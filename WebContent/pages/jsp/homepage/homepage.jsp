<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<link type="image/x-icon" href="http://www.luoo.net/favicon.ico" rel="shortcut icon">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setAttribute("importParams", "jquery|flexSlider.js|index.js|common.css|luoo.js|end"); %>
<%@ include file="../snippets/static_js_css.jsp" %>
<title>树</title>
</head>
<body>

<%@ include file="../snippets/navigator.jsp" %>

<div class="container index-ct" style="min-height: 221px;">	
<%@ include file="../homepage/poster.jsp" %>
<%@ include file="../homepage/articleColumn.jsp" %>
<%@ include file="../homepage/somniloquismColumn.jsp" %>
<%@ include file="../homepage/criticismColumn.jsp" %>
<%@ include file="../homepage/musicColumn.jsp" %>
</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
