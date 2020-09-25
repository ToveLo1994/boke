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
 * 博客标签表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogTag implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客标签ID
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    /**
     * 标签名称
     */
    @TableField("tag_name")
    private String tagName;

    /**
     * 标签创建时间
     */
    @TableField("tag_create_time")
    private Date tagCreateTime;

    /**
     * 标签最后修改时间
     */
    @TableField("tag_update_time")
    private Date tagUpdateTime;

    /**
     * 是否删除：0-->未删除；1-->删除
     */
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


}
