<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<s:set name="importParams" value="'general|common.css|utils|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
<title>约会规划</title>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container index-ct" style="min-height: 221px;" >	
			<div  class="margin-b-16">
 			<label for="meet" >约会时间：</label><input id="meet" type="time" autofocus accesskey="q" tabindex="1"  step="600">
			</div>
			<div style="position: relative;" >
				<div name="iterm" id="iterm" class="margin-b-6">
				<input name="effort" type="number" id="label" 
					placeholder="用时"  style="width: 15%; height: 20px;" autofocus tabindex="2" step="10"/>
				</div>
				<div id="operate" class="margin-t-20">
					<span id="add" class="cursor-pointer" onclick="addLabel($('#operate'));">&nbsp;<font size="4px">添加</font></span>
					<span id="reduce" class="hidden cursor-pointer" onclick="redLabel();">|&nbsp;<font size="4px">删除</font></span>
				</div>
			</div>
				<div id="result" class="margin-t-20 hidden" style="">
				出发时间：<label id="resultValue"></label>
				</div>
			<div style="text-align: center; margin-top: 15px;">
				<input id="btnPublish" type="button" onclick="getDepartureTime()" class="btn rounded btn-positive"
					class="input_btn_1" value="计算" title="保存并跳转"  style="margin-right:40px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnCancel" type="button" onclick="clearTimeBox()" class="btn rounded btn-negative btn-reload" value="舍弃" />
			</div>

</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>
