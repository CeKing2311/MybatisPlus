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

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ceking.mp.beans.Employee;
import com.ceking.mp.mapper.EmployeeMapper;
import com.mysql.cj.result.IntegerValueFactory;

public class TestMP {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

	private EmployeeMapper employeeMapper = ioc.getBean(EmployeeMapper.class);

	/**
	 * 测试Condition条件构造器
	 */
	@Test
	public void testCondition() {
		List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1, 2),
				Condition.create().between("age", 18, 40));
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * 测试条件构造器EntityWrapper
	 */
	@Test
	public void testWrapper() {

		/*
		 * EntityWrapper<Employee> wrapper =new EntityWrapper<Employee>();
		 * wrapper.between("age", 18, 50); wrapper.eq("gender", 1);
		 * wrapper.eq("last_name", "tom"); List<Employee> list =
		 * employeeMapper.selectPage(new Page<Employee>(1, 2), wrapper); for
		 * (Employee employee : list) { System.out.println(employee); }
		 */
		// 查询性别为女并且 名字带有"j"或者邮箱带有"a"
		/*
		 * List<Employee> list = employeeMapper.selectList( new
		 * EntityWrapper<Employee>().eq("gender", 1).like("last_name", "j")
		 * .or() //.orNew() .like("email", "a"));
		 */
		// 测试排序
		List<Employee> list = employeeMapper
				.selectList(new EntityWrapper<Employee>().eq("gender", 1).orderDesc(Arrays.asList("age")));

		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

	/**
	 * 测试查询操作
	 */
	@Test
	public void testSelect() {
		/*
		 * List<Integer> list =new ArrayList<Integer>(); list.add(1);
		 * list.add(2); list.add(4); list.add(6); List<Employee> listEmp =
		 * employeeMapper.selectBatchIds(list); for (Employee employee :
		 * listEmp) { System.out.println(employee); }
		 */

		// 分页查询
		/*
		 * Page page=new Page<>(1, 2, "id"); List<Employee> list =
		 * employeeMapper.selectPage(page, null); for (Employee employee : list)
		 * { System.out.println(employee); }
		 */

	}

	/**
	 * 测试更新操作
	 */
	@Test
	public void testUpdate() {
		Employee employee = new Employee(8, "Amiza", "Amiza@qq.com", 1, 32);
		// Integer count = employeeMapper.update(employee, null);
		Integer count = employeeMapper.updateById(employee);
		System.out.println(count);
	}

	/**
	 * 测试插入操作
	 */
	@Test
	public void testInsert() {
		Employee employee = new Employee(null, "Amiza", "Amiza@qq.com", 1, 28);
		Integer count = employeeMapper.insert(employee);
		// 全字段插入
		// employeeMapper.insertAllColumn(employee);
		System.out.println(count);
		Integer id = employee.getId();
		System.out.println(id);
	}

	@Test
	public void testDataSource() throws Exception {
		DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
