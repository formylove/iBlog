<%@ page import="main.src.common.MessageUtils" %>
<base href="<%=MessageUtils.getMessageFromUrl("base")%>"/>

<%String importParams=(String)request.getAttribute("importParams"); %>

<%
if(importParams!=null){
if(importParams.indexOf("jquery")>=0){ %>
<script type="text/javascript" src="js/jquery.js"></script>
<%}
if(importParams.indexOf("Jcrop.js")>=0){ %>
<script type="text/javascript" src="Jcrop/js/jquery.Jcrop.js"></script>
<%}
if(importParams.indexOf("flexSlider.js")>=0){ %>
<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
<%}
if(importParams.indexOf("Jcrop.css")>=0){ %>
<link href="Jcrop/css/jquery.Jcrop.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("main.css")>=0){ %>
<link href="Jcrop/css/main.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("crop.js")>=0){ %>
<script src="js/crop.js"></script>
<%}
if(importParams.indexOf("index.js")>=0){ %>
<script src="js/index.js"></script>
<%}
if(importParams.indexOf("upload.js")>=0){ %>
<script src="js/ajaxupload.js"></script>
<%}
if(importParams.indexOf("upload2.js")>=0){ %>
<script src="js/fileuploader.js"></script>
<%}
if(importParams.indexOf("ajaxfile.js")>=0){ %>
<script src="js/ajaxfileupload.js"></script>
<%}
if(importParams.indexOf("ckeditor.js")>=0){ %>
<script src="ckeditor/ckeditor.js"></script>
<%}
if(importParams.indexOf("common.css")>=0){ %>
<link href="css/common.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("vol.css")>=0){ %>
<link href="css/vol.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("diary.css")>=0){ %>
<link href="css/diary.css" type="text/css" rel="stylesheet">
<%}
if(importParams.indexOf("luoo.js")>=0){ %>
<script src="js/luoo.js"></script>
<%}}%>
