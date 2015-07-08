package com.netmed.pojo;

/**
 * 症状证候对照表,字段意义见其配置文件
 * SyndSympCont entity. @author MyEclipse Persistence Tools
 */

public class SyndSympCont implements java.io.Serializable {

	// Fields

	private Integer syndSympId;
	private SympSyno sympSyno;
	private SyndSyno syndSyno;

	// Constructors

	/** default constructor */
	public SyndSympCont() {
	}

	/** full constructor */
	public SyndSympCont(SympSyno sympSyno, SyndSyno syndSyno) {
		this.sympSyno = sympSyno;
		this.syndSyno = syndSyno;
	}

	// Property accessors

	public Integer getSyndSympId() {
		return this.syndSympId;
	}

	public void setSyndSympId(Integer syndSympId) {
		this.syndSympId = syndSympId;
	}

	public SympSyno getSympSyno() {
		return this.sympSyno;
	}

	public void setSympSyno(SympSyno sympSyno) {
		this.sympSyno = sympSyno;
	}

	public SyndSyno getSyndSyno() {
		return this.syndSyno;
	}

	public void setSyndSyno(SyndSyno syndSyno) {
		this.syndSyno = syndSyno;
	}

}