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
    public APIResponse projecting(@RequestParam(value="start") int start,
                                  @RequestParam(value="end") int end,
                                  @RequestParam(value = "languageType") String languageType){
        Integer sum =null;
        List<ProjectBO> projectDetail = null;
        if (languageType.equals("Chinese")) {
             projectDetail = textboxInfoService.projectDetail(start, end);
             sum = textboxInfoService.sumProject();
        }else if(languageType.equals("English")) {
            projectDetail = textboxInfoService.enProjectDetail(start,end);
            sum = textboxInfoService.sumEnProject();
        }
        return APIResponse.success(projectDetail,sum);
    }


    @RequestMapping("/require-direction")
    public APIResponse direction(@RequestParam(value="start",defaultValue = "0") int start,
                                 @RequestParam(value="end",defaultValue = "10") int end,
                                 @RequestParam(value = "languageType") String languageType){
        Integer sum =null;
        List<DirectionsDTO> direDetail = null;
        if (languageType.equals("Chinese")) {
            direDetail = textboxInfoService.direDetail(start, end);
            sum = textboxInfoService.sumTextbox("科研方向");
        }else if (languageType.equals("English")){
            direDetail = textboxInfoService.enDireDetail(start,end);
            sum = textboxInfoService.sumEnTextbox("科研方向");
        }
        return APIResponse.success(direDetail,sum);
    }

    @RequestMapping("/require-platform")
    public APIResponse platform(@RequestParam(value="start",defaultValue = "0") int start,
                                @RequestParam(value="end",defaultValue = "10") int end,
                                @RequestParam(value = "languageType") String languageType){
        List<PlatformDTO> platformDetail = textboxInfoService.platformDetail(start,end);
        return APIResponse.success(platformDetail,textboxInfoService.sumEnTextbox("科研平台"));
    }


    @GetMapping("/require-courses")
    public APIResponse course(@RequestParam(value = "languageType") String languageType) {
        List<CoursePageBO> teachDetail=null;
        teachDetail = textboxInfoService.teachDetail();
        return APIResponse.success(teachDetail,textboxInfoService.sumEnTextbox("课程教学"));
    }
}
