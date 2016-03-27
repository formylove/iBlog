<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="easyui-tabs" id='group' title="group" style="width: 760px; height: 1085px">
	<div title="朝代" style="padding-top: 10px;padding-left: 10px">
	<form id="dynasty-editor" action="manager/dynasty/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='dynasty==null'>0</s:if><s:else>${dynasty.id}</s:else>">
			<input type="hidden" name="dynasty.id" id="id"  value="<s:if test='dynasty==null'>0</s:if><s:else>${dynasty.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="dynasty.name" class="easyui-textbox" value='${dynasty.name}'>
	    			</td>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="dynasty.name_en" class="easyui-textbox" value='${dynasty.name_en}'></td>
	    		</tr>
	    		<tr>
	    			<td>首都:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="capital" name="dynasty.capital.id" data-options="url:'ajax/manager/city/tree',method:'get'" >
	    			</td>
	    			<td>国父:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="founder" name="dynasty.founder.id" data-options="url:'ajax/manager/figure/tree/domain/政治圈',method:'get'" >
	    			</td>
	    			</tr>
	    		<tr>
	    			<td>建国:</td>
	    			<td><input class="easyui-datebox" id="from" name="dynasty.from"  value='${dynasty.from }'/></td>
	    			<td>灭国:</td>
	    			<td><input class="easyui-datebox" id="perish" name="dynasty.perish"  value='${dynasty.perish}'/></td>
	    		</tr>
	    		<tr>
	    			<td>人口:</td>
	    			<td>
	    			<input id="pupulation" name="dynasty.pupulation" class="easyui-numberbox" value='${dynasty.pupulation}'
	    			data-options="groupSeparator:',',min:0">(万人)
	    			</td>
					<td>面积:</td>
	    			<td>
	    			<input id="area" name="dynasty.area" class="easyui-numberbox" value='${dynasty.area}'
	    			data-options="groupSeparator:',',min:0">(万平方公里)
	    			</td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="dynasty.profile" id='profile' data-options="multiline:true" style="height:80px" value='${dynasty.profile}'/></td>
                </tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','dynasty-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
	<div title="宗教" style="padding-top: 10px;padding-left: 10px">
	<form id="religion-editor" action="manager/religion/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='religion==null'>0</s:if><s:else>${religion.id}</s:else>">
			<input type="hidden" name="religion.id" id="id"  value="<s:if test='religion==null'>0</s:if><s:else>${religion.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="religion.name" class="easyui-textbox" value='${religion.name}'>
	    			</td>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="religion.name_en" class="easyui-textbox" value='${religion.name_en}'></td>
	    		</tr>
	    		<tr>
	    			<td>教主:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="founder" name="religion.founder.id" data-options="url:'ajax/manager/figure/tree/domain/宗教',method:'get'" >
	    			</td>
	    			<td>圣地:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="pilgrimplace" name="religion.pilgrimplace.id" data-options="url:'ajax/manager/city/tree',method:'get'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>国家:</td>
	    			<td>
	    			 <input class="easyui-combotree" id="birthplace" name="religion.birthplace.id" data-options="url:'ajax/manager/nation/tree',method:'get'" >
	    			</td>
	    			<td>教众:</td>
	    			<td><input id="votaryNum" name="religion.votaryNum" class="easyui-numberbox" value='${religion.votaryNum}'
	    			data-options="groupSeparator:',',min:0">(万人)
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>建教:</td>
	    			<td><input class="easyui-datebox" id="from" name="religion.from"  value='${religion.from }'/></td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="religion.profile" id='profile' data-options="multiline:true" style="height:80px" value='${religion.profile}'/></td>
                </tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','religion-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>
	<div title="民族" style="padding-top: 10px;padding-left: 10px">
	<form id="people-editor" action="manager/people/save/" method="post">
			<input type="hidden" name="id" id="id"  value="<s:if test='people==null'>0</s:if><s:else>${people.id}</s:else>">
			<input type="hidden" name="people.id" id="id"  value="<s:if test='people==null'>0</s:if><s:else>${people.id}</s:else>">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>名称:</td>
	    			<td><input id="name" name="people.name" class="easyui-textbox" value='${people.name}'>
	    			</td>
	    			<td>英文:</td>
	    			<td><input id="name_en" name="people.name_en" class="easyui-textbox" value='${people.name_en}'></td>
	    		</tr>
	    		<tr>
                    <td>简介:</td>
                    <td><input class="easyui-textbox" name="people.profile" id='profile' data-options="multiline:true" style="height:80px" value='${people.profile}'/></td>
                </tr>
	    	</table>
		<div  class="margin-t-10" style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="submitForm('name','people-editor')" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" onclick="clearForm()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">清除</span></span></a>
		</div>
	    </form>
	</div>

</div>
<script>
		$(function(){
			<s:if test="#parameters['type'][0] == 'edynasty'">
			$('#group').tabs("select",0);
			<s:if test="dynasty != null">
			$('#dynasty-editor #capital').combotree('setValue', ${dynasty == null?'0':dynasty.capital.id});
			$('#dynasty-editor #founder').combotree('setValue', ${dynasty == null?'0':dynasty.founder.id});
			$('#dynasty-editor #president').combotree('setValue', ${dynasty == null?'0':dynasty.president.id});
			</s:if>
			</s:if>
			<s:if test="#parameters['type'][0] == 'ereligion'">
			<s:if test="religion != null">
			$('#group').tabs("select",1);
			$('#religion-editor #pilgrimplace').combotree('setValue', ${religion == null?'0':religion.pilgrimplace.id});
			$('#religion-editor #birthplace').combotree('setValue', ${religion == null?'0':religion.birthplace.id});
			$('#religion-editor #founder').combotree('setValue', ${religion == null?'0':religion.founder.id});
			</s:if>
			</s:if>
			<s:if test="#parameters['type'][0] == 'epeople'">
			<s:if test="people != null">
			$('#group').tabs("select",2);
			</s:if>
			</s:if>
		})
	</script>
