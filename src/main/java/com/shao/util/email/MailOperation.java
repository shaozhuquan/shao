package com.shao.util.email;




import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public abstract class MailOperation {
    private static Logger logger = LoggerFactory.getLogger(MailOperation.class);
    public boolean doSendMail(String user, String password, String host, String port, String to, String content) throws Exception{
        return doSendMail(user, password, host, port, user,new String[]{to}, null, content, new String[]{});
    }

    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param content
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String to, String content) throws Exception{
        return doSendMail(user, password, host, port, from,new String[]{to}, null, content, new String[]{});
    }
    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String to, String subject, String content) throws Exception{
        return doSendMail(user, password, host, port, from, new String[]{to}, subject, content, new String[]{});
    }

    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String[] to, String subject, String content) throws Exception{
        return doSendMail(user, password, host, port, from, to, subject, content, new String[]{});
    }

    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String to, String subject, String content, String filePath) throws Exception{
        return doSendMail(user, password, host, port, from, new String[]{to}, subject, content, new String[]{filePath});
    }
    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String[] to, String subject, String content, String filePath) throws Exception{
        return doSendMail(user, password, host, port, from, to, subject, content, new String[]{filePath});
    }

    /**
     *
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String to, String subject, String content, String[] filePath) throws Exception{
        return doSendMail(user, password, host, port, from, new String[]{to}, subject, content, filePath);
    }

    /**
     *采用魔板方法模式
     * @param user
     * @param password
     * @param host
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws Exception
     */
    public boolean doSendMail(String user, String password, String host, String port, String from,
                                  String[] to, String subject, String content, String[] filePath) throws Exception{
        if(to.length > 0 && StringUtils.isNotBlank(to[0])){
            try {
                // 定义properties对象，设置环境信息
                Properties props = this.setProperties(host,port);
                //邮箱登录名和密码（密码明码和授权码）
                MailAuthenticator auth = this.getMailAuthenticator(user,password);
                // 获取session对象
                Session session = Session.getInstance(props, auth);
                // 当设置为true，JavaMail AP就会将其运行过程和邮件服务器的交互命令信息输出到console中，用于JavaMail的调试
                session.setDebug(true);
                // 创建邮件对象
                MimeMessage message = this.getMessage(session,from,to,subject);
                // 创建消息部分
                this.setContent(message,content,filePath);

                Transport.send(message);
                logger.info("邮件发送成功："+message.toString());
                return true;
            }catch (AuthenticationFailedException e){
                e.printStackTrace();
                logger.error("发送邮件失败\t\terror:用户名或密码不对");
                throw new AuthenticationFailedException("用户名或密码不对");
            }catch (SendFailedException e){
                e.printStackTrace();
                logger.error("发送邮件失败\t\terror:发件人邮箱不对");
                throw new SendFailedException("发件人邮箱不对");
            }catch (MessagingException e){
                e.printStackTrace();
                logger.error("发送邮件失败\t\terror:服务器地址不对");
                throw new MessagingException("服务器地址不对");
            }catch (Exception e){
                e.printStackTrace();
                logger.error("发送邮件失败\t\terror:"+e.getMessage());
                throw new Exception(e.getMessage());
            }
        }else {
            return false;
        }
    }

    public abstract Properties setProperties(String host, String ip);

    public abstract MailAuthenticator getMailAuthenticator(String user, String password);

    public abstract MimeMessage getMessage(Session session, String from, String[] to, String subject) throws Exception ;

    //邮件发送消息部分
    public abstract void setContent(MimeMessage message, String content, String[] filePath) throws Exception ;
}
