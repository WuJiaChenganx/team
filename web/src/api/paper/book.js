import request from "@/uitls/request";

export function getBookURL(params) {
    return request({
        url: "/api/teamWeb/paper/require-monograph",
        method: "GET",
        params,
    });
}