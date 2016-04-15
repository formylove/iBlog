<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="!good">
confirm('${message}');
</s:if>
<s:elseif test="comment.floor == 1">
<div class="item" data-floor="1" data-unit="${comment.unit}">
            <a href="user/profile/${comment.publisher.id}" class="avatar-wrapper" target="_blank">
                <img src="img/depot/${comment.publisher.portrait }" alt="${comment.publisher.nick_name}" class="avatar rounded">
            </a>
<div class="item-wrapper">
                <div class="helper">
                    <a href="user/profile/${comment.publisher.id}" class="username" target="_blank">${comment.publisher.nick_name }</a>
               ${(comment.publisher.motto!=null)?"，":""}${comment.publisher.motto}
                </div>
                <div class="comment-ct">
                    <p class="the-comment" >${comment.content }</p>
                </div>
                <div class="helper clearfix">
                    			刚刚
                    <a class="ln-comment-from" href="javascript:void(0);" target="_blank"> 来自  ${comment.dev_name}</a>
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply">
                        <span class="icon-reply"></span> 回复
                    </a>
                </div>
                <div class="sub-comment clearfix hide">
                    <span class="arrows"></span>
                    <div class="editor-wrapper hide form-comment-at">
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
                    </div>
                </div>
            </div>
            </div>
</s:elseif>
<s:elseif test="comment.floor == 2">
           <div class="item" data-floor="2" data-unit="${comment.unit}">
            <a href="user/profile/${comment.publisher.id}" class="avatar-wrapper" target="_blank">
                <img src="img/depot/${comment.publisher.portrait}" alt="${comment.publisher.nick_name}" class="avatar rounded">
            </a>
            <div class="item-wrapper feedback">
                <a href="user/profile/${comment.publisher.id}" class="username" target="_blank">${comment.publisher.nick_name}</a>
                <div class="comment-ct">
                    <p class="the-comment">${comment.content}</p>
                </div>
                <div class="helper clearfix">
                    刚刚
                    <a href="javascript:void(0);" class="btn-reply btn-action-reply ">
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
                                <button name="commentSubmit" data-target="${comment.id}" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
        </div>
</s:elseif>
<s:else>
           <div class="item" data-floor="${comment.floor}" data-unit="${comment.unit}">
            <a href="user/profile/${comment.publisher.id}" class="avatar-wrapper" target="_blank">
                <img src="img/depot/${comment.publisher.portrait}" alt="${comment.publisher.nick_name}" class="avatar rounded">
            </a>
            <div class="item-wrapper feedback">
                <a href="user/profile/${comment.publisher.id}" class="username" target="_blank">${comment.publisher.nick_name}</a>
                <span class="reply">回复</span>
                <a href="user/profile/${comment.target.publisher.id}" class="username" target="_blank">${comment.target.publisher.nick_name}</a>
                <div class="comment-ct">
                    <p class="the-comment">${comment.content}</p>
                </div>
                <div class="helper clearfix">
                    <s:property value="@main.src.common.TimeManager@getTimeDif(comment.create_date,comment.create_time)"/>
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
                                <button name="commentSubmit" data-target="${comment.id}" class="btn btn-positive btn-not-ready rounded btn-at-comment-submit">评论</button>
                            </div>
                        </div>
                    </div>
        </div>
</s:else>