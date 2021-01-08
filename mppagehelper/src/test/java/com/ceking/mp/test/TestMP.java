package com.ceking.mp.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.AbstractDocument.Content;

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
import com.ceking.mp.beans.Employee;
import com.ceking.mp.beans.User;
import com.ceking.mp.mapper.EmployeeMapper;
import com.ceking.mp.mapper.UserMapper;
import com.mysql.cj.result.IntegerValueFactory;

public class TestMP {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);
	UserMapper userMapper = context.getBean(UserMapper.class);

	/**
	 * 测试自动填充字段
	 */
	@Test
	public void testMetaObjectHandler() {
		User user=new User();
		user.setId(7);
		//user.setName("jack");
		user.setStatus(1);
		//userMapper.insert(user);
		userMapper.updateById(user);
		
	}
	
	
	/**
	 * 测试逻辑删除
	 */
	@Test
	public void testLogicDelete() {
		Integer count = userMapper.deleteById(1);
		System.out.println(count);		
	}
	
	/**
	 * 测试自定义全局操作
	 */
	public void testDeleteAll() {
		int count = employeeMapper.deleteAll();
		System.out.println("result:" + count);
	}

	/**
	 * 测试乐观锁插件 防止多个同时对同一条数据的操作
	 */
	@Test
	public void testOptimisticLocker() {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setLastName("苍老师");
		employee.setAge(18);
		employee.setVersion(1);

		employeeMapper.updateById(employee);
	}

	/**
	 * 测试性能分析插件
	 */
	@Test
	public void testPerformance() {
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setEmail("xiaowei@qq.com");
		employee.setGender("0");
		employee.setLastName("小薇");
		employeeMapper.insert(employee);
	}

	/**
	 * 测试SQL执行分析插件
	 */
	@Test
	public void testSqlExplain() {
		// 全表删除
		employeeMapper.delete(null);
	}

	/**
	 * 测试分页插件
	 */
	@Test
	public void testPage() {

		Page<Employee> page = new Page<>(1, 3);
		List<Employee> list = employeeMapper.selectPage(page, null);

		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println(page.getPages());
		System.out.println(page.getTotal());
		System.out.println(page.getSize());

	}
}
