package com.wwh.boke.service.impl;

import com.wwh.boke.entity.BlogConfig;
import com.wwh.boke.dao.BlogConfigMapper;
import com.wwh.boke.service.BlogConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客配置表 服务实现类
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Service
public class BlogConfigServiceImpl extends ServiceImpl<BlogConfigMapper, BlogConfig> implements BlogConfigService {

}
