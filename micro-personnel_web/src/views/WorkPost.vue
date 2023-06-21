<template>
  <div>
    <WorkPostBtn></WorkPostBtn>
    <WorkPostInfo></WorkPostInfo>
  </div>
</template>

<script>
const WorkPostInfo = () => import('components/WorkPost/WorkPostInfo')
const WorkPostBtn = () => import('components/WorkPost/WorkPostBtn')
export default {
  data() {
    return {

    }
  },
  components: {
    WorkPostInfo,
    WorkPostBtn
  },
  mounted() {
    const userid = this.$store.state.user.userId
    this.axios.get('salary/get', {
    })
      .then((response) => {
        let { data, status } = response
        this.$bus.$emit('showSalary', data)
      })
      .catch(function (error) {
        console.log(error);
      })

  },
}
</script>

<style>
</style>