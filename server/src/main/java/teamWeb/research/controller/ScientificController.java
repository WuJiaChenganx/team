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
@RequestMapping("/teamWeb/scientific")
public class ScientificController {
    @Autowired
    TextboxInfoService textboxInfoService;

    @RequestMapping("/dire")
    public APIResponse dire(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<TextboxInfo> direDetail = textboxInfoService.direDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(direDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/platform")
    public APIResponse platform(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<TextboxInfo> platformDetail = textboxInfoService.platformDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(platformDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/teach")
    public APIResponse teach(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<TextboxInfo> teachDetail = textboxInfoService.teachDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(teachDetail);
        return APIResponse.success(params);
    }
    @RequestMapping("/Detail")
    public APIResponse getText(@RequestParam(value = "id") int id){
        List<TextboxInfo> text = textboxInfoService.getText(id);
        List<Object> params =new ArrayList<>();
        params.add(text);
        return APIResponse.success(params);
    }
}
