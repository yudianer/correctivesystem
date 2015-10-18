package com.cmli.correctivesystem.utils;

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
