<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|common.css|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title></title>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container index-ct" style="min-height: 221px;">	


<jsp:include page="./musicSolo.jsp"/>





</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
