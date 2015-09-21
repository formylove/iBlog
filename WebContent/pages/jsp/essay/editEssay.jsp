<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="main.src.entity.essay.Essay"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文字</title>
<%
	request.setAttribute("importParams", "jquery|index.js|common.css|Akita.js|ckeditor.js|end");
%>
<%@ include file="../snippets/static_js_css.jsp"%>
<style type="text/css">
select{
height:27px;
width:100px;
}
</style>
</head>
<body style="position:relative;">
 <div class="overlay hidden"></div>
	<%@ include file="../snippets/navigator.jsp"%>

	<div class="container index-ct round-container" style="min-height: 221px;">

		<form id="form" action="<s:url action='essayAction?method:saveEssay'/>" method="post">
			<input type="hidden" name="id" id="id" value="<%=((request.getAttribute("note")==null)?0:((Essay)request.getAttribute("essay")).getId()) %>">
			<div class="clearfix">
				<div class="fleft margin-r-16">
					<div id="preview-pane" class="hidden">
						<div class="preview-container-essay">
							<img src="img/essay/essay_default.jpeg" class="round-cover jcrop-preview" alt="Preview" />
						</div>
					</div>
					<img src="img/essay/essay_default.jpg" class="round-cover cover-essay" alt="Preview" />
				</div>
				<div class="fleft margin-r-16 ">
						<select id="isOriginal" name="isOriginal" style="margin-bottom:105px;"
							onchange="showCouple('isOriginal','original_link','false');showCouple('isOriginal','author','false');">
							<option value="true">原创</option>
							<option value="false">转载</option>
						</select>
						<div>
						<input type="file" class="btn" id="profilegetter" accept=".jpg,.jpeg,.png,.gif" autofocus onchange="" style="display:none;">
						<input type="button" class="btn" value="设置封面" onclick="$(profilegetter).click();">
						</div>
				</div>
				<div class="fleft" style="margin-top:0px;">
					<div class="margin-b-4">

						 <input type="text" id="title" name="title" placeholder="文章标题"
							value="<s:property value='essay.title'/>" class="nfloat margin-b-4 input-width" />
					</div>
					<div class="margin-b-4">
						<input type="text" id="author" name="author" placeholder="文章作者"
							value="<s:property value='essay.author'/>"
							class="nfloat  hidden margin-b-4 input-width" />
					</div>
					<div>
							 <input type="text"
							id="original_link" name="original_link" placeholder="原文地址"
							value="<s:property value='essay.original_link'/>"
							class="nfloat hidden input-width" />
					</div>
				</div>
			</div>
			<div class="section">
				<textarea id="editor" name="editor" placeholder="文章内容" rows="30"
					style="width: 99.4%;"><s:property value='essay.content' /></textarea>
			</div>
			<script type="text/javascript">
				var editortext = CKEDITOR.replace('editor');
			</script>

			<p>
				选择分类 [<a href="/category" target="_blank">编辑分类</a>]
			</p>
			<s:select list="categories" listKey="id" listValue="name" id="categoryId" name="categoryId"></s:select>
			<p>设置权限</p>
			<s:select list="authorities" listKey="key" listValue="value" cssClass="margin-b-16" id="authority" name='authority' ></s:select>

			<p class="subtit">文章标签</p>
			<div style="position: relative;">
				<input name="label" type="text" id="txtTag2"
					placeholder="最多添加5个标签，多个标签之间用“,”分隔"
					value="<s:property value='essay.label'/>"
					style="width: 60%; height: 20px;" maxlength="100" />
				<div id="tag2box" style="display: none;"></div>
			</div>

			<script type="text/javascript">
				var duplicateCheck = function() {
					$
							.ajax({
								url : 'essayAction.action?method:hasExisted',
								type : 'post',
								contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
								data : 'title=' + $('#title').val(),
								success : function(data) {
									if (data.hasExisted
											& document.getElementById('id').value == '') {
										alert('不要重复发布文章');
									} else if (editortext.document.getBody()
											.getText().replace(/\s/g, '') == '') {
										alert('文章内容为空');
									} else {
										document.getElementById('form')
												.submit();
									}
								}
							});
				};
			</script>

			<div style="text-align: center; margin-top: 15px;">
				<input id="btnPublish" type="button" onclick="duplicateCheck()" class="btn"
					class="input_btn_1" value="发表文章" title="保存并跳转" style="margin-right:40px"/> <input
					id="btnCancel" type="button"
					onclick="window.location.href='http://127.0.0.1:8080/iBlog/essayAction.action?method:editEssay'; " class="btn"
					value="舍弃" />
			</div>
		</form>





	</div>
	<%@ include file="../snippets/footer.jsp"%>

	<script type="text/javascript">
		initSelector('isOriginal', "<s:property value='essay.original_flag'/>");
		initSelector('categoryId', "<s:property value='essay.category'/>");
		initSelector('authority', "<s:property value='essay.authority'/>");
	</script>
</body>
</html>