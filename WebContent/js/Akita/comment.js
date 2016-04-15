function toggleTextBox($item){
$replyBox = $item.find(".editor-wrapper").first();
$subComment = $item.find(".sub-comment").first();
if($item.data("floor") == '1' && $subComment.find(".items").children().size() == 0){
	$replyBox.toggleClass("hide");
	$subComment.toggleClass("hide");
}else{
	$replyBox.toggleClass("hide");
}
	}
$(function(){
	bindPageEvent();
	$(".btn-reply").click(function(){	
		 toggleTextBox($(this).parents(".item").first());
	}	)

		
			$("#commentEditor,.editor-comment-at").on("input",function(){
				var $editor = $(this);
				var $submit = $(this).parents(".editor-wrapper").find("button[name='commentSubmit']").first();
				detectAreaVal( $editor,$submit,"btn-not-ready","");
				});
	
			$("button[name='commentSubmit']").click(
				function (){ 
				var Browsers;
				var $items = $(this).parents(".item");
				var $item;
				if($items != undefined){
					$item = $items.first();
				}
				var $editor = $(this).parents(".editor-wrapper").find("textarea").first();
				var commentData = {'comment.content':$editor.val()};
				commentData['comment.'+$("#append_id").data("type")+'.id'] = $("#append_id").val();
				if("dataset" in this && "target" in this.dataset ){//typeof this.dataset.target == "undefined"智能判断是否声明
					commentData['comment.target.id'] = this.dataset.target;
				}
				 commentData['comment.dev_name'] = $.cookie('device');
				    $.ajax({ 
				     type:"post", //表单提交类型 
				     url:"/ajax/comment/add", //表单提交目标 
				     contentType:'application/x-www-form-urlencoded;charset=UTF-8',
				     data:commentData, //表单数据
				     success:function(msg){
				    	 if(msg.indexOf("confirm") >0){
				    		 eval(msg);
				    	 }else if($(msg).data("floor") == '1'){
				    		 $('#commentItems').prepend($(msg));
				    		 $editor.val("");
				    		 confirm("发布成功");
				    	 }else{
				    		 $editor.val("");
				    		 $('.item[data-unit="'+$(msg).data('unit')+'"]').find(".items").append($(msg));
				    		 confirm("发布成功");
				    	 }
				    	 if($items != undefined){
				    		 toggleTextBox($item);
				    	 }
				     } 
			    });
	
			
			});
function toggleReplyBox(){
	$replyBox = $(this).parents(".item").first().find(".editor-wrapper").first();
	$replyBox.toggle();
}
;
function bindPageEvent(){
	$(".page,.next,.previous").not(".disabled").not(".actived").click(function(){
		var page;
		var curPage = parseInt($(".paginator .actived").text());
		if($(this).is(".previous")){
			page = curPage-1;
		}else if($(this).is(".next")){
			page = curPage+1;
		}else{
			page = parseInt($(this).text());
		}
		var data = {};//必须初始化
		data.page = page;
		data['comment.'+$("#append_id").data("type")+'.id'] = $("#append_id").val();
		$.ajax({
			url:"/ajax/comment/load",
			type:"post",
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			data:data,
			success:function(msg){
				if(msg){
					sortPagination(page,msg.pages);
					buildComments(msg.comments);
				}else{
					confirm("加载评论失败");
				}
			}
		});
	});	
	
}
function sortPagination(page,pages){
	var $pagination = $("#paginator");
	$pagination.html("");
	var $prev = $("<a></a>").addClass("previous").attr("href","javascript:void(0);").attr("rel","nofollow").text("上一页");
	var $next = $("<a></a>").addClass("next").attr("href","javascript:void(0);").attr("rel","nofollow").text("下一页");
	var $item = $("<a></a>").addClass("page").attr("href","javascript:void(0);").attr("rel","nofollow");
	var $ellipsis = $("<span></span>").addClass("break").text("...");
	var $tail = null;
	var $temp;
	if(page == 1){
		$pagination.prepend($prev.addClass("disabled"));
	}else{
		$pagination.prepend($prev);
	}
	$tail = $prev;
	if(page<5){
		for(var i=1;i<page;i++){
			$temp = $item.clone().text(i);
			$tail.after($temp);
			$tail = $temp;
		}
	}else{
		$temp = $item.clone().text(1);
		$tail.after($temp);
		$tail = $temp;
		$temp = $ellipsis.clone();
		$tail.after($temp);
		$tail = $temp;
		$temp = $item.clone().text(page-2);
		$tail.after($temp);
		$tail = $temp;
		$temp = $item.clone().text(page-1);
		$tail.after($temp);
		$tail = $temp;
	}
	$temp = $item.clone().addClass("actived").text(page);
	$tail.after($temp);
	$tail = $temp;
	if(pages - page<4){
		for(var i=page+1;i<pages+1;i++){
			$temp = $item.clone().text(i);
			$tail.after($temp);
			$tail = $temp;
		}
	}else{
		$temp = $item.clone().text(page + 1);
		$tail.after($temp);
		$tail = $temp;
		$temp = $item.clone().text(page+2);
		$tail.after($temp);
		$tail = $temp;
		$temp = $ellipsis.clone();
		$tail.after($temp);
		$tail = $temp;
		$temp = $item.clone().text(pages);
		$tail.after($temp);
		$tail = $temp;
	}
	if(page == pages){
		$pagination.append($next.addClass("disabled"));
	}else{
		$pagination.append($next);
	}
	
	bindPageEvent();
	
	
}
function buildComments(comments){
	var curBase = null;
	var curUpper = null;
	$("#commentItems").html("");
	for(var index in comments){
		var c = comments[index];
		if(c.floor == 1){
			curBase = $("#base").clone(true).removeClass("hide").removeAttr("id");
			curBase.attr("data-unit",c.unit).find(".avatar-wrapper").attr("href",defaultProfilePath+c.publisher)
			.find(".avatar").attr("src",defaultImgPath+c.portrait);
			curBase.find(".username").attr("href",defaultProfilePath+c.publisher).html(c.name).after((c.motto!=null?"，"+c.motto:""));
			curBase.find(".the-comment").text(c.content);
			curBase.find(".helper.clearfix").prepend(c.time).find(".ln-comment-from").text("来自  "+c.device)
			curBase.find("bRutton[name='commentSubmit']").attr("data-target",c.id);
			$("#commentItems").append(curBase);
		}else{
			if(c.floor == 2){
				curBase.find(".sub-comment").removeClass("hide");
			}
			curUpper = $("#upper").clone(true).removeClass("hide").removeAttr("id");
			curUpper.attr("data-unit",c.unit).attr("data-floor",c.floor).find(".avatar-wrapper")
			.attr("href",defaultProfilePath+c.publisher).find(".avatar").attr("src",defaultImgPath+c.portrait);
			var $me = curUpper.find(".item-wrapper:first-child").attr("href",defaultProfilePath+c.publisher).text(c.name);
			if(c.floor > 2){
				var $span = $("<span></span>").addClass("reply")
				.text("回复");
				var $a = $("<a></a>").addClass("username").attr("target","_blank").attr("href",defaultProfilePath+c.target_id)
				.text(c.target_name);
				$me.after($a);
				$me.after($span);
			}
			curUpper.find(".the-comment").text(c.content);
			curUpper.find(".helper.clearfix").prepend(c.time);
			curUpper.find("button[name='commentSubmit']").attr("data-target",c.id);
			curBase.find(".items").append(curUpper);
		}
	}
}
 })
