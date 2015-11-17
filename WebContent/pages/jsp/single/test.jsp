    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
<%request.setAttribute("importParams", "general|common.css|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
<jsp:include page="../snippets/hidden_box.jsp" />
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<br>
<br>
<br>
<br>
<br>
<div style="text-align:center;min-height:110px">
信息输出----------------------->${msg}
<s:select list="nations" listKey="key" listValue="value" label="国家" ></s:select>
<br>
<s:property value="user.nick_name"/>
${user.nick_name }
</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>