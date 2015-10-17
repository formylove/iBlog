<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- back to top -->
<div id="backTop">&nbsp;</div>
<!-- back to top End-->
<div class="overlay hidden"></div>
<!-- login-->
<div class="total hidden">
<div id="login-box" >
<div class="dialog-passport" >
	<div class="dialog-head">
		<span class="title">
			登录
		</span>
		<a href="javascript:;" rel="nofollow" class="ln-reg btn-dialog-register" id="registerDialog" data-tipid="registerDialog" data-remote="http://www.luoo.net/register/dialog" data-width="235" onclick="showSiblings($(this));">
			注册
		</a>
		<span class="fright">没有账号？</span>
	</div>
	<form class="form-ajax" action="ajax/login/" method="post" name ="login_form" callback="login_cback">
		<div class="inline-input">
			<span class="label">邮箱</span>
			<input type="email" class="input-passport" name="email" required="">
		</div>
		<div class="inline-input">
			<span class="label">密码</span>
			<input type="password" name="password" class="input-passport"  required="">
		</div>
		<div class="btn-wrapper">
			<input type="submit" value="登录" id="login_submit" style="width:100%" class="btn btn-positive btn-login-submit rounded" rel="nofollow">
			<span name="error_placement" class="btn btn-positive btn-login-msg rounded" style="display:none;">
				提示
			</span>
		</div>
		<div class="clearfix">
			<label><input type="checkbox" name="remember"> 下次自动登录</label>
		</div>
	</form>
</div>
<div class="dialog-login-oauth">
	<div class="platforms">
		<a href="http://www.luoo.net/login/oauth/site/weibo" class="icon-open-weibo" rel="nofollow"></a>
		<a href="http://www.luoo.net/login/oauth/site/douban" class="icon-open-douban" rel="nofollow">
		</a>
		<a href="http://www.luoo.net/login/oauth/site/qq" class="icon-open-qq" rel="nofollow"></a>
	</div>
</div>

</div>
<!--                         注册                                                  -->
<div id="register-box" class="hidden">
<div class="dialog-passport" id="register">
	<div class="dialog-head">
		<span class="title">
			注册
            <img style="display: none;" width="1" height="1" src="http://www.luoo.net/register/vild_shit">
		</span>
		<a href="javascript:;" class="ln-login btn-dialog-login"  id="loginDialog" data-tipid="loginDialog" data-remote="http://www.luoo.net/login/dialog" data-width="235" onclick="showSiblings($(this));">
			返回登录
		</a>
	</div>
	<form class="form-ajax" name="register_form" action="ajax/register/" method="post" callback="register_cback">
		<div class="inline-input">
			<span class="label">昵称</span>
			<input type="text" name="nick_name" class="input-passport" autocomplete="off" placeholder="14位以内中英文数字" required="">

		</div>
		<div class="inline-input">
			<span class="label">邮箱</span>
			<input type="email" name="email" class="input-passport" autocomplete="off" required="" placeholder="您的常用邮箱">
		</div>
		<div class="inline-input">
			<span class="label">密码</span>
			<input type="password" class="input-passport" id="password" name="password" autocomplete="off" required="" placeholder="8-16个字符">
		</div>
		<div class="inline-input">
			<span class="label">确认</span>
			<input type="password" class="input-passport" name="psw_conf" autocomplete="off" required="" placeholder="8-16个字符">
		</div>

		<div class="inline-input" style="display:none;">
			<span class="label">验证码</span>
			<input type="text" name="auth_code" class="input-sort" autocomplete="off" required="">
			<img src="http://www.luoo.net/data/captcha" data-src="http://www.luoo.net/data/captcha" alt="验证码" class="verify">
		</div>

		<div class="rule-wrapper">
			<input type="checkbox" name="rule" checked="" required="">
			 同意夜网的
			 <a target="_blank" href="term/">《使用协议》</a>
		</div>
		<div>
			<input type="submit" id="register_submit" style="width:100%" class="btn btn-positive btn-register-submit rounded" value="注册">
			<span class="btn btn-positive btn-register-msg rounded"  name="error_placement2" style="display: none;"></span>
		</div>
	</form>
</div></div>
</div>
<!-- login End-->
<!-- account detail-->
<div class="account hidden">
<div class="account-links rounded" id="accountLinks">
			<a class="account-link link-uc" href="user/profile/${user.id}" target="_blank" rel="nofollow">
				<span class="icon-account"></span>我的落网
			</a>
			<a class="account-link link-setting" href="user/setting/" target="_blank" rel="nofollow">
				<span class="icon-setting"></span>账号设置
			</a>
			<a class="account-link link-logout" href="javaScript:void(0);" rel="nofollow">
				<span class="icon-logout"></span>退出
			</a>
		</div>
		</div>
<!-- account detail end-->
<script>
function showSiblings($me){
$myFather = $me.parent().parent().parent();
$myFather.hide();
$myFather.siblings().show();
}
$(function(){
	  jQuery.validator.addMethod("normalName",function(value,element){  
          return /^[a-zA-Z0-9\u4E00-\u9FA5_]*$/.test(value);  
         },$.validator.format("请输入数字或者中英文以及下划线")  
         );  
	  jQuery.validator.addMethod("simpleChar",function(value,element){  
          return /^[a-zA-Z0-9]*$/.test(value);  
         },$.validator.format("密码只可以是字母和数字组合")  
         );  


 $("#loggedOutWrapper .ln-top-login").qtip({
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
              	var options = {
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
            		    } };
            	var options2 = {
            			type:"post",
            			dataType:'json',
            		    success: function(data) {
            		    	console.info("register2");
                          	$(".qtip #register_submit").hide();
                        	$(".qtip span[name=error_placement2]").text(data.message);
                        	$(".qtip span[name=error_placement2]").show();
            		      if(data.isGood=="true"){
            		    	  window.open($("base").attr("href") + "user/prompt/"+data.email+"/"+data.nick_name+"/",'_blank')
            		    	  $("#loggedOutWrapper .ln-top-login").qtip('hide');
                          	$(".qtip span[name=error_placement2]").hide();
                          	$(".qtip #login_submit").show();
            		      }
            		    } };
         	   $('.qtip form[name=login_form]').submit(function() {
       		    // 提交表单
       		    $(this).ajaxSubmit(options);
       		    // 为了防止普通浏览器进行表单提交和产生页面导航（防止页面刷新？）返回false
       		    return false;
       		   });
       	   $('.qtip form[name=register_form]').submit(function(event) {
       		    // 提交表单
       		    	console.info("register0");
       		    $(this).ajaxSubmit(options2);
       		    event.preventDefault();
       		    // 为了防止普通浏览器进行表单提交和产生页面导航（防止页面刷新？）返回false
       		    return false;
       		   });
            	$(".qtip form[name=login_form]").validate({rules:{
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
            	});
//             	注册表单验证
            	$(".qtip  form[name=register_form]").validate({rules:{
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
            	
            	
            	});
            	}  
         }

      });
 //为登录名添加qtip
 $(".logged-in-wrapper").qtip({
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
 });

$("button[data-tipid='commentSubmitDialog']").qtip({
content:$(".total").html() ,
			show:{
			solo:true,
			event: 'click',
			effect:{type:'slide'},
			length:2000
			},
			hide:'unfocus',
        position: {
          my: 'top center',
          at: 'bottom center'
        },

        style: {
          classes: 'qtip-luoo'
        }

      });


	  });
</script>
