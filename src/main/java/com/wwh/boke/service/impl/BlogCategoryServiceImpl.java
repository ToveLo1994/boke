package com.wwh.boke.service.impl;

import com.wwh.boke.entity.BlogCategory;
import com.wwh.boke.dao.BlogCategoryMapper;
import com.wwh.boke.service.BlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客类别表 服务实现类
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

}
