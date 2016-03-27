package main.src.action;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.service.MusicService;
import main.src.service.ShareService;
import net.sf.json.JSONObject;

public class ShareAction {
	@Resource(name="shareService")
	private ShareService shareService;
	@Resource(name="musicService")
	private MusicService musicService;
	private int id;
	private int rows;
	private int page;
	private String type;
	private String order;
	private String conditions;
	private String properties;
	private JSONObject datagrid;
	public String list() {
		return MsgConstants.LIST;
	}
	public String retrieve() {
		return MsgConstants.RETRIEVE;
	}
	public String delete() {
		type = StringUtils.lowerCase(type);
		if("music".equals(type)){
			musicService.delete(id);
		}else{
			shareService.delete(StringUtils.capitalize(type), id);
		}
		return MsgConstants.RETRIEVE;
	}
	public String datagrid() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		type = StringUtils.stripToNull(type);
		if(StringUtils.isNotEmpty(type)){
			datagrid = shareService.getDatalist(StringUtils.capitalize(type)+" "+type.substring(0,1),rows, page, order, conditions,properties);
		}
		return MsgConstants.DATAGRID;
	}
	@JSON(serialize=false)
	public ShareService getShareService() {
		return shareService;
	}
	public void setShareService(ShareService shareService) {
		this.shareService = shareService;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public JSONObject getDatagrid() {
		return datagrid;
	}
	public void setDatagrid(JSONObject datagrid) {
		this.datagrid = datagrid;
	}
	
}
