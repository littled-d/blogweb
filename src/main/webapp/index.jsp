<html>
<body>
<h2>Hello World!</h2>
<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>

<%--这里的路径，需要找到项目的路径--%>
<%--${pageContext.request.contextPath}指向项目路径--%>
<form action="${pageContext.request.contextPath}/request" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="checkbox" name="hobbies" value="读书">读书
    <input type="checkbox" name="hobbies" value="泡妞">泡妞
    <input type="checkbox" name="hobbies" value="敲代码">敲代码
    <input type="checkbox" name="hobbies" value="听音乐">听音乐
    <br>
    <input type="submit">
</form>
</body>
</html>
