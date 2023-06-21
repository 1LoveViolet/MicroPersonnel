import Vue from "vue";
import App from "./App.vue";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import VueRouter from "vue-router";
import router from "./router";
import axios from "axios";

Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.prototype.axios = axios;
axios.defaults.baseURL = "http://localhost:8080"; //我电脑问题，你们使用改成http://127.0.0.1

import store from "./store";
Vue.prototype.$store = store;

// // 在 Vue 实例创建之前添加一个监听器
// window.addEventListener("beforeunload", () => {
//   // 在浏览器关闭之前，触发该事件
//   // 在此处执行清除用户 ID 的操作
//   store.commit("clearUserId"); // 假设您有一个 mutation 叫做 clearUserId，用于清除用户 ID
// });

new Vue({
  store,
  render: (h) => h(App),
  router: router,

  beforeCreate() {
    Vue.prototype.$bus = this;
  },
}).$mount("#app");
