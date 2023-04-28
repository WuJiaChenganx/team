package teamWeb.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.research.entity.ProjectInfo;
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

    @GetMapping("/require-project")
    public APIResponse projecting(@RequestParam(value="start") int start,
                                  @RequestParam(value="end") int end,
                                  @RequestParam(value = "languageType") String languageType,
                                  @RequestParam(value = "type") String direType){
        Integer sum =null;
        List<ProjectBO> projectDetail = null;
        if (languageType.equals("Chinese")) {
             projectDetail = textboxInfoService.projectDetail(start, end,direType);
             sum = textboxInfoService.sumProject(direType);
        }else if(languageType.equals("English")) {
            projectDetail = textboxInfoService.enProjectDetail(start,end);
            sum = textboxInfoService.sumEnProject();
        }
        return APIResponse.success(projectDetail,sum);
    }

    @GetMapping("/require-projectDetail")
    public APIResponse projectDetail(@RequestParam(value = "languageType") String languageType,
                                     @RequestParam(value = "projectId") Integer projectId){
        ProjectBO projectBO = textboxInfoService.projectInfo(projectId);
        return APIResponse.success(projectBO);
    }


    @GetMapping("/require-direction")
    public APIResponse direction(@RequestParam(value = "languageType") String languageType){
        String sum =null;
        List<DirectionsDTO> direDetail = null;
        if (languageType.equals("Chinese")) {
            direDetail = textboxInfoService.direDetail();
            sum = textboxInfoService.sumDire();
        }else if (languageType.equals("English")){
            // direDetail = textboxInfoService.enDireDetail(start,end);
            // sum = textboxInfoService.sumEnTextbox("科研方向");
            sum=" ";
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





}
