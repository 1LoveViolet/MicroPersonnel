<template>
  <div class="paper-tab">
    <el-table :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" border style="width: 80%" id="elTab" v-loading="loading" element-loading-text="拼命加载中" element-loading-spinner="el-icon-loading" element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column prop="school" label="学校" width="180"></el-table-column>
      <el-table-column prop="profession" label="专业" width="180"> </el-table-column>
      <el-table-column prop="startDate" label="起始日期" width="180"></el-table-column>
      <el-table-column prop="endDate" label="结束日期" width="180"></el-table-column>
      <el-table-column prop="operation" label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="handlEdit(scope.$index, scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handlDelet(scope.row.id)" v-show="isShow"></el-button>
        </template>

      </el-table-column>
    </el-table>
    <div id="block">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[4, 6, 8]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
      </el-pagination>
    </div>
    <el-dialog title="教育经历" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="学校" :label-width="formLabelWidth">
          <el-input v-model="form.school" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="专业" :label-width="formLabelWidth">
          <el-input v-model="form.profession" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="起始日期" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker v-model="form.startDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="结束日期" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker v-model="form.endDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false" id="btn">取 消</el-button>
        <el-button type="primary" @click="subMit" id="btn">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "EducationTab",
  inject: ['reload'],
  data() {
    return {
      loading: false,
      isShow: true,
      dialogFormVisible: false,
      formLabelWidth: "120px",
      form: {
        id: "",
        school: "",
        profession: "",
        startDate: "",
        endDate: ""
      },
      currentPage: 1,
      pageSize: 4,
      totalSize: 4,
      tableData: [

      ],
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentPage = val;
    },
    handleSizeChange(val) {
      this.pageSize = val;
    },
    handlEdit(index, row) {
      this.dialogFormVisible = true
      this.form.id = row.id
      this.form.school = row.school
      this.form.profession = row.profession
      this.form.startDate = row.startDate
      this.form.endDate = row.endDate
    },
    subMit() {
      this.axios.put('eduinfo/update', this.form, {
        headers: {
          "Content-Type": "application/json"
        },
      })
        .then((response) => {

        })
        .catch(function (error) {
          console.log(error);
        })

      this.dialogFormVisible = false
      this.reload()
    },
    handlDelet(id) {
      let url = 'eduinfo/delete/' + id
      this.$confirm('删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.axios.delete(url, {
          headers: {
            "Content-Type": "application/json"
          }
        })
          .then((response) => {

          })
          .catch(function (error) {
            console.log(error);
          })
        this.reload()
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
  },

  mounted() {
    this.loading = true
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.$bus.$on("showEducation", (data) => {
        this.tableData.push(data)
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchEducation', (data) => {
        console.log(data);
        this.tableData.push(data)
        this.totalSize = data.length
      })
    }
    else {
      this.$bus.$on("showEducation", (data) => {
        this.tableData = data
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchEducation', (data) => {
        console.log(data);
        this.tableData = data
        this.totalSize = data.length
      })
    }
  },
};
</script>

<style scoped>
#elTab {
  margin-top: 40px;
  margin-left: 120px;
  width: 800px;
}

#block {
  margin-left: 320px;
  margin-top: 150px;
}
</style>
