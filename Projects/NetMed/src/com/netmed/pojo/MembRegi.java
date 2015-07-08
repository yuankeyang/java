package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 会员注册表,字段意义见其配置文件
 * MembRegi entity. @author MyEclipse Persistence Tools
 */

public class MembRegi implements java.io.Serializable {

	// Fields

	private String membId;
	private String realName;
	private String membPass;
	private Boolean membSex;
	private String membEmai;
	private Integer rank;
	private Integer credit;
	private Long money;
	private String headImg;
	private String phonNumb;
	private Boolean state;
	private Set memberArticles = new HashSet(0);
	private Set expeServOrdes = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set sleepRecordses = new HashSet(0);
	private Set memberAppointments = new HashSet(0);
	private Set membArchInfos = new HashSet(0);
	private Set blooPreses = new HashSet(0);
	private Set membFamis = new HashSet(0);
	private Set membConsInfos = new HashSet(0);
	private Set chats = new HashSet(0);

	// Constructors

	/** default constructor */
	public MembRegi() {
	}

	public MembRegi(String membId) {
		this.membId=membId;
	}

	/** minimal constructor */
	public MembRegi(String membId, String membPass, Boolean membSex,
			String membEmai) {
		this.membId = membId;
		this.membPass = membPass;
		this.membSex = membSex;
		this.membEmai = membEmai;
	}
	
	public MembRegi(String membId, String membPass, Boolean membSex,
			String membEmai, Integer rank, Integer credit, Long money) {
		this.membId = membId;
		this.membPass = membPass;
		this.membSex = membSex;
		this.membEmai = membEmai;
		this.rank = rank;
		this.credit = credit;
		this.money = money;
	}


	/** full constructor */
	public MembRegi(String membId, String realName, String membPass,
			Boolean membSex, String membEmai, Integer rank, Integer credit,
			Long money, String headImg, String phonNumb, Boolean state,
			Set memberArticles, Set expeServOrdes, Set collections,
			Set sleepRecordses, Set memberAppointments, Set membArchInfos,
			Set blooPreses, Set membFamis, Set membConsInfos, Set chats) {
		this.membId = membId;
		this.realName = realName;
		this.membPass = membPass;
		this.membSex = membSex;
		this.membEmai = membEmai;
		this.rank = rank;
		this.credit = credit;
		this.money = money;
		this.headImg = headImg;
		this.phonNumb = phonNumb;
		this.state = state;
		this.memberArticles = memberArticles;
		this.expeServOrdes = expeServOrdes;
		this.collections = collections;
		this.sleepRecordses = sleepRecordses;
		this.memberAppointments = memberAppointments;
		this.membArchInfos = membArchInfos;
		this.blooPreses = blooPreses;
		this.membFamis = membFamis;
		this.membConsInfos = membConsInfos;
		this.chats = chats;
	}

	// Property accessors

	public String getMembId() {
		return this.membId;
	}

	public void setMembId(String membId) {
		this.membId = membId;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMembPass() {
		return this.membPass;
	}

	public void setMembPass(String membPass) {
		this.membPass = membPass;
	}

	public Boolean getMembSex() {
		return this.membSex;
	}

	public void setMembSex(Boolean membSex) {
		this.membSex = membSex;
	}

	public String getMembEmai() {
		return this.membEmai;
	}

	public void setMembEmai(String membEmai) {
		this.membEmai = membEmai;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getPhonNumb() {
		return this.phonNumb;
	}

	public void setPhonNumb(String phonNumb) {
		this.phonNumb = phonNumb;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set getMemberArticles() {
		return this.memberArticles;
	}

	public void setMemberArticles(Set memberArticles) {
		this.memberArticles = memberArticles;
	}

	public Set getExpeServOrdes() {
		return this.expeServOrdes;
	}

	public void setExpeServOrdes(Set expeServOrdes) {
		this.expeServOrdes = expeServOrdes;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getSleepRecordses() {
		return this.sleepRecordses;
	}

	public void setSleepRecordses(Set sleepRecordses) {
		this.sleepRecordses = sleepRecordses;
	}

	public Set getMemberAppointments() {
		return this.memberAppointments;
	}

	public void setMemberAppointments(Set memberAppointments) {
		this.memberAppointments = memberAppointments;
	}

	public Set getMembArchInfos() {
		return this.membArchInfos;
	}

	public void setMembArchInfos(Set membArchInfos) {
		this.membArchInfos = membArchInfos;
	}

	public Set getBlooPreses() {
		return this.blooPreses;
	}

	public void setBlooPreses(Set blooPreses) {
		this.blooPreses = blooPreses;
	}

	public Set getMembFamis() {
		return this.membFamis;
	}

	public void setMembFamis(Set membFamis) {
		this.membFamis = membFamis;
	}

	public Set getMembConsInfos() {
		return this.membConsInfos;
	}

	public void setMembConsInfos(Set membConsInfos) {
		this.membConsInfos = membConsInfos;
	}

	public Set getChats() {
		return this.chats;
	}

	public void setChats(Set chats) {
		this.chats = chats;
	}

}