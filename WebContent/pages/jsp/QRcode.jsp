<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信号</title>
<%request.setAttribute("importParams", "jquery|index.js|common.css|luoo.js|end"); %>
<%@ include file="snippets/static_js_css.jsp" %>
</head>
<body>
<%@ include file="./snippets/navigator.jsp" %>
<div style="text-align:center;">
<img alt="ansyx1002" src="img/QRcode/wechat_1.png">
</div>
<div style="text-align:center;">
<font size="25px">微信号：ansyx1002</font>
</div>
<%@ include file="snippets/footer.jsp" %>
</body>
</html>