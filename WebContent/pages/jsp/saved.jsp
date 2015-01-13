<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>successfully saved</title>
</head>
<body>
title:<s:property value="title" escape="false"/><br/>
label:<s:property value="label" escape="false"/><br/>
category：<s:property value="category" escape="false"/><br/>
原创：<s:property value="isOriginal" escape="false"/><br/>
原创：<s:property value="label" escape="false"/><br/>
content：<s:property value="editor" escape="false"/><br/>
</body>
</html>