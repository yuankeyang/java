package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 专家类型对照表,字段意义见其配置文件
 * ExpeTypeComp entity. @author MyEclipse Persistence Tools
 */

public class ExpeTypeComp implements java.io.Serializable {

	// Fields

	private Integer expeTypeId;
	private String expeTypeName;
	private Set expeTypes = new HashSet(0);
	private Set expeServPrics = new HashSet(0);
	private Set expeServOrdes = new HashSet(0);
	private Set membConsInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExpeTypeComp() {
	}

	/** minimal constructor */
	public ExpeTypeComp(String expeTypeName) {
		this.expeTypeName = expeTypeName;
	}

	/** full constructor */
	public ExpeTypeComp(String expeTypeName, Set expeTypes, Set expeServPrics,
			Set expeServOrdes, Set membConsInfos) {
		this.expeTypeName = expeTypeName;
		this.expeTypes = expeTypes;
		this.expeServPrics = expeServPrics;
		this.expeServOrdes = expeServOrdes;
		this.membConsInfos = membConsInfos;
	}

	// Property accessors

	public Integer getExpeTypeId() {
		return this.expeTypeId;
	}

	public void setExpeTypeId(Integer expeTypeId) {
		this.expeTypeId = expeTypeId;
	}

	public String getExpeTypeName() {
		return this.expeTypeName;
	}

	public void setExpeTypeName(String expeTypeName) {
		this.expeTypeName = expeTypeName;
	}

	public Set getExpeTypes() {
		return this.expeTypes;
	}

	public void setExpeTypes(Set expeTypes) {
		this.expeTypes = expeTypes;
	}

	public Set getExpeServPrics() {
		return this.expeServPrics;
	}

	public void setExpeServPrics(Set expeServPrics) {
		this.expeServPrics = expeServPrics;
	}

	public Set getExpeServOrdes() {
		return this.expeServOrdes;
	}

	public void setExpeServOrdes(Set expeServOrdes) {
		this.expeServOrdes = expeServOrdes;
	}

	public Set getMembConsInfos() {
		return this.membConsInfos;
	}

	public void setMembConsInfos(Set membConsInfos) {
		this.membConsInfos = membConsInfos;
	}

}