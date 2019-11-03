package net.meloli.demo.sys.mapper;

import net.meloli.demo.sys.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ITagsMapper {

    /**
     * 插入单个数据
     * @param tag
     * @return
     */
    int insert(Tag tag);

    /**
     * 插入所有数据
     * @param tags
     * @return
     */
    int insertAll(List<Tag> tags);

    /**
     * 获取Tags
     * @return
     */
    List<Tag> getTags();
}
