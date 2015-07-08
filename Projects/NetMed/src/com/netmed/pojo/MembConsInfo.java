package com.netmed.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 离线咨询表,字段意义见其配置文件
 * MembConsInfo entity. @author MyEclipse Persistence Tools
 */

public class MembConsInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer consId;
	private ExpeRegi expeRegi;
	private ExpeTypeComp expeTypeComp;
	private MembRegi membRegi;
	private Timestamp consTime;
	private String relationship;
	private String servType;
	private String illnDesc;
	private String folder;
	private String filenames;
	private String famiHist;
	private String persHist;
	private Timestamp replTime;
	private String diagResu;
	private String diagReco;
	private Boolean state;
	private Set chinDiagDises = new HashSet(0);
	private Set chinDiagSynds = new HashSet(0);

	// Constructors

	/** default constructor */
	public MembConsInfo() {
	}

	/** minimal constructor */
	public MembConsInfo(MembRegi membRegi, Timestamp consTime,
			String relationship) {
		this.membRegi = membRegi;
		this.consTime = consTime;
		this.relationship = relationship;
	}

	/** full constructor */
	public MembConsInfo(ExpeRegi expeRegi, ExpeTypeComp expeTypeComp,
			MembRegi membRegi, Timestamp consTime, String relationship,
			String servType, String illnDesc, String folder, String filenames,
			String famiHist, String persHist, Timestamp replTime,
			String diagResu, String diagReco, Boolean state, Set chinDiagDises,
			Set chinDiagSynds) {
		this.expeRegi = expeRegi;
		this.expeTypeComp = expeTypeComp;
		this.membRegi = membRegi;
		this.consTime = consTime;
		this.relationship = relationship;
		this.servType = servType;
		this.illnDesc = illnDesc;
		this.folder = folder;
		this.filenames = filenames;
		this.famiHist = famiHist;
		this.persHist = persHist;
		this.replTime = replTime;
		this.diagResu = diagResu;
		this.diagReco = diagReco;
		this.state = state;
		this.chinDiagDises = chinDiagDises;
		this.chinDiagSynds = chinDiagSynds;
	}

	// Property accessors

	public Integer getConsId() {
		return this.consId;
	}

	public void setConsId(Integer consId) {
		this.consId = consId;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public ExpeTypeComp getExpeTypeComp() {
		return this.expeTypeComp;
	}

	public void setExpeTypeComp(ExpeTypeComp expeTypeComp) {
		this.expeTypeComp = expeTypeComp;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public Timestamp getConsTime() {
		return this.consTime;
	}

	public void setConsTime(Timestamp consTime) {
		this.consTime = consTime;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getServType() {
		return this.servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
	}

	public String getIllnDesc() {
		return this.illnDesc;
	}

	public void setIllnDesc(String illnDesc) {
		this.illnDesc = illnDesc;
	}

	public String getFolder() {
		return this.folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getFilenames() {
		return this.filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public String getFamiHist() {
		return this.famiHist;
	}

	public void setFamiHist(String famiHist) {
		this.famiHist = famiHist;
	}

	public String getPersHist() {
		return this.persHist;
	}

	public void setPersHist(String persHist) {
		this.persHist = persHist;
	}

	public Timestamp getReplTime() {
		return this.replTime;
	}

	public void setReplTime(Timestamp replTime) {
		this.replTime = replTime;
	}

	public String getDiagResu() {
		return this.diagResu;
	}

	public void setDiagResu(String diagResu) {
		this.diagResu = diagResu;
	}

	public String getDiagReco() {
		return this.diagReco;
	}

	public void setDiagReco(String diagReco) {
		this.diagReco = diagReco;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set getChinDiagDises() {
		return this.chinDiagDises;
	}

	public void setChinDiagDises(Set chinDiagDises) {
		this.chinDiagDises = chinDiagDises;
	}

	public Set getChinDiagSynds() {
		return this.chinDiagSynds;
	}

	public void setChinDiagSynds(Set chinDiagSynds) {
		this.chinDiagSynds = chinDiagSynds;
	}

}