package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 会员预约表,字段意义见其配置文件
 * MemberAppointment entity. @author MyEclipse Persistence Tools
 */

public class MemberAppointment implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExpeRegi expeRegi;
	private MembRegi membRegi;
	private Timestamp appoTime;
	private String title;
	private String content;
	private Boolean ifaccept;
	private Timestamp replyTime;
	private Boolean state;
	private Boolean defaultMemb;
	private Boolean defaultExpe;

	// Constructors

	/** default constructor */
	public MemberAppointment() {
	}

	/** minimal constructor */
	public MemberAppointment(Boolean state, Boolean defaultMemb,
			Boolean defaultExpe) {
		this.state = state;
		this.defaultMemb = defaultMemb;
		this.defaultExpe = defaultExpe;
	}

	/** full constructor */
	public MemberAppointment(ExpeRegi expeRegi, MembRegi membRegi,
			Timestamp appoTime, String title, String content, Boolean ifaccept,
			Timestamp replyTime, Boolean state, Boolean defaultMemb,
			Boolean defaultExpe) {
		this.expeRegi = expeRegi;
		this.membRegi = membRegi;
		this.appoTime = appoTime;
		this.title = title;
		this.content = content;
		this.ifaccept = ifaccept;
		this.replyTime = replyTime;
		this.state = state;
		this.defaultMemb = defaultMemb;
		this.defaultExpe = defaultExpe;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExpeRegi getExpeRegi() {
		return this.expeRegi;
	}

	public void setExpeRegi(ExpeRegi expeRegi) {
		this.expeRegi = expeRegi;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public Timestamp getAppoTime() {
		return this.appoTime;
	}

	public void setAppoTime(Timestamp appoTime) {
		this.appoTime = appoTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIfaccept() {
		return this.ifaccept;
	}

	public void setIfaccept(Boolean ifaccept) {
		this.ifaccept = ifaccept;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getDefaultMemb() {
		return this.defaultMemb;
	}

	public void setDefaultMemb(Boolean defaultMemb) {
		this.defaultMemb = defaultMemb;
	}

	public Boolean getDefaultExpe() {
		return this.defaultExpe;
	}

	public void setDefaultExpe(Boolean defaultExpe) {
		this.defaultExpe = defaultExpe;
	}

}