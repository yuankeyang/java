package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 饮食分类结构表,字段意义见其配置文件
 * DietClasStru entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class DietClasStru implements java.io.Serializable {

	// Fields

	private String dietRegiId;
	private RegiClasStru regiClasStru;
	private String subClasName;
	private Set chinRegiComps = new HashSet(0);

	// Constructors

	/** default constructor */
	public DietClasStru() {
	}

	/** minimal constructor */
	public DietClasStru(String dietRegiId, RegiClasStru regiClasStru,
			String subClasName) {
		this.dietRegiId = dietRegiId;
		this.regiClasStru = regiClasStru;
		this.subClasName = subClasName;
	}

	/** full constructor */
	public DietClasStru(String dietRegiId, RegiClasStru regiClasStru,
			String subClasName, Set chinRegiComps) {
		this.dietRegiId = dietRegiId;
		this.regiClasStru = regiClasStru;
		this.subClasName = subClasName;
		this.chinRegiComps = chinRegiComps;
	}

	// Property accessors

	public String getDietRegiId() {
		return this.dietRegiId;
	}

	public void setDietRegiId(String dietRegiId) {
		this.dietRegiId = dietRegiId;
	}

	public RegiClasStru getRegiClasStru() {
		return this.regiClasStru;
	}

	public void setRegiClasStru(RegiClasStru regiClasStru) {
		this.regiClasStru = regiClasStru;
	}

	public String getSubClasName() {
		return this.subClasName;
	}

	public void setSubClasName(String subClasName) {
		this.subClasName = subClasName;
	}

	public Set getChinRegiComps() {
		return this.chinRegiComps;
	}

	public void setChinRegiComps(Set chinRegiComps) {
		this.chinRegiComps = chinRegiComps;
	}

}