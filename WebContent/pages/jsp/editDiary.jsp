<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑文章 - Aurora博客 - CSDN.NET</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../ckeditor/ckeditor.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="Stylesheet" href="http://csdnimg.cn/pig/blog/write/css/main.css" />
    <!--new top-->
<link type='text/css' rel='Stylesheet' href='http://csdnimg.cn/pig/blog/write/css/write.css' />
<link type='text/css' rel='Stylesheet' href='http://csdnimg.cn/pig/blog/write/css/jquery.autocomplete.css' />
</head>

<body>
     <!--new top-->
     <!--new top-->
    <div id="wrap">

        <div class="head">

            <div class="user_info">
                <dl>
                    <dt><a href="http://my.csdn.net/"><img src="http://avatar.csdn.net/A/D/2/3_ansyxx.jpg" alt="ansyxx" /></a></dt>
                    <dd>
                        <ul>
                            <li class="user_name"><a href="http://my.csdn.net/" class="user_name">ansyxx</a><span>ansyxx的专栏</span></li>
                            <li class="feed_link"><a href="http://my.csdn.net/">个人主页</a>|<a href="http://blog.csdn.net/ansyxx">我的博客</a></li>
                        </ul>
                    </dd>
                </dl>
            </div>

            <div style="float:right; margin-top:20px; color:Red;">
                
            </div>
        </div>

        <div class="tabs_header">
            <ul id="ul_tab" class="tabs">
                <li id="tab_postedit" style="display:none;"><a href="/postedit"><span>发表文章</span></a></li>
                <li id="tab_import" style="display:none;"><a href="/import"><span>博客搬家</span></a></li>
                <li><a href="/postlist"><span>文章管理</span></a></li>
                <li><a href="/category"><span>类别管理</span></a></li>
                <li><a href="/feedback"><span>评论管理</span></a></li>
                <li><a href="/configure"><span>博客配置</span></a></li>
                <li><a href="/configure/column"><span>博客栏目</span></a></li>
                <li><a href="/postlist/0/all/draft"><span>草稿箱</span></a></li>
                <li><a href="/postlist/0/all/deleted"><span>回收站</span></a></li>
                <li id="btn_postedit" class="write"><a href="/postedit" class="t_button">写新文章</a></li>
                <li id="btn_import" class="write"><a href="/import" class="t_button">博客搬家</a></li>
            </ul>
        </div>

<form action="<s:url action='diaryAction?method:saveDiary'/>" method="post">
<p class="subtit">文章标题<span style="color: green; margin-left: 18px; display: none">尊重原创，请保证您的文章为原创作品</span>
<input type="hidden" id="userinfo1" value="2014-11-30 10:46:17" /><input type="hidden" id="userinfo2" value="" /></p>
<div>
<select id="selType" name="isOriginal">
<option value="true">原创</option>
<option value="false">转载</option>
</select>
<input type="text" id="txtTitle" name="title" style="width:560px; height:20px; float:left;" maxlength="100" />
<span style="display:inline-block; padding:4px 0 0 10px;">*只有原创和翻译文章才能推荐到首页</span>
</div>

<p class="subtit">文章内容<span style="color:#ff9900;font-weight:normal;display:none;">（很抱歉，由于博客图片审核功能尚未完成，普通用户暂时关闭引用站外图片功能，请您谅解，我们会尽快开放。）</span><span id="autosave_note"></span></p>
<div class="section">
<textarea id="editor" name="editor" rows="30" style="width:99.4%;">输入爱人的名字</textarea>
</div>
<script type="text/javascript">
CKEDITOR.replace( 'editor' );
</script>


    <p class="subtit">文章标签</p>
<div style="position:relative;">
<div id="d_tag2"></div>
<input name="label" type="text" id="txtTag2" style="width:60%; height:20px;" maxlength="100" />（最多添加5个标签，多个标签之间用“,”分隔）
<div id="tag2box" style="display:none;">
</div>
</div>

<p class="subtit">选择分类 [<a href="/category" target="_blank">编辑分类</a>]</p>
<select id="selType" name="category"><option value="3000">请选择</option><option value="3001">java</option><option value="3002">linux</option></select>
<div>
<input type="text" id="txtTag" style="width:60%; height:20px;" maxlength="100" />（多个分类之间用“,”分隔）
<div><div id="tagbox"></div></div>
</div>

<div class="btn_area_1">   
<input id="btnPublish" type="submit" class="input_btn_1" value="发表文章" title="保存并跳转" />
<input id="btnDraft" type="submit" class="input_btn_1" value="立即保存" title="保存文章并留在当前页" />
<input id="btnCancel" type="submit" class="input_btn_1" value="舍弃" />
<span id="sp_note" class="savenote" style="display:none;"></span>
</div>
</form>
    </div>

 

</body>
</html>
