package net.meloli.demo.sys.service.inf;

import com.github.pagehelper.PageInfo;
import net.meloli.demo.sys.entity.Tag;
import net.meloli.demo.sys.util.MvcDataDto;

public interface ITagsService {

    /**
     * 获取标签集合
     * @param param
     * @exception Exception
     * @return
     */
    PageInfo<Tag> getTags(MvcDataDto param) throws Exception;
}
