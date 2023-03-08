package teamWeb.teamDynamics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamDynamics.pojo.AllNewsDTO;
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
        List<ReportDO> allNotice = reportInfoService.noticeDetail(start,end);
        return APIResponse.success(allNotice);
    }

    @GetMapping("/require-academicDynamics")
    public APIResponse allacademicDynamics(@RequestParam(value="start") Integer start,
                                           @RequestParam(value="end") Integer end){
        List<ReportDO> teamDynamics = reportInfoService.teamDynamicsDetail(start,end);
        return APIResponse.success(teamDynamics);
    }


    @GetMapping("/require-news")
    public APIResponse allNews(@RequestParam(value="start") Integer start,
                               @RequestParam(value="end") Integer end){
        List<AllNewsBO> allNewsBOList = reportInfoService.allNews(start, end);
        List<AllNewsDTO> allNewsDTOList = BeanUtil.convert(allNewsBOList, AllNewsDTO.class);
        return APIResponse.success(allNewsDTOList);
    }

    @GetMapping(value = "/require-detail")
    public APIResponse requireDetail(@RequestParam(value="id") Integer id){
        List<ReportDO> getNews = reportInfoService.getNews(id);

        return APIResponse.success(getNews);
    }
}
