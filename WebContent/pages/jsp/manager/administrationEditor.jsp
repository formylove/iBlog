<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-tabs" id='admin' title="行政单位" style="width: 760px; height: 1085px">
	<div title="国家" style="padding-top: 10px;padding-left: 10px">
	<form id="nation-editor" action="manager/nation/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='nation==null'>0</s:if><s:else>${nation.id}</s:else>">
			<input type="hidden" name="nation.id" id="id"  value="<s:if test='nation==null'>0</s:if><s:else>${nation.id}</s:else>">
			<input type="hidden" name=cover id="cover" value="${nation.cover}">
			<input type="hidden" name="nation.cover" id="profile_backup" value="${nation.cover}">
			<div class="clearfix">
			<div class="fleft">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="nation.name" class="easyui-textbox" value='${nation.name}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="nation.name_en" class="easyui-textbox" value='${nation.name_en}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>华夏:</td>
	    			<td><input class="easyui-switchbutton" name='nation.zhonghua'
	    			 <s:if test='nation.zhonghua'>checked</s:if>
	    			 data-options="onText:'Yes',offText:'No',value:'true'"></td>
	    		</tr>
	    		<tr>
	    			<td>首都:</td>
	    			<td>
	    			<input class="easyui-combotree" id="capital" name="nation.capital.id" data-options="url:'ajax/manager/city/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>货币:</td>
	    			<td><input id="currency" name="nation.currency" class="easyui-textbox" value='${nation.currency}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>英文:</td>
	    			<td><input id="currency_en" name="nation.currency_en" class="easyui-textbox" value='${nation.currency_en}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>语言:</td>
	    			<td><input id="language" name="nation.language" class="easyui-textbox" value='${nation.language}'>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>民族:</td>
	    			<td>
	    			<s:select list="@main.src.service.impl.PeopleServiceImpl@getPeoples()" listKey="key" listValue="value" cssClass="easyui-combobox" id="people" name='nation.people.id' ></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>宗教:</td>
	    			<td>
	    			<s:select list="@main.src.service.impl.ReligionServiceImpl@getReligions()" listKey="key" listValue="value" cssClass="easyui-combobox" id="religion" name='nation.religion.id' ></s:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>建国:</td>
	    			<td><input class="easyui-datebox" id="from" name="nation.from"  value='${nation.from }'/></td>
	    		</tr>
	    		<tr>
	    			<td>灭国:</td>
	    			<td><input class="easyui-datebox" id="perish" name="nation.perish"  value='${nation.perish}'/></td>
	    		</tr>
	    		<tr>
	    			<td>首脑:</td>
	    			<td>
	    			<input class="easyui-combotree" id="president" name="nation.president.id" data-options="url:'/ajax/manager/figure/tree/domain/政治圈',method:'get'" >
	    			<td>
	    		</tr>
	    		<tr>
	    			<td>国父:</td>
	    			<td>
	    			<input class="easyui-combotree" id="founder" name="nation.founder.id" data-options="url:'/ajax/manager/figure/tree/domain/政治圈',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>面积:</td>
	    			<td><input id="area" name="nation.area" class="easyui-numberbox" value='${nation.area}'
	    			data-options="groupSeparator:',',min:0">(万平方公里)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>人口:</td>
	    			<td><input id="population" name="nation.population" class="easyui-numberbox" value='${nation.population}'
	    			data-options="groupSeparator:',',min:0">(万人)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>GDP:</td>
	    			<td><input id="GDP" name="nation.GDP" class="easyui-numberbox" value='${nation.GDP}'
	    			data-options="groupSeparator:',',min:0">(百亿美元)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>大陆:</td>
	    			<td>
	    			<s:select list="@main.src.entity.gallery.Continent@values()" listKey="name" listValue="name" id="continent" name="nation.continent" cssClass="easyui-combobox"></s:select>
	    			</td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="nation.profile" id='profile' data-options="multiline:true" style="height:80px" value='${nation.profile}'/></td>
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
						<img src="<s:if test='nation.cover != null  && nation.cover != ""'>img/depot/${nation.cover}</s:if><s:else>img/common/horizontal_default.jpg</s:else>" id="prevImg" class="cover-horizontal jcrop-preview" alt="Preview" />
					</div>
				</div>
				</div>
				</div>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','nation-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
<jsp:include page="../snippets/cropIMG.jsp"/>
	    </form>
	</div>
	<div title="州/省" style="padding-top: 10px;padding-left: 10px">
	<form id="state-editor" action="manager/state/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='state==null'>0</s:if><s:else>${state.id}</s:else>">
			<input type="hidden" name="state.id" id="id"  value="<s:if test='state==null'>0</s:if><s:else>${state.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="state.name" class="easyui-textbox" value='${state.name}'>
	    			</td>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="state.name_en" class="easyui-textbox" value='${state.name_en}'></td>
	    		</tr>
	    		<tr>
	    			<td>别名:</td>
	    			<td>
	    			<input id="alias" name="state.alias" class="easyui-textbox" value='${state.alias}'>
	    			</td>
	    			<td>GDP:</td>
	    			<td><input id="GDP" name="state.GDP" class="easyui-numberbox" value='${state.GDP}'
	    			data-options="groupSeparator:',',min:0">(亿元)
	    			</td>
	    			</tr>
	    		<tr>
	    			<td>省会:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="capital" name="state.capital.id" data-options="url:'ajax/manager/city/tree',method:'get'" >
	    			</td>
					<td>国家:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="nation" name="state.nation.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="state.profile" id='profile' data-options="multiline:true" style="height:80px" value='${state.profile}'/></td>
                </tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','state-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
	<div title="市" style="padding-top: 10px;padding-left: 10px">
	<form id="city-editor" action="manager/city/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='city==null'>0</s:if><s:else>${city.id}</s:else>">
			<input type="hidden" name="city.id" id="id"  value="<s:if test='city==null'>0</s:if><s:else>${city.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="city.name" class="easyui-textbox" value='${city.name}'>
	    			</td>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="city.name_en" class="easyui-textbox" value='${city.name_en}'></td>
	    		</tr>
	    		<tr>
	    			<td>原名:</td>
	    			<td>
	    			<input id="name_old" name="city.name_old" class="easyui-textbox" value='${city.name_old}'>
	    			</td>
	    			<td>别名:</td>
	    			<td>
	    			<input id="alias" name="city.alias" class="easyui-textbox" value='${city.alias}'>
	    			</td>
	    			</tr>
	    		<tr>
	    			<td>辖下:</td>
	    			<td><input id="under" name="city.under" class="easyui-textbox" value='${city.under}'>
	    			</td>
	    			<td>GDP:</td>
	    			<td><input id="GDP" name="city.GDP" class="easyui-numberbox" value='${city.GDP}'
	    			data-options="groupSeparator:',',min:0">(亿元)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>面积:</td>
	    			<td>
	    			<input id="area" name="city.area" class="easyui-numberbox" value='${city.area}'
	    			data-options="groupSeparator:',',min:0">(平方公里)
	    			</td>
	    			<td>人口:</td>
	    			<td>
	    			<input id="population" name="city.population" class="easyui-numberbox" value='${city.population}'
	    			data-options="groupSeparator:',',min:0">(万人)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>省:</td>
	    			<td>
	    			<input class="easyui-combotree" id="state" name="city.state.id" data-options="url:'ajax/manager/state/tree',method:'get'" >
	    			</td>
	    			<td>国家:</td>
	    			<td>
	    			<input class="easyui-combotree" id="nation" name="city.nation.id" 
	    			data-options="
	    			url:'ajax/manager/nation/tree',
	    			method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="city.profile" id='profile' data-options="multiline:true" style="height:80px" value='${city.profile}'/></td>
                </tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','city-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
</div>
<script>
window.onload = function(){
			<s:if test="#parameters['type'][0] == 'enation'">
			$('#admin').tabs("select",0);
			$('#nation-editor #capital').combotree('setValue', ${nation == null?'':nation.capital.id});
			$('#nation-editor #founder').combotree('setValue', ${nation == null?'':nation.founder.id});
			$('#nation-editor #president').combotree('setValue', ${nation == null?'':nation.president.id});
			</s:if>
			<s:if test="#parameters['type'][0] == 'estate'">
			$('#admin').tabs("select",1);
			$('#state-editor #nation').combotree('setValue', ${state == null?'':state.nation.id});
			$('#state-editor #capital').combotree('setValue', ${state == null?'':state.capital.id});
			</s:if>
			<s:if test="#parameters['type'][0] == 'ecity'">
			$('#admin').tabs("select",2);
			$('#city-editor #nation').combotree('setValue', ${city == null?'':city.nation.id});
			$('#city-editor #state').combotree('setValue', ${city == null?'':city.state.id});
			</s:if>
		};
	</script>
