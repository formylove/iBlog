<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-tabs" id='collection' title="collection" style="width: 760px; height: 1085px">
	<div title="文章分类" style="padding-top: 10px;padding-left: 10px">
	<form id="category-editor" action="manager/category/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='category==null'>0</s:if><s:else>${category.id}</s:else>">
			<input type="hidden" name="category.id" id="id"  value="<s:if test='category==null'>0</s:if><s:else>${category.id}</s:else>">
	    	<input type="hidden" name=cover id="cover" value="${category.cover}">
			<input type="hidden" name="category.cover" id="profile_backup" value="${category.cover}">
	    	<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="category.name" class="easyui-textbox" value='${category.name}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>描述:</td>
	    			<td><input id="desc" name="category.desc" class="easyui-textbox" value='${category.desc}'></td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="category.profile" id='profile' data-options="multiline:true" style="height:80px" value='${category.profile}'/></td>
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
						<img src="<s:if test='category.cover != null && category.cover != ""'>img/depot/${category.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-horizontal jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
			</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','category-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
	<div title="作品类型" style="padding-top: 10px;padding-left: 10px">
	<form id="genre-editor" action="manager/genre/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='genre==null'>0</s:if><s:else>${genre.id}</s:else>">
			<input type="hidden" name="genre.id" id="id"  value="<s:if test='genre==null'>0</s:if><s:else>${genre.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td>
	    			<input id="name" name="genre.name"  class="easyui-textbox" value='${genre.name}'>
	    			</td>
	    			<td>类型:</td>
	    			<td>
	    			<select class="easyui-combobox" name="genre.type">
	    			<option value="movie" selected>电影</option>
	    			<option value="book">书</option>
	    			<option value="series">连续剧</option>
	    			</select>
	    			</td>
	    		</tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','genre-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>

</div>
<script>
		$(function(){
			<s:if test="#parameters['type'][0] == 'ecategory'">
			$('#group').tabs("select",0);
			</s:if>
			<s:if test="#parameters['type'][0] == 'egenre'">
			$('#group').tabs("select",1);
			</s:if>
		})
	</script>
