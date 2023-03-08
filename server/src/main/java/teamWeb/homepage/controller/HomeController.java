package teamWeb.homepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.homepage.entity.RelationInfo;
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
        List<ReportDO> teamDynamicsDetail = reportInfoService.teamDynamicsDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(teamDynamicsDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/notice")
    public APIResponse notice(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<ReportDO> noticeDetail = reportInfoService.noticeDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(noticeDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/news")
    public APIResponse allNews(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllNewsBO> allNewBOS = reportInfoService.allNews(start,end);
        List<Object> params =new ArrayList<>();
        params.add(allNewBOS);
        return APIResponse.success(params);
    }


    @RequestMapping("/member")
    public APIResponse member(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<MemberDO> member = memberInfoService.getHomeMember(start,end);
        List<Object> params =new ArrayList<>();
        params.add(member);
        return APIResponse.success(params);
    }

    @RequestMapping("/relation")
    public APIResponse relation(){
        List<RelationInfo> relation = textboxInfoService.getRelation();
        List<Object> params =new ArrayList<>();
        params.add(relation);
        return APIResponse.success(params);
    }
}
