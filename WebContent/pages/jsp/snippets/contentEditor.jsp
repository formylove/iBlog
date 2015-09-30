<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
				<div class="section">
					<textarea id="editor" name="note.content" placeholder="文章内容" rows="30"
						style="width: 99.4%;">${note.content}</textarea>
				</div>
			<script type="text/javascript">
				var editortext = CKEDITOR.replace('note.content');
				var duplicateCheck = function() {
					$.ajax({
								url : 'essayAction.action?method:hasExisted',
								type : 'post',
								contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
								data : 'title=' + $('#title').val(),
								success : function(data) {
									if (data.hasExisted
											& document.getElementById('id').value == '') {
										alert('不要重复发布文章');
									} else if (editortext.document.getBody()
											.getText().replace(/\s/g, '') == '') {
										alert('文章内容为空');
									} else {
										document.getElementById('form')
												.submit();
									}
								}
							});
				};
			</script>
    