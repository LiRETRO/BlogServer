package net.meloli.demo.sys.service.inf;

import net.meloli.demo.sys.dto.VisitDto;

public interface IBlogRecordService {

    /**
     * 保存博客访问记录
     * @param visitDto
     * @return
     */
    boolean saveBlogVisitRecord(VisitDto visitDto);

}
