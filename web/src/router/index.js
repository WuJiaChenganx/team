import VueRouter from "vue-router";
import Vue from "vue";

// 将VueRouter作为Vue的插件
Vue.use(VueRouter);
const router = new VueRouter({
  routes: [
    { path: "/", redirect: "/home" },
    // 首页
    {
      path: "/home",
      name: "首页",
      component: () => import("../views/home/home.vue"),
    },
    // 新闻快讯模块
    {
      path: "/newFlash",
      name: "新闻列表",
      component: () => import("../views/newFlash/newFlash.vue"),
    },
    {
      path: "/newFlash/detail",
      name: "新闻详情",
      component: () => import("../views/newFlash/newFlashDetail.vue"),
    },
    // 论文论著
    {
      path: "/paper",
      redirect: "/paper/paper",
    },
    {
      path: "/paper/paper",
      name: "发表论文",
      component: () => import("../views/paper/paper.vue"),
    },

    {
      path: "/paper/patent",
      name: "授权专利",
      component: () => import("../views/paper/patent.vue"),
    },
    {
      path: "/paper/book",
      name: "出版专著",
      component: () => import("../views/paper/book.vue"),
    },
    // 资源共享
    {
      path: "/resource",
      redirect: "/resource/simulationTool",
    },
    {
      path: "/resource/simulationTool",
      name: "仿真工具",
      component: () => import("../views/resourceSharing/simulationTool.vue"),
    },
    {
      path: "/resource/dataSet",
      name: "数据集",
      component: () => import("../views/resourceSharing/dataSet.vue"),
    },
    // 团队概况
    {
      path: "/team",
      redirect: "/team/profile",
    },
    {
      path: "/team/profile",
      name: "团队简介",
      component: () => import("../views/team/profile.vue"),
    },
    {
      path: "/team/teacher",
      name: "老师",
      component: () => import("../views/team/teacher.vue"),
    },
    {
      path: "/team/doctor",
      name: "博士生",
      component: () => import("../views/team/doctor.vue"),
    },
    {
      path: "/team/master",
      name: "研究生",
      component: () => import("../views/team/master.vue"),
    },
    {
      path: "/team/graduate",
      name: "毕业生",
      component: () => import("../views/team/graduate.vue"),
    },
    // 科研教学
    {
      path: "/scientificResearch",
      redirect: "/scientificResearch/direction",
    },
    {
      path: "/scientificResearch/direction",
      name: "研究方向",
      component: () => import("../views/scientificResearch/direction.vue"),
    },
    {
      path: "/scientificResearch/project",
      name: "科研项目",
      component: () => import("../views/scientificResearch/project.vue"),
    },
    {
      path: "/scientificResearch/platform",
      name: "科研平台",
      component: () => import("../views/scientificResearch/platform.vue"),
    },
    {
      path: "/scientificResearch/curriculum",
      name: "课程教学",
      component: () => import("../views/scientificResearch/curriculum.vue"),
    },
  ],
});
export default router;
