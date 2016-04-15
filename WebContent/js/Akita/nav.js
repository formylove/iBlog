function showSiblings($me){
$myFather = $me.parent().parent().parent();
$myFather.hide();
$myFather.siblings().show();
}
function setNav(data){
	$(".logged-in-wrapper .ln-account").html("<img src='img/depot/"+data.portrait+"' alt='"+data.nick_name+"' class='avatar'>&nbsp;<span>" + data.nick_name+"</span>");
	$(".link-uc").attr("href",defaultProfilePath+data.id);
	if(data.level == 0){
		$(".link-setting").removeClass("hidden");
	}
	if($("#commentAvatarHolder")){
		$("#commentAvatarHolder").find("img").attr("src",defaultImgPath + data.portrait);
	}
}
function clearNav(){
	$(".logged-in-wrapper .ln-account").html("");
	$(".link-uc").attr("href","profile/");
	$(".link-setting").addClass("hidden");
	if($("#commentAvatarHolder")){
		$("#commentAvatarHolder").find("img").attr("src",defaultAvatar);
	}
	//$(".logged-in-wrapper").removeData("level");//仅能删除缓存内值
	$(".logged-in-wrapper").removeAttr("data-level");//仅能删除缓存内值
}
//         绑定
$(function(){
	if($("input[name='document_details']")){
		var type =$("input[name='document_details']").data("type");
		var id = $("input[name='document_details']").val();
		if($.cookie(type+"like") != undefined  && $.cookie(type+"like").indexOf("|"+id+"|")>=0){
			 document.getElementById("like").className="icon-essay-fav hidden";
			 document.getElementById("liked").className="icon-essay-faved";
		}
		
	}
	var hasBinded = false;
	  jQuery.validator.addMethod("normalName",function(value,element){  
          return /^[a-zA-Z0-9\u4E00-\u9FA5_]*$/.test(value);  
         },$.validator.format("请输入数字或者中英文以及下划线")  
         );  
	  jQuery.validator.addMethod("simpleChar",function(value,element){  
          return /^[a-zA-Z0-9]*$/.test(value);  
         },$.validator.format("密码只可以是字母和数字组合")  
         );  

    	
    	var options4 = {rules:{
            "password":{
                required: true,
                rangelength: [8, 16]
            },
            "email":{
                required: true,
                email:true
            }
		},messages:{
			 "password":{
                 required: "请填写密码",
                 rangelength: "密码长度大于8，小于16"
             },
             "email":{
                 required: "请填写邮箱",
                 email:"邮件格式错误"
             }
			
		},
        errorPlacement: function(error, element) {   
        	$(".qtip #login_submit").hide();
        	$(".qtip span[name=error_placement]").text(error.text());
        	$(".qtip span[name=error_placement]").show();
      	  
      	  },
      	success: function() {   
      		$(".qtip #login_submit").show();
        	$(".qtip span[name=error_placement]").hide();
    	  }
    	};
    	var options5 = {rules:{
            "nick_name":{
                required: true,
                normalName:true,
                maxlength: 14
            },
            "email":{
                required: true,
                email:true
            },
            "password":{
                required: true,
                simpleChar:true,
                maxlength: 16,
                minlength: 8
            },
            "psw_conf":{
                required: true,
                equalTo:".qtip #password"   //定位到了隐藏栏位
            }
		},
		messages:{
            "nick_name":{
                required: "嘿，给自己取个昵称先",
                maxlength: "昵称不要太长啊喂"
            },
            "email":{
                required: "你email忘了填唉",
                email:"注意下邮件格式，错了哎"
            },
            "password":{
                required: "填下密码",
                maxlength: "设这么长密码你累不累",
                minlength:"密码少于8位"
            },
            "psw_conf":{
                required: "密码确认下？",
                equalTo:"两次密码输入不同噢"
            }
		},
            errorPlacement: function(error, element) {   
            	$(".qtip #register_submit").hide();
            	$(".qtip span[name=error_placement2]").text(error.text());
            	$(".qtip span[name=error_placement2]").show();
          	  
          	  },
          	success: function() {   
          		$(".qtip #register_submit").show();
            	$(".qtip span[name=error_placement2]").hide();
        	  }
    	
    	
    	};

    	var options6 = {
    			content:$(".total").html() ,
    			show:{
    			solo:true,
    			effect:{type:'slide'},
    			length:2000
    			},
    			hide:{
    				event:'unfocus',
    				delay: 1260, 
    			},
            position: {
              my: 'top center',
              at: 'bottom center'
            },

            style: {
              classes: 'qtip-luoo'
            },
            events: {  
                render: null,  
                visible:function(){
                	if(!hasBinded){
                	  	   $('form[name=login_form]').submit(function() {
                	    		    $(this).ajaxSubmit({
                	    	    			type:"post",
                	    	    			dataType:'json',
                	    	    		    success: function(data) {
                	    	                  $(".qtip #login_submit").hide();
                	    	                  $(".qtip span[name=error_placement]").text(data.message);
                	    	                  $(".qtip span[name=error_placement]").show();
                	    	    		      if(data.isGood){
                	    	    		      $(".logged-out-wrapper").hide();
                	    	    		      setNav(data);
                	    	    		      $(".logged-in-wrapper").qtip('api').set('content.text',$(".account").html());
                	    	    		      $(".logged-in-wrapper").show();
                	    	    		      $("#loggedOutWrapper .ln-top-login").qtip('hide');
                	    	                  $(".qtip span[name=error_placement]").hide();
                	    	                  $(".qtip #login_submit").show();
                	    	    		      }
                	    	    		    } });
                	    		    return false;
                	    		   });
                	    	   $('form[name=register_form]').submit(function(event) {
                	    		    $(this).ajaxSubmit({
                	    	    			type:"post",
                	    	    			dataType:'json',
                	    	    		    success: function(data) {
                	    	                  	$(".qtip #register_submit").hide();
                	    	                	$(".qtip span[name=error_placement2]").text(data.message);
                	    	                	$(".qtip span[name=error_placement2]").show();
                	    	          	      if(data.isGood){
                	    	    		    	 $("#loggedOutWrapper .ln-top-login").qtip('hide');
                	    	                  	$(".qtip span[name=error_placement2]").hide();
                	    	                  	$(".qtip #register_submit").show();
                	    	                  	$('form[name=register_form] input:not(:submit)').val("");
                	    	                  	confirm("注册成功,登录邮箱激活");
                	    	                  	window.open($("base").attr("href") + "user/prompt/"+data.email+"/"+data.nick_name+"/",'_blank')
                	    	    		      }
                	    	    		    } });
                	    		    return false;
                	    		   });
                		$("input[type=email]").mailAutoComplete({  boxClass: "emailist"});
                		//绑定 validate
                		$(".qtip form[name=login_form]").validate(options4);
                		//注册表单验证
                		$(".qtip  form[name=register_form]").validate(options5);
                		hasBinded = true;
                	}
                	
                	}  
             }

          };
    	var options7 = {
    			    content:$(".account").html() ,
    				show:{
    				solo:true,
    				effect:{type:'slide'},
    				length:2000,
    				distance: 32
    				},
    				
    				hide:'unfocus',
    		   position: {
    		     my: 'top center',
    		     at: 'bottom center',
    		     adjust: { 
    				// 提示信息位置偏移 
    				x: 20, y: -10
    				} 
    		   },
    		   style: {
    		     classes: 'qtip-luoo'
    		   },
    		   events: {  
    		       render: null,  
    		       visible:function(){
    		    	   if("dataset" in $(".logged-in-wrapper")[0] && "level" in $(".logged-in-wrapper")[0].dataset  && $(".logged-in-wrapper").data("level") == 0){
    		    		   $(".link-setting").removeClass("hidden");
    		    	   }
    		    		$(".link-logout").click(function(){
    		    	   		theUrl = 'ajax/logout/';
    		    	   		xmlHttp = new XMLHttpRequest();
    		    	   		xmlHttp.open( "GET", theUrl, false );
    		    	   		xmlHttp.send( null );
    		    	   		$(".logged-in-wrapper").hide();
    		    	   		$(".logged-in-wrapper .ln-account").html("");
    		    	   		$(".logged-out-wrapper").show();
    		    	   		$(".logged-in-wrapper").qtip("hide");
    		    	   		clearNav();
    		    	   	});
    		       }
    		   }
    		 };

 $("#loggedOutWrapper .ln-top-login").qtip(options6);
 //为登录名添加qtip
 $(".logged-in-wrapper").qtip(options7);
//$("button[data-tipid='commentSubmitDialog']").qtip({
//content:$(".total").html() ,
//			show:{
//			solo:true,
//			event: 'click',
//			effect:{type:'slide'},
//			length:2000
//			},
//			hide:'unfocus',
//        position: {
//          my: 'top center',
//          at: 'bottom center'
//        },
//
//        style: {
//          classes: 'qtip-luoo'
//        }
//
//      });
 if($.cookie('device') == null){//设置userAgent,放入cookie
	 $.getScript("js/agent/agent.js",function(){
		 $.getScript(getAgentJS(),function(){
			 Browsers = new WhichBrowser(navigator.userAgent);
			 $.cookie('device', Browsers.toString(), { expires: 30, path: '/'}); 
		 });
	 });
 }
 if ( $(".foot-ct").is($("div"))) {
     var b2t_left = $(".foot-ct").offset().left - 0 + 980;
     $(window).scroll(function() {
         var a = $(document).scrollTop();
         a > 900 ? $("#backTop").css({left: b2t_left,bottom: 10}).fadeIn(300) : 300 > a && $("#backTop").fadeOut(300)
     })
 }
 $("#backTop").css("left", b2t_left), $("#backTop").click(function(a) {
     a.preventDefault(), $("html, body").animate({scrollTop: 0}, 300)
 })
 var qqint;
 $("#QqAccount").hover(function() {
     $(this).find(".qq-group").show()
 }, function(a) {
     qqint = setTimeout(function() {
         $("#QqAccount").find(".qq-group").hide()
     }, 100)
 }), $(".qq-group").mouseenter(function() {
     clearTimeout(qqint), $(this).show()
 });
	  });