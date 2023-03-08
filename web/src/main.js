import Vue from "vue";
import App from "./App.vue";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import axios from "axios";
import router from "./router/index";

import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
Vue.use(BootstrapVue);

// baseURL后端接口前面的东西,如果写成/就是页面上面的URL
axios.defaults.baseURL = "/";
// 将axios作为全局的自定义属性,每个组件可以在内部直接访问
// 相当于给vue加了个属性叫$http
Vue.prototype.$http = axios;
Vue.config.productionTip = false;
// 全局注册
Vue.use(ElementUI);
new Vue({
  // 导入App组件
  render: (h) => h(App),
  router: router,
}).$mount("#app"); //使用mount挂载到index上
