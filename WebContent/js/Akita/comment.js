$(
		function(){
			$("#commentEditor").on("input",function(){detectAreaVal("commentEditor","commentSubmit","btn-not-ready","");});
			$("#commentForm").submit(
				function (){ 
				var Browsers;
				$.getScript(getAgentJS(),function(){
					Browsers = new WhichBrowser(navigator.userAgent);
				    var ajax_url = "commentAction.action?method:addComment"; //表单目标 
				    $.ajax({ 
				     type:"post", //表单提交类型 
				     url:ajax_url, //表单提交目标 
				     contentType:'application/x-www-form-urlencoded;charset=UTF-8',
				     data:{content:$("#commentEditor").val(),device:Browsers.toString(),target_id:$("#target_id").val()}, //表单数据
				     success:function(msg){
				    	 	alert("时间："+msg.date);
				     } 
				    }); 
				
				});

			    return false; //阻止表单的默认提交事件 
			    });
	
			
			});

