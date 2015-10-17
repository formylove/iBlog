<%@ page language="java" import="main.src.common.WebUtils" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.nick_name}</title>
<%request.setAttribute("importParams", "jquery|Akita.js|qtip|form|validate|user.css|end"); %>
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
			
			<div style="display: none;" id="formMood" class="form-mood">
				<form action="http://www.luoo.net/mood/add" method="post" class="form-ajax" callback="add_mood_cback">
					<input type="text" id="txtContent" name="content" style="width:355px;" value="" data-value="" maxlength="70">
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
				<p class="setting-row nickname">
					了不起的提利昂					<a href="javascript:;" class="ln-setting-edit" id="lnEditUsername" rel="nofollow">更改</a>
				</p>
				<div class="setting-row" style="border-bottom: 1px solid #E5E5E5; padding-bottom: 25px;">
					<div class="setting-email">
						<span class="helper">
							登录邮箱
						</span>
						<br>
						<p>
							ansyx@163.com							<a href="javascript:;" class="ln-setting-edit" id="lnEditEmail" rel="nofollow">更改</a>
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
							<input type="radio" name="sex" value="1" class="input-listener"> 男
						</label>
						<label>
							<input type="radio" name="sex" value="2" class="input-listener"> 女
						</label>
					</div>
					<div class="setting-row" style="position: relative;">
						<span class="label">生日</span>
						<span class="helper" id="birthdayPlaceholder">[未填]</span>						<a href="javascript:;" class="ln-setting-edit input-listener" rel="nofollow" id="lnEditBrithday">更改</a>	
						<input type="text" id="txtBirthday" name="birthday" style="width: 185px; visibility: hidden; position: absolute; top: -26px; margin-left: 5px;">				
					</div>
					<div class="setting-row">
						<span class="label">常居</span>
						<span id="areaSelector">
							<select class="province input-listener" name="province" data-val=""><option value="0">请选择</option><option value="北京">北京</option><option value="天津">天津</option><option value="河北">河北</option><option value="山西">山西</option><option value="内蒙古">内蒙古</option><option value="辽宁">辽宁</option><option value="吉林">吉林</option><option value="黑龙江">黑龙江</option><option value="上海">上海</option><option value="江苏">江苏</option><option value="浙江">浙江</option><option value="安徽">安徽</option><option value="福建">福建</option><option value="江西">江西</option><option value="山东">山东</option><option value="河南">河南</option><option value="湖北">湖北</option><option value="湖南">湖南</option><option value="广东">广东</option><option value="广西">广西</option><option value="海南">海南</option><option value="重庆">重庆</option><option value="四川">四川</option><option value="贵州">贵州</option><option value="云南">云南</option><option value="西藏">西藏</option><option value="陕西">陕西</option><option value="甘肃">甘肃</option><option value="青海">青海</option><option value="宁夏">宁夏</option><option value="新疆">新疆</option><option value="香港">香港</option><option value="澳门">澳门</option><option value="台湾">台湾</option></select> 
							<select class="city input-listener" name="city" data-val="" disabled="disabled" style="display: none;"></select>
						</span>					
					</div>
					<div class="setting-row">
						<span class="label">职业</span>
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
						<input type="password" name="cmfpassword" class="rounded" id="txtCmfpassword" autocomplete="off">
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