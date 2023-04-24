package teamWeb.homepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.homepage.service.HomeService;
import teamWeb.teamDynamics.pojo.NoticeBO;

import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamSurvey.service.MemberInfoService;
import teamWeb.teamDynamics.service.ReportInfoService;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.List;

@RestController
@RequestMapping("/teamWeb/home")
public class HomeController {
    @Autowired
    ReportInfoService reportInfoService;
    @Autowired
    TextboxInfoService textboxInfoService;
    @Autowired
    HomeService homeService;

    @RequestMapping("/teamDynamics")
    public APIResponse teamDynamics(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<NoticeBO> teamDynamicsDetail = reportInfoService.teamDynamicsDetail(start,end,"回顾");
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
        List<RelationInfo> relation = textboxInfoService.relationDetail();
        return APIResponse.success(relation);
    }

    @GetMapping("/pageView")
    public APIResponse pageView(){
        Integer pageView = homeService.pageView();
        return APIResponse.success(pageView);
    }
}
