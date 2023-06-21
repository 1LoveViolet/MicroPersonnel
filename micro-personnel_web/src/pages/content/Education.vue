<template>
  <div>
    <EditEducation v-show="isShow"></EditEducation>
    <EducationTab></EducationTab>
  </div>
</template>

<script>
import EditEducation from "../../components/EditBtn/EditEducation.vue";
import EducationTab from "../../components/Edit/EducationTab.vue";
export default {
  name: "Education",
  components: { EditEducation, EducationTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('eduinfo/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showEducation', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('eduinfo/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showEducation', response.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
  },
};
</script>

<style scoped>
.el-button {
  margin-left: 120px;
}

.edit-tag {
  height: 40px;
}

.block {
  margin-left: 370px;
  margin-top: 150px;
}
</style>
