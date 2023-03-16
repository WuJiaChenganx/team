import request from "@/uitls/request";

export function getPaperURL(params) {
    return request({
        url: "/api/teamWeb/paper/require-paper",
        method: "GET",
        params,
    });
}