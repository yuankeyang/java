package com.netmed.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * 专家注册表,字段意义见其配置文件
 * ExpeRegi entity. @author MyEclipse Persistence Tools
 * hibernate自动生成
 */

public class ExpeRegi  implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private String expeId;
     private String expeName;
     private Short rank;
     private Long money;
     private Integer credit;
     private String department;
     private String indiResu;
     private String photo;
     private String expePass;
     private Boolean expeSex;
     private String idCardNumb;
     private String idPict;
     private String expeEmai;
     private String expeLinePhon;
     private String expeMobiPhon;
     private String referrer;
     private Boolean refeConf;
     private String title;
     private String degree;
     private String education;
     private String unit;
     private String alipAcco;
     private String address;
     private Short recoNumb;
     private Boolean state;
     private Set memberAppointments = new HashSet(0);
     private Set expeIndiRepos = new HashSet(0);
     private Set expeServConts = new HashSet(0);
     private Set expeTypes = new HashSet(0);
     private Set expertArticles = new HashSet(0);
     private Set membConsInfos = new HashSet(0);
     private Set expertNotices = new HashSet(0);
     private Set collections = new HashSet(0);
     private Set schedules = new HashSet(0);
     private Set chats = new HashSet(0);
     private Set expeServOrdes =  new HashSet(0);
     private Set refePeers = new HashSet(0);
     private Set expertDiaries = new HashSet(0);


    // Constructors

    /** default constructor */
    public ExpeRegi() {
    }
    
	/** 自己构造的构造器，在收藏表DAO中使用*/
	public ExpeRegi(String expeId) {
		this.expeId = expeId;
	}

	/** minimal constructor */
    public ExpeRegi(String expeId,  String expeName, String expePass, Boolean expeSex, String idCardNumb, String expeEmai, String expeMobiPhon, String referrer, Boolean refeConf, Boolean state) {
        this.expeId = expeId;
        this.expeName = expeName;
        this.expePass = expePass;
        this.expeSex = expeSex;
        this.idCardNumb = idCardNumb;
        this.expeEmai = expeEmai;
        this.expeMobiPhon = expeMobiPhon;
        this.referrer = referrer;
        this.refeConf = refeConf;
        this.state = state;
    }
    
    /**自己构造的构造器**/
    public ExpeRegi(String expeId,  String expeName, String expePass, Boolean expeSex, String idCardNumb, String expeEmai, String expeLinePhon, String expeMobiPhon, String referrer){
    	this.expeId = expeId;
        this.expeName = expeName;
        this.expePass = expePass;
        this.expeSex = expeSex;
        this.idCardNumb = idCardNumb;
        this.expeEmai = expeEmai;
        this.expeLinePhon = expeLinePhon;
        this.expeMobiPhon = expeMobiPhon;
        this.referrer = referrer;
        this.refeConf=Boolean.FALSE;
        this.state=Boolean.FALSE;
    }
    
    
    /** full constructor */
    public ExpeRegi(String expeId, String expeName, Short rank, Long money, Integer credit, String department, String indiResu, String photo, String expePass, Boolean expeSex, String idCardNumb, String idPict, String expeEmai, String expeLinePhon, String expeMobiPhon, String referrer, Boolean refeConf, String title, String degree, String education, String unit, String alipAcco, String address, Short recoNumb, Boolean state, Set memberAppointments, Set expeIndiRepos, Set expeServConts, Set expeTypes, Set expertArticles, Set membConsInfos, Set expertNotices, Set collections, Set schedules, Set chats, Set expeServOrdes, Set refePeers, Set expertDiaries) {
        this.expeId = expeId;
        this.expeName = expeName;
        this.rank = rank;
        this.money = money;
        this.credit = credit;
        this.department = department;
        this.indiResu = indiResu;
        this.photo = photo;
        this.expePass = expePass;
        this.expeSex = expeSex;
        this.idCardNumb = idCardNumb;
        this.idPict = idPict;
        this.expeEmai = expeEmai;
        this.expeLinePhon = expeLinePhon;
        this.expeMobiPhon = expeMobiPhon;
        this.referrer = referrer;
        this.refeConf = refeConf;
        this.title = title;
        this.degree = degree;
        this.education = education;
        this.unit = unit;
        this.alipAcco = alipAcco;
        this.address = address;
        this.recoNumb = recoNumb;
        this.state = state;
        this.memberAppointments = memberAppointments;
        this.expeIndiRepos = expeIndiRepos;
        this.expeServConts = expeServConts;
        this.expeTypes = expeTypes;
        this.expertArticles = expertArticles;
        this.membConsInfos = membConsInfos;
        this.expertNotices = expertNotices;
        this.collections = collections;
        this.schedules = schedules;
        this.chats = chats;
        this.expeServOrdes = expeServOrdes;
        this.refePeers = refePeers;
        this.expertDiaries = expertDiaries;
    }

   
    // Property accessors

    public String getExpeId() {
        return this.expeId;
    }
    
    public void setExpeId(String expeId) {
        this.expeId = expeId;
    }

    public String getExpeName() {
        return this.expeName;
    }
    
    public void setExpeName(String expeName) {
        this.expeName = expeName;
    }

    public Short getRank() {
        return this.rank;
    }
    
    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Long getMoney() {
        return this.money;
    }
    
    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getCredit() {
        return this.credit;
    }
    
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIndiResu() {
        return this.indiResu;
    }
    
    public void setIndiResu(String indiResu) {
        this.indiResu = indiResu;
    }

    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getExpePass() {
        return this.expePass;
    }
    
    public void setExpePass(String expePass) {
        this.expePass = expePass;
    }

    public Boolean getExpeSex() {
        return this.expeSex;
    }
    
    public void setExpeSex(Boolean expeSex) {
        this.expeSex = expeSex;
    }

    public String getIdCardNumb() {
        return this.idCardNumb;
    }
    
    public void setIdCardNumb(String idCardNumb) {
        this.idCardNumb = idCardNumb;
    }

    public String getIdPict() {
        return this.idPict;
    }
    
    public void setIdPict(String idPict) {
        this.idPict = idPict;
    }

    public String getExpeEmai() {
        return this.expeEmai;
    }
    
    public void setExpeEmai(String expeEmai) {
        this.expeEmai = expeEmai;
    }

    public String getExpeLinePhon() {
        return this.expeLinePhon;
    }
    
    public void setExpeLinePhon(String expeLinePhon) {
        this.expeLinePhon = expeLinePhon;
    }

    public String getExpeMobiPhon() {
        return this.expeMobiPhon;
    }
    
    public void setExpeMobiPhon(String expeMobiPhon) {
        this.expeMobiPhon = expeMobiPhon;
    }

    public String getReferrer() {
        return this.referrer;
    }
    
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public Boolean getRefeConf() {
        return this.refeConf;
    }
    
    public void setRefeConf(Boolean refeConf) {
        this.refeConf = refeConf;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegree() {
        return this.degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEducation() {
        return this.education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAlipAcco() {
        return this.alipAcco;
    }
    
    public void setAlipAcco(String alipAcco) {
        this.alipAcco = alipAcco;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Short getRecoNumb() {
        return this.recoNumb;
    }
    
    public void setRecoNumb(Short recoNumb) {
        this.recoNumb = recoNumb;
    }

    public Boolean getState() {
        return this.state;
    }
    
    public void setState(Boolean state) {
        this.state = state;
    }

    public Set getMemberAppointments() {
        return this.memberAppointments;
    }
    
    public void setMemberAppointments(Set memberAppointments) {
        this.memberAppointments = memberAppointments;
    }

    public Set getExpeIndiRepos() {
        return this.expeIndiRepos;
    }
    
    public void setExpeIndiRepos(Set expeIndiRepos) {
        this.expeIndiRepos = expeIndiRepos;
    }

    public Set getExpeServConts() {
        return this.expeServConts;
    }
    
    public void setExpeServConts(Set expeServConts) {
        this.expeServConts = expeServConts;
    }

    public Set getExpeTypes() {
        return this.expeTypes;
    }
    
    public void setExpeTypes(Set expeTypes) {
        this.expeTypes = expeTypes;
    }

    public Set getExpertArticles() {
        return this.expertArticles;
    }
    
    public void setExpertArticles(Set expertArticles) {
        this.expertArticles = expertArticles;
    }

    public Set getMembConsInfos() {
        return this.membConsInfos;
    }
    
    public void setMembConsInfos(Set membConsInfos) {
        this.membConsInfos = membConsInfos;
    }

    public Set getExpertNotices() {
        return this.expertNotices;
    }
    
    public void setExpertNotices(Set expertNotices) {
        this.expertNotices = expertNotices;
    }

    public Set getCollections() {
        return this.collections;
    }
    
    public void setCollections(Set collections) {
        this.collections = collections;
    }

    public Set getSchedules() {
        return this.schedules;
    }
    
    public void setSchedules(Set schedules) {
        this.schedules = schedules;
    }

    public Set getChats() {
        return this.chats;
    }
    
    public void setChats(Set chats) {
        this.chats = chats;
    }

    public Set getExpeServOrdes() {
        return this.expeServOrdes;
    }
    
    public void setExpeServOrdes(Set expeServOrdes) {
        this.expeServOrdes = expeServOrdes;
    }

    public Set getRefePeers() {
        return this.refePeers;
    }
    
    public void setRefePeers(Set refePeers) {
        this.refePeers = refePeers;
    }

    public Set getExpertDiaries() {
        return this.expertDiaries;
    }
    
    public void setExpertDiaries(Set expertDiaries) {
        this.expertDiaries = expertDiaries;
    }
   








}