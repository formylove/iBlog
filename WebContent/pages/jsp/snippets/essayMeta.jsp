<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="main.src.entity.User" %>
<s:if test="opus == null">
<p class="essay-meta">
<%if((User)request.getAttribute("loginedUser")!=null && ((User)request.getAttribute("loginedUser")).getAuthority() == 0) {%>
				<span class="cursor-pointer" onclick="window.open('/manager/essay/edit/${essay.id}')">修改</span>・
				<s:if test="essay.del_flag==false"><span id="delete" onclick="deleteObj('essay','${essay.id}');" class="cursor-pointer">删除</span><span id="recover" class="hidden cursor-pointer" onclick="recoverObj('essay','${essay.id}');">恢复</span></s:if>
				<s:else><span id="delete" class="hidden cursor-pointer" onclick="deleteObj('essay','${essay.id}');">删除</span><span id="recover" onclick="recoverObj('essay','${essay.id}');" class="cursor-pointer">恢复</span></s:else>
				・
				<%} %>
				<s:if test="essay.original_flag">[原创]</s:if>
				<s:else>[转发自]</s:else>&nbsp;
				作者・<span><s:if test="essay.author == null || essay.author == ''">佚名</s:if><s:else><a href="${essay.author_link}">${essay.author}</a></s:else></span>
				<s:if test="!essay.original_flag">・<span><a href="${essay.original_link}" target="_blank" ><font color="red">[原文链接]</font></a></span></s:if>・${essay.create_date}
				</p>
</s:if>
<s:else>
<p class="margin-b-25" style="margin-top: 0;  padding: 0;">
<%if((User)request.getAttribute("loginedUser") !=null && ((User)request.getAttribute("loginedUser")).getAuthority() == 0) {%>
				<span class="cursor-pointer" onclick="window.open('/manager/note/edit/${essay.id}')'">修改</span>・
				<s:if test="essay.del_flag==false"><span id="delete" onclick="deleteObj('note','${essay.id}');" class="cursor-pointer">删除</span><span id="recover" class="hidden cursor-pointer" onclick="recoverObj('note','${essay.id}');">恢复</span></s:if>
				<s:else><span id="delete" class="hidden" onclick="deleteObj('note','${essay.id}');">删除</span><span id="recover" onclick="recoverObj('note','${essay.id}');" class="cursor-pointer">恢复</span></s:else>
				・
				<%} %>
				
				<s:if test="essay.original_flag">[原创]</s:if><s:else>[转发自]</s:else>&nbsp;
				作者・<span><s:if test="essay.author == null">佚名</s:if><s:else><a href="<s:property value="essay.author_link"/>"><s:property value="essay.author"/></a></s:else></span><s:if test="!essay.original_flag">・<span><a href="<s:property value="essay.original_link"/>" target="_blank" ><font color="red">[原文链接]</font></a></span></s:if>・<s:property value="essay.create_date"/>
				</p>
</s:else>