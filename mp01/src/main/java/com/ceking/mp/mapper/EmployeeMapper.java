package com.ceking.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ceking.mp.beans.Employee;

/**
 * 基于Mybatis：在mapper中编写CRUD方法，提供mapper接口对应的sql映射 文件
 * 基于MybayisPlus，只需要继承baseMapper接口即可
 * @author cjq
 *
 */

public interface EmployeeMapper extends BaseMapper<Employee> {
	
}
