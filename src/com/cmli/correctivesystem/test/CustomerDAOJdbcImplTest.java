package com.cmli.correctivesystem.test;

import java.util.List;

import org.junit.Test;

import com.cmli.correctivesystem.dao.DAO;
import com.cmli.correctivesystem.dao.impl.CustomerDAOJdbcImpl;
import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.domain.Customer;
/**
 * 测试类，测试所有数据库操作是否正常
 * @author gaden
 *
 */
public class CustomerDAOJdbcImplTest {

	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	String tableName = "zhbt";
	int count = 0;
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		System.setProperty("sun.jnu.encoding","utf-8");
		customer.setMinwen("民文123");
		customer.setHanwen("汉文1");
		customer.setShuxone("属性1");
		customer.setShuxtwo("属性2");
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer customer = customerDAO.get(2);
		System.out.println(customer.getMinwen()+customer.getHanwen());
	}
	@Test
	public void testGetString() {
		String str = null;
		Customer cc = customerDAO.get("aa");
		if(cc!=null){
			System.out.println(cc);
		}else{
			System.out.println("Not Foud!");
		}
		//return str;
	}
	@Test
	public void testDelete() {
		customerDAO.delete(1);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("aa");
		System.out.println(count);
	}
	/**
	 * 把.txt文档中的内容批量加入mysql 数据库中
	 */
	@Test
	public void testSaveForList() {
		
	}
}
