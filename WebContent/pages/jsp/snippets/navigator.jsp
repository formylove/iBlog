	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="header">
		<div class="header-ct">
			<a href="img/t.jpg" class="logo">
				<span class="icon-logo"></span>树
			</a>
			<div class="nav" >
				<ul class="clearfix">
					<li><a href="http://www.luoo.net/music/">文字</a></li>
					<li><a href="http://www.luoo.net/music/">技术</a></li>
					<li><a href="http://www.luoo.net/musician/">心情</a></li>
					<li><a href="http://www.luoo.net/app/">梦呓 </a></li>				
					<li><a href="http://www.luoo.net/app/">札记 </a></li>				
					<li><a href="http://www.luoo.net/app/">留言</a></li>				
					<li><a href="http://www.luoo.net/app/">图鉴</a></li>				
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
			<!-- logged-in-wrapper end-->

			<div style="display: block;" class="logged-out-wrapper" id="loggedOutWrapper" data-remote="http://www.luoo.net/login/dialog" data-tipid="headLoginDialog" data-width="235" data-show="mouseenter" data-adjusty="-12">
				<a href="javascript:;" rel="nofollow" class="ln-top-login"> 注册/登录 </a>
				
			</div>
			<!-- logged-out-wrapper -->
		</div>
	</div>