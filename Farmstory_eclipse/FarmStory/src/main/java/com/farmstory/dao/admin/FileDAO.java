package com.farmstory.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.util.DBHelper;

public class FileDAO extends DBHelper {
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO () {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	public void insertListFile() {}
	public void selectListFile() {}
	public void selectListFiles() {}
	public void updateListFile() {}
	public void deleteListFile() {}
	
	public void insertBasicFile() {}
	public void selectBasicFile() {}
	public void selectBasicFiles() {}
	public void updateBasicFile() {}
	public void deleteBasicFile() {}
	
	
	
	public void insertDescFile() {}
	public void selectDescFile() {}
	public void selectDescFiles() {}
	public void updateDescFile() {}
	public void deleteDescFile() {}
	

}
