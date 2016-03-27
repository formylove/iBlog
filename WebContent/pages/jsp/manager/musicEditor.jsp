<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="音乐"  style="width: 760px; height: 1085px">
	<div style="padding-top: 10px;padding-left: 10px">
	<form id="movie-editor" action="manager/music/save/"  enctype="multipart/form-data" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='music==null'>0</s:if><s:else>${music.id}</s:else>">
			<input type="hidden" name="music.id" id="id"  value="<s:if test='music==null'>0</s:if><s:else>${music.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${music.cover}">
			<input type="hidden" name="music.cover" id="profile_backup" value="${music.cover}">
			<input type="hidden" name="music.url" id="url_backup" value="${music.url}">
			<input type="hidden" name="music.favor_cnt" id="favor_cnt" value="<s:if test="essay==null">0</s:if><s:else>${music.favor_cnt}</s:else>">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input class="easyui-textbox"  id="name" name="music.name"
							value="${music.name}" /></td>
	    		</tr>
	    		<tr>
	    			<td>类型:</td>
	    			<td><input class="easyui-effect-input" type="text" id="style" name="music.style" list='styles'
							value="${music.style}" ></input>
      				<datalist id='styles'>
      				<s:iterator value="@main.src.service.impl.MusicServiceImpl@getStyles()" id="o">
					<option value=' <s:property value='o'/>'/>
      				</s:iterator>
					</datalist>
							</td>
	    		</tr>
	    		<tr>
	    			<td>优先级:</td>
	    			<td>
	    			<s:select cssClass="easyui-combobox" id="precedence" name="music.precedence" list="#{0:'0',1:'1',2:'2',3:'3'}" listKey="key" listValue="value"></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>国家:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="nation" name="music.nation.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>歌手:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="singer" name="music.singer.id" data-options="url:'ajax/manager/figure/tree/domain/娱乐圈',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>作曲:</td>
	    			<td><input class="easyui-textbox"  id="composer" name="music.composer"
							value="${music.composer}" /></td>
	    		</tr>
	    		<tr>
                    <td>短评:</td>
                    <td><input class="easyui-textbox" name="music.motto" id='motto' data-options="multiline:true" style="height:80px" value='${music.motto}'/></td>
                </tr>
	    		<tr>
                    <td>上传:</td>
                    <td>
                    <s:fielderror></s:fielderror>
                    <input class="easyui-filebox" id = "musicFile" name="musicFile" data-options="
                    prompt:'上传音乐...',
                    accept:'mp3,wav,ogg'"/>
                    </td>
                </tr>
                <tr>
                    <td>封面:</td>
                    <td>
						<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
						<input type="button" class="btn" value="粘贴网址" id="tog" onclick="if($('#imgUrl').attr('disabled')){$('#tog').val('收起');}else{$('#tog').val('粘贴网址');};toggleDisable('imgUrl');toggleDisable('confBtn');toggleDisable('pas');">
						<input type="url" id="imgUrl" class="hidden easyui-effect-input" disabled="disabled"  placeholder="粘贴图片网址"   class="easyui-textbox">
						<input type="button" id="confBtn" class="btn hidden" disabled="disabled"  value="确认" onclick="startCrop();">
                     </td>               
                </tr>
	    	</table>
	    	</div>
	    		<div class="fright">
				<div id="preview-pane" class="fleft margin-r-55">
					<div id ="preview-container" class="preview-container-horizontal"  onclick="$(file).click();">
						<img src="<s:if test='music.cover != null && music.cover != ""'>img/depot/${music.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-horizontal jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','movie-editor')"><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
</div>
<script>
		$(function(){
		})
	</script>
