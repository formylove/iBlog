<%@page  pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|common.css|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title>UI test</title>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container index-ct" style="min-height: 221px;">	

date:${ dateTrans}
<br>
String:${ dateStr}
<br>
population:${ population}
<br>
gender:${ gender}
<br>
nations:${ nations}
<br>
actors:${ actors}
<br>
isWork:${ working}
<br>
count:${ count}
<form action="t!t2.action" id="f1">
<s:updownselect name="o.protagonistIds" label="集合属性" list="users" listKey="id" listValue="nick_name"/>
<br>
<s:date name="#tDate" format="dd/MM/yyyy" />
<br>
fmt:<fmt:formatDate value='${dateTrans}' type='date' pattern='yyyy-MM-dd' />
<br>
fmt for date input:<input type="date" name="dateTrans" value="<fmt:formatDate value='${dateTrans}' type='date' pattern='yyyy-MM-dd' />"/>
<br>
dateStr:<input type="date" name="dateStr" value="${dateStr }"/>
<br>
<s:checkbox name="working" label="isWork" labelposition="left" />
<br>
population:<input type="text" title="人口" name="population"/>
<s:select multiple="true" name="population" list="@main.src.common.MsgConstants@CU" listKey="key" listValue="value"/>
<br>
  <select name="actors"  id="authorizedUsers" multiple="multiple">
    <option value="1">刘德华</option>
    <option value="2">周星驰</option>
    <option value="3">黄渤</option>
  </select>
<br>
<s:updownselect name="nations" list="@main.src.common.MsgConstants@AUTHORITY" listKey="key" listValue="value"/>
<s:radio name="gender" list="@main.src.common.MsgConstants@GENDER"></s:radio>
<br>
<%-- <s:checkboxlist name="users2" list="users"  listKey="id" listValue="nick_name"></s:checkboxlist>  --%>
<br>
<input type="submit" value="submit">
</form>
<br>
<input type="button" value="ajax for html" onclick="forHtml();"/>

<script type="text/javascript">
function forHtml(){
	$.ajax({
		url:'hachi.space/t.action?method:t2',
		type:'post',
		dataType:'html',
		success:function(data){
			$(data).appendTo($("#f1"));
		}
	});
}
</script>


</div>
${tDate2 }
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
