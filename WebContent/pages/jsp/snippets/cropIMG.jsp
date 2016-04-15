<div id="cutArgs" class="hidden">
<input type="text" id="x" name="x" >
<input type="text" id="y" name="y" >
<input type="text" id="w" name="w" >
<input type="text" id="h" name="h" >
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
var option1 = {
		title: '截取头像',
	    okValue: '确定',
	    ok: function () {
	        recover();
	    },
	    cancelValue: '取消',
	    cancel: function () {
	    	clears();
	    	recover();
	    }};
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
	$.ajaxFileUpload(
	{url:'ajax/image/upLoadImg',
	dataType:'json',
	fileElementId:she,
	type:'post',
	secureuri: false,
	success:function(data,status){
		console.info(data.imgName)
		$('#cutArgs :text').val(0);
		$('#cover').val(data.imgName);
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));//清空file input
		setImg('temp/'+data.imgName);
	},
	error:function(data,status,e){
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));
		alert(e);
	}}
	);
}
function setImg(url){
	
	$('#prevImg').attr('src',url);//预览
	var dg = dialog(option1);
	dg.content('<img src="'+url+'" id="target" name="target" class="text-align:center" style="max-width:700px;max-height:700px"/>');
	$('img[name=target]').first().load(function(){//等待图片加载完毕
		dg.show();
		$('#target').Jcrop({
			  onChange: updatePreview,
			  onSelect: updatePreview,
			  minSize: [0,0],//选框大小
			  maxSize:[0,0],
			  boxWidth:600,
			  aspectRatio: xsize / ysize
			},function(){
			  jcrop_api = this;
			  bounds = jcrop_api.getBounds();
			  boundx = bounds[0];
			  boundy = bounds[1];
			});
	$('#preview-container').addClass('border-frame-light');
	$('#prevImg').removeClass(classType);
	

			});
	
	};
	function recover(){
		$('#prevImg').addClass(classType);
		$('#preview-container').removeClass('border-frame-light');
	}
	function clears(){
		$('#prevImg').attr('src',originalImg);
		$('#cover').val(originalImgUUID);
		$('#imgUrl').val("");
		$('#cutArgs input[type=text]').val(0);
		$("#prevImg").removeAttr("style");
		$("#prevImg").attr("style","");
	}
	function startCrop(){
		reg = /\.jpg$|\.png$|\.gif$|\.jpeg$/i;//空格也算入正则表达式了
		if($('#imgUrl').val()==''){
			confirm4easyui('请先输入图片网址');
			$('#imgUrl').focus();
		}else if(!reg.exec($('#imgUrl').val())){
			confirm4easyui('图片格式错误');
			$('#imgUrl').focus();
			$('#imgUrl').val("");
		}else{
		$('#cutArgs input[type=text]').val(0);
		$('#cover').val($('#imgUrl').val());
		setImg($('#imgUrl').val());
	}
	}
</script>

