package teamWeb.resource.controller;

import org.springframework.web.bind.annotation.*;
import teamWeb.resource.pojo.ResourceBO;
import teamWeb.resource.pojo.ResourceDTO;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.resource.service.FileService;
import teamWeb.teamDynamics.service.ReportInfoService;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;
import teamWeb.utils.BeanUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

    @GetMapping("/require-tool")
    public APIResponse emulation(@RequestParam(value="start") int start,
                                 @RequestParam(value="end") int end,
                                 @RequestParam(value = "languageType") String language){
        Integer sum =null;
        List<ResourceBO> emulationDetail =null;
        List<ResourceDTO> resourceDTOList =null;
        if (language.equals("Chinese")) {
            emulationDetail = textboxInfoService.emulationDetail(start, end);
            resourceDTOList = BeanUtil.convert(emulationDetail, ResourceDTO.class);
            sum = textboxInfoService.sumTextbox("仿真工具");
        }else if (language.equals("English")){
            emulationDetail = textboxInfoService.enEmulationDetail(start, end);
            resourceDTOList = BeanUtil.convert(emulationDetail, ResourceDTO.class);
            sum = textboxInfoService.sumEnTextbox("仿真工具");
        }
        return APIResponse.success(resourceDTOList,sum);
    }

    @GetMapping("/require-data")
    public APIResponse data(@RequestParam(value="start") int start,
                            @RequestParam(value="end") int end,
                            @RequestParam(value = "languageType") String language){
        Integer sum =null;
        List<ResourceBO> dataDetail =null;
        List<ResourceDTO> resourceDTOList =null;
        if (language.equals("Chinese")) {
            dataDetail = textboxInfoService.dataDetail(start, end);
            resourceDTOList = BeanUtil.convert(dataDetail, ResourceDTO.class);
            sum = textboxInfoService.sumTextbox("数据集");
        }else if (language.equals("English")){
            dataDetail = textboxInfoService.enDataDetail(start, end);
            resourceDTOList = BeanUtil.convert(dataDetail, ResourceDTO.class);
            sum = textboxInfoService.sumEnTextbox("数据集");
        }
        return APIResponse.success(resourceDTOList,sum);
    }


    /*@GetMapping("download/{fileName}")
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
    }*/

    @GetMapping("download/{path}/{fileName}")
    public void download(@PathVariable String path, HttpServletResponse response, @PathVariable String fileName) {
        path = fileService.loadFileAsResource(path+"/"+fileName);
        try {
            // path是指想要下载的文件的路径
            File file = new File(path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
