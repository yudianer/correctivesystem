package com.cmli.correctivesystem.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	/**
	 * 释放
	 * @param connection
	 */
	public static void  releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource =null;
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 *连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
