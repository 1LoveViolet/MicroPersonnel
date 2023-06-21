<template>
  <div>
    <EditPaper v-show="isShow"></EditPaper>
    <PaperTab></PaperTab>
  </div>
</template>

<script>
import EditPaper from "../../components/EditBtn/EditPaper.vue";
import PaperTab from "../../components/Edit/PaperTab.vue";
export default {
  name: "Paper",
  components: { EditPaper, PaperTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('certificate/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showPaper', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('certificate/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showPaper', response.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
  },
}
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
