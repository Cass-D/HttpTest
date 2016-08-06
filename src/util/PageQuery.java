package util;

import java.sql.*;
import javax.servlet.http.*;

public class PageQuery {

    int Offset; // 记录偏移量
    int Total; // 记录总数

    int MaxLine; // 记录每页显示记录数
    ResultSet rs; // 读出的结果

    int TPages; // 总页数
    int CPages; // 当前页数

//    String PageQuery; // 分页显示要传递的参数
    String Query; // query 语句
    String QueryPart; // " FROM " 以后的 query 部分

    String FilePath;

    PagedbClass db;
    public PageQuery() {
// 每页显示2行
        MaxLine = 2;
        db = new PagedbClass();
    }

//********读取记录***************
//　主要工作函数，根据所给的条件从表中读取相应的记录

    public ResultSet myQuery(String query, HttpServletRequest req) throws SQLException {

        String query_part, os;
        int begin;

        // 截取 " FROM " 以后的 query 语句
        begin = query.indexOf(" FROM ");
        query_part = query.substring(begin, query.length()).trim();

// 计算偏移量
        os = req.getParameter("offset");
        if (os == null) Offset = 0;
        else Offset = Integer.parseInt(os);

// 获取文件名
        FilePath = req.getRequestURI();

        Query = query;
        QueryPart = query_part;

// 计算总的记录条数
        String SQL = "SELECT Count(*) AS total " + this.QueryPart;
        rs = db.executeQuery(SQL);
        if (rs.next())
            Total = rs.getInt(1);

// 设置当前页数和总页数
        TPages = (int)Math.ceil((double)this.Total/this.MaxLine);
        CPages = (int)Math.floor((double)Offset/this.MaxLine+1);

// 根据条件判断，取出所需记录
        if (Total > 0) {
            SQL = Query + " LIMIT " + Offset + " , " + MaxLine;
            rs = db.executeQuery(SQL);
        }

        return rs;
    }
    public void close(){
        db.closedb();
    }

//    // 显示总页数
//    public int getTotalPages() {
//        return TPages;
//    }
//
//    //显示当前所在页数
//    public int getCurrenPages() {
//        return CPages;
//    }

// 显示首页、下页、上页、尾页
    public String PageLegend() {

        String str = "";
        int first, next, prev, last;
        first = 0;
        next = Offset + MaxLine;
        prev = Offset - MaxLine;
        last = (this.TPages - 1) * MaxLine;

        if(Offset >= MaxLine)
            str += "<button type='button'' class='btn btn-default btn''><A href=" + FilePath + "?offset=" + first + ">首页</button></A>";
        else str += "<button type='button'' class='btn btn-default btn' disabled='disabled'>首页</button>";
        if(prev >= 0)
            str += "<button type='button'' class='btn btn-default btn''><A href=" + FilePath + "?offset=" + prev + ">上一页</button></A> ";
        else str += "<button type='button'' class='btn btn-default btn' disabled='disabled'>上一页</button>";
        if(next < Total)
            str += "<button type='button'' class='btn btn-default btn''><A href=" + FilePath + "?offset=" + next + ">下一页</li></A> ";
        else str += "<button type='button'' class='btn btn-default btn' disabled='disabled'>下一页</button>";
        if(TPages != 0 && CPages < TPages)
            str += "<button type='button'' class='btn btn-default btn''><A href=" + FilePath + "?offset=" + last + ">尾页</li></A>";
        else str += "<button type='button'' class='btn btn-default btn' disabled='disabled'>尾页</button>";

//        str += " <ul class='pagination'><li>页次：</li></ul>" + getCurrenPages() + "<li>/</li>" + getTotalPages() + "<li>页</li> ";
//        str += MaxLine + "<li>条/页</li> " + "<li>共</li>" + Total + "<li>条</li>";
//        String pageNum;
        return str;
    }
}