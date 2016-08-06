<%--
  Created by IntelliJ IDEA.
  User: Cass
  Date: 2016/6/23
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@  page import="java.sql.*" %>
<%@ page import="Test.Product" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'showAllByPage.jsp' starting page</title>
</head>
<%
    ResultSet rs = null;
    PreparedStatement pstmt =null;
    Connection conn = null;
   /* List<DeptVo> list = new ArrayList<DeptVo>();*/
    List<Product> list = new ArrayList<Product>();
    try {
        String page1 = request.getParameter("page");//获得页面传递过来的page值赋值给page1
        int page2 =1;
        if(page1 != null){
            //如果页面传递过来的page值存在，则把该page1赋值给page2变量
            page2 = Integer.parseInt(page1);
        }
        request.setAttribute("page2", page2);
        Class.forName("com.mysql.jdbc.Driver" );//创建数据库驱动
        //连接数据库
        conn =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersys","root","x5");
        //分页查询的SQL语句，每页显示5条记录
        String sql = "select * from orderdishes order by odId desc limit ?,?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, page2);
        rs = pstmt.executeQuery();
        while(rs.next()){
            Product p=new Product();
            p.setOdId(rs.getInt("odId"));
            p.setDishes(rs.getInt("dishes"));
            p.setCookingStatus(rs.getInt("cookingStatus"));
            p.setOrderReference(rs.getInt("orderReference"));
            p.setNum(rs.getInt("num"));
            list.add(p);
            request.setAttribute("list", list);
        }
        int count =0;//声明一个count变量，用于存储记录数
        int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
        Statement stmt = conn.createStatement();
        String sql1 ="select count(*) from orderdishes";//查询总记录数的SQL语句

        rs = stmt.executeQuery(sql1);

        while (rs.next()) {
            count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
        }
        maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
        request.setAttribute("maxpage", maxpage);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<body>
<table border="1" align="center" width="70%">
    <tr>
        <td>部门编号</td>
        <td>部门地址</td>
        <td>部门人数</td>
        <td>部门名称</td>
        <td>部门id</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.odId }</td>
            <td>${list.dishes }</td>
            <td>${list.cookingStatus }</td>
            <td>${list.orderReference }</td>
            <td>${list.num }</td>
        </tr>
    </c:forEach>
</table>
<div align="center">

    <a href="?page=1">首页</a>
    <c:if test="${page2 ==1}">上一页</c:if>
    <c:if test="${page2 > 1}"><a href="?page=${page2 -1 }">上一页</a></c:if>
    <c:if test="${page2 == maxpage}">下一页</c:if>
    <c:if test="${page2 < maxpage}"><a href="?page=${page2 +1 }">下一页</a></c:if>
    <a href="?page=${maxpage }">末页</a>
</div>
</body>
</html>