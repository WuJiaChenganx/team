package teamWeb.manage.controller;


import teamWeb.manage.server.ManageService;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.service.OutcomeInfoService;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.resource.service.FileService;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.service.ReportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.service.MemberInfoService;
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

    @RequestMapping("/control-report")
    public APIResponse news(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate, ReportDO reportDO){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    reportDO.setPictureUrl(path);
                    reportInfoService.insertInfo(reportDO);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            reportInfoService.updateInfo(reportDO);
        }else {
            reportInfoService.deleteInfo(reportDO);
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
    public APIResponse member(@RequestParam(value = "photos") MultipartFile[] photos, @RequestParam(value="operate") String operate, MemberDO memberDo){
        if(Objects.equals(operate, "insert")){
            if(photos.length > 0){
                for (MultipartFile multipartFile : photos) {
                    String path = fileService.saveFile(multipartFile,"picture");
                    memberDo.setPictureUrl(path);
                    memberInfoService.insertInfo(memberDo);
                }
            }
        } else if (Objects.equals(operate, "updata")) {
            memberInfoService.updateInfo(memberDo);
        }else {
            memberInfoService.deleteInfo(memberDo);
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
