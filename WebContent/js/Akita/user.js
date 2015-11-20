$(function(){
	
	var options = {
			content:$("<input type='text' name='name' placeholder='新的昵称'>"),
			title:"修改昵称",
			width: 410,
			background: "none",
			 ok: false,
             cancle: false,
             close: null
			};
	var options1 = {
			type:"post",
			dataType:'json',
			success: function(data) {
				if(data.isGood=="true"){
					if(typeof data.motto != "undefined"){
						$("#txtMoodCt").text(data.motto);
					}else{
						$("#txtMoodCt").text("说两句吧...");
					}
				}
			} };
	var options2 = {
	rules:{
        "nick_name":{
            required: true,
            normalName:true,
            maxlength: 14
        }
	},
	messages:{
        "nick_name":{
            required: "嘿，给自己取个昵称先",
            maxlength: "昵称不要太长啊喂"
        }
	},
        errorPlacement: function(error, element) {   
        	$(".input-group valid-msg").text(error.text());
      	  },
      	success: function() {   
      		$(".input-group valid-msg").text();
    	  }
	
	
	};
	var dg = dialog(options);
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
		event.preventDefault();
		return false;
	});
  	   //绑定 validate
    $(".edit-username-wrapper form").validate(options2);
	$("#lnEditUsername").click(function(){
		dg.show();
	});
	
	
	
	
	
	
	
	
	
	
	
	
});