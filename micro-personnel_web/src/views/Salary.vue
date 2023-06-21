<template>
  <div>
    <SalaryBtn v-show="isShow"></SalaryBtn>
    <SalaryInfo></SalaryInfo>
  </div>
</template>

<script>
const SalaryInfo = () => import('components/Salary/SalaryInfo')
const SalaryBtn = () => import('components/Salary/SalaryBtn')
export default {
  data() {
    return {
      isShow: true,
    }
  },
  components: {
    SalaryInfo,
    SalaryBtn
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('salary/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showSalary', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('salary/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showSalary', response.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }

  },
}
</script>

<style>
</style>