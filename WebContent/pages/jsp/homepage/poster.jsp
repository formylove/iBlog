<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="slider" class="flexslider section-site-first">
				<ul class="slides">
			<s:iterator value="posters" id="poster">
				<li>
			    	<a href="${empty poster.url?'javascript:void(0);':poster.url }" title="${poster.desc }" target="_blank">
			    	<img src="img/depot/${poster.cover }" alt="${poster.desc }" class="round-poster"></a>
			    </li>
			</s:iterator>
				</ul>
</div>