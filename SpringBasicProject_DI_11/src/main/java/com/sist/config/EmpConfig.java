package com.sist.config;
import java.util.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.sist.dao.EmpDAO2;

import io.opentelemetry.sdk.resources.Resource;

@Configuration
@ComponentScan(basePackages = )
public class EmpConfig {
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org");
		ds.setUrl("");
		ds.setUsername("");
		ds.setPassword("");
		return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		ssf.setDataSource(datasource());
		return ssf.getObject();
	}
	
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean(){
		MapperFactoryBean mapper=new MapperFactoryBean();
		try {
			mapper.setSqlSessionFactory(sqlSessionFactory());
			mapper.setMapperInterface(com.sist.mapper.EmpMapper.class);
		}catch (Exception ex) {
			// TODO: handle exception
		}
		return mapper;
	}
	
	
}
