package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.TextboxInfo;
import teamWeb.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/teamWeb/project")
public class ProjectController {
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/projecting")
    public APIResponse projecting(@RequestParam(value="page") int page){
        List<TextboxInfo> projectDetail = textboxInfoService.projectDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(projectDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/projected")
    public APIResponse projected(@RequestParam(value="page") int page){
        List<TextboxInfo> projectedDetail = textboxInfoService.projectedDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(projectedDetail);
        return APIResponse.success(params);
    }
}
