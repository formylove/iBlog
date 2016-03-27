<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="公司" style="width: 760px; height: 1085px">
<div title="" style="padding-top: 10px;padding-left: 10px">
	<form id="corporation-editor" action="manager/corporation/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='corporation==null'>0</s:if><s:else>${corporation.id}</s:else>">
			<input type="hidden" name="corporation.id" id="id"  value="<s:if test='corporation==null'>0</s:if><s:else>${corporation.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${corporation.cover}">
			<input type="hidden" name="corporation.cover" id="profile_backup" value="${corporation.cover}">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>行业:</td>
	    			<td>
	    			<input id="industry" class="easyui-effect-input" type = "text" name="corporation.industry" class="" value='${corporation.industry}' list='industries'/>
      				<datalist id='industries'>
      				<s:iterator value="@main.src.service.impl.CorporationServiceImpl@getIndustries()" id="o">
					<option value=' <s:property value='o'/>'/>
      				</s:iterator>
					</datalist>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="corporation.name" class="easyui-textbox" value='${corporation.name}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="corporation.name_en" class="easyui-textbox" value='${corporation.name_en}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>国别:</td>
	    			<td>
	    			<input class="easyui-combotree" id="nation" name="corporation.nation.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			 </td>
	    		</tr>
	    		<tr>
	    			<td>总部:</td>
	    			<td>
	    			<input class="easyui-combotree" id="headquarters" name="corporation.headquarters.id" data-options="url:'ajax/manager/city/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>创始:</td>
	    			<td>
	    			<input class="easyui-combotree" id="founder" name="corporation.founder.id" data-options="url:'ajax/manager/figure/tree/domain/商业',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>董事:</td>
	    			<td>
	    			<input class="easyui-combotree" id="chairman" name="corporation.chairman.id" data-options="url:'ajax/manager/figure/tree/domain/商业',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>CEO:</td>
	    			<td>
	    			<input class="easyui-combotree" id="CEO" name="corporation.CEO.id" data-options="url:'ajax/manager/figure/tree/domain/商业',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>成立:</td>
	    			<td><input class="easyui-datebox" id="from" name="corporation.from"  value='${corporation.from }'/></td>
	    		</tr>
	    		<tr>
	    			<td>DTO:</td>
	    			<td><input id="turnover" name="corporation.turnover" class="easyui-numberbox" value='${corporation.turnover}'
	    			data-options="groupSeparator:',',min:0">(百万美元)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>市值:</td>
	    			<td><input id="marketCapitalization" name="corporation.marketCapitalization" class="easyui-numberbox" value='${corporation.marketCapitalization}'
	    			data-options="groupSeparator:',',min:0">(千万美元)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>员工:</td>
	    			<td><input id="headcount" name="corporation.headcount" class="easyui-numberbox" value='${corporation.headcount}'
	    			data-options="groupSeparator:',',min:0">(人)
	    			</td>
	    		</tr>
	    		<tr>
                    <td>品牌:</td>
                    <td><input class="easyui-textbox" name="corporation.brands" id='brands' data-options="multiline:true" style="height:80px" value='${corporation.brands}'/></td>
                </tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="corporation.profile" id='profile' data-options="multiline:true" style="height:80px" value='${corporation.profile}'/></td>
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
					<div id ="preview-container" class="preview-container-horizontal" onclick="$(file).click();">
						<img src="<s:if test='corporation.cover != null && corporation.cover != ""'>img/depot/${corporation.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-horizontal jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','corporation-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
</div>
<script>
		$(function(){
			<s:if test="corporation != null">
			$('#corporation-editor #nation').combotree('setValue', ${corporation == null?'0':corporation.nation.id});
			$('#corporation-editor #headquarters').combotree('setValue', ${corporation == null?'0':corporation.headquarters.id});
			$('#corporation-editor #founder').combotree('setValue', ${corporation == null?'0':corporation.founder.id});
			$('#corporation-editor #chairman').combotree('setValue', ${corporation == null?'0':corporation.chairman.id});
			$('#corporation-editor #CEO').combotree('setValue', ${corporation == null?'0':corporation.CEO.id});
			</s:if>
		})
	</script>
