<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-tabs" id='poster'style="width: 760px; height: 1085px">
	<div  title="海报" style="padding-top: 10px;padding-left: 10px">
	<div class="top">
				<div id="preview-pane" class="fleft margin-r-55">
					<div id ="preview-container" class="preview-container-poster" onclick="$(file).click();">
						<img src="<s:if test='poster.cover != null && poster.cover != ""'>img/depot/${poster.cover}</s:if><s:else>img/common/poster_default.jpg</s:else>" id="prevImg" class="cover-poster jcrop-preview" alt="Preview" />
					</div>
				</div>
	</div>
	<br>
	<br>
	<br>
	<form id="poster-editor" action="manager/poster/save/" method="post">
	<div style="padding-top: 70px;padding-left: 130px">
	<input type="hidden" name="id" id="id"  value="<s:if test='poster==null'>0</s:if><s:else>${poster.id}</s:else>">
			<input type="hidden" name="poster.id" id="id"  value="<s:if test='poster==null'>0</s:if><s:else>${poster.id}</s:else>">
	    	<input type="hidden" name=cover id="cover" value="${poster.cover}">
			<input type="hidden" name="poster.cover" id="profile_backup" value="${poster.cover}">
			<div class="clearfix">
			<div class="">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>标题:</td>
	    			<td><input class="easyui-textbox" type="text"  id="desc" name="poster.desc"
							value="${poster.desc}"></input></td>
	    		<tr>
	    			<td>url:</td>
	    			<td><input class="easyui-textbox" type="text"  id="url" name="poster.url"
							value="${poster.url}"></input></td>
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

	</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('desc','poster-editor')" ><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
		<div title="海报顺序" style="padding-top: 10px;padding-left: 10px">
		<ol id="posters" class="posters">
		<s:iterator value="posters" id="p" status="st">
		<li class="drag-item" data-id="${p.id }">${p.desc }</li>
		</s:iterator>
		</ol>
		<div  class="margin-t-20" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small submitOrder"><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
		</div>
	</div>
</div>
<script>
		$(function(){
			<s:if test="#parameters['type'][0] == 'eposterorder'">
			$('#poster').tabs("select",1);
			</s:if>
		$('.drag-item').draggable({
					cursor:"options",
					revert:true,
					deltaX:0,
					deltaY:0
				}).droppable({
					onDrop:function(e,source){
						$(source).insertAfter(this);
					}
					});
		$(".submitOrder").click(function(){
			$.ajax({
				url:"manager/poster/update",
				data:{"ids":$(".drag-item").map(function(){return $(this).data("id");}).get().join()},
				success:function(){
					confirm("顺序修改成功");
				}
				});
		});
		});
	</script>
