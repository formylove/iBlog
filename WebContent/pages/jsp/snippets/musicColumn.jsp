<%@page import="main.src.entity.User" %>
<div class="essay-music">
<div class="vol-tracklist" id="luooPlayerPlaylist">
								<ul>
					
						<li class="track-item rounded" id="track12464">
							<div class="track-wrapper clearfix">							
								<div class="btn-play">
									<span class="btn-control">
										<i class="icon icon-status-play" style="display: <%if((User)request.getAttribute("loginedUser") == null || ((User)request.getAttribute("loginedUser")).isAutoplay()){%>none<%}else{%>inline-block<%}%>;"></i>
										<i class="icon icon-status-pause" style="display: <%if((User)request.getAttribute("loginedUser") == null || ((User)request.getAttribute("loginedUser")).isAutoplay()){%>inline-block<%}else{%>none<%}%>;"></i>
									</span>
									<a href="javascript:;" rel="nofollow" class="trackname">${essay.music.name}</a>
									<div class="artist">${essay.music.singer.name}</div>
									<audio id="" src="/music/${essay.music.url}"  loop
									<%if((User)request.getAttribute("loginedUser") ==null || ((User)request.getAttribute("loginedUser")).isAutoplay()){%>autoplay<%} %>></audio>
								</div>
								
								<a href="javascript:;" rel="nofollow" class="icon icon-info" style="visibility: visible;"></a>
													
								<a href="javascript:;" rel="nofollow" class="btn-action-share icon icon-share" style="visibility: visible;">
								</a>

								<a href="javascript:;" rel="nofollow" class="btn-action-like icon icon-fav" data-id="12464" data-type="single" data-cback="single_like_callback" style="visibility: visible;">
								</a>
								<div class="duration" style="display: block;">
									<span class="current-time">00:00</span>
									<span>/</span>
									<span class="total-time"></span>
								</div>
							</div>
							<div class="track-detail-wrapper" id="trackDetailWrapper12464">
								<div class="track-detail-arrow">
									<span class="tria-out">
										▲
									</span>
									<span class="tria-in">
										▲
									</span>
								</div>
								<div class="track-detail rounded clearfix">
									<div class="player-wrapper">
										<img src="img/depot/${essay.music.cover}" alt="i/O" class="cover rounded">
										<p class="name">${essay.music.name}</p>
										<p class="artist">艺人：${essay.music.singer.name}</p>
										<p class="album">专辑：i/O</p>
										<div class="progress rounded">
											<div class="loaded rounded" style="width: 100%;">
												<div class="escaped rounded" style="width: 17.9202%;"></div>
											</div>							
										</div>
										<div class="duration">
											<span class="current-time">00:00</span>
											<span>/</span>
											<span class="total-time"></span>
										</div>
										<div class="player-btns">
											<a href="javascript:;" rel="nofollow" class="player-btn player-ctl icon icon-detail-pause"></a>
											<a href="javascript:;" rel="nofollow" class="rounded player-btn btn-action-like icon icon-fav" data-id="12464" data-type="single" data-cback="single_like_callback" style="visibility: visible;"></a>
											<a href="javascript:;" rel="nofollow" class="player-btn btn-action-share icon icon-share" style="visibility: visible;"></a>
										</div>
									</div>
									<div class="lyric-wrapper">
										<div class="lyric-content">
										</div>
									</div>
								</div>
							</div>						
							<!--track-detail-wrapper end-->
						</li>
						
							</ul>
							<div>
								<div class="jp-playlist" style="display:none;">
									<ul style="display: block;"><li class="jp-playlist-current"><div><a href="javascript:;" class="jp-playlist-item-remove" style="display: none;">×</a><a href="javascript:;" class="jp-playlist-item jp-playlist-current" tabindex="1">${essay.music.name} <span class="jp-artist">by ${essay.music.singer.name}</span></a></div></li></ul>
								</div>
							</div>	
						</div>
						</div>