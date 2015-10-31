<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|index.js|flexSlider.js|common.css|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title>树</title>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>

<div class="container index-ct" style="min-height: 221px;">	
<jsp:include page="../homepage/poster.jsp" />
<jsp:include page="../homepage/articleColumn.jsp" />
<jsp:include page="../homepage/somniloquismColumn.jsp" />
<jsp:include page="../homepage/criticismColumn.jsp" />
<jsp:include page="../homepage/musicColumn.jsp" />
</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
