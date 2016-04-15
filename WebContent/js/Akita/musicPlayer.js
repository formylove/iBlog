var id ;
$(function(){
	var btn = $(".btn-play");
	var player = btn.find("audio").first()[0];
	if(player != undefined){
		player.oncanplay = function(){
			$(".total-time").text(arrive_timer_format(this.duration.toFixed(0)));
		}
		btn.click(function(){
			togglePlay($(this))
		});
	}
	
	
	
})
window.onload=function(){
	var btn = $(".btn-play");
	var player = btn.find("audio").first()[0];
	
}
function togglePlay(btn){
	var player = btn.find("audio").first()[0];
	if(player.paused){
		btn.find(".icon-status-play").css("display","none");
		btn.find(".icon-status-pause").css("display","inline-block");
		id = setInterval("$('.current-time').text(arrive_timer_format($('.btn-play').find('audio').first()[0].currentTime.toFixed(0)))",1000);
		player.play();
	}else{
		btn.find(".icon-status-play").css("display","inline-block");
		btn.find(".icon-status-pause").css("display","none");
		clearInterval(id);
		player.pause();
	}
	
}