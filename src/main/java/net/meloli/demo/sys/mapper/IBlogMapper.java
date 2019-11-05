package net.meloli.demo.sys.mapper;

import net.meloli.demo.sys.dto.BlogSearchConditionDTO;
import net.meloli.demo.sys.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName IBlogMapper
 * @Description TODO
 * @Author LiRETRO
 * @Date 2019/11/4 9:51 上午
 * @Version 1.0
 **/
@Component
public interface IBlogMapper {

    /**
     * 插入Blog
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     * 插入所有的Blog
     * @param blogList
     * @return
     */
    int insertAll(List<Blog> blogList);

    /**
     * 分页获取博客
     * @param blogSearchConditionDTO
     * @return
     */
    List<Blog> getBlogList(@Param("blog") BlogSearchConditionDTO blogSearchConditionDTO);

    /**
     * 通过当前博客Id获取上一篇/下一篇文章
     * @param blogId
     * @return
     */
    List<Blog> getPrevAndNext(@Param("blogId") String blogId);
}
