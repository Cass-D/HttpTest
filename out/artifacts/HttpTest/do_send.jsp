<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="JDBC.JDBC" %><%--
  Created by IntelliJ IDEA.
  User: Cass
  Date: 2016/6/5
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="user" class="JDBC.text"></jsp:useBean>
<jsp:setProperty name="user" property="content"/>--%>
<%
    String content=request.getParameter("content");
    request.setAttribute("content",content);
    JDBC.notice(content);
%>
<jsp:forward page="index.jsp"></jsp:forward>
