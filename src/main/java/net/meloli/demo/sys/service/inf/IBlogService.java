package net.meloli.demo.sys.service.inf;

import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.util.MvcDataDto;

public interface IBlogService {

    /**
     * 获取博客列表
     * @return MvcDataDto
     */
    MvcDataDto getBlogList();

    /**
     * 添加博客
     * @return
     */
    MvcDataDto addBlog(Blog blog);

    /**
     * 通过ID获取博客详情
     * @param id
     * @return
     */
    MvcDataDto getBlogDetail(String id);
}
