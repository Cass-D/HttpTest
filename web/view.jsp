<%@ page import="JDBC.JDBC" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Cass
  Date: 2016/6/5
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看</title>
   <script language="javascript" src="dw/AjaxRequest.js"></script>
    <script language="JavaScript">
    setInterval("aaa()","5000");//5秒刷新一次
    function aaa(){
        checkInfo();
    }

    function checkInfo(){
        var url='checkInfo.jsp';
        getInfo(url);
    }
    function getInfo(url){
        var loader=new net.AjaxRequest(url,seccous,onerror,"GET");
    }
    function onerror() {
        alert("错误");
    }
    function seccous(){
        //alert("cg");
        //用来获取label把服务器查询出来的内容显示到label
        document.getElementById("dd").innerHTML=("每5秒进行刷新数据,最新的一条数据是：")+this.req.responseText;
    }
</script>
</head>
<body onload="aaa()">
<h2>
    dddfggew
</h2>
<label  id="dd" >
    <%--<%= request.getAttribute("userAccount")%>--%>
</label>
</body>
</html>

