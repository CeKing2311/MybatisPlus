package com.ceking.mp.metaobjecthandler;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * 自定义的公共字段填充处理器
 * 
 * @author cjq
 *
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

	/**
	 * 插入操作自动填充
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		// 获取到要被填充的字段的值
		Object fieldValObject = getFieldValByName("name", metaObject);
		if (fieldValObject == null) {
			System.out.println("插入操作满足填充条件");
			setFieldValByName("name", "插入填充的值", metaObject);
		}	

	}

	/**
	 * 更新操作自动填充
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		// 获取到要被填充的字段的值
		Object fieldValObject = getFieldValByName("name", metaObject);
		if (fieldValObject == null) {
			System.out.println("更新操作满足填充条件");
			setFieldValByName("name", "更新填充的值", metaObject);
		}
	}

}
