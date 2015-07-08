package com.netmed.pojo;

/**
 * 医学知识表,字段意义见其配置文件
 * MediKnow entity. @author MyEclipse Persistence Tools
 */

public class MediKnow implements java.io.Serializable {

	// Fields

	private Integer mediKnowId;
	private SympSyno sympSyno;
	private ChinDiseSyno chinDiseSyno;
	private SyndSyno syndSyno;
	private WestDiseSyno westDiseSyno;
	private String knowCont;
	private String picture;
	private String video;
	private String source;
	private String provider;

	// Constructors

	/** default constructor */
	public MediKnow() {
	}

	/** minimal constructor */
	public MediKnow(String knowCont) {
		this.knowCont = knowCont;
	}

	/** full constructor */
	public MediKnow(SympSyno sympSyno, ChinDiseSyno chinDiseSyno,
			SyndSyno syndSyno, WestDiseSyno westDiseSyno, String knowCont,
			String picture, String video, String source, String provider) {
		this.sympSyno = sympSyno;
		this.chinDiseSyno = chinDiseSyno;
		this.syndSyno = syndSyno;
		this.westDiseSyno = westDiseSyno;
		this.knowCont = knowCont;
		this.picture = picture;
		this.video = video;
		this.source = source;
		this.provider = provider;
	}

	// Property accessors

	public Integer getMediKnowId() {
		return this.mediKnowId;
	}

	public void setMediKnowId(Integer mediKnowId) {
		this.mediKnowId = mediKnowId;
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

	public SyndSyno getSyndSyno() {
		return this.syndSyno;
	}

	public void setSyndSyno(SyndSyno syndSyno) {
		this.syndSyno = syndSyno;
	}

	public WestDiseSyno getWestDiseSyno() {
		return this.westDiseSyno;
	}

	public void setWestDiseSyno(WestDiseSyno westDiseSyno) {
		this.westDiseSyno = westDiseSyno;
	}

	public String getKnowCont() {
		return this.knowCont;
	}

	public void setKnowCont(String knowCont) {
		this.knowCont = knowCont;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}