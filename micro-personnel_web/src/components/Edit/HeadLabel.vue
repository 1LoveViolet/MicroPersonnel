<template>
  <div>
    <router-link to="/edit/basic" class="hederlabel" active-class="active" v-if="isShow">基本资料</router-link>
    <router-link to="/edit/paper" class="hederlabel" active-class="active">证件管理</router-link>
    <router-link to="/edit/address" class="hederlabel" active-class="active">地址管理</router-link>
    <router-link to="/edit/contact" class="hederlabel" active-class="active">联系方式</router-link>
    <router-link to="/edit/education" class="hederlabel" active-class="active">教育经历</router-link>
    <router-link to="/edit/skill" class="hederlabel" active-class="active">技能列表</router-link>
    <router-link to="/edit/workExp" class="hederlabel" active-class="active">工作经历</router-link>
    <router-link to="/edit/projectExp" class="hederlabel" active-class="active">项目经历</router-link>
    <router-link to="/edit/salary" class="hederlabel" active-class="active" v-if="isShow">员工工资</router-link>
  </div>
</template>

<script>
export default {
  name: "HeadLabel",
  data() {
    return {
      isShow: false
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = true
    }
  }
};
</script>

<style scoped>
.hederlabel {
  text-decoration: none;
  color: black;
  font-size: small;
  margin-left: 30px;
}

.active {
  padding: 6px;
  border-bottom: solid skyblue 2px;
  color: skyblue;
}
</style>
