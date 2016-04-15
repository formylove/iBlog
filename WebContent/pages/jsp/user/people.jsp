<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.nick_name}</title>
<%request.setAttribute("importParams", "general|user.css|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container ct-sm" style="min-height: 221px;">
<input type="hidden" id="userId" value="${user.id}">	
<!-- uc-head -->
<div class="uc-head clearfix" style="border-bottom: 1px solid #E5E5E5; padding-bottom: 25px;">
	<div class="avatar-wrapper" id="avatarEditWrapper">
		<img src="img/depot/${user.portrait}" alt="${user.nick_name}" title="${user.nick_name}" class="avatar">
	</div>
	<div class="uinfo">
		<div class="clearfix">
			<h1 class="uname">${user.nick_name}</h1>
			<p class="join">${user.register_date.year + 1900}-${user.register_date.month + 1}-${user.register_date.date}&nbsp;加入</p>
		</div>
		
		<div class="sign">			
			<div style="display: block;" id="textMood">
				<span id="txtMoodCt" class="mood-ct" data-editable="true">${(user.motto==null)?"这人太懒，什么也没留下...":user.motto}</span>
			</div>
		</div>
	</div>
</div>
		<div class="uc-ct">
			<!-- setting-base -->
			<div class="setting-base tab-content-item" style="display: block;">
				<div class="exhibit-row helper"> 资料 </div> 
					<s:if test="user.gender != null">
					<div class="exhibit-row">
						<span class="label">性别:</span>
						<label>
							<s:if test="user.gender == 'm'">男</s:if>
							<s:if test="user.gender == 'f'">女</s:if>
						</label>
					</div>
					</s:if>
					<s:if test="user.birthday != null">
					<div class="exhibit-row" style="position: relative;">
						<span class="label">生日:</span>
						<c:out value='${fn:substring(user.birthday,0,10)}'/>
					</div>
					</s:if>
					<s:if test="user.qq != null">
					<div class="exhibit-row">
						<span class="label">QQ:&nbsp;</span>
						${user.qq }
					</div>
					</s:if>
					<s:if test="user.wechat != null">
					<div class="exhibit-row">
						<span class="label">微信:</span>
						${user.wechat }
					</div>
					</s:if>
			</div>
		</div>
		</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>