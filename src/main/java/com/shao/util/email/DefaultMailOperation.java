package com.shao.util.email;


import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class DefaultMailOperation extends MailOperation {
    public Properties setProperties(String host, String port){
        // 定义properties对象，设置环境信息
        Properties props = System.getProperties();
        /*
         * mail.smtp.host ：指定连接的邮件服务器的主机名。如：163邮箱就填写smtp.163.com
         * 若在本地测试的话，需要在本地安装smtp服务器
         */
        props.put("mail.smtp.host", host);
        // mail.smtp.auth：指定客户端是否要向邮件服务器提交验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.transport.protocol", "smtp");
        return  props;
    }

    public MailAuthenticator getMailAuthenticator(String user, String password){
        MailAuthenticator auth = new MailAuthenticator();
        auth.user_name = user;// 此处填写发送的邮箱名
        auth.password = password;// 此处填写登录的邮箱密码
        return auth;
    }

    public MimeMessage getMessage(Session session, String from, String[] to, String subject) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 设置邮件发送方
        message.setFrom(new InternetAddress(from));
        //To: 收件人 增加收件人
        for (String address : to){
            if (StringUtils.isNotBlank(address)){
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(address.trim()));
            }
        }
        // 设置邮件发送的主题<邮件标题>
        message.setSubject(subject);
        return message;
    }

    //邮件发送消息部分
    public void setContent(MimeMessage message, String content, String[] filePath) throws Exception {
        if (filePath.length > 0){
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setContent(content, "text/html;charset=utf-8");
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            for (String file : filePath){
                // 附件部分
                BodyPart fileBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(file);
                fileBodyPart.setDataHandler(new DataHandler(source));
                fileBodyPart.setFileName(file);
                multipart.addBodyPart(fileBodyPart);
                // 发送完整消息
                message.setContent(multipart);
            }
        }else {
            message.setContent(content,"text/html;charset=utf-8");
        }
        message.setSentDate(new Date());
        message.saveChanges();
    }
}
