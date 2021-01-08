package com.ceking.mp.mapper;

import com.ceking.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjq
 * @since 2021-01-07
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
	
	int deleteAll();
}
