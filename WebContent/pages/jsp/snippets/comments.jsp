<%@ taglib prefix="s" uri="/struts-tags"%>
		<div class="comment-wrapper">
		<jsp:include page="./PlainEditor.jsp"/>
<a class="hide" name="commentAnchor"></a>
		<span id="commentSortText">最新评论</span>
		<span class="icon-sort-menu">▼</span>
		
<div class="comment-list" id="commentList">
                <div id="commentItems">
<s:iterator value="comments.{?#this.floor == 1  && #this.del_flag == false}" var="comment" status="st">
        <div class="item" data-floor="1" data-unit="${comment.unit}">
            <a href="user/profile/${comment.publisher.id}" class="avatar-wrapper" target="_blank">
                <img src="img/depot/${comment.publisher.portrait }" alt="${comment.publisher.nick_name}" class="avatar rounded">
            </a>
			<div class="item-wrapper">
                <div class="helper">
                    <a href="user/profile/${comment.publisher.id}" class="username" target="_blank">${comment.publisher.nick_name }</a>
                    ${(comment.publisher!=null)?"，":""}${comment.publisher.motto}
                </div>
                <div class="comment-ct">
                    <p class="the-comment" >${comment.content }</p>
                </div>
                <div class="helper clearfix">
                <s:property value="@main.src.common.TimeManager@getTimeDif(#comment.create_date,#comment.create_time)"/>
               		<a class="ln-comment-from" href="javascript:void(0);" target="_blank"> 来自  ${comment.dev_name}</a>
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply">
                        <span class="icon-reply"></span> 回复
                    </a>
                </div>
<s:if test="comments.{?#this.unit == #comment.unit && #this.floor != 1 && #this.del_flag == false}.size > 0">
                <div class="sub-comment clearfix">
                    </s:if>
                    <s:else>
                <div class="sub-comment clearfix hide">
</s:else>
                    <span class="arrows"></span>
                    <div class="editor-wrapper form-comment-at hide">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>

                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <button name="commentSubmit" data-target="${comment.id}" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix items">
<s:iterator value="comments.{?#this.unit == #comment.unit && #this.floor != 1 && #this.del_flag == false}" var="commentIN" status="st">
                    <div class="item" data-floor="${commentIN.floor}" data-unit="${commentIN.unit}">
            <a href="user/profile/${commentIN.publisher.id}" class="avatar-wrapper" target="_blank">
                <img src="img/depot/${commentIN.publisher.portrait}" alt="${commentIN.publisher.nick_name}" class="avatar rounded">
            </a>
            <div class="item-wrapper feedback">
                <a href="user/profile/${commentIN.publisher.id}" class="username" target="_blank">${commentIN.publisher.nick_name}</a>
<s:if test="#commentIN.floor >2">
                <span class="reply">回复</span>
                <a href="user/profile/${commentIN.target.publisher.id}" class="username" target="_blank">${commentIN.target.publisher.nick_name}</a>
</s:if>
                <div class="comment-ct">
                    <p class="the-comment">${commentIN.content}</p>
                </div>
                <div class="helper clearfix">
                <s:property value="@main.src.common.TimeManager@getTimeDif(#commentIN.create_date,#commentIN.create_time)"/>
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply">
                        <span class="icon-reply"></span> 回复
                    </a>
                </div>
            </div>
                    <div class="editor-wrapper hide form-comment-at">
                        <div class="editor">
                            <textarea name="content" class="editor-comment-at" spellcheck="false" autocomplete="off"></textarea>
                        </div>
                        <div class="toolbar clearfix">
                            <div class="btn-group">
                                <button name="commentSubmit" data-target="${commentIN.id}" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
       					 </div>
</s:iterator>
                    </div>
                </div>
            </div>
            </div>
                
</s:iterator>

                </div>
<s:include value="./cPagination.jsp" ></s:include>
			</div>
			</div>
		