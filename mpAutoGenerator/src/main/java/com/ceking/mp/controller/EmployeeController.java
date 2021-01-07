package com.ceking.mp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ceking.mp.beans.Employee;
import com.ceking.mp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjq
 * @since 2021-01-07
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public String login() {
		Employee employee = employeeService.selectById(1);
		
		return "";
	}
}

