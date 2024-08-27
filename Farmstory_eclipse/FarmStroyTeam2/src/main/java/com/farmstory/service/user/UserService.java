package com.farmstory.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.user.UserDao;
import com.farmstory.dto.user.UserDTO;

public enum UserService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserDao dao = UserDao.getInstance();

	public void insertUser(UserDTO dto) { dao.insertUser(dto);	}
	public UserDTO selectUser(String uid,String pass) {	
		return dao.selectUser(uid, pass);
	}
	public List<UserDTO> selectUsers() {	
		List<UserDTO> users = dao.selectUsers();
		return users;
	}
	public void updateUser(UserDTO dto) {dao.updateUser(dto);	}
	public void deleteUser(String uid) {	dao.deleteUser(uid);}
}
