<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/4
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JDBC.JDBC" %>
<%@ page import="java.sql.ResultSet" %>
<jsp:useBean id="pq" scope="page" class="util.PageQuery" />
<html lang="en">
<head>
    //<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <title>点餐系统</title>

</head>

<body>
<!-- 顶部导航 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand " href="#" style="padding-left: 35px">
            <span class="glyphicon glyphicon-home navFont"><strong class=“systemTitle”> 木叶村-餐厅到店点餐系统</strong></span>
        </a>
    </div>
</nav>
<div class="container-fluid">
</div>
<!-- 右边详细内容 -->
<!-- <div class="container"> -->
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">员工列表</h3>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th class="tableCenter">员工编号</th>
                        <th class="tableCenter">员工帐号</th>
                        <th class="tableCenter">员工角色</th>
                        <th class="tableCenter">员工状态</th>
                        <th class="tableCenter">操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderTable">
                    <%
                        /*String sql = "SELECT userinfo.*,roleinfo.roleName FROM userinfo,roleinfo WHERE userinfo.roleId=roleinfo.roleId limit 0,3";
                        ResultSet rs = JDBC.select(sql);*/
                        String query = "SELECT * FROM userinfo";
                        ResultSet rs = pq.myQuery(query, request);
                        String bar = pq.PageLegend();
                        out.println("<ul class='pager'><li class='previous'>"+bar+"</li></ul>");
                         }
                            rs.close();
                        } catch (Exception e) {
                        }
                    %>
                    </tbody>
                </table>
                <nav style="text-align: center">
                    <ul class="pagination pagination-lg pager">
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <hr>
        <%--<div style="text-align: center;">
            如果您需要在系统中添加一名员工，请点击右边的按钮：<a href="adminAddUser.jsp" class="btn btn-primary addUserAndDishes">添加员工</a>
        </div>--%>
    </div>

    <footer>
        <p>&copy; ${ORDER_SYS_NAME}-木叶村-餐厅到店点餐系统</p>
    </footer>
</div>
</div>
<!-- 将外部文件引入放在最后面这里更多为了提高用户体验，不必像传统的放前面后必须加载完后页面才显示内容，延缓了页面响应 -->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<!-- 模态框Modal -->
</body>

</html>
