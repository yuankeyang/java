package com.netmed.action.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.netmed.dao.MembConsInfoDAO;

//专家文件下载
public class FileDownloadAction {
	

		private int fileNumber;//文件数
	    private String fileName; //文件名
		public int getFileNumber() {
			return fileNumber;
		}

		//set和get方法
		public void setFileNumber(int fileNumber) {
			this.fileNumber = fileNumber;
		}
		

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个输出流
		public InputStream getDownloadFile() throws Exception
		{
		    String basePath="null"; 
			System.out.println("运行到了文件下载action！！！");	
			
			System.out.println("InputStream--从jsp页面接收的fileName参数值为："+fileName);
			
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring获得DAO
			MembConsInfoDAO dao = (MembConsInfoDAO) otx.getBean("MembConsInfoDAO");	
			//获得request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			//从jsp页面获取离线咨询id
			String electronic_record = request.getParameter("electronic_record");
			int id=Integer.parseInt(electronic_record);
			System.out.println("判断ID是否有文件成功----id="+id);
			//附件存储地址
			basePath=dao.FindInfoById(id).getFolder();
			System.out.println("下载地址:"+basePath);
			
			//附件列表
			String fileList="";
			String []files=new String[3];   //附件最多有3个
			if(dao.isHaveFile(id)){
			    fileList=dao.FindInfoById(id).getFilenames();
			    System.out.println("文件条目："+fileList.toString());
				files=fileList.split("/");
			 System.out.println("文件个数："+files.length);
			}else{
				System.out.println("用户没有上传文件");
			}
			//附件1
			if(fileNumber==0){
				System.out.println("恭喜，下载了附件-----"+files[0]);
				return new FileInputStream(new File(basePath,files[0]));
			}
			//附件2
			if(fileNumber==1){
				System.out.println("恭喜，下载了附件------"+files[1]);
				return new FileInputStream(new File(basePath,files[1]));
			}
			//附件3
			if(fileNumber==2){
				System.out.println("恭喜，下载了附件------"+files[2]);
				return new FileInputStream(new File(basePath,files[2]));
			}
			
			return null;
			
		}
		
		//将页面获取的fileName进行转码，使得在下载对话框中显示正确的下载文件名
		 public String getDownloadFileName() {   
			  
			    System.out.println("String---从jsp页面接收的fileName参数值为："+fileName);
		        String downFileName = fileName;   
		        try {   
		            downFileName = new String(downFileName.getBytes("ISO8859-1"), "UTF-8");
		            System.out.println("String---转码之后的fileName名字 ："+downFileName);
		  
		        } catch (UnsupportedEncodingException e) {   
		            e.printStackTrace();   
		        }   
		        return downFileName;   
		    }   
		
		//action默认执行方法
		public String execute() throws Exception {
			System.out.println("文件action的默认execute()----执行");
			return "success";
		}

	}

