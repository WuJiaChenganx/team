package teamWeb.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/teamWeb/project")
public class ProjectController {
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/projecting")
    public APIResponse projecting(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<TextboxInfo> projectDetail = textboxInfoService.projectDetail(start,end);
        return APIResponse.success(projectDetail);
    }

    @RequestMapping("/projected")
    public APIResponse projected(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<TextboxInfo> projectedDetail = textboxInfoService.projectedDetail(start,end);
        return APIResponse.success(projectedDetail);
    }
    @RequestMapping("/Detail")
    public APIResponse getText(@RequestParam(value = "id") int id){
        List<TextboxInfo> text = textboxInfoService.getText(id);
        return APIResponse.success(text);
    }
}
