package com.cmli.correctivesystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmli.correctivesystem.dao.DAO;
import com.cmli.correctivesystem.dao.impl.CustomerDAOJdbcImpl;
import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.domain.Customer;
import java.net.URLDecoder;
public class Dicfrowedservlet extends HttpServlet {

	private static final long seriaLVersionUID = 1l;
	String tableName = "zhdt";
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0,methodName.length()-3);
		
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}
	//添加请求
	private void add(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String minwen = request.getParameter("minwen");
		minwen=URLDecoder.decode(minwen, "utf-8");
		minwen=URLDecoder.decode(minwen, "utf-8");
		//minwen = new String (minwen.getBytes("GBK"),"GBK");
		
		String hanwen = request.getParameter("hanwen");
		hanwen=URLDecoder.decode(hanwen, "utf-8");
		hanwen=URLDecoder.decode(hanwen, "utf-8");
		//hanwen = new String (hanwen.getBytes("GBK"),"GBK");
		
		String shuxone = request.getParameter("shuxone");
		shuxone=URLDecoder.decode(shuxone, "utf-8");
		shuxone=URLDecoder.decode(shuxone, "utf-8");
		//shuxone = new String (shuxone.getBytes("GBK"),"GBK");
		
		String shuxtwo = request.getParameter("shuxtwo");
		shuxtwo=URLDecoder.decode(shuxtwo, "utf-8");
		shuxtwo=URLDecoder.decode(shuxtwo, "utf-8");
		//shuxtwo = new String (shuxtwo.getBytes("GBK"),"GBK");
		Customer customers = new Customer(minwen,shuxone,shuxtwo,hanwen);
		boolean b = customerDAO.save(customers);
		String idString=request.getParameter("id");
		int idInt=Integer.parseInt(idString);
		customerDAO.delete(idInt);
		if(b==true){
			response.sendRedirect("success.jsp");
		}else{
			response.sendRedirect("adderror.jsp");
		}
	}
	//查询请求--错词
	private void query(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		List<Customer> customers = customerDAO.getAll();
//		List<String> words = null;
//		List<String> lables = null;
////		List<String,String[]> = null;
//		String[] word_lables = null;
//		for (Customer customer : customers) {
//			String sentence = customer.getMinwen();
//			 word_lables =  sentence.split(" ");
//			for(String word_lable : word_lables){
//				words.add(word_lable);
//			}
//			words.add("\r\n");
//			lables.add("\r\n");
//			 
//		}
		System.out.println(customers);
		request.setAttribute("customers", customers);
//		request.setAttribute("lables", lables);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	//查询请求--错词修改
	private void modifyWords(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/modifyWords.jsp").forward(request, response);
	}
	//查询请求--分词错误
	private void splitWords(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/splitWords.jsp").forward(request, response);
	}
	//查询请求--词性
	private void POS(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/POS.jsp").forward(request, response);
	}
	//删除请求
	private void delete(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		String idStr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
			System.out.println(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("query.do");
	}
	//更新请求
	private void update(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		
		Customer customersup = null ;
		String idStr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			customersup =customerDAO.get(id);
			System.out.println(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("customersup", customersup);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
		customerDAO.delete(id);
		System.out.println("update.do");
	}
	
	private void translation(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
//		List<String> YiwenResult = new ArrayList<String>();
//		String Yuanwen =  request.getParameter("tinput");
//		String chYuanwen =new String(Yuanwen.getBytes("iso-8859-1"),"UTF-8");
//		SearchForZhdb szh = new SearchForZhdb();
//		SearchForAddressdb address = new SearchForAddressdb();
//		SearchForPnamedb pName = new SearchForPnamedb();
//		
//		String Yiwen = szh.searcherZh(chYuanwen);
//		YiwenResult =szh.splitForresult(Yiwen);
//		request.setAttribute("Yiwen", YiwenResult);
//		request.getRequestDispatcher("/translate.jsp").forward(request, response);
		
	}

}
