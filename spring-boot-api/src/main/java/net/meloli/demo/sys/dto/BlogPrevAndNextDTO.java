package net.meloli.demo.sys.dto;

import lombok.Data;
import net.meloli.demo.sys.entity.Blog;

/**
 * @ClassName BlogPrevAndNextDTO
 * @Description TODO
 * @Author LiRETRO
 * @Date 2019/11/1 2:51 下午
 * @Version 1.0
 **/
@Data
public class BlogPrevAndNextDTO {

    private Blog prev;
    private Blog next;
}
