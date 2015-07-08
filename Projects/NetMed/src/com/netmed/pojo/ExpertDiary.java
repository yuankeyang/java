package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家日记表,字段意义见其配置文件
 * ExpertDiary entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpertDiary implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private String title;
	private String thesis;
	private String content;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public ExpertDiary() {
	}

	/** full constructor */
	public ExpertDiary(ExpeRegi expeRegi, String title, String thesis,
			String content, Timestamp date) {
		this.expeRegi = expeRegi;
		this.title = title;
		this.thesis = thesis;
		this.content = content;
		this.date = date;
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

	public String getThesis() {
		return this.thesis;
	}

	public void setThesis(String thesis) {
		this.thesis = thesis;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}