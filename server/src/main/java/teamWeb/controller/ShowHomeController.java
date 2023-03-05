package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.RelationInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.service.MemberInfoService;
import teamWeb.service.ReportInfoService;
import teamWeb.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/home")
public class ShowHomeController {

    @Autowired
    ReportInfoService reportInfoService;
    @Autowired
    MemberInfoService memberInfoService;
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/teamDynamics")
    public APIResponse teamDynamics(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<ReportInfo> teamDynamicsDetail = reportInfoService.teamDynamicsDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(teamDynamicsDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/notice")
    public APIResponse notice(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<ReportInfo> noticeDetail = reportInfoService.noticeDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(noticeDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/news")
    public APIResponse news(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<ReportInfo> newsDetail = reportInfoService.newsDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(newsDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/member")
    public APIResponse member(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<MemberInfo> member = memberInfoService.getHomeMember(start,end);
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
