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
            component: () =>
                import ("../views/home/home.vue"),
        },
        // 团队动态
        { path: "/activity", redirect: "/activity/newFlash" },
        {
            path: "/activity/newFlash",
            name: "新闻快讯",
            component: () =>
                import ("../views/activity/newFlash.vue"),
        },
        {
            path: "/activity/newFlashDetail",
            name: "新闻快讯详情",
            component: () =>
                import ("../views/activity/newFlashDetail.vue"),
        },
        {
            path: "/activity/academy",
            name: "学术动态",
            component: () =>
                import ("../views/activity/academy.vue"),
        },
        {
            path: "/activity/academyDetail",
            name: "学术动态详情",
            component: () =>
                import ("../views/activity/academyDetail.vue"),
        },
        {
            path: "/activity/notice",
            name: "通知公告",
            component: () =>
                import ("../views/activity/notice.vue"),
        },
        {
            path: "/activity/noticeDetail",
            name: "通知公告详情",
            component: () =>
                import ("../views/activity/noticeDetail.vue"),
        },
        // 论文论著
        {
            path: "/paper",
            redirect: "/paper/paper",
        },
        {
            path: "/paper/paper",
            name: "发表论文",
            component: () =>
                import ("../views/paper/paper.vue"),
        },

        {
            path: "/paper/patent",
            name: "授权专利",
            component: () =>
                import ("../views/paper/patent.vue"),
        },
        {
            path: "/paper/book",
            name: "出版专著",
            component: () =>
                import ("../views/paper/book.vue"),
        },
        // 资源共享
        {
            path: "/resource",
            redirect: "/resource/simulationTool",
        },
        {
            path: "/resource/simulationTool",
            name: "仿真工具",
            component: () =>
                import ("../views/resourceSharing/simulationTool.vue"),
        },
        {
            path: "/resource/dataSet",
            name: "数据集",
            component: () =>
                import ("../views/resourceSharing/dataSet.vue"),
        },
        // 团队概况
        {
            path: "/team",
            redirect: "/team/profile",
        },
        {
            path: "/team/profile",
            name: "团队简介",
            component: () =>
                import ("../views/team/profile.vue"),
        },
        {
            path: "/team/teacher",
            name: "老师",
            component: () =>
                import ("../views/team/teacher.vue"),
        },
        {
            path: "/team/doctor",
            name: "博士生",
            component: () =>
                import ("../views/team/doctor.vue"),
        },
        {
            path: "/team/master",
            name: "研究生",
            component: () =>
                import ("../views/team/master.vue"),
        },
        {
            path: "/team/graduate",
            name: "毕业生",
            component: () =>
                import ("../views/team/graduate.vue"),
        },
        {
            path: "/team/studentDetail",
            name: "学生详情",
            component: () =>
                import ("../views/team/studentDetail.vue"),
        },
        // 科研教学
        {
            path: "/scientificResearch",
            redirect: "/scientificResearch/direction",
        },
        {
            path: "/scientificResearch/direction",
            name: "研究方向",
            component: () =>
                import ("../views/scientificResearch/direction.vue"),
        },
        {
            path: "/scientificResearch/project",
            name: "科研项目",
            component: () =>
                import ("../views/scientificResearch/project.vue"),
        },
        {
            path: "/scientificResearch/platform",
            name: "科研平台",
            component: () =>
                import ("../views/scientificResearch/platform.vue"),
        },
        {
            path: "/scientificResearch/curriculum",
            name: "课程教学",
            component: () =>
                import ("../views/scientificResearch/curriculum.vue"),
        },
        // 测试用
        {
            path: "/test",
            name: "测试",
            component: () =>
                import ("../views/home.vue"),
        },
        {
            path: "/test1",
            name: "测试",
            component: () =>
                import ("../views/home1.vue"),
        },
        {
            path: "/test2",
            name: "测试",
            component: () =>
                import ("../views/home2.vue"),
        },
    ],
});
export default router;