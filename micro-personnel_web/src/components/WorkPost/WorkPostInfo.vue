<template>
  <div class="paper-tab">
    <el-table id="elTab" :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" border style="width: 100%" v-loading="loading" element-loading-text="拼命加载中" element-loading-spinner="el-icon-loading" element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <el-table-column prop="department" label="岗位"> </el-table-column>

      <el-table-column prop="operation" label="操作" width="138">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="handlEdit(scope.$index, scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handlDelet(scope.row.id)"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <div id="block">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[4, 6, 8]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
      </el-pagination>
    </div>

  </div>
</template>
<script>
export default {
  name: "AddressTab",
  inject: ['reload'],
  data() {
    return {
      loading: false,
      dialogFormVisible: false,
      formLabelWidth: "120px",
      form: {
        name: null,
        department: null,

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
      this.form.name = row.name
      this.form.department = row.department

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

    this.$bus.$on("showSalary", (data) => {
      console.log(data)
      this.tableData = data
      this.totalSize = data.length
      this.loading = false
    });
    this.$bus.$on('searchSalary', (data) => {
      console.log(data);
      this.tableData = data
      this.totalSize = data.length
    })

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
