package teamWeb.controller;
import teamWeb.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import teamWeb.entity.ReportInfo;
import teamWeb.service.FileService;
import teamWeb.service.ReportInfoService;
import teamWeb.utils.APIResponse;

import java.util.Objects;

@RestController
@RequestMapping("/teamWeb/manage")
public class ManageController {
    @Autowired
    ManageService manageService;
    @Autowired
    ReportInfoService reportInfoService;

    @Autowired
    FileService fileService;
    /*
    @RequestMapping("/news")
    public APIResponse news(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<ReportInfo> news = reportInfoService.allNews(start,end);
        List<Object> params =new ArrayList<>();
        params.add(news);
        return APIResponse.success(params);
    }*/
    @RequestMapping("/news")
    public APIResponse news(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate,ReportInfo reportInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    reportInfo.setPictureUrl(path);
                    reportInfoService.insertInfo(reportInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            reportInfoService.updateInfo(reportInfo);
        }else {
            reportInfoService.deleteInfo(reportInfo);
        }
        return APIResponse.success();
    }

}
