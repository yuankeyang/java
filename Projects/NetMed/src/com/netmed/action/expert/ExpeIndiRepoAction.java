package com.netmed.action.expert;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeIndiRepoDAO;
import com.netmed.pojo.ExpeIndiRepo;
import com.netmed.pojo.ExpeRegi;

public class ExpeIndiRepoAction {
	
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	/**
	 * 专家知识库
	 * 专家增加新的处方等内容
	 * 
	 * @return 是否处理成功
	 * @throws Exception
	 */
	
	public String NewRepository() throws Exception {

		System.out.println("运行到了专家知识库action-----NewRepository");
		String FORWARD = "error";
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");
			
			/**从jsp页面获取知识库参数，封装成对象**/
			ExpeIndiRepo repository = getParaFromJsp(request);
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeIndiRepoDAO dao = (ExpeIndiRepoDAO) otx
					.getBean("ExpeIndiRepoDAO");
			
			/**专家新建知识库，返回非0值则成功**/
			int save = dao.NewRepository(repository);
			if (save != 0) {
				System.out.println("专家新增知识库-----成功");
				FORWARD = "success";
			} else {
				System.out.println("专家新增知识库-----失败");
			}

		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}

	/** 从jsp页面获取日记参数 */
	public ExpeIndiRepo getParaFromJsp(HttpServletRequest request) {
		ExpeIndiRepo repository = new ExpeIndiRepo();
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		
		// 获取专家Id
		String expename=null;
		try {
			expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/**设置知识库专家字段**/
		ExpeRegi expert = new ExpeRegi();
		expert.setExpeId(expename);
		repository.setExpeRegi(expert);

		String pres_name = request.getParameter("pres_name");  	/**方名**/
		String illn_desc = request.getParameter("illn_desc");   /**病情描述**/
		String synd_name = request.getParameter("synd_name");   	/**证候**/
		String chin_dise_name = request.getParameter("chin_dise_name");  /**中医病名**/
		String west_dise_name = request.getParameter("west_dise_name");  /**西医病名**/
		String pres_detail = request.getParameter("pres_detail");        /**方剂详解**/
		String medi_mate_name = request.getParameter("medi_mate_name");  /**中药材**/
		String west_medi_name = request.getParameter("west_medi_name");  /**西药**/
		
		/**这两项非空，做非空判断，如果页面输入为空，则设置字段为无**/
		repository.setPresName(pres_name);
		repository.setIllnDesc(illn_desc);
		if("".equals(synd_name)){
			repository.setSyndName("无");
		}else{
			repository.setSyndName(synd_name);
		}
        if("".equals(chin_dise_name)){
        	repository.setChinDiseName("无");
		}else{
			repository.setChinDiseName(chin_dise_name);
		}
        
        if("".equals(west_dise_name)){
        	repository.setWestDiseName("无");
		}else{
			repository.setWestDiseName(west_dise_name);
		}
        
        if("".equals(pres_detail)){
        	repository.setPresDetail("无");
		}else{
			repository.setPresDetail(pres_detail);
		}
        
        if("".equals(medi_mate_name)){
        	repository.setMediMateName("无");
		}else{
			repository.setMediMateName(medi_mate_name);
		}
        
        if("".equals(west_medi_name)){
			repository.setWestMediName("无");
		}else{
			repository.setWestMediName(west_medi_name);
		}
        /**返回知识库对象**/
		return repository;
	}
	
	/**
	 * 删除专家个人知识库
	 * 
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String DeleteRepository() throws Exception {

		System.out.println("运行到了医生工具箱处理action！-----DeleteRepository");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeIndiRepoDAO dao = (ExpeIndiRepoDAO) otx
					.getBean("ExpeIndiRepoDAO");

			PrintWriter out = response.getWriter();
			
			 /**获取知识库id**/
			String repoId = new String(request.getParameter("repoId"));
			ExpeIndiRepo repository = dao.SelectRepository(Integer
					.parseInt(repoId));
			
			/**先通过工具箱id找到工具箱，再删除**/
			if (dao.DeleteRepository(repository)) {
				System.out.println("删除专家知识库-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("删除专家知识库----失败");
				FORWARD = "error";
				out.println("no");
			}
			out.flush();
			out.close();
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}
	
	/**
	 * 根据专家Id获取专家知识库
	 * @return 是否成功
	 */
	public String getBriefRepoListForRead() {
		System.out.println("运行到了专家知识库处理action！-----getBriefRepoListForRead");
		String forward = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			 /**通过session获取专家id**/
			String expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
			
			 /**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeIndiRepoDAO dao = (ExpeIndiRepoDAO) otx
					.getBean("ExpeIndiRepoDAO");
			 
			/**通过专家id获取其个人知识库**/
			List<ExpeIndiRepo> repositoryList = dao.FindRepositoryByExpeId(expename);

			 /**定义json对象和数组用以返回数据库数据**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject repository = null;
			for (int i = 0; i < repositoryList.size(); i++) {

				repository = new JSONObject();
				// 知识库id
				repository.put("repoId", repositoryList.get(i).getRepoId());
				
				// 方名
				repository.put("presName", repositoryList.get(i).getPresName());

				/**证候**/
				String syndName=repositoryList.get(i).getSyndName();
				if("".equals(syndName)||syndName==null){
					repository.put("syndrome","无");
				}else{
					repository.put("syndrome", syndName);
				}
				/**中医病名**/
				String chinDise=repositoryList.get(i).getChinDiseName();
				if("".equals(chinDise)||chinDise==null){
					repository.put("chinDise","无");
				}else{
					repository.put("chinDise", chinDise);
				}
				/**西医病名**/
				String westDise=repositoryList.get(i).getWestDiseName();
				if("".equals(westDise)||westDise==null){
					repository.put("westDise","无");
				}else{
					repository.put("westDise", westDise);
				}
				/**中药**/
				String mediMate=repositoryList.get(i).getMediMateName();
				if("".equals(mediMate)||mediMate==null){
					repository.put("mediMate","无");
				}else{
					repository.put("mediMate", mediMate);
				}
				/**西药**/
				String westMedi=repositoryList.get(i).getWestMediName();
				if("".equals(westMedi)||westMedi==null){
					repository.put("westMedi","无");
				}else{
					repository.put("westMedi", westMedi);
				}
				/**病情描述**/
				String illnDesc=repositoryList.get(i).getIllnDesc();
				if("".equals(illnDesc)||illnDesc==null){
					repository.put("illnDesc","无");
				}else{
					repository.put("illnDesc", illnDesc);
				}
				
				/**方剂详解**/
				String presDetail=repositoryList.get(i).getPresDetail();
				if("".equals(presDetail)||presDetail==null){
					repository.put("presDetail","无");
				}else{
					repository.put("presDetail", presDetail);
				}
				/**时间**/
				String showTime=timeFormat.format(repositoryList.get(i).getConsTime());
				repository.put("time", showTime);

				array.add(repository);
			}
			json.put("acount", repositoryList.size());
			json.put("repoArray", array);
			out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";// 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return forward;
	}
	
	/**
	 * 根据工具箱处方Id 读取详细的工具箱处方信息
	 * @author 
	 */
	public String getRepositoryForRead() {
		System.out.println("查询知识库详情-----getRepositoryForRead");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeIndiRepoDAO dao = (ExpeIndiRepoDAO) otx
					.getBean("ExpeIndiRepoDAO");
			
			/**知识库id**/
			String repoId = request.getParameter("repoId");
			int id = Integer.parseInt(repoId);
			
			/**通过知识库id查找知识库对象**/
			ExpeIndiRepo repository = dao.SelectRepository(id);
			// 处方名称
			json.put("presName", repository.getPresName());
			
			/**获取知识库的详细信息，如果字段有为空，就设置无**/
			String syndName=repository.getSyndName();
			if("".equals(syndName)||syndName==null){
				json.put("syndrome","无");
			}else{
				json.put("syndrome", syndName);
			}
			
			String showTime=timeFormat.format(repository.getConsTime());
			json.put("time", showTime);

			String chinDise=repository.getChinDiseName();
			if("".equals(chinDise)||chinDise==null){
				json.put("chinDise","无");
			}else{
				json.put("chinDise", chinDise);
			}
			String westDise=repository.getWestDiseName();
			if("".equals(westDise)||westDise==null){
				json.put("westDise","无");
			}else{
				json.put("westDise", westDise);
			}
			
			String mediMate=repository.getMediMateName();
			if("".equals(mediMate)||mediMate==null){
				json.put("mediMate","无");
			}else{
				json.put("mediMate", mediMate);
			}
			String westMedi=repository.getWestMediName();
			if("".equals(westMedi)||westMedi==null){
				json.put("westMedi","无");
			}else{
				json.put("westMedi", westMedi);
			}
			
			String illnDesc=repository.getIllnDesc();
			if("".equals(illnDesc)||illnDesc==null){
				json.put("illnDesc","无");
			}else{
				json.put("illnDesc", illnDesc);
			}
			String presDetail=repository.getPresDetail();
			if("".equals(presDetail)||presDetail==null){
				json.put("presDetail","无");
			}else{
				json.put("presDetail", presDetail);
			}
			
			out = response.getWriter();
			out.println(json.toString());

			forward = "success";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		out.flush();
		out.close();
		return forward;
	}
	
	/**
	 * 修改知识库内容
	 * @return
	 */
	public String UpdateRepository() {
		System.out.println("更改知识库详情-----UpdateRepository");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeIndiRepoDAO dao = (ExpeIndiRepoDAO) otx
					.getBean("ExpeIndiRepoDAO");
			
			/**request对象获取知识库id**/
			String repoId = request.getParameter("repoId");
			int id = Integer.parseInt(repoId);
			ExpeIndiRepo repository = dao.SelectRepository(id);
			
			/**从jsp页面获取个人知识库的字段信息**/
			String pres_name = request.getParameter("pres_name");     /**方名**/
			String illn_desc = request.getParameter("illn_desc");     /**病情描述**/
			String synd_name = request.getParameter("synd_name");     /**证候**/
			String chin_dise_name = request.getParameter("chin_dise_name");  /**中医病名**/
			String west_dise_name = request.getParameter("west_dise_name");  /**西医病名**/
			String pres_detail = request.getParameter("pres_detail");        /**方剂详解**/
			String medi_mate_name = request.getParameter("medi_mate_name");  /**中药**/
			String west_medi_name = request.getParameter("west_medi_name");  /**西药**/
			
			repository.setPresName(pres_name);
			repository.setIllnDesc(illn_desc);
			if("".equals(synd_name)){
				repository.setSyndName("无");
			}else{
				repository.setSyndName(synd_name);
			}
	        if("".equals(chin_dise_name)){
	        	repository.setChinDiseName("无");
			}else{
				repository.setChinDiseName(chin_dise_name);
			}
	        
	        if("".equals(west_dise_name)){
	        	repository.setWestDiseName("无");
			}else{
				repository.setWestDiseName(west_dise_name);
			}
	        
	        if("".equals(pres_detail)){
	        	repository.setPresDetail("无");
			}else{
				repository.setPresDetail(pres_detail);
			}
	        
	        if("".equals(medi_mate_name)){
	        	repository.setMediMateName("无");
			}else{
				repository.setMediMateName(medi_mate_name);
			}
	        
	        if("".equals(west_medi_name)){
				repository.setWestMediName("无");
			}else{
				repository.setWestMediName(west_medi_name);
			}
	        
	        if (dao.UpdateRepository(repository)) {
				System.out.println("专家修改医生知识库成功");
				forward = "success";
			} else {
				System.out.println("专家修改医生知识库失败");
				forward = "error";
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}

		return forward;
	}

}
