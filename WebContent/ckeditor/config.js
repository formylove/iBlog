/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
//	config.language = 'zh';
//	config.uiColor = '#AADC6E';
//	config.filebrowserUploadUrl="../../action/imageAction";
//	config.filebrowserUploadUrl="default2/imageAction";
	config.extraPlugins = 'clipboard,lineutils,widget,dialog,codesnippet';
	var pathName = window.document.location.pathname; //获取带"/"的项目名，如：/uimcardprj
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    config.filebrowserImageUploadUrl = projectName+'/imageAction.action?method:upLoadImg'; //固定路径
};
