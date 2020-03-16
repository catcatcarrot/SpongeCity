package org.boot.city.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages= {"org.boot.city.mapper"},sqlSessionFactoryRef="sqlSessionFactory")
public class DruidConfig {
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean(name="dataSource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource")DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//指定mapper.xml路径
        //增加驼峰配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setTypeAliasesPackage("org.boot.city.entity");
        return bean.getObject();
	}
	
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
