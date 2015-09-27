<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My gf is as nice as my mum</title>
<%
	request.setAttribute("importParams", "jquery|common.css|ZeroClipboard.js|Akita.js|end");
%>
<jsp:include page="../snippets/static_js_css.jsp"/>
	<script type="text/javascript">
	function init(){
  	clip = new ZeroClipboard.Client();
		ZeroClipboard.setMoviePath("js/zeroclipboard/ZeroClipboard.swf");
  	clip.setHandCursor(true);  	
  	clip.addEventListener('mouseOver', function (client){    
    	clip.setText( $("#stacktrace").text());
  	});
  	clip.addEventListener('complete', function (client, text) {   
    	alert("复制成功");
  	});
	clip.glue("clip_button"); // 和上一句位置不可调换 
	}
	</script>
</head>
<body onload="init()">
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
