<%@ page language="java" import="java.util.Map,main.src.entity.essay.Essay" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>札记</title>
<%request.setAttribute("importParams", "jquery|common.css|Akita.js|validate|ckeditor.js|upload.js|Jcrop|end");%>
<%@ include file="../snippets/static_js_css.jsp"%>
<style type="text/css">
select{
height:27px;
width:100px;
}
input[type=number],input[type=month]{
height:23px;
}
</style>
</head>
<body style="position:relative;">
	<jsp:include page="../snippets/hidden_box.jsp"/>
	<%@ include file="../snippets/navigator.jsp"%>
	<div class="container index-ct round-container" style="min-height: 221px;">
	<form id="form" action="<s:url action='opusAction.action?method:save'/>" method="post">
			<input type="hidden" name="opus.id" id="id"  value="<c:choose><c:when test="${empty opus}">0</c:when><c:otherwise>${opus.id}</c:otherwise></c:choose>">
			<!-- 作品编辑区域 -->
			<jsp:include page="../snippets/opusEditor.jsp"/>
			<!-- 作品编辑区域 end -->

			<p class="margin-t-20">设置权限</p>
			<s:select list="authority" listKey="key" listValue="value" cssClass="margin-b-16" id="authority" name='essay.authority' ></s:select>
			<p class="subtit">文章标签</p>
			
			<div style="text-align: center; margin-top: 15px;">
				<input id="btnPublish" type="button" onclick="submitForm()" class="btn rounded btn-positive"
					class="input_btn_1" value="发表文章" title="保存并跳转"  style="margin-right:40px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnCancel" type="button" onclick="window.location.href='http://127.0.0.1:8080/iBlog/opusAction.action?method:edit'; " class="btn rounded btn-negative btn-reload" value="舍弃" />
			</div>

		</form>
	</div>
	<%@ include file="../snippets/footer.jsp"%>
	<script type="text/javascript">
	checkTokenDis($("span[name='labelIterm']").size());
	initSelector('isOriginal', "${essay.original_flag}");
	initSelector('category', "${essay.category}");
	initSelector('authority', "${essay.authority}");
	showCouple('isOriginal','original_link','false');
	showCouple('isOriginal','author','false');
	</script>
</body>
</html>