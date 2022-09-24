<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程id" prop="courseId">
        <el-input
          v-model="queryParams.courseId"
          placeholder="请输入课程id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名称" prop="courseName">
        <el-input
          v-model="queryParams.courseName"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课时名称;微型计算机概述" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入课时名称;微型计算机概述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课时时长;45分钟" prop="duration">
        <el-input
          v-model="queryParams.duration"
          placeholder="请输入课时时长;45分钟"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="时间安排;2022-9-1 9:00:00" prop="schedule">
        <el-date-picker clearable
          v-model="queryParams.schedule"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择时间安排;2022-9-1 9:00:00">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="课时顺序;1" prop="order">
        <el-input
          v-model="queryParams.order"
          placeholder="请输入课时顺序;1"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课时重要等级;课时重要程度1-5" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入课时重要等级;课时重要程度1-5"
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
          v-hasPermi="['system:period:add']"
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
          v-hasPermi="['system:period:edit']"
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
          v-hasPermi="['system:period:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:period:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="periodList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="课程id" align="center" prop="courseId" />
      <el-table-column label="课程名称" align="center" prop="courseName" />
      <el-table-column label="课时名称;微型计算机概述" align="center" prop="name" />
      <el-table-column label="课时时长;45分钟" align="center" prop="duration" />
      <el-table-column label="时间安排;2022-9-1 9:00:00" align="center" prop="schedule" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.schedule, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="课时顺序;1" align="center" prop="order" />
      <el-table-column label="课时重要等级;课时重要程度1-5" align="center" prop="level" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:period:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:period:remove']"
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

    <!-- 添加或修改课程章节对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程id" prop="courseId">
          <el-input v-model="form.courseId" placeholder="请输入课程id" />
        </el-form-item>
        <el-form-item label="课程名称" prop="courseName">
          <el-input v-model="form.courseName" placeholder="请输入课程名称" />
        </el-form-item>
        <el-form-item label="课时名称;微型计算机概述" prop="name">
          <el-input v-model="form.name" placeholder="请输入课时名称;微型计算机概述" />
        </el-form-item>
        <el-form-item label="课时时长;45分钟" prop="duration">
          <el-input v-model="form.duration" placeholder="请输入课时时长;45分钟" />
        </el-form-item>
        <el-form-item label="时间安排;2022-9-1 9:00:00" prop="schedule">
          <el-date-picker clearable
            v-model="form.schedule"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择时间安排;2022-9-1 9:00:00">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="课时顺序;1" prop="order">
          <el-input v-model="form.order" placeholder="请输入课时顺序;1" />
        </el-form-item>
        <el-form-item label="课时重要等级;课时重要程度1-5" prop="level">
          <el-input v-model="form.level" placeholder="请输入课时重要等级;课时重要程度1-5" />
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
import { listPeriod, getPeriod, delPeriod, addPeriod, updatePeriod } from "@/api/exam/period";

export default {
  name: "Period",
  data() {
    return {
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
      // 课程章节表格数据
      periodList: [],
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
        name: null,
        duration: null,
        schedule: null,
        order: null,
        level: null,
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
  },
  methods: {
    /** 查询课程章节列表 */
    getList() {
      this.loading = true;
      listPeriod(this.queryParams).then(response => {
        this.periodList = response.rows;
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
        courseId: null,
        courseName: null,
        name: null,
        duration: null,
        schedule: null,
        order: null,
        level: null,
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
      this.title = "添加课程章节";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPeriod(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程章节";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePeriod(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPeriod(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除课程章节编号为"' + ids + '"的数据项？').then(function() {
        return delPeriod(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/period/export', {
        ...this.queryParams
      }, `period_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
