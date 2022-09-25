<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="学院名称" prop="instituteName">
        <el-select v-model="queryParams.instituteId" clearable  placeholder="请选择" @change="curCollegeChange">
          <el-option
              v-for="item in collegeOptions"
              :key="item.deptId"
              :label="item.deptName"
              :value="item.deptId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="专业名称" prop="majorName">
        <el-select v-model="queryParams.majorId" clearable  placeholder="请选择">
          <el-option
              v-for="item in subjectOptions"
              :key="item.deptId"
              :label="item.deptName"
              :value="item.deptId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="教师名称" prop="teacherName">
        <el-input
            v-model="queryParams.teacherName"
            placeholder="请输入教师名称"
            clearable
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:course:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:course:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="课程名称" align="center" prop="name" />
      <el-table-column label="学院名称" align="center" prop="instituteName" />
      <el-table-column label="专业名称" align="center" prop="majorName" />
      <el-table-column label="教师名称" align="center" prop="teacherName" />
      <el-table-column label="配套教材" align="center" prop="courseBook" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:course:edit']"
          >修改</el-button>

          <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleCoursePeriod(scope.row)"
              v-hasPermi="['system:course:edit']"
          >分配课时</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:course:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入课程名称" />
        </el-form-item>

        <el-form-item label="学院&专业" prop="instituteName">
          <el-cascader
              v-model="paths"
              :props="cascaderProps"
              :options="addFormCascaderOptions"
              @change="handleCascaderChange"></el-cascader>
        </el-form-item>

        <el-form-item label="教师名称" prop="teacherName">
          <el-input v-model="form.teacherName" placeholder="请输入教师名称" />
        </el-form-item>
        <el-form-item label="配套教材" prop="courseBook">
          <el-input v-model="form.courseBook" placeholder="请输入配套教材" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCourse, getCourse, delCourse, addCourse, updateCourse,getCollegeList ,getSubjectByDeptId,getDeptTreeList} from "@/api/exam/course";
import {listTeacher} from "@/api/system/user";

export default {
  name: "Course",
  data() {
    return {
      //级联选择框属性
      cascaderProps: {
        value: "id",
        label: "label",
        children: "children"
      },
      addFormCascaderOptions:[],
      paths:[],
      collegeOptions:[],
      subjectOptions:[],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        instituteId: null,
        majorId: null,
        teacherName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
    };
  },
  created() {
    this.getList();

    this.getCollegeList();
  },
  methods: {
    handleCascaderChange(){

    },
    curCollegeChange(){
      getSubjectByDeptId(this.queryParams.instituteId).then(res =>{
        this.subjectOptions = res.data
      })
    },
    /*分配课时*/
    handleCoursePeriod(row){

    },
    /*查询所有学院*/
    getCollegeList(){
      getCollegeList().then(res =>{
        console.log(res);
        this.collegeOptions = res.data;
      })
    },
    /*查询所有学院及其对应的专业*/
    getAllCollege2Subject(){

    },
    /** 查询课程列表 */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        instituteId: null,
        instituteName: null,
        majorId: null,
        majorName: null,
        teacherId: null,
        teacherName: null,
        courseBook: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程";

      //请求学院-专业
      getDeptTreeList().then(res =>{
        //console.log(res);
        this.addFormCascaderOptions = res.data[1].children
      })

      //学院 -> 请求 老师
      if(this.paths[0] != undefined && this.paths[0] != "" && this.paths[0] != null){
        let queryParams = {

        }
        listTeacher(this.addDateRange(queryParams)).then(res =>{
          console.log(res);
        })
      }

    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCourse(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除课程编号为"' + ids + '"的数据项？').then(function() {
        return delCourse(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
