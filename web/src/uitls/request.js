import axios from "axios";
import { MessageBox, Message } from "element-ui";

// create an axios instance
const service = axios.create({
    baseURL: "/", // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 10000, // request timeout
});

// request interceptor
service.interceptors.request.use(
    (config) => {
        // do something before request is sent
        // config.headers["common"]["Content-Type"] =
        //     "application/x-www-form-urlencoded";
        return config;
    },
    (error) => {
        // do something with request error
        console.log(error); // for debug
        return Promise.reject(error);
    }
);

// response interceptor
service.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */

    /**
     * Determine the request status by custom code
     * Here is just an example
     * You can also judge the status by HTTP Status Code
     */
    (response) => {
        const res = response.data;
        // console.log(res);
        if (res.code == null) {
            return res;
        }
        if (res.code != 200) {
            Message({
                message: res.msg || "Error",
                type: "error",
                duration: 5 * 1000,
            });

            return Promise.reject(new Error(res.message || "Error"));
        } else {
            return res;
        }
    },
    (error) => {
        console.log("err" + error); // for debug
        Message({
            message: error.message,
            type: "error",
            duration: 5 * 1000,
        });
        return Promise.reject(error);
    }
);

export default service;