<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
			<input type="hidden" name="cover" id="cover" value="${opus.cover}">
			<input type="hidden" name="opus.cover" id="cover_backup" value="${opus.cover}">
			<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
<div id="works_info" class="clearfix" style="width: 100%">
				<div class="margin-b-16">
					<label>札记类型</label> 
					<select id="type" name='opus.type' onchange="enableCouple('type','book_info','book');enableCouple('type','movie_info','movie');">
						<option value="book">书籍</option>
						<option value="movie">电影</option>
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
			<script type="text/javascript">
	checkToken($("span[name='CastIterm']").size());
	setCheckbox("rec_flag","${opus.rec_flag}");
	initSelector('rating', "${opus.rating}");
	initSelector('genre', "${opus.genre}");
	initSelector('nationality', "${opus.nationality}");
	initSelector('dynasty', "${opus.dynasty}");
	enableCouple('category','book_info','5012');
	enableCouple('category','movie_info','5013');
	showCouple('nationality','dynasty','中国');
	hideCouple('nationality','original_name','中国');
	hideCouple('nationality2','original_name2','中国');
			</script>
				<jsp:include page="../snippets/cropIMG.jsp"/>