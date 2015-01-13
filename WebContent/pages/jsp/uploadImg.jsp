<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setAttribute("importParams", "jquery|Jcrop.js|Jcrop.css|main.css|crop.js|upload.js|fileupload.js|ajaxfile.js"); %>
<%@ include file="snippets/static_js_css.jsp" %>
<script type="text/javascript">
// function a() {
// 	$.ajax({
// 		url:'imageAction.action?method:upLoadCropedImg',
// 		type:'get',
// 		data:'file='+ document.getElementById("upload").files[0]
// 	});
	
// }
// $(document).ready(var button = $('#upload');  //定义能够上传文件的按钮,就是一个普通的button  
// var fileType = "jpg",fileNum = "one";   //定义能够上传的文件类型,当然要靠后面的onSubmit中的js去做判断  
// new AjaxUpload(button,{  
//     action: 'imageAction.action?method:upLoadCropedImg',  
//     name: 'uploadFile',   //这相当于<input type = "file" name = "shanghaiFile"/>  
//     onSubmit : function(file, ext){  
// //         if(fileType == "zip")  
// //         {  
// //             if (ext && /^(zip|rar)$/.test(ext)){  
//                 this.setData({  
//                     'test': '文件类型为压缩包' //这个info 暂时无效  
//                 });  
// //             } else {  
// //                 alert('非压缩包类型文件，请重传');  
// //                 return false;                 
// //             }  
// //         }  
                      
//         button.text('导入上海资信中...');  
          
//         if(fileNum == 'one')  //同时上传的文件数不能超过一个  
//             this.disable();  
          
//     },  
//     onComplete: function(file, response){ //上传完毕后的操作  
//         if(response != "success")  
//             alert(response);  
              
//         button.text('导入上海资信');                          
//         this.enable();  
          
//         if(response == "success");  
//             alert("导入上海资信成功");     
  
//         //有了response我们能做任何事了,返回的文件名称,文件路径等我们可以随意操作的!  
//     }  
// });  );
// function uploadPhoto(){
// 	alert("diaoyong");
// 	var button = $('#uploadFile');
// 	 new AjaxUpload(button, {
// 	   action: 'imageAction.action?method:upLoadCropedImg', //action address
// 	   name: 'upload',//file name
// 	   onSubmit : function(file, ext){
// 	     if (!(ext && /^(jpg|jpeg|JPG|JPEG|png)$/.test(ext))) {
// 	                    alert('图片格式不正确,请选择 jpg 格式的文件!', '系统提示');
// 	                    return false;
// 	                }
// 	   },
// 	   onComplete: function(file, response){//file是本地文件名； response是action对应返回jsp中的html代码
// 	    var limit=$(response).eq(2).val();
// 	    if(limit=="-1"){
// 	     alert("你上传的图片太大");
// 	    }
// 	    if(response!=""&&limit=="1"){
// 	     var img=$(response).get(0);
// 	     //var img=$(response).css({width:"125px",height:"175px"});
// 	     $("#test").html(img);
	     
// 	    }
// 	   }
// 	  }); 
// }

        function ajaxFileUpload() {
            $.ajaxFileUpload
            (
                {
                    url: 'imageAction.action?method:upLoadCropedImg', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'upload', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
								data:{"w":$('#w').val(),"h":$('#h').val()},
                    success: function (data, status)  //服务器成功响应处理函数
                    {
//                         $("#img1").attr("src", data.imgurl);
//                         if (typeof (data.error) != 'undefined') {
//                             if (data.error != '') {
//                                 alert(data.error);
//                             } else {
//                                 alert(data.msg);
//                             }
//                         }
alert("success");
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            );
            return false;
        }
</script>
<title>upload image here</title>
    </head>
    <body>
        <div class="demo" style=" margin-top:60px;">
            <div class="bheader"><h2>——图像上传表单——</h2></div>
            <div class="bbody">

                <!-- upload form -->
                <form id="upload_form" enctype="multipart/form-data" method="post" action="imageAction.action?method:upLoadCropedImg" onSubmit="return checkForm()">
                    <!-- hidden crop params -->
                    <input type="hidden" id="x1" name="x1" />
                    <input type="hidden" id="y1" name="y1" />
                    <input type="hidden" id="x2" name="x2" />
                    <input type="hidden" id="y2" name="y2" />

                    <h2>第一步:请选择图像文件</h2>
                    <div><input type="file" name="upload" id="upload" onChange="fileSelectHandler()" style="width:400px;"/></div>

                    <div class="error"></div>

                    <div class="step2">
                        <h2>请选择需要截图的部位,然后按上传</h2>
                        <img id="preview" />

																  <div class="info">
                            <label>文件大小</label> <input type="text" id="filesize" name="filesize" />
                            <label>类型</label> <input type="text" id="filetype" name="filetype" />
                            <label>图像尺寸</label> <input type="text" id="filedim" name="filedim" />
                            <label>宽度</label> <input type="text" id="w" name="w" />
                            <label>高度</label> <input type="text" id="h" name="h" />
                        </div>

                        <input type="submit" value="上传" />
                    </div>
                </form>
                <input type="button" id="uploadFile" name="uploadFile"  onclick="ajaxFileUpload();" value="submit">
                <a href="" id="uploadFile">头像上传<a/>
            </div>
        </div>
<div style="text-align:center;clear:both"><br>
<p>适用浏览器：FireFox、Chrome、Opera. 不支持IE8、360、Safari、傲游、搜狗、世界之窗。</p><br>
<div id="test"></div>
<%request.setAttribute("uploadContentType", "success");%>
</div>
</body>
</html>