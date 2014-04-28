package email;

import java.io.IOException;
import java.util.Properties;

import email.My_memberDAOAware;
import email.my_memberDTO;

import org.apache.struts2.interceptor.ServletRequestAware;



import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.Address;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.servlet.http.HttpServletRequest;
import javax.mail.PasswordAuthentication;

import java.util.Properties;

public class my_SendMailAction  implements Action, ServletRequestAware,My_memberDAOAware{

	private SqlMapClient sqlMapper;
	private HttpServletRequest request;
	private int emailcheck;
	private String subject="인증번호 전송";
	private String sender = "skatnr0202@gmail.com";
	private String receiver;
	private String content;
	private my_memberDTO memberDTO; 
	private String myid;
	
	
	public String execute() throws Exception {
		memberDTO = new my_memberDTO();
		memberDTO.setMyid(getMyid());
		System.out.println("1");
		//System.out.println(myid);
		
		emailcheck =(int) (Math.floor(Math.random() * 1000000)+100000);
		  if(emailcheck>1000000){
			  emailcheck = emailcheck - 100000;
		  }		
		  		
		  content = "귀하의 인증번호는 (" +emailcheck+")입니다.";
		  my_memberDTO dto = (my_memberDTO)sqlMapper.queryForObject("my_selectEmail",myid);
		  receiver = String.valueOf(dto.getEmail());
		  memberDTO.setEmailcheck(emailcheck);
		  sqlMapper.update("my_CheckUpdate", memberDTO);
		  
		  System.out.println(myid);
		  System.out.println(receiver);
		  System.out.println(subject);
		  System.out.println(sender);
		  System.out.println(content);
		
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("setStartTLSRequired","true"); 
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.soketFactory.port", "587");
		p.put("mail.smtp.soketFactory.class", "javax.net.ssl.SSLSoketFactory");
		p.put("mail.smtp.soketFactory.fallback", "false");
		p.put("mail.transport.protocol","smtp" ); 
		
			
			Session ses= Session.getInstance(p, new SMTPAuthenticator());
			
			
			//메일을 전송할때 상세한 상황을 콘솔에 출력.
			ses.setDebug(true);
			
			//메일의 내용을 담기위한 객체
			MimeMessage msg = new MimeMessage(ses);
			
			//제목설정
			msg.setSubject(subject);
			
			//보내는 사람의 메일주소
			Address fromAddr = new InternetAddress(sender);
			msg.setFrom(fromAddr);
			
			//받는 사람의 메일주소
			Address toAddr = new InternetAddress(receiver);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			
			
			msg.setContent(content, "text/html;charset=UTF-8");
			
			
			Transport.send(msg);
			
			
	     return SUCCESS;
	}


	public my_memberDTO getMemberDTO() {
		return memberDTO;
	}


	public void setMemberDTO(my_memberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	


	public void setMy_memberDAO(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
		
	}


	public String getMyid() {
		return myid;
	}


	public void setMyid(String myid) {
		this.myid = myid;
	}

}
