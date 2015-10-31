package com.cmli.correctivesystem.dao.impl2;
import java.util.List;

import com.cmli.correctivesystem.dao.DAO;
import com.cmli.correctivesystem.dao.CustomerDAO;
import com.cmli.correctivesystem.domain.Customer;
import com.cmli.correctivesystem.file.FileNameId;
public class CustomerDAOJdbclmpl2 extends DAO<FileNameId> {
	public List<FileNameId> getFilesNameAndId(){//从file表中得到id和file_name
			String sql = "SELECT id,file_name FROM file";
			return getForListFileNameId(sql);
		}
	public int save(String fileName) {
		System.setProperty("sun.jnu.encoding","utf-8");
		String sql = "INSERT INTO file(file_name) VALUES(?)";
		update(sql,fileName);
		sql="select id from file order by id desc limit 1";
		int id=getForVaule(sql);
		return id;
	}
}
