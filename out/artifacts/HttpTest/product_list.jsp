<%--
  Created by IntelliJ IDEA.
  User: Cass
  Date: 2016/6/15
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ page import="Test.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title>Insert title here</title>
    <script>
        function checkDelete(id, name, obj) {
            msg = '�Ƿ�'+ name +'��⿣�';
            if (confirm(msg)) {
                xmlAjaxRequest("/CookingStatus?odId=" + id + "&cookingStatus=" + 1, "post", true, null, deleteCallback, obj, null);
            }
        }
        function deleteCallback(responseTxt, obj) {
            alert("�ɹ���");
            obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
        }
    </script>

</head>
<body <%--onload="aaa()"--%>>
<table align="center" width="450" border="1">
    <thead>
    <tr>
        <th class="tableCenter">���</th>
        <th class="tableCenter">�������</th>
        <th class="tableCenter">��Ʒ���</th>
        <th class="tableCenter">��Ʒ������</th>
        <th class="tableCenter">���״̬</th>
        <th class="tableCenter">����</th>
    </tr>
    </thead>
    <tbody id="orderdishes">
    </tbody>
    <%
        List<Product> list=(List<Product>)request.getAttribute("list");
        for(Product p:list){
    %>
    <tr align="center">
        <td><%=p.getOdId() %></td>
        <td><%=p.getOrderReference() %></td>
        <td><%=p.getDishes() %></td>
        <td><%=p.getNum() %></td>
        <td><%=p.getCookingStatus()==0?"�����":"δ���" %></td>
        <td class="tableCenter">
            <a href="#" onclick="checkDelete('<%=p.getCookingStatus()%>','<%=p.getCookingStatus()%>',this)" title="���" name="aaa">
            </a>
        <button name="aaa"  onclick="checkDelete('<%=p.getCookingStatus()%>','<%=p.getCookingStatus()%>',this)">ddd </button>
        </td>

    </tr>
    <%
        }
    %>
    <tr>
        <td align="center" colspan="5">
            <%=request.getAttribute("bar") %>
            <a href="FindServert?page=2">��һҳ</a>
        </td>
    </tr>
</table>
</body>
</html>
