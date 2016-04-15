<form name="axis" id="axis" method="post" class="hide" action="ajax/login/update">
<input type="text" id="x" name="x" >
<input type="text" id="y" name="y" >
<input type="text" id="w" name="w" >
<input type="text" id="h" name="h" >
<input type="text" id="portrait" name="portrait" >
<input type="hidden" name="id" value="${user.id}"/>
<input type="hidden" value="portrait" name="update_type" >
</form>
<script type="text/javascript">
var option0 = {
		type:"post",
		dataType:'json',
		async:false,
		success: function(data) {
					$(".avatar").attr("src",defaultImgPath+data.portrait);
			}
		};
var option1 = {
		title: '截取头像',
	    okValue: '确定',
	    ok: function () {
	        this.title('提交中…');
	    	 $("#axis").ajaxSubmit(option0);
	    },
	    cancelValue: '取消',
	    cancel: function () {
	    	clears();
	    }};
function updateAxis(c)
{  
  	$('#x').val(c.x);
	$('#y').val(c.y);
	$('#w').val(c.w);
	$('#h').val(c.h);
}


function ajaxUpload(she){
	$.ajaxFileUpload(
	{url:'ajax/image/upLoadImg',
	dataType:'json',
	fileElementId:she,
	type:'post',
	secureuri: false,
	success:function(data,status){
		clears();
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));//清空file input
		$('#portrait').val(data.imgName);
		setImg('temp/'+data.imgName);
	},
	error:function(data,status,e){
		$('#'+she).prop('outerHTML', $('#'+she).prop('outerHTML'));
		confirm(e);
	}}
	);
}

function setImg(url){
	var dg = dialog(option1);
	dg.content('<img src="'+url+'" id="target" name="target" class="text-align:center" style="max-width:500px;max-height:500px"/>');
	$('img[name=target]').first().load(function(){//等待图片加载完毕
	dg.show();
		$('#target').Jcrop({
			  onChange: updateAxis,
			  onSelect: updateAxis,
			  minSize: [0,0],//选框大小
			  maxSize:[0,0],
			  boxWidth:600,
			  aspectRatio: 1
			},function(){
			  jcrop_api = this;
			});
			});
	};
	function clears(){
		$('#axis input[type=text]').val(0);
	}
</script>

