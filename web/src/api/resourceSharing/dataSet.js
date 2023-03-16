import request from "@/uitls/request";

export function getDataSetURL(params) {
    return request({
        url: "/api/teamWeb/resource/require-data",
        method: "GET",
        params,
    });
}