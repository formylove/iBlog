<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="日志" style="width: 760px; height: 1085px">
	<div style="padding-top: 10px;padding-left: 10px">
	<form id="essay-editor" action="manager/essay/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test="essay==null">0</s:if><s:else>${essay.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${essay.cover}">
			<input type="hidden" name="essay.cover" id="profile_backup" value="${essay.cover}">
			<input type="hidden" name="essay.read_cnt" id="read_cnt" value="<s:if test="essay==null">0</s:if><s:else>${essay.read_cnt}</s:else>">
			<input type="hidden" name="essay.favor_cnt" id="favor_cnt" value="<s:if test="essay==null">0</s:if><s:else>${essay.favor_cnt}</s:else>">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>标题:</td>
	    			<td><input class="easyui-textbox" type="text"  id="title" name="essay.title"
							value="${essay.title}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>副题:</td>
	    			<td><input class="easyui-textbox" type="text"  id="subtitle" name="essay.subtitle"
							value="${essay.subtitle}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>类别:</td>
	    			<td><s:select list="@main.src.service.impl.CategoryServiceImpl@getAll()" listKey="id" listValue="name" id="category" name="essay.category.id" cssClass="easyui-combobox"></s:select></td>
	    		</tr>
	    		<tr>
	    			<td>音乐:</td>
	    			<td>
	    			<input class="easyui-combotree" id="music" name="essay.music.id" data-options="url:'ajax/manager/music/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>权限:</td>
	    			<td>
	    				<s:select list="authorities" listKey="key" listValue="value" cssClass="easyui-combobox" id="authority" name='essay.authority' ></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>来源:</td>
	    			<td><s:select list="#{true:'原创',false:'转载'}" listKey="key" listValue="value" id="original" name="essay.original_flag" cssClass="easyui-combobox" data-options=""></s:select></td>
	    		</tr>
	    		<tr>
	    			<td>作者:</td>
	    			<td><input class="easyui-textbox" type="text" id="author" name="essay.author"
							value="${essay.author}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>头像:</td>
	    			<td><input class="easyui-textbox" type="text" id="portrait" name="essay.portrait"
							value="${essay.portrait}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>主页:</td>
	    			<td><input class="easyui-textbox" type="text" id="author_link" name="essay.author_link"
							value="${essay.author_link}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>原址:</td>
	    			<td><input class="easyui-textbox" type="text"id="original_link" name="essay.original_link"
							value="${essay.original_link}" ></input></td>
	    		</tr>
	    		<tr>
                    <td>封面:</td>
                    <td>
						<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
						<input type="button" class="btn" value="粘贴网址" id="tog" onclick="if($('#imgUrl').attr('disabled')){$('#tog').val('收起');}else{$('#tog').val('粘贴网址');};toggleDisable('imgUrl');toggleDisable('confBtn');toggleDisable('pas');">
						<input type="url" id="imgUrl" class="hidden " style="line-height: 15px;height: 15px;border: 1px solid #95B8E7;" disabled="disabled"  placeholder="粘贴图片网址"   class="easyui-textbox">
						<input type="button" id="confBtn" class="btn hidden" disabled="disabled"  value="确认" onclick="startCrop();">
                     </td>               
                </tr>
	    	</table>
	    	</div>
	    		<div class="fright">
				<div id="preview-pane" class="fleft margin-r-55">
					<div id ="preview-container" class="preview-container-horizontal" onclick="$(file).click();">
						<img src="<s:if test='essay.cover != null && essay.cover != ""'>img/depot/${essay.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-horizontal jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
				<div  class="margin-t-10 margin-l-10">
			<div style="position: relative;" ><label>标签:</label>
			<s:if test="essay!=null && essay.label!='' && essay.label!=null">
			<s:iterator value="essay.getLabels()" id="label">
			<span id="labelIterm" name="labelIterm"><input class="easyui-textbox" name="essay.label" type="text" id="label" 
				value="<s:property value='label'/>" placeholder="标签"/>&nbsp;|&nbsp;</span>
			</s:iterator>
			</s:if><s:else>
				<span id="labelIterm" name="labelIterm"><input name="essay.label" type="text" id="label" class="easyui-textbox"
					placeholder="标签"/>&nbsp;|&nbsp;</span></s:else><span id="add" class="cursor-pointer" onclick="addLabel($(this));">&nbsp;<font size="4px">+</font> |</span>
				<span id="reduce" class="hidden cursor-pointer" onclick="redLabel($(this));">&nbsp;<font size="4px">—</font>&nbsp;</span>
			</div>
				
				</div>
				<div class="margin-t-20 float">
		<textarea id="editor" name="essay.content" placeholder="文章内容">${essay.content}</textarea>
		<script type="text/javascript">
			CKEDITOR.replace('editor', {uiColor:'#E0ECFF', height: '550px', width: '730px' });
		</script>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('title','essay-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
</div>
	<script type="text/javascript">
		checkTokenDis($("span[name='labelIterm']").size());
	</script>
