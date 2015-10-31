<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信号</title>
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
<!-- <script> -->
// window.onload = function(){
// 	Browsers = new WhichBrowser(navigator.userAgent);
// 	document.write(navigator.userAgent);
// 	var txt = "browserName: " + (Browsers.browser.name ? Browsers.browser.name : '') + '<br />' +
// 	 "browserChannel: " + (Browsers.browser.channel ? Browsers.browser.channel : '') + '<br />' +
// 	 "browserVersion: " + (Browsers.browser.version ? Browsers.browser.version.toString() : '') + '<br />' +
// 	 "browserVersionType: " + (Browsers.browser.version ? Browsers.browser.version.type : '') + '<br />' +
// 	 "browserVersionMajor: " + (Browsers.browser.version ? Browsers.browser.version.major : '') + '<br />' +
// 	 "browserVersionMinor: " + (Browsers.browser.version ? Browsers.browser.version.minor : '') + '<br />' +
// 	 "browserVersionOriginal: " + (Browsers.browser.version ? Browsers.browser.version.original : '') + '<br />' +
// 	 "browserMode: " + (Browsers.browser.mode ? Browsers.browser.mode : '') + '<br />' +
// 	 "engineName: " + (Browsers.engine.name ? Browsers.engine.name : '') + '<br />' +
// 	 "engineVersion: " + (Browsers.engine.version ? Browsers.engine.version.toString() : '') + '<br />' +
// 	 "osName: " + (Browsers.os.name ? Browsers.os.name : '') + '<br />' +
// 	 "osVersion: " + (Browsers.os.version ? Browsers.os.version.toString() : '') + '<br />' +
// 	 "deviceManufacturer: " + (Browsers.device.manufacturer ? Browsers.device.manufacturer : '') + '<br />' +
// 	 "deviceModel: " + (Browsers.device.model ? Browsers.device.model : '') + '<br />' +
// 	 "deviceType: " + (Browsers.device.type ? Browsers.device.type : '') + '<br />' +
// 	 "useragent: " + navigator.userAgent + '<br />' +
// 	 "humanReadable: " + Browsers.toString();
// 	document.write(txt);
// };

<!-- </script> -->
<s:property value="user.nick_name"/>
###################
${user.nick_name }
</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>