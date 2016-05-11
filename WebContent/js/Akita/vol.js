var id ;
var curIndex;
$.fn.extend({
	stop:function(){
		if(this.is("audio")){
			this[0].pause();
			this[0].currentTime = 0;;
		}
	}
	
});
function playNext(){
	$("#music_"+curIndex).stop();
	var cnt = $("audio").size();
	var next = (curIndex + 1)%cnt;
	$("#music_"+next)[0].play();
}
function playPrev(){
	$("#music_"+curIndex).stop();
	var cnt = $("audio").size();
	var prev = (curIndex - 1 + cnt)%cnt;
	$("#music_"+prev)[0].play();
}
function htmlencode(str) {
	 str = str.replace(/&/g, '&amp;');
	 str = str.replace(/</g, '&lt;');
	 str = str.replace(/>/g, '&gt;');
	 str = str.replace(/(?:t| |v|r)*n/g, '<br />');
	 str = str.replace(/  /g, '&nbsp; ');
	 str = str.replace(/t/g, '&nbsp; &nbsp; ');
	 str = str.replace(/x22/g, '&quot;');
	 str = str.replace(/x27/g, '&#39;');
	 return str;
	}
function setPlayer(){
	var $curSong = $("#music_"+curIndex);
	var $lPlayer =$(".player-large");
	var $sPlayer =$(".player-follow");
	var name =$curSong.data("name");
	var artist =$curSong.data("singer");
	var cover =$curSong.data("cover");
	var index =$curSong.data("index");
	var lyric =$curSong.data("lyric");
	
	$lPlayer.data("index",index);
	$lPlayer.find(".PLTrackname").attr("title",name).text(name);
	$lPlayer.find(".PLCover").attr("src",defaultImgPath + cover);
	$lPlayer.find(".lyric-ct").html($.isNotEmpty(lyric)?lyric:"<div class='margin-t-20'><p style='margin: 60px auto; text-align: center;'><a href='javascript:;' class='btn btn-positive btn-add-lyric'>未添加歌词</a></p></div>");//
	$sPlayer.find("#PFName").attr("title",name).text(name);
	$sPlayer.find("#PFCover").attr("src",defaultImgPath + cover);
	if($.isNotEmpty(artist)){
		$lPlayer.find(".PLArtist").attr("title",artist).text(artist).show();
		$sPlayer.find("#PFArtist").attr("title",artist).text(artist).show();
	}else{
		$lPlayer.find(".PLArtist").hide();
		$sPlayer.find("#PFArtist").hide();
	}
}
function toggle(){
	var $audio =$("#music_"+curIndex);
	var $myPlay = $audio.siblings(".track-wrapper").find(".icon-status-play");
	var $myPause = $audio.siblings(".track-wrapper").find(".icon-status-pause");
	if($audio[0].paused){
		$myPlay.css("display","inline-block");
		$(".icon-status-play,.icon-status-pause").not($myPlay).hide();
		$(".jp-play").show();
		$(".jp-pause").hide();
	}else{
		$myPause.css("display","inline-block");
		$(".icon-status-play,.icon-status-pause").not($myPause).hide();
		$(".jp-play").hide();
		$(".jp-pause").show();
	}
}
$(function ()
{
    $("audio").map(function(){
    	this.addEventListener("ended",function(){
    	    	 playNext();
	},false);
    });
    $("audio").map(function(){
    	this.addEventListener("pause",function(){
    		if($(this).data("index") == curIndex){
    			toggle();
    		}
    	},false);
    });
    $("audio").map(function(){
    	this.addEventListener("play",function(){
    		var now = $(this).data("index");
    		if(now != curIndex){
    			$(".total-time").text($(this).data("duration"));
    			curIndex = now;
    			setPlayer();
    		}
    		toggle();
    	},false);
    });
    $(".track-item").on("click",function(){
    	var $music = $(this).find("audio");
    	if($music.data("index") == curIndex){
    		if($music[0].paused){
    			$music[0].play();
    		}else{
    			$music[0].pause();
    		}
    	}else{
    		$("#music_"+curIndex).stop();
    		$music[0].play();
    	}
    });
    
    
    $(".jp-play").click(function(){
    	var $audio =$("#music_"+curIndex);
    	$audio[0].play();
    });
    $(".jp-pause").click(function(){
    	var $audio =$("#music_"+curIndex);
    	$audio[0].pause();
    });
    $(".icon-repeat").click(function(){
    	 $("audio").attr("loop",true);
    	 $(".jp-repeatone-off,.jp-repeatone").toggle();
    });
    $(".icon-repeat-one").click(function(){
    	 $("audio").attr("loop",false);
    	 $(".jp-repeatone-off,.jp-repeatone").toggle();
    });
    $(".icon-lyric,.icon-lyric-active").click(function(){
    	$(".lyric-wrapper,.player-ct").toggle();
    });
    $(".jp-next").click(function(){
    	playNext();
    });
    $(".jp-previous").click(function(){
    	playPrev();
    });
    $("audio").on("timeupdate",function(){
    	if(!this.paused){
    		$(".progressbar").val(this.currentTime/this.duration*100);
    		$(".current-time").text(arrive_timer_format(this.currentTime));
    	}
    });
    $("audio").on("canplay",function(){
    		$(this).data("duration",arrive_timer_format(this.duration));
    });
    $("#playerFollow").stick_in_parent({
        offset_top: 0,
        parent: $("body")
    }).on("sticky_kit:stick", function(a) {
        $(a.target).animate({
            opacity: 1
        }, 300)
    }
    ).on("sticky_kit:unstick", function(a) {
        $(a.target).animate({
            opacity: 0
        }, 300)
    });
});
