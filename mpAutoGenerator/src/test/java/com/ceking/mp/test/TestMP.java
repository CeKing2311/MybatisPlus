package com.ceking.mp.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysql.cj.result.IntegerValueFactory;

public class TestMP {
	
	/**
	 * MP Generator
	 */
	@Test
	public void testGenerator() {
		//1.全局配置
		GlobalConfig config =new GlobalConfig();
		config.setActiveRecord(true) //是否支持AR模式
			   .setAuthor("cjq") //作者
			    .setOutputDir("D:\\JavaStudy\\Code\\MybatisPlus\\mpAutoGenerator\\src\\main\\java") //生成路径
			    .setFileOverride(true) //文件是否覆盖
			    .setIdType(IdType.AUTO)  //主键策略
			    .setServiceName("%sService")  //设置service接口的名字的首字母是否为I开始
			    .setBaseResultMap(true)  
			    .setBaseColumnList(true);		
			    
		//2.数据源配置
		DataSourceConfig sourceConfig =new  DataSourceConfig();
		sourceConfig
			.setDbType(DbType.MYSQL)
			.setDriverName("com.mysql.cj.jdbc.Driver")
			.setUrl("jdbc:mysql://localhost:3306/mybatisplus")
			.setUsername("root")
			.setPassword("Goldcommon13579");				
		//3.策略配置
		StrategyConfig strategyConfig =new StrategyConfig();
		strategyConfig
			.setCapitalMode(true) //全局大写命名
			.setDbColumnUnderline(true) //指定表名 字段名使用下划线
			.setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略
			.setTablePrefix("t_") //表名前缀
			.setInclude("t_employee"); //生成的表
		
		//4.包名策略配置
		PackageConfig packageConfig =new PackageConfig();
		packageConfig
			.setParent("com.ceking.mp")
			.setMapper("mapper")
			.setService("service")
			.setController("controller")
			.setEntity("beans")
			.setXml("mapper");					
		//5.整合配置
		AutoGenerator generator =new AutoGenerator();
		generator
			.setGlobalConfig(config)
			.setDataSource(sourceConfig)
			.setStrategy(strategyConfig)
			.setPackageInfo(packageConfig);			
		
		//执行		
		generator.execute();
	}
}
