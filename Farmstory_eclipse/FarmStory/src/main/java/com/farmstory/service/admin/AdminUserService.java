package com.farmstory.service.admin;

import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.user.UserDao;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.user.UserDTO;

public enum AdminUserService {

	INSTANCE;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserDao dao = UserDao.getInstance();

	

	// 전체 게시물 갯수에서 마지막 페이지 번호 구하기 
		public int getLastPageNum(int total) {
			
			int lastPageNum = 0;
			
			if(total % 10 == 0) {
				lastPageNum = total / 10;
			}else {
				lastPageNum = total / 10 + 1;
			}
			return lastPageNum;
		}
		
		// 페이지 시작번호(limit용)
		public int getStartNum(int currentPage) {
			return (currentPage - 1) * 10;
		}
		
		// 현재 페이지번호 구하기
		public int getCurrentPage(String pg) {
			
			int currentPage = 1; // 처음 들어왔을때 파라미터 pg가 null이라서 첫페이지가 조회됨
			
			if(pg != null) {
				currentPage = Integer.parseInt(pg);
			}
			
			return currentPage;
		}
		
		// 현재 페이지 그룹 구하기 
		public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
			
		 	int currentPageGroup = (int) Math.ceil(currentPage / 10.0); // 현재 그룹 번호
			int pageGroupStart = (currentPageGroup - 1) * 10 + 1; // 그룹 시작 번호 
		 	int pageGroupEnd = currentPageGroup * 10; // 그룹 마지막 번호 
		 			
		 	if(pageGroupEnd > lastPageNum){
				pageGroupEnd = lastPageNum;
			}
		 	
			return new PageGroupDTO(pageGroupStart, pageGroupEnd);
		}
		
		// 페이지 시작번호
		public int getPageStartNum5(int total, int currentPage) {
			int start = (currentPage - 1) * 5;
			return total - start;
		}
		
		
	
			
			public int selectCountTotal() {
			return dao.selectCountTotal();
		}
	
		
	public int selectCountUser (String type,String value) {
		return dao.selectCountUser(type, value);
	}

	public void insertUser(UserDTO dto) { dao.insertUser(dto);	}
	
	public UserDTO selectUser(String uid,String pass) {	
		return dao.selectUser(uid, pass);
	}
	
	public List<UserDTO> selectUsers() {	
		return dao.selectUsers();
		
	}public List<UserDTO> selectUsers(int start) {	
		return dao.selectUsers();
	}
	
	public void updateUser(UserDTO dto) {dao.updateUser(dto);	}
	
	public void deleteUser(String uid) {	dao.deleteUser(uid);}

}
