<%@ page language="java" contentType="text/html; charset=UTF-8"
import="main.src.entity.essay.Essay"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>那些文字</title>
<%request.setAttribute("importParams", "jquery|index.js|essay.css|luoo.js|end"); %>
<%@ include file="../snippets/static_js_css.jsp" %>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container" style="min-height: 221px;">	
		
				<div class="essay-banner clearfix">
					<img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/essays/201508/55dd7ef0375a3.jpg" alt="秋天，邀你来喝一碗叫做“布衣”的酒" class="cover">
					<div class="meta">
						<a href="http://www.luoo.net/essay/521" class="title">秋天，邀你来喝一碗叫做“布衣”的酒</a>
						<p class="content">20年，对于一个人来说，是从少年到中年，从懵懂到成熟；20年，对于一支乐队来说实属不易，而布衣的脚步却从未停止，秉着那股西北硬汉不服输的劲头子，一路走一路唱。布衣就像一瓶陈年佳酿，随着时间的沉淀，布衣的音乐愈加韵味深长。布衣这瓶酒，怎么喝都不嫌多呢！</p>
<!-- 						<p class="date">2015-08-26</p> -->
<!-- 						<p class="more"> -->
<!-- 							<a href="http://www.luoo.net/essay/521" class="ln-more">全文</a> -->
						</p>
					</div>
				</div>
					<div class="clearfix">
			<!-- article start-->
			<div class="article article-sm">
				<!-- essay-list -->
				<div class="essay-list">
				<s:iterator value="essays" id="essay" status="st">
							<div class="item">
								<a href="essay/<s:property value='essay.id'/>/" class="cover-wrapper">
									<img class="cover rounded" src="<s:property value='essay.profile'/>" alt="<s:property value='essay.title'/>">
								</a>
								<div class="essay-wrapper">									
									<a href="essay/<s:property value='essay.id'/>/" title="曹方最新单曲《海鸥》首发" class="title">
										<s:property value='essay.title'/>
									</a>
									<s:if test="essay.original_flag">
									<div class="meta">
										<span class="category">首发</span><span class="separator">・</span><a class="entry-author" href="hachi/">徐大海</a><span class="separator">・</span><span class="time"><s:property value='essay.create_date'/></span>
									</div>
									</s:if>
									<s:else>
									<div class="meta">
										<span class="category">转发</span><span class="separator">・</span><a class="entry-author" href="<s:property value='essay.author_link'/>">author</a><span class="separator">・</span><span class="time"><s:property value='essay.create_date'/></span>
									</div>
									</s:else>
									<div class="subscribe">
									<%
		
									Essay e = (Essay) request.getAttribute("essay");
									String subtitle = e.getSubtitle();
									if(subtitle!=null ||!subtitle.equals(""))
									{
									subtitle = subtitle.replaceAll("&lt;img.+?&gt;","").replaceAll("<img.+?>","").replaceAll("&lt;b&gt;","").replaceAll("<b>","").replaceAll("&lt;/b&gt;","").replaceAll("</b>","").replaceAll("&lt;br&gt;","").replaceAll("<br>;","");
										if(subtitle.length()>130){
											subtitle = subtitle.substring(0,129)+"...";
										}
									%>
									<%=subtitle%>
									<% 
									}else{
										String content = e.getContent();
										content = e.getContent().replaceAll("&lt;img.+?&gt;","").replaceAll("<img.+?>","").replaceAll("&lt;b&gt;","").replaceAll("<b>","").replaceAll("&lt;/b&gt;","").replaceAll("</b>","").replaceAll("&lt;br&gt;","").replaceAll("<br>;","");
										if(content.length()>130){
											content = content.substring(0,129)+"...";
										}
										%>
										<%=content%>
										<% 	
									}
									%>
									</div>
								</div>
							</div>
				</s:iterator>
							
							
				</div>
				<!--/// essay-list end-->

				<div class="paginator">
					<a class="previous disabled" rel="nofollow" href="javascript:;">上一页</a><a class="page actived" rel="nofollow" href="javascript:;">1</a><a class="page" href="http://www.luoo.net/essay/index/p/2">2</a><a class="page" href="http://www.luoo.net/essay/index/p/3">3</a><a class="page" href="http://www.luoo.net/essay/index/p/4">4</a><a class="page" href="http://www.luoo.net/essay/index/p/5">5</a><a class="page" href="http://www.luoo.net/essay/index/p/6">6</a><a class="page" href="http://www.luoo.net/essay/index/p/7">7</a><a class="page" href="http://www.luoo.net/essay/index/p/8">8</a><a class="page" href="http://www.luoo.net/essay/index/p/9">9</a><a class="page" href="http://www.luoo.net/essay/index/p/10">10</a><span class="break">...</span><a class="page" href="http://www.luoo.net/essay/index/p/33">33</a><a class="next" href="http://www.luoo.net/essay/index/p/2">下一页</a>				</div>
			</div>
			<!--/// article end-->

			<!-- aside start-->
			<div class="aside" style="">
				
				<div class="widget">
					<div class="widget-head">						
						<span class="title">推荐文章</span>				
					</div>

					<div class="widget-ct pic-widget">
					
						<div class="item">
							<a href="http://www.luoo.net/essay/442" title="莫西子诗：歌唱血液里流淌的音乐" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201503/54f7f68f60af1.jpg" alt="莫西子诗：歌唱血液里流淌的音乐" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="http://www.luoo.net/essay/442" title="莫西子诗：歌唱血液里流淌的音乐" class="title">莫西子诗：歌唱血液里流淌的音乐</a>
								<p class="description"><span>专访</span><span class="separator">・</span><a href="http://www.luoo.net/author/essays/5038">苏鲤鱼</a></p>
							</div>
						</div>
						
						<div class="item">
							<a href="http://www.luoo.net/essay/443" title="别和那些人一样？" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201503/55000a5d3e28d.jpg" alt="别和那些人一样？" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="http://www.luoo.net/essay/443" title="别和那些人一样？" class="title">别和那些人一样？</a>
								<p class="description"><span>专访</span><span class="separator">・</span><a href="http://www.luoo.net/author/essays/5033">老惠</a></p>
							</div>
						</div>
						
						<div class="item">
							<a href="http://www.luoo.net/essay/446" title="Be a deer：那些南瓜妮告诉过我的事" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201503/5512837857901.jpg" alt="Be a deer：那些南瓜妮告诉过我的事" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="http://www.luoo.net/essay/446" title="Be a deer：那些南瓜妮告诉过我的事" class="title">Be a deer：那些南瓜妮告诉过我的事</a>
								<p class="description"><span>专访</span><span class="separator">・</span><a href="http://www.luoo.net/author/essays/5183">LUO</a></p>
							</div>
						</div>
						
						<div class="item">
							<a href="http://www.luoo.net/essay/453" title="Nova Heart：有矛盾，但也要有光" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201504/5524ed7bc2b55.jpg" alt="Nova Heart：有矛盾，但也要有光" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="http://www.luoo.net/essay/453" title="Nova Heart：有矛盾，但也要有光" class="title">Nova Heart：有矛盾，但也要有光</a>
								<p class="description"><span>专访</span><span class="separator">・</span><a href="http://www.luoo.net/author/essays/259467">陈海海</a></p>
							</div>
						</div>
						
						<div class="item">
							<a href="http://www.luoo.net/essay/455" title="李志：这个世界会好吗？" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201504/552cef59c49a3.jpg" alt="李志：这个世界会好吗？" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="http://www.luoo.net/essay/455" title="李志：这个世界会好吗？" class="title">李志：这个世界会好吗？</a>
								<p class="description"><span>专访</span><span class="separator">・</span><a href="http://www.luoo.net/author/essays/483194">micro</a></p>
							</div>
						</div>
												
					</div>
				</div>

				<div class="widget">
					<div class="widget-ct">
						<a href="http://www.luoo.net/essay/submit" class="ln-widget-block rounded">
							投稿推荐
						</a>
					</div>
				</div>

							</div>
			<!--/// aside end-->

		</div>
	</div>


<%@ include file="../snippets/footer.jsp" %>
</body>
</html>