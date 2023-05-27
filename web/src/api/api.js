import request from "@/uitls/request";
// 获取论文
export function getPaperURL(params) {
  return request({
    url: "/api/teamWeb/paper/require-paper",
    method: "GET",
    params,
  });
}
// 获取专著
export function getBookURL(params) {
  return request({
    url: "/api/teamWeb/paper/require-monograph",
    method: "GET",
    params,
  });
}
// 获取专利
export function getPatentURL(params) {
  return request({
    url: "/api/teamWeb/paper/require-patent",
    method: "GET",
    params,
  });
}
// 获取仿真工具
export function getSimulationToolURL(params) {
  return request({
    url: "/api/teamWeb/resource/require-tool",
    method: "GET",
    params,
  });
}
// 获取数据集
export function getDataSetURL(params) {
  return request({
    url: "/api/teamWeb/resource/require-data",
    method: "GET",
    params,
  });
}
// 获取新闻
export function getNewFlashURL(params) {
  return request({
    url: "/api/teamWeb/report/require-news",
    method: "GET",
    params,
  });
}
// 获取学术动态
export function getAcademyURL(params) {
  return request({
    url: "/api/teamWeb/report/require-academicDynamics",
    method: "GET",
    params,
  });
}
// 获取通知
export function getNoticeURL(params) {
  return request({
    url: "/api/teamWeb/report/require-notice",
    method: "GET",
    params,
  });
}

// 获取新闻/学术动态/通知的详情(参数是id)
export function getActivityDetail(params) {
  return request({
    url: "/api/teamWeb/report/require-detail",
    method: "GET",
    params,
  });
}

// 通过memberType获取不同类型的老师信息
// memberType 的值为 'teacher','principal'
// 例如teamWeb / teamSurvey / require - member ? start = 0 & end = 2 & memberType = teacher
export function getMemberCover(params) {
  return request({
    url: "/api/teamWeb/teamSurvey/require-member",
    method: "GET",
    params,
  });
}
// 获得学生信息
// 参数如右边languageType=Chinese&memberType=master&start=0&end=100
export function getStudentCover(params) {
  return request({
    url: "/api/teamWeb/teamSurvey/require-student",
    method: "GET",
    params,
  });
}

// 获取学生信息详情(参数是id)
export function getMemberDetail(params) {
  return request({
    url: "/api/teamWeb/teamSurvey/require-detail",
    method: "GET",
    params,
  });
}

// 获取科研项目
export function getProjectURL(params) {
  return request({
    url: "/api/teamWeb/project/require-project",
    method: "GET",
    params,
  });
}
// 项目详情
export function getProjectDetail(params) {
  return request({
    url: "/api/teamWeb/project/require-projectDetail",
    method: "GET",
    params,
  });
}
// 首页团队详情(不需要参数全部传)
export function getHomeMember(params) {
  return request({
    url: "/api/teamWeb/teamSurvey/require-homeMember",
    method: "GET",
    params,
  });
}
// 本科生教育/研究生教育
// http://localhost:8186/teamWeb/teach/require-courses?languageType = Chinese &start=0&end=10&type=master
export function getCourseURL(params) {
  return request({
    url: "/api/teamWeb/teach/require-courses",
    method: "GET",
    params,
  });
}
// 成果荣誉:type=团队荣誉honor 科技成果project
// http://localhost:8186/teamWeb/award/require-award?languageType = Chinese &start=0&end=3&type=team
export function getPrizeAndHonourURL(params) {
  return request({
    url: "api/teamWeb/award/require-award",
    method: "GET",
    params,
  });
}
// 教育成果
// http://localhost:8186/teamWeb/teach/require-studentAward?languageType = Chinese
export function getStudentAwardURL(params) {
  return request({
    url: "api/teamWeb/teach/require-studentAward",
    method: "GET",
    params,
  });
}
// 首页浏览量
export function getHomePageViewURL(params) {
  return request({
    url: "api/teamWeb/home/pageView",
    method: "GET",
    params,
  });
}
// 获取研究方向
export function getDirectionURL(params) {
  return request({
    url: "api/teamWeb/project/require-direction",
    method: "GET",
    params,
  });
}
// http://localhost:8186/teamWeb/interflow/require-internal?languageType=Chinese
// 获取国内交流
export function getDomesticURL(params) {
  return request({
    url: "api/teamWeb/interflow/require-internal",
    method: "GET",
    params,
  });
}
// http://localhost:8186/teamWeb/interflow/require-foreign?languageType=Chinese
// 获取国外交流
export function getInternationalURL(params) {
  return request({
    url: "api/teamWeb/interflow/require-foreign",
    method: "GET",
    params,
  });
}
