<template>
  <div>
    <EditContact v-show="isShow"></EditContact>
    <ContactTab></ContactTab>
  </div>
</template>

<script>
import EditContact from "../../components/EditBtn/EditContact.vue";
import ContactTab from "../../components/Edit/ContactTab.vue";
export default {
  name: "Contact",
  components: { EditContact, ContactTab },
  data() {
    return {
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
      this.axios.get('contact/get/' + userid, {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showContact', response.data.data)
        })
        .catch(function (error) {
          console.log(error);
        })
    }
    else {
      this.axios.get('contact/get', {
      })
        .then((response) => {
          let { data, status } = response
          this.$bus.$emit('showContact', response.data)
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
