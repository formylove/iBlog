<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="main.src.entity.essay.Essay"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文字</title>
<%
	request.setAttribute("importParams", "jquery|common.css|Akita.js|qtip|upload.js|Jcrop|ckeditor.js|end");

%>
<jsp:include page="../snippets/static_js_css.jsp"/>
<style type="text/css">
select{
height:27px;
width:100px;
}
</style>
</head>
<body style="position:relative;">
	<jsp:include page="../snippets/hidden_box.jsp"/>
	<%@ include file="../snippets/navigator.jsp"%>
 <div class="overlay hidden"></div>
	<div class="container index-ct round-container clearfix" style="min-height: 221px;">

		<form id="form" action="<s:url action='essayAction?method:saveEssay'/>" method="post">
			<div class="clearfix">
			<input type="hidden" name="id" id="id"  value="<s:if test="essay==null">0</s:if><s:else>${essay.id}</s:else>">
			<input type="hidden" name="profile" id="cover" value="${essay.profile}">
			<input type="hidden" name="essay.profile" id="profile_backup" value="${essay.profile}">
			<input type="hidden" name="essay.read_cnt" id="read_cnt" value="<s:if test="essay==null">0</s:if><s:else>${essay.read_cnt}</s:else>">
			<input type="hidden" name="essay.favor_cnt" id="favor_cnt" value="<s:if test="essay==null">0</s:if><s:else>${essay.favor_cnt}</s:else>">
		
			<div class="clearfix margin-b-16">
				<div class="fleft">
				<div id="preview-pane" class="fleft margin-r-55">
					<div id ="preview-container" class="preview-container-essay" >
						<img src="<s:if test="essay.profile != null  && essay.profile != ''">img/depot/${essay.profile}</s:if><s:else>img/essay/essay_default.jpg</s:else>" id="prevImg" class="cover-essay jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				<div class="fleft margin-r-16 ">
						<select id="isOriginal" name="essay.original_flag" style="margin-bottom:105px;"
							onchange="showCouple('isOriginal','original_link','false');showCouple('isOriginal','author','false');">
							<option value="true">原创</option>
							<option value="false">转载</option>
						</select>
				</div>
				<div class="fleft" style="margin-top:0px;">
					<div class="margin-b-4">

						 <input type="text" id="title" name="essay.title" placeholder="文章标题"
							value="${essay.title}" class="nfloat margin-b-4 input-width" />
					</div>
					<div class="margin-b-4">
						<input type="text" id="author" name="essay.author" placeholder="文章作者"
							value="${essay.author}"
							class="nfloat  hidden margin-b-4 input-width" />
					</div>
					<div>
							 <input type="text"
							id="original_link" name="essay.original_link" placeholder="原文地址"
							value="${essay.original_link}"
							class="nfloat hidden input-width" />
					</div>
					<div class="margin-t-23">
						<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
						<label>封面:</label>
						<input type="button" class="btn" value="本地"  onclick="$(file).click();">
						<span>|</span>
						<input type="button" class="btn" value="粘贴网址" id="tog" onclick="if($('#imgUrl').attr('disabled')){$('#tog').val('收起');}else{$('#tog').val('粘贴网址');};toggleDisable('imgUrl');toggleDisable('confBtn');toggleDisable('pas');">
						<input type="url" id="imgUrl" class="hidden" disabled="disabled"  placeholder="粘贴图片网址"  style="width:30%;">
						<input type="button" id="confBtn" class="btn hidden" disabled="disabled"  value="确认" onclick="startCrop();">
						<input type="button" id="pas" class="btn hidden" disabled="disabled" onclick="paste('imgUrl');"   value="清空并粘贴">
					</div>
				</div>
			</div>
				<!-- 正文 -->
			<jsp:include page="../snippets/contentEditor.jsp"/>
			<br/>
			<p>
				选择分类 [<a href="/category" target="_blank">编辑分类</a>]
			</p>
			<s:select list="categories" listKey="id" listValue="name" id="categoryId" name="essay.category" cssClass="margin-b-16"></s:select>
			<p>设置权限</p>
			<s:select list="authorities" listKey="key" listValue="value" cssClass="margin-b-16" id="authority" name='essay.authority' ></s:select>
			<br/>
			<p class="subtit">文章标签</p>
			<div style="position: relative;" >
			<s:if test="essay!=null && essay.label!='' && essay.label!=null">
			<s:iterator value="essay.getLabels()" id="label">
			<span id="labelIterm" name="labelIterm"><input name="essay.label" type="text" id="label" 
				value="<s:property value='label'/>" placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span>
			</s:iterator>
			</s:if><s:else>
				<span id="labelIterm" name="labelIterm"><input name="essay.label" type="text" id="label" 
					placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span></s:else><span id="add" class="cursor-pointer" onclick="addLabel($(this));">&nbsp;<font size="4px">+</font> |</span>
				<span id="reduce" class="hidden cursor-pointer" onclick="redLabel($(this));">&nbsp;<font size="4px">—</font>&nbsp;</span>
			</div>
			<div style="text-align: center; margin-top: 15px;">
				<input id="btnPublish" type="button" onclick="submitForm()" class="btn rounded btn-positive"
					class="input_btn_1" value="发表文章" title="保存并跳转"  style="margin-right:40px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnCancel" type="button" onclick="window.location.href='http://127.0.0.1:8080/iBlog/essayAction.action?method:editEssay'; " class="btn rounded btn-negative btn-reload" value="舍弃" />
			</div>
	<jsp:include page="../snippets/cropIMG.jsp"/>
	</div>
		</form>





	</div>
	<%@ include file="../snippets/footer.jsp"%>

	<script type="text/javascript">
		checkTokenDis($("span[name='labelIterm']").size());
		initSelector('isOriginal', "${essay.original_flag}");
		initSelector('categoryId', "${essay.category}");
		initSelector('authority', "${essay.authority}");
		showCouple('isOriginal','original_link','false');
		showCouple('isOriginal','author','false');
	</script>
</body>
</html>