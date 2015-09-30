<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="essay-author-wrapper clearfix">
				<div class="essay-author">
					<p class="title">
						文章作者
					</p>
						<div class="clearfix">
							<a href="" class="avatar-wrapper">
								<img src="${essay.portrait}" alt="${essay.author}" class="avatar rounded"/>
							</a>
							<div class="essay-author-info">
								<div class="cell">
									<a href="${essay.author_link}" class="essay-author-name">
										${essay.author}
									</a>
									<p class="essay-author-sign">${essay.author_desc}</p>
								</div>
							</div>
						</div>
										</div>
				<div class="copyright">
					<p class="title">
						版权声明
					</p>
					<div class="copyright-ct">
						「夜网」专栏内文章，如果侵权，立即删除
					</div>
				</div>
			</div>