package com.netmed.action.member;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.Bean.UserRegister;
import com.opensymphony.xwork2.ActionSupport;

/**类<code>UserImgUploadAction</code>
 * 会员头像上传Action
 * @author 远客
 * @version 1.0
 *
 */
public class UserImgUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1419610820404881079L;
	private String username;
	private String password;
	private String uploadContentType;
	private String mem_id;
	private File upload;
	
	private String uploadFileName;
	private String fileName;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//实现头像上传功能
	public String uploadHeadImg() throws Throwable{
		String savePath="/memberFiles/"+getMem_id();
		String path=ServletActionContext.getRequest().getRealPath(savePath);
		if(!new File(path).exists()){
			new File(path).mkdirs();
		}
		if(uploadFileName.contains(";")||uploadFileName.contains("&#")){
			uploadFileName=System.currentTimeMillis()+new java.util.Random().nextInt(1000)+uploadFileName.substring(uploadFileName.indexOf("."));
		}
		File destFile=new File(path+"/"+uploadFileName);
		FileUtils.copyFile(upload,destFile );
		String url=savePath+"/"+uploadFileName;
		System.out.println("\t"+url);
		UserRegister ur=new UserRegister();
		ur.uploadImg(url, mem_id);
		
		return SUCCESS;
	}

	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
}
