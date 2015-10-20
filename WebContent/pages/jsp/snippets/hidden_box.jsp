<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- back to top -->
<div id="backTop">&nbsp;</div>
<!-- back to top End-->
<div class="overlay hidden"></div>
<!-- login-->
<div class="total hidden">
<div id="login-box" >
<div class="dialog-passport" >
	<div class="dialog-head">
		<span class="title">
			登录
		</span>
		<a href="javascript:;" rel="nofollow" class="ln-reg btn-dialog-register" id="registerDialog" data-tipid="registerDialog" data-remote="http://www.luoo.net/register/dialog" data-width="235" onclick="showSiblings($(this));">
			注册
		</a>
		<span class="fright">没有账号？</span>
	</div>
	<form class="form-ajax" action="ajax/login/" method="post" name ="login_form" callback="login_cback">
		<div class="inline-input">
			<span class="label">邮箱</span>
			<input type="email" class="input-passport" autocomplete="off" name="email" required="">
		</div>
		<div class="inline-input">
			<span class="label">密码</span>
			<input type="password" name="password" class="input-passport"  required="">
		</div>
		<div class="btn-wrapper">
			<input type="submit" value="登录" id="login_submit" style="width:100%" class="btn btn-positive btn-login-submit rounded" rel="nofollow">
			<span name="error_placement" class="btn btn-positive btn-login-msg rounded" style="display:none;">
				提示
			</span>
		</div>
		<div class="clearfix">
			<label><input type="checkbox" name="remember"> 下次自动登录</label>
		</div>
	</form>
</div>
<div class="dialog-login-oauth">
	<div class="platforms">
		<a href="http://www.luoo.net/login/oauth/site/weibo" class="icon-open-weibo" rel="nofollow"></a>
		<a href="http://www.luoo.net/login/oauth/site/douban" class="icon-open-douban" rel="nofollow">
		</a>
		<a href="http://www.luoo.net/login/oauth/site/qq" class="icon-open-qq" rel="nofollow"></a>
	</div>
</div>

</div>
<!--                         注册                                                  -->
<div id="register-box" class="hidden">
<div class="dialog-passport" id="register">
	<div class="dialog-head">
		<span class="title">
			注册
            <img style="display: none;" width="1" height="1" src="http://www.luoo.net/register/vild_shit">
		</span>
		<a href="javascript:;" class="ln-login btn-dialog-login"  id="loginDialog" data-tipid="loginDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235" onclick="showSiblings($(this));">
			返回登录
		</a>
	</div>
	<form class="form-ajax" name="register_form" action="ajax/register/" method="post" callback="register_cback">
		<div class="inline-input">
			<span class="label">昵称</span>
			<input type="text" name="nick_name" class="input-passport" autocomplete="off" placeholder="14位以内中英文数字" required="">

		</div>
		<div class="inline-input">
			<span class="label">邮箱</span>
			<input type="email" name="email" class="input-passport" autocomplete="off" required="" placeholder="您的常用邮箱">
		</div>
		<div class="inline-input">
			<span class="label">密码</span>
			<input type="password" class="input-passport" id="password" name="password" autocomplete="off" required="" placeholder="8-16个字符">
		</div>
		<div class="inline-input">
			<span class="label">确认</span>
			<input type="password" class="input-passport" name="psw_conf" autocomplete="off" required="" placeholder="8-16个字符">
		</div>

		<div class="inline-input" style="display:none;">
			<span class="label">验证码</span>
			<input type="text" name="auth_code" class="input-sort" autocomplete="off" required="">
			<img src="http://www.luoo.net/data/captcha" data-src="http://www.luoo.net/data/captcha" alt="验证码" class="verify">
		</div>

		<div class="rule-wrapper">
			<input type="checkbox" name="rule" checked="" required="">
			 同意夜网的
			 <a target="_blank" href="term/">《使用协议》</a>
		</div>
		<div>
			<input type="submit" id="register_submit" style="width:100%" class="btn btn-positive btn-register-submit rounded" value="注册">
			<span class="btn btn-positive btn-register-msg rounded"  name="error_placement2" style="display: none;"></span>
		</div>
	</form>
</div></div>
</div>
<!-- login End-->
<!-- account detail-->
<div class="account hidden">
<div class="account-links rounded" id="accountLinks">
			<a class="account-link link-uc" href="user/profile/${user.id}" target="_blank" rel="nofollow">
				<span class="icon-account"></span>我的落网
			</a>
			<a class="account-link link-setting" href="user/setting/" target="_blank" rel="nofollow">
				<span class="icon-setting"></span>账号设置
			</a>
			<a class="account-link link-logout" href="javaScript:void(0);" rel="nofollow">
				<span class="icon-logout"></span>退出
			</a>
		</div>
		</div>
<!-- account detail end-->
