<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>用户信息管理</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <link href="${contextPath}/skins/skin/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/skins/skin/css/public.css" rel="stylesheet"/>
</head>
<body class="container">
    <div class="addContainer">
        <form class="form-horizontal" id="saveForm" onsubmit="return false">
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">发送地址<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="text" class="" id="sendAddress" datatype="" value="" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">服务地址<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="text" class="" id="serverAddress" disabled datatype="" value="smtp.163.com" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">发送端口<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="text" class="" id="sendPort" datatype="" disabled value="25" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">用户名<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="text" class="" id="userName" datatype="" value="" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">密码<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="password" class="" id="password" datatype="" value="" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">主题<span class="required">*</span></label>
                <div class="col-xs-5">
                    <input type="text" class="" id="subject" datatype="" value="" nullmsg="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label text-right">内容<span class="required">*</span></label>
                <div class="col-xs-5">
                    <textarea rows="5" cols="22"></textarea>
                </div>
            </div>
        </form>
        <button type="button" class="btn" id="send" style="position: relative; left: 40%">发送</button>
    </div>
</body>





<%--<form action="add" id="addForm" method="post">
    <div class="form-group">
        用户姓名：<input type="text" name="userName"/>
        用户爱好：<input type="text" name="userHobby">
        旅游目的地：<input type="text" name="travelCity">
        <input type="submit" class="btn btn-default" value="添加">
        <a href="user" class="btn btn-success">用户列表</a>
    </div>
</form>


<form action="query" method="post">
    用户姓名：<input type="text" name="userName" value="${queryUser.userName}"/>
    用户爱好：<input type="text" name="userHobby" value="${queryUser.userHobby}">
    旅游目的地：<input type="text" name="travelCity" value="${queryUser.travelCity}">
    <input type="submit" class="btn btn-default" value="查询">
</form>

<form action="search" method="post">
    用户姓名：<input type="text" name="userName" value="${searchUser.userName}"/>
    用户爱好：<input type="text" name="userHobby" value="${searchUser.userHobby}">
    旅游目的地：<input type="text" name="travelCity" value="${searchUser.travelCity}">
    <input type="submit" class="btn btn-default" value="搜索">
</form>

<form action="query-cities" method="post">
    旅游目的地集合：<input type="text" name="travelCities" value="${cityList}">
    <input type="submit" class="btn btn-default" value="查询">
</form>

<table class="table table-striped table-hover table-condensed">
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>爱好</th>
        <th>旅游目的地</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th colspan="3" style="text-align: center">操作</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userHobby}</td>
            <td>${user.travelCity}</td>
            <td><fmt:formatDate value="${user.createTime}" type="both"/></td>
            <td><fmt:formatDate value="${user.updateTime}" type="both"/></td>
            <td>
                <form action="getUserDetail" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="submit" value="查看" class="btn btn-default">
                </form>
            </td>
            <td>
                <form action="load-edit" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="submit" value="编辑" class="btn btn-default">
                </form>
            </td>
            <td>
                <form action="delete" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="submit" value="删除" class="btn btn-default">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    liu:<input width="10px" height="2px" id="sdfs" class="">
</div>--%>

<script src="${contextPath}/skins/js/jquery.min.js"></script>
<script src="${contextPath}/skins/js/bootstrap.min.js"></script>
</body>
</html>
