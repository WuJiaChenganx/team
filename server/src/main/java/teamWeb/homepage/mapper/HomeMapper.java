package teamWeb.homepage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.homepage.pojo.PageViewDO;
import teamWeb.research.entity.TextboxInfo;

public interface HomeMapper extends BaseMapper<PageViewDO>{
    void addPageView();

    Integer pageViewCount();
}
