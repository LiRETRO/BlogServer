package net.meloli.demo.sys.mapper;

import net.meloli.demo.sys.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface IAttachmentMapper {
    /**
     * 插入附件
     * @MethodName: insert
     * @Param: [attachment]
     * @Return: int
     * @Author: LiRETRO
     * @Date: 2019/11/8
    **/
    int insert(@Param("attachment") Attachment attachment);
}
