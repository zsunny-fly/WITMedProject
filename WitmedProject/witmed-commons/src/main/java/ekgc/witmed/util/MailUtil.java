package ekgc.witmed.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


@Component("mailUtil")
public class MailUtil {
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	public  void simpleSendMail(String receiveAddr,String subject) throws Exception {
//		// 创建实例
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		// 设置发件人
//		mailMessage.setFrom("zsunny_registry@163.com");
//		// 设置收件人
//		mailMessage.setTo(receiveAddr);
//		// 设置抄送地址，否则，容易被认定为垃圾短信
//		mailMessage.setCc("zsunny_registry@163.com");
//		// 设置邮件主题
//		mailMessage.setSubject(subject);
//		// 设置发送内容 SimpleMailMessage 仅支持文本格式的内容
//		mailMessage.setText("这是 SimpleMailMessage 的邮件内容");
//		// 使用 JavaMailSender 发送邮件
//		javaMailSender.send(mailMessage);
//	}
//
//	public  void mimeSendMail(String receiveAddr, String subject) throws Exception {
//		// 通过 javaMailSender 创建 MimeMailMessage 对象
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage() ;
//		// 通过 mimeMessage 创建 MimeMailMessageHelper 对象
//		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
//		messageHelper.setFrom("zsunny_registry@163.com");
//		messageHelper.setTo(receiveAddr);
//		messageHelper.setCc("zsunny_registry@163.com");
//		messageHelper.setSubject(subject);
//		String context = "<h1>这是 <h2>张培凤-15249098426</h2>发送的邮件</h1>";
//		messageHelper.setText(context,true);
//		javaMailSender.send(mimeMessage);
//	}
}
