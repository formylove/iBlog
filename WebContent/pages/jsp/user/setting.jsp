<%@ page language="java" import="main.src.common.WebUtils" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的帐号</title>
<%request.setAttribute("importParams", "jquery|Akita.js|qtip|form|validate|common.css|agent|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>

<%@ include file="../snippets/footer.jsp" %>
</body>
</html>