<!-- back to top -->
<div id="backTop">&nbsp;</div> 
<!-- back to top End-->
<!-- chat -->
<div class="common-dialog-wrapper hide">
		<form id="frmFeedback" action="/feedback/" class="form-ajax">
				<div class="chatbox rounded">
				<ul id="tabs">
   				 <li  id="tab_console" class="hide tab"><a href="#" title="控制台">控制台</a></li>
   				 <li  id="tab_"  class="current tab adminTab"><a href="#" title="管理员">管理员<sub><i style="color: bisque;"></i></sub></a></li>
				</ul>

				<div id="console" contenteditable='true' class="console hide" autofocus>
				</div>
				<div id="chatGroups"> 
				<div id="chatbox_" class="msgScreen adminScreen"></div>
				<div id="toolkit" class="toolkit"></div>
				<textarea id="messageBox" class="msgBox rounded" spellcheck="false"></textarea>
				<p class="fb-group">
				<a href="javascript:;" rel="nofollow" class="btn btn-positive" id="msgSubmit">提交</a>
				<a href="javascript:;" rel="nofollow" class="btn btn-negative" id="msgClear">清空聊天窗口</a>
				<a href="javascript:;" rel="nofollow" class="btn btn-negative" id="msgCancel">取消</a>
				</p>
				</div>
				</div>
		</form>
	</div>
<!-- chat End-->
<!-- login-->
<a id='hopCast' class="hidden" onClick="" target="_blank"></a>
<div class="total hidden">
<div id="login-box" >
<div class="dialog-passport" >
	<div class="dialog-head">
		<span class="title">
			登录
		</span>
		<a href="javascript:;" rel="nofollow" class="ln-reg btn-dialog-register" id="registerDialog" onclick="showSiblings($(this));">
			注册
		</a>
		<span class="fright">没有账号？</span>
	</div>
	<form class="form-ajax" action="ajax/login/" method="post" name ="login_form" onsubmit="">
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
		<a href="login/oauth/site/weibo" class="icon-open-weibo" rel="nofollow"></a>
		<a href="login/oauth/site/douban" class="icon-open-douban" rel="nofollow">
		</a>
		<a href="login/oauth/site/qq" class="icon-open-qq" rel="nofollow"></a>
	</div>
</div>

</div>
<!--                         注册                                                  -->
<div id="register-box" class="hidden">
<div class="dialog-passport" id="register">
	<div class="dialog-head">
		<span class="title">
			注册
		</span>
		<a href="javascript:;" class="ln-login btn-dialog-login"  id="loginDialog" onclick="showSiblings($(this));">
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
			<a class="account-link link-uc" href="user/profile/${requestScope.loginedUser.id}" target="_blank" rel="nofollow">
				<span class="icon-account"></span>我的落网
			</a>
			<a class="account-link link-setting hidden" href="manager/" target="_blank" rel="nofollow">
				<span class="icon-setting"></span>后台管理
			</a>
			<a class="account-link link-logout" href="javaScript:void(0);" rel="nofollow">
				<span class="icon-logout"></span>退出
			</a>
		</div>
		</div>
<!-- account detail end-->
<!-- comment details start-->
<div id ="base" class="item hide" data-floor="1" data-unit="">
            <a class="avatar-wrapper" target="_blank">
                <img class="avatar rounded">
            </a>
<div class="item-wrapper">
                <div class="helper">
                    <a class="username" target="_blank"></a>
                </div>
                <div class="comment-ct">
                    <p class="the-comment" ></p>
                </div>
                <div class="helper clearfix">
                    <a class="ln-comment-from" href="javascript:void(0);" target="_blank"></a>
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply">
                        <span class="icon-reply"></span> 回复
                    </a>
                </div>
                <div class="sub-comment clearfix hide">
                    <span class="arrows"></span>
                    <div class="editor-wrapper hide form-comment-at">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <button name="commentSubmit" data-target="" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix items">
                    </div>
                </div>
            </div>
            </div>
            
   <div id ="upper" class="item hide"  data-floor="1" data-unit="">
            <a class="avatar-wrapper" target="_blank">
                <img class="avatar rounded">
            </a>
            <div class="item-wrapper feedback">
                <a class="username" target="_blank"></a>
                <div class="comment-ct">
                    <p class="the-comment"></p>
                </div>
                <div class="helper clearfix">
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply">
                        <span class="icon-reply"></span> 回复
                    </a>
                </div>
            </div>
                    <div class="editor-wrapper hide form-comment-at">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>
                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <button name="commentSubmit" data-target="" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
        </div>      
            
            