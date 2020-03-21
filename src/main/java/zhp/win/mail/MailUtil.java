package zhp.win.mail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MailUtil {
    private final Logger L= LoggerFactory.getLogger(MailUtil.class);
    private final boolean success=true;
    private final boolean fail=false;
    private final char SLIPT_SIGN=',';
    private Map<String,String> conf= new HashMap<String,String>();
    public void init(){
        conf.put(MailConfig.TO,"");//收件人电子邮箱,若有多个则用','分隔开
        conf.put(MailConfig.From,"");//发件人电子邮箱
        conf.put(MailConfig.Host,"");
        conf.put(MailConfig.PassWord,"");
        conf.put(MailConfig.UserName,"");
    }
    public boolean sendSimple(){
        Properties properties=System.getProperties();
        //设置邮件服务器
        properties.setProperty("mail.smtp.host", conf.get(MailConfig.Host));
        //获取session对象
        Session session=Session.getDefaultInstance(properties);
        try{
            //创建默认的MimeMessage对象
            MimeMessage message=new MimeMessage(session);
            message.setFrom(conf.get(MailConfig.From));
            //setTo头部字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(conf.get(MailConfig.TO)));
            //头部字段
            message.setSubject("This is subject Line!");
            message.setText("这是要发送的消息");
            Transport.send(message);
            L.info("["+conf.get(MailConfig.TO).toString()+"]"+"邮件发送完成");
        }catch (Exception e){
            L.error(e.getMessage());
        }
        return success;
    }
}
