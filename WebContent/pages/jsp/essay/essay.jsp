<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="essay.title"/></title>
<%request.setAttribute("importParams", "jquery|essay.css|agent|comment|Akita.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<input type="hidden" id="target_id" value="${essay.id}">
<div class="container ct-sm" style="min-height: 221px;">	
		<nav class="article-nav">
			<a href="essays/" class="nav-back">
				<i class="icon-back"></i>
				返回专栏首页
			</a>
		</nav>
		<div class="essay-detail-wrapper">	
			<h1 class="essay-title">${essay.title}</h1>
			<!-- essay meta -->
			<jsp:include page="../snippets/essayMeta.jsp"></jsp:include>
				<!-- 音乐 -->
		<s:if test="essay.music != 0">
		<jsp:include page="../snippets/musicColumn.jsp"></jsp:include>
			</s:if>
					<s:else>
<HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="80%" color=#987cb9 SIZE=1>	
	<br>
					</s:else>

				<!-- 文章内容 -->
					<div class="essay-content">
					<s:property value="essay.content" escape="false"/>
				<br>
				<br>
				<br>
					 </div>
			<!-- 点赞区 -->		 
			<jsp:include page="../snippets/shareArea.jsp"/>		 
			<!-- 作者信息 -->		 
					 
			<s:if test="essay.author != null && essay.author != '' ">
			<jsp:include page="../snippets/userColumn.jsp"/>
			</s:if>
	</div>	

<jsp:include page="../snippets/comments.jsp"/>
		
		</div>
		
<%@ include file="../snippets/footer.jsp" %>
<script>

</script>
</body>
</html>