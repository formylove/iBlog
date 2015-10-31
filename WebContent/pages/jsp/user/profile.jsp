<%@ page language="java" import="main.src.common.WebUtils" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.nick_name}</title>
<%request.setAttribute("importParams", "general|user|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<jsp:include page="../snippets/hidden_box.jsp"/>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container ct-sm" style="min-height: 221px;">	
<!-- uc-head -->
<div class="uc-head clearfix">
	<div class="avatar-wrapper" id="avatarEditWrapper">
		<img src="${user.portrait}" alt="${user.nick_name}" class="avatar">
		<a href="javascript:;" rel="nofollow" class="ln-edit-avatar" id="lnEditAvatar" style="display: none;">修改头像</a>	</div>
	<div class="uinfo">
		<div class="clearfix">
			<h1 class="uname">${user.nick_name}</h1>
			<p class="join">${user.register_date.year + 1900}-${user.register_date.month + 1}-${user.register_date.date}&nbsp;加入</p>
		</div>
		
		<div class="sign">			
			<div style="display: block;" id="textMood">
				<span id="txtMoodCt" class="mood-ct" data-editable="true">${(user.motto==null || user.motto==null)?"说两句吧...":user.motto}</span>
				<a class="ln-edit-mood" href="javascript:;" id="lnEditMood">${self == "true"?"编辑":""}</a>
			</div>
			
			<div  id="formMood" class="form-mood hidden">
				<form id="motto-form" action="ajax/user/update/" method="post" class="form-ajax">
				<input type="hidden" name="update_type" value="motto"/>
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
			<a href="#basic" rel="nofollow" id="tab-basic" class="nav-item tab-item actived">基础设置</a>
			<a href="#pwd" rel="nofollow" id="tab-pwd" class="nav-item tab-item">修改密码</a>
			<a href="#sns" rel="nofollow" id="tab-sns" class="nav-item tab-item">社区绑定</a>
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
					${user.nick_name}					<a href="javascript:;" class="ln-setting-edit" id="lnEditUsername" rel="nofollow">更改</a>
				</p>
					</div>
					<div class="setting-autoplay">
						<span class="helper">
							播放设置
						</span>
						<br>
						<label>
							<input type="checkbox" name="autoplay" id="chkAutoplay" checked="">自动播放网站音乐
						</label>
					</div>
				</div>
				<div class="setting-row helper"> 资料 </div> 
				<form method="post" class="form-ajax" callback="profile_common_cback">
						
					<div class="setting-row">
						<span class="label">性别</span>
						<label>
							<input type="radio" name="gender" value="m" class="input-listener"> 男
						</label>
						<label>
							<input type="radio" name="gender" value="f" class="input-listener"> 女
						</label>
					</div>
					<div class="setting-row" style="position: relative;">
						<span class="label">生日</span>
						<span class="helper" id="birthdayPlaceholder">[未填]</span>						<a href="javascript:;" class="ln-setting-edit input-listener" rel="nofollow" id="lnEditBrithday">更改</a>	
						<input type="text" id="txtBirthday" name="birthday" style="width: 185px; visibility: hidden; position: absolute; top: -26px; margin-left: 5px;">				
					</div>
					<div class="setting-row">
						<span class="label">QQ</span>
						<input type="text" name="vocation" style="width: 52px;" class="rounded input-listener" value="">
					</div>
					<div class="setting-row setting-bottom">
						<input type="submit" value="保存" class="btn rounded btn-positive btn-not-ready" id="btnBasicSubmit">
						<input type="button" value="取消" class="btn rounded btn-negative btn-reload">
					</div>
				</form>
			</div>
			<!-- ///setting-base end-->

			<!-- setting-pwd -->
			<div class="setting-pwd tab-content-item" style="display: none;">
				<form action="http://www.luoo.net/user/password" method="post" class="form-ajax" callback="pwd_cback" prepare="pwd_valid">
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
						<input type="button" value="取消" class="btn btn-negative rounded btn-reload">
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
							<a href="http://www.luoo.net/login/oauth/site/qq/act/bind" class="ln-bind">绑定QQ账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-share-weibo"></i>
							<a href="http://www.luoo.net/login/oauth/site/weibo/act/bind" class="ln-bind" rel="nofollow">绑定微博账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-share-douban"></i>
							<a href="http://www.luoo.net/login/oauth/site/douban/act/bind" class="ln-bind" rel="nofollow">绑定豆瓣账号</a>
						</div>
						
						<div class="setting-sns-row">
							<i class="icon-tweibo"></i>
							<a href="http://www.luoo.net/login/oauth/site/tweibo/act/bind" class="ln-bind" rel="nofollow">绑定腾讯微博</a>
						</div>
									</div>
			<!-- ///setting-sns end-->

		</div>

	</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>