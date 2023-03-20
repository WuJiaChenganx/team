package teamWeb.homepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.teamDynamics.pojo.NoticeBO;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamSurvey.service.MemberInfoService;
import teamWeb.teamDynamics.service.ReportInfoService;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/home")
public class HomeController {
    @Autowired
    ReportInfoService reportInfoService;
    @Autowired
    MemberInfoService memberInfoService;
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/teamDynamics")
    public APIResponse teamDynamics(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<NoticeBO> teamDynamicsDetail = reportInfoService.teamDynamicsDetail(start,end);
        return APIResponse.success(teamDynamicsDetail);
    }

    @RequestMapping("/notice")
    public APIResponse notice(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<NoticeBO> noticeDetail = reportInfoService.noticeDetail(start,end);
        return APIResponse.success(noticeDetail);
    }

    @RequestMapping("/news")
    public APIResponse allNews(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllNewsBO> allNewBOS = reportInfoService.allNews(start,end);
        return APIResponse.success(allNewBOS);
    }



    @RequestMapping("/relation")
    public APIResponse relation(){
        List<RelationInfo> relation = textboxInfoService.getRelation();
        return APIResponse.success(relation);
    }
}
