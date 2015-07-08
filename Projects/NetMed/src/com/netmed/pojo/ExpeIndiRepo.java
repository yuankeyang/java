package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 专家个人知识库,字段意义见其配置文件
 * ExpeIndiRepo entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpeIndiRepo implements java.io.Serializable {

	// Fields

	private Integer repoId;
	private ExpeRegi expeRegi;
	private String presName;
	private String illnDesc;
	private String mediMateName;
	private String syndName;
	private String chinDiseName;
	private String westDiseName;
	private String presDetail;
	private String westMediName;
	private String others;
	private String folder;
	private String filenames;
	private Timestamp consTime;

	// Constructors

	/** default constructor */
	public ExpeIndiRepo() {
	}

	/** minimal constructor */
	public ExpeIndiRepo(ExpeRegi expeRegi, String presName, String illnDesc,
			Timestamp consTime) {
		this.expeRegi = expeRegi;
		this.presName = presName;
		this.illnDesc = illnDesc;
		this.consTime = consTime;
	}

	/** full constructor */
	public ExpeIndiRepo(ExpeRegi expeRegi, String presName, String illnDesc,
			String mediMateName, String syndName, String chinDiseName,
			String westDiseName, String presDetail, String westMediName,
			String others, String folder, String filenames, Timestamp consTime) {
		this.expeRegi = expeRegi;
		this.presName = presName;
		this.illnDesc = illnDesc;
		this.mediMateName = mediMateName;
		this.syndName = syndName;
		this.chinDiseName = chinDiseName;
		this.westDiseName = westDiseName;
		this.presDetail = presDetail;
		this.westMediName = westMediName;
		this.others = others;
		this.folder = folder;
		this.filenames = filenames;
		this.consTime = consTime;
	}

	// Property accessors

	public Integer getRepoId() {
		return this.repoId;
	}

	public void setRepoId(Integer repoId) {
		this.repoId = repoId;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public String getPresName() {
		return this.presName;
	}

	public void setPresName(String presName) {
		this.presName = presName;
	}

	public String getIllnDesc() {
		return this.illnDesc;
	}

	public void setIllnDesc(String illnDesc) {
		this.illnDesc = illnDesc;
	}

	public String getMediMateName() {
		return this.mediMateName;
	}

	public void setMediMateName(String mediMateName) {
		this.mediMateName = mediMateName;
	}

	public String getSyndName() {
		return this.syndName;
	}

	public void setSyndName(String syndName) {
		this.syndName = syndName;
	}

	public String getChinDiseName() {
		return this.chinDiseName;
	}

	public void setChinDiseName(String chinDiseName) {
		this.chinDiseName = chinDiseName;
	}

	public String getWestDiseName() {
		return this.westDiseName;
	}

	public void setWestDiseName(String westDiseName) {
		this.westDiseName = westDiseName;
	}

	public String getPresDetail() {
		return this.presDetail;
	}

	public void setPresDetail(String presDetail) {
		this.presDetail = presDetail;
	}

	public String getWestMediName() {
		return this.westMediName;
	}

	public void setWestMediName(String westMediName) {
		this.westMediName = westMediName;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
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

	public Timestamp getConsTime() {
		return this.consTime;
	}

	public void setConsTime(Timestamp consTime) {
		this.consTime = consTime;
	}

}