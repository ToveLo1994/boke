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
 * 博客配置表
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogConfig implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客配置字段名
     */
    @TableId("config_field")
    private String configField;

    /**
     * 配置名称
     */
    @TableField("config_name")
    private String configName;

    /**
     * 配置项的值
     */
    @TableField("config_value")
    private String configValue;

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
     * 是否删除：0-->未删除；1-->删除
     */
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


}
