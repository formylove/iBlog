

<!DOCTYPE html>
<html>
<head>
	<title>上传头像自定义裁切 示例页面</title>
	<meta charset="utf-8" />
	
	<script type="text/javascript" language="javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
	
	
	<link type="text/css" rel="stylesheet" href="file-uploader/fileuploader.css"/>
	<script type="text/javascript" language="javascript" src="file-uploader/fileuploader.min.js"></script>
	
	
	<link type="text/css" rel="stylesheet" href="jcrop/jquery.Jcrop.min.css" />
	<script type="text/javascript" language="javascript" src="jcrop/jquery.Jcrop.min.js"></script>
	
	
	<script type="text/javascript" language="javascript">
   		var g_oJCrop = null;
		
		$(function(){
			new qq.FileUploader({
				element: document.getElementById('upload_avatar'),
				action: "controller.php?task=ajax_upload_avatar",
				multiple: false,
				disableDefaultDropzone: true,
				allowedExtensions: ["jpg", "jpeg", "png", "gif"],
				uploadButtonText: '选择头像图片',
				onComplete: function(id, fileName, json) {
					if(json.success)
					{
						if(g_oJCrop!=null) g_oJCrop.destroy();
						
						$("#crop_tmp_avatar").val(json.tmp_avatar);
						$("#crop_container").show();
						$("#crop_target, #crop_preview").html('<img src="tmp/'+json.tmp_avatar+'">');

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
					}
					else
					{
						alert(json.description);
					}
				}
			});

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
		
		
		
		function saveCropAvatar()
		{
			if($("#crop_tmp_avatar").val()=="")
			{
				alert("您还没有上传头像");
				return false;
			}
			
			$.ajax({
				type: "POST",
				url: "controller.php?task=ajax_crop",
				data: $("#form_crop_avatar").serialize(),
				dataType: "json",
				success: function(json)
				{
					if(json.success)
					{
						$("#crop_tmp_avatar").val("");
						$("#crop_container").hide();
						
						$("#my_avatar").html('<img src="avatars/'+json.avatar+'">');
					}
					else
					{
						alert(json.description);
					}
				}
			});
		}
	</script>


</head>
<body style="text-align:center;padding:30px;">

	<div style="width:800px; margin:auto;border:1px #bbb solid;border-radius:5px; box-shadow:1px 1px 10px rgba(0, 0, 0, 0.25); padding:20px; text-align:left;">
	
		<div style="border-radius:5px; background-color:#f5f5f5; padding:10px; font-size:32px; margin-bottom:10px;">上传头像自定义裁切</div>
	
		<table style=" width:100%; border:#eee 1px solid;">
		  <tr>
			<td style="text-align:right;width:120px;">当前头像：</td>
		  </tr>
		  <tr id="crop_container" style="display:none;">
			<td style="text-align:right;">裁切头像：</td>
			<td>
				<table style="border:none;">
					<tr>
						<td><div id="crop_target"></div></td>
						<td valign="top">
							<div id="crop_preview" style="width:90px; height:90px; overflow:hidden;">
							</div>
						</td>
					</tr>
				</table>
			</td>
		  </tr>
		  <tr>
			<td style="text-align:right;">上传新头像：</td>
			<td>
				<div id="upload_avatar"></div>
			</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td><input type="button" id="btn_save_crop" value="保存" style="padding:2px 10px;" onClick="javascript:saveCropAvatar();" /></td>
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
		
	</div>

</body>
</html>

