		<div class="essay-share">
				<a href="javascript:;" >
					<span id="like" class="icon-essay-fav"  onclick="like('essay','${essay.id}');" style="margin-right:5px;" ></span>
					<span id="liked" class="icon-essay-faved hidden"  onclick="undoLike('essay','${essay.id}');" style="margin-right:5px;" ></span>
					<span id="favorcnt">${essay.favor_cnt}</span>
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:;" class="btn-share btn-action-share"  >
					<span class="icon-essay-share"></span>
				</a>
			</div>	