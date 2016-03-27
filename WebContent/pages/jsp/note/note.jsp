<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${note.title} - 札记</title>
<%request.setAttribute("importParams", "jquery|note.css|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container ct-sm note-detail-wrapper" style="min-height: 221px;">	
		<nav class="article-nav">
			<a href="notes/" class="nav-back">
				<i class="icon-back"></i>
				返回札记首页
			</a>
		</nav>
					<script type="text/javascript">

			
			</script>
		<div class="event-head clearfix">
			<img src="img/depot/${opus.cover}" alt="${note.title}" class="poster rounded">
			<div class="event-meta">
				<h1 style="font-size: 24px;">${note.title}</h1>
				<!-- note meta -->
<%-- 				<jsp:include page="../snippets/noteMeta.jsp"/> --%>
				<s:iterator value="opus.getMeta()" id="entry">
				<p class="meta"><s:property value="key"/>:
				<s:property value="value"/></p>
				</s:iterator>
			<p class="meta">分享：<span id="shareBtns" class="share-btns" data-app="event" data-id="13084" data-text="分享一个活动【2015天津卓扬岛屿音乐节 】（分享自@落网）" data-img="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/event/13084/55f0edd5bd747.jpg?imageView2/1/w/180/h/225"><a href="javascript:;" class="btn-action-linkout" data-href="http://service.weibo.com/share/share.php?url=http%3A%2F%2Fwww.luoo.net%2Fevent%2F13084&amp;title=%E5%88%86%E4%BA%AB%E4%B8%80%E4%B8%AA%E6%B4%BB%E5%8A%A8%E3%80%902015%E5%A4%A9%E6%B4%A5%E5%8D%93%E6%89%AC%E5%B2%9B%E5%B1%BF%E9%9F%B3%E4%B9%90%E8%8A%82%20%E3%80%91%EF%BC%88%E5%88%86%E4%BA%AB%E8%87%AA%40%E8%90%BD%E7%BD%91%EF%BC%89&amp;source=%E8%90%BD%E7%BD%91&amp;sourceUrl=http%3A%2F%2Fluoo.net&amp;content=utf-8&amp;pic=http%3A%2F%2F7xkszy.com2.z0.glb.qiniucdn.com%2Fpics%2Fevent%2F13084%2F55f0edd5bd747.jpg%3FimageView2%2F1%2Fw%2F180%2Fh%2F225" target="_blank"><span class="icon-share-weibo" title="分享到微博"></span></a><a href="javascript:;" class="btn-action-linkout" data-href="http://www.douban.com/share/service?bm=1&amp;image=http%3A%2F%2F7xkszy.com2.z0.glb.qiniucdn.com%2Fpics%2Fevent%2F13084%2F55f0edd5bd747.jpg%3FimageView2%2F1%2Fw%2F180%2Fh%2F225&amp;href=http%3A%2F%2Fwww.luoo.net%2Fevent%2F13084&amp;updated=&amp;name=%E5%88%86%E4%BA%AB%E4%B8%80%E4%B8%AA%E6%B4%BB%E5%8A%A8%E3%80%902015%E5%A4%A9%E6%B4%A5%E5%8D%93%E6%89%AC%E5%B2%9B%E5%B1%BF%E9%9F%B3%E4%B9%90%E8%8A%82%20%E3%80%91%EF%BC%88%E5%88%86%E4%BA%AB%E8%87%AA%40%E8%90%BD%E7%BD%91%EF%BC%89" target="_blank" title="分享到豆瓣"><span class="icon-share-douban"></span></a><a href="javascript:;" class="btn-action-linkout" data-href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http%3A%2F%2Fwww.luoo.net%2Fevent%2F13084&amp;desc=%E5%88%86%E4%BA%AB%E4%B8%80%E4%B8%AA%E6%B4%BB%E5%8A%A8%E3%80%902015%E5%A4%A9%E6%B4%A5%E5%8D%93%E6%89%AC%E5%B2%9B%E5%B1%BF%E9%9F%B3%E4%B9%90%E8%8A%82%20%E3%80%91%EF%BC%88%E5%88%86%E4%BA%AB%E8%87%AA%40%E8%90%BD%E7%BD%91%EF%BC%89&amp;pics=http%3A%2F%2F7xkszy.com2.z0.glb.qiniucdn.com%2Fpics%2Fevent%2F13084%2F55f0edd5bd747.jpg%3FimageView2%2F1%2Fw%2F180%2Fh%2F225" target="_blank" title="分享到QQ空间"><span class="icon-share-qzone"></span></a><a href="javascript:;" class="btn-show-qr" data-href="http://www.luoo.net/event/13084" target="_blank" title="分享到朋友圈"><span class="icon-share-wechat"></span></a></span></p>
			</div>
		</div>
		
		<div class="event-intro">
			<h3 class="title">札记</h3>
			<div class="ct">${note.content}</div>
		</div>
			<!-- 点赞区 -->		 
		<div class="note-share">
				<a href="javascript:;" >
					<span id="like" class="icon-note-fav"  onclick="like('${id}');" style="margin-right:5px;" ></span>
					<span id="liked" class="icon-note-faved hidden"  onclick="undoLike('${id}');" style="margin-right:5px;" ></span>
					<span id="favorcnt"><s:property value="note.favor_cnt"/></span>
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:;" class="btn-share btn-action-share" data-app="note" data-id="520'" data-text="这篇文章值得一读【惘闻：艺术与声音的即兴合作——奇迹寻踪】（分享自@落网）" data-img="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/notes/201508/55d5b1119b303.jpg" title="分享">
					<span class="icon-note-share"></span>
				</a>
			</div>	
<!-- 作者信息 -->
					<s:if test="note.author != null && note.author != '' ">
					 <div class="note-author-wrapper clearfix">
				<div class="note-author">
					<p class="title">
						文章作者
					</p>
						<div class="clearfix">
							<a href="<s:property value='note.author_link'/>" class="avatar-wrapper">
								<img src="<s:property value='note.portrait'/>" alt="<s:property value='note.author'/>" class="avatar rounded"/>
							</a>
							<div class="note-author-info">
								<div class="cell">
									<a href="<s:property value='note.author_link'/>" class="note-author-name">
										<s:property value="note.author"/>
									</a>
									<p class="note-author-sign"><s:property value='note.author_desc'/></p>
								</div>
							</div>
						</div>
										</div>
				<div class="copyright">
					<p class="title">
						版权声明
					</p>
					<div class="copyright-ct">
						「夜网」专栏内文章，如果侵权，立即删除
					</div>
				</div>
			</div>
			</s:if>
	</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>