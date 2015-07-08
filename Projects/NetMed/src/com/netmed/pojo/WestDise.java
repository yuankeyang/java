package com.netmed.pojo;



/**
 * 西药治病表,字段意义见其配置文件
 * WestDise entity. @author MyEclipse Persistence Tools
 */

public class WestDise  implements java.io.Serializable {


    // Fields    

     private Integer mediDiseId;
     private WestMedi westMedi;
     private String chinDiseName;
     private String westDiseName;


    // Constructors

    /** default constructor */
    public WestDise() {
    }

	/** minimal constructor */
    public WestDise(WestMedi westMedi) {
        this.westMedi = westMedi;
    }
    
    /** full constructor */
    public WestDise(WestMedi westMedi, String chinDiseName, String westDiseName) {
        this.westMedi = westMedi;
        this.chinDiseName = chinDiseName;
        this.westDiseName = westDiseName;
    }

   
    // Property accessors

    public Integer getMediDiseId() {
        return this.mediDiseId;
    }
    
    public void setMediDiseId(Integer mediDiseId) {
        this.mediDiseId = mediDiseId;
    }

    public WestMedi getWestMedi() {
        return this.westMedi;
    }
    
    public void setWestMedi(WestMedi westMedi) {
        this.westMedi = westMedi;
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
   








}