package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.service.MemberInfoService;
import teamWeb.service.ReportInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/news")
public class NewsController {

    @Autowired
    ReportInfoService reportInfoService;

    @RequestMapping("/notice")
    public APIResponse notice(@RequestParam(value="page") int page){
        List<ReportInfo> noticeDetail = reportInfoService.noticeDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(noticeDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/teamDynamics")
    public APIResponse teamDynamics(@RequestParam(value="page") int page){
        List<ReportInfo> teamDynamicsDetail = reportInfoService.teamDynamicsDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(teamDynamicsDetail);
        return APIResponse.success(params);
    }


    @RequestMapping("/media")
    public APIResponse media(@RequestParam(value="page") int page){
        List<ReportInfo> mediaDetail = reportInfoService.mediaDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>                                                                          ();
        params.add(mediaDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/consult")
    public APIResponse consult(@RequestParam(value="page") int page){
        List<ReportInfo> consultDetail = reportInfoService.consultDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(consultDetail);
        return APIResponse.success(params);
    }
}
