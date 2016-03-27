<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="player-large rounded clearfix">
<audio src="music/${music.url }" autoplay></audio>
            <div class="cover-wrapper">
                <img src="${music.cover }" class="cover rounded PLCover">
            </div>

            <div class="player-ct" id="playerCt" style="display: block;">
                <div class="clearfix">
                    <a href="javascript:;" rel="nofollow" class="icon-lyric"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-share icon-share PLShare" data-app="single"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-like icon-fav PLFav" data-type="single" data-cback="single_like_callback"></a>
                </div>
                <div class="trackname">
                    <p class="PLTrackname" title="The Worst Part">${music.name }</p>
                </div>
                <s:if test =" music.singer != null"><p class="track-meta">Artist: <span class="PLArtist" title="${music.singer.name}">${music.singer.name}</span></p></s:if>
               <s:if test =" music.motto != null"><p class="track-meta">Motto: <span class="PLAlbum" title="${music.motto }">${music.motto }</span></p></s:if>
                <div class="btn-wrapper">
                    <a href="javascript:;" rel="nofollow" class="jp-previous" title="上一曲">
                        <span class="icon-prev-lg"></span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="jp-play" title="播放" style="display: none;">
                        <span class="icon-play-lg"></span>
                    </a>
                    <a href="/download/music/${music.id }" rel="nofollow" class="jp-pause" title="暂停" style="display: inline-block;">
                        <span class="icon-pause-lg">????????????????????</span>
                    </a>
                    <a href="javascript:;" rel="nofollow" class="jp-next margin-right-0" title="下一曲">
                        <span class="icon-next-lg"></span>
                    </a>
                </div>
                <div class="clearfix">
                    <div class="progress rounded">
                        <div class="loaded rounded" style="width: 100%;">
                            <div class="escaped rounded" style="width: 13.0189%;"></div>
                        </div>
                    </div>
                    <div class="duration" id="PLDuration" style="width: 85px;">
                        <span class="current-time">00:27</span><span>/</span><span class="total-time">03:30</span>
                    </div>

                    <a href="javascript:;" rel="nofollow" class="btn-volume" id="PLBtnVolume">
                        <span class="icon-unmute"></span>
                    </a>

                    <div class="volume-bar-wrapper" id="PLVolBar" style="width: 0px;">
                        <div class="volume-bar jp-volume-bar">
                            <div class="volume-bar-value jp-volume-bar-value" style="width: 80%;"></div>
                        </div>
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
                        <p class="trackname PLTrackname" title="The Worst Part">The Worst Part</p>
                        <p class="artist PLArtist" title="Lucy Wainwright Roche">Lucy Wainwright Roche</p>
                    </div>
                    <a href="javascript:;" rel="nofollow" class="icon-lyric-active"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-share icon-share PLShare" data-app="single"></a>
                    <a href="javascript:;" rel="nofollow" class="btn-action-like icon-fav PLFav" data-type="single" data-cback="single_like_callback"></a>
                </div>

                <div class="lyric-ct" id="lyricCt"></div>
            </div>
        </div>