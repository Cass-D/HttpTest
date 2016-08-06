package Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cass on 2016/6/15.
 */
public class ProductDao {
    public Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ordersys";
            String user = "root";
            String password = "x5";
            conn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public int findCount(){
        int count=0;
        Connection conn = getConnection();
        String sql = "select count(*) from orderdishes";
        try {
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);  //对总记录数赋值
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;        //返回总记录数
    }
    public List<Product> find(int page){
        List<Product> list = new ArrayList<Product>();
        Connection conn = getConnection();
        String sql = "select* from orderdishes order by odId desc limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page-1)*Product.PAGE_SIZE);
            ps.setInt(2, Product.PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setOdId(rs.getInt("odId"));
                p.setDishes(rs.getInt("dishes"));
                p.setCookingStatus(rs.getInt("cookingStatus"));
                p.setOrderReference(rs.getInt("orderReference"));
                p.setNum(rs.getInt("num"));
                list.add(p);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}