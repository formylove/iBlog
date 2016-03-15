<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My gf is as nice as my mum</title>
<s:set name="importParams" value="'general|ZeroClipboard.js|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body onload="clipboard('clip_button')">
	<%@ include file="../snippets/navigator.jsp"%>
	<div style="text-align: center;">
		<h1>报错信息：<s:property value="exception.message" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn" id="clip_button" value="将异常信息加入剪切板"></h1>
		<br>
		<br>
		<textarea rows="30" cols="120" spellcheck="false" id="stacktrace">
		 <s:property value="exceptionStack"/>   
		</textarea>
	</div>
	<%@ include file="../snippets/footer.jsp"%>
</body>
</html>
