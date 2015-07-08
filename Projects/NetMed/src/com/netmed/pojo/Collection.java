package com.netmed.pojo;

/**
 * 收藏表,字段意义见其配置文件
 * Collection entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class Collection implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private MembRegi membRegi;
	private Boolean state;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** minimal constructor */
	public Collection(ExpeRegi expeRegi, MembRegi membRegi) {
		this.expeRegi = expeRegi;
		this.membRegi = membRegi;
	}

	/** full constructor */
	public Collection(ExpeRegi expeRegi, MembRegi membRegi, Boolean state) {
		this.expeRegi = expeRegi;
		this.membRegi = membRegi;
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

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}