package email;

import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		//���̹��� Gmail ����� ���� ����.
		//Gmail�� ��� @Gmail.com�� ������ ���̵� �Է��Ѵ�.
		return new PasswordAuthentication("skatnr0202@gmail.com","dkagh1234.");
	}
}