package com.netmed.pojo;

/**
 * 养生治疗建议表,字段意义见其配置文件
 * RegiTreaReco entity. @author MyEclipse Persistence Tools
 */

public class RegiTreaReco implements java.io.Serializable {

	// Fields

	private Integer adviId;
	private SyndSyno syndSyno;
	private String dietotherapy;
	private String kinesitherapy;
	private String psychotherapy;
	private String mediEqui;

	// Constructors

	/** default constructor */
	public RegiTreaReco() {
	}

	/** minimal constructor */
	public RegiTreaReco(SyndSyno syndSyno) {
		this.syndSyno = syndSyno;
	}

	/** full constructor */
	public RegiTreaReco(SyndSyno syndSyno, String dietotherapy,
			String kinesitherapy, String psychotherapy, String mediEqui) {
		this.syndSyno = syndSyno;
		this.dietotherapy = dietotherapy;
		this.kinesitherapy = kinesitherapy;
		this.psychotherapy = psychotherapy;
		this.mediEqui = mediEqui;
	}

	// Property accessors

	public Integer getAdviId() {
		return this.adviId;
	}

	public void setAdviId(Integer adviId) {
		this.adviId = adviId;
	}

	public SyndSyno getSyndSyno() {
		return this.syndSyno;
	}

	public void setSyndSyno(SyndSyno syndSyno) {
		this.syndSyno = syndSyno;
	}

	public String getDietotherapy() {
		return this.dietotherapy;
	}

	public void setDietotherapy(String dietotherapy) {
		this.dietotherapy = dietotherapy;
	}

	public String getKinesitherapy() {
		return this.kinesitherapy;
	}

	public void setKinesitherapy(String kinesitherapy) {
		this.kinesitherapy = kinesitherapy;
	}

	public String getPsychotherapy() {
		return this.psychotherapy;
	}

	public void setPsychotherapy(String psychotherapy) {
		this.psychotherapy = psychotherapy;
	}

	public String getMediEqui() {
		return this.mediEqui;
	}

	public void setMediEqui(String mediEqui) {
		this.mediEqui = mediEqui;
	}

}