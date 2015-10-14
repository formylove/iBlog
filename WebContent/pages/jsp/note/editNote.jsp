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
	<form id="form" action="<s:url action='noteAction.action?method:saveNote'/>" method="post">
			<input type="hidden" name="id" id="id"  value="<c:choose><c:when test="${empty essay}">0</c:when><c:otherwise>${essay.id}</c:otherwise></c:choose>">
			<input type="hidden" name="essay.read_cnt" id="read_cnt" value="<c:choose><c:when test="${empty essay}">0</c:when><c:otherwise>${essay.read_cnt}</c:otherwise></c:choose>">
			<input type="hidden" name="essay.favor_cnt" id="favor_cnt" value="<c:choose><c:when test="${empty essay}">0</c:when><c:otherwise>${essay.favor_cnt}</c:otherwise></c:choose>">
			<!-- 作品编辑区域 -->
			<jsp:include page="../snippets/opusEditor.jsp"/>
			<!-- 作品编辑区域 end -->
			<!-- 正文 -->
			<div id="review" class="clearfix">
				<div>
					<label style="float: none;">札记正文</label>
				</div>
				<div class="clearfix">
				<s:select id="isOriginal" name="essay.original_flag" list="#{'true':'原创','false':'转载'}" 
				onchange="showCouple('isOriginal','original_link','false');showCouple('isOriginal','author','false');">
				</s:select>
					<input type="text" id="title" required="required" name="essay.title" placeholder="文章标题"
						 value="${essay.title}" style="width: 85%;  margin-bottom: 11px;"/>
					<input type="text" id="subtitle" name="essay.subtitle" placeholder="副标题"
						 value="${essay.subtitle}" style="width: 85%;margin-left:105px;"/>
				</div>
				<div class="margin-b-6 clearfix">
					<input type="text" id="author" name="essay.author" placeholder="文章作者"
						value="${essay.author}" class="hidden width-40" style="margin-left: 105px;margin-right: 24px"/>
					<input type="url" id="original_link" name="essay.original_link"
						placeholder="原文地址" class="hidden width-40" value="${essay.original_link}" />
				</div>
				<!-- 正文编辑区域 -->
				<jsp:include page="../snippets/contentEditor.jsp"/>
				<!-- 正文编辑区域 End -->
			</div>
			<!-- 正文 End -->

			<p class="margin-t-20">设置权限</p>
			<s:select list="authority" listKey="key" listValue="value" cssClass="margin-b-16" id="authority" name='essay.authority' ></s:select>
			<p class="subtit">文章标签</p>
			
			<div style="position: relative;" >
			<s:if test="essay!=null && essay.label!='' && essay.label!=null">
			<s:iterator value="essay.getLabels()" id="label">
			<span id="labelIterm" name="labelIterm"><input name="essay.label" type="text" id="label" 
				value="<s:property value='label'/>" placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span>
			</s:iterator>
			</s:if><s:else>
				<span id="labelIterm" name="labelIterm"><input name="essay.label" type="text" id="label" 
					placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span></s:else><span id="add" class="cursor-pointer" onclick="addLabel($(this));">&nbsp;<font size="4px">+</font> |</span>
				<span id="reduce" class="hidden cursor-pointer" onclick="redLabel($(this));">&nbsp;<font size="4px">—</font>&nbsp;</span>
			</div>
			
			<div style="text-align: center; margin-top: 15px;">
				<input id="btnPublish" type="button" onclick="duplicateCheck()" class="btn rounded btn-positive"
					class="input_btn_1" value="发表文章" title="保存并跳转"  style="margin-right:40px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnCancel" type="button" onclick="window.location.href='http://127.0.0.1:8080/iBlog/noteAction.action?method:editNote'; " class="btn rounded btn-negative btn-reload" value="舍弃" />
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