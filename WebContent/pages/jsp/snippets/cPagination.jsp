<%@page import="com.opensymphony.xwork2.ActionContext"%>
    <%
    int pages = (Integer)ActionContext.getContext().getValueStack().findValue("pages"); 
    %>
    <%if(pages != 0){%>
    <div class="paginator" id="paginator">
    <a class="previous disabled" rel="nofollow" href="javascript:void(0);">上一页</a>
    <a class="page actived" rel="nofollow" href="javascript:void(0);">1</a>
    <%if(pages == 1){%>
    <a class="next disabled" href="javascript:void(0);" data-page="2">下一页</a>
	<%}else if(pages <=7 ){for(int i=2;i<pages+1;i++){%>
    <a class="page" rel="nofollow" href="javascript:void(0);"><%=i%></a>
	<%}%>
    <a class="next" href="javascript:void(0);" data-page="2">下一页</a>
	<%}else if(pages >7){for(int i=2;i<6;i++){%>
    <a class="page" rel="nofollow" href="javascript:void(0);"><%=i%></a><%}%>
    <span class="break">...</span>
    <a class="page" rel="nofollow" href="javascript:void(0);"><%=pages%></a>
    <a class="next" href="javascript:void(0);" data-page="2">下一页</a>
    <%}%>
	</div>
	<%} %>
