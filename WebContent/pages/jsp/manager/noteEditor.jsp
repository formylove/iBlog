<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="札记" style="width: 760px; height: 1085px">
	<div style="padding-top: 10px;padding-left: 10px">
	<form id="note-editor" action="manager/note/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test="note==null">0</s:if><s:else>${note.id}</s:else>">
			<input type="hidden" name="note.id" id="id"  value="<s:if test='note==null'>0</s:if><s:else>${note.id}</s:else>">
			<input type="hidden" name="note.read_cnt" id="read_cnt" value="<s:if test="note==null">0</s:if><s:else>${note.read_cnt}</s:else>">
			<input type="hidden" name="note.favor_cnt" id="favor_cnt" value="<s:if test="note==null">0</s:if><s:else>${note.favor_cnt}</s:else>">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>作品:</td>
	    			<td>
	    			<input class="easyui-combotree" id="opus" name="note.opus.id" data-options="url:'/ajax/manager/opus/tree/',method:'get'" />
					</td>
	    			<td>音乐:</td>
	    			<td>
	    			<input class="easyui-combotree" id="music" name="note.music.id" data-options="url:'ajax/manager/music/tree',method:'get'" ></td>
	    		</tr>
					
	    		<tr>
	    			<td>权限:</td>
	    			<td>
	    				<s:select list="authorities" listKey="key" listValue="value" cssClass="easyui-combobox" id="authority" name='note.authority' ></s:select>
	    			</td>
	    			<td>来源:</td>
	    			<td><s:select list="#{true:'原创',false:'转载'}" listKey="key" listValue="value" id="original" name="note.original_flag" cssClass="easyui-combobox" data-options=""></s:select></td>
	    		</tr>
	    		<tr>
	    			<td>标题:</td>
	    			<td><input class="easyui-textbox" type="text"  id="title" name="note.title"
							value="${note.title}"></input></td>
	    			<td>副题:</td>
	    			<td><input class="easyui-textbox" type="text"  id="subtitle" name="note.subtitle"
							value="${note.subtitle}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>作者:</td>
	    			<td><input class="easyui-textbox" type="text" id="author" name="note.author"
							value="${note.author}"></input></td>
	    			<td>头像:</td>
	    			<td><input class="easyui-textbox" type="text" id="portrait" name="note.portrait"
							value="${note.portrait}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>主页:</td>
	    			<td><input class="easyui-textbox" type="text" id="author_link" name="note.author_link"
							value="${note.author_link}"></input></td>
	    			<td>原址:</td>
	    			<td><input class="easyui-textbox" type="text"id="original_link" name="note.original_link"
							value="${note.original_link}" ></input></td>
	    		</tr>
	    	</table>
	    	</div>
				</div>
				<div class="margin-t-20 float">
		<textarea id="editor" name="note.content" placeholder="文章内容">${note.content}</textarea>
		<script type="text/javascript">
			CKEDITOR.replace('editor', {uiColor:'#E0ECFF', height: '550px', width: '730px' });
		</script>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('title','note-editor')"><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
</div>
