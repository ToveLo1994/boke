package com.wwh.boke.service.impl;

import com.wwh.boke.entity.BlogInfo;
import com.wwh.boke.dao.BlogInfoMapper;
import com.wwh.boke.service.BlogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客信息表 服务实现类
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo> implements BlogInfoService {

}
