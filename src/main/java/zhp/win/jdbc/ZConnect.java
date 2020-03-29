package zhp.win.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhp.win.util.L;

import java.sql.*;
import java.util.Stack;

public class ZConnect {
    private Connection connection=null;
    public  String url=null;
    public  String user=null;
    public  String password=null;
    public static String Driver="";
    public Stack<Object> stack=new Stack<>();
    private  static Logger log= LoggerFactory.getLogger(ZConnect.class);
    static {
        try {
            Class.forName(Driver);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    public ZConnect(){
        this.connection=getConnection();
    }
    /**
     * 获取连接
     * @return
     */
    public Connection getConnection(){
        try {
            connection= DriverManager.getConnection(url,user,password);
        }catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return connection;
    }

    /**
     * 更新，插入，删除可以用的方法
     * @param sql
     * @param args
     * @return
     */
    public boolean update(String sql,Object...args){
        PreparedStatement ps=null;
        boolean sqlf=sql.contains("?");
        int row=0;
        try {
            ps=connection.prepareStatement(sql);
            if(!(args.length ==0)&&sqlf){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }else if(args.length==0&&sqlf){
                throw new SQLException("sql语句中有\"?\"应当输入对应的参数");
            }
            row=ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println("ps关闭异常："+e.getMessage());
            }
        }
        return row>0?true:false;
    }

    /**
     * 查询方法
     * @param sql
     * @param args
     * @return
     */
    public ResultSet Query(String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet res=null;
        boolean f=sql.contains("?");
        try {
            ps=connection.prepareStatement(sql);
            if((args.length==0)&&f){
                throw new SQLException("sql语句中有\"?\"应当输入对应的参数");
            }
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            res=ps.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        stack.push(ps);
        stack.push(res);
        return null==res?null:res;
    }

    /**
     * 寻找栈中的对象，调用对应的close()方法
     */
    public void close(){
        int a=stack.size();
        for(int i=0;i<a;i++){
            Object temp=stack.get(i);
            if(temp instanceof PreparedStatement){
                try {
                    if(temp!=null) {
                        ((PreparedStatement) temp).close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(temp instanceof ResultSet){
                try {
                    if(temp!=null) {
                        ((ResultSet) temp).close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放数据库连接
     */
    public void releaseConnect(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 清理通讯所用的栈
     */
    public void destroyStack(){
        stack.clear();
    }
}
