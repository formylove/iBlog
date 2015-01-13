<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<link type="image/x-icon" href="http://www.luoo.net/favicon.ico" rel="shortcut icon">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setAttribute("importParams", "jquery|index.js|common.css|luoo.js|end|Jcrop.js|main.css|upload.js|ajaxfile.js|vol.css||||"); %>
<%@ include file="snippets/static_js_css.jsp" %>
<title>树</title>
</head>
<body>
<%@ include file="snippets/navigator.jsp" %>
<div class="container ct-sm" style="">
<div id="comment" class="comment-wrapper" >
<div class="comment-editor">
<div class="avatar-wrapper" style="padding-top: 8px;">
			<img class="avatar rounded figure" style="width:88px;height:88px;"  alt="" src="http://s.luoo.net/img/avatar.gif">
</div>
				<div class="editor-wrapper" style="width: 550px;">
					<form id="commentForm" action="http://www.luoo.net/comment/add">
						<div class="editor rounded" >
							<div class="reply-wrapper">
								<a id="replyAtUser" class="reply-at-user" href="javascript:;">@xxx：</a>
								<span id="replyQuotes"></span>
								<a title="取消回复" class="cancle-reply" href="javascript:;">×</a>
							</div>
							
							<textarea autocomplete="off" id="commentEditor" spellcheck="false" name="content"></textarea>

						</div>
						
						<div class="toolbar rounded clearfix">
							<div class="sns-sync">
								同步到
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/weibo">
									<span class="icon-share-weibo"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[weibo]">
								</a>
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/douban">
									<span class="icon-share-douban"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[douban]">
								</a>
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/tweibo">
									<span class="icon-tweibo"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[tweibo]">
								</a>
							</div>
							<button data-width="235" data-remote="http://www.luoo.net/login/dialog" data-tipid="commentSubmitDialog" id="commentSubmit" class="btn btn-positive btn-not-ready rounded">发布</button>
						</div>

						<input type="hidden" value="1" name="app_id">
						<input type="hidden" value="688" name="res_id">
						<input type="hidden" value="0" name="comment_at" id="txtCommentAt">
					</form>
				</div>
				<!-- editor-wrapper end-->
			</div>
<div id="commentList" class="comment-list">
<div class="item">
				<a target="_blank" class="avatar-wrapper" href="http://www.luoo.net/user/537948">
					<img class="avatar rounded figure" style="width:88px;height:88px;" alt="Shin死亡摇滚" src="http://img2.luoo.net/pics/avatars/u537948_1419096154.jpg_128x128.jpg">
				</a>
				<div class="item-wrapper">
					<p class="helper">
						<a target="_blank" class="username" href="http://www.luoo.net/user/537948">Shin死亡摇滚</a>
					</p>
					<div class="comment-ct">
						
						<p data-ct="1419095850" data-vote="" class="the-comment">face to face我喜欢的调调</p>
					</div>
					<div class="helper clearfix">
						13小时前
						<a target="_blank" href="http://www.luoo.net/app/" class="ln-comment-from"><span class="icon-mobile"></span> 来自落网客户端</a>
						<a data-user="Shin死亡摇滚" data-res="178988" class="btn-reply btn-action-reply" href="javascript:;">
							<span class="icon-reply"></span>
							回复
						</a>
						<a rel="nofollow" href="javascript:;" class="btn-vote btn-action-vote" data-width="235" data-tipid="commentVoteDialog178988" data-app="5" data-res="178988">
							<i class="icon-vote"></i> 
							<span>赞</span>
						</a>
						
						<a rel="nofollow" data-width="235" data-tipid="commentReportDialog178988" data-app="5" data-res="178988" class="btn-report btn-action-report" href="javascript:;">
									<span class="icon-report"></span> 
									<span class="report-status">举报</span>
								</a>
						<span data-count="0" style="display:none;" class="vote-count">0赞</span>
					</div>
				</div>
			</div>
<div class="item">
				<a target="_blank" class="avatar-wrapper" href="http://www.luoo.net/user/451465">
					<img class="avatar rounded figure" style="width:88px;height:88px;" alt="林小虫" src="http://s.luoo.net/img/avatar.gif">
				</a>
				<div class="item-wrapper">
					<p class="helper">
						<a target="_blank" class="username" href="http://www.luoo.net/user/451465">林小虫</a>
					</p>
					<div class="comment-ct">
						
						<p data-ct="1419073958" data-vote="" class="the-comment">angel很顺耳</p>
					</div>
					<div class="helper clearfix">
						19小时前
						<a target="_blank" href="http://www.luoo.net/app/" class="ln-comment-from"><span class="icon-mobile"></span> 来自落网客户端</a>
						<a data-user="林小虫" data-res="178862" class="btn-reply btn-action-reply" href="javascript:;">
							<span class="icon-reply"></span>
							回复
						</a>
						<a rel="nofollow" href="javascript:;" class="btn-vote btn-action-vote" data-width="235" data-tipid="commentVoteDialog178862" data-app="5" data-res="178862">
							<i class="icon-vote"></i> 
							<span>赞</span>
						</a>
						
						<a rel="nofollow" data-width="235" data-tipid="commentReportDialog178862" data-app="5" data-res="178862" class="btn-report btn-action-report" href="javascript:;">
									<span class="icon-report"></span> 
									<span class="report-status">举报</span>
								</a>
						<span data-count="0" style="display:none;" class="vote-count">0赞</span>
					</div>
				</div>
			</div> 
			</div> 
			</div> 
			</div> 
<%@ include file="snippets/footer.jsp" %>
<body>

</body>
</html>