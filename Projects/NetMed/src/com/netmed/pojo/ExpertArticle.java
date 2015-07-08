package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家文章表,字段意义见其配置文件
 * ExpertArticle entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpertArticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private String title;
	private String type;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public ExpertArticle() {
	}

	/** full constructor */
	public ExpertArticle(ExpeRegi expeRegi, String title, String type,
			String content, Timestamp time) {
		this.expeRegi = expeRegi;
		this.title = title;
		this.type = type;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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