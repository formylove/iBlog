<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信号</title>
<%request.setAttribute("importParams", "jquery|common.css|Akita.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div style="text-align:center;">
<img alt="ansyx1002" src="./img/QRcode/wechat_2.png">
</div>
<div style="text-align:center;">
<font size="25px">微信号：ansyx1002</font>
</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>