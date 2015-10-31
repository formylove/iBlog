<%@ page import="main.src.entity.essay.Essay,main.src.common.StrUtils,main.src.common.Log""%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>那些文字</title>
<%request.setAttribute("importParams", "jquery|sticky.js|essay.css|Akita.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body style="position:relative;">
<%@ include file="../snippets/navigator.jsp" %>
					<!-- aside-left start-->
<jsp:include page="../snippets/aside_left.jsp" />
			<!--/// aside-right end-->
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
								<a href=<s:if test="#essay.category == 5003">"<s:property value='#essay.original_link'/>" onclick="readEssay(<s:property value='#essay.id'/>);" </s:if><s:else>"essay/<s:property value='#essay.id'/>/"</s:else>  target="_blank" class="cover-wrapper">
									<img class="cover rounded" src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/essays/201506/55892e49abcf3.jpg" alt="<s:property value="#essay.title"/>">
								</a>
								<div class="essay-wrapper">									
									<a href=<s:if test="#essay.category == 5003">"<s:property value='#essay.original_link'/>" onclick="readEssay(<s:property value='#essay.id'/>);" </s:if><s:else>"essay/<s:property value='#essay.id'/>/"</s:else> title="<s:property value="#essay.title"/>" class="title"  target="_blank" style="margin-top:0;">
										<s:property value='#essay.title'/>
									</a>
									<div class="meta">
									<s:if test="#essay.original_flag">
									<span class="category">首发</span>
									</s:if>
									<s:else>
										<span class="category">转发自</span>
									</s:else>
									<span class="separator">・</span><a class="entry-author" href="<s:property value='#essay.author_link'/>"  target="_blank"><s:property value="#essay.author"/></a><span class="separator">・</span><span class="time"><s:property value='#essay.create_date'/></span>
									<s:if test="!#essay.original_flag and #essay.category!=5003">
									<span class="separator">・</span><a href="<s:property value='origninal_link'/>"  target="_blank">[原文链接]</a>
									</s:if>
									</div>
									<div class="subscribe">
									<%
									Essay e = (Essay) request.getAttribute("essay");
									String subtitle = e.getSubtitle();
									if(!StrUtils.isEmpty(subtitle))
									{
									subtitle = StrUtils.removeTag(subtitle);
										if(e.getTitle().length()>19){
											subtitle = StrUtils.truncate(subtitle, 70);
										}else{
											subtitle = StrUtils.truncate(subtitle, 100);
										}%>
									<%=subtitle%><% 
									}else{
										String content = e.getContent();
										content = StrUtils.removeTag(content);
										if(e.getTitle().length()>19){
										content = StrUtils.truncate(content, 70);
										}else{
										content = StrUtils.truncate(content, 100);
										}%>
										<%=content%>
										<%}%>
									</div>
								</div>
							</div>
				</s:iterator>
				</div>
				<!--/// essay-list end-->
			<jsp:include page="../snippets/pagination.jsp" />
			</div>
			<!--/// article end-->

			<!-- aside-right start-->
<jsp:include page="../snippets/aside_right.jsp" />
			<!--/// aside-right end-->

		</div>
	</div>


<%@ include file="../snippets/footer.jsp" %>
</body>
</html>