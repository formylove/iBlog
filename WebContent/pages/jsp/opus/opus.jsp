    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${opus.name} - 作品</title>
<%request.setAttribute("importParams", "jquery|note.css|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container ct-sm essay-detail-wrapper" style="min-height: 221px;">	
		<nav class="article-nav">
			<a href="notes/" class="nav-back">
				<i class="icon-back"></i>
				返回作品首页
			</a>
		</nav>
					<script type="text/javascript">

			
			</script>
		<div class="event-head clearfix">
			<img src="img/depot/${opus.cover}" alt="${opus.name}" class="poster rounded">
			<div class="event-meta">
				<h1 style="font-size: 24px;">${opus.name}</h1>
				<!-- essay meta -->
				<s:iterator value="opus.getMeta()" id="entry">
				<p class="meta"><s:property value="key"/>:
				<s:property value="value"/></p>
				</s:iterator>
			</div>
		</div>
		
	</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>