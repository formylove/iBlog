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

<form action="t.action?method:t1" id="f1">
<s:checkbox type="checkbox" name="checkbox_test" />
<input type="checkbox" name="checkbox_test" value="true">
<input type="checkbox" name="checkbox_test2" value="true">
<input type="checkbox" name="opus.rec_flag" value="true"  >
<s:select  list="{'aa','bb','cc'}" name="opus.name">
</s:select>
<br>
   <s:combobox label="Fruit" name="opus.protagonists"
    list="{'apple','banana','grape','pear'}" headerKey="-1"
    headerValue="--- Please Select ---" emptyOption="true"  value="banana" /> 
<br>
<s:select label="您所关注的技术领域" name="opus.type"
    list="#{'JavaScript':'JavaScript','Ajax':'Ajax'}">
    <s:optgroup label="Java Web"
     list="#{'JSP':'JSP','Servlet':'Servlet','JavaBean':'JavaBean'}"
     listKey="value" listValue="key"></s:optgroup>
    <s:optgroup label="Java开源框架"
     list="#{'SSH':'SSH','Struts 2':'Struts 2','Hibernate3':'天啦噜','Spring2':'Spring2'}"
     listKey="value" listValue="key"></s:optgroup>
   </s:select>
   <s:select multiply="true" name="multiple" list="users" listKey="id" listValue="nick_name"/>
<br>
<%-- <s:checkboxlist name="checkboxList"  list="{'w','a','x','xy'}" label="请选择你所喜欢的圣斗士"/> --%>
<s:checkboxlist name="users2" list="users"  listKey="id" listValue="nick_name"></s:checkboxlist> 
<br>
<input type="submit" value="submit">
</form>






</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
