package com.cmli.correctivesystem.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.text.AbstractDocument.Content;

import org.apache.catalina.Contained;
import org.junit.Test;

import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.dao.impl.CustomerDAOJdbcImpl;
import com.cmli.correctivesystem.domain.Customer;

/*public class Save {
	
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	@Test
	public void testSave() {
		Customer customer = new Customer();
		String content =  readFile("F:\\科研相关\\资源库\\藏文已标注\\藏文已标\\epaper.chinatibetnews.com-tibet-2014-01-01.all.txt");
		String[] str = content.split("\r\n");
		Integer B = new Integer(0);
		for(String s:str){
			customer.setMinwen(s.trim());
			customer.setHanwen(B.toString());
			customer.setShuxone("null");
			customer.setShuxtwo("null");
			customerDAO.save(customer);
			B++;
		}
	}
	
	*//**
	 * 读文件 
	 * @param filePathAndName
	 * @return
	 *//*
	 public static String readFile(String filePathAndName) {
			String fileContent = "";
			try {
				File f = new File(filePathAndName);
				if (f.isFile() && f.exists()) {
					InputStreamReader read = new InputStreamReader(
							new FileInputStream(f), "UTF-8");
					BufferedReader reader = new BufferedReader(read);
					String line;
					while ((line = reader.readLine()) != null) {
						fileContent += line+"\r\n";
					}
					read.close();
				}
			} catch (Exception e) {
				System.out.println("du wenjian cuo wu");
				e.printStackTrace();
			}
			return fileContent;
		}
	 
}*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.dao.impl.CustomerDAOJdbcImpl;
import com.cmli.correctivesystem.domain.Customer;

public class Save {
	
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	@Test
	public void testSave() {
		Customer customer = new Customer();
		String content =  readFile("F:\\tibet(2).txt"); //这是通过读本地文件，你可以直接把页面获取的数据给content
		String[] str = content.split("\r\n"); //先按照行分开
		Integer B = new Integer(0);
		String[] sentences = null;
//		System.out.println(content);
		int sentenceNO=1;
		for(String s:str){
//			System.out.println(s);
			if(s.indexOf("།།") != -1){
				sentences = s.split("།།");  //如果句子中含有双垂符，按照双垂符分句
			}else{
				sentences = s.split("།"); // 否则按照单垂符分句
			}
			for(String sentence :sentences){
				customer.setMinwen(sentence+"།".trim());
				customer.setHanwen(B.toString()); //为了方便定义一个数字，可以自己定义存储的字段
				customer.setShuxone("null");
				customer.setShuxtwo("null");
				
				customerDAO.save(customer);  //保存到数据库
				System.out.println(sentence);
				B++;
			}
		}
		
	}
	public void saveFile(String filePath,int fileId) {
		Customer customer = new Customer();
		String content =  readFile(filePath); //这是通过读本地文件，你可以直接把页面获取的数据给content
		String[] str = content.split("\r\n"); //先按照行分开
		Integer B = new Integer(0);
//		System.out.println(content);
		String[] sentences = null;
		int sentenceNO=1;
		for(String s:str){
			s=s.trim();
			System.out.println(s+"--------");
			if(s.indexOf("།།") != -1){
				sentences = s.split("།།");  //如果句子中含有双垂符，按照双垂符分句
			}else{
				sentences = s.split("།"); // 否则按照单垂符分句
			}
			for(String sentence :sentences){
				String minWen=sentence.trim()+"།";
				customer.setMinwen(minWen);
				customer.setHanwen(B.toString()); //为了方便定义一个数字，可以自己定义存储的字段
				customer.setShuxone("null");
				customer.setShuxtwo("null");
				customer.setSentence_no(sentenceNO);
				customer.setFile_id(fileId);
				customerDAO.save(customer);  //保存到数据库
				if (sentence.length()==0) {
					System.out.print("none words in this sentence");
				}
				System.out.println(minWen+"++++++++++++++++++++++"+sentences.length);
				sentenceNO++;
				B++;
			}
		}
		
	}
	
	/**
	 * 读文件 
	 * @param filePathAndName
	 * @return
	 */
	 public static String readFile(String filePathAndName) {
			String fileContent = "";
			try {
				File f = new File(filePathAndName);
				if (f.isFile() && f.exists()) {
					InputStreamReader read = new InputStreamReader(
							new FileInputStream(f), "UTF-8");
					BufferedReader reader = new BufferedReader(read);
					String line;
					while ((line = reader.readLine()) != null) {
						
						if(line.startsWith("h")){
							continue;
						}
						fileContent += line+"\r\n";
					}
					read.close();
				}
			} catch (Exception e) {
				System.out.println("du wenjian cuo wu");
				e.printStackTrace();
			}
			return fileContent;
		}
	 
}

