import request from "@/uitls/request";

export function getSimulationToolURL(params) {
    return request({
        url: "/api/teamWeb/resource/require-tool",
        method: "GET",
        params,
    });
}