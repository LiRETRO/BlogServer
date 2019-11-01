package net.meloli.demo.sys.mapper;

import net.meloli.demo.sys.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ITagsMapper {

    /**
     * 获取Tags
     * @return
     */
    List<Tag> getTags();
}
