<template>
  <div>
    <EditSkill v-show="isShow"></EditSkill>
    <SkillTab></SkillTab>
  </div>
</template>

<script>
import EditSkill from "../../components/EditBtn/EditSkill.vue";
import SkillTab from "../../components/Edit/SkillTab.vue";
export default {
  name: "Skill",
  components: { EditSkill, SkillTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('skillList/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showSkill', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('skillList/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showSkill', response.data)
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
