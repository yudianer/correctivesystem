package com.cmli.correctivesystem.dao;

import java.util.List;

import com.cmli.correctivesystem.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAll(); // 获取所有数据
	
	public boolean save (Customer customer); //保存数据
	
	public Customer get(Integer id); //获取某个数据
	
	public void delete(Integer id); //删除某个数据
	
	/**
	 * 返回和name 相等的记录数
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name); //获取所有符合条件的值的数量

	public Customer get(String minwen);// 根据某个字段获取值
	
	public int getId(String minwen);//根据某个字段获取ID

}
