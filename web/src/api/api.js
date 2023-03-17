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