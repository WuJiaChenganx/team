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