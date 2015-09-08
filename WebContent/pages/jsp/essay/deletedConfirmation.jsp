<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除成功</title>
<%request.setAttribute("importParams", "jquery|index.js|common.css|luoo.js|end"); %>
<%@ include file="../snippets/static_js_css.jsp" %>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<script type="text/javascript">
var recoverEssay = function(){
	 $.ajax({
		 url:"essayAction.action?method:recoverEssay&<s:property value='essay.id'/>",
		 contentType:'application/x-www-form-urlencoded;charset=UTF-8',
		 type:'post',
		 success:function(data){
			 alert('恢复成功');
		 }
	 });
};

</script>
<div style="text-align:center;">
"<s:property value="essay.title"/>" 已被成功删除,点击恢复<a onclick="recoverEssay();"></a>
</div>

<%@ include file="../snippets/footer.jsp" %>
</body>
</html>