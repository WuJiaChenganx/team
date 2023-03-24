import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);
// 公共state对象,刷新之后才会吧state对象存起来,没有刷新之前,sessionStorage里面没有存state对象所以在浏览器里面看不到但是这个对象可以直接用
const state =
  sessionStorage.getItem("state") != null
    ? JSON.parse(sessionStorage.getItem("state"))
    : {
        languageType: "Chinese",
      };

// 返回一个完整的用户对象,计算属性
const getters = {
  getLanguageType(state) {
    return state.languageType;
  },
};
// 唯一可以修改state的方法,同步阻塞
const mutations = {
  // state是对象,languageType是要传入的值,然后对languageType进行更新
  updateLanguageType(state, languageType) {
    state.languageType = languageType;
  },
};
const actions = {
  // context表示上下文
  async updateLanguageType(context, languageType) {
    // 调用上面mutations中的updateLanguageType方法,调用mutations必须使用commit去调用
    await context.commit("updateLanguageType", languageType);
  },
};

export default new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
});
