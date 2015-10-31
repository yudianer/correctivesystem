package com.cmli.correctivesystem.dao.impl;

import java.util.List;

import com.cmli.correctivesystem.dao.DAO;
import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.domain.Customer;
import com.cmli.correctivesystem.file.FileNameId;
public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	
	public List<Customer> getAll() {
		String sql = "SELECT id,Minwen,Hanwen,Shuxone,Shuxtwo FROM bzxt";
		return getForList(sql);
	}

	/*public boolean save(Customer customer) {
		System.setProperty("sun.jnu.encoding","utf-8");
		long Fag = getCountWithName(customer.getMinwen());
		if(Fag==0){
			String sql = "INSERT INTO bzxt(Minwen,Hanwen,Shuxone,Shuxtwo,file_id,sentence_no) VALUES(?,?,?,?,?,?)";
			update(sql, customer.getMinwen(),customer.getHanwen(),customer.getShuxone(),customer.getShuxtwo(),customer.getFile_id(),customer.getSentence_no());
		}else{
			System.out.println("数据已存在");
			return false;
		}
		return true;
	}*/
	public boolean save(Customer customer) {
		System.setProperty("sun.jnu.encoding","utf-8");
		String sql = "INSERT INTO bzxt(Minwen,Hanwen,Shuxone,Shuxtwo,file_id,sentence_no) VALUES(?,?,?,?,?,?)";
		update(sql, customer.getMinwen(),customer.getHanwen(),customer.getShuxone(),customer.getShuxtwo(),customer.getFile_id(),customer.getSentence_no());
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
	public List<Customer> getFile(String file_id){//根据文件的id通过order排序来返回属于这个id的语句，也就是这个文件来提供下载文件
		String sql = "SELECT Minwen FROM bzxt where file_id= ? order by sentence_no";
		return getForList(sql,file_id);
	}
	public List<Customer> showFile(String file_id){//根据文件的id通过order排序来返回属于这个id的语句，显示这个文件
		String sql = "SELECT * FROM bzxt where file_id= ?";
		return getForList(sql,file_id);
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
