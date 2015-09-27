<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>札记</title>
<%request.setAttribute("importParams", "jquery|note.css|sticky.js|Akita.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp">
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container" style="min-height: 221px;">	
		<div class="clearfix">
			<!-- article start-->
			<div class="article article-sm">
				<!-- event-list-wrapper -->
				<div class="event-list-wrapper">
					<div class="location-nav rounded clearfix">
						<span class="current-area">
							当前地区：热门						</span>
						<div class="area-filter">
							<p class="list-types">
								<a href="javascript:;" class="list-type actived">最新活动</a>
								<a href="http://www.luoo.net/livehouse/" class="list-type">演出场所</a>
							</p>
							<p class="area-types">
								<a href="http://www.luoo.net/event/index/city/100002" data-area="100002" class="area-item">北京</a>
								<a href="http://www.luoo.net/event/index/city/100819" data-area="100819" class="area-item">上海</a>
								<a href="http://www.luoo.net/event/index/city/101991" data-area="101991" class="area-item">广州</a>
								<a href="http://www.luoo.net/event/index/city/102015" data-area="102015" class="area-item">深圳</a>
								<a href="http://www.luoo.net/event/index/city/101733" data-area="101733" class="area-item">武汉</a>
								<a href="http://www.luoo.net/event/index/city/102323" data-area="102323" class="area-item">成都</a>
								<a href="http://www.luoo.net/event/index/city/103296" data-area="103296" class="area-item">台湾</a>
								<a href="http://www.luoo.net/event/index/city/103269" data-area="103269" class="area-item">香港</a>
								<a href="http://www.luoo.net/event/location" class="area-item">更多</a>
							</p>
						</div>
					</div>

					<!-- event-list -->
					<div class="event-list">
						
								<div class="item clearfix">
									<a href="http://www.luoo.net/event/13084" class="cover-wrapper">
										<img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/event/13084/55f0edd5bd747.jpg?imageView2/1/w/180/h/225" alt="2015天津卓扬岛屿音乐节" class="cover rounded">
									</a>
									<ul class="info">
										<li>
											<a href="http://www.luoo.net/event/13084" class="name">2015天津卓扬岛屿音乐节</a>
										</li>
										<li>时间： 2015-09-12 至 2015-09-13</li>
										<li>地点： 天津市静海县团泊湖乐乐岛</li>
										
										<li>费用： 150元 - 980元</li>
									</ul>
								</div>
								
								<div class="item clearfix">
									<a href="http://www.luoo.net/event/12959" class="cover-wrapper">
										<img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/event/12959/006bfae3a90bab38e29382170867e962.jpg?imageView2/1/w/180/h/225" alt="2015长沙橘洲音乐节 " class="cover rounded">
									</a>
									<ul class="info">
										<li>
											<a href="http://www.luoo.net/event/12959" class="name">2015长沙橘洲音乐节 </a>
										</li>
										<li>时间： 2015-09-12 至 2015-09-13</li>
										<li>地点： 橘子洲头2号橘子洲公园以北</li>
										<li>场所： 橘洲沙滩乐园</li>
										<li>费用： 120元 - 150元</li>
									</ul>
								</div>
								
								
					</div>
					<!--/// event-list end-->

				</div>
				<!--/// event-list-wrapper end-->
<div class="paginator">
					<a class="previous disabled" rel="nofollow" href="javascript:;">上一页</a><a class="page actived" rel="nofollow" href="javascript:;">1</a><a class="page" href="http://www.luoo.net/event/index/p/2">2</a><a class="page" href="http://www.luoo.net/event/index/p/3">3</a><a class="page" href="http://www.luoo.net/event/index/p/4">4</a><a class="page" href="http://www.luoo.net/event/index/p/5">5</a><a class="page" href="http://www.luoo.net/event/index/p/6">6</a><a class="page" href="http://www.luoo.net/event/index/p/7">7</a><a class="page" href="http://www.luoo.net/event/index/p/8">8</a><a class="page" href="http://www.luoo.net/event/index/p/9">9</a><a class="page" href="http://www.luoo.net/event/index/p/10">10</a><span class="break">...</span><a class="page" href="http://www.luoo.net/event/index/p/298">298</a><a class="next" href="http://www.luoo.net/event/index/p/2">下一页</a>				
</div>
<%-- <%@ include file="../snippets/pagination.jsp" %> --%>
				</div>
			<!--/// article end-->
			<!-- aside start-->
			<div class="aside">
				
				<div class="widget">
					<div class="widget-head">						
						<span class="title">热门活动</span>					
					</div>

					<div class="widget-ct pic-widget">
						
									<div class="item">
										<a href="http://www.luoo.net/event/12884" class="cover-wrapper">
											<img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/event/12884/697782646a61d39ff18134e51fe7db85.jpg?imageView2/1/w/180/h/225" alt="美国气质创作才子 Chris Garneau2015 中国巡演" class="event-cover rounded">
										</a>
										<div class="info">
											<a href="http://www.luoo.net/event/12884" title="美国气质创作才子 Chris Garneau2015 中国巡演" class="wrap-title">美国气质创作才子 Chris Garneau2015 中国巡演</a>
										</div>
									</div>
														
					</div>
				</div>

				<div class="widget widget-break">
					<div class="widget-ct">
						<a href="http://www.luoo.net/contact/" class="ln-widget-block rounded">
							活动提交
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