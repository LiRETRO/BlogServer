package net.meloli.demo.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.meloli.demo.sys.entity.Tag;
import net.meloli.demo.sys.mapper.ITagsMapper;
import net.meloli.demo.sys.service.inf.ITagsService;
import net.meloli.demo.sys.util.MvcDataDto;
import net.meloli.demo.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TagsServiceImpl implements ITagsService {

    @Autowired
    ITagsMapper tagsMapper;

    /**
     * 获取标签集合
     *
     * @param param
     *
     * @return
     *
     * @throws Exception
     */
    @Override
    public PageInfo<Tag> getTags(MvcDataDto param) throws Exception {
        Page page = param.getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Tag> tags = tagsMapper.getTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return pageInfo;
    }
}
