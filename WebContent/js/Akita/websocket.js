 var dg;
 var wsUrl = "ws://"+domain+"/websocket/chat";
 var websocket;
 var $mb ;
 websocket  = new WebSocket(wsUrl);
$(function(){
 $mb = $("#messageBox");
 var $adminScreen = $(".adminScreen") ;
 var $adminTab = $(".adminTab");
 websocket.onmessage = function(event){
	 var $box = $("[id^=chatbox_],#console:visible");
	 var data = JSON.parse(event.data);
	 var $msgStructs = $("<div class ='item'></div>");
	 if(jQuery.isNotEmpty(data.sessionId)){//刷新后首次建立session
		 websocket.sessionId = data.sessionId;
	 }
	 if(data.type == "admin_login"){
		 switchAdmin();
	 }
	 if(data.type == "admin_login_remind"){
		 $adminTab.attr("id","tab_"+data.userId).find("sub").text("在线");
		 $adminScreen.attr("id","chatbox_"+data.userId);
		 $msgStructs.append("<p class='prompt'>管理员<a href ='"+defaultProfilePath+ data.userID+"' target='_blank' class='"+data.gender+"'>"+data.nickName+"</a>登录了</p>");
	 }
	 if(data.type == "user_login"){
		 if(data.hasAdmin){
			 $adminTab.attr("id","tab_"+data.adminId).find("sub").text("在线");
			 $adminScreen.attr("id","chatbox_"+data.adminId);
			 $msgStructs.append("<p class='prompt'>登陆成功;站长在线</p>");
		 }else{
			 $adminTab.find("sub").text("离线");
			 $msgStructs.append("<p class='prompt'>登陆成功,站长不在线</p>");
		 }
	 }
	 if(data.type == "user_login_remind"){
		 $msgStructs.append("<p class='prompt'><a href ='"+defaultProfilePath+ data.userID+"' target='_blank' class='"+data.gender+"'>"+data.nickName+"</a>登录了</p>");
	 }
	 if(data.type == "proposal_login"){
		 if(data.hasAdmin){
			 $adminTab.attr("id","tab_"+data.userId).find("sub").text("在线");
		 }else{
			 $adminTab.find("sub").text("离线");
		 }
		 $msgStructs.append("<p class='prompt'>请先注册/登录帐号</p>");
	 }
	 if(data.type == "admin_logout_remind"){
		 $adminTab.find("sub").text("离线");
		 $msgStructs.append("<p class='prompt'>管理员<a href ='"+defaultProfilePath+ data.userID+"' target='_blank' class='"+data.gender+"'>"+data.nickName+"</a>离线了</p>");
	 }
	 if(data.type == "admin_logout"){
		 switchClient();
		 $adminTab.find("sub").text("离线");
	 }
	 if(data.type == "user_logout_remind"){  
		 $msgStructs.append("用户<a href ='"+defaultProfilePath+ data.userID+"' target='_blank' class='"+data.gender+"'>"+data.nickName+"</a>");
		 $msgStructs.append("离线了");
		 $("#tab_"+data.userId+" sub").text("离线");
		 $("#chatbox_"+data.userId).append($msgStructs);
		 return;
	 }
	 if(data.type == "text"){
		 $msgStructs.append("<a href ='"+defaultProfilePath+ data.userId+"' target='_blank' class='"+data.gender+"'>"+data.nickName+"</a>&nbsp;&nbsp;&nbsp;"+data.time);
		 $msgStructs.append("<br>");
		 $msgStructs.append($("<p class='text'></p>").html(data.content));
		 if($("#tab_"+data.userId).length>0){//聊天窗口存在
			 $("#tab_"+data.userId).fadeOut().fadeIn();
			 $("#chatbox_"+data.userId).append($msgStructs);
		 }else{//不在则创建聊天窗口
			 $(".adminScreen").clone().attr("id","chatbox_"+data.userId).removeClass("adminScreen hide").show().append($msgStructs).prependTo("#chatGroups");
			 $(".adminTab").clone(true).attr("id","tab_"+data.userId).removeClass("adminTab hide current").show().appendTo("#tabs").trigger("click").find("a").text(data.nickName).addClass("online");
		 }
		 return;
	 }
	 $box.append($msgStructs);
 }
 BindTabEvent();
 
 
 websocket.onopen = function(event){
	 console.log('onopen a message',event); 
 }
 websocket.onerror = function(event){
	 var $msgStructs = $("<div></div>");
	 $msgStructs.append(event);
	 $msgStructs.append("<br>");
	 console.log('onerror',event); 
 }
 websocket.onclose = function(event){
	 var $msgStructs = $("<div></div>");
	 
	  
	 $msgStructs.append("链接关闭");
	 $msgStructs.append("<br>");
	 console.log('onclose',event); 
 }
 $("#contactMe").click(function(a) {
	 dg = dialog({
		 fixed: true,
		 title: '聊天',
		 content:$('.common-dialog-wrapper:hidden').show(),//模块已被包裹,不显示
		 onclose:function(){
		 }
	 });
	 dg.show();
	 
	 
 });
 addCursor();
 $("#console").keyup(function(event) {
	 if(event.keyCode == 13){
		 var command = {type:"console"};
		// webservice.send(JSON.stringify());
		 $(this).children().last("div").prevAll("div").attr("contentEditable",false).off("input focus");
		 addCursor();
	 }
 }
);	 
 function addCursor(){
	 $("#console").on("selectstart keyup",function(event){//keydown 不行,还未获得焦点
		 if(event.type == "selectstart" || (event.type == "keyup" && (event.keyCode == 37 || event.keyCode == 39))){
			 
		 var $cursor = $("<span>&nbsp;</span>").addClass("terminal-cursor");
		 var range = window.getSelection()
		 $("#console").find("span.terminal-cursor").replaceWith($("#console").find("span.terminal-cursor").text());
		 var pos = range.anchorOffset;
		 if($(this).text().length == pos)
			 {
			 $(this).append($cursor);
			 }else{
				 var text = $(this).text();
				 $(this).html(text.substring(0,pos)+$cursor.clone().text(text.substring(pos,pos+1)).prop("outerHTML")+text.substring(pos+1));
			 }
		 console.info(pos);
		 }
		 });
 }
	 dg = dialog({
		 fixed: true,
		 title: '聊天',
		 content:$('.common-dialog-wrapper:hidden').show(),//模块已被包裹,不显示
		 onclose:function(){
		 }
	 });
	 dg.show();
 $("#msgSubmit").click(function(){
	 if($.isNotEmpty($mb.val())){
		 var target = $(".tab.current").attr("id").substring(4);
		 var msg = {"content":$mb.val().replace(/\n/g,'&lt;br&gt;'),type:"text",'target':target};
		 websocket.send(JSON.stringify(msg));
		 var $m = $("<p class='text'></p>").html($mb.val().replace(/\n/g,'&lt;br&gt;'));
		 var $term =$("<div class='item'></div>").prepend("<a href ='javascript:void(0);' class='me'>我</a>").append("&nbsp;&nbsp;&nbsp;"+formatTime(new Date())).append("<br>").append($m);
		 $(".msgScreen:visible").append($term);
		 $mb.val("");
	 }else{
		 var d = dialog({
			    content: '空内容!',
			    align: 'top',
			    quickClose: true// 点击空白处快速关闭
			});
			d.show($mb[0]);
	 }
 });
 $("#msgCancel").click(function(){
	 dg.close();
 });
 
 $("#msgClear").click(function(){
	 $(".msgScreen:visible").text("");
 });
 


 
 
 
 
 
 
 
 
 
 
 
 
	  });
function switchAdmin(){
	$(".adminScreen").hide();
	$(".adminTab").hide();
	$("#chatGroups").hide()
	$("#console").show();
	$("#tab_console").show().trigger("click");
}
function switchClient(){
	$(".adminScreen").show();
	$(".adminTab").show().trigger("click");
	$("#chatGroups").show()
	$("#console").hide();
	$("#tab_console").hide();
}
function switchVisitor(){
	$(".adminScreen").show();
	$(".adminTab").show().trigger("click");
	$("#chatGroups").show()
	$("#console").hide();
	$("#tab_console").hide();
}
	function BindTabEvent(){
	 $("[id^=tab_]").click(function(event){
		 if(!$(this).is(".current")){
			 
		 var targetId = $(this).attr("id").substring(4);
		 $(this).addClass("current").siblings().removeClass("current");
		 if(targetId == "console"){
			 $("#console").show();
			 $("#chatGroups").hide();
		 }else{
			 $("#console").hide();
			 $("#chatGroups").show().find("#chatbox_"+targetId).show().siblings().not("#messageBox,.fb-group,#toolkit").hide();
		 }
		 }
	 }); 
	 $("[id^=tab_]").dblclick(function(event){
		 if(!$(this).is(".adminTab") && !$(this).is("#tab_console")){
			 $(this).remove();
			 var targetId = $(this).attr("id").substring(4);
			 $("#chatbox_"+targetId).remove();
		 }
	 }); 
	 }
