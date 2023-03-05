package teamWeb.controller;
import teamWeb.entity.*;
import teamWeb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
    OutcomeInfoService outcomeInfoService;
    @Autowired
    MemberInfoService memberInfoService;
    @Autowired
    TextboxInfoService textboxInfoService;
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
    @RequestMapping("/paper")
    public APIResponse paper(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate, OutcomeInfo outcomeInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    outcomeInfo.setPictureUrl(path);
                    outcomeInfoService.insertInfo(outcomeInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            outcomeInfoService.updateInfo(outcomeInfo);
        }else {
            outcomeInfoService.deleteInfo(outcomeInfo);
        }
        return APIResponse.success();
    }
    @RequestMapping("/project")
    public APIResponse project(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate, TextboxInfo textboxInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    textboxInfo.setPictureUrl(path);
                    textboxInfoService.insertInfo(textboxInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            textboxInfoService.updateInfo(textboxInfo);
        }else {
            textboxInfoService.deleteInfo(textboxInfo);
        }
        return APIResponse.success();
    }
    @RequestMapping("/team")
    public APIResponse team(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate,TextboxInfo textboxInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    textboxInfo.setPictureUrl(path);
                    textboxInfoService.insertInfo(textboxInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            textboxInfoService.updateInfo(textboxInfo);
        }else {
            textboxInfoService.deleteInfo(textboxInfo);
        }
        return APIResponse.success();
    }

    @RequestMapping("/member")
    public APIResponse member(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate, MemberInfo memberInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    memberInfo.setPictureUrl(path);
                    memberInfoService.insertInfo(memberInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            memberInfoService.updateInfo(memberInfo);
        }else {
            memberInfoService.deleteInfo(memberInfo);
        }
        return APIResponse.success();
    }

    @RequestMapping("/resource")
    public APIResponse resource(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate,TextboxInfo textboxInfo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    textboxInfo.setPictureUrl(path);
                    textboxInfoService.insertInfo(textboxInfo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            textboxInfoService.updateInfo(textboxInfo);
        }else {
            textboxInfoService.deleteInfo(textboxInfo);
        }
        return APIResponse.success();
    }
}
