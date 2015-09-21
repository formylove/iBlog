<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setAttribute("importParams", "jquery|index.js|common.css|Akita.js|end|Jcrop.js|main.css|upload.js|ajaxfile.js|||||"); %>
<%@ include file="snippets/static_js_css.jsp" %>
<title>梦游仙境</title>

<script type="text/javascript">
function ajaxFileUpload() {
    $.ajaxFileUpload
    (
        {
            url: 'imageAction.action?method:upLoadCropedImg', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'upload', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
						data:{"w":$('#w').val(),"h":$('#h').val()},
            success: function (data, status)  //服务器成功响应处理函数
            {
//                 $("#img1").attr("src", data.imgurl);
//                 if (typeof (data.error) != 'undefined') {
//                     if (data.error != '') {
//                         alert(data.error);
//                     } else {
//                         alert(data.msg);
//                     }
//                 }
alert("success");
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        }
    );
    return false;
}






var g_oJCrop = null;
function showImg(){
	$("#crop_container").show();
	  var   p=document.getElementById("file").value; 
	  document.getElementById("target").src=p;
	  document.getElementById("preview").src=p;
	  
		$('#crop_target img').Jcrop({
			allowSelect: false,
			onChange: updatePreview,
				onSelect: updatePreview,
			aspectRatio: 1,
			minSize:[90, 90]
		},function(){
		  	g_oJCrop = this;
			
			var bounds = g_oJCrop.getBounds();
			var x1,y1,x2,y2;
			if(bounds[0]/bounds[1] > 90/90)
			{
				y1 = 0;
				y2 = bounds[1];

				x1 = (bounds[0] - 90 * bounds[1]/90)/2
				x2 = bounds[0]-x1;
			}
			else
			{
				x1 = 0;
				x2 = bounds[0];
				
				y1 = (bounds[1] - 90 * bounds[0]/90)/2
				y2 = bounds[1]-y1;
			}
			g_oJCrop.setSelect([x1,y1,x2,y2]);
		});
		
		function updatePreview(c)
		{
		    $('#crop_x1').val(c.x);
			$('#crop_y1').val(c.y);
			$('#crop_x2').val(c.x2);
			$('#crop_y2').val(c.y2);
			$('#crop_w').val(c.w);
			$('#crop_h').val(c.h);

			if (parseInt(c.w) > 0)
			{
				var bounds = g_oJCrop.getBounds();

				var rx = 90 / c.w;
				var ry = 90 / c.h;
				
				$('#crop_preview img').css({
					width: Math.round(rx * bounds[0]) + 'px',
					height: Math.round(ry * bounds[1]) + 'px',
					marginLeft: '-' + Math.round(rx * c.x) + 'px',
					marginTop: '-' + Math.round(ry * c.y) + 'px'
				});
			}
		};
	
}
</script>
</head>
<body>
<a class="nav-back" href="http://www.luoo.net/music/">
				<i class="icon-back"></i>
				返回期刊首页
			</a>
<!-- 写 -->
<div id="my_avatar" style="max-width=88px"><img src="avatars/20141221150012_f18abd2c25925e209b2b07ac04558a77.png" /></div>
<form id="commentForm" action="http://www.luoo.net/comment/add">
						<div class="editor rounded">
							<div class="reply-wrapper">
								<a id="replyAtUser" class="reply-at-user" href="javascript:;">@xxx：</a>
								<span id="replyQuotes"></span>
								<a title="取消回复" class="cancle-reply" href="javascript:;">×</a>
							</div>
							
							<textarea autocomplete="off" id="commentEditor" spellcheck="false" name="content"></textarea>

						</div>
						
						<div class="toolbar rounded clearfix">
							<div class="sns-sync">
								<a>配图</a>	
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/weibo">
									<span class="icon-share-weibo"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[weibo]">
								</a>
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/douban">
									<span class="icon-share-douban"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[douban]">
								</a>
								<a class="sns-item btn-action-comment-sync" rel="nofollow" href="http://www.luoo.net/comment/sync/tweibo">
									<span class="icon-tweibo"></span>
									<input type="hidden" class="input-comment-sync" value="0" name="sync[tweibo]">
								</a>
							</div>
							<button data-width="235" data-remote="http://www.luoo.net/login/dialog" data-tipid="commentSubmitDialog" id="commentSubmit" class="btn btn-positive btn-not-ready rounded">发布</button>
						</div>

						<input type="hidden" value="1" name="app_id">
						<input type="hidden" value="688" name="res_id">
						<input type="hidden" value="0" name="comment_at" id="txtCommentAt">
					</form>
		<table style=" width:100%; border:#eee 1px solid;">
		  <tr id="crop_container" style="display:none;">
			<td style="text-align:right;">裁切头像：</td>
			<td>
				<table style="border:none;">
					<tr>
						<td><div id="crop_target"><img id="target" src=""></div></td>
						<td valign="top">
							<div id="crop_preview" style="width:90px; height:90px; overflow:hidden;">
							<img id="preview" src="">
							</div>
						</td>
					</tr>
				</table>
			</td>
		  </tr>
		  <tr>
			<td style="text-align:right;">上传新头像：</td>
			<td>
				<td>
				<div id="upload_avatar"><div class="qq-uploader"><div class="qq-upload-button" style="position: relative; overflow: hidden; direction: ltr;">选择头像图片<input type="file" id="file" name="file" onchange="showImg();" style="position: absolute; right: 0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0;"></div><ul class="qq-upload-list"></ul></div></div>
			</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td><input type="button" id="btn_save_crop" value="保存" style="padding:2px 10px;" onClick="" /></td>
		  </tr>
		</table>
				<form id="form_crop_avatar">
			<input type="hidden" name="tmp_avatar" id="crop_tmp_avatar" value="">
			<input type="hidden" name="x1" id="crop_x1" value="">
			<input type="hidden" name="y1" id="crop_y1" value="">
			<input type="hidden" name="x2" id="crop_x2" value="">
			<input type="hidden" name="y2" id="crop_y2" value="">
			<input type="hidden" name="w" id="crop_w" value="">
			<input type="hidden" name="h" id="crop_h" value="">
		</form>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
<!-- 	留言 -->
						<div class="item">
				<a target="_blank" class="avatar-wrapper" href="http://www.luoo.net/user/533106">
					<img class="avatar rounded" alt="艹你二大爷" src="http://img2.luoo.net/pics/avatars/u533106_1418800745.jpg_128x128.jpg">
				</a>
				<div class="item-wrapper">
					<p class="helper">
						<a target="_blank" class="username" href="http://www.luoo.net/user/533106">艹你二大爷</a>
					</p>
					<div class="comment-ct">
						
						<p data-ct="1418800573" data-vote="" class="the-comment">还不错</p>
					</div>
					<div class="helper clearfix">
						2014-12-17
						<a target="_blank" href="http://www.luoo.net/app/" class="ln-comment-from"><span class="icon-mobile"></span> 来自落网客户端</a>
						<a data-user="艹你二大爷" data-res="177680" class="btn-reply btn-action-reply" href="javascript:;">
							<span class="icon-reply"></span>
							回复
						</a>
						<a rel="nofollow" href="javascript:;" class="btn-vote btn-action-vote" data-width="235" data-tipid="commentVoteDialog177680" data-app="5" data-res="177680">
							<i class="icon-vote"></i> 
							<span>赞</span>
						</a>
<!-- 						分页 -->
						<a rel="nofollow" data-width="235" data-tipid="commentReportDialog177680" data-app="5" data-res="177680" class="btn-report btn-action-report" href="javascript:;">
									<span class="icon-report"></span> 
									<span class="report-status">举报</span>
								</a>
						<span data-count="0" style="display:none;" class="vote-count">0赞</span>
					</div>
				</div>
			</div>
						<div class="paginator ajax-comment-pager">
				<a href="javascript:;" rel="nofollow" class="previous disabled">上一页</a>
				<a href="javascript:;" rel="nofollow" class="page actived">1</a>
				<a href="http://www.luoo.net/comment/get/p/2/app/1/id/688/sort/new" class="page">2</a>
				<a href="http://www.luoo.net/comment/get/p/2/app/1/id/688/sort/new" class="next">下一页</a>
			</div>
</body>
</html>