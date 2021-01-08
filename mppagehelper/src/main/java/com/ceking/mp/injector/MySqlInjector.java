package com.ceking.mp.injector;

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;

/**
 * 自定义全局操作
 * @author cjq
 *
 */
public class MySqlInjector extends AutoSqlInjector {
	
	/**
	 * 扩展inject方法完成自定义全局操作
	 */	
	@Override
	public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
			Class<?> modelClass, TableInfo table) {		
		//将自定义的deleteAll，处理成对应的MappedStatement对象，加入到configuration对象中		
		//1.sql语句
		String sql = "delete from "+table.getTableName();
		//2.注入的方法名,与接口中的方法名一致
		String method ="deleteAll";
		//3.构造SqlSource
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);		
		//4.构造删除的MappedStatement		
		this.addDeleteMappedStatement(mapperClass, method, sqlSource);				
	}
	
	
}
