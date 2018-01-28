package com.vincent.newshop.common.utils;


import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 上午 10:47 2018/1/2 0002
 */
public final class MailUtils {
    private static Properties props;
    private static Session session;


    static {
        props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        session = Session.getInstance(props);
        session.setDebug(true);

    }

    public static String sendMessage(String receiveEmail) throws IOException, MessagingException {


        MimeMessage message = createMessage("13813456184@163.com", receiveEmail);

        Transport transport = session.getTransport();
        transport.connect("18924919769@163.com", "941229z");

        String code= UUID.randomUUID().toString().replace("-", "");

        message.setContent(code, "text/html;charset=UTF-8");
        transport.sendMessage(message, message.getAllRecipients());

        transport.close();

        return code;
    }

    private static MimeMessage createMessage(String sendEmail, String receiveEmail) throws MessagingException, IOException {

        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(sendEmail, "你爸爸", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmail, "洋之", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("18924919769@163.com", "USER_EE", "UTF-8"));

        message.setSubject("这是一封测试邮件");
        message.setSentDate(new Date());
        message.saveChanges();

        return message;
    }
}
