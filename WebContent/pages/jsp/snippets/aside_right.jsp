<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	$('.aside')
	.stick_in_parent({offset_top: 15})
	.on("sticky_kit:bottom", function(e) {
		//console.log( $(this) );
		$(this).css({top: 0, bottom: '', position: 'fixed'})
	});
})
</script>
					<div class="aside">
				
				<div class="widget">
					<div class="widget-head">						
						<span class="title">推荐文章</span>				
					</div>

					<div class="widget-ct pic-widget">
					<s:iterator value="recommendations" id="record" status="st">
						<div class="item">
							<a href=<s:if test="#record.category == 5003">"<s:property value='#record.original_link'/>" onclick="readEssay(<s:property value='#record.id'/>);" </s:if><s:else>"essay/<s:property value='#record.id'/>/"</s:else>
							target="_blank" title="<s:property value='#record.title'/>" class="cover-wrapper">
								<img src="http://7xkszy.com2.z0.glb.qiniucdn.com//pics/essays/201507/55a8aba2aaf47.jpg" alt="<s:property value='#record.title'/>" class="essay-cover rounded">
							</a>
							<div class="info">
								<a href=<s:if test="#record.category == 5003">"<s:property value='#record.original_link'/>" onclick="readEssay(<s:property value='#record.id'/>);" </s:if><s:else>"essay/<s:property value='#record.id'/>/"</s:else> 
								target="_blank" title="<s:property value='#record.title'/>" class="title"><s:property value='#record.title'/></a>
								<p class="description"><span>作者</span><span class="separator">&#12539;</span><a href="<s:property value='#record.author_link'/>" target="_blank"><s:property value='#record.author'/></a></p>
							</div>
						</div>
							</s:iterator>					
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