<template>
  <div class="paper-tab">
    <el-table id="elTab" :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" border style="width: 100%" v-loading="loading" element-loading-text="拼命加载中" element-loading-spinner="el-icon-loading" element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <el-table-column prop="basicSalary" label="基本工资"> </el-table-column>
      <el-table-column prop="department" label="岗位"> </el-table-column>
      <el-table-column prop="fullAttendancePay" label="全勤工资"> </el-table-column>
      <el-table-column prop="lateDeduction" label="迟到扣款"> </el-table-column>
      <el-table-column prop="leaveDeduction" label="请假扣款"> </el-table-column>
      <el-table-column prop="performanceBonus" label="绩效奖金"></el-table-column>

      <el-table-column prop="operation" label="操作" width="138">
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
    <el-dialog title="地址管理" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="基本工资" :label-width="formLabelWidth">
          <el-input v-model="form.basicSalary" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="岗位" :label-width="formLabelWidth">
          <el-input v-model="form.department" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="全勤工资" :label-width="formLabelWidth">
          <el-input v-model="form.fullAttendancePay" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="迟到扣款" :label-width="formLabelWidth">
          <el-input v-model="form.lateDeduction" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="请假扣款" :label-width="formLabelWidth">
          <el-input v-model="form.leaveDeduction" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="绩效奖金" :label-width="formLabelWidth">
          <el-input v-model="form.performanceBonus" autocomplete="off"></el-input>
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
  name: "AddressTab",
  inject: ['reload'],
  data() {
    return {
      loading: false,
      isShow: true,
      dialogFormVisible: false,
      formLabelWidth: "120px",
      form: {
        id: null,
        name: null,
        department: null,
        basicSalary: null,
        fullAttendance_pay: null,
        lateDeduction: null,
        leaveDeduction: null,
        performanceBonus: null,
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
      this.form.name = row.name
      this.form.department = row.department
      this.form.basicSalary = row.basicSalary
      this.form.fullAttendancePay = row.fullAttendancePay
      this.form.lateDeduction = row.lateDeduction
      this.form.leaveDeduction = row.leaveDeduction
      this.form.performanceBonus = row.performanceBonus
    },
    subMit() {
      this.axios.put('salary/update', this.form, {
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
      let url = 'salary/delete/' + id
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
      this.$bus.$on("showSalary", (data) => {
        this.tableData.push(data)
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchSalary', (data) => {
        console.log(data);
        this.tableData.push(data)
        this.totalSize = data.length
      })
    }
    else {
      this.$bus.$on("showSalary", (data) => {
        this.tableData = data
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchSalary', (data) => {
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

  width: 800px;
}

#block {
  margin-left: 320px;
  margin-top: 150px;
}
</style>
