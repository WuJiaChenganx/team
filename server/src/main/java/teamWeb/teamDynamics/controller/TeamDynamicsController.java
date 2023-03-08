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
@RequestMapping("/teamWeb/news")
public class TeamDynamicsController {

    @Autowired
    ReportInfoService reportInfoService;


    @RequestMapping("/require-notice")
    public APIResponse allNotice(@RequestParam(value="page") int page){
        List<AllNewsBO> allNotice = reportInfoService.noticeDetail((page-1)*10,page*10);
        return APIResponse.success(allNotice);
    }

    @RequestMapping("/require-academicDynamics")
    public APIResponse allacademicDynamics(@RequestParam(value="page") int page){
        List<AllNewsBO> teamDynamics = reportInfoService.teamDynamicsDetail((page-1)*10,page*10);
        return APIResponse.success(teamDynamics);
    }

    @GetMapping("/require-news")
    public APIResponse allNews(@RequestParam(value="start") int start,
                               @RequestParam(value="end") int end){
        List<AllNewsBO> allNewsBOList = reportInfoService.allNews(start, end);
        List<AllNewsDTO> allNewsDTOList = BeanUtil.convert(allNewsBOList, AllNewsDTO.class);
        return APIResponse.success(allNewsDTOList);
    }

    @RequestMapping(value = "/require-detail")
    public APIResponse requireDetail(@RequestParam(value="id") int id){
        List<ReportDO> getNews = reportInfoService.getNews(id);

        return APIResponse.success(getNews);
    }
}
