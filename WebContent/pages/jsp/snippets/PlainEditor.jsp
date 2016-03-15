<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="comment-editor">
				<a href="javascript:;" class="avatar-wrapper" id="commentAvatarHolder" rel="nofollow">
					<img src="${user==null?'img/common/avatar.gif':user.portrait}" alt="${user.nick_name }" class="avatar rounded">
				</a>
				<div class="editor-wrapper">
						<div class="editor rounded">
							<textarea name="content" spellcheck="false" id="commentEditor" autocomplete="off"></textarea>
						</div>
						<div class="toolbar rounded clearfix">
							<button  disabled="disabled" class="btn btn-positive btn-not-ready rounded" id="commentSubmit" >发布</button>
						</div>
				<!-- editor-wrapper end-->
			</div>
		
		</div>