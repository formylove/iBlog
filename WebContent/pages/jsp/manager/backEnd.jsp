<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|common.css|easyui|manager.js|editor|Jcrop|upload.js|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title>夜网后台管理系统</title>
</head>
<body> 
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container index-ct" style="min-height: 1000px;">	
<div style='float:left'>
<%@ include file="../manager/nav.jsp" %>
</div>
<div style='float:right'>
<c:choose> 
  <c:when test="${param.type =='retrieve'}">   
<%@ include file="../manager/retrieve/retrieve.jsp" %>
  </c:when> 
  <c:when test="${param.type =='eessay'}">   
<%@ include file="../manager/essayEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='enote'}">   
<%@include file="../manager/noteEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='emovie'}">  
<%@include file="../manager/movieEditor.jsp" %>>
  </c:when> 
  <c:when test="${param.type =='ebook'}">  
<%@include file="../manager/bookEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='eseries'}">   
<%@include file="../manager/seriesEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='enation' || param.type =='estate' || param.type =='ecity'}">   
<%@include file="../manager/administrationEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='edynasty' || param.type =='epeople' || param.type =='ereligion'}">   
<%@include file="../manager/groupEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='ecategory' || param.type =='ecatorder' || param.type =='egenre'}">   
<%@include file="../manager/collectionEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='ecorporation'}">   
<%@include file="../manager/corporationEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='efigure'}">   
<%@include file="../manager/figureEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='emusic'}">   
<%@include file="../manager/musicEditor.jsp" %>
  </c:when> 
  <c:when test="${param.type =='eposter' || param.type =='eposterorder'}">   
<%@include file="../manager/posterEditor.jsp" %>
  </c:when> 
  <c:otherwise>   
<%@include file="../manager/essayEditor.jsp"  %>
  </c:otherwise> 
</c:choose> 

</div>

</div>
	<c:choose> 
  <c:when test="${param.type =='eessay' || param.type =='enote' || param.type =='emovie' || param.type =='ebook' || param.type =='eseries' || param.type =='enation' || param.type =='estate' || param.type =='ecity' || param.type =='edynasty' || param.type =='epeople' || param.type =='ereligion' || param.type =='ecorporation' || param.type =='efigure' || param.type =='emusic' || param.type =='ecategory' || param.type =='egenre' || param.type =='eposter' || param.type =='ecatorder' || param.type =='eposterorder'}"> 
  <script type="text/javascript">
  window.onload = function(){
	  $('#rightside-nav').accordion('select','创作');
  };
  </script> 
  </c:when> 
</c:choose> 
<%@ include file="../snippets/footer.jsp" %>

</body>

</html>
		`