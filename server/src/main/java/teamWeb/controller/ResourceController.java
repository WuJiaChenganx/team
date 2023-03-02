package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamWeb.entity.ReportInfo;
import teamWeb.entity.TextboxInfo;
import teamWeb.service.FileService;
import teamWeb.service.ReportInfoService;
import teamWeb.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/teamWeb/resource")
public class ResourceController {
    final
    TextboxInfoService textboxInfoService;
    final
    ReportInfoService reportInfoService;

    private final FileService fileService;

    public ResourceController(FileService fileService, TextboxInfoService textboxInfoService, ReportInfoService reportInfoService) {
        this.fileService = fileService;
        this.textboxInfoService = textboxInfoService;
        this.reportInfoService = reportInfoService;
    }

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


    @GetMapping("download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
                                                 HttpServletRequest request) {
        Resource resource = fileService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename() + "")
                .body(resource);
    }
}
