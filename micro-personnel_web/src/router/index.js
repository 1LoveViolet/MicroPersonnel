import Vue from "vue";
import VueRouter from "vue-router";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

// 全局使用 Element UI
Vue.use(ElementUI);
Vue.use(VueRouter);
const Edit = () => import("views/Edit.vue");
const Person = () => import("views/Person.vue");
const BasicInfo = () => import("pages/content/BasicInfo.vue");
const Paper = () => import("pages/content/Paper.vue");
const Address = () => import("pages/content/Address.vue");
const Education = () => import("pages/content/Education.vue");
const Contact = () => import("pages/content/Contact.vue");
const ProjectExp = () => import("pages/content/ProjectExp.vue");
const Skill = () => import("pages/content/Skill.vue");
const WorkExp = () => import("pages/content/WorkExp.vue");
const Login = () => import("views/Login.vue");
const Register = () => import("views/Register.vue");
const Home = () => import("views/Home.vue");
const Salary = () => import("views/Salary.vue");
const WorkPost = () => import("views/WorkPost.vue");
const router = new VueRouter({
  // mode: "history", // history 模式去除地址栏 # 号
  routes: [
    // {
    // 	path: "/",
    // 	name: "登录",
    // 	component: () => import("@/components/account/Login.vue"),
    // 	meta: { requireAuth: false },
    // },
    {
      path: "/login",
      component: Login,
    },
    {
      path: "/register",
      component: Register,
    },
    {
      path: "/",
      // redirect: "/edit/basic",
      component: Login,
    },
    {
      path: "/home",
      component: Home,
      children: [
        {
          path: "/home/edit",
          component: Edit,
          // redirect: "/edit/basic",
          children: [
            {
              path: "/edit/basic",
              component: BasicInfo,
              meta: { requireAuth: false },
            },
            {
              path: "/edit/paper",
              component: Paper,
            },
            {
              path: "/edit/address",
              component: Address,
            },
            {
              path: "/edit/contact",
              component: Contact,
            },
            {
              path: "/edit/education",
              component: Education,
            },
            {
              path: "/edit/skill",
              component: Skill,
            },
            {
              path: "/edit/workExp",
              component: WorkExp,
            },
            {
              path: "/edit/projectExp",
              component: ProjectExp,
            },
            {
              path: "/edit/salary",
              component: Salary,
            },
          ],
        },
        {
          path: "/home/person",
          component: Person,
        },
        {
          path: "/home/salary",
          component: Salary,
        },
        {
          path: "/home/workpost",
          component: WorkPost,
        },
      ],
    },
  ],
  mode: "history",
});

router.beforeEach((to, from, next) => {
  const userId = router.app.$store.state.user.userId;

  if (to.path === "/login" || to.path === "/register" || to.path === "/") {
    // 如果是登录或注册页面，直接允许访问
    next();
  } else if (userId) {
    // 用户已登录，允许导航到目标路由
    next();
  } else {
    // 用户未登录，重定向到登录页面或其他处理方式
    Vue.prototype.$alert("请先登录", "提示", {
      confirmButtonText: "确定",
      type: "warning",
      callback: () => {
        next("/login");
      },
    });
  }
});
export default router;
