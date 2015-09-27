<%@ page language="java" import="java.util.Map,main.src.entity.essay.Essay" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>札记</title>
<%
	request.setAttribute("importParams", "jquery|common.css|Akita.js|validate|ckeditor.js|upload.js|Jcrop|end");
%>
<%@ include file="../snippets/static_js_css.jsp"%>
<style type="text/css">
select{
height:27px;
width:100px;
}
input[type=number]{
height:23px;
}
input[type=month]{
height:23px;
}
</style>
</head>
<body style="position:relative;">
	<%@ include file="../snippets/navigator.jsp"%>
 <div class="overlay hidden"></div>
 
	<div class="container index-ct round-container" style="min-height: 221px;">
	<form id="form" action="<s:url action='noteAction.action?method:saveNote'/>" method="post">
			<input type="hidden" name="id" id="id"  value="<c:choose><c:when test="${empty note}">0</c:when><c:otherwise>${note.id}</c:otherwise></c:choose>">
			<input type="hidden" name="cover" id="cover" value="${opus.cover}">
			<input type="hidden" name="opus.cover" id="cover_backup" value="${opus.cover}">
			<input type="hidden" name="note.read_cnt" id="read_cnt" value="<c:choose><c:when test="${empty note}">0</c:when><c:otherwise>${note.read_cnt}</c:otherwise></c:choose>">
			<input type="hidden" name="note.favor_cnt" id="favor_cnt" value="<c:choose><c:when test="${empty note}">0</c:when><c:otherwise>${note.favor_cnt}</c:otherwise></c:choose>">
			<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
			<div id="works_info" class="clearfix" style="width: 100%">
				<div class="margin-b-16">
					<label>札记类型</label> 
					<select id="category" name='note.category' onchange="enableCouple('category','book_info','5012');enableCouple('category','movie_info','5013');">
						<option value="5012">书评</option>
						<option value="5013">影评</option>
					</select>
					<label class="margin-l-30">推荐：<s:checkbox id="rec_flag" name='rec_flag' value="false" onclick="showCoupleForCheckbox('rec_flag','remark','true');"
					></s:checkbox></label>
					&nbsp;<label class="hidden" id="remark">推荐评语&nbsp;&nbsp;<input class="width-30" name="opus.remark" type="text" value="${opus.remark }" /></label>
				</div>
				<div id="preview-pane" class="fleft margin-r-55">
					<div id ="preview-container" class="preview-container-note" >
						<img src="<s:if test="opus.cover != null">img/depot/${opus.cover}</s:if><s:else>img/note/review_default.jpg</s:else>" id="prevImg" class="cover-note jcrop-preview" alt="Preview" />
					</div>
				</div>
				<div class="fleft width-70">
				<div id="book_info" >
					<div class="margin-b-8">
						<label>图书信息</label>&nbsp;&nbsp;<s:select list="rate" listKey="key" listValue="value"  id="rating" name='opus.rating' ></s:select>
						<input type="hidden" name="opus.type" value="book">
					</div>
					<div class="margin-b-6">
						<input type="text" placeholder="书名" id='works_name' name='opus.name' value="${opus.name}"> 
						<input type="text" placeholder="译名" id='original_name' name='opus.original_name' value="${opus.original_name}"> 
						<s:select list="genres.{?#this.type=='book'}" listKey="id" listValue="name" id="genre" name='opus.genre' ></s:select>
					</div>
					<div class="margin-b-6">
						<input type="text" placeholder="作者" id="author_directior" name='opus.author_directior' value="${opus.author_directior}"> 
						<s:select list="nation" listKey="key" listValue="value" 
						onchange="showCouple('nationality','dynasty','中国');hideCouple('nationality','original_name','中国');" id="nationality" name='opus.nationality' ></s:select>
						<s:select id="dynasty" name='opus.dynasty' list="dynastys" listKey="key" listValue="value" cssClass="hidden" >
						</s:select>
					</div>
				</div>
				<!-- 电影 -->
				<div id="movie_info" class="hidden">
					<div class="margin-b-8">
						<label>电影信息</label>&nbsp;&nbsp;<label>评分：</label><input type="number" max="10" min="0" step="0.2" id="score" name='opus.rating' value="${opus.rating}"/>
						<input type="hidden" name="opus.type" value="movie">
					</div>
					<div class="margin-b-6">
						<input  type="text" placeholder="电影名" id="works_name" name='opus.name' value="${opus.name}"> 
					    <input type="text" placeholder="译名"  id='original_name2' name='opus.original_name' value="${opus.original_name}">
						<s:select list="genres.{?#this.type=='movie'}" listKey="id" listValue="name"   id="genre" name='opus.genre' ></s:select>
						<s:select list="nation" listKey="key" listValue="value"   id="nationality2" name='opus.nationality' onchange="hideCouple('nationality2','original_name2','中国');"></s:select>
					</div>
					<div class="margin-b-6">
						<input  type="text" id="author_directior" name='opus.author_directior' placeholder="导演" value="${opus.author_directior}"> 
						<label>上映日期：</label>&nbsp;&nbsp;<input  type="month" placeholder="上映日期" id="publish_date" name='opus.publish_date' value="${opus.publish_date}">
					</div>
			<div>
				</div>
			</div>
				  <div class="margin-b-6">
						<s:if test="opus!=null && opus.protagonists!=''&& opus.protagonists!=null">
						<s:iterator value="opus.getAllProtagonists()" id="protagonist">
						<span id="CastIterm" name="CastIterm"><input name="opus.protagonists" type="text" id="protagonist" 
							value="<s:property value='protagonist'/>" placeholder="主角"  style="width: 13%; height: 20px;"/>&nbsp;|&nbsp;</span>
						</s:iterator>
						</s:if><s:else>
						<span id="CastIterm" name="CastIterm"><input name="opus.protagonists" type="text"
								placeholder="主角"  style="width: 13%; height: 20px;"/>&nbsp;|&nbsp;</span></s:else><span id="add2" class="cursor-pointer" onclick="addCast($(this));">&nbsp;<font size="4px">+</font> |</span>
						<span id="reduce2" class="hidden cursor-pointer" onclick="redCast($(this));">&nbsp;<font size="4px">—</font>&nbsp;</span>
					</div>
					<div class="margin-t-23">
					<label>封面:</label>
					<input type="button" class="btn" value="本地上传"  onclick="$(file).click();">
					<span>|</span>
					<input type="button" class="btn" value="粘贴图片网址" id="tog" onclick="if($('#imgUrl').attr('disabled')){$('#tog').val('收起');}else{$('#tog').val('粘贴图片网址');};toggleDisable('imgUrl');toggleDisable('confBtn');toggleDisable('pas');">
					<input type="url" id="imgUrl" class="hidden" disabled="disabled"  placeholder="粘贴图片网址"  style="width:40%;">
					<input type="button" id="confBtn" class="btn hidden" disabled="disabled"  value="确认" onclick="startCrop();">
					<input type="button" id="pas" class="btn hidden" disabled="disabled" onclick="paste('imgUrl');"   value="清空并粘贴">
			        </div>
			</div>
			</div>
			<div id="review" class="clearfix">
				<div>
					<label style="float: none;">札记正文</label>
				</div>
				<div class="clearfix">
				<s:select id="isOriginal" name="note.original_flag" list="#{'true':'原创','false':'转载'}" 
				onchange="showCouple('isOriginal','original_link','false');showCouple('isOriginal','author','false');">
				</s:select>
					<input type="text" id="title" required="required" name="note.title" placeholder="文章标题"
						 value="${note.title}" style="width: 85%;  margin-bottom: 11px;"/>
					<input type="text" id="subtitle" name="note.subtitle" placeholder="副标题"
						 value="${note.subtitle}" style="width: 85%;margin-left:105px;"/>
				</div>
				<div class="margin-b-6 clearfix">
					<input type="text" id="author" name="note.author" placeholder="文章作者"
						value="${note.author}" class="hidden width-40" style="margin-left: 105px;margin-right: 24px"/>
					<input type="url" id="original_link" name="note.original_link"
						placeholder="原文地址" class="hidden width-40" value="${note.original_link}" />
				</div>
				<div class="section">
					<textarea id="editor" name="note.content" placeholder="文章内容" rows="30"
						style="width: 99.4%;">${note.content}</textarea>
				</div>
			</div>
			<script type="text/javascript">
				var editortext = CKEDITOR.replace('note.content');
			</script>

			<p class="margin-t-20">设置权限</p>
			<s:select list="authority" listKey="key" listValue="value" cssClass="margin-b-16" id="authority" name='note.authority' ></s:select>
			<p class="subtit">文章标签</p>
			<div style="position: relative;" >
			<s:if test="note!=null && note.label!='' && note.label!=null">
			<s:iterator value="note.getLabels()" id="label">
			<span id="labelIterm" name="labelIterm"><input name="note.label" type="text" id="label" 
				value="<s:property value='label'/>" placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span>
			</s:iterator>
			</s:if><s:else>
				<span id="labelIterm" name="labelIterm"><input name="note.label" type="text" id="label" 
					placeholder="标签"  style="width: 15%; height: 20px;"/>&nbsp;|&nbsp;</span></s:else><span id="add" class="cursor-pointer" onclick="addLabel($(this));">&nbsp;<font size="4px">+</font> |</span>
				<span id="reduce" class="hidden cursor-pointer" onclick="redLabel($(this));">&nbsp;<font size="4px">—</font>&nbsp;</span>
			</div>

			<script type="text/javascript">
				var duplicateCheck = function() {
					$.ajax({
								url : 'noteAction.action?method:hasExisted',
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
				<input id="btnPublish" type="button" onclick="duplicateCheck()" class="btn rounded btn-positive"
					class="input_btn_1" value="发表文章" title="保存并跳转"  style="margin-right:40px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnCancel" type="button" onclick="window.location.href='http://127.0.0.1:8080/iBlog/noteAction.action?method:editNote'; " class="btn rounded btn-negative btn-reload" value="舍弃" />
			</div>
	<jsp:include page="../snippets/cropIMG.jsp"/>
		</form>
	</div>
	<%@ include file="../snippets/footer.jsp"%>
	<script type="text/javascript">
	checkToken($("span[name='CastIterm']").size());
	checkTokenDis($("span[name='labelIterm']").size());
	setCheckbox("rec_flag","${opus.rec_flag}");
	initSelector('rating', "${opus.rating}");
	initSelector('genre', "${opus.genre}");
	initSelector('nationality', "${opus.nationality}");
	initSelector('dynasty', "${opus.dynasty}");
	initSelector('isOriginal', "${note.original_flag}");
	initSelector('category', "${note.category}");
	initSelector('authority', "${note.authority}");
	enableCouple('category','book_info','5012');
	enableCouple('category','movie_info','5013');
	showCouple('nationality','dynasty','中国');
	hideCouple('nationality','original_name','中国');
	hideCouple('nationality2','original_name2','中国');
	showCouple('isOriginal','original_link','false');
	showCouple('isOriginal','author','false');
	</script>
</body>
</html>