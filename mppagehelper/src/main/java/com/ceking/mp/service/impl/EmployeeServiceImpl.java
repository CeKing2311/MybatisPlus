package com.ceking.mp.service.impl;

import com.ceking.mp.beans.Employee;
import com.ceking.mp.mapper.EmployeeMapper;
import com.ceking.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjq
 * @since 2021-01-07
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
	
}
