<template>
  <div>
    <PersonInfo></PersonInfo>
  </div>
</template>

<script>
import PersonInfo from "pages/content/PersonInfo.vue";
export default {
  name: "Person",
  components: {
    PersonInfo,
  }

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

