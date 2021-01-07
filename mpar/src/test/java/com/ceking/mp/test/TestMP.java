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
	 * 复杂分页
	 */
	@Test
	public void testARPage() {
		Employee employee =new Employee();
		Page<Employee> page = employee.selectPage(new Page<Employee>(1,3), new EntityWrapper<Employee>().like("last_name","j"));
		
		List<Employee> list = page.getRecords();
		for (Employee emp : list) {
			System.out.println(emp);
		}
		System.out.println(page.getPages());		
	}
	
	/**
	 * AR 更新操作
	 */
	@Test
	public void testUpdateAR() {
		Employee employee =new Employee();
		employee.setId(9);
		employee.setLastName("老宋");
		employee.setEmail("laosong@qq.com");
		employee.setAge(55);
		employee.setGender(1);
		boolean result = employee.updateById();
		System.out.println(result);
	}
	
	/**
	 * AR 插入操作
	 */
	@Test
	public void testInsertAR() {
		Employee employee =new Employee();
		employee.setLastName("老宋");
		employee.setEmail("song@qq.com");
		employee.setAge(28);
		employee.setGender(1);
		boolean result = employee.insert();
		System.out.println(result);
	}

}