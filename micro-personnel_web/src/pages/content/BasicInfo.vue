<template>
  <div>
    <el-form ref="form" :model="model" label-width="80px" :inline="true">
      <el-form-item label="姓名">
        <el-input v-model="model.name" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="model.gender" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-date-picker v-model="model.birthday" type="date" placeholder="选择日期时间" value-format="yyyy-MM-dd" style="width: 200px"></el-date-picker>
      </el-form-item>
      <el-form-item label="身高">
        <el-input v-model="model.height" style="width: 200px">
          <i slot="suffix" style="font-style: normal; margin-right: 10px">CM</i>
        </el-input>
      </el-form-item>
      <el-form-item label="体重">
        <el-input v-model="model.weight" style="width: 200px">
          <i slot="suffix" style="font-style: normal; margin-right: 10px">KG</i>
        </el-input>
      </el-form-item>
      <el-form-item label="籍贯">
        <el-input v-model="model.nationality" style="width: 200px"></el-input>
      </el-form-item>

    </el-form>
    <el-divider></el-divider>
    <el-form ref="form" :model="model" label-width="80px" :inline="true">
      <el-form-item label="毕业院校">
        <el-input v-model="model.graduateSchool" style="width: 200px"></el-input>
      </el-form-item>
    </el-form>

    <el-divider></el-divider>
    <el-form ref="form" label-width="80px">
      <el-form-item>
        <el-button @click="updateModel" type="primary">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "BasicInfo",
  data: function () {
    return {
      model: {
        id: '',
        birthday: '',
        gender: '',
        graduateSchool: '',
        height: '',
        name: '',
        nationality: '',
        nativePlace: '',
        weight: '',
        headPicture: '',
        selfEvaluation: '',
      },
      BasicInfo: [],

    };
  },
  methods: {
    updateModel() {
      this.axios.put('basicInformation/update', this.model, {
        headers: {
          "Content-Type": "application/json"
        },
      })
        .then((response) => {

        })
        .catch(function (error) {
          console.log(error);
        })
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    this.axios.get('basicInformation/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.BasicInfo.push(response.data.data)
        this.model.birthday = this.BasicInfo[0].birthday
        this.model.gender = this.BasicInfo[0].gender
        this.model.graduateSchool = this.BasicInfo[0].graduateSchool
        this.model.height = this.BasicInfo[0].height
        this.model.name = this.BasicInfo[0].name
        this.model.nationality = this.BasicInfo[0].nationality
        this.model.weight = this.BasicInfo[0].weight
        this.model.id = this.BasicInfo[0].id

      })
      .catch(function (error) {
        console.log(error);
      })
  },
};
</script>

<style>
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
