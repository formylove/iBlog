$(function(){
	$nickForm = $("<form></form>").attr("action","ajax/login/update").attr("id","nick_name_form")
	.prepend("<span id='name_error_placement' style='color:red'></span>")
	.prepend($("<input type='text' name='nick_name' id='nick_name' placeholder='新的昵称'>"))
	.prepend($("<input type='hidden' name='id' value='"+$("#userId").val()+"'>"))
	.prepend($("<input type='hidden' name='update_type' value='nick_name'>"));
	  jQuery.validator.addMethod("wechat",function(value,element){  
          return /^[a-zA-Z0-9_]*$/.test(value);  
         },$.validator.format("请输入正确微信号")  
         ); 
	var options = {
			content:$nickForm.prop('outerHTML'),
			title:"修改昵称",
			cancelValue:"取消",
			cancel:function(){},
			okValue:"确定",
			ok:function(){
				var isGood = null;
					     $("#nick_name_form").ajaxSubmit({
				    			type:"post",
				    			async:false,//阻塞提交
				    			dataType:'json',
				    		    success: function(data) {
				    		    	isGood = data.isGood;
				    		      if(isGood){
				                  	$(".setting-name p span").text(data.nick_name);
				                  	$("h1.uname").text(data.nick_name);
				                  	$("#lnAccountMore span").text(data.nick_name).attr("alt",data.nick_name);
				    		      }else{
				    		    	  $("#name_error_placement").text(data.message);
				    		      }
				    		    } });
					     if(!isGood){
					    	 return false;
					     }
			},
			onshow: function () {
		        $("#nick_name_form").validate(options2);
		    },
			width: 410,
			background: "none",
            close: null
			};
	var options1 = {
			type:"post",
			dataType:'json',
			success: function(data) {
				if(data.isGood==true){
					if(typeof data.motto != "undefined"){
						$("#txtMoodCt").text(data.motto);
					}else{
						$("#txtMoodCt").text("说两句吧...");
					}
					$('#textMood').toggle();
					$('#formMood').toggle();
				}
			} };
	var options2 = {
	rules:{
        "nick_name":{
            required: true,
            normalName:true,
            maxlength: 10
        }
	},
	messages:{
        "nick_name":{
            required: "嘿，给自己取个昵称先",
            maxlength: "昵称不要太长啊喂"
        }
	},
        errorPlacement: function(error, element) {   
        	$("#name_error_placement").text(error.text());
      	  },
      	success: function() {   
      		$("#name_error_placement").text("");
    	  }
	
	
	};
	var options3 = {
			rules:{
				"qq":{
					required: true,
					number:true,
					rangelength:[5,11]
				},
				"wechat":{
					required: true,
					wechat:true
				},
				"phone":{
					required: true,
					number:true,
					rangelength:[11,11]
				},
			},
			messages:{
				"qq":{
					required: "请输入QQ",
					number: "请输入正确的QQ号",
					rangelength: "请输入正确的QQ号"
				},
				"wechat":{
					required: "请输入你的微信号"
				},
				"phone":{
					required: "请输入自己的手机号",
					number: "请输入正确的手机号",
					rangelength: "请输入正确的手机号"
				}
			},
			errorPlacement: function(error, element) {   
				$(element).next().text(error.text());
			},
			success: function(element) {   
				$(element).next().text("");
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:"post",
					dataType:'json',
					success: function(data) {
						if(data.isGood){
							$("#details .btn").addClass("btn-not-ready");
							confirm("资料更新成功!");
						}else{
							confirm(data.message);
						}
					} });
				return false;  
	        }    
			
			
	};
	var options4 = {
			rules:{
				"password":{
					required: true,
	                simpleChar:true,
	                maxlength: 16,
	                minlength: 8
				},
				"newpassword":{
					required: true,
	                simpleChar:true,
	                rangelength:[8,16]
				},
				"psw_conf":{
					 required: true,
		             equalTo:"#txtNewpassword"   //定位到了隐藏栏位
				},
			},
			messages:{
				"password":"密码错误",
				"newpassword":{
					required: "请输入新密码",
					rangelength: "请输入8到16位数密码"
				},
				"psw_conf":"两次输入密码不一致"
			},
			errorPlacement: function(error, element) {   
				$(element).next().text(error.text());
			},
			success: function(element) {   
				$(element).next().text("");
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:"post",
					dataType:'json',
					success: function(data) {
						if(data.isGood){
							confirm("密码更新成功!");
						}else{
							confirm(data.message);
						}
					} });
				return false;  
			}    
			
			
	};
	$("#details").validate(options3);
	$("#reset_psw").validate(options4);
	$("#lnEditMood,#lnCancleMood").click(function(){
		$('#textMood').toggle();
		$('#formMood').toggle();
	});
	$("#lnSaveMood").click(function(){
		$('#motto-form').submit();
	});
	$('#motto-form').submit(function(event) {
  		    $(this).ajaxSubmit(options1);
  		    event.preventDefault();
  		    return false;
  		   });
	
	$('.edit-username-wrapper form').submit(function(event) {
		$(this).ajaxSubmit(options1);
		return false;
	});
  	   //绑定 validate
    
	$("#lnEditUsername").click(function(){
		var dg = dialog(options);//每次显示都需要初始化
		dg.show();
	});
	$("#chkAutoplay").click(function(){
		$.ajax({
			url:"ajax/login/update",
			data:{autoplay:$(this).is(":checked"),id:$("#userId").val(),update_type:"autoplay"}
		});
	});
	
	$("#details input").on("input change",function(){//绑定多个事件
		$("#details .btn").removeClass("btn-not-ready");
		
	});
	$("#details input").on("change",function(){
		$("#details .btn").removeClass("btn-not-ready");
		
	});
	$(".tab-item").click(function(){
		$(this).addClass("actived").siblings().removeClass("actived");
		$("."+$(this).attr("id")).show().siblings(".tab-content-item").hide();
	});
	
    var a = new Date;
    a.setFullYear(a.getFullYear() - 10),
    $("#lnEditBrithday").click(function() {
        var b = $("#txtBirthday").glDatePicker({
            cssName: "flatwhite",
            yearRange: {
                from: 1960,
                to: (new Date).getFullYear() - 10
            },
            todayDate: a,
            dowNames: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            onClick: function(a, b, c) {
                var d = (c.getMonth() + 1<10)?'0'+(c.getMonth() + 1):(c.getMonth() + 1)
                  , e = c.getFullYear() + "-" + d + "-" + ((c.getDate()<10)?'0'+c.getDate():c.getDate());
                $("#txtBirthday").val(e),
                $("#birthdayPlaceholder").removeClass("helper").text(e);
                $("#details .btn").removeClass("btn-not-ready");
            }
        }).glDatePicker(!0);
        b.show()
    });
	
	
	
});