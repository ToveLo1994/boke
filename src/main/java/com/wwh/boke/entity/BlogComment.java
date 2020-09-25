package com.wwh.boke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客评论信息表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogComment implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 评论的博客ID
     */
    @TableField("blog_id")
    private Integer blogId;

    /**
     * 评论人的昵称
     */
    @TableField("commentator")
    private String commentator;

    /**
     * 评论人的邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 评论的网页URL
     */
    @TableField("web_url")
    private String webUrl;

    /**
     * 评论内容
     */
    @TableField("comment_body")
    private String commentBody;

    /**
     * 评论创建时间
     */
    @TableField("comment_create_time")
    private Date commentCreateTime;

    /**
     * 评论IP地址
     */
    @TableField("commentator_ip")
    private String commentatorIp;

    /**
     * 回复的评论ID
     */
    @TableField("reply_comment_id")
    private Integer replyCommentId;

    /**
     * 回复内容
     */
    @TableField("reply_body")
    private String replyBody;

    /**
     * 回复创建时间
     */
    @TableField("reply_create_time")
    private Date replyCreateTime;

    /**
     * 审核状态：0-->未通过审核；1-->通过审核
     */
    @TableField("comment_status")
    private Integer commentStatus;

    /**
     * 是否删除：0-->未删除；1-->删除
     */
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


}
