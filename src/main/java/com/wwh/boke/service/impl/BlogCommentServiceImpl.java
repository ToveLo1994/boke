package com.wwh.boke.service.impl;

import com.wwh.boke.entity.BlogComment;
import com.wwh.boke.dao.BlogCommentMapper;
import com.wwh.boke.service.BlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客评论信息表 服务实现类
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

}
