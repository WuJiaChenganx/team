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
    // 团队动态
    { path: "/activity", redirect: "/activity/newFlash" },
    {
      path: "/activity/newFlash",
      name: "新闻快讯",
      component: () => import("../views/activity/newFlash.vue"),
    },
    {
      path: "/activity/newFlashDetail",
      name: "新闻快讯详情",
      component: () => import("../views/activity/newFlashDetail.vue"),
    },
    {
      path: "/activity/academy",
      name: "学术动态",
      component: () => import("../views/activity/academy.vue"),
    },
    {
      path: "/activity/academyDetail",
      name: "学术动态详情",
      component: () => import("../views/activity/academyDetail.vue"),
    },
    {
      path: "/activity/notice",
      name: "通知公告",
      component: () => import("../views/activity/notice.vue"),
    },
    {
      path: "/activity/noticeDetail",
      name: "通知公告详情",
      component: () => import("../views/activity/noticeDetail.vue"),
    },
    // 论文著作
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
      path: "/team/consultor",
      name: "顾问",
      component: () => import("../views/team/consultor.vue"),
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
    {
      path: "/team/memberInfo",
      name: "成员详情",
      component: () => import("../views/team/memberInfo.vue"),
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
      path: "/scientificResearch/lateralProject",
      name: "横向项目",
      component: () => import("../views/scientificResearch/lateralProject.vue"),
    },
    {
      path: "/scientificResearch/projectDetail",
      name: "横向项目详情",
      component: () => import("../views/scientificResearch/lateralDetail.vue"),
    },
    {
      path: "/scientificResearch/verticalProject",
      name: "纵向项目",
      component: () =>
        import("../views/scientificResearch/verticalProject.vue"),
    },
    {
      path: "/scientificResearch/projectDetail",
      name: "纵向项目详情",
      component: () => import("../views/scientificResearch/verticalDetail.vue"),
    },
    {
      path: "/scientificResearch/platform",
      name: "科研平台",
      component: () => import("../views/scientificResearch/platform.vue"),
    },
    // 教育教学
    {
      path: "/education",
      name: "教育教学",
      redirect: "/education/undergraduate",
    },
    {
      path: "/education/undergraduate",
      name: "本科生教学",
      component: () => import("../views/education/undergraduate.vue"),
    },
    {
      path: "/education/graduate",
      name: "研究生教学",
      component: () => import("../views/education/graduate.vue"),
    },
    {
      path: "/education/achievements",
      name: "教学成果",
      component: () => import("../views/education/achievements.vue"),
    },
    // 成果荣誉
    {
      path: "/prize",
      name: "成果荣誉",
      redirect: "/prize/teamPrize",
    },
    {
      path: "/prize/teamPrize",
      name: "团队荣誉",
      component: () => import("../views/prize/teamPrize"),
    },
    {
      path: "/prize/personalPrize",
      name: "个人荣誉",
      component: () => import("../views/prize/personalPrize"),
    },
    {
      path: "/prize/projectPrize",
      name: "项目获奖",
      component: () => import("../views/prize/projectPrize.vue"),
    },
    // 交流合作
    {
      path: "/cooperation",
      name: "交流合作",
      redirect: "/cooperation/domestic",
    },
    {
      path: "/cooperation/domestic",
      name: "国内交流",
      component: () => import("../views/cooperation/domestic.vue"),
    },
    {
      path: "/cooperation/international",
      name: "国际交流",
      component: () => import("../views/cooperation/international.vue"),
    },
    // 测试用
    {
      path: "/test",
      name: "测试",
      component: () => import("../views/navigation.vue"),
    },
  ],
});
// 跳转后自动返回页面顶部
router.afterEach(() => {
  window.scrollTo(0, 0);
});

export default router;
