package teamWeb.translate.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.krb5.internal.PAData;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.utils.APIResponse;

import teamWeb.utils.Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static teamWeb.utils.Address.BaseUrl;

@RestController
@RequestMapping("/teamWeb/en")
public class TranslateController {
    @GetMapping("/**")
    public APIResponse translate(HttpServletRequest request, HttpServletResponse res){
        String url = request.getRequestURL().toString();
        // 获取url中携带的参数，即/resTemplate?后面的内容
        String query = request.getQueryString();
        String pagePath = url.split("/teamWeb/en")[1];
        String target = BaseUrl;

        // 新的url拼接上旧url后的请求参数
        if (query != null && !query.equals("") && !query.equals("null")) {
            target = target + pagePath + "?" + query;
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        // 获取到请求头
        Enumeration<String> headerNames = request.getHeaderNames();

        HttpHeaders headers = new HttpHeaders();
        Map<String, String> headerMap = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String header = request.getHeader(headerName);
            headerMap.put(headerName, header);
            headers.add(headerName, header);
        }

        // 构造HttpEntity，新请求会携带本次请求的请求头
        HttpEntity entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.getForEntity(target, String.class, entity);

        Map<String, Object> list = JSONArray.parseObject(response.getBody(), Map.class);

        // 当需要分页时，返回分页信息
        res.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
        res.setHeader("Content-Range", String.valueOf(list.size()));
        res.setHeader("Access-Control-Expose-Headers", "Content-Range");

        return APIResponse.success(list);
    }
}

