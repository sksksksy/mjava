package zhp.win.mail;

public class MailEntity {
    public   String TO;
    public   String From;
    public   String Host;
    public   String UserName;
    public   String PassWord;

    public MailEntity() {

    }
    private static MailEntity mailEntity = new MailEntity();
    public MailEntity mailEntity(){
        if(mailEntity !=null){
            return mailEntity;
        }else{
            return new MailEntity();
        }
    }
    private MailEntity(String TO,String msg,String title){

    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
