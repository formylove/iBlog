<%@ taglib prefix="s" uri="/struts-tags" %>
<table id="dg"></table>
   <div id="tb" style="padding:2px 5px;">
       	 类别: 
        <select id="classes" class="easyui-combobox" panelHeight="auto" style="width:100px"
        data-options="
        valueField: 'id',
        textField: 'text',
        onSelect: function(rec){
            getDatagrid(rec.id);
        }">
            <option value="music" selected>音乐</option>
            <option value="essay">文字</option>
            <option value="note">札记</option>
            <optgroup label="作品">
            <option value="movie">电影</option>
            <option value="book">书籍</option>
            <option value="series">连续剧</option>
            </optgroup>
            <optgroup label="百科">
            <option value="figure">人物</option>
            </optgroup>
            <optgroup label="行政单位">
            <option value="nation">国家</option>
            <option value="state">省/州</option>
            <option value="city">市/县</option>
            <option value="corporation">公司</option>
            </optgroup>
            <optgroup label="集合属性">
            <option value="dynasty">朝代</option>
            <option value="religion">宗教</option>
            <option value="people">种族</option>
            </optgroup>
            <optgroup label="分类">
            <option value="genre">电影分类</option>
            <option value="category">文字分类</option>
            </optgroup>
        </select>
        <span>|</span>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addItem()"></a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editItem()"></a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleteItem()"></a>
        <span>|</span>
        <input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" ></input>
    </div>
<script>










</script>