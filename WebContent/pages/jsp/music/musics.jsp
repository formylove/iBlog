    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>声音</title>
<s:set name="importParams" value="'general|sticky.js|vol|end'" scope="request"/>
<jsp:include page="../snippets/static_js_css.jsp"/>
</head>
<body>
<%@ include file="../snippets/navigator.jsp" %>
<jsp:include page="../snippets/hidden_box.jsp"/>
<div class="container ct-sm note-detail-wrapper" style="min-height: 221px;">	
<div class="vol-tracklist" id="luooPlayerPlaylist">
        <div class="player-large rounded clearfix" data-index="0">
            <div class="cover-wrapper">
                <img src="img/depot/${musics[0].bcover }" class="cover rounded PLCover">
            </div>

            <div class="player-ct" id="playerCt" style="display: block;">
                <div class="clearfix">
                    <a href="javascript:;" rel="nofollow" class="icon-lyric"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-share icon-share PLShare" data-app="single"></a>
                </div>
                <div class="trackname">
                    <p class="PLTrackname" title="${musics[0].name }">${musics[0].name }</p>
                </div>
                <p class="track-meta ${empty musics[0].singer.name?'hide':''}">Artist: <span class="PLArtist" title="${musics[0].singer.name }">${musics[0].singer.name }</span></p>
                <p class="track-meta ${empty musics[0].motto?'hide':''}">Motto: <span class="PLAlbum" title="${musics[0].motto }">${musics[0].motto }</span></p>
                <div class="btn-wrapper">
                    <a href="javascript:;" rel="nofollow" class="jp-previous" title="上一曲">
                        <span class="icon-prev-lg"></span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="jp-play" title="播放" style="display: inline-block;">
                        <span class="icon-play-lg"></span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="jp-pause" title="暂停" style="display: none;">
                        <span class="icon-pause-lg"></span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="jp-next margin-right-0" title="下一曲">
                        <span class="icon-next-lg"></span>
                    </a>
                </div>
                <div class="clearfix">
                            <progress class="fleft progressbar" value="0" max="100"></progress>
                    <div class="duration" id="PLDuration" style="width: 85px;">
                        <span class="current-time">00:00</span><span>/</span><span class="total-time">00:00</span>
                    </div>


                    <a href="javascript:;" rel="nofollow" class="btn-repeat jp-repeatone-off" title="列表循环">
                        <span class="icon-repeat"></span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="btn-repeat jp-repeatone" title="单曲循环" style="display: none;">
                        <span class="icon-repeat-one"></span>
                    </a>
                </div>
            </div>
            <!-- playerCt end /// -->
            <div class="lyric-wrapper" id="lyricWrapper" style="display: none;">
                <div class="lyric-hd clearfix">
                    <div class="track-info">
                        <p class="trackname PLTrackname" title="${musics[0].name }">${musics[0].name }</p>
                        <p class="artist PLArtist" title="${musics[0].singer.name }">${musics[0].singer.name }</p>
                    </div>
                    <a href="javascript:;" rel="nofollow" class="icon-lyric-active"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-share icon-share PLShare" data-app="single"></a>
                </div>

                <div class="lyric-ct" id="lyricCt">${musics[0].lyric }</div>
            </div>
        </div>
        <!-- player-large end /// -->

        <ul>
<s:iterator value="musics" id="m" status="st">
		<li class="track-item rounded" id="track${m.id}">
		<s:if test="#st.first">
		<audio src="music/${m.url }" id = "music_${st.index}"  preload="auto"
		<%if((User)request.getAttribute("loginedUser") == null || ((User)request.getAttribute("loginedUser")).isAutoplay()){%>autoplay<%} %>
		 data-index = "${st.index}" data-name="${m.name}" data-lyric="${m.lyric}" data-cover="${m.bcover}" data-singer = "${m.singer.name}"></audio>
		</s:if>
		<s:else>
		<audio src="music/${m.url }" id="music_${st.index}" data-lyric="${m.lyric}" data-index = "${st.index}"  data-index = "${st.index}" data-name="${m.name}" data-cover="${m.bcover}" data-singer = "${m.singer.name}"></audio>
		</s:else>
            <div class="track-wrapper clearfix">
								<span class="btn-control btn-play">
									<i class="icon-status-play" style="display: none;"></i>
									<i class="icon-status-pause" style="display: none;"></i>
								</span>
                <a href="javascript:;" rel="nofollow" class="trackname btn-play">${st.index<9?"0":""}${1 + st.index}. ${m.name}</a>
                <span class="artist btn-play">${m.singer.name}</span>

                <a href="javascript:;" rel="nofollow" class="btn-action-share icon-share" ></a>

            </div>
            <div class="track-detail-wrapper" >
                <div class="track-detail-arrow">
                    <img src="/img/icon/trian.png">
                </div>
                <div class="track-detail rounded clearfix">
                    <div class="player-wrapper">
                        <img src="img/depot/${m.bcover}" alt="${m.singer.name}" class="cover rounded">
                        <p class="name">${m.bcover}</p>
                        <p class="artist ${empty m.singer.name?'hide':''}" >Artist: ${m.singer.name}</p>
                        <p class="album ${empty m.style?'hide':''}">Style: ${m.style}</p>
                    </div>
                    <div class="lyric-wrapper">
                        <div class="lyric-content">
                        ${m.lyric}
                        </div>
                    </div>
                </div>
            </div>
            <!--track-detail-wrapper end-->
            </li>
</s:iterator>   
                    </ul>
        <!--/// tracklist end -->

        <!-- player-follow -->
        <div class="player-follow clearfix" id="playerFollow">
            <img src="img/depot/${musics[0].bcover}" class="cover " id="PFCover">
            <div class="fleft">
                <p class="name" id="PFName" title="${musics[0].name}">${musics[0].name}</p>
                <p class="artist" id="PFArtist" title="${musics[0].singer.name}">${musics[0].singer.name}</p>
                <p class="sns" id="PFSns">
                    <a href="javascript:;" rel="nofollow" class="btn-action-share icon-follow-share PFShare" data-app="single"></a>
                </p>
            </div>
            <a href="javascript:;" rel="nofollow" class="jp-previous">
                <span class="icon-follow-prev"></span>
            </a>
            <a href="javascript:;" rel="nofollow" class="jp-play" style="display: none;">
                <span class="icon-follow-play"></span>
            </a>
            <a href="javascript:;" rel="nofollow" class="jp-pause" style="display: block;">
                <span class="icon-follow-pause"></span>
            </a>
            <a href="javascript:;" rel="nofollow" class="jp-next">
                <span class="icon-follow-next"></span>
            </a>
        </div>
        <!-- player-follow end ///-->

    </div>




	</div>
<%@ include file="../snippets/footer.jsp" %>
</body>
</html>