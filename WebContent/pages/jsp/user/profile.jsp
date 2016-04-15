<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@page import="main.src.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.nick_name}</title>
<%request.setAttribute("importParams", "general|user.js|user.css|datapicker|Jcrop|upload.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container ct-sm" style="min-height: 221px;">
<input type="hidden" id="userId" value="${user.id}">	
<!-- uc-head -->
<div class="uc-head clearfix">
	<div class="avatar-wrapper" id="avatarEditWrapper">
		<input type="file" onchange="ajaxUpload('file');" id="file" name="file" accept=".jpg,.jpeg,.png,.gif" style="display:none;">
		<%@ include file="../snippets/cropPortrait.jsp" %>
		<img src="img/depot/${user.portrait}" alt="${user.nick_name}" class="avatar">
		<a href="javascript:;" rel="nofollow" class="ln-edit-avatar" id="lnEditAvatar" onclick="$(file).click();">修改头像</a>
	</div>
	<div class="uinfo">
		<div class="clearfix">
			<h1 class="uname">${user.nick_name}</h1>
			<p class="join">${user.register_date.year + 1900}-${user.register_date.month + 1}-${user.register_date.date}&nbsp;加入</p>
		</div>
		
		<div class="sign">			
			<div style="display: block;" id="textMood">
				<span id="txtMoodCt" class="mood-ct" data-editable="true">${(user.motto==null)?"说两句吧...":user.motto}</span>
				<a class="ln-edit-mood" href="javascript:;" id="lnEditMood">编辑</a>
			</div>
			
			<div  id="formMood" class="form-mood hidden">
				<form id="motto-form" action="ajax/login/update/" method="post" class="form-ajax">
				<input type="hidden" name="update_type" value="motto"/>
				<input type="hidden" name="id" value="${user.id}"/>
				<input type="text" id="motto" name="motto" style="width:355px;" value="" maxlength="70">
					&nbsp;
					<a href="javascript:;" class="helper" id="lnSaveMood">保存</a> 
					<a href="javascript:;" class="helper" id="lnCancleMood">取消</a>
				</form>
			</div>					
		</div>
	</div>
</div>
<!--/// uc-head end-->
		<div class="uc-nav rounded clearfix" style = "margin: 20px 0;">
			<a href="javascript:void();" rel="nofollow" id="setting-base" class="nav-item tab-item actived">基础设置</a>
			<a href="javascript:void();" rel="nofollow" id="setting-pwd" class="nav-item tab-item">修改密码</a>
			<a href="javascript:void();" rel="nofollow" id="setting-sns" class="nav-item tab-item">社区绑定</a>
		</div>
		<div class="uc-ct">
			<!-- setting-base -->
			<div class="setting-base tab-content-item" style="display: block;">
				<div class="setting-row" style="border-bottom: 1px solid #E5E5E5; padding-bottom: 25px;">
					<div class="setting-name">
						<span class="helper">
							昵称
						</span>
						<br>
				<p >
					<span>${user.nick_name}</span>					
					<a href="javascript:;" class="ln-setting-edit" id="lnEditUsername" rel="nofollow">更改</a>
				</p>
					</div>
					<div class="setting-autoplay">
						<span class="helper">
							播放设置
						</span>
						<br>
						<label>
							<input type="checkbox" name="autoplay" id="chkAutoplay" value="true" ${user.autoplay?"checked":"" }>自动播放网站音乐
						</label>
					</div>
				</div>
				<div class="setting-row helper"> 资料 </div> 
				<form method="post" id="details" class="form-ajax" action="ajax/login/update">
					<input type="hidden" name="update_type" value="details"/>
					<input type="hidden" name="id" value="${user.id}"/>
					<%if(((User)request.getAttribute("loginedUser")).getAuthority() == 0) {%>
					<c:if test="${not empty user.email }">
					<div class="setting-row">
						<span class="label">邮件</span>
						${user.email }
					</div>
					</c:if>
					<c:if test="${not empty user.device}">
					<div class="setting-row">
						<span class="label">设备</span>
						${user.device }
					</div>
					</c:if>
					<c:if test="${not empty user.register_ip }">
					<div class="setting-row">
						<span class="label">地址</span>
						${user.register_ip }
					</div>
					</c:if>
					<c:if test="${not empty user.city }">
					<div class="setting-row">
						<span class="label">城市</span>
						${user.city }
					</div>
					</c:if>
					<div class="setting-row">
						<span class="label">权限</span>
						<input type="text" name="level" style="width: 70px;" class="rounded input-listener" value="${user.authority }">
					</div>
					<%} %>
					<div class="setting-row">
						<span class="label">性别</span>
						<label>
							<input type="radio" name="gender" value="m" <s:if test="user.gender == 'm'">checked</s:if> class="input-listener"> 男
						</label>
						<label>
							<input type="radio" name="gender" value="f"  <s:if test="user.gender == 'f'">checked</s:if> class="input-listener"> 女
						</label>
					</div>
					<div class="setting-row" style="position: relative;">
						<span class="label">生日</span>
						<span class="helper" id="birthdayPlaceholder"><c:if test="${user.birthday!=null}">${fn:substring(user.birthday,0,10)}</c:if><c:if test="${user.birthday==null}">[未填]</c:if></span>						
						<a href="javascript:;" class="ln-setting-edit input-listener" rel="nofollow" id="lnEditBrithday">更改</a>	
						<input type="text" id="txtBirthday" name="birthday" value="<c:out value='${fn:substring(user.birthday,0,10)}'/>" style="width: 185px; visibility: hidden; position: absolute; top: -26px; margin-left: 5px;">				
					</div>
					<div class="setting-row">
						<span class="label">QQ&nbsp;</span>
						<input type="text" name="qq" style="width: 70px;" class="rounded input-listener" value="${user.qq }">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row">
						<span class="label">微信</span>
						<input type="text" name="wechat" style="width: 70px;" class="rounded input-listener" value="${user.wechat }">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row">
						<span class="label">手机</span>
						<input type="text" name="phone" style="width: 70px;" class="rounded input-listener" value="${user.phone }">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row setting-bottom">
						<input type="submit" value="保存" class="btn rounded btn-positive btn-not-ready" id="btnBasicSubmit">
					</div>
				</form>
			</div>
			<!-- ///setting-base end-->

			<!-- setting-pwd -->
			<div class="setting-pwd tab-content-item" style="display: none;">
				<form action="ajax/login/update/" method="post" id="reset_psw" class="form-ajax" >
					<input type="hidden" name="update_type" value="password"/>
					<input type="hidden" name="id" value="${user.id}"/>
					<div class="setting-row">
						<span class="label">当前密码</span>
						<input type="password" name="password" class="rounded" id="txtPassword" autocomplete="off">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row">
						<span class="label">新的密码</span>
						<input type="password" name="newpassword" class="rounded" id="txtNewpassword" autocomplete="off">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row">
						<span class="label">确认密码</span>
						<input type="password" name="psw_conf" class="rounded" id="txtCmfpassword" autocomplete="off">
						<span class="valid-msg"></span>
					</div>
					<div class="setting-row setting-bottom">
						<input type="submit" value="保存" class="btn btn-positive rounded">
						<input type="reset" value="取消" class="btn btn-negative rounded btn-reload">
					</div>
				</form>
			</div>
			<!-- ///setting-pwd end-->
			
			<!-- setting-sns -->
			<div class="setting-sns tab-content-item" style="display: none;">
				<div class="setting-row">
					绑定社区账号，能够将你的评论同步到以下平台。
				</div>
				
						<div class="setting-sns-row">
							<i class="icon-uc-qq"></i>
							<a href="login/oauth/site/qq/act/bind" class="ln-bind">绑定QQ账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-share-weibo"></i>
							<a href="login/oauth/site/weibo/act/bind" class="ln-bind" rel="nofollow">绑定微博账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-share-douban"></i>
							<a href="login/oauth/site/douban/act/bind" class="ln-bind" rel="nofollow">绑定豆瓣账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-tweibo"></i>
							<a href="login/oauth/site/tweibo/act/bind" class="ln-bind" rel="nofollow">绑定腾讯微博</a>
						</div>
									</div>
			<!-- ///setting-sns end-->
		</div>
	</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>