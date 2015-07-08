package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家推荐表,字段意义见其配置文件
 * RefePeer entity. @author MyEclipse Persistence Tools
 */

public class RefePeer implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private String expeName;
	private Timestamp refeTime;
	private Boolean state;

	// Constructors

	/** default constructor */
	public RefePeer() {
	}

	/** full constructor */
	public RefePeer(ExpeRegi expeRegi, String expeName, Timestamp refeTime,
			Boolean state) {
		this.expeRegi = expeRegi;
		this.expeName = expeName;
		this.refeTime = refeTime;
		this.state = state;
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

	public String getExpeName() {
		return this.expeName;
	}

	public void setExpeName(String expeName) {
		this.expeName = expeName;
	}

	public Timestamp getRefeTime() {
		return this.refeTime;
	}

	public void setRefeTime(Timestamp refeTime) {
		this.refeTime = refeTime;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}