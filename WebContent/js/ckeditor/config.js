/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	config.toolbar = [
['Source','Preview'],
[],
['RemoveFormat'],
[],
['Bold','Italic','Underline','Strike'],
['NumberedList','BulletedList','Blockquote'],
[],
['Link','Unlink'],
['Image','Table','HorizontalRule','Smiley'],
'/',
[],
[]
];
	config.filebrowserUploadUrl="ajax/upLoadImg4Editor";
	config.baseHref = 'http://hachi.space/';
	config.font_defaultLabel = 'Helvetica Neue';
	 config.keystrokes = [
	                      [ CKEDITOR.CTRL + 90 /*Z*/, 'undo' ],  //撤销
	                       [ CKEDITOR.CTRL + 89 /*Y*/, 'redo' ],  //重做
	                       [ CKEDITOR.CTRL + 66 /*B*/, 'bold' ],  //粗体
	                       [ CKEDITOR.CTRL + 73 /*I*/, 'italic' ],  //斜体
	                       [ CKEDITOR.CTRL + 85 /*U*/, 'underline' ],  //下划线
	                   ]
	// config.uiColor = '#AADC6E';
};
