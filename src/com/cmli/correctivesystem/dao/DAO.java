package com.cmli.correctivesystem.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cmli.correctivesystem.db.JdbcUtils;
import com.cmli.correctivesystem.file.FileNameId;

/**
 * 数据获取类，不必修改
 * @author gaden
 *
 * @param <T>
 */
public class DAO<T> {
	
	private  QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;
	
	public DAO(){
		
		Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs[0] != null && typeArgs.length > 0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>) typeArgs[0];
				}
			}
			
		}
		
	}
	/**
	 * 
	 * 根据查询SQl条件  获取某个值
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForVaule(String sql,Object ...args){
		Connection connection =null;
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler<T>(), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 根据SQL 查询条件 获取某个值的集合list  (获取符合条件的所有值)
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args){
		Connection connection =null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	public List<T> getForListFileNameId(String sql,Object ...args){
		Connection connection =null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
//	public List<FileNameId> getForListFileNameId(String sql,Object ...args){
//		Connection connection =null;
//		try {
//			connection = JdbcUtils.getConnection();
//			return (List<FileNameId>) queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			JdbcUtils.releaseConnection(connection);
//		}
//		
//		return null;
//	}
	/**
	 * 获取某个
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args){

		Connection connection =null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	/**
	 * 更新操作 INSERT UADATA DELETE 
	 * @param sql
	 * @param args
	 */
	public void update(String sql, Object ...args){
		System.setProperty("sun.jnu.encoding","utf-8");
		Connection connection =null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
	}

}
