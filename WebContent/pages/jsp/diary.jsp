
<%@ page language="java"
	import="java.util.*,main.src.entity.*,main.src.service.*;"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="diary.title" />| Aurora个人博客|个人网站</title>
<link rel="shortcut icon" href="/favicon.ico" />
<link rel="pingback" href="http://www.xuecaijie.com/xmlrpc.php" />
<!--[if IE]><style type="text/css">.tagcloud a{background:#4A4A4A;}</style><![endif]-->
<script type="text/javascript"
	src="http://www.xuecaijie.com/wp-content/themes/frontopen2/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		mod_txt = '#';
	});
</script>
<script type="text/javascript"
	src="http://www.xuecaijie.com/wp-content/themes/frontopen2/frontopen.js"></script>

<link href="images/style.css" rel="stylesheet">
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/gotop.js"></script>

	<link rel="alternate" type="application/rss+xml"
		title="Aurora个人博客|个人网站 &raquo; Feed"
		href="http://www.xuecaijie.com/feed" />
	<link rel="alternate" type="application/rss+xml"
		title="Aurora个人博客|个人网站 &raquo; 评论Feed"
		href="http://www.xuecaijie.com/comments/feed" />
	<link rel='stylesheet' id='edd-styles-css'
		href='http://www.xuecaijie.com/wp-content/plugins/easy-digital-downloads/templates/edd.min.css?ver=2.1.7'
		type='text/css' media='all' />
	<script type="text/javascript" src="http://static.duoshuo.com/embed.js"
		charset="UTF-8" async="async"></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-includes/js/jquery/jquery.js?ver=1.10.2'></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.2.1'></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-includes/js/swfobject.js?ver=2.2-20120417'></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-content/plugins/page-flip-image-gallery/js/flippingbook.js?ver=0.5.10'></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-includes/js/comment-reply.min.js?ver=3.6.1'></script>
	<script type='text/javascript'
		src='http://www.xuecaijie.com/wp-content/plugins/easy-digital-downloads/assets/js/edd-ajax.min.js?ver=2.1.7'></script>
	<link rel='prev' title='打印机能搜到但无法共享，提示打印机未连接服务器'
	
		href='http://www.xuecaijie.com/318.html' />
	<meta name="generator" content="Easy Digital Downloads v2.1.7" />

	<!-- All in One SEO Pack 2.2.3.1 by Michael Torbert of Semper Fi Web Design[315,365] -->
	<meta name="description" itemprop="description"
		content="准备工作： 1、配置防火墙，开启80端口、3306端口 vi /etc/sysconfig/iptables -A INPUT -m state --state NEW -m tcp -p tcp --dport 80 -j ACCEPT #允许80端口通过防火墙 -A INPUT -m state" />

	<meta name="keywords" itemprop="keywords"
		content="搭建lamp环境,lamp环境,linux" />

	<link rel="canonical" href="http://www.xuecaijie.com/320.html" />
	<!-- /all in one seo pack -->
	<link rel="stylesheet" type="text/css" media="all"
		href="http://www.xuecaijie.com/wp-content/themes/frontopen2/style.css" />
</head>

<body class="single single-post postid-320 single-format-standard"
	class="home">
	<div class="loading"></div>
	<div class="header marauto">
		<span class="logo"> <a href="http://www.xuecaijie.com/"
			title="Aurora个人博客|个人网站" rel="home"><b class="bclass">Aurora♥个人博客</b></a>
			<i>一个专注于IT技术的优秀个人博客网站</i></span>

		<form role="search" method="get" id="searchform"
			action="http://www.xuecaijie.com/">
			<span class="search"> <input name="s" id="s" type="text"
				class="input" value="输入你要找的关键词" onclick="this.value = '';"
				style="color: #999"
				onkeypress="javascript:if(event.keyCode == 13){query(this.value);}"
				x-webkit-speech="" />
				<button id="searchsubmit" class="btn">搜索</button>
			</span>
		</form>
		<p class="m960tips">
			<a id="tclose">X 我知道了</a>TIPS:左右滑动导航栏可以查看更多栏目<img class="csan"
				src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/csan.gif"
				width="27" height="14" />
			<div id="bakg"></div>
		</p>
		<div class="cls"></div>
	</div>

	<div class="nav marauto">
		<div class="tig">
			<a
				href="http://t.qq.com/xuecaijie7780?pgv_ref=im.perinfo.perinfo.icon"
				target="_blank" rel="nofollow" title="腾讯微博"><span class="sub">腾讯微博</span></a>
			<a target="_blank"
				href="http://shang.qq.com/wpa/qunwpa?idkey=0992e8424635cc63b57ce41a0674c3d1cb59b80fbefe86caa8ecec5d8af1b7ba"><img
				border="0" src="http://pub.idqqimg.com/wpa/images/group.png"
				alt="IT技术交流群" title="IT技术交流群"></a>

		</div>

		<div class="navlist">
			<dl>
				<dt>
					<a href="http://www.xuecaijie.com/wenzhangguidang" title="文章归档"
						target="_self" class="nav_button" style="opacity: 0.7;" rel=""><img
						src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/dsj.gif"
						width="45" height="45"></a>
				</dt>
				<dd>文章归档</dd>
			</dl>
			<dl>
				<dt>
					<a href="http://www.xuecaijie.com/gerenziliao" title="博主档案"
						target="_self" class="nav_button" style="opacity: 0.7;" rel=""><img
						src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/nav_1.gif"
						width="45" height="45"></a>
				</dt>
				<dd>博主档案</dd>
			</dl>
			<dl>
				<dt>
					<a href="http://www.xuecaijie.com/ziyuan" title="资源共享"
						target="_self" class="nav_button" style="opacity: 0.7;"
						rel="nofollow"><img
						src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/tools.gif"
						width="45" height="45"></a>
				</dt>
				<dd>资源共享</dd>
			</dl>
			<dl>
				<dt>
					<a
						href="http://wpa.qq.com/msgrd?v=3&uin=963370407&site=qq&menu=yes"
						title="联系博主" target="_blank" class="nav_button"
						style="opacity: 0.7;" rel="nofollow"><img
						src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/qq1.gif"
						width="45" height="45"></a>
				</dt>
				<dd>联系博主</dd>
			</dl>
			<dl>
				<dt>
					<a href="http://www.xuecaijie.com/liuyanban" title="留言板"
						target="_self" class="nav_button" style="opacity: 0.7;" rel=""><img
						src="http://www.xuecaijie.com/wp-content/themes/frontopen2/images/tutorial.gif"
						width="45" height="45"></a>
				</dt>
				<dd>留言板</dd>
			</dl>

			<div class="cls"></div>
		</div>

	</div>
	<div class="navcon marauto">
		<div class="menu-header">
			<ul id="menu-nav1" class="menu">
				<li id="menu-item-7"
					class="menu-item menu-item-type-custom menu-item-object-custom menu-item-home menu-item-7"><a
					href="http://www.xuecaijie.com">首页</a></li>
				<li id="menu-item-15"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-15"><a
					href="http://www.xuecaijie.com/websheji">web前端</a>
					<ul class="sub-menu">
						<li id="menu-item-10"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-10"><a
							href="http://www.xuecaijie.com/websheji/htmlcssdiv">HTML+CSS</a></li>
						<li id="menu-item-12"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-12"><a
							href="http://www.xuecaijie.com/websheji/javascript">Javascript</a></li>
					</ul></li>
				<li id="menu-item-13"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-13"><a
					href="http://www.xuecaijie.com/phpmysql">PHP+Mysql</a></li>
				<li id="menu-item-9"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-9"><a
					href="http://www.xuecaijie.com/cms">CMS建站</a>
					<ul class="sub-menu">
						<li id="menu-item-8"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-8"><a
							href="http://www.xuecaijie.com/cms/phpcms">PHPCMS</a></li>
						<li id="menu-item-16"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-16"><a
							href="http://www.xuecaijie.com/cms/empirecms">帝国CMS</a></li>
						<li id="menu-item-21"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-21"><a
							href="http://www.xuecaijie.com/cms/dedecms">织梦CMS</a></li>
						<li id="menu-item-115"
							class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-115"><a
							href="http://www.xuecaijie.com/cms/discuz">Discuz</a></li>
					</ul></li>
				<li id="menu-item-14"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-14"><a
					href="http://www.xuecaijie.com/seo">SEO</a></li>
				<li id="menu-item-18"
					class="menu-item menu-item-type-taxonomy menu-item-object-category current-post-ancestor current-menu-parent current-post-parent menu-item-18"><a
					href="http://www.xuecaijie.com/server">服务器运维</a></li>
				<li id="menu-item-11"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-11"><a
					href="http://www.xuecaijie.com/itjishu">IT技术杂谈</a></li>
				<li id="menu-item-17"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-17"><a
					href="http://www.xuecaijie.com/life">心情随笔</a></li>
				<li id="menu-item-65"
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-65"><a
					href="http://www.xuecaijie.com/picture">相册</a></li>
			</ul>
		</div>
		<div class="menu-header-m mIco">
			<ul id="remen_ul" class="menu-header-m">
				<li
					class="menu-item menu-item-type-custom menu-item-object-custom menu-item-home menu-item-7"><a
					href="http://www.xuecaijie.com">首页</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-15"><a
					href="http://www.xuecaijie.com/websheji">web前端</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-13"><a
					href="http://www.xuecaijie.com/phpmysql">PHP+Mysql</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-9"><a
					href="http://www.xuecaijie.com/cms">CMS建站</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-14"><a
					href="http://www.xuecaijie.com/seo">SEO</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category current-post-ancestor current-menu-parent current-post-parent menu-item-18"><a
					href="http://www.xuecaijie.com/server">服务器运维</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-11"><a
					href="http://www.xuecaijie.com/itjishu">IT技术杂谈</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-17"><a
					href="http://www.xuecaijie.com/life">心情随笔</a></li>
				<li
					class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-65"><a
					href="http://www.xuecaijie.com/picture">相册</a></li>
			</ul>
		</div>
	</div>

	<div class="conter marauto">
		<script type="text/javascript">
			$('.loading').animate({
				'width' : '33%'
			}, 50);
		</script>
		<div id="container">
			<div id="content" role="main" style="width: 96%">



				<div class="mbx">
					<a href="http://www.xuecaijie.com" class="gray">首页</a> > <a
						href="http://www.xuecaijie.com/server" title="查看服务器运维中的全部文章"><s:property
							value="category" /></a> >
					<s:property value="diary.title" />
				</div>

				<div id="post-320"
					class="post-320 post type-post status-publish format-standard hentry category-server tag-linux">
					<div class="c-top2" id="post-55">
						<div class="datetime">
							<s:property value="diary.create_date" />
							<br />
							<s:property value="diary.create_time" />
						</div>
						<div class="tit">
							<h1 class="entry-title">
								<s:property value="diary.title" />
							</h1>
							<div class="entry-meta iititle2">
								<span class="i2"><a
									href="http://www.xuecaijie.com/author/admin" title="由Aurora发布"
									rel="author">Aurora</a></span><span class="i1"><a
									href="http://www.xuecaijie.com/server" title="查看服务器运维中的全部文章"
									rel="category tag">服务器运维</a></span><span class="i3"><a
									href="http://www.xuecaijie.com/320.html#comments"
									class="ds-thread-count" data-thread-key="320"
									title="《<s:property value="diary.title"/>》上的评论">6 条评论</a></span>
							</div>
						</div>
						<div class="cls"></div>
					</div>
					<!-- .entry-meta -->

					<div class="entry-content">
						<s:property value="diary.content" escape="false"/>
						<!-- .entry-content -->
						<!-- .entry-utility -->
					</div>
					<!-- #post-## -->
					<div class="c-bot">
						<span class="cb_bq"><a
							href="http://www.xuecaijie.com/tag/linux" rel="tag"><s:property
									value="category" /></a></span>
						<div class="cls"></div>
					</div>
					<br />
					<div id="nav-below" class="navigation">
						<div class="nav-previous">
							<a href="http://www.xuecaijie.com/318.html" rel="prev"><span
								class="meta-nav">&lArr;</span> 打印机能搜到但无法共享，提示打印机未连接服务器</a>
						</div>
						<div class="nav-next"></div>
					</div>


					<a name="comments"></a>

					<div class="ds-thread" data-thread-key="320" data-author-key="1"
						data-title="<s:property value="diary.title"/>"
						data-url="http://www.xuecaijie.com/320.html"></div>

					<script type="text/javascript">
						if (typeof DUOSHUO !== 'undefined')
							DUOSHUO.EmbedThread('.ds-thread');
					</script>
					<div id="ds-ssr">

<br/>
						<ol id="commentlist">
							<s:iterator var="comment" value="comments" status="status">
								<li class="comment even thread-even depth-1" id="li-comment-313">
									<article id="comment-313" class="comment"> 
									<footer class="comment-meta"> <cite class="comment-author vcard"> 
										<span class="fn"><a href='http://www.henghost.com/' rel='external nofollow' class='url'>
												<%
													int user_id = ((Comment) request.getAttribute("comment"))
																.getUser_id();
														String name = UserService.getUserName(user_id);
												%><%=name%></a></span>
										on <a rel="nofollow"	href="http://www.xuecaijie.com/320.html#comment-313">
										<time pubdate 	datetime="<s:property value="comment.create_date"/>T<s:property value="#comment.create_time"/>">
											<s:property value="#comment.create_date" /> at <s:property	value="#comment.create_time" /></time></a> <span class="says">said:</span>
									</cite><!-- .comment-author .vcard --> </footer>

									<div class="comment-content">
										<p>
											<s:property value="#comment.content" />
										</p>
									</div>

									</article>
									<!-- #comment-## -->
								</li>
								<!-- #comment-## -->
							</s:iterator>
						</ol>
						<script type="text/javascript">
						var convey=function(){
							$.ajax({
								url:'../../diaryAction.action?method:saveComment',
								type:'post',
								contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
								data:'message='+$('#message').val()+'&user_id='+$('#user_id').val()+'&article_id='+$('#article_id').val()+'&append='+$('#append').val(),
								success:function(data){
									
									alert(data.comment.content);
									
								}
								
								
							});
							
							
						} ;
						
						
						</script>
						<form method="post">
							<input type="hidden" value="<s:property value="user.id"/>" id="user_id"/>
								<input type="hidden" value="<s:property value="diary.id"/>" id="article_id"/>
								 <input type="hidden" value="0" id="append"/>
								 <div class="ds-textarea-wrapper ds-rounded-top"	>
											<textarea placeholder="说点什么吧…" title="Ctrl+Enter快捷提交"	name="message" id="message"></textarea>
											<pre class="ds-hidden-text"></pre>
										</div>
										<div class="ds-post-toolbar">
											<div class="ds-post-options ds-gradient-bg">
												<span class="ds-sync"></span>
											</div>
											<button type="button" onclick="convey();" class="ds-post-button">发布</button>
											<div class="ds-toolbar-buttons">
												<a title="插入表情" class="ds-toolbar-button ds-add-emote"></a>
											</div>
										</div>
						</form>

					</div>
				</div>
				<!-- #content -->
			</div>
			<!-- #container -->
			<script type="text/javascript">
				$('.loading').animate({
					'width' : '55%'
				}, 50);
			</script>



			<script type="text/javascript">
				$('.loading').animate({
					'width' : '78%'
				}, 50);
			</script>

		</div>
		<!-- #main -->

		<div class="cls"></div>





	</div>
	<!-- #wrapper -->





	<!-- GOTOP -->
	<div id="code"></div>
	<div id="code_img"></div>
	<a id="gotop" href="javascript:void(0)"></a>
	<!-- GOTOP -->
</body>
<script
	src="http://www.xuecaijie.com/wp-content/themes/frontopen2/include/ai.js"></script>
<script
	src="http://www.xuecaijie.com/wp-content/themes/frontopen2/include/slip.js"></script>
<script
	src="http://www.xuecaijie.com/wp-content/themes/frontopen2/include/page.js"></script>
</html>
<script type="text/javascript">
	$('.loading').animate({
		'width' : '100%'
	}, 50);
</script>
