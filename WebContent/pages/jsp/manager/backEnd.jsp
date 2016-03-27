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
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container index-ct" style="min-height: 1000px;">	
<div style='float:left'>
<%@ include file="../manager/nav.jsp" %>
</div>
<div style='float:right'>
<c:choose> 
  <c:when test="${param.type =='retrieve'}">   
<jsp:include page="../manager/retrieve/retrieve.jsp" />
  </c:when> 
  <c:when test="${param.type =='eessay'}">   
<jsp:include page="../manager/essayEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='enote'}">   
<jsp:include page="../manager/noteEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='emovie'}">  
<jsp:include page="../manager/movieEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='ebook'}">   
<jsp:include page="../manager/bookEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='eseries'}">   
<jsp:include page="../manager/seriesEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='enation' || param.type =='estate' || param.type =='ecity'}">   
<jsp:include page="../manager/administrationEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='edynasty' || param.type =='epeople' || param.type =='ereligion'}">   
<jsp:include page="../manager/groupEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='ecategory' || param.type =='egenre'}">   
<jsp:include page="../manager/collectionEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='ecorporation'}">   
<jsp:include page="../manager/corporationEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='efigure'}">   
<jsp:include page="../manager/figureEditor.jsp" />
  </c:when> 
  <c:when test="${param.type =='emusic'}">   
<jsp:include page="../manager/musicEditor.jsp" />
  </c:when> 
  <c:otherwise>   
<%@include file="../manager/essayEditor.jsp"  %>
  </c:otherwise> 
</c:choose> 





</div>
<c:choose> 
  <c:when test="${param.type =='eessay' || param.type =='enote' || param.type =='emovie' || param.type =='ebook' || param.type =='eseries' || param.type =='enation' || param.type =='estate' || param.type =='ecity' || param.type =='edynasty' || param.type =='epeople' || param.type =='ereligion' || param.type =='ecorporation' || param.type =='efigure' || param.type =='emusic' || param.type =='ecategory' || param.type =='egenre'}"> 
  <script type="text/javascript">
  $(function(){
  $('#rightside-nav').accordion('select','创作');//必须加载完全再执行
  })
  </script> 
  </c:when> 
</c:choose> 





</div>
	
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
		`