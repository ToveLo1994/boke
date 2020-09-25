package com.wwh.boke.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* @Description:    Mybatis-plus 类配置文件
* @Author:         wangwenhu
* @CreateDate:     2020/9/25  15:23
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/25  15:23
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@Configuration
public class MybatisConfig {

    /**
    * Mybatis-plus 分页插件
    * @author      wangwenhu
    * @param
    * @return      分页插件
    * @exception
    * @date        2020/9/25  15:28
    */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
    * sql分析插件
    * @author      wangwenhu
    * @param
    * @return
    * @exception
    * @date        2020/9/25  15:29
    */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

}
