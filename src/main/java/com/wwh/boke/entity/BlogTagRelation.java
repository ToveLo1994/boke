package com.wwh.boke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客标签文章关联表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogTagRelation implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 标签与文章关联表ID
     */
    @TableId(value = "relation_id", type = IdType.AUTO)
    private Integer relationId;

    /**
     * 博客文章ID
     */
    @TableField("blog_id")
    private Integer blogId;

    /**
     * 标签ID
     */
    @TableField("tag_id")
    private Integer tagId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除：0-->未删除；1-->删除；
     */
    @TableField("is_delete")
    private Integer isDelete;


}
