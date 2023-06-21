<template>
  <div class="content">
    <el-descriptions title="用户信息" v-bind="BasicInfo">
      <el-descriptions-item label="姓名">{{ BasicInfo[0].name }} </el-descriptions-item>
      <el-descriptions-item label="性别">{{ BasicInfo[0].gender }} </el-descriptions-item>
      <el-descriptions-item label="生日">{{ BasicInfo[0].birthday }}</el-descriptions-item>
      <el-descriptions-item label="身高">{{ BasicInfo[0].height }} CM</el-descriptions-item>
      <el-descriptions-item label="体重">{{ BasicInfo[0].weight }} KG</el-descriptions-item>
      <el-descriptions-item label="居住地">{{ BasicInfo[0].nativePlace }}</el-descriptions-item>
      <el-descriptions-item label="籍贯">{{ BasicInfo[0].nationality }}</el-descriptions-item>
      <el-descriptions-item label="毕业院校">{{ BasicInfo[0].graduateSchool }}</el-descriptions-item>
    </el-descriptions>
    <el-divider></el-divider>
    <div>
      <h1>证件列表</h1>
      <el-table :data="certificateData" style="width: 93%" :show-header="false" class="customer-no-border-table">
        <el-table-column prop="name" width="180">
        </el-table-column>
        <el-table-column prop="type" width="180">
        </el-table-column>
        <el-table-column prop="number">
        </el-table-column>
        <el-table-column prop="issDate">
        </el-table-column>
        <el-table-column prop="validityPeriod">
        </el-table-column>
      </el-table>
    </div>
    <!-- <el-divider></el-divider> -->

    <div>
      <h1>地址列表</h1>
      <el-table :data="addressData" style="width: 93%" :show-header="false">
        <el-table-column prop="name" width="180">
        </el-table-column>
        <el-table-column prop="details" width="180">
        </el-table-column>
        <el-table-column prop="zipCode">
        </el-table-column>
      </el-table>
    </div>

    <div>
      <h1>联系方式</h1>
      <el-table :data="contactData" style="width: 93%" :show-header="false">
        <el-table-column prop="type" width="180">
        </el-table-column>
        <el-table-column prop="content" width="180">
        </el-table-column>
      </el-table>
    </div>

    <div>
      <h1>教育经历</h1>
      <el-table :data="eduinfoData" style="width: 93%" :show-header="false">
        <el-table-column prop="school" width="180">
        </el-table-column>
        <el-table-column prop="profession" width="180">
        </el-table-column>
        <el-table-column prop="startDate">
        </el-table-column>
        <el-table-column prop="endDate">
        </el-table-column>
      </el-table>
    </div>

    <div>
      <h1>技能列表</h1>
      <el-table :data="skillListData" style="width: 93%" :show-header="false">
        <el-table-column prop="skillName" width="180">
        </el-table-column>
        <el-table-column prop="useDate" width="180">
        </el-table-column>

      </el-table>
    </div>

    <div>
      <h1>工作经历</h1>
      <el-table :data="workData" style="width: 93%" :show-header="false">
        <el-table-column prop="firm" width="180">
        </el-table-column>
        <el-table-column prop="post" width="180">
        </el-table-column>
        <el-table-column prop="startDate">
        </el-table-column>
        <el-table-column prop="endDate">
        </el-table-column>

      </el-table>
    </div>

    <div>
      <h1>项目经历</h1>
      <el-table :data="proexpData" style="width: 93%" :show-header="false">
        <el-table-column prop="projectName" width="180">
        </el-table-column>
        <el-table-column prop="duty" width="180">
        </el-table-column>
        <el-table-column prop="startDate">
        </el-table-column>
        <el-table-column prop="endDate">
        </el-table-column>
      </el-table>
    </div>

  </div>
</template>
<script>
export default {
  name: "PersonInfo",
  data() {
    return {
      BasicInfo:
        [],
      eduinfoData: [],
      addressData: [],
      certificateData: [],
      contactData: [],
      workData: [],
      proexpData: [],
      skillListData: [],
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    this.axios.get('eduinfo/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.eduinfoData = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('address/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.addressData = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('basicInformation/get', {
    })
      .then((response) => {
        let { data, status } = response
        this.BasicInfo = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('certificate/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.certificateData = response.data.data
        console.log('this.certificateData' + this.certificateData);
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('contact/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.contactData = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('workexp/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.workData = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('proexp/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.proexpData = data
      })
      .catch(function (error) {
        console.log(error);
      })

    this.axios.get('skillList/get/' + userid, {
    })
      .then((response) => {
        let { data, status } = response
        this.skillListData = data
      })
      .catch(function (error) {
        console.log(error);
      })
  },
};
</script>
<style scoped>
.el-table td.el-table__cell,
.el-table th.el-table__cell.is-leaf {
  border-bottom: 0px;
}

.el-descriptions,
h1,
.el-table {
  margin-left: 40px;
}

.my-label {
  background: #e1f3d8;
}

.my-content {
  background: #fde2e2;
}

.el-table {
  border: 0px;
}
</style>