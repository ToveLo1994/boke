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
 * 博客友情链接表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogLink implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "link_id", type = IdType.AUTO)
    private Integer linkId;

    /**
     * 链接类别：0-->友情链接；1-->推荐网站；2-->个人网站
     */
    @TableField("link_type")
    private Integer linkType;

    /**
     * 链接名称
     */
    @TableField("link_name")
    private String linkName;

    /**
     * 链接url
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 链接描述
     */
    @TableField("link_description")
    private String linkDescription;

    /**
     * 链接权重(排序用)
     */
    @TableField("link_rank")
    private Integer linkRank;

    /**
     * 链接创建时间
     */
    @TableField("link_create_time")
    private Date linkCreateTime;

    /**
     * 链接最后修改时间
     */
    @TableField("link_update_time")
    private Date linkUpdateTime;

    /**
     * 是否删除：0-->未删除；1-->删除
     */
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


}
