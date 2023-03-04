package teamWeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.entity.RelationInfo;
import teamWeb.entity.TextboxInfo;
import teamWeb.mapper.TextboxInfoMapper;
import teamWeb.service.TextboxInfoService;

import java.util.List;
@Service
public class TextboxInfoServiceImpl extends ServiceImpl<TextboxInfoMapper, TextboxInfo> implements TextboxInfoService {

    @Autowired
    TextboxInfoMapper textboxInfoMapper;

    @Override
    public List<TextboxInfo> briefDetail() {
        return textboxInfoMapper.getBrief();
    }

    @Override
    public List<TextboxInfo> projectDetail(int start, int end) {
        return textboxInfoMapper.getProject(start,end);
    }

    @Override
    public List<TextboxInfo> projectedDetail(int start, int end) {
        return textboxInfoMapper.getProjected(start,end);
    }

    @Override
    public List<TextboxInfo> direDetail(int start, int end) {
        return textboxInfoMapper.getDire(start,end);
    }

    @Override
    public List<TextboxInfo> platformDetail(int start, int end) {
        return textboxInfoMapper.getPlatform(start,end);
    }

    @Override
    public List<TextboxInfo> teachDetail(int start, int end) {
        return textboxInfoMapper.getTeach(start,end);
    }


    @Override
    public List<TextboxInfo> emulationDetail(int start, int end) {
        return textboxInfoMapper.getEmulation(start,end);
    }

    @Override
    public List<TextboxInfo> dataDetail(int start, int end) {
        return textboxInfoMapper.getData(start,end);
    }


    @Override
    public List<RelationInfo> getRelation() {
        return textboxInfoMapper.getRelation();
    }

    @Override
    public List<TextboxInfo> getText(int id) {
        return textboxInfoMapper.getText(id);
    }

}
