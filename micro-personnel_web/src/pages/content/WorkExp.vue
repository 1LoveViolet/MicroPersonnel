<template>
  <div>
    <EditWorkExp v-show="isShow"></EditWorkExp>
    <WorkExpTab></WorkExpTab>
  </div>
</template>

<script>
import EditWorkExp from "../../components/EditBtn/EditWorkExp.vue";
import WorkExpTab from "../../components/Edit/WorkExpTab.vue";
export default {
  name: "WorkExp",
  components: { EditWorkExp, WorkExpTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('workexp/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showWorkexp', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('workexp/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showWorkexp', response.data)
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
