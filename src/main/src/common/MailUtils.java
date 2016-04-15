package main.src.common;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class MailUtils {
	static private String MyMail = "ansyx@163.com"; 
	static private String PASSWORD="a54417522";
	static private final String SUBJECT="夜网帐号激活";
	static private final String Salutation_Reg="(?<=id=\"salutation\">)[^<]+(?=</p>)";
	static private final String Href_Reg = "(?<=href=\")[^\"]*(?=\")";
	static public String baseRealPath = ((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/");
	static public String templatePath = baseRealPath + MessageUtils.getMessageFromUrl("template.email");
	static public String base = MessageUtils.getMessageFromUrl("base");
    /**
     * 发送邮件的props文件
     */
    private final transient Properties props = System.getProperties();
    /**
     * 邮件服务器登录验证
     */
    private transient MailAuthenticator authenticator;
 
    /**
     * 邮箱session
     */
    private transient Session session;
    public MailUtils(String Sender,String password){
    	this.MyMail = Sender;
    	this.PASSWORD = password;
    }
    public MailUtils(){
    }
	public String sendEmail(String recipient,String subject,String content){
		init();
		 // 创建mime类型邮件
	    final MimeMessage message = new MimeMessage(session);
	    // 设置发信人
	    try {
	    message.setFrom(new InternetAddress(authenticator.getUsername()));
	    // 设置收件人
	    message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
	    // 设置主题
	    message.setSubject(subject);
	    // 设置邮件内容
	    message.setContent(content.toString(), "text/html;charset=utf-8");
	    // 发送
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String sendActivateEmail(String recipient,String nick_name,String token){
		String content = StrUtils.fileToString(templatePath+"activateMail.html");
		content = content.replaceAll(Salutation_Reg, nick_name+", 感谢你注册夜网");
		content = content.replaceAll(Href_Reg, base + "activate/" + token +"/");
		sendEmail(recipient, SUBJECT, content);
		return null;
	}
	 private void init() {
		 final String smtpHostName = "smtp." + MyMail.split("@")[1];
	    // 初始化props
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.host", smtpHostName);
	    // 验证
	    authenticator = new MailAuthenticator(MyMail, PASSWORD);
	    // 创建session
	    session = Session.getInstance(props, authenticator);
	    }
	 
}
