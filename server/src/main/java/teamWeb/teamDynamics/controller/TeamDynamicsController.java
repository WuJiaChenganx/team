package teamWeb.teamDynamics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamDynamics.pojo.AllNewsDTO;
import teamWeb.teamDynamics.pojo.NoticeBO;
import teamWeb.teamDynamics.pojo.ReportBO;
import teamWeb.teamDynamics.service.ReportInfoService;
import teamWeb.utils.APIResponse;
import teamWeb.utils.BeanUtil;

import java.util.List;

@RestController
@RequestMapping("/teamWeb/report")
public class TeamDynamicsController {

    @Autowired
    ReportInfoService reportInfoService;


    @GetMapping("/require-notice")
    public APIResponse allNotice(@RequestParam(value="start") Integer start,
                                 @RequestParam(value="end") Integer end){
        List<NoticeBO> allNotice = reportInfoService.noticeDetail(start,end);
        return APIResponse.success(allNotice,reportInfoService.sumReport("通知"));
    }

    @GetMapping("/require-academicDynamics")
    public APIResponse allacademicDynamics(@RequestParam(value="start") Integer start,
                                           @RequestParam(value="end") Integer end){
        List<NoticeBO> teamDynamics = reportInfoService.teamDynamicsDetail(start,end);
        return APIResponse.success(teamDynamics,reportInfoService.sumReport("动态"));
    }


    @GetMapping("/require-news")
    public APIResponse allNews(@RequestParam(value="start") Integer start,
                               @RequestParam(value="end") Integer end){
        List<NoticeBO> allNewsBOList = reportInfoService.mediaDetail(start, end);
        return APIResponse.success(allNewsBOList,reportInfoService.sumReport("媒体"));
    }

    @GetMapping(value = "/require-detail")
    public APIResponse requireDetail(@RequestParam(value="id") Integer id){
        List<ReportBO> getNews = reportInfoService.getNews(id);
        return APIResponse.success(getNews);
    }
}
