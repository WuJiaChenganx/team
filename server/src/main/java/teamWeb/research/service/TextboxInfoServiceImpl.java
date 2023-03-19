package teamWeb.research.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.mapper.TextboxInfoMapper;
import teamWeb.research.pojo.*;
import teamWeb.resource.pojo.ResourceBO;
import teamWeb.teamDynamics.pojo.NoticeBO;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.utils.Address;
import teamWeb.utils.BeanUtil;

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
    public List<ProjectBO> projectDetail(int start, int end) {

        return BeanUtil.convert(textboxInfoMapper.getProject(start,end-start),ProjectBO.class);
    }


    @Override
    public List<DirectionsDTO> direDetail(int start, int end) {
        List<DirectionsBO> directionsBOList = BeanUtil.convert(textboxInfoMapper.getDire(start,end-start),DirectionsBO.class);

        for (DirectionsBO directionsBO:
                directionsBOList) {
            directionsBO.setPicUrl(Address.rootAddress()+directionsBO.getPictureUrl());
            directionsBO.setInfo(directionsBO.getText());

        }
        return BeanUtil.convert(directionsBOList,DirectionsDTO.class);
    }

    @Override
    public List<PlatformDTO> platformDetail(int start, int end) {
        List<PlatformBO> platformBOList = BeanUtil.convert(textboxInfoMapper.getPlatform(start,end-start),PlatformBO.class);
        for (PlatformBO platformBO:
                platformBOList) {
            platformBO.setInfoTitle(platformBO.getTitle());
            platformBO.setInfoDetail(platformBO.getText());
        }

        return BeanUtil.convert(platformBOList,PlatformDTO.class);
    }

    @Override
    public List<CoursePageBO> teachDetail() {
        List<CoursePageBO> CoursePageBOList = textboxInfoMapper.teachDetail();
        for (CoursePageBO coursePageBO:
                CoursePageBOList) {
            Integer courseId = coursePageBO.getId();
            coursePageBO.setCourseList(textboxInfoMapper.allCourse(courseId));
        }
        return CoursePageBOList;
    }


    @Override
    public List<ResourceBO> emulationDetail(int start, int end) {
        List<ResourceBO> resourceBOList = BeanUtil.convert(textboxInfoMapper.getEmulation(start,end-start),ResourceBO.class);
        for (ResourceBO resourceBO:
                resourceBOList) {
            resourceBO.setDetail(resourceBO.getText());
            resourceBO.setText("");
        }
        return resourceBOList;
    }

    @Override
    public List<ResourceBO> dataDetail(int start, int end) {
        List<ResourceBO> resourceBOList = BeanUtil.convert(textboxInfoMapper.getData(start,end-start),ResourceBO.class);
        for (ResourceBO resourceBO:
                resourceBOList) {
            resourceBO.setDetail(resourceBO.getText());
            resourceBO.setText("");
        }
        return resourceBOList;
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

    @Override
    public Integer sumProject() {
        return textboxInfoMapper.sumProject();
    }

    @Override
    public Integer sumTextbox(String type) {
        return textboxInfoMapper.sumTextbox(type);
    }

}
