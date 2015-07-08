package com.netmed.pojo;



/**
 * 方剂治病表,字段意义见其配置文件
 * PresDise entity. @author MyEclipse Persistence Tools
 */

public class PresDise  implements java.io.Serializable {


    // Fields    

     private Integer presDiseId;
     private Prescription prescription;
     private String chinDiseName;
     private String westDiseName;


    // Constructors

    /** default constructor */
    public PresDise() {
    }

	/** minimal constructor */
    public PresDise(Prescription prescription) {
        this.prescription = prescription;
    }
    
    /** full constructor */
    public PresDise(Prescription prescription, String chinDiseName, String westDiseName) {
        this.prescription = prescription;
        this.chinDiseName = chinDiseName;
        this.westDiseName = westDiseName;
    }

   
    // Property accessors

    public Integer getPresDiseId() {
        return this.presDiseId;
    }
    
    public void setPresDiseId(Integer presDiseId) {
        this.presDiseId = presDiseId;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }
    
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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