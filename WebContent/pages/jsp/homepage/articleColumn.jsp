<%@ page import="main.src.entity.essay.Essay,main.src.common.StrUtils,main.src.common.Log,java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<div class="section-m clearfix">
			<div class="section-musician">
				<div class="section-head clearfix">
					<h3><span class="section-head-label"></span>文字在记录</h3>
				</div>
				<div class="section-ct">
					<div class="clearfix">
						<img src="img/depot/${essays[0].cover }"  class="cover rounded">
						<div class="title">
							<div class="align-fix">
								<div>
									<a href="essay/${essays[0].id }" class="single-name">${essays[0].id }</a>
									<p class="pubdate">${essays[0].create_date}</p>
								</div>
							</div>
							
						</div>
					</div>
					<div class="remark">
						<span class="quote-before"></span>
						<span>
									<%
									Essay e = null;
									Object es = request.getAttribute("essays");
									if(es != null){
										e = ((List<Essay>)es).get(0);
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
										<%}}%>
						</span> <span class="quote-after"></span> 
					</div>
				</div>
			</div>
			<!-- /// section-musician end -->

			<div class="section-essay">
				<div class="section-head clearfix">
					<div class="fright">
						<a href="essays/" class="tag ln-more" target="_blank">更多<span class="icon-more"></span></a> 
					</div>
				</div>
				<div class="section-ct clearfix">
					<s:iterator value="essays" id="es" status="st">
					<s:if test="#st.index != 0">
						<div class="essay-item">
							<a href="essay/${es.id }" class="cover-wrapper">
								<img src="img/depot/${es.cover }" alt="${es.title }" class="cover rounded">
							</a>
							<div class="meta rounded">
								<p class="title"><a class="ln-title" href="essay/${es.id }" title="${es.title }">${es.title }</a></p>
							</div>
						</div>
					</s:if>
					</s:iterator>
				</div>
			</div>
		</div>