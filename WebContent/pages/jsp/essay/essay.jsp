<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="essay.title"/></title>
<%request.setAttribute("importParams", "jquery|essay.css|agent|comment|Akita.js|end"); %>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<div class="container ct-sm" style="min-height: 221px;">	
		<nav class="article-nav">
			<a href="essays/" class="nav-back">
				<i class="icon-back"></i>
				返回专栏首页
			</a>
		</nav>
		<div class="essay-detail-wrapper">	
			<h1 class="essay-title">${essay.title}</h1>
			<p class="essay-meta">
				<span class="cursor-pointer" onclick="window.location.href='essayAction.action?method:editEssay&id=${id}'">修改</span>・
				<s:if test="essay.del_flag==false"><span id="delete" onclick="deleteObj('essay','${id}');" class="cursor-pointer">删除</span><span id="recover" class="hidden cursor-pointer" onclick="recoverObj('essay','${id}');">恢复</span></s:if>
				<s:else><span id="delete" class="hidden cursor-pointer" onclick="deleteObj('essay','${id}');">删除</span><span id="recover" onclick="recoverObj('essay','${id}');" class="cursor-pointer">恢复</span></s:else>
				・<s:if test="essay.original_flag">[原创]</s:if><s:else>[转发自]</s:else>&nbsp;
				作者・<span><a href="${essay.author_link}">${essay.author}</a></span><s:if test="!essay.original_flag">・<span><a href="${essay.original_link}" target="_blank" ><font color="red">[原文链接]</font></a></span></s:if>・${essay.create_date}</p>
		<!-- 音乐 -->
		<s:if test="essay.music != 0">
		<div class="essay-music">
							<div class="vol-tracklist" id="luooPlayerPlaylist">
								<ul>
					
						<li class="track-item rounded" id="track12098">
							<div class="track-wrapper clearfix">							
								<div class="btn-play">
									<span class="btn-control">
										<i class="icon icon-status-play" style="display: none;"></i>
										<i class="icon icon-status-pause" style="display: inline-block;"></i>
									</span>
									<a href="javascript:;" rel="nofollow" class="trackname">01. welcome to utopia</a>
									<div class="artist">惘闻</div>
								</div>
								
								<a href="javascript:;" rel="nofollow" class="icon icon-info" data-sid="12098" style="visibility: visible;"></a>
													
								<a href="javascript:;" rel="nofollow" class="btn-action-share icon icon-share" data-app="single" data-id="12098" data-text="推荐惘闻的歌曲welcome to utopia（分享自@落网）" data-img="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/albums/6764/cover.jpg?imageView2/1/w/580/h/580" style="visibility: visible;">
								</a>

								<a href="javascript:;" rel="nofollow" class="btn-action-like icon icon-fav" data-id="12098" data-type="single" data-cback="single_like_callback" style="visibility: visible;">
								</a>
								<div class="duration" style="display: block;">
									<span class="current-time">00:00</span>
									<span>/</span>
									<span class="total-time">00:00</span>
								</div>
							</div>
		
						</li>
						
							</ul>
							<div>
								<div id="luooPlayerContent" style="width: 0px; height: 0px;"><img id="jp_poster_0" style="width: 0px; height: 0px; display: inline;" src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/albums/6764/cover.jpg?imageView2/1/w/580/h/580"><audio id="jp_audio_0" preload="metadata" src="http://emo.luoo.net/low/2014/0612_01.mp3"></audio></div>
								<div class="jp-playlist" style="display:none;">
									<ul style="display: block;"><li class="jp-playlist-current"><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item jp-playlist-current" tabindex="1">welcome to utopia <span class="jp-artist">by 惘闻</span></a></div></li></ul>
								</div>
							</div>	
						</div>
					</div>
					</s:if>
					<s:else>
<HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="80%" color=#987cb9 SIZE=1>	
	<br>
					</s:else>

				<!-- 文章内容 -->
					<div class="essay-content">
					<s:property value="essay.content" escape="false"/>
				<br>
				<br>
				<br>
					 </div>
			<!-- 点赞区 -->		 
		<div class="essay-share">
				<a href="javascript:;" >
					<span id="like" class="icon-essay-fav"  onclick="like('${id}');" style="margin-right:5px;" ></span>
					<span id="liked" class="icon-essay-faved hidden"  onclick="undoLike('${id}');" style="margin-right:5px;" ></span>
					<span id="favorcnt">${essay.favor_cnt}</span>
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:;" class="btn-share btn-action-share" data-app="essay" data-id="520'" data-text="这篇文章值得一读【惘闻：艺术与声音的即兴合作——奇迹寻踪】（分享自@落网）" data-img="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/essays/201508/55d5b1119b303.jpg" title="分享">
					<span class="icon-essay-share"></span>
				</a>
			</div>			 
			<!-- 作者信息 -->		 
					 
						<s:if test="essay.author != null && essay.author != '' ">
					 <div class="essay-author-wrapper clearfix">
				<div class="essay-author">
					<p class="title">
						文章作者
					</p>
					
						<div class="clearfix">
							<a href="" class="avatar-wrapper">
								<img src="" alt="<s:property value='essay.author'/>" class="avatar rounded"/>
							</a>
							<div class="essay-author-info">
								<div class="cell">
									<a href="dd<s:property value='essay.author_link'/>" class="essay-author-name">
										<s:property value="essay.author"/>
									</a>
									<p class="essay-author-sign"><s:property value='essay.author_desc'/></p>
								</div>
							</div>
						</div>
										</div>
				<div class="copyright">
					<p class="title">
						版权声明
					</p>
					<div class="copyright-ct">
						「夜网」专栏内文章，如果侵权，立即删除
					</div>
				</div>
			</div>
			</s:if>
	</div>	
		
		<div class="comment-wrapper">
		<div class="comment-editor">
				<a href="javascript:;" class="avatar-wrapper" id="commentAvatarHolder" rel="nofollow">
					<img src="http://s.luoo.net/img/avatar.gif" alt="" class="avatar rounded">
				</a>
				<div class="editor-wrapper">
					<form action="commentAction.action?method:addComment" id="commentForm">
						<input type="hidden" id="target_id" value="${essay.id}">
						<div class="editor rounded">
							<textarea name="content" spellcheck="false" id="commentEditor" autocomplete="off"></textarea>
						</div>
						<div class="toolbar rounded clearfix">
							<div class="sns-sync">
								同步到
								<a href="http://www.luoo.net/comment/sync/weibo" rel="nofollow" class="sns-item btn-action-comment-sync">
									<span class="icon-share-weibo"></span>
									<input type="hidden" name="sync[weibo]" value="0" class="input-comment-sync">
								</a>
								<a href="http://www.luoo.net/comment/sync/douban" rel="nofollow" class="sns-item btn-action-comment-sync">
									<span class="icon-share-douban"></span>
									<input type="hidden" name="sync[douban]" value="0" class="input-comment-sync">
								</a>
								<a href="http://www.luoo.net/comment/sync/tweibo" rel="nofollow" class="sns-item btn-action-comment-sync">
									<span class="icon-tweibo"></span>
									<input type="hidden" name="sync[tweibo]" value="0" class="input-comment-sync">
								</a>
							</div>
							<button  disabled="disabled" class="btn btn-positive btn-not-ready rounded" id="commentSubmit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">发布</button>
						</div>
					</form>
				<!-- editor-wrapper end-->
			</div>
		
		</div>
		
		
		
		
		<span id="commentSortText">最新评论</span>
		<span class="icon-sort-menu">▼</span>
		
		
<div class="comment-list" id="commentList">
                <div id="commentItems"><div class="item">
                    

                    <a href="http://www.luoo.net/user/631826" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u631826_1437626193.png?imageView2/1/w/128/h/128" alt="Rubystone" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <div class="helper">
                            <a href="http://www.luoo.net/user/631826" class="username" target="_blank">Rubystone</a>
                            
                            <div class="more">
                                    <span class="icon-more">
                                        ▼
                                        <span class="more-menu">
                                            
                                            <a href="javascript:void(0);" class="comment-more-item btn-report" data-res="260389" data-app="5" data-tipid="commentReportDialog260389" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                                        </span>
                                    </span>
                            </div>
                            
                        </div>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="1" data-ct="1440157312">图片很帅！</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-08-21
                            <a class="ln-comment-from" href="http://www.luoo.net/app/" target="_blank"> 来自落网客户端</a>
                            
                            <a data-res="260389" data-app="5" data-tipid="commentVoteDialog260389" data-width="235" class="btn-vote btn-action-vote" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply" data-res="260389" data-user="Rubystone">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <span class="vote-count" data-count="1">1赞</span>
                            
                        </div>
                        
                            <div class="sub-comment clearfix ">
                                <span class="arrows"></span>

                                <form action="http://www.luoo.net/comment/add" class="editor-wrapper hide form-comment-at">
                                    <div class="editor">
                                        <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                                    </div>

                                    <div class="toolbar clearfix">
                                        <div class="btn-group">
                                            <a href="javascript:void(0);" class="btn-link btn-action-cancel">取消</a>
                                            <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">发布</button>
                                        </div>
                                    </div>

                                    <input type="hidden" name="app_id" value="2">
                                    <input type="hidden" name="res_id" value="520">
                                    <input type="hidden" name="comment_at" value="260389">
                                </form>
                                <div class="clearfix items">

                                <div class="item">
                    
                    <a href="http://www.luoo.net/user/656733" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u656733_1430279362.png?imageView2/1/w/128/h/128" alt="eyelight" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="" data-ct="1440159976">一定要找這部片子來看喔！</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-08-21
                            
                            <a data-res="260399" data-app="5" data-tipid="commentVoteDialog260399" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="260399" data-user="eyelight">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <a href="javascript:void(0);" class="comment-more-item btn-report hide" data-res="260399" data-app="5" data-tipid="commentReportDialog260399" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                            
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="520">
                        <input type="hidden" name="comment_at" value="260399">
                    </form>
                </div></div>
                                
                            </div>
                        
                    </div>
                </div>
                <div class="item">
                    

                    <a href="http://www.luoo.net/user/807254" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u807254_1435631476.jpg?imageView2/1/w/128/h/128" alt="不酷少年" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <div class="helper">
                            <a href="http://www.luoo.net/user/807254" class="username" target="_blank">不酷少年</a>
                            
                            <div class="more">
                                    <span class="icon-more">
                                        ▼
                                        <span class="more-menu">
                                            
                                            <a href="javascript:void(0);" class="comment-more-item btn-report" data-res="260364" data-app="5" data-tipid="commentReportDialog260364" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                                        </span>
                                    </span>
                            </div>
                            
                        </div>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="1" data-ct="1440148321">在乐视官网看了两遍，听了一遍，每次都有不一样的感动，惘闻真的是在不断挑战自己，激发更多的创作火花，为国内后摇团在创作上刷新了新的一页。</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-08-21
                            
                            
                            <a data-res="260364" data-app="5" data-tipid="commentVoteDialog260364" data-width="235" class="btn-vote btn-action-vote" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply" data-res="260364" data-user="不酷少年">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <span class="vote-count" data-count="1">1赞</span>
                            
                        </div>
                        
                            <div class="sub-comment clearfix ">
                                <span class="arrows"></span>

                                <form action="http://www.luoo.net/comment/add" class="editor-wrapper hide form-comment-at">
                                    <div class="editor">
                                        <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                                    </div>

                                    <div class="toolbar clearfix">
                                        <div class="btn-group">
                                            <a href="javascript:void(0);" class="btn-link btn-action-cancel">取消</a>
                                            <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">发布</button>
                                        </div>
                                    </div>

                                    <input type="hidden" name="app_id" value="2">
                                    <input type="hidden" name="res_id" value="520">
                                    <input type="hidden" name="comment_at" value="260364">
                                </form>
                                <div class="clearfix items">

                                <div class="item">
                    
                    <a href="http://www.luoo.net/user/656733" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u656733_1430279362.png?imageView2/1/w/128/h/128" alt="eyelight" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="" data-ct="1440150329">看出来你真的很用心去揣摩音乐背后的东西</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-08-21
                            
                            <a data-res="260372" data-app="5" data-tipid="commentVoteDialog260372" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="260372" data-user="eyelight">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <a href="javascript:void(0);" class="comment-more-item btn-report hide" data-res="260372" data-app="5" data-tipid="commentReportDialog260372" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                            
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="520">
                        <input type="hidden" name="comment_at" value="260372">
                    </form>
                </div></div>
                                
                            </div>
                        
                    </div>
                </div>
                <div class="item">
                    

                    <a href="http://www.luoo.net/user/850004" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u8500041440866521.jpg?imageView2/1/w/128/h/128" alt="南隅有海" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <div class="helper">
                            <a href="http://www.luoo.net/user/850004" class="username" target="_blank">南隅有海</a>
                            
                            <div class="more">
                                    <span class="icon-more">
                                        ▼
                                        <span class="more-menu">
                                            
                                            <a href="javascript:void(0);" class="comment-more-item btn-report" data-res="265572" data-app="5" data-tipid="commentReportDialog265572" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                                        </span>
                                    </span>
                            </div>
                            
                        </div>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="" data-ct="1441940402">四线城市没有现场</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-09-11
                            <a class="ln-comment-from" href="http://www.luoo.net/app/" target="_blank"> 来自落网客户端</a>
                            
                            <a data-res="265572" data-app="5" data-tipid="commentVoteDialog265572" data-width="235" class="btn-vote btn-action-vote" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply" data-res="265572" data-user="南隅有海">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                        
                            <div class="sub-comment clearfix ">
                                <span class="arrows"></span>

                                <form action="http://www.luoo.net/comment/add" class="editor-wrapper hide form-comment-at">
                                    <div class="editor">
                                        <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                                    </div>

                                    <div class="toolbar clearfix">
                                        <div class="btn-group">
                                            <a href="javascript:void(0);" class="btn-link btn-action-cancel">取消</a>
                                            <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">发布</button>
                                        </div>
                                    </div>

                                    <input type="hidden" name="app_id" value="2">
                                    <input type="hidden" name="res_id" value="524">
                                    <input type="hidden" name="comment_at" value="265572">
                                </form>
                                <div class="clearfix items">

                                <div class="item">
                    
                    <a href="http://www.luoo.net/user/656733" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u656733_1430279362.png?imageView2/1/w/128/h/128" alt="eyelight" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="0" data-ct="1441975009">中国现场音乐版图有待扩充</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-09-11
                            
                            <a data-res="265678" data-app="5" data-tipid="commentVoteDialog265678" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow" style="display: none;"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="265678" data-user="eyelight" style="display: none;">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <a href="javascript:void(0);" class="comment-more-item btn-report hide" data-res="265678" data-app="5" data-tipid="commentReportDialog265678" data-width="235" rel="nofollow" style="display: none;"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                            
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="524">
                        <input type="hidden" name="comment_at" value="265678">
                    </form>
                </div><div class="item">
                    
                    <a href="http://www.luoo.net/user/850004" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u8500041440866521.jpg?imageView2/1/w/128/h/128" alt="南隅有海" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/850004" class="username" target="_blank">南隅有海</a> 回复 <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="" data-ct="1442363127">哪百年的事了</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-09-16
                            
                            <a data-res="266862" data-app="5" data-tipid="commentVoteDialog266862" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow" style="display: none;"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="266862" data-user="南隅有海" style="display: none;">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <a href="javascript:void(0);" class="comment-more-item btn-report hide" data-res="266862" data-app="5" data-tipid="commentReportDialog266862" data-width="235" rel="nofollow" style="display: none;"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                            
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="524">
                        <input type="hidden" name="comment_at" value="266862">
                    </form>
                </div><div class="item">
                    
                    <a href="http://www.luoo.net/user/656733" class="avatar-wrapper" target="_blank">
                        <img src="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/avatars/u656733_1430279362.png?imageView2/1/w/128/h/128" alt="eyelight" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="" data-ct="1442363940">那你要麼挪窩，要麼活久一些</p>
                            
                        </div>
                        <div class="helper clearfix">
                            2015-09-16
                            
                            <a data-res="266864" data-app="5" data-tipid="commentVoteDialog266864" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="266864" data-user="eyelight">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            <a href="javascript:void(0);" class="comment-more-item btn-report hide" data-res="266864" data-app="5" data-tipid="commentReportDialog266864" data-width="235" rel="nofollow"><span class="icon-report"></span><span class="report-status"> 举报</span></a>
                            
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="524">
                        <input type="hidden" name="comment_at" value="266864">
                    </form>
                </div><div class="item">
                    
                    <a href="http://www.luoo.net/user/847506" class="avatar-wrapper" target="_blank">
                        <img src="http://www.luoo.net/static/img/avatar.gif" alt="了不起的提利昂" class="avatar rounded">
                    </a>
                    <div class="item-wrapper">
                        <a href="http://www.luoo.net/user/847506" class="username" target="_blank">了不起的提利昂</a> 回复 <a href="http://www.luoo.net/user/656733" class="username" target="_blank">eyelight</a>
                        <div class="comment-ct">
                            
                                <p class="the-comment" data-vote="0" data-ct="1443185959">哈哈</p>
                            
                        </div>
                        <div class="helper clearfix">
                            12小时前
                            
                            <a data-res="269750" data-app="5" data-tipid="commentVoteDialog269750" data-width="235" class="btn-vote btn-action-vote hide" href="javascript:void(0);" rel="nofollow" style="display: none;"><i class="icon-vote"></i> <span>赞</span></a>
                            <a href="javascript:void(0);" class="btn-reply btn-action-reply hide" data-res="269750" data-user="了不起的提利昂" style="display: none;">
                                <span class="icon-reply"></span>
                                回复
                            </a>
                            
                            <a href="javascript:void(0);" class="comment-more-item btn-delcom hide" data-id="269750" rel="nofollow" style="display: none;"><span class="icon icon-trash"></span> 删除</a>
                            <span class="vote-count" style="display:none;" data-count="0">0赞</span>
                            
                        </div>
                    </div>
                    <form action="http://www.luoo.net/comment/add" class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <a href="javascript:void(0);" class="btn-link btn-action-cancel-at">取消</a>
                                <button class="btn btn-positive btn-not-ready rounded btn-at-comment-submit" data-tipid="commentSubmitDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235">评论</button>
                            </div>
                        </div>

                        <input type="hidden" name="app_id" value="2">
                        <input type="hidden" name="res_id" value="524">
                        <input type="hidden" name="comment_at" value="269750">
                    </form>
                </div></div>
                                
                            </div>
                        
                    </div>
                </div>
                </div>
                <div class="paginator" id="paginator"><a class="previous disabled" rel="nofollow" href="javascript:void(0);">上一页</a><a class="page actived" rel="nofollow" href="javascript:void(0);">1</a><a class="next disabled" rel="nofollow" href="javascript:void(0);">下一页</a></div>

                

                
			</div>
		
		
		
		
		
		</div>
		</div>
		
<%@ include file="../snippets/footer.jsp" %>
<script>

</script>
</body>
</html>