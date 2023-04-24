package teamWeb.homepage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.homepage.pojo.PageViewDO;

public interface HomeService extends IService<PageViewDO> {
    Integer pageView();
}
