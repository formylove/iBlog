<%@ page import="main.src.entity.essay.Essay,main.src.common.StrUtils,main.src.common.Log"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>那些文字</title>
<s:set name="importParams" value="'general|essay.css|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body style="position:relative;">
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container" style="min-height: 221px;">	
		
				<div class="essay-banner clearfix">
					<img src="img/depot/${cat.cover }" alt="${cat.desc }" class="cover">
					<div class="meta">
						<a href="javascript:void(0);" class="title">${cat.desc }</a>
						<span class="quote-before"></span>&nbsp;<span class="content">${cat.profile }</span>&nbsp;<span class="quote-after"></span>
					</div>
				</div>

		<div class="clearfix">
			<!-- article start-->
			<div class="article article-sm">
				<!-- essay-list -->
				<div class="essay-list">
				<s:iterator value="essays" id="ess" status="st">
							<div class="item">
								<a href="essay/${ess.id}/" target="_blank" class="cover-wrapper">
									<img class="cover rounded" src="img/depot/${ess.cover}" alt="${ess.title }"/>
								</a>
								<div class="essay-wrapper">									
									<a href="essay/${ess.id}/" title="<s:property value="#ess.title"/>" class="title"  target="_blank" style="margin-top:0;">
										<s:property value='#ess.title'/>
									</a>
									<div class="meta">
									<s:if test="#ess.original_flag">
									<span class="category">首发</span>
									</s:if>
									<s:elseif test="#ess.author != null && #ess.author != ''">
									<span class="category">转发自</span>
									<span class="separator">・</span>
									<a class="entry-author" href="<s:property value='#ess.author_link'/>"  target="_blank">
									<s:property value="#ess.author"/></a>
									</s:elseif>
									<span class="separator">・</span><span class="time"><s:property value='#ess.create_date'/></span>
									<s:if test="!#ess.original_flag">
									<span class="separator">・</span><a href="<s:property value='origninal_link'/>"  target="_blank">[原文链接]</a>
									</s:if>
									</div>
									<div class="subscribe">
									<%
									Essay e = (Essay) request.getAttribute("ess");
									String subtitle = e.getSubtitle();
									if(!StrUtils.isEmpty(subtitle))
									{
									subtitle = StrUtils.removeTag(subtitle);
										if(e.getTitle() != null && e.getTitle().length()>19){
											subtitle = StrUtils.truncate(subtitle, 70);
										}else{
											subtitle = StrUtils.truncate(subtitle, 100);
										}%>
									<%=subtitle%><% 
									}else{
										String content = e.getContent();
										content = StrUtils.removeTag(content);
										if(e.getTitle() != null && e.getTitle().length()>19){
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