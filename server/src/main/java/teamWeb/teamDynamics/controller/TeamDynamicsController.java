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
                                 @RequestParam(value="end") Integer end,
                                 @RequestParam(value = "languageType") String languageType){
        List<NoticeBO> allNotice = null;
        Integer sum =null;
        if (languageType.equals("Chinese")) {
            allNotice = reportInfoService.noticeDetail(start, end);
            sum = reportInfoService.sumReport("通知");
        }else if (languageType.equals("English")){
            allNotice = reportInfoService.enNoticeDetail(start,end);
            sum = reportInfoService.sumEnReport("通知");
        }
        return APIResponse.success(allNotice,sum);
    }

    @GetMapping("/require-academicDynamics")
    public APIResponse allacademicDynamics(@RequestParam(value="start") Integer start,
                                           @RequestParam(value="end") Integer end,
                                           @RequestParam(value = "languageType") String languageType){
        List<NoticeBO> teamDynamics = null;
        Integer sum =null;
        if (languageType.equals("Chinese")) {
            teamDynamics = reportInfoService.teamDynamicsDetail(start, end);
            sum = reportInfoService.sumReport("动态");
        }else if (languageType.equals("English")){
            teamDynamics = reportInfoService.enTeamDynamicsDetail(start,end);
            sum = reportInfoService.sumEnReport("动态");
        }
        return APIResponse.success(teamDynamics,sum);
    }


    @GetMapping("/require-news")
    public APIResponse allNews(@RequestParam(value="start") Integer start,
                               @RequestParam(value="end") Integer end,
                               @RequestParam(value = "languageType") String languageType){
        Integer sum =null;
        List<NoticeBO> allNewsBOList = null;
        if (languageType.equals("Chinese")) {
            allNewsBOList = reportInfoService.mediaDetail(start, end);
            sum = reportInfoService.sumReport("媒体");
        }else if (languageType.equals("English")){
            allNewsBOList = reportInfoService.enMediaDetail(start,end);
            sum = reportInfoService.sumEnReport("媒体");
        }
        return APIResponse.success(allNewsBOList,sum);
    }

    @GetMapping(value = "/require-detail")
    public APIResponse requireDetail(@RequestParam(value="id") Integer id,
                                     @RequestParam(value = "languageType") String languageType){
        ReportBO news = null;
        if (languageType.equals("Chinese")){
            news = reportInfoService.getNews(id);
            reportInfoService.updateViewCount(id);
        }else if (languageType.equals("English")){
            news = reportInfoService.enGetNews(id);
            reportInfoService.updateEnViewCount(id);
        }
        return APIResponse.success(news);
    }
}
