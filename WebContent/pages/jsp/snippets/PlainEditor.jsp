<%@page import="main.src.entity.User" %>
		<div class="comment-editor">
				<a href="javascript:;" class="avatar-wrapper" id="commentAvatarHolder" rel="nofollow">
					<img src='<%=request.getAttribute("loginedUser")!=null?"img/depot/"+((User)request.getAttribute("loginedUser")).getPortrait():"img/common/avatar.gif"%>' class="avatar rounded">
				</a>
				<div class="editor-wrapper">
						<div class="editor rounded">
							<textarea name="content" spellcheck="false" id="commentEditor" autocomplete="off"></textarea>
						</div>
						<div class="toolbar rounded clearfix">
							<button  disabled="disabled" class="btn btn-positive btn-not-ready rounded" name="commentSubmit" id="commentSubmit" >发布</button>
						</div>
			</div>
		</div>