<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程名称" prop="courseName">
        <el-select v-model="form.courseName" placeholder="请选择课程" clearable >
          <el-option
              v-for="item in selectCourseOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="题目分数" prop="score">
        <el-input
          v-model="queryParams.score"
          placeholder="请输入题目分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="难度等级" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入难度等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="题目热度" prop="count">
        <el-input
          v-model="queryParams.count"
          placeholder="请输入题目被引用次数"
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
          v-hasPermi="['exam:question:add']"
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
          v-hasPermi="['exam:question:edit']"
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
          v-hasPermi="['exam:question:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['exam:question:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="questionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="试题编号" align="center" prop="questionId" />
      <el-table-column label="课程名称" align="center"  width="180" prop="courseName" />
      <el-table-column label="题目" align="center" width="250" prop="title">
        <template slot-scope="scope">
          <el-input
              type="textarea"
              :rows="2"
              v-model="scope.row.title">
          </el-input>
        </template>
      </el-table-column>
      <el-table-column label="正确答案" align="center" width="100" prop="rightAnswer" />
      <el-table-column label="题目解析" align="center" width="120" prop="analysis" />
      <el-table-column label="题目分数" align="center" prop="score">
        <template slot-scope="scope">
          <el-tag type="success">{{ scope.row.score }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="难度等级" align="center" prop="level">
        <template slot-scope="scope">
          <el-tag type="danger">{{scope.row.level}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="被用次数" align="center" prop="count">
        <template slot-scope="scope">
          <el-tag type="warning">{{scope.row.count}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['exam:question:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['exam:question:remove']"
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

    <!-- 添加或修改题库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form-item label="选择课程" prop="rightAnswer">
        <el-select v-model="form.courseName" placeholder="请选择课程">
          <el-option
              v-for="item in selectCourseOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="课程名称" prop="courseName">
          <el-select v-model="form.courseName" placeholder="请选择课程">
            <el-option
                v-for="item in selectCourseOptions"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="题目" prop="title">
          <el-input
              type="textarea"
              :rows="3"
              placeholder="请输入内容"
              v-model="form.title">
          </el-input>
        </el-form-item>
        <el-form-item label="正确答案" prop="rightAnswer">
          <el-input v-model="form.rightAnswer" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="题目解析" prop="analysis">
          <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入内容"
              v-model="form.analysis">
          </el-input>
        </el-form-item>
        <el-form-item label="题目分数" prop="score">
          <el-input-number v-model="form.score" :min="1" :max="100" label="请输入题目分数" size="mini"></el-input-number>
        </el-form-item>
        <el-form-item label="难度等级" prop="level">
          <el-input-number v-model="form.level" :min="1" :max="5" label="请输入难度等级" size="mini"></el-input-number>
        </el-form-item>
        <el-form-item label="题目被引用次数" prop="count">
          <el-input-number v-model="form.count" :min="0" controls-position="right" label="请输入题目被引用次数" size="mini"></el-input-number>
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
import {listQuestion, getQuestion, delQuestion, addQuestion, updateQuestion, listCourse} from "@/api/exam/question";

export default {
  name: "Question",
  data() {
    return {
      selectCourseOptions:[],
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
      // 题库表格数据
      questionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        courseName: null,
        title: null,
        rightAnswer: null,
        analysis: null,
        score: null,
        level: null,
        count: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();

    this.initCourseList();
  },
  methods: {
    /*课程*/
    initCourseList(){
      listCourse().then(res =>{
        console.log(res);
        this.selectCourseOptions = res.rows
      })
    },
    /** 查询题库列表 */
    getList() {
      this.loading = true;
      listQuestion(this.queryParams).then(response => {
        console.log(response.rows);
        this.questionList = response.rows;
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
        questionId: null,
        courseId: null,
        courseName: null,
        title: null,
        rightAnswer: null,
        analysis: null,
        score: null,
        level: null,
        count: null,
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
      this.ids = selection.map(item => item.questionId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.initCourseList();
      this.title = "添加题库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const questionId = row.questionId || this.ids
      getQuestion(questionId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改题库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.questionId != null) {
            updateQuestion(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addQuestion(this.form).then(response => {
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
      const questionIds = row.questionId || this.ids;
      this.$modal.confirm('是否确认删除题库编号为"' + questionIds + '"的数据项？').then(function() {
        return delQuestion(questionIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('exam/question/export', {
        ...this.queryParams
      }, `question_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
