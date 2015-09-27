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
if(importParams.indexOf("Jcrop")>=0){ %>
<script type="text/javascript" src="js/Jcrop/jquery.Jcrop.js"></script>
<link href="js/Jcrop/jquery.Jcrop.css" type="text/css" rel="stylesheet">
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
<%}
}%>
