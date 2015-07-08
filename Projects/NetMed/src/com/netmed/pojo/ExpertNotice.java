package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家公告表,字段意义见其配置文件
 * ExpertNotice entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpertNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public ExpertNotice() {
	}

	/** minimal constructor */
	public ExpertNotice(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public ExpertNotice(ExpeRegi expeRegi, String content, Timestamp time) {
		this.expeRegi = expeRegi;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}