package com.safety.util;

import java.security.MessageDigest;

import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.safety.entity.Mail;

public class Toolkit {
	private final Logger logger =Logger.getLogger(Toolkit.class);
	public static String getMD5(String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			byte b[] = md5.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean sendEmail(Mail mail){
		HtmlEmail email = new HtmlEmail();
		try{
			email.setHostName(mail.getHost());
			email.setCharset(Mail.ENCODING);
			email.setFrom(mail.getSender(),mail.getName());
			email.setAuthentication(mail.getUsername(), mail.getPassword());
			if(mail.getReceiverName().isEmpty()){
				email.addTo(mail.getReceiver());
			}else{
				email.addTo(mail.getReceiver(),mail.getReceiverName());
			}
			email.setSubject(mail.getSubject());
			email.setHtmlMsg(mail.getMessage());
			email.send();
			if(logger.isDebugEnabled()){
				logger.debug(mail.getSender()+" 发送邮件到 "+mail.getReceiver());
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.info(mail.getSender()+" 发送邮件到 "+mail.getReceiver()+" 失败");
			return false;
		}
	}
}
