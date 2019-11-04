package net.meloli.demo.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.meloli.demo.sys.entity.Tag;
import net.meloli.demo.sys.mapper.ITagsMapper;
import net.meloli.demo.sys.service.inf.ITagsService;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import net.meloli.demo.sys.util.Page;
import net.meloli.demo.sys.util.RedisKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static net.meloli.demo.sys.util.RedisHelper.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class TagsServiceImpl implements ITagsService {

    @Autowired
    ITagsMapper tagsMapper;

    /**
     * 添加一个或多个标签
     *
     * @param tags
     * @return
     */
    @Override
    public MvcDataDto addTags(List<Tag> tags) throws Exception {
        MvcDataDto dataDto = MvcDataDto.getInstance();
        tags = tags.stream().filter(tag -> StringUtils.isEmpty(tag.getTagId())).peek(tag -> tag.setTagId(IdWorker.getId())).collect(Collectors.toList());
        tagsMapper.insertAll(tags);
        return dataDto;
    }

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
        List<Tag> tags = getTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return pageInfo;
    }

    /**
     * 获取所有的标签集合
     * 先获取Redis内的
     * 再获取数据库内的
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Tag> getTags() throws Exception {
        List<Tag> tags = getHashList(Tag.class, RedisKeyHolder.TAGS.getKey());
        if (CollectionUtils.isEmpty(tags)) {
            tags = tagsMapper.getTags();
            tags.stream().peek(tag -> setHashObj(RedisKeyHolder.TAGS.getKey(), tag.getTagId(), tag));
        }
        return tags;
    }
}
