package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/6/2.
 */

//数据库插入操作类
public class JDBC {
    //获取数据库连接对象方法
    public  static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersys","root","x5");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //'notice'表数据插入方法
    public static void notice(String content){
        Connection conn = getConnection();
        String sql ="INSERT INTO notice(content)"+
                String.format("VALUES('%s')",content);
        try{
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //'userinfo'表数据插入方法
    public static void userinfo(String userAccount,String userPass,int role){
        Connection conn = getConnection();
        String sql ="INSERT INTO userinfo(userAccount,userPass,role)"+
                String.format("VALUES('%s','%s','%d')",userAccount,userPass,role);
        try{
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //'dishesinfo'表数据插入方法
    public static void dishesinfo(String dishesName,String dishesDiscript,String dishesImg,String dishesTxt,int recommend,float dishesPrice){
        Connection conn = getConnection();
        String sql ="INSERT INTO dishesinfo(dishesName,dishesDiscript,dishesImg,dishesTxt,recommend,dishesPrice)"+
                String.format("VALUES('%s','%s','%s','%s','%d','%f')",dishesName,dishesDiscript,dishesImg,dishesTxt,recommend,dishesPrice);
        try{
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //'orderinfo'表数据插入方法
    public static void orderinfo(int waiterId,int tableId){
        Connection conn = getConnection();
        String sql ="INSERT INTO orderinfo(waiterId,tableId)"+
                String.format("VALUES('%d','%d')",waiterId,tableId);
        try{
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //'orderdishes'表数据插入方法
    public static void orderdishes(int orderReference,int dishes,int num){
        Connection conn = getConnection();
        String sql ="INSERT INTO orderdishes(orderReference,dishes,num)"+
                String.format("VALUES('%d','%d','%d')",orderReference,dishes,num);
        try{
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //数据库查询操作方法
    public static ResultSet select(String sql){
        //String sql = "SELECT * FROM userinfo";
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    //数据修改操作方法
    public static void upDate(String sql){
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.print(count);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
