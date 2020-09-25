package com.wwh.boke.entity;

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
 * 博客类别表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogCategory implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客类别id
     */
    @TableId("category_id")
    private Integer categoryId;

    /**
     * 博客类别名称
     */
    @TableField("category_name")
    private String categoryName;

    /**
     * 博客图标
     */
    @TableField("category_icon")
    private String categoryIcon;

    /**
     * 博客类别权重
     */
    @TableField("category_rank")
    private Integer categoryRank;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 逻辑删除： 0--> 未删除， 1-->删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


}
