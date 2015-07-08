package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家日程表,字段意义见其配置文件
 * Schedule entity. @author MyEclipse Persistence Tools
 */

public class Schedule implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private String title;
	private String content;
	private Timestamp starttime;
	private Timestamp endtime;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	/** minimal constructor */
	public Schedule(ExpeRegi expeRegi, String title) {
		this.expeRegi = expeRegi;
		this.title = title;
	}

	/** full constructor */
	public Schedule(ExpeRegi expeRegi, String title, String content,
			Timestamp starttime, Timestamp endtime) {
		this.expeRegi = expeRegi;
		this.title = title;
		this.content = content;
		this.starttime = starttime;
		this.endtime = endtime;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

}