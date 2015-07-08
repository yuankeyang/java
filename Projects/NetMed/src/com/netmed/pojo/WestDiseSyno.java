package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 西医病名同义词表,字段意义见其配置文件
 * WestDiseSyno entity. @author MyEclipse Persistence Tools
 */

public class WestDiseSyno implements java.io.Serializable {

	// Fields

	private String westDiseId;
	private String westDiseName;
	private String westDiseClas;
	private String synonymy;
	private Set mediKnows = new HashSet(0);
	private Set chinWestConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public WestDiseSyno() {
	}

	/** minimal constructor */
	public WestDiseSyno(String westDiseId, String westDiseName,
			String westDiseClas) {
		this.westDiseId = westDiseId;
		this.westDiseName = westDiseName;
		this.westDiseClas = westDiseClas;
	}

	/** full constructor */
	public WestDiseSyno(String westDiseId, String westDiseName,
			String westDiseClas, String synonymy, Set mediKnows,
			Set chinWestConts) {
		this.westDiseId = westDiseId;
		this.westDiseName = westDiseName;
		this.westDiseClas = westDiseClas;
		this.synonymy = synonymy;
		this.mediKnows = mediKnows;
		this.chinWestConts = chinWestConts;
	}

	// Property accessors

	public String getWestDiseId() {
		return this.westDiseId;
	}

	public void setWestDiseId(String westDiseId) {
		this.westDiseId = westDiseId;
	}

	public String getWestDiseName() {
		return this.westDiseName;
	}

	public void setWestDiseName(String westDiseName) {
		this.westDiseName = westDiseName;
	}

	public String getWestDiseClas() {
		return this.westDiseClas;
	}

	public void setWestDiseClas(String westDiseClas) {
		this.westDiseClas = westDiseClas;
	}

	public String getSynonymy() {
		return this.synonymy;
	}

	public void setSynonymy(String synonymy) {
		this.synonymy = synonymy;
	}

	public Set getMediKnows() {
		return this.mediKnows;
	}

	public void setMediKnows(Set mediKnows) {
		this.mediKnows = mediKnows;
	}

	public Set getChinWestConts() {
		return this.chinWestConts;
	}

	public void setChinWestConts(Set chinWestConts) {
		this.chinWestConts = chinWestConts;
	}

}