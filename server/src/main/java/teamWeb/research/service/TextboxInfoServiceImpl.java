package teamWeb.research.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.mapper.TextboxInfoMapper;

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

    @Override
    public void insertInfo(TextboxInfo textboxInfo) {
        textboxInfoMapper.insertInfo(textboxInfo);
    }

    @Override
    public void updateInfo(TextboxInfo textboxInfo) {
        textboxInfoMapper.updateInfo(textboxInfo);
    }

    @Override
    public void deleteInfo(TextboxInfo textboxInfo) {
        textboxInfoMapper.deleteInfo(textboxInfo.getId());
    }

}