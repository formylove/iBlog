<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="essay-share">
				<a href="javascript:;" >
					<span id="like" class="icon-essay-fav"  onclick="like('${id}');" style="margin-right:5px;" ></span>
					<span id="liked" class="icon-essay-faved hidden"  onclick="undoLike('${id}');" style="margin-right:5px;" ></span>
					<span id="favorcnt">${essay.favor_cnt}</span>
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:;" class="btn-share btn-action-share" data-app="essay" data-id="520'" data-text="这篇文章值得一读【惘闻：艺术与声音的即兴合作——奇迹寻踪】（分享自@落网）" data-img="http://7xkszy.com2.z0.glb.qiniucdn.com/pics/essays/201508/55d5b1119b303.jpg" title="分享">
					<span class="icon-essay-share"></span>
				</a>
			</div>	