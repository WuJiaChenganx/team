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
@RequestMapping("/teamWeb/Scientific")
public class ScientificController {
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/dire")
    public APIResponse dire(@RequestParam(value="page") int page){
        List<TextboxInfo> direDetail = textboxInfoService.direDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(direDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/platform")
    public APIResponse platform(@RequestParam(value="page") int page){
        List<TextboxInfo> platformDetail = textboxInfoService.platformDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(platformDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/teach")
    public APIResponse teach(@RequestParam(value="page") int page){
        List<TextboxInfo> teachDetail = textboxInfoService.teachDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(teachDetail);
        return APIResponse.success(params);
    }

}
