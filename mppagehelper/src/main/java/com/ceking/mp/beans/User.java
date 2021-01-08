package com.ceking.mp.beans;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
@TableName("t_user")
public class User extends Model<User> {
	private Integer id;
	//自动填充
	@TableField(fill=FieldFill.INSERT_UPDATE)
	private String name;
	//逻辑删除属性
	@TableLogic
	private Integer status;
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	@Override
	protected Serializable pkVal() {
		return id;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status + "]";
	}


}
