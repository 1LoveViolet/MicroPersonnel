<template>
  <el-container>
    <div id="user">
      <el-avatar :size="60">
        <el-button @click="show3 = !show3">{{ $store.state.user.userName }}</el-button>
      </el-avatar>
      <div id="user-content">
        <el-collapse-transition>
          <div v-show="show3">
            <div class="transition-box">{{ $store.state.user.userName }}</div>
            <div class="transition-box">
              <el-button type="danger" icon="el-icon-delete" round @click="loginout">退出</el-button>
            </div>
          </div>
        </el-collapse-transition>
      </div>
    </div>

    <el-header id="header">
      <el-menu class="el-menu-demo" mode="horizontal"><!--:default-active="activeIndex"   @select="handleSelect"-->
        <el-submenu index="1">
          <template slot="title">员工信息</template>
          <el-menu-item index="1-1">
            <router-link to="/home/edit" class="hedera" active-class="active">编辑档案</router-link>
          </el-menu-item>
          <el-menu-item index="1-2">
            <router-link to="/home/person" class="hedera" active-class="active" v-if="!isShow">个人档案</router-link>
          </el-menu-item>
        </el-submenu>
        <el-submenu index="2" v-show="isShow">
          <template slot="title">工资管理</template>
          <el-menu-item index="2-1">
            <router-link to="/home/salary" class="hedera" active-class="active">员工工资</router-link>
          </el-menu-item>
        </el-submenu>
        <el-submenu index="3" v-show="isShow">
          <template slot="title">岗位管理</template>
          <el-menu-item index="3-1">
            <router-link to="/home/workpost" class="hedera" active-class="active">岗位情况</router-link>
          </el-menu-item>
        </el-submenu>
      </el-menu>
      <router-link to="/home/edit" class="hedera">编辑档案</router-link>
      <router-link to="/home/person" class="hedera">个人档案</router-link>

    </el-header>

    <el-main>
      <div class="content">
        <router-view v-if="isRouterAlive"></router-view>
      </div>
    </el-main>
  </el-container>
</template>

<script scoped>
export default {
  name: "Home",
  provide() { // 父组件中返回要传给下级的数据
    return {
      reload: this.reload,

    }
  },
  data() {
    return {
      show3: false,
      isRouterAlive: true,
      isShow: true,
    }
  },
  mounted() {
    const userid = this.$store.state.user.userId
    if (userid != 1) {
      this.isShow = false
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    loginout() {
      this.$store.dispatch('clearUserId');
      this.$store.dispatch('clearUserName');
      this.$router.replace('/login')
    }
  }
};
</script>

<style scoped>
* {
  margin: 0;
  border: 0;
}
#header {
  padding-left: 53px;
}
.hedera {
  text-decoration: none;
  color: black;
}

.hedera:hover {
  color: #ff0101;
}

.el-header {
  color: #333;
  margin-left: 100px;
  line-height: 60px;
}

.content {
  width: 1100px;
  height: 1300px;
  background-color: rgb(255, 255, 255);
  margin-left: 133px;
  /* box-shadow: 14px, 14px, 14px, 14px black; */
}

.el-main {
  background-color: #ebeef0;
  color: #333;
  /* line-height: 90px;
  height: 740px; */
}
.el-dropdown-link {
  cursor: pointer;
}
#user {
  display: inline-block;
  position: relative;
  top: 40px;
  left: 40px;
  font-size: 18px;
}
.transition-box {
  margin-bottom: 10px;
  width: 200px;
  height: 100px;
  border-radius: 4px;
  background-color: #409eff;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
#user-content {
  position: absolute;
  top: 70px;
  left: -40px;
}
.transition-box {
  width: 145px;
  height: 55px;
  padding: 0px;
  margin: 0px;
  line-height: 40px;
  border-radius: 0px;
}
</style>
