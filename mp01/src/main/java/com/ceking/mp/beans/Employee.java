package com.ceking.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


//@TableName value:指定数据库表名
//@TableName(value="t_employee")
public class Employee {
	//@TableId value:指定表中主键列的列名，type：主键策略	
	//@TableId(value="",type=IdType.AUTO)
	private Integer id;
	//指定数据库中字段对应的名字
	@TableField(value="last_name")
	private String lastName;
	private String email;
	private Integer gender;
	private Integer age;
	//设置在数据库中不存在的字段
	@TableField(exist=false)
	private Double salary;
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age="
				+ age + "]";
	}

}
