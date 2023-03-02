import VueRouter from "vue-router";
import Vue from "vue";
import Layout from "../components/layout/layout";
// 将VueRouter作为Vue的插件
Vue.use(VueRouter);
const router = new VueRouter({
    routes: [
        // redirect重定向当用户访问/是跳转到/navigation
        { path: "/", redirect: "/home" },
        {
            path: "/home",
            layout: Layout,
            component: () =>
                import ( /* webpackChunkName: "news" */ "../views/home.vue"),
            // 使用child人属性,嵌套声明子路由
            children: [],
        },
        {
            path: "/newFlash",
            component: () =>
                import ( /* webpackChunkName: "news" */ "../views/newFlash.vue"),
        },
        {
            path: "/paging",
            layout: Layout,
            component: () =>
                import ( /* webpackChunkName: "news" */ "../views/paging.vue"),
        },
        {
            path: "/resource",
            component: () =>
                import ( /* webpackChunkName: "news" */ "../views/resourceSharing.vue"),
        },
    ],
});
export default router;