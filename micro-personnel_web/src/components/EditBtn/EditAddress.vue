<template>
  <div class="edit-tag">
    <el-button type="primary" icon="el-icon-edit" @click="dialogFormVisible = true">新增</el-button>
    <el-input class="search" v-model="input" placeholder="查询" @keyup.enter.native="handleSearch"></el-input>
    <el-button id="delete" type="" icon="el-icon-close" circle @click="reSearch"></el-button>

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
        <el-button type="primary" @click="submitEd" id="btn">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addAddress } from 'network/edit'
export default {
  name: "EditAddress",
  inject: ['reload'],
  data() {
    return {
      dialogFormVisible: false,
      input: '',
      form: {
        name: "",
        alias: "",
        details: "",
        zipCode: "",
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    submitEd() {
      let data = this.form
      addAddress(data)
        .then((response) => {
          console.log('添加address')
        })
        .catch(function (error) {
          console.log(error);
        })
      this.reload()
      this.dialogFormVisible = false
    },
    handleSearch() {
      this.axios.get('address/mocha/' + this.input, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('searchAdd', data)
        })
        .catch(function (error) {
          console.log(error);
        })
    },
    reSearch() {
      this.reload()
    }
  }
};
</script>

<style scoped>
.el-button {
  margin-left: 120px;
}

#btn {
  margin-left: 10px;
}

.search {
  margin-left: 600px;
}

#delete {
  margin-left: 0;
  margin-right: 20px;
}

.dialog-footer {
  display: flex;
  justify-content: center;
}

.el-input {
  width: 200px;
  margin-right: 50px;
}

.edit-tag {
  display: flex;
  justify-content: space-between;
  width: 100%;
  height: 40px;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
