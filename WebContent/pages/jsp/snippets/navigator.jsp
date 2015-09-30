	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<div class="header">
		<div class="header-ct">
			<a href="" class="logo">
				<span class="icon-logo"></span>树
			</a>
			<div class="nav" >
				<ul class="clearfix">
					<li><a href="essays/">文字</a></li>
					<li><a href="tsukkomi/">心情</a></li>
					<li><a href="somniloquy/">梦呓 </a></li>				
					<li><a href="notes/">札记 </a></li>				
					<li><a href="illustration/">长廊</a></li>				
					<li><a href="essays/">留言</a></li>				
				</ul>

			</div>
			
				<div class="head-search">
					<form class="search-form" action="http://www.luoo.net/search/" id="headSearchForm">
						<input class="search-input" name="q" autocomplete="off" type="text">
						<button class="search-btn" type="submit">
							<span class="icon-search"></span>
						</button>
					</form>
				</div>			<!-- logged-in-wrapper -->
			<div style="display: none;" class="logged-in-wrapper" id="loggedInWrapper"></div>

		<s:if test="user == null">
		<!-- logged-out-wrapper -->
			<div style="display: block;" class="logged-out-wrapper" id="loggedOutWrapper" data-remote="http://www.luoo.net/login/dialog" data-tipid="headLoginDialog" data-width="235" data-show="mouseenter" data-adjusty="-12">
				<a href="javascript:;" rel="nofollow" class="ln-top-login"> 注册/登录 </a>
			</div>
			<!-- logged-out-wrapper -->
		</s:if>
		<s:else>
<div class="logged-in-wrapper" id="loggedInWrapper" style="display: block;">
<a href="javascript:;" rel="nofollow" class="ln-message" id="lnMessage" data-show="mouseenter" data-remote="http://www.luoo.net/message/latest" data-tipid="messageDialog" data-width="270" data-adjusty="-10">
	<span class="icon-message"></span>
	</a>
<div class="account-more">
	<a href="javascript:;" rel="nofollow" class="ln-account" id="lnAccountMore" data-ct="accountMoreWrapper" data-show="mouseenter" data-tipid="accountMoreDialog" data-adjusty="-10" data-hasqtip="accountMoreDialog" aria-describedby="qtip-accountMoreDialog">
		<img src="${user.portrait}" alt="${user.nick_name}" class="avatar">
		${user.nick_name}	</a>		
	<div id="accountMoreWrapper" style="display: none;">
		<div class="account-links rounded" id="accountLinks">
			<a class="account-link link-uc" href="user/${user.id}/" rel="nofollow">
				<span class="icon-account"></span>我的落网
			</a>
			<a class="account-link link-setting" href="user/profile/" rel="nofollow">
				<span class="icon-setting"></span>账号设置
			</a>
			<a class="account-link link-logout" href="user/logout" rel="nofollow">
				<span class="icon-logout"></span>退出
			</a>
		</div>
	</div>		
</div></div>
</s:else>
</div>
			<!-- logged-out-wrapper -->
		</div>
	</div>