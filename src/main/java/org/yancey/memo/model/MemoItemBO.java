/******************************************************************************
* Copyright (C) 2014 ShenZhen ComTop Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
*****************************************************************************/

package org.yancey.memo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 备忘事项
 * @author  杨赛
 * @since   jdk1.7
 * @version 2018年1月18日 杨赛
 */
@Entity
@Table(name = "memo_item")
public class MemoItemBO {
	 private int id;
	 private String name;
	 private String description;
	 
	 
	/**
	 * @return 获取 id属性值
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	/**
	 * @param id 设置 id 属性值为参数值 id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return 获取 name属性值
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 设置 name 属性值为参数值 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 获取 description属性值
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description 设置 description 属性值为参数值 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
