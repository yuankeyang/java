package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 证候表,字段意义见其配置文件
 * SyndSyno entity. @author MyEclipse Persistence Tools
 */

public class SyndSyno implements java.io.Serializable {

	// Fields

	private String syndId;
	private String syndName;
	private String syndType;
	private String synonymy;
	private Boolean ifStandard;
	private Set syndSympConts = new HashSet(0);
	private Set mediKnows = new HashSet(0);
	private Set regiTreaRecos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SyndSyno() {
	}

	/** minimal constructor */
	public SyndSyno(String syndId, String syndName, String syndType,
			Boolean ifStandard) {
		this.syndId = syndId;
		this.syndName = syndName;
		this.syndType = syndType;
		this.ifStandard = ifStandard;
	}

	/** full constructor */
	public SyndSyno(String syndId, String syndName, String syndType,
			String synonymy, Boolean ifStandard, Set syndSympConts,
			Set mediKnows, Set regiTreaRecos) {
		this.syndId = syndId;
		this.syndName = syndName;
		this.syndType = syndType;
		this.synonymy = synonymy;
		this.ifStandard = ifStandard;
		this.syndSympConts = syndSympConts;
		this.mediKnows = mediKnows;
		this.regiTreaRecos = regiTreaRecos;
	}

	// Property accessors

	public String getSyndId() {
		return this.syndId;
	}

	public void setSyndId(String syndId) {
		this.syndId = syndId;
	}

	public String getSyndName() {
		return this.syndName;
	}

	public void setSyndName(String syndName) {
		this.syndName = syndName;
	}

	public String getSyndType() {
		return this.syndType;
	}

	public void setSyndType(String syndType) {
		this.syndType = syndType;
	}

	public String getSynonymy() {
		return this.synonymy;
	}

	public void setSynonymy(String synonymy) {
		this.synonymy = synonymy;
	}

	public Boolean getIfStandard() {
		return this.ifStandard;
	}

	public void setIfStandard(Boolean ifStandard) {
		this.ifStandard = ifStandard;
	}

	public Set getSyndSympConts() {
		return this.syndSympConts;
	}

	public void setSyndSympConts(Set syndSympConts) {
		this.syndSympConts = syndSympConts;
	}

	public Set getMediKnows() {
		return this.mediKnows;
	}

	public void setMediKnows(Set mediKnows) {
		this.mediKnows = mediKnows;
	}

	public Set getRegiTreaRecos() {
		return this.regiTreaRecos;
	}

	public void setRegiTreaRecos(Set regiTreaRecos) {
		this.regiTreaRecos = regiTreaRecos;
	}

}