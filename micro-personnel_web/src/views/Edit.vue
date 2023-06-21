<template>
  <div>
    <HeadLabel class="headTag"></HeadLabel>
    <el-divider></el-divider>
    <router-view></router-view>
  </div>
</template>

<script>
import HeadLabel from "components/Edit/HeadLabel.vue";

export default {
  name: "Edit",
  components: { HeadLabel },
  mounted() {
    this.axios.get('eduinfo/get', {
    })
      .then((response) => {
        let { data, status } = response
        this.$bus.$emit('showEd', data)
      })
      .catch(function (error) {
        console.log(error);
      })
  },
};
</script>

<style scoped>
.headTag {
  margin-left: 100px;
  line-height: 60px;
}

.el-divider--horizontal {
  margin-top: 0px;
  margin-bottom: 20px;
}
</style>
