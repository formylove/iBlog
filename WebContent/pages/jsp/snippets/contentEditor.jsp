<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
				<div class="section">
					<textarea id="editor" name="essay.content" placeholder="文章内容" rows="30"
						style="width: 99.4%;">${essay.content}</textarea>
				</div>
			<script type="text/javascript">
				CKEDITOR.editorConfig = function (config) {
			    //添加插件，多个插件用逗号隔开
			    config.extraPlugins = 'codesnippet';
			    //使用zenburn的代码高亮风格样式 PS:zenburn效果就是黑色背景
			    //如果不设置着默认风格为default
			    codeSnippet_theme: 'zenburn';
				}
				var editortext = CKEDITOR.replace('essay.content');
				var submitForm = function() {
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
    