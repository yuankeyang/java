package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 养生顶级分类表,字段意义见其配置文件
 * RegiClasStru entity. @author MyEclipse Persistence Tools
 */

public class RegiClasStru implements java.io.Serializable {

	// Fields

	private String firsClasId;
	private String firsClasName;
	private Set dietClasStrus = new HashSet(0);

	// Constructors

	/** default constructor */
	public RegiClasStru() {
	}

	/** minimal constructor */
	public RegiClasStru(String firsClasId, String firsClasName) {
		this.firsClasId = firsClasId;
		this.firsClasName = firsClasName;
	}

	/** full constructor */
	public RegiClasStru(String firsClasId, String firsClasName,
			Set dietClasStrus) {
		this.firsClasId = firsClasId;
		this.firsClasName = firsClasName;
		this.dietClasStrus = dietClasStrus;
	}

	// Property accessors

	public String getFirsClasId() {
		return this.firsClasId;
	}

	public void setFirsClasId(String firsClasId) {
		this.firsClasId = firsClasId;
	}

	public String getFirsClasName() {
		return this.firsClasName;
	}

	public void setFirsClasName(String firsClasName) {
		this.firsClasName = firsClasName;
	}

	public Set getDietClasStrus() {
		return this.dietClasStrus;
	}

	public void setDietClasStrus(Set dietClasStrus) {
		this.dietClasStrus = dietClasStrus;
	}

}