package com.wht.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    public static void sendMail(String email,String emailMsg) throws MessagingException {
        Properties properties=new Properties();
        //设置邮件传输协议为SMTP
        properties.setProperty("mail.transport.protocol","SMTP");
        //设置SMTP服务器地址
        properties.setProperty("mail.host","smtp.qq.com");
        //设置SMTP服务器是否需要用户验证，需要验证设置为true
        properties.setProperty("mail.smtp.auth","true");
        //创建验证器
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return new PasswordAuthentication("","");
                return new PasswordAuthentication("","");
            }
        };
        //实例化邮件会话Session
        Session session=Session.getInstance(properties,auth);
        //创建一个Message，该对象相当于邮件内容
        Message message=new MimeMessage(session);
        //设置发送者
        message.setFrom(new InternetAddress("32670876@qq.com"));
        //设置发送方式与接收者，邮件接收者在调用sendMail()方法时通过参数传递进来
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
        //设置发出的邮件主题
        message.setSubject("用户激活");
        message.setContent(emailMsg,"text/html;charset=utf-8");
        Transport.send(message);

    }
}
