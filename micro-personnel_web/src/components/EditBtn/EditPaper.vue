<template>
  <div class="edit-tag">
    <el-button type="primary" icon="el-icon-edit" @click="dialogFormVisible = true">新增</el-button>
    <el-input class="search" v-model="input" placeholder="查询" @keyup.enter.native="handleSearch"></el-input>
    <el-button id="delete" type="" icon="el-icon-close" circle @click="reSearch"></el-button>

    <el-dialog title="编辑证件" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="证件类型" :label-width="formLabelWidth">
          <el-select v-model="form.type" placeholder="请选择">
            <el-option label="身份证" value="shenfen"></el-option>
            <el-option label="学生证" value="xuesheng"></el-option>
            <el-option label="结婚证" value="jiehun"></el-option>
            <el-option label="毕业证" value="biye"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="编号" :label-width="formLabelWidth">
          <el-input v-model="form.number" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="签发日期" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker v-model="form.issDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="有效期" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker v-model="form.validityPeriod" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
            </el-date-picker>
          </div>
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
export default {
  name: "EditPaper",
  inject: ['reload'],
  data() {
    return {
      dialogFormVisible: false,
      input: '',
      form: {
        name: '',
        type: '',
        number: "",
        issDate: "",
        validityPeriod: "",
        updateTime: '',
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    submitEd() {
      let data = this.form
      this.axios.post('certificate/insert', data, {
        headers: {
          "Content-Type": "application/json"
        },
      })
        .then((response) => {

        })
        .catch(function (error) {
          console.log(error);
        })
      this.reload()
      this.dialogFormVisible = false
    },
    handleSearch() {
      this.axios.get('certificate/mocha/' + this.input, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('searchPaper', data)
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
