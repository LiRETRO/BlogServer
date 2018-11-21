package net.meloli.demo.sys.service.inf;

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
    MvcDataDto addBlog();
}
