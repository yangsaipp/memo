/******************************************************************************
* Copyright (C) 2014 ShenZhen ComTop Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
*****************************************************************************/

package org.yancey.memo.model;

import java.sql.Timestamp;

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
	 
	 /** 事项主题*/
	 private String name;
	 
	 private String description;
	 
	 private String projectTeam;
	 
	 private Timestamp planStartTime;
	 
	 private Timestamp planEndTime;
	 
	 private Timestamp startTime;
	 
	 private Timestamp endTime;
	 
	 /** 状态：0未开始、1进行中、2已完成、 3放弃*/
	 private String status;
	 
	 private Timestamp createTime;
	 
	 
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
	
	/**
	 * @return 获取 planStartTime属性值
	 */
	public Timestamp getPlanStartTime() {
		return planStartTime;
	}
	
	/**
	 * @param planStartTime 设置 planStartTime 属性值为参数值 planStartTime
	 */
	public void setPlanStartTime(Timestamp planStartTime) {
		this.planStartTime = planStartTime;
	}
	/**
	 * @return 获取 planEndTime属性值
	 */
	public Timestamp getPlanEndTime() {
		return planEndTime;
	}
	/**
	 * @param planEndTime 设置 planEndTime 属性值为参数值 planEndTime
	 */
	public void setPlanEndTime(Timestamp planEndTime) {
		this.planEndTime = planEndTime;
	}
	/**
	 * @return 获取 startTime属性值
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime 设置 startTime 属性值为参数值 startTime
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return 获取 endTime属性值
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime 设置 endTime 属性值为参数值 endTime
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return 获取 status属性值
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status 设置 status 属性值为参数值 status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return 获取 projectTeam属性值
	 */
	public String getProjectTeam() {
		return projectTeam;
	}
	/**
	 * @param projectTeam 设置 projectTeam 属性值为参数值 projectTeam
	 */
	public void setProjectTeam(String projectTeam) {
		this.projectTeam = projectTeam;
	}
	/**
	 * @return 获取 createTime属性值
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime 设置 createTime 属性值为参数值 createTime
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
