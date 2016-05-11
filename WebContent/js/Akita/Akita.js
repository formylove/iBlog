var defaultAvatar ="img/common/avatar.gif";
var defaultImgPath ="img/depot/";
var defaultProfilePath ="user/profile/";
var domain ="hachi.space";
function extend(des, src, override){
   if(src instanceof Array){
       for(var i = 0, len = src.length; i < len; i++)
            extend(des, src[i], override);
   }
   for( var i in src){
       if(override || !(i in des)){
           des[i] = src[i];
       }
   } 
   return des;
}
$.extend({
	isNotEmpty:function(str){
		if(str!=null && str!=undefined && $.trim(str)!=''){
			return true;
		}else{
			return false;
		}
	}
	
	
})
function arrive_timer_format(s) {
	s = s.toFixed(0);
	var t = "";
	if(s > -1){
	    min = Math.floor(s/60) % 60;
	    sec = s % 60;
	    if(min < 10){t += "0";}
	        t += min + ":";
	    if(sec < 10){t += "0";}
	        t += sec;
	}
	return t;
	}
function formatTime(date) {
	var day = (date.getDate()>9)?date.getDate():"0"+date.getDate();
	var month = (date.getMonth()>9)?date.getMonth():"0"+date.getMonth();
	var minutes = (date.getMinutes()>9)?date.getMinutes():"0"+date.getMinutes();
	var hours = (date.getHours()>9)?date.getHours():"0"+date.getHours();
	var year = 1900 + date.getYear();
	return month+"-"+day+" "+hours+":"+minutes
}
function clearForm(){
			$('form').form('clear');
		}

var submitForm = function(item,formName) {
	var reiterationFlag = false;
	var prefix;
	var label;
	var unchecked = $('#' + formName + ' #' + item);
	var controllers = $("input[name^='controller']");
	controllers.map(function(k,c){
		prefix = $(c).attr("name").split("_")[1];
		label = $(c).attr("name").split("_")[2];
		var cnt = $(c).val();
		for(var i = 0;i<cnt-1;i++){
			for(var j = i+1;j<cnt;j++){
				if($("#"+prefix+i).combobox("getValue") == $("#"+prefix+j).combobox("getValue")){
					reiterationFlag = true;
				}
			}
		}
	}
	);
 	$(".combo input:hidden").map(function(index,combo){
		if($(combo).val() == null || $(combo).val() == ''){
			$(combo).remove();
		}
	});
	if(reiterationFlag == true){
			confirm4easyui("'" + label + "' 选项重复！");
	}else if(unchecked.val() == null || unchecked.val() == ''){
			confirm4easyui('标题为空！');
	}else if(item == 'title' && editor.document.getBody().getText().replace(/\s/g, '') == ''){
			confirm4easyui('内容为空！');
	}else{
		var form = document.getElementById(formName);
		var areas = $(form).find("input:hidden");
		if(areas && areas.size()>0){
			for(var a in areas){
				if($.isNotEmpty(areas.eq(a).val())){
					areas.eq(a).val(areas.eq(a).val().replace(/\n/g,'&lt;br&gt;'))
				}
			}
		}
		if(formName.indexOf("essay")==-1 && formName.indexOf("note")==-1){
			$(form).ajaxSubmit(
					{type:"post",
						dataType:'json',
						success: function(data) {
							if($.isNumeric(data)){
								$.messager.alert("提交结果","更新成功 id:" +data,'info');
							}else{
								$.messager.alert("提交结果","更新失败",'error');
							}
						}		
					}		
			);
		}else{
			form.submit();
		}
		
	}
}
function confirm4easyui(message){
				$.messager.show({
					title:'信息',
					msg:message,
					timeout:1000,
					showType:'show'
				});
			}
var disableSelect = function(name,cnt){
	var selects =$("select[id^='"+name+"']");
	selects.map(function(k,s){//map 取出的是document元素，非jquery(document：select#genre0;jquery:z = [select#genre0)
		for(var i=1;i<selects.size();i++){
			$(s).combobox('disable');
		}
	});
	for(var i=0;i<cnt;i++){
		$("#"+name+i+"").combobox('enable');
	}
}
var disableComboTree = function(name,cnt){
	var selects =$("input[id^='"+name+"']");
	selects.map(function(k,s){//map 取出的是document元素，非jquery(document：select#genre0;jquery:z = [select#genre0)
		for(var i=1;i<selects.size();i++){
			$(s).combotree('disable');
		}
	});
	for(var i=0;i<cnt;i++){
		$("#"+name+i+"").combotree('enable');
	}
}
var clipboard = function(id){
  	clip = new ZeroClipboard.Client();
		ZeroClipboard.setMoviePath("js/zeroclipboard/ZeroClipboard.swf");
  	clip.setHandCursor(true);  	
  	clip.addEventListener('mouseOver', function (client){    
    	clip.setText( $("#stacktrace").text());
  	});
  	clip.addEventListener('complete', function (client, text) {   
    	confirm("复制成功");
  	});
	clip.glue(id); // 和上一句位置不可调换 
	}
function detectAreaVal(me,she,emptyClass,availClass){
	if(me.val()==''){//textarea用val取值
		she.addClass(emptyClass);
		she.removeClass(availClass);
		she.attr("disabled","disabled");
	}else{
		she.addClass(availClass);
		she.removeClass(emptyClass);
		she.removeAttr("disabled");
	}
}

		function setCheckbox(me,val){
				$('#'+me).val(val);
			}
			function getClass(me,reg){
					return $('#'+me).attr("class").match(reg)[0];
				}
			function showCoupleForCheckbox(me,she,val){
				if($('#'+me).prop("checked") == Boolean(val)){
					$('#'+she).removeClass("hidden");
				}else{
					$('#'+she).addClass("hidden");
				}
			}
function deleteObj(type,id){
				 $.ajax({
					 url:"/ajax/manager/" + type + "/delete/" + id,
					 contentType:'application/x-www-form-urlencoded;charset=UTF-8',
					 type:'post',
					 success:function(data){
						 $("#delete").addClass("hidden");
						 $("#recover").removeClass("hidden");
						 confirm( '文章删除成功！');
					 }
				 });
			}
			function recoverObj(type,id){
				 $.ajax({
					 url:"/ajax/manager/" + type + "/recover/" + id,
					 contentType:'application/x-www-form-urlencoded;charset=UTF-8',
					 type:'post',
					 success:function(data){
						 $("#recover").addClass("hidden");
						 $("#delete").removeClass("hidden");
						 confirm( '文章恢复成功！');
					 }
				 });
			}

			 function like(type,id){
				 $.ajax({
					 url:"/ajax/manager/" + type + "/like/" + id,
					 contentType:'application/x-www-form-urlencoded;charset=UTF-8',
					 type:'post',
					 success:function(data){
						 $.cookie(type+"like",($.cookie(type+"like") == undefined?"":$.cookie(type+"like"))+"|"+id+"|", { expires: 7, path: '/'});
						 document.getElementById("like").className="icon-essay-fav hidden";
						 document.getElementById("liked").className="icon-essay-faved";
						 document.getElementById("favorcnt").innerText=parseInt(document.getElementById("favorcnt").innerText)+1;
					 }
				 });
			}
			 function undoLike(type,id){
				 $.ajax({
					 url:"/ajax/manager/" + type + "/undoLike/" + id,
					 contentType:'application/x-www-form-urlencoded;charset=UTF-8',
					 type:'post',
					 success:function(data){
						 $.cookie(type+"like",$.cookie(type+"like").replace("|"+id+"|",""), { expires: 7, path: '/'});
						 document.getElementById("like").className="icon-essay-fav";
						 document.getElementById("liked").className="icon-essay-faved hidden";
						 document.getElementById("favorcnt").innerText=parseInt(document.getElementById("favorcnt").innerText)-1;
					 }
				 });
			}
			function confirm(content){
					var d = dialog({
						title: '提示',
					    content: content,
					    icon: 'succeed'
					});
					d.show();
					setTimeout(function () {
					    d.close().remove();
					}, 1000);
				}
function addLabel(me){
	if($("span[name='labelIterm']").size()<3){
		var she = $('#labelIterm').clone();
		she.children().first().val("");
		me.before(she);
	}
		checkTokenDis($("span[name='labelIterm']").size());
}
function redLabel(me){
	if($("span[name='labelIterm']").size()>1){
		$("span[name='labelIterm']").last().remove();
	}
	checkTokenDis($("span[name='labelIterm']").size());
}
function addCast(me){
	if($("span[name='CastIterm']").size()<3){
		var she = $('#CastIterm').clone();
		she.children().first().val("");
		me.before(she);
	}
	checkToken($("span[name='CastIterm']").size());
}
function redCast(me){
	if($("span[name='CastIterm']").size()>1){
		$("span[name='CastIterm']").last().remove();
	}
	checkToken($("span[name='CastIterm']").size());
}
function checkTokenDis(size){
	if(size==3){
		$("#add").addClass("hidden");
		$("#reduce").removeClass("hidden");
	}else if(size==1){
		$("#add").removeClass("hidden");
		$("#reduce").addClass("hidden");
	}else{
		$("#add").removeClass("hidden");
		$("#reduce").removeClass("hidden");
	}
}
function checkToken(size){
	if(size==3){
		$("#add2").addClass("hidden");
		$("#reduce2").removeClass("hidden");
	}else if(size==1){
		$("#add2").removeClass("hidden");
		$("#reduce2").addClass("hidden");
	}else{
		$("#add2").removeClass("hidden");
		$("#reduce2").removeClass("hidden");
	}
}
function suspendToBottom(me,she){
	var left = me.offset().left +  me.width()/2 - she.width()/2;
	var top =  me.offset().top +  me.height();
	she.css({"left":left,"top":top});
}
function getScreenWidth(){
	if(window.innerWidth){
		return window.innerWidth;
	}else {
		return document.body.clientWidth;
	}
}
	function getScreenHeight(){
	if(window.innerHeight){
		return window.innerHeight;
	}else {
		return document.body.clientHeight;
	}
	}
	
	function getLCenterPopPosition(w){
		return  getScreenWidth()/2-w/2;
		
}
	function getTCenterPopPosition(h){
		return getScreenHeight()/2-h/2;
	}
	function setCenterPopPosition(her,it){
		var l = getLCenterPopPosition(it.width());
		var t = getTCenterPopPosition(it.height());
		her.css({'top':t,'left':l});
	}
function initSelector(id,value){
	var selector = document.getElementById(id);
	for(i=0;i<selector.length;i++)
	{
		if(selector[i].value == value)
			selector[i].selected=true;
	}
	
}
function showCouple(i,she,condition){
	var obj = i.options[i.selectedIndex];
	if(obj.value==condition){
		show(she);
		she.disabled=false;
	}else{
		hide(she);
		she.disabled=true;
	}
}
function hideCouple(i,she,condition){
	me = document.getElementById(i);
	var obj = me.options[me.selectedIndex];
	if(obj.value==condition){
		hide(she);
	}else{
		show(she);
	}
}
function enable(she){
	$("#"+she).removeAttr('disabled');
	show(she);
}
function disanable(she){
	$("#"+she).attr('disabled','disabled');
	hide(she);
}
function toggleDisable(she){
	if($("#"+she).attr('disabled')){
		enable(she);
	}else{
		disanable(she);
	}
}
function enableCouple(i,she,condition){
	me = document.getElementById(i);
	var obj = me.options[me.selectedIndex];
	if(obj.value==condition){
		show(she);
		$("#"+she+" input[type=text]").removeAttr('disabled');
		$("#"+she+" input[type=number]").removeAttr('disabled');
		$("#"+she+" input[type=hidden]").removeAttr('disabled');
		$("#"+she+" select").removeAttr('disabled');
	}else{
		$("#"+she+" input[type=text]").attr('disabled','disabled');
		$("#"+she+" input[type=number]").attr('disabled','disabled');
		$("#"+she+" input[type=hidden]").attr('disabled','disabled');
		$("#"+she+" select").attr('disabled','disabled');
		hide(she);
	}
}
function paste(id){
	var input = document.getElementById(id);
	input.focus();
	input.select();
	input.value='';
	document.execCommand('Paste');
}
function show(id){
	$('#'+id).removeClass("hidden");
}
function hide(id){
	$('#'+id).addClass("hidden");
}
function showJQ(arg){
	$(arg).removeClass("hidden");
}
function hideJQ(arg){
	$(arg).addClass("hidden");
}
function toggleShow(id){
	$('#'+id).toggleClass("hidden");
}
///↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  validate   ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//$("form").validate(
//{rule:{
//	works_name:{requered:true, minlength: 6},
//	author_directior:{requered:true},
//	title:{requered:true},
//	author:{requered:true},
//},
//errorPlacement:function(error,element){element.after(error);}
//}		
//);
///↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  新增   ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
