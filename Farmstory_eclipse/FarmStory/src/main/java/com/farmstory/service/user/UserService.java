package com.farmstory.service.user;

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
import com.farmstory.dto.user.UserDTO;

public enum UserService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserDao dao = UserDao.getInstance();

public UserDTO selectNameEmail(String name, String email) {return dao.selectNameEmail(name,  email);}
public String sendEmailCode(String email) {
		
		// 인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		// 이메일 기본 정보
		String title = "FarmStory 인증번호 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		String sender = "gkdntn@gmail.com";
		String appPass = "cztl pprm haxl eupx"; // google 앱 비밀번호

		// gmail SMTP 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		// gmail session 생성
		Session gmailSession = Session.getInstance(props, new Authenticator(){
			
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sender, appPass);
			}
		});
		
		// 메일 발송
		Message message = new MimeMessage(gmailSession);
		
		try{	
		message.setFrom(new InternetAddress(sender, "보내는사람", "UTF-8"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject(title);
		message.setContent(content, "text/html;charset=utf-8");
		
		Transport.send(message);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return ""+code;
	}


	

	public int updateUserPass(String uid,String pass) {
		return dao.updateUserPass(uid,pass);
	}
	
	public int selectCountUser (String type,String value) {
		return dao.selectCountUser(type, value);
	}
	
	public void insertUser(UserDTO dto) { dao.insertUser(dto);	}
	public UserDTO selectUser(String uid,String pass) {	
		return dao.selectUser(uid, pass);
	}
	public UserDTO selectUserCart(String uid) {	
		return dao.selectUserCart(uid);
	}
	public List<UserDTO> selectUsers() {	
		return dao.selectUsers();
	}
	public void updateUser(UserDTO dto) {dao.updateUser(dto);	}
	public void deleteUser(String uid) {	dao.deleteUser(uid);}

}
