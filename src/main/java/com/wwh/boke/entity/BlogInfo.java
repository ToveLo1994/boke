package com.wwh.boke.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客信息表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogInfo implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客文章ID
     */
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Integer blogId;

    /**
     * 博客文章标题
     */
    @TableField("blog_title")
    private String blogTitle;

    /**
     * 博客自定义url
     */
    @TableField("blog_url")
    private String blogUrl;

    /**
     * 博客文章前言
     */
    @TableField("blog_preface")
    private String blogPreface;

    /**
     * 博客文章内容
     */
    @TableField("blog_content")
    private String blogContent;

    /**
     * 博客分类ID
     */
    @TableField("blog_category_id")
    private String blogCategoryId;

    /**
     * 博客分类名称
     */
    @TableField("blog_category_name")
    private String blogCategoryName;

    /**
     * 博客标签名称
     */
    @TableField("blog_tags")
    private String blogTags;

    /**
     * 博客文章状态：0-->草稿；1-->发布
     */
    @TableField("blog_status")
    private Integer blogStatus;

    /**
     * 博客文章阅读量
     */
    @TableField("blog_views")
    private Integer blogViews;

    /**
     * 是否允许评论：0-->不允许；1-->允许
     */
    @TableField("blog_comment_status")
    private Integer blogCommentStatus;

    /**
     * 博客文章创建时间
     */
    @TableField("blog_create_time")
    private Date blogCreateTime;

    /**
     * 博客文章最后修改时间
     */
    @TableField("blog_update_time")
    private Date blogUpdateTime;

    /**
     * version 乐观锁
     */
    @TableField("version")
    @Version
    private Integer version;

    /**
     * 是否删除：0-->未删除；1-->删除
     */
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


}
