$(function ()
{
    $("#backTop").remove();
    $(".play-btn-mask").hover(function ()
    {
        $(this).siblings("span").stop(!0).animate({
            opacity : 1
        }, 150), 
        $(this).stop(!0).animate({
            opacity : .5
        }, 200)
    }
    , function(a) {
        return $(a.relatedTarget).is($("span")) ? !1 : ($(this).siblings("span").animate({
            opacity: 0
        }, 200),
        void $(this).animate({
            opacity: 0
        }, 200))
    });
    $("#slider").flexslider(
    {
        animationLoop :!0, controlNav :!0, directionNav :!1, itemWidth : 960, move : 1, slideshowSpeed : 5e3
    });
    
    var cnt = $("audio").size();
    $("audio").map(function(){
    	this.addEventListener("ended",function(){
    	    	var now = $(this).data("order");
    	    	var next = (now + 1)%cnt;
    	    	$("#music_"+next)[0].play();
	},false);
    });
    
    $(".vol-item-lg,.vol-item").on("click",function(){
    	var $music = $(this).find("audio");
    	if($music[0].paused){
    		$music[0].play();
    		$("audio").not($music).map(function(){
    			this.pause()
    		});
    	}else{
    		$music[0].pause();
    	}
    	
    });
});
