package teamWeb.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.pojo.CoursePageBO;
import teamWeb.research.pojo.DirectionsDTO;
import teamWeb.research.pojo.PlatformDTO;
import teamWeb.research.pojo.ProjectBO;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/teamWeb/project")
public class ProjectController {
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/require-project")
    public APIResponse projecting(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<ProjectBO> projectDetail = textboxInfoService.projectDetail(start,end);
        return APIResponse.success(projectDetail);
    }


    @RequestMapping("/require-direction")
    public APIResponse direction(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<DirectionsDTO> direDetail = textboxInfoService.direDetail(start,end);
        return APIResponse.success(direDetail);
    }

    @RequestMapping("/require-platform")
    public APIResponse platform(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<PlatformDTO> platformDetail = textboxInfoService.platformDetail(start,end);
        return APIResponse.success(platformDetail);
    }


    @GetMapping("/require-courses")
    public APIResponse course() {
        List<CoursePageBO> teachDetail = textboxInfoService.teachDetail();
        return APIResponse.success(teachDetail);
    }
}
