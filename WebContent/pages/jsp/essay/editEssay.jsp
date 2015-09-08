<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章编辑</title>
<%request.setAttribute("importParams", "jquery|index.js|common.css|luoo.js|ckeditor.js|end"); %>
<%@ include file="../snippets/static_js_css.jsp" %>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>

<div class="container index-ct" style="min-height: 221px;">	

<form  id="form" action="<s:url action='essayAction?method:saveEssay'/>" method="post">
<input type="hidden" name="id" id="id" value="<s:property value='essay.id'/>">
<div>
<select id="isOriginal" name="isOriginal" style="height:28px;">
<option value="true">原创</option>
<option value="false">转载</option>
</select>
<input type="text" id="title" name="title" placeholder="文章标题" value="<s:property value='essay.title'/>" style="width:880px; height:20px; float:right;" maxlength="100" />
</div>
<input type="text" id="author"  name="author" placeholder="文章作者" value="<s:property value='essay.author'/>" style="width:880px; height:20px; float:right;margin-left:55px;" maxlength="100"/>
<input  type="text" id="original_link" name="original_link" placeholder="原文地址"  value="<s:property value='essay.original_link'/>" style="width:880px; height:20px; float:right;margin-left:55px;" maxlength="100"/>
<div class="section">
<textarea id="editor" name="editor" placeholder="文章内容" rows="30" style="width:99.4%;"><s:property value='essay.content'/></textarea>
</div>
<script type="text/javascript">
var editortext = CKEDITOR.replace( 'editor' );
</script>

<p>选择分类 [<a href="/category" target="_blank">编辑分类</a>]</p>
<select id="categoryId" name="categoryId">
<s:iterator value="categories" var="category">
<option value="<s:property value="#category.id"/>"><s:property value="#category.name"/></option>
</s:iterator>
</select>

<p>设置权限</p>
<select id="authority" name="authority">
<option value="10">所有人可见</option>
<option value="0">自己可见</option>
<option value="5">登录可见</option>
<option value="1">珠海ip可见</option>
<option value="2">珠海ip不可见</option>
</select>

    <p class="subtit">文章标签</p>
<div style="position:relative;">
<input name="label" type="text" id="txtTag2" placeholder="最多添加5个标签，多个标签之间用“,”分隔" value="<s:property value='essay.label'/>" style="width:60%; height:20px;" maxlength="100" />
<div id="tag2box" style="display:none;">
</div>
</div>

						<script type="text/javascript">
						var duplicateCheck=function(){
							$.ajax({
								url:'essayAction.action?method:hasExisted',
								type:'post',
								contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
								data:'title='+$('#title').val(),
								success:function(data){
									if(data.hasExisted & document.getElementById('id').value==''){
										alert('不要重复发布文章');
									}else if(editortext.document.getBody().getText().replace(/\s/g,'')==''){
										alert('文章内容为空');}
										   else{
										document.getElementById('form').submit();
									}
								}
							});
						} ;
						</script>

<div style="text-align:center;margin-top:15px;">   
<input id="btnPublish" type="button" onclick="duplicateCheck()" class="input_btn_1" value="发表文章" title="保存并跳转" />
<input id="btnCancel" type="button" onclick="window.location.href='http://127.0.0.1:8080/iBlog/essayAction.action?method:editEssay'; " value="舍弃" />
</div>
</form>





</div>
<%@ include file="../snippets/footer.jsp" %>

<script type="text/javascript">
var selector = document.getElementById('isOriginal');
for(i=0;i<selector.length;i++)
	{
	if(selector[i].value=="<s:property value='essay.original_flag'/>")
		selector[i].selected=true;
	}
selector = document.getElementById('categoryId');
for(i=0;i<selector.length;i++)
	{
	if(selector[i].value=="<s:property value='essay.category'/>")
		selector[i].selected=true;
	}
selector = document.getElementById('authority');
for(i=0;i<selector.length;i++)
	{
	if(selector[i].value=="<s:property value='essay.authority'/>")
		selector[i].selected=true;
	}
</script>
</body>
</html>