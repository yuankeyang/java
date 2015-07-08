package com.netmed.pojo;

import java.sql.Timestamp;

/**
 * 会员文章表,字段意义见其配置文件
 * MemberArticle entity. @author MyEclipse Persistence Tools
 */

public class MemberArticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private MembRegi membRegi;
	private String title;
	private String type;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public MemberArticle() {
	}

	/** full constructor */
	public MemberArticle(MembRegi membRegi, String title, String type,
			String content, Timestamp time) {
		this.membRegi = membRegi;
		this.title = title;
		this.type = type;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MembRegi getMembRegi() {
		return this.membRegi;
	}

	public void setMembRegi(MembRegi membRegi) {
		this.membRegi = membRegi;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}