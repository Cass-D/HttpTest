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
        String page1 = request.getParameter("page");//���ҳ�洫�ݹ�����pageֵ��ֵ��page1
        int page2 =1;
        if(page1 != null){
            //���ҳ�洫�ݹ�����pageֵ���ڣ���Ѹ�page1��ֵ��page2����
            page2 = Integer.parseInt(page1);
        }
        request.setAttribute("page2", page2);
        Class.forName("com.mysql.jdbc.Driver" );//�������ݿ�����
        //�������ݿ�
        conn =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersys","root","x5");
        //��ҳ��ѯ��SQL��䣬ÿҳ��ʾ5����¼
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
        int count =0;//����һ��count���������ڴ洢��¼��
        int maxpage = 0;//����һ��maxpage������ԭ����ʾ���ҳ��
        Statement stmt = conn.createStatement();
        String sql1 ="select count(*) from orderdishes";//��ѯ�ܼ�¼����SQL���

        rs = stmt.executeQuery(sql1);

        while (rs.next()) {
            count = rs.getInt(1);//�����������ڣ���¼����ʼ��ֵΪ1
        }
        maxpage = (count+4)/5;//���ҳ�������ܼ�¼��������4���ٳ���5
        request.setAttribute("maxpage", maxpage);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<body>
<table border="1" align="center" width="70%">
    <tr>
        <td>���ű��</td>
        <td>���ŵ�ַ</td>
        <td>��������</td>
        <td>��������</td>
        <td>����id</td>
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

    <a href="?page=1">��ҳ</a>
    <c:if test="${page2 ==1}">��һҳ</c:if>
    <c:if test="${page2 > 1}"><a href="?page=${page2 -1 }">��һҳ</a></c:if>
    <c:if test="${page2 == maxpage}">��һҳ</c:if>
    <c:if test="${page2 < maxpage}"><a href="?page=${page2 +1 }">��һҳ</a></c:if>
    <a href="?page=${maxpage }">ĩҳ</a>
</div>
</body>
</html>