import VueRouter from "vue-router";
import Vue from "vue";
import NavigationBar from "../components/public/navigationBar.vue";
import MyFooter from "../components/public/myFooter.vue";
// 将VueRouter作为Vue的插件
Vue.use(VueRouter);
const router = new VueRouter({
    routes: [
        // 在单页面应用中，网页具体路径显示是由vue-router配置中 path 决定的，path设置的是什么就显示什么，和name无关。
        // 在单页面应用中，网页具体路径显示是由vue-router配置中 path 决定的，path设置的是什么就显示什么，和name无关。
        // 其实name就相当于给你的path取个别名，方便使用，路由并不是一定要设置name值。（如果不设置name，vue-router默认name值为 default）
        // redirect重定向当用户访问/是跳转到/navigation
        { path: "/", redirect: "/home" },
        {
            path: "/home",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import ( /* webpackChunkName: "news" */ "../views/home.vue"),
                Bottom: MyFooter,
            },
        },
        {
            path: "/newFlash",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import ( /* webpackChunkName: "news" */ "../views/newFlash.vue"),
                Bottom: MyFooter,
            },
        },
        {
            path: "/paper",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import ( /* webpackChunkName: "news" */ "../views/paper/paper.vue"),
                Bottom: MyFooter,
            },
        },
        {
            path: "/patent",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import ( /* webpackChunkName: "news" */ "../views/paper/patent.vue"),
                Bottom: MyFooter,
            },
        },
        {
            path: "/book",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import ( /* webpackChunkName: "news" */ "../views/paper/book.vue"),
                Bottom: MyFooter,
            },
        },
        {
            path: "/simulationTool",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/resourceSharing/simulationTool.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/dataSet",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/resourceSharing/dataSet.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/teamProfile",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/teamIntroduction/teamProfile.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/teacher",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/teamIntroduction/teacher.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/doctor",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/teamIntroduction/doctor.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/master",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/teamIntroduction/master.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/graduate",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/teamIntroduction/graduate.vue"
                    ),
                Bottom: MyFooter,
            },
        },

        {
            path: "/researchDirection",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/scientificResearch/researchDirection.vue"
                    ),
                Bottom: MyFooter,
            },
        },

        {
            path: "/project",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/scientificResearch/project.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/platform",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/scientificResearch/platform.vue"
                    ),
                Bottom: MyFooter,
            },
        },
        {
            path: "/curriculum",
            components: {
                Top: NavigationBar,
                // default表示router-view中没有加name的部分
                default: () =>
                    import (
                        /* webpackChunkName: "news" */
                        "../views/scientificResearch/curriculum.vue"
                    ),
                Bottom: MyFooter,
            },
        },
    ],
});
export default router;