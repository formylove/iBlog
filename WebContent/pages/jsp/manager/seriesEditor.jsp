<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="连续剧"  style="width: 760px; height: 1085px">
	<div style="padding-top: 10px;padding-left: 10px">
	<form id="series-editor" action="manager/opus/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='opus==null'>0</s:if><s:else>${opus.id}</s:else>">
			<input type="hidden" name="opus.id" id="id"  value="<s:if test='opus==null'>0</s:if><s:else>${opus.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${opus.cover}">
			<input type="hidden" name="opus.cover" id="profile_backup" value="${opus.cover}">
			<input type="hidden" name="opus.type" id="type" value="series">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>评分:</td>
	    			<td>
	    			<input id="rating" name="opus.rating" class="easyui-slider" 
                    value='${opus.rating}' data-options="showTip:true,min:0,max:100" style="width:210px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>类型:</td>
	    			<td>
	    			<s:select list="@main.src.service.impl.GenreServiceImpl@getAll().{?#this.type=='series'}" listKey="id" listValue="name" id="genre0" name="opus.genres[0].id" cssClass="easyui-combobox"></s:select>
	    			<s:select list="@main.src.service.impl.GenreServiceImpl@getAll().{?#this.type=='series'}" listKey="id" listValue="name" id="genre1" name="opus.genres[1].id" cssClass="easyui-combobox"></s:select>
	    			<s:select list="@main.src.service.impl.GenreServiceImpl@getAll().{?#this.type=='series'}" listKey="id" listValue="name" id="genre2" name="opus.genres[2].id" cssClass="easyui-combobox"></s:select>
	    			<input name = "controller_genre_类型" class="easyui-numberspinner" value="<c:out value='${fn:length(opus.genres)}'></c:out>" style="width:80px;" data-options="
                				min:0,
                				max:3,
                				onChange: function(value){
                           disableSelect('genre',value);}"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>推荐:</td>
	    			<td><input class="easyui-switchbutton" name='opus.rec_flag'
	    			 <s:if test='opus.rec_flag'>checked</s:if>
	    			 data-options="onText:'Yes',offText:'No',value:'true'"></td>
	    		</tr>
	    		<tr>
	    			<td>名称:</td>
	    			<td><input class="easyui-textbox" type="text"  id="name" name="opus.name"
							value="${opus.name}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>英文:</td>
	    			<td><input class="easyui-textbox" type="text"  id="name_en" name="opus.name_en"
							value="${opus.name_en}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>国家:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="nation" name="opus.nation.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			<td>
	    		</tr>
	    		
	    		<tr>
	    			<td>导演:</td>
	    			<td>
	    			<input class="easyui-combotree" id="author_directior" name="opus.author_directior.id" data-options="url:'/ajax/manager/figure/tree/domain/娱乐圈',method:'get'" />
</td>
	    		</tr>
	    		<tr>
	    			<td>演员:</td>
	    			<td>
	    			<input class="easyui-combotree" id="protagonists0" name="opus.protagonists[0].id" data-options="url:'/ajax/manager/figure/tree/domain/娱乐圈',method:'get'" style="width: 120px;"/>
	    			<input class="easyui-combotree" id="protagonists1" name="opus.protagonists[1].id" data-options="url:'/ajax/manager/figure/tree/domain/娱乐圈',method:'get'"  style="width: 120px;"/>
	    			<input class="easyui-combotree" id="protagonists2" name="opus.protagonists[2].id" data-options="url:'/ajax/manager/figure/tree/domain/娱乐圈',method:'get'"  style="width: 120px;"/>
	    			<input name = "controller_protagonists_演员" class="easyui-numberspinner" value="<c:out value='${fn:length(opus.protagonists)}'></c:out>" style="width:50px;" data-options="
                				min:0,  
                				max:3,  
                				onChange: function(value){  
                          disableComboTree('protagonists',value);}"/> 
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>制片:</td>
	    			<td>
	    			<input class="easyui-combotree" id="pictures" name="opus.pictures.id" data-options="url:'/ajax/manager/corporation/tree/industry/影视',method:'get'"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>上映:</td>
	    			<td><input class="easyui-datebox" id="publish_date" name="opus.publish_date"  value='${opus.publish_date }'/></td>
	    		</tr>
	    		<tr>
                    <td>剧透:</td>
                    <td><input class="easyui-textbox" name="opus.spoiler" id='spoiler' data-options="multiline:true" style="height:80px" value='${opus.spoiler}'/></td>
                </tr>
	    		<tr>
                    <td>短评:</td>
                    <td><input class="easyui-textbox" name="opus.remark" id='remark' data-options="multiline:true" style="height:80px" value='${opus.remark}'/></td>
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
					<div id ="preview-container" class="preview-container-vertical"  onclick="$(file).click();">
						<img src="<s:if test='opus.cover != null && opus.cover != ""'>img/depot/${opus.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-vertical jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','series-editor')"><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
</div>
<script>
		$(function(){
			disableSelect('genre',<c:out value='${fn:length(opus.genres)}'></c:out>);
		})
	</script>
