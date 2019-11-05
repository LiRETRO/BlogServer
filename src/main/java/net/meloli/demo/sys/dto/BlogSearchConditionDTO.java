package net.meloli.demo.sys.dto;

import lombok.Data;

/**
 * 博客查询条件DTO
 * @author LiRETRO
 */
@Data
public class BlogSearchConditionDTO {

    /**
     * 0 简单搜索 1 完全搜索
     * 如果不传则默认为1
     */
    private Integer searchType;
}
