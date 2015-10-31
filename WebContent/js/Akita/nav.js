function showSiblings($me){
$myFather = $me.parent().parent().parent();
$myFather.hide();
$myFather.siblings().show();
}
function setNav(data){
	$(".logged-in-wrapper .ln-account").html("<img src='"+data.portrait+"' alt='"+data.nick_name+"' class='avatar'>&nbsp;" + data.nick_name);
	$(".link-uc").attr("href","user/profile/" + data.id);
}
function clearNav(){
	$(".logged-in-wrapper .ln-account").html("");
	$(".link-uc").attr("href","profile/");
}
//         绑定
$(function(){
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
                $("input[type=email]").mailAutoComplete({  boxClass: "emailist"});
           	   //绑定 validate
               $(".qtip form[name=login_form]").validate(options4);
               	//注册表单验证
               $(".qtip  form[name=register_form]").validate(options5);
                	
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
  	   $('form[name=login_form]').submit(function() {
  		 console.info("register2");
  		    $(this).ajaxSubmit({
  	    			type:"post",
  	    			dataType:'json',
  	    		    success: function(data) {
  	    		      console.info("register1");
  	                  $(".qtip #login_submit").hide();
  	                  $(".qtip span[name=error_placement]").text(data.message);
  	                  $(".qtip span[name=error_placement]").show();
  	    		      if(data.isGood=="true"){
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
  	    		      if(data.isGood=="true"){
  	    		    	  window.open($("base").attr("href") + "user/prompt/"+data.email+"/"+data.nick_name+"/",'_blank')
  	    		    	  $("#loggedOutWrapper .ln-top-login").qtip('hide');
  	                  	$(".qtip span[name=error_placement2]").hide();
  	                  	$(".qtip #register_submit").show();
  	    		      }
  	    		    } });
  		    return false;
  		   });
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


	  });