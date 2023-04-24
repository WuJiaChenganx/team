package teamWeb.homepage.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.homepage.mapper.HomeMapper;
import teamWeb.homepage.pojo.PageViewDO;


@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, PageViewDO> implements HomeService{

    @Autowired
    HomeMapper homeMapper;
    @Override
    public Integer pageView() {
        homeMapper.addPageView();
        return homeMapper.pageViewCount();
    }
}
