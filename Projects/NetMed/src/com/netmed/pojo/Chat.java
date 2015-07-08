package com.netmed.pojo;

/**
 * 在线咨询表
 * Chat entity. @author MyEclipse Persistence Tools
 * 05-20
 */

public class Chat implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer chatId;
	private ExpeRegi expeRegi;
	private MembRegi membRegi;
	private Boolean state;

	// Constructors

	/** default constructor */
	public Chat() {
	}

	/** minimal constructor */
	public Chat(ExpeRegi expeRegi, MembRegi membRegi) {
		this.expeRegi = expeRegi;
		this.membRegi = membRegi;
	}

	/** full constructor */
	public Chat(ExpeRegi expeRegi, MembRegi membRegi, Boolean state) {
		this.expeRegi = expeRegi;
		this.membRegi = membRegi;
		this.state = state;
	}

	public Integer getChatId() {
		return this.chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
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

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}