package JDBC;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class text implements Serializable {
  /*  public String content;
    public text(){
        super();
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }*/

    public static void main(String[] args){
        //List list=new ArrayList();
        int min=0;
        int max=2;
        String sql = "SELECT userinfo.*,roleinfo.roleName FROM userinfo,roleinfo WHERE userinfo.roleId=roleinfo.roleId ";
        //sql.append(String.format(" limit %d, %d", min, max));
        ResultSet rs = JDBC.select(sql);
        try {
            while (rs.next()){
                System.out.println(rs.getString("userAccount"));
            }
        } catch (Exception e) {
        }

    }

}
