package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 服务机构中心表,字段意义见其配置文件
 * ServInstCent entity. @author MyEclipse Persistence Tools
 */

public class ServInstCent implements java.io.Serializable {

	// Fields

	private String instId;
	private ServInstRegi servInstRegi;
	private String instName;
	private String instAddr;
	private String alipAcco;
	private String webLink;
	private String picture;
	private String videIntr;
	private Integer instRank;
	private String instLoggStat;
	private String custSati;
	private String prodList;
	private Set instServOrdes = new HashSet(0);

	// Constructors

	/** default constructor */
	public ServInstCent() {
	}

	/** minimal constructor */
	public ServInstCent(String instId, ServInstRegi servInstRegi,
			String instName, Integer instRank, String instLoggStat,
			String custSati) {
		this.instId = instId;
		this.servInstRegi = servInstRegi;
		this.instName = instName;
		this.instRank = instRank;
		this.instLoggStat = instLoggStat;
		this.custSati = custSati;
	}

	/** full constructor */
	public ServInstCent(String instId, ServInstRegi servInstRegi,
			String instName, String instAddr, String alipAcco, String webLink,
			String picture, String videIntr, Integer instRank,
			String instLoggStat, String custSati, String prodList,
			Set instServOrdes) {
		this.instId = instId;
		this.servInstRegi = servInstRegi;
		this.instName = instName;
		this.instAddr = instAddr;
		this.alipAcco = alipAcco;
		this.webLink = webLink;
		this.picture = picture;
		this.videIntr = videIntr;
		this.instRank = instRank;
		this.instLoggStat = instLoggStat;
		this.custSati = custSati;
		this.prodList = prodList;
		this.instServOrdes = instServOrdes;
	}

	// Property accessors

	public String getInstId() {
		return this.instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public ServInstRegi getServInstRegi() {
		return this.servInstRegi;
	}

	public void setServInstRegi(ServInstRegi servInstRegi) {
		this.servInstRegi = servInstRegi;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getInstAddr() {
		return this.instAddr;
	}

	public void setInstAddr(String instAddr) {
		this.instAddr = instAddr;
	}

	public String getAlipAcco() {
		return this.alipAcco;
	}

	public void setAlipAcco(String alipAcco) {
		this.alipAcco = alipAcco;
	}

	public String getWebLink() {
		return this.webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideIntr() {
		return this.videIntr;
	}

	public void setVideIntr(String videIntr) {
		this.videIntr = videIntr;
	}

	public Integer getInstRank() {
		return this.instRank;
	}

	public void setInstRank(Integer instRank) {
		this.instRank = instRank;
	}

	public String getInstLoggStat() {
		return this.instLoggStat;
	}

	public void setInstLoggStat(String instLoggStat) {
		this.instLoggStat = instLoggStat;
	}

	public String getCustSati() {
		return this.custSati;
	}

	public void setCustSati(String custSati) {
		this.custSati = custSati;
	}

	public String getProdList() {
		return this.prodList;
	}

	public void setProdList(String prodList) {
		this.prodList = prodList;
	}

	public Set getInstServOrdes() {
		return this.instServOrdes;
	}

	public void setInstServOrdes(Set instServOrdes) {
		this.instServOrdes = instServOrdes;
	}

}