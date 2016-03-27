<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-panel" title="人物" style="width: 760px; height: 1085px">
	<div title="" style="padding-top: 10px;padding-left: 10px">
	<form id="figure-editor" action="manager/figure/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='figure==null'>0</s:if><s:else>${figure.id}</s:else>">
			<input type="hidden" name="figure.id" id="id"  value="<s:if test='figure==null'>0</s:if><s:else>${figure.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${figure.cover}">
			<input type="hidden" name="figure.cover" id="profile_backup" value="${figure.cover}">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>领域:</td>
	    			<td>
	    			<input id="domain" class="easyui-effect-input" type = "text" name="figure.domain" class="" value='${figure.domain}' list='domains'/>
      				<datalist id='domains'>
      				<s:iterator value="@main.src.service.impl.FigureServiceImpl@getDomains()" id="o">
					<option value=' <s:property value='o'/>'/>
      				</s:iterator>
					</datalist>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="figure.name" class="easyui-textbox" value='${figure.name}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="figure.name_en" class="easyui-textbox" value='${figure.name_en}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>别名:</td>
	    			<td><input id="alias" name="figure.alias" class="easyui-textbox" value='${figure.alias}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input class="easyui-switchbutton" name='figure.gender'
	    			 <s:if test="figure.gender == 'm'">checked</s:if>
	    			 data-options="onText:'男',offText:'女',value:'m'"></td>
	    		</tr>
	    		<tr>
	    			<td>身高:</td>
	    			<td>
	    			<input id="height" name="figure.height" class="easyui-slider" 
                    value='${figure.height}' data-options="showTip:true,min:140,max:240" style="width:180px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>朝代:</td>
	    			<td>
	    			<input class="easyui-combotree" id="dynasty" name="figure.dynasty.id" data-options="url:'/ajax/manager/dynasty/tree/',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>宗教:</td>
	    			<td>
	    			<s:select list="@main.src.service.impl.ReligionServiceImpl@getReligions()" listKey="key" listValue="value" cssClass="easyui-combobox" id="religion" name='figure.religion.id' ></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>种族:</td>
	    			<td>
	    			<s:select list="@main.src.service.impl.PeopleServiceImpl@getPeoples()" listKey="key" listValue="value" cssClass="easyui-combobox" id="echnic" name='figure.echnic.id' ></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>出生:</td>
	    			<td><input class="easyui-datebox" id="from" name="figure.from"  value='${figure.from }'/></td>
	    		</tr>
	    		<tr>
	    			<td>卒没:</td>
	    			<td><input class="easyui-datebox" id="perish" name="figure.perish"  value='${figure.perish}'/></td>
	    		</tr>
	    		<tr>
	    			<td>国家:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="nation" name="figure.nation.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			<td>
	    		</tr>
	    		<tr>
	    			<td>公司:</td>
	    			<td>
	    			<input class="easyui-combotree" id="corp" name="figure.corp.id" data-options="url:'/ajax/manager/corporation/tree/industry/',method:'get'"/>
	    			<td>
	    		</tr>
	    		<tr>
	    			<td>职业:</td>
	    			<td>
	    			<input id="job" class="easyui-effect-input" type = "text" name="figure.job" value='${figure.job}' list='jobs'/>
      				<datalist id='jobs'>
     				<s:iterator value="@main.src.service.impl.FigureServiceImpl@getJobs()" id="o">
					<option value=' <s:property value='o'/>'/>
      				</s:iterator>
					</datalist>
	    			<td>
	    		</tr>
	    		<tr>
	    			<td>职位:</td>
	    			<td><input id="position" name="figure.position" class="easyui-textbox" value='${figure.position}'>
	    			<td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="figure.profile" id='profile' data-options="multiline:true" style="height:80px" value='${figure.profile}'/></td>
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
					<div id ="preview-container" class="preview-container-vertical" onclick="$(file).click();">
						<img src="<s:if test='figure.cover != null && figure.cover != ""'>img/depot/${figure.cover}</s:if><s:else>img/common/vertical_default.jpg</s:else>" id="prevImg" class="cover-vertical jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','figure-editor')" id="submit"><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" id="clear"><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
</div>
<script>
		$(function(){
			$('#nation').combotree('setValue', ${figure == null?'0':figure.nation.id});
		})
	</script>
