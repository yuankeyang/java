package com.netmed.pojo;

/**
 * 疾病症状对照表,字段意义见其配置文件
 * DiseSympCont entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class DiseSympCont implements java.io.Serializable {

	// Fields

	private Integer id;
	private SympSyno sympSyno;
	private ChinDiseSyno chinDiseSyno;

	// Constructors

	/** default constructor */
	public DiseSympCont() {
	}

	/** full constructor */
	public DiseSympCont(SympSyno sympSyno, ChinDiseSyno chinDiseSyno) {
		this.sympSyno = sympSyno;
		this.chinDiseSyno = chinDiseSyno;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SympSyno getSympSyno() {
		return this.sympSyno;
	}

	public void setSympSyno(SympSyno sympSyno) {
		this.sympSyno = sympSyno;
	}

	public ChinDiseSyno getChinDiseSyno() {
		return this.chinDiseSyno;
	}

	public void setChinDiseSyno(ChinDiseSyno chinDiseSyno) {
		this.chinDiseSyno = chinDiseSyno;
	}

}