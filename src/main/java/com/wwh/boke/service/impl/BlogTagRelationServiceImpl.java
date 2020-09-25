package com.wwh.boke.service.impl;

import com.wwh.boke.entity.BlogTagRelation;
import com.wwh.boke.dao.BlogTagRelationMapper;
import com.wwh.boke.service.BlogTagRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客标签文章关联表 服务实现类
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Service
public class BlogTagRelationServiceImpl extends ServiceImpl<BlogTagRelationMapper, BlogTagRelation> implements BlogTagRelationService {

}
