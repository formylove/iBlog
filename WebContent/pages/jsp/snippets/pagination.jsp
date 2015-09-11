<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int index = (request.getAttribute("page") == null || (int)request.getAttribute("page") == 0)?1:(int)request.getAttribute("page");
    System.out.print(index);
    int pages = (int)request.getAttribute("pages"); 
     String category = "c/" + ((String)request.getAttribute("category")).replace(",", "/")+"/";
    %><div class="paginator" style="<%=request.getAttribute("category")%>"><a class="previous <%if(index == 1){%>disabled<%}%>" rel="nofollow" href="<%if(index != 1){%>essays/<%=index - 1 %>/<%}%>">上一页</a><%
    if(pages <= 12){
    	for(int i=1;i<pages+1;i++){
    		if(i == index){%>
    		    <a class="page actived" rel="nofollow" href="javascript:;"><%=i%></a>
    			<%}else{%>
    			<a class="page" href="essays/<%=i%>/<%=category%>"><%=i%></a>
    	<%}}}else if(index < 7){
    	for(int i=1;i<11;i++){
    	    	if(i == index){%>
    		    <a class="page actived" rel="nofollow" href="javascript:;"><%=i%></a>
    			<%}else{%>
			<a class="page" href="essays/<%=i%>/<%=category%>"><%=i%></a><%}}%>
    	<span class="break">...</span><a class="page" href="essays/<%=pages%>/<%=category%>"><%=pages%></a><%
    }else if(pages - index < 6){%>
    	<a class="page" href="essays/1/<%=category%>">1</a><span class="break">...</span><%
    	for(int i = pages - 9;i < pages + 1;i++){
	    	if(i == index){%>
		    <a class="page actived" rel="nofollow" href="javascript:;"><%=i%></a>
			<%}else{%>
		<a class="page" href="essays/<%=i%>/<%=category%>"><%=i%></a>
		<%}}}else if(pages - index > 5 && index > 6){%>
			<a class="page" href="essays/1/<%=category%>">1</a>
			<span class="break">...</span>
	    	<%for(int i = index - 4;i < index + 5;i++){
	    	if(i == index){%>
		    <a class="page actived" rel="nofollow" href="javascript:;"><%=i%></a>
			<%}else{%>
		<a class="page" href="essays/<%=i%>/<%=category%>"><%=i%></a>
    <%}}%>
			<span class="break">...</span>	
			<a class="page" href="essays/<%=pages%>/<%=category%>"><%=pages%></a>
			 <%}%>
    <a class="next <%if(index == pages){%>disabled<%}%>" rel="nofollow" href="<%if(index != pages){%>essays/<%=index + 1 %>/<%=category%><%}%>">下一页</a>
				</div>
