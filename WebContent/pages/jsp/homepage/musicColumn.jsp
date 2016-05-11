<%@ taglib prefix="s" uri="/struts-tags"%>   
<%@page import="main.src.entity.User" %>
<s:if test="!musics.isEmpty">
<div class="section-vol">
			<div class="section-head clearfix">
				<h3><span class="section-head-label"></span>声音</h3>
				<div class="fright">
					<a href="musics/" class="tag ln-more" target="_blank">更多<span class="icon-more"></span></a>
				</div>
			</div>
		
<div class="section-ct clearfix">
				<div class="vol-item-lg">
					<audio id="music_0" data-order="0" src="music/${musics[0].url }" 
					<%if(request.getAttribute("loginedUser") != null && ((User)request.getAttribute("loginedUser")).isAutoplay()){%>autoplay<%} %>
					></audio>
					<a href="javascript:void(0);" class="cover-wrapper cover-wrapper-lg">
						<img src="img/depot/${musics[0].bcover }" alt="${musics[0].name }" class="cover-lg rounded">
						<span class="icon-play-lg" style="opacity: 0;"></span>
						<div class="play-btn-mask" style="opacity: 0;"></div>
					</a>

					<a href="javascript:void(0);" class="title">vol.${musics[0].id}&nbsp; ${musics[0].name}</a>
				</div>
					<s:iterator value="musics" id="m" status="st">
					<s:if test="#st.index != 0">
					<div class="vol-item">
					<audio id="music_<s:property value='st.index'/>" src="music/${m.url}"  data-order="${st.index}"></audio>
						<a href="javascript:void(0);" class="cover-wrapper">
							<img src="img/depot/${m.bcover }" alt="${m.name }" class="cover rounded">
							<span class="icon-play" style="opacity: 0;"></span>
							<div class="play-btn-mask" style="opacity: 0;"></div>
						</a>
						<a class="title" href="javascript:void(0);">vol.${m.id }&nbsp;${m.name }</a>
					</div>
					</s:if>
					</s:iterator>
			</div>
		</div>
</s:if>