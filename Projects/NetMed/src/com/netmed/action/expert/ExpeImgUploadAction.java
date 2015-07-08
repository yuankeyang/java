package com.netmed.action.expert;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.Bean.ExpeRegister;
import com.opensymphony.xwork2.ActionSupport;

/**类<code>UserImgUploadAction</code>
 * 会员头像上传Action
 * @author 远客
 * @version 1.0
 *
 */
public class ExpeImgUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1419610820404881079L;
	private String username;
	private String password;
	private String uploadContentType;
	private String exp_id;
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

	/**专家个人中心上传头像方法**/
	public String uploadHeadImg() {
		try{
			
		/**头像保存路径**/
		String savePath="/expertFiles/"+getExp_id();
		String path=ServletActionContext.getRequest().getRealPath(savePath);
		
		/**路径是否存在，不存在则创建新的目录**/
		if(!new File(path).exists()){
			new File(path).mkdirs();
		}
		if(uploadFileName.contains(";")||uploadFileName.contains("&#")){
			uploadFileName=System.currentTimeMillis()+new java.util.Random().nextInt(1000)+uploadFileName.substring(uploadFileName.indexOf("."));
		}
		/**找到目标文件，并复制到保存路径**/
		File destFile=new File(path+"/"+uploadFileName);
		FileUtils.copyFile(upload,destFile );
		
		String url=savePath+"/"+uploadFileName;
		ExpeRegister ur=new ExpeRegister();
		ur.uploadImg(url, exp_id);
		
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	
	/**下面为set和get方法**/
	
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

	public String getExp_id() {
		return exp_id;
	}

	public void setExp_id(String exp_id) {
		this.exp_id = exp_id;
	}
}
