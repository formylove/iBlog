<%@ taglib prefix="s" uri="/struts-tags"%>   
<div class="aside">
				<div class="widget">
					<div class="widget-head">						
						<span class="title">文章分类</span>				
					</div>

					<div class="widget-ct pic-widget">
					<s:iterator value="categories" id="cag" status="st">
						<div class="item">
							<a href="essays/1/${cag.id}" title="${cag.name}" class="cover-wrapper">
								<img src="img/depot/${cag.tcover}" alt="${cag.name}" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href="essays/1/${cag.id}" title="${cag.name}" class="title">${cag.name}</a>
								<p class="description"><span>${cag.desc}</span></p>
							</div>
						</div>
					</s:iterator>
					</div>
				</div>
</div>