package com.cmli.correctivesystem.dao.impl;

import java.util.List;

import com.cmli.correctivesystem.dao.DAO;
import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	
	public List<Customer> getAll() {
		String sql = "SELECT id,Minwen,Hanwen,Shuxone,Shuxtwo FROM bzxt";
		return getForList(sql);
	}

	public boolean save(Customer customer) {
		System.setProperty("sun.jnu.encoding","utf-8");
		long Fag = getCountWithName(customer.getMinwen());
		if(Fag==0){
			String sql = "INSERT INTO bzxt(Minwen,Hanwen,Shuxone,Shuxtwo) VALUES(?,?,?,?)";
			update(sql, customer.getMinwen(),customer.getHanwen(),customer.getShuxone(),customer.getShuxtwo());
		}else{
			System.out.println("数据已存在");
			return false;
		}
		return true;
	}


	public Customer get(Integer id) {
		String sql = "SELECT Minwen,Hanwen,Shuxone,Shuxtwo FROM bzxt WHERE id = ?";
		return get(sql, id);
	}


	public Customer get(String Minwen) {
		String sql = "SELECT Hanwen FROM bzxt WHERE minwen = ?";
		return get(sql, Minwen);
	}

	public void delete(Integer id) {

		String sql = "DELETE FROM bzxt WHERE id = ?";
		update(sql, id);
				
	}


	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM bzxt WHERE Minwen = ?";
		return getForVaule(sql, name);
	}

	public int getId(String minwen) {
		String sql = "SELECT id FROM bzxt WHERE Minwen = ?";
		return getForVaule(sql, minwen);
	}

}
