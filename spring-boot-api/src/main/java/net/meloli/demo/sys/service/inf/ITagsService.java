package net.meloli.demo.sys.service.inf;

import com.github.pagehelper.PageInfo;
import net.meloli.demo.sys.entity.Tag;
import net.meloli.demo.sys.util.MvcDataDto;

import java.util.List;

public interface ITagsService {

    /**
     * 获取标签集合
     * @param param
     * @exception Exception
     * @return
     */
    PageInfo<Tag> getTags(MvcDataDto param) throws Exception;

    /**
     * 获取所有的标签集合
     * 先获取Redis内的
     * 再获取数据库内的
     * @return
     * @throws Exception
     */
    List<Tag> getTags() throws Exception;

    /**
     * 添加一个或多个标签
     * @param tags
     * @return
     */
    MvcDataDto addTags(List<Tag> tags) throws Exception;
}
