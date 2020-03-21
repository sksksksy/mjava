package zhp.win.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMailException extends Exception{
    private Logger log= LoggerFactory.getLogger(SendMailException.class);
    public SendMailException(){
    }
    public SendMailException(String msg){
        super(msg);
    }
    public SendMailException(Throwable e){
        super(e);
    }
}
