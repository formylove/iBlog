function getDatagrid(type){
	var options = extend({},[defaultSetting,settings[type]]);
	$('#dg').datagrid(options);
}
function addItem(){
	var type = $('#classes').combobox('getValue');
	if(type == "movie" || type == "series" || type =="book"){
		window.open("manager/opus/e" + type);   
	}else{
		window.open("manager/"+type+"/edit/"); 
	}
}
function deleteItem(){
	var id = $("#dg").datagrid("getSelected").id;
	var type = $('#classes').combobox('getValue');
	var xhr = new XMLHttpRequest();
	var url = "manager/share/delete/"+id;
	var tableName = ""
		if(type == "movie" || type == "series" || type =="book"){
			tableName = "opus";
		}else{
			tableName = type;
		}
		xhr.open("post",url,false);//默认text/plain,需要流读取
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");  
		xhr.send("type="+tableName);
		$("#dg").datagrid("deleteRow",$("#dg").datagrid("getRowIndex",$("#dg").datagrid("getSelected")));
//		var datum = JSON.parse(xhr.responseText);
		confirm4easyui(type + " " + id + " 删除成功");
}
function editItem(){
	var id = $("#dg").datagrid("getSelected").id;
	var type = $('#classes').combobox('getValue');
	if(type == "movie" || type == "series" || type =="book"){
		window.open("manager/opus/e" + type+"/"+id);   
	}else{
		window.open("manager/"+type+"/edit/"+id); 
	}
}
function doSearch(value,name){
	var details = settings[$('#classes').combobox('getValue')];
	if(details.queryParams.properties.indexOf("name") >0){
		details.queryParams.conditions ="name like '%"+value+"%'";
	}else{
		details.queryParams.conditions ="title like '%"+value+"%'";
	}
	var options = extend({},[defaultSetting,details]);
	options.page = 1;
	$('#dg').datagrid('gotoPage', options);
}
var defaultSetting = {
		url:'/ajax/datagrid/',
		loadMsg:"数据加载中，请稍后……",
		width: 760,  
		height:400,               
		singleSelect : true,  
		rownumbers: true,
		toolbar:'#tb',
		footer:'#ft',
		pagination: true,  
		pageList: [10,30,50],
		pageSize:10};
var musicSetting = {
		queryParams:{type:"music",order:"precedence desc,id desc",conditions:"1=1",properties:"id,name,precedence"},
		columns:[[
		          {field:'id',title:'Id',width:100},
		          {field:'name',title:'名称',width:100},
		          {field:'precedence',title:'优先级',width:100}
		          ]],
		          title:'音乐'
};
var essaySetting = {
		queryParams:{type:"essay",rows:10,pageNum:1,order:"id desc",conditions:"1=1",properties:"id,title"},
		columns:[[
		          {field:'id',title:'Id',width:100},
		          {field:'title',title:'标题',width:100}
		          ]],
		          title:'文字'
};
var movieSetting = {
		queryParams:{type:"opus",rows:10,pageNum:1,order:"id desc",conditions:"type='movie'",properties:"id,name,rating"},
		columns:[[
		          {field:'id',title:'Id',width:100},
		          {field:'name',title:'名称',width:100},
		          {field:'rating',title:'分数',width:100}
		          ]],
		          title:'电影'
};

var settings = {music:musicSetting,movie:movieSetting};
$(function(){
	getDatagrid($('#classes').combobox('getValue'));
	

	
	
	
})