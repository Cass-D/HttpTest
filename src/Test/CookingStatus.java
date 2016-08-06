package Test;

import JDBC.JDBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/9.
 */
public class CookingStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql;
        int cookingStatus=Integer.parseInt(req.getParameter("cookingStatus"));
        int id=Integer.parseInt(req.getParameter("odId"));
        sql=String.format("UPDATE orderdishes SET cookingStatus=%d WHERE odId=%d",cookingStatus,id);
        JDBC.upDate(sql);
    }
}
