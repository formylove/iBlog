<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
#cutArgs input[type=text]{
color:#FF0000;
}
</style>
<div id="pop" class="pop hidden clearfix ">
<img alt="loading" id="loading" src="img/icon/img-loader.gif">
<div class="fleft margin-r-16">
  <img src="" id="target" name="target" class=""/>
</div>
<div  class="fleft">
<ul id="cutArgs" class="margin-t-50" style="position:fixed;color:#FF0000;">
<li class="margin-b-8"><label>X1</label>&nbsp;&nbsp;<input type="text" id="x" name="x" ></li>
<li class="margin-b-8"><label>Y1</label>&nbsp;&nbsp;<input type="text" id="y" name="y" ></li>
<li class="margin-b-8"><label>W</label>&nbsp;&nbsp;&nbsp;<input type="text" id="w" name="w" ></li>
<li class="margin-b-20"><label>H</label>&nbsp;&nbsp;&nbsp;<input type="text" id="h" name="h" ></li>
<li>
<input type="button" onclick="recover();" class="btn rounded btn-positive margin-l-30 margin-r-55" id="confirm" value="确定" >
<input type="button" onclick="$('#prevImg').attr('src',originalImg);clears();recover();" class="btn rounded btn-negative btn-reload" id="throw" value="丢弃" >
</li>
</ul>
</div>
  </div>
<script type="text/javascript">
var classType = getClass('prevImg',/cover-\w+/);
var jcrop_api,
boundx,
boundy,
$pcnt = $('#preview-pane #preview-container'),
$pimg = $('#preview-pane #preview-container img'),
xsize = $pcnt.width(),
ysize = $pcnt.height()
originalImg = $('#prevImg').attr('src');
originalImgUUID = $('#cover').attr('value');
clears();
var bounds;
$('#target').Jcrop({
	  onChange: updatePreview,
	  onSelect: updatePreview,
	  minSize: [0,0],//选框大小
	  maxSize:[0,0],
	  boxWidth:600,
	  aspectRatio: xsize / ysize
	},function(){
	  jcrop_api = this;
	});
function updatePreview(c)
{  
  if (parseInt(c.w) > 0)
  {	$('#x').val(c.x);
	$('#y').val(c.y);
	$('#w').val(c.w);
	$('#h').val(c.h);
    var rx = xsize / c.w;
    var ry = ysize / c.h;

    $pimg.css({
      width: Math.round(rx * boundx) + 'px',
      height: Math.round(ry * boundy) + 'px',
      marginLeft: '-' + Math.round(rx * c.x) + 'px',
      marginTop: '-' + Math.round(ry * c.y) + 'px'
    });
  }
}
function ajaxUpload(she){
	$('#loading').ajaxStart(function(){it.show()});
	$.ajaxFileUpload(
	{url:'imageAction.action?method:upLoadImg',
	dataType:'json',
	fileElementId:she,
	type:'post',
	secureuri: false,
	success:function(data,status){
		console.info(data.imgName)
		$('#cutArgs input[type=text]').val(0);
		$('#cover').val(data.imgName);
		$('#loading').hide();
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));
		setImg('temp/'+data.imgName);
	},
	error:function(data,status,e){
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));
		alert(e);
	}}
	);
}
function setImg(url){
	$('#prevImg').attr('src',url);
	$('#target').attr('src',url);
	jcrop_api.setImage(url);
	$('img[name=target]').eq(1).load(function(){//等待图片加载完毕
	$('#preview-container').addClass('border-frame-light');
	
	$('#prevImg').removeClass(classType);
		 bounds = jcrop_api.getBounds();
		 boundx = bounds[0];
		 boundy = bounds[1];
	setCenterPopPosition($('#pop'),$('img[name=target]').eq(1));
	$('#cutArgs').css("top",getTCenterPopPosition($('#cutArgs').height())-120);
	$('#pop').removeClass('hidden');
	$('.overlay').removeClass('hidden');
			});
	};
	function recover(){
		$('#prevImg').addClass(classType);
		$('#preview-container').removeClass('border-frame-light');
		hideJQ('#pop');
		hideJQ('.overlay');
	}
	function clears(){
		$('#cover').val(originalImgUUID);
		$('#imgUrl').val("");
		$('#cutArgs input[type=text]').val(0);
		$("#prevImg").removeAttr("style");
		$("#prevImg").attr("style","");
	}
	function startCrop(){
		reg = /\.jpg$|\.png$|\.gif$|\.jpeg$/i;//空格也算入正则表达式了
		if($('#imgUrl').val()==''){
			alert('请先输入图片网址');
			$('#imgUrl').focus();
		}else if(!reg.exec($('#imgUrl').val())){
			alert('图片格式错误');
			$('#imgUrl').focus();
			$('#imgUrl').val("");
		}else{
		$('#cutArgs input[type=text]').val(0);
		$('#cover').val($('#imgUrl').val());
		setImg($('#imgUrl').val());
	}
	}
</script>

