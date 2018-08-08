package com.myke.mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.myke.mybatis.utils.ContextDbMap;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author： zhangjianbin <br/>
 * ===============================
 * Created with IDEA.
 * Date： 2018/8/7
 * Time： 13:34
 * ================================
 */
@Configuration
public class Datasource {

    @Primary
    @Bean(name = "ds1")
    @ConfigurationProperties("spring.datasource.druid.one")// application.properteis中对应属性的前缀
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties("spring.datasource.druid.two")// application.properteis中对应属性的前缀
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Bean(name = "dynamicDS1")
    public DataSource dynamicDS1() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceOne());

        // 配置多数据源
//        Map<Object, Object> dsMap = new HashMap(5);
//        dsMap.put("ds1", dataSourceOne());
//        dsMap.put("ds2", dataSourceTwo());
//        dynamicDataSource.setTargetDataSources(dsMap);


        ContextDbMap.put("ds1", dataSourceOne());
        ContextDbMap.put("ds2", dataSourceTwo());
        dynamicDataSource.setTargetDataSources(ContextDbMap.getDsMap());

        return dynamicDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDS1());
        return factoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
        return template;
    }
}
