	<%@taglib prefix="s" uri="/struts-tags"%>
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
				</div>	
		<s:if test="#request.logined_user == null">
		<!-- logged-out-wrapper -->
			<div style="display: block;" class="logged-out-wrapper" id="loggedOutWrapper" >
				<a href="javascript:;" rel="nofollow" class="ln-top-login"> 注册/登录 </a>
			</div>
			<!-- logged-out-wrapper -->
			<div class="logged-in-wrapper hidden" id="loggedInWrapper">
			<a href="javascript:;" rel="nofollow" class="ln-message" id="lnMessage">
			<span class="icon-message"></span>
			</a>
			<div class="account-more">
			<a href="javascript:;" rel="nofollow" class="ln-account" >
			</a>		
</div>
</div>
		</s:if>
		<s:else>
			<div class="logged-out-wrapper hidden"
				id="loggedOutWrapper">
				<a href="javascript:;" rel="nofollow" class="ln-top-login">
					注册/登录 </a>
			</div>
			<div class="logged-in-wrapper" id="loggedInWrapper"
				style="display: block;">
				<a href="javascript:;" rel="nofollow" class="ln-message"
					id="lnMessage"> <span class="icon-message"></span>
				</a>
				<div class="account-more">
					<a href="javascript:;" rel="nofollow" class="ln-account"
						id="lnAccountMore"> <img src="${requestScope.logined_user.portrait}"
						alt="${requestScope.logined_user.nick_name}" class="avatar"> ${requestScope.logined_user.nick_name}
					</a>
				</div>
			</div>
		</s:else>
</div>
		</div>
