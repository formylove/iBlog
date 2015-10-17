<%@ page import="main.src.common.MessageUtils" %>
<base href="<%=MessageUtils.getMessageFromUrl("base")%>"/>

<%String importParams=(String)request.getAttribute("importParams"); %>

<%
if(importParams!=null){
if(importParams.indexOf("jquery")>=0){ %>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<%}
if(importParams.indexOf("Akita.js")>=0){ %>
<script src="js/Akita/Akita.js"></script>
<%}
if(importParams.indexOf("validate")>=0){ %>
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script>
<%}
if(importParams.indexOf("user.css")>=0){ %>
<link href="css/user.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("Jcrop")>=0){ %>
<script type="text/javascript" src="js/Jcrop/jquery.Jcrop.js"></script>
<link href="js/Jcrop/jquery.Jcrop.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("qtip")>=0){ %>
<script type="text/javascript" src="js/qtip/jquery.qtip.min.js"></script>
<%}
if(importParams.indexOf("qtip")>=0){ %>
<script type="text/javascript" src="js/artDialog/jquery.qtip.min.js"></script>
<%}
if(importParams.indexOf("form")>=0){ %>
<script type="text/javascript" src="js/form/jquery.form.js"></script>
<%}
if(importParams.indexOf("flexSlider.js")>=0){ %>
<script type="text/javascript" src="js/flexSlider/jquery.flexslider-min.js"></script>
<%}
if(importParams.indexOf("sticky.js")>=0){ %>
<script type="text/javascript" src="js/stickyKit/stickyKit.js"></script>
<%}
if(importParams.indexOf("index.js")>=0){ %>
<script src="js/Akita/index.js"></script>
<%}
if(importParams.indexOf("upload.js")>=0){ %>
<script src="js/fileUpload/ajaxfileupload.js"></script>
<%}
if(importParams.indexOf("ckeditor.js")>=0){ %>
<script src="ckeditor/ckeditor.js"></script>
<link href="ckeditor/plugins/codesnippet/lib/highlight/styles/default.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("common.css")>=0){ %>
<link href="css/common.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("essays.css")>=0){ %>
<link href="css/essays.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("note.css")>=0){ %>
<link href="css/note.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("essay.css")>=0){ %>
<link href="css/essay.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("comment")>=0){ %>
<script src="js/Akita/comment.js"></script>
<%}
if(importParams.indexOf("ZeroClipboard.js")>=0){ %>
<script src="js/zeroclipboard/ZeroClipboard.js"></script>
<%}
if(importParams.indexOf("agent")>=0){ %>
<script src="js/agent/agent.js"></script>
<script src="js/agent/ua-parser.min.js"></script>
<%}
}
if(session.getAttribute("hasDeviceDetail") == null){%>
<script src="js/agent/ua-parser.min.js"></script>
<script>
$(function(){
	var parser = new UAParser();//atool网方法
		if(parser != null){
		r = parser.getResult();
		$.ajax({
			url:$("base").attr("href") + 'ajax/ua/',
			type:'post',
			data:{"browser":r.browser.name + ' ' + r.browser.major,"device":r.device.model + ' ' + r.device.type + ' ' + r.device.vendor,"os":r.os.name + ' ' + r.os.version,}
		});
	}
});
</script>

<%
}



%>
