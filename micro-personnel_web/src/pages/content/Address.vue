<template>
  <div>
    <EditAddress v-show="isShow"></EditAddress>
    <AddressTab></AddressTab>
  </div>
</template>

<script>
import EditAddress from "components/EditBtn/EditAddress.vue";
import AddressTab from "components/Edit/AddressTab.vue";
export default {
  name: "Address",
  components: { EditAddress, AddressTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('address/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showAddress', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('address/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showAddress', response.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }

  },
  methods: {
  }
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
