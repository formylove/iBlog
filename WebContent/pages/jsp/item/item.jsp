<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|common.css|easyui|manager|editor|Jcrop|upload.js|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title>元素展示</title>
</head>
<body> 
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container index-ct" style="min-height: 1000px;">	
<<<<<<<<<<<<<<<a onClick="history.go(-1);">back</a><<<<<<<<<<<<<<<<
${nation!=null?"item :  NATION":""}
${figure!=null?"item :  FIGURE":""}
${state!=null?"item :  STATE":""}
${city!=null?"item :  CITY":""}
${dynasty!=null?"item : DYNASTY":""}
${music!=null?"item : Music":""}
${genre!=null?"item : Genre":""}
${category!=null?"item : CATEGORY":""}
<br>
name:  ${nation !=null?nation.name:"" }
	   ${figure !=null?figure.name:"" }
	   ${state !=null?state.name:"" }
	   ${city !=null?city.name:"" }
	   ${dynasty !=null?dynasty.name:"" }
	   ${music !=null?music.name:"" }
	   ${genre !=null?genre.name:"" }
	   ${category !=null?category.name:"" }
<br>
id:  ${nation !=null?nation.id:"" }
	 ${figure !=null?figure.id:"" }
	 ${state !=null?state.id:"" }
	 ${city !=null?city.id:"" }
	 ${dynasty !=null?dynasty.id:"" }
	 ${music !=null?music.id:"" }
	 ${genre !=null?genre.id:"" }
	 ${category !=null?category.id:"" }
<br>
<%-- <audio src="music/${music.url }"  controls="controls" autoplay> --%>
<!-- Your browser does not support the audio element. -->
<!-- </audio> -->
</div>








</div>
	
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
		`