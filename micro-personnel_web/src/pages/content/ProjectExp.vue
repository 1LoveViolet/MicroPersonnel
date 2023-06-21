<template>
  <div>
    <EditProjectExp v-show="isShow"></EditProjectExp>
    <ProjectExpTab></ProjectExpTab>
  </div>
</template>

<script>
import EditProjectExp from "../../components/EditBtn/EditProjectExp.vue";
import ProjectExpTab from "../../components/Edit/ProjectExpTab.vue";
export default {
  name: "ProjectExp",
  components: { EditProjectExp, ProjectExpTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('proexp/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showProexp', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('proexp/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showProexp', response.data)
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
