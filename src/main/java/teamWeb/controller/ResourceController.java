package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.ReportInfo;
import teamWeb.entity.TextboxInfo;
import teamWeb.service.ReportInfoService;
import teamWeb.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/resource")
public class ResourceController {
    @Autowired
    TextboxInfoService textboxInfoService;
    @Autowired
    ReportInfoService reportInfoService;

    @RequestMapping("/emulation")
    public APIResponse emulation(@RequestParam(value="page") int page){
        List<TextboxInfo> emulationDetail = textboxInfoService.emulationDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(emulationDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/data")
    public APIResponse data(@RequestParam(value="page") int page){
        List<TextboxInfo> dataDetail = textboxInfoService.dataDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(dataDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/meet")
    public APIResponse meet(@RequestParam(value="page") int page){
        List<ReportInfo> meetDetail = reportInfoService.meetDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(meetDetail);
        return APIResponse.success(params);
    }
}
