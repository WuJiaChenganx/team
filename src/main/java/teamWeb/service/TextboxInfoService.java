package teamWeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.entity.RelationInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.entity.TextboxInfo;

import java.util.List;

public interface TextboxInfoService extends IService<TextboxInfo> {

    List<TextboxInfo> briefDetail();

    List<TextboxInfo> projectDetail(int start, int end);


    List<TextboxInfo> projectedDetail(int start, int end);

    List<TextboxInfo> direDetail(int start, int end);

    List<TextboxInfo> platformDetail(int start, int end);

    List<TextboxInfo> teachDetail(int start, int end);

    List<TextboxInfo> emulationDetail(int start, int end);

    List<TextboxInfo> dataDetail(int start, int end);

    List<RelationInfo> getRelation();
}