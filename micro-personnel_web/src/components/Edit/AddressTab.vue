<template>
  <div class="paper-tab">
    <el-table id="elTab" :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" border style="width: 80%" v-loading="loading" element-loading-text="拼命加载中" element-loading-spinner="el-icon-loading" element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column prop="name" label="姓名" width="100"> </el-table-column>
      <el-table-column prop="alias" label="别名" width="100"> </el-table-column>
      <el-table-column prop="details" label="详情" width="180"></el-table-column>
      <el-table-column prop="zipCode" label="邮编" width="180"> </el-table-column>
      <el-table-column prop="updateTime" label="日期" width="180"> </el-table-column>
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
        <el-form-item label="名字" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="别名" :label-width="formLabelWidth">
          <el-input v-model="form.alias" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="详情" :label-width="formLabelWidth">
          <el-input v-model="form.details" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮编" :label-width="formLabelWidth">
          <el-input v-model="form.zipCode" autocomplete="off"></el-input>
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
        id: "",
        name: "",
        alias: "",
        details: "",
        zipCode: "",
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
      this.form.alias = row.alias
      this.form.details = row.details
      this.form.zipCode = row.zipCode
    },
    subMit() {
      this.axios.put('address/update', this.form, {
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
      let url = 'address/delete/' + id
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
      this.$bus.$on("showAddress", (data) => {
        this.tableData.push(data)
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchAdd', (data) => {
        console.log(data);
        this.tableData.push(data)
        this.totalSize = data.length
      })
    }
    else {
      this.$bus.$on("showAddress", (data) => {
        this.tableData = data
        this.totalSize = data.length
        this.loading = false
      });
      this.$bus.$on('searchAdd', (data) => {
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
