<%--
Description: This is where all the common hidden boxes to be put at the bottom of listing pages should go. Attributes to pass in the request: pointNameForInquireAll, wordForPATipBox
$Header: /data/cvs/enigma3/boojum/gsol/en/clean/jsp/snippets/Attic/hidden_listing_boxes.jsp,v 1.1.6.54 2015/09/15 06:11:50 frankx Exp $
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="enigma.web.util.WebContext"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="enigma.web.entity.SessionBean, java.util.*" %><jsp:useBean id="sessionBean" scope="session" type="enigma.web.entity.SessionBean" />
<%-- Web Trends WT.source Logic --%>
<%@page import="javax.servlet.http.HttpServletRequest,java.util.*,java.net.URLEncoder,enigma.util.config.ConfigManager, enigma.web.util.GuiHelper,enigma.web.entity.*" %>
<%@ include file="../snippets/taglib_includes.jsp" %>
<fmt:setLocale value="${param.language}"/>
<jsp:useBean id ="pointBean" scope="session" class="enigma.web.entity.EnigmaBean" />
<%@ include file="../commons/catalog_and_point_init.jsp" %><%
String thisPage = request.getParameter("page")==null?"":request.getParameter("page").toString();
boolean isMobileDevice = sessionBean.getContext().checkMobileDevice();
String WT_source_value ="";
String WT_source_value1 = "";
if("showsuppliers".equals(thisPage)){
    WT_source_value = "Art Supp List Pg";
	WT_source_value1 = "Art Supp List Pg";
} else if ("SupplierIndustries".equals(thisPage)){
	if (point.getLevel()<=3){
		String tempLevelString = "" + point.getLevel();
	    WT_source_value = "DD L" + tempLevelString + " Pg";
	    WT_source_value1 = "Product L" + tempLevelString + " DD";
	}else if (point.isLeaf()){//L4
	    WT_source_value = "DD L4 Pg";
		WT_source_value1="Product L4 DD";
	}
} else if ("search/SupplierSearchResults".equals(thisPage)) {
	WT_source_value = "KW Search Pg";
	WT_source_value1="Supp KW Pg";
} else if ("Browse".equals(thisPage)){
	if (point.getLevel()<=3){	//L3
		String tempLevelString = "" + point.getLevel();
	    WT_source_value = "DD L" + tempLevelString + " Pg";
		WT_source_value1="Product L" + tempLevelString + " DD";
	}else if (point.isLeaf()){//L4
	    WT_source_value = "DD L4 Pg";
		WT_source_value1="Product L4 DD";
	}
} else if ("prodalert/PALanding".equals(thisPage)) {
    WT_source_value = "PA Landing Pg";
	WT_source_value1="PA Landing Pg";
}else if ("search/ProductSearchResults".equals(thisPage)){
	WT_source_value = "KW Search Pg";
    WT_source_value1="Prod KW Pg";
} else if ("top/L1L2NewProducts".equals(thisPage)) {
    WT_source_value = "New Pdt Pg";
	if ("NL1".equals(request.getParameter("npType"))){//npType
		WT_source_value1 = "Whats New HP";
	}else{
		WT_source_value1 = "Whats New L2 Pg";
	}
} else if ("top/L1NewProductsAlpha".equals(thisPage)) {
    WT_source_value = "New Pdt Pg";
	WT_source_value1 = "Whats New Alpha Pg";
} else if ("top/Results".equals(thisPage)) {
    WT_source_value = "TP Pg";
	WT_source_value1 = "TP Pg";
}else if ("top/TCSResults".equals(thisPage)){
	WT_source_value = "TCS Pg";
	WT_source_value1 = "TCS Pg";
}else if ("ProductDetail".equals(thisPage)){
	WT_source_value = "GSOLpp_pages";
	WT_source_value1 = "GSOL ADV PPs";
}else if ("ms/ProductSearch".equals(thisPage)){
	WT_source_value = "Zhongshan Prod KW Pg";
	WT_source_value1 = "Zhongshan Prod KW Pg";
}else if ("ms/SupplierSearch".equals(thisPage)){
	WT_source_value = "Zhongshan Supp KW Pg";
	WT_source_value1 = "Zhongshan Supp KW Pg";
}else if ("ms/Browse".equals(thisPage)){
	WT_source_value = "Zhongshan L4 DD Pg";
	WT_source_value1 = "Zhongshan L4 DD Pg";
}else if ("ms/ExhibitorList".equals(thisPage)){
	WT_source_value = "Zhongshan Exhibitor List";
	WT_source_value1 = "Zhongshan Exhibitor List";
}else if ("listings/Filter".equals(thisPage)) {	
if ("true".equals(request.getParameter("compare_table"))) {
		if ("SupplierIndustries".equals(request.getParameter("pageCaller"))) {
			if (point.isLeaf()){ // L4
				WT_source_value = "DD L4 Pg";
				WT_source_value1="Product L4 DD";
			}else if (point.getLevel()<=3) { //L3
				String tempLevelString = "" + point.getLevel();
				WT_source_value = "DD L" + tempLevelString + " Pg";
				WT_source_value1="Product L" + tempLevelString + " DD";
			}
		}
	}else if ("Browse".equals(request.getParameter("pageCaller"))) {
		if (point.isLeaf()) {
			WT_source_value = "DD L4 Pg";
			WT_source_value1="Product L4 DD";
		}else if (point.getLevel()<=3) {
			String tempLevelString = "" + point.getLevel();
			WT_source_value = "DD L" + tempLevelString + " Pg";
			WT_source_value1="Product L" + tempLevelString + " DD";
		}
	}else if ("SupplierIndustries".equals(request.getParameter("pageCaller"))) {
		if (point.isLeaf()) {
			WT_source_value = "DD L4 Pg";
			WT_source_value1 = "Product L4 DD";
		}else if (point.getLevel()<=3) {
			String tempLevelString = "" + point.getLevel();
			WT_source_value = "DD L" + tempLevelString + " Pg";
			WT_source_value1 = "Product L" + tempLevelString + " DD";
		}
	} else if ("prodalert/PALanding".equals(request.getParameter("pageCaller"))) {
		WT_source_value = "PA Landing Pg";
		WT_source_value1 = "PA Landing Pg";
	} 
}else if ("wholesale/Results".equals(thisPage)) {	
	WT_source_value = "Wholesale Pg";
}

String WTSWTTabValue = (request.getAttribute("WTTab")!=null?(String)request.getAttribute("WTTab"):"");
%>
<% //-- GUIDED NAVIGATOR BOXES %>
<%=(request.getAttribute("generatedDropLists")!=null)?request.getAttribute("generatedDropLists"):""%>
<%if (!"supplier/ProductDetail".equals(thisPage)){ %>
<% //--TIP BOXES FOR VERIFIED/UNVERIFIED %>
<div id="verifiedBox" class="supplierPopBox clearfix">
<img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" class="verifiedSupplierIco" alt="" /><span class="supplierPopBox_txt"><spring:message code="listing.vs.tip"/></span>
</div>
<div id="unverifiedBox" class="supplierPopBox wholesalerPopBox clearfix">
<span class="supplierPopBox_txt"><spring:message code="listing.unvs.tip"/></span>
</div>
<% //--INQUIRY BUTTON TIP BOX %>
<div id="inquiryBox" class="inquiryPopBox">
<p class="inquiryPopCon"><spring:message code="listing.fixtool.tip"/></p>
</div>
<% //--INQUIRE ALL BUTTON TIP BOX %>
<div id="inquiryAllBox" class="inquiryPopBox">
<%Object allSuppObj[]={(request.getAttribute("pointNameForInquireAll")!=null)?" of <strong>" + request.getAttribute("pointNameForInquireAll") + "</strong>":""}; %>
<p class="inquiryPopCon"><spring:message code="listing.contactallspp" arguments="<%=allSuppObj%>"/> </p>
</div>
<% //--PA TIP BOX %>
<div id="paTipBox" class="paTipPopBox">
<% if(!isMobileDevice){%>
<% if(null == request.getAttribute("wordForPATipBoxViewLatest")) {%>
<spring:message code="listing.click.recieve"/><% if(request.getAttribute("wordForPATipBox")!=null){%>&nbsp;<spring:message code="listing.on"/>&nbsp;<strong><%=request.getAttribute("wordForPATipBox")%></strong><%}%>
<% }else{ %>
<spring:message code="listing.click.view"/><% if(request.getAttribute("wordForPATipBoxViewLatest")!=null){%>&nbsp;<spring:message code="listing.on"/>&nbsp;<strong><%=request.getAttribute("wordForPATipBoxViewLatest")%></strong><%}%>

<% } %>
</div>
<% } %>
<%if(sessionBean.getUser()==null){
			String fromWhere="PAEnh_L" + point.getLevel();
			String regFormAction="action=EELinkHandlerAction";
		 	String sourcePara = "GSOLHP_New_Product".equals(request.getParameter("source")) ? "&source=GSOLHP_New_Product" : "";
		 	String pageType="L1_L3_page";
        	if (request.getParameter("point_id") != null && !"".equals(request.getParameter("point_id"))){
        		regFormAction = regFormAction + "&l4_point_id=" + request.getParameter("point_id");
        	}
			if (request.getParameter("fromWhere") != null && !"".equals(request.getParameter("fromWhere"))){
				regFormAction = regFormAction + "&fromWhere=" + request.getParameter("fromWhere");
				if ("PAEnh_L3".equals(request.getParameter("fromWhere")) || "PAEnh_TP".equals(request.getParameter("fromWhere"))){
					regFormAction = regFormAction + "&catalog_id=" + catalog.getId() ;
				}
			}
			if (request.getParameter("pos") != null && !"".equals(request.getParameter("pos"))){
				regFormAction = regFormAction + "&pos=" + request.getParameter("pos");
			} 
			if (request.getParameter("searchQueryKeyword") != null && !"".equals(request.getParameter("searchQueryKeyword"))){
				regFormAction = regFormAction + "&searchQueryKeyword=" + URLEncoder.encode(request.getParameter("searchQueryKeyword"),"UTF-8"); 		 
			}
			String queryKeyword=point.getName().getValue()==null?"":point.getName().getValue();
			if("top/Results".equals(thisPage) || "wholesale/Results".equals(thisPage)){
				pageType="TP_page";
				queryKeyword=request.getParameter("query");
				regFormAction=regFormAction+sourcePara+"&fromWhere=PAEnh_TP";
				fromWhere="PAEnh_TP";
			}else{
				regFormAction = regFormAction + sourcePara+"&fromWhere=PAEnh_L" + point.getLevel();
				//added for MR38020
				if ( point.getLevel() == 4){
					regFormAction = regFormAction + "&pageTypes=L4_page";
				}
			}
			queryKeyword=URLEncoder.encode(queryKeyword,"UTF-8");
			%>
			<script language="JavaScript">var regFormActn = '<%=sessionBean.createHref(regFormAction) %>';</script>
			<form name="subscribeForm" method="post" onsubmit="return false;" action="">
				<div id="emailBox" class="emailBox">
		            <label>
		            	<spring:message code="common.email"/>
		            	<input id="paLiteTxt" class="paLiteTxt paLiteEmailTxt ui_input_tip inputTip" type="text" tipcls="inputTip" tip="Example:abc@company.com" name="email" value="<spring:message code="js.pa.example.abc"/>" />
		            </label>
		            <input id="paLiteKeyword" name="searchQueryKeyword" type="hidden" value="<%=queryKeyword%>" >
		            <input id="subscribeSubmit" class="button verticalMid" type="button" name="subscribeSubmit" value="<spring:message code="common.subscribe"/>" onclick="<%if(point.isLeaf()){%>checkEmailAndSub(regFormActn,document.subscribeForm,'L4_page');<%}%><%else{%>checkEmailAndSubL1_L3('http://<%=enigma.web.action.SuperReMap.getHostName(gsolCatalog.getName().getValue(),sessionBean.getContext())%>/gsol/GeneralManager?&catalog_id=2000000003844&design=clean&language=<%=sessionBean.getContext().language()%>&action=RedirectNewLite&fromWhere=<%=fromWhere %>',document.subscribeForm,'<%=pageType%>');<%}%>"/>
		        
		        </div>
		    </form>
	        <div id="eConfirmBox" class="eConfirmBox" style="display:none;">
	            <img class="successIco_s" alt="" src="<%=sessionBean.imageSrc("BLANK.GIF")%>"/>
	            <p id="sentEmailTipId" ><spring:message code="listing.sendmail"/></p>
	        </div>
         <%} %>
<% //--DEFAULT LIST BOXES %>

    <!--==S supplier list more prodcut box -->
    <div class="morePP_PopBox" id="morePPBox" >
        <dl class="morePP_pop">
            <dd class="pr">
            	<div class="morePP_Pop_img"><input type="checkbox" class="pp_check" /><a href="#"><img  src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" /></a></div>
            	<p class="sup_compare"><a href="javascript:void(0);" class="funBox UI_comparePP_btn" onclick="dcsMultiTrack('DCS.dcsuri', '/ComparePP.htm', 'WT.ti', 'PP Comparison', 'WT.cg_n', 'Compare PP', 'WT.dl', '22', 'WT.cg_s', '', 'WT.tab', '', 'WT.si_n', '', 'WT.si_p', '');"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" class="compIco" alt="" /> <span class="funTxt"><spring:message code="listing.compare.product.label"/></span></a></p>
            </dd>
            <dd class="supplier_inquire">
            	<p><a id="InqBtn" href="#" class="button"><spring:message code="common.inquirenow"/></a></p>
            	<p class="mt5"><a href="#" class="funBox" id="moAddBsk"><img alt="" class="basketIco" src="<%=sessionBean.imageSrc("BLANK.GIF")%>" />&nbsp;<spring:message code="listing.addbasket"/></a></p>
            </dd>
            <dd class="supplierPP_detail"><a href="#" id="InqSPD"></a>
			<div class="supplier_minOrder">
				<p id="InqMOQContainer"><strong><spring:message code="common.moq"/>:</strong> <span id="InqMOQ"></span></p>
				<p id="InqFOBContainer"><strong><spring:message code="common.fob"/>:</strong> <span id="InqFOB"></span></p>
				<p id="InqCertContainer"><strong><spring:message code="listing.certs"/>:</strong>  <span id="InqCert"></span>  <a onclick="dcsMultiTrack('DCS.dcsuri', '/More_link.htm', 'WT.ti', 'More Link', 'WT.cg_n', 'More_MouseoverPP', 'WT.source', '<%=WT_source_value%>');" target="_blank" id="InqCertMore" href="#" class="more"><spring:message code="listing.more"/>...</a></p>
			</div>
			</dd>
        </dl>
    </div>
    <!--==E supplier list more prodcut box -->    
<!--==S supplier service icon popup box -->
    <!--==S Verified Suppliers popup box -->
    <dl class="verifiedSupPopup serviceListPopup kwRelateLink" id="verifiedSupPop">
        <dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="verifiedSupplierIcoPop_b" /> <spring:message code="common.vs"/>
        </dt>
        <dd class="serviceListTxt">
            <spring:message code="listing.vs.desc"/>
            <p class="serviceList_more mt15"><a target="_blank" class="UIdata_href" href="#" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp Verified Mouseover Link', 'WT.cg_s', 'Learn More','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="common.learn.more"/></a></p>
        </dd>
    </dl>
    <!--==E Verified Suppliers popup box -->

    <!--==S Credit Check popup box -->
    <dl class="creditCheckPopup serviceListPopup kwRelateLink" id="creditPop">
        <dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="creditCheckIco_b" /> <spring:message code="common.cc"/>
        </dt>
        <dd class="serviceListTxt">
            <spring:message code="listing.cc.desc"/>
            <a target="_blank" href="#" class="viewDetails UIdata_href" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CC Mouseover Link', 'WT.cg_s', 'View details','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="listing.filter.viewdetails"/></a>
        </dd>
        <dd class="serviceListImg">
            <img class="UIdata_img" src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" />
        </dd>
    </dl>
	<!--==E Credit Check popup box -->

	<!--==S Supplier Capability Assessment popup box -->
    <dl class="serviceListPopup kwRelateLink" id="bvPop">
    	<dt class="serviceListTit">
        	<img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="bvIco_b" /> <spring:message code="common.sca"/>
        </dt>
        <dd class="serviceListTxt">
            <spring:message code="listing.sca.desc"/>
            <a target="_blank" href="#" class="viewDetails UIdata_href" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp SCA Mouseover Link', 'WT.cg_s', 'View details','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="listing.filter.viewdetails"/></a>
        </dd>
        <dd class="serviceListImg">
            <a href="#" class="serviceListTipImg UIdata_href2"  onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp SCA Mouseover Link', 'WT.cg_s', 'Image','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');">
            	<img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="UIdata_img"  />
            	<span class="serviceListTip"><spring:message code="listing.hiddenlist.click.download"/></span>
            </a>          
        </dd>
    </dl>
	<!--==E Supplier Capability Assessment popup box -->

    <!--==S Private Sourcing Event popup box -->
    <dl class="psePopup serviceListPopup kwRelateLink" id="psePop">
    <dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="pseIco_b" /> <spring:message code="Listing.pse"/>
        </dt>
        <dd class="serviceListTxt">
            <spring:message code="listing.pse.desc"/>
            <p class="serviceList_more mt5"><a target="_blank" href="#" class="UIdata_href" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp PSE Mouseover Link', 'WT.cg_s', 'View details','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="common.learn.more"/></a></p>
        </dd>
        <dd class="serviceListImg"><img src="<%=sessionBean.imageSrc("i/PSEIMG.JPG") %>" alt="" width="270" height="99" /></dd>
    </dl>
	<!--==E Private Sourcing Event popup box -->
	
	<% //--EMAG ICON BOX %>
	 <!--===S e-Magzines popup box -->
	<dl class="eMagPopup serviceListPopup kwRelateLink" id="eMagPop">
    	<dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="emagazineIco_b" /> <spring:message code="listing.magazine"/>
        </dt>
        <dd class="serviceListTxt"><spring:message code="prodetail.learn.more"/></dd>
        <dd class="serviceListImg">
        	<a target="_blank" href="#" class="UIdata_href2"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="UIdata_img" /></a>
        </dd>
        <dd class="eMagPopup_link"><spring:message code="listing.magazine.dl"/>:<a target="_blank" href="#" class="UIdata_href3" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp eMag Mouseover Link', 'WT.cg_s', 'Full Size Ad','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', ''	);"><spring:message code="listing.magazine.ad"/> </a> | <a target="_blank" href="#" class="UIdata_href4" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp eMag Mouseover Link', 'WT.cg_s', 'eMagazines','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="listing.magazine.emag"/></a> | <a target="_blank" href="#" class="UIdata_href5" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp eMag Mouseover Link', 'WT.cg_s', 'iPad App','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="listing.magazine.ipad"/></a>
        </dd>
	</dl>
	<!--===S e-Magzines popup box -->
		
<!--==E supplier service icon popup box -->
<%//--listing large PP box  %>
<!--==S listing large PP box -->
    <div id="largePPBox" class="ppPopBox">
        <dl class="kwRelateLink">
            <dd class="ppPopBox_img">
            	<a href="#"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" class="iconPopPhoto" width="180" height="180" alt="" /></a>
            	<p class="sup_compare"><a href="javascript:void(0);" class="funBox UI_comparePP_btn" onclick="dcsMultiTrack('DCS.dcsuri', '/ComparePP.htm', 'WT.ti', 'PP Comparison', 'WT.cg_n', 'Compare PP', 'WT.dl', '22', 'WT.cg_s', '', 'WT.tab', '', 'WT.si_n', '', 'WT.si_p', '');"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" class="compIco" alt="" /> <span class="funTxt"><spring:message code="listing.compare.product.label"/></span></a></p>
            </dd>
            <dd>
            	<p class="mt10"><a href="#" id="InqBtn2" class="button"><spring:message code="common.inquirenow"/></a></p>
                <p class="mt5"><a href="#" class="funBox" id="moAddBsk2"><img alt="" class="basketIco" src="<%=sessionBean.imageSrc("BLANK.GIF")%>" />&nbsp;<spring:message code="listing.addbasket"/></a></p>
            </dd>
            <dd class="booth_Pop">
            	<strong><spring:message code="listing.hiddenlist.spp.exhibited"/>:</strong>
            	<p><a target="_blank"  href="#"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" class="iconPopPhoto" width="80" height="80" alt="" /></a></p>
            	<p class="UIdata_showname"></p>
            	<p class="boothPopLink"><a target="_blank"  href="#"><spring:message code="listing.hiddenlist.view.photos"/></a></p>
            </dd>
        </dl>
    </div>
    <!---=E listing large PP box -->
    <!--===S Major customer popup box -->
	<dl class="customerPopup serviceListPopup kwRelateLink" id="customerPop">
    	<dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="majorCustIco_b" /> <spring:message code="listing.customer"/>
        </dt>
        <dd class="serviceListTxt">
        <spring:message code="listing.customer.desc"/> 
         <ul id="mcList" class="dotList">
         </ul>      
        <p class="serviceList_more"><a target="_blank" href="#" class="UIdata_href" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp Major Customer Mouseover Link', 'WT.cg_s', 'View All','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="common.view.all"/></a></p>   
        </dd>
	</dl>
	<!--===S Major customer  popup box -->
	<!--===S Sourcing Fair popup box -->
    <dl class="sfPopup serviceListPopup kwRelateLink" id="sfPop">
    	<dt class="serviceListTit">
			<img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="csfIco_b" /> <spring:message code="common.ts"/>
		</dt>
        <dd class="UIdata_block2 upcomeShow">
        	<p id="upcomeTit"><strong><spring:message code="listing.hiddenlist.meet.us"/> <a target="_blank" href="#" class="UIdata_upcomingReg" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'Register','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="common.register"/></a></strong></p>
        	<p id="WTStit"><strong><spring:message code="listing.hiddenlist.come"/> <a target="_blank" href="#" id="WTSpp" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'WTS PP Online', 'WT.tab', '<%=WTSWTTabValue%>', 'WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '')"><spring:message code="listing.product"/></a> <spring:message code="listing.hiddenlist.at.fair"/><a target="_blank" href="#" id="WTSreg" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'WTS Reg', 'WT.tab', '<%=WTSWTTabValue%>', 'WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '')"><spring:message code="common.register"/></a></strong></p>
            <p class="UIdata_html">
                
            </p>
        </dd>
        <dd class="UIdata_block1 pr">
        	<p><spring:message code="listing.ts.desc"/></p>
            <div class="sfBooth clearfix UIdata_block3">
                <a class="UIdata_href3" href="#" target="_blank"  onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'Online Booth','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="sfImg UIdata_img" /></a>
                <ul class="sfInfo dotList UIdata_html2"></ul>
                <a target="_blank" href="#" class="booth UIdata_href4" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'Online Booth','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="listing.hiddenlist.click.view"/></a>
            </div>
        </dd>
        <dd class="serviceList_more"><a target="_blank" href="#" class="UIdata_href" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp CSF Mouseover Link', 'WT.cg_s', 'View All','WT.source', '<%=WT_source_value%>', 'WT.si_n','', 'WT.si_p', '');"><spring:message code="common.view.all"/></a></dd>
    </dl>    
    <!--===E Sourcing Fair popup box -->
	<!--===S select trade show overlay box -->
	<div id="tradeShow_overlay" class="overlayBox overlayBoxUTC kwRelateLink none">
		<strong class="overlayBox_tit"><spring:message code="listing.filter.upcomingts.boxheadline"/></strong>
	    <ul class="overlayBox_list listWithChk">
	    </ul>
	    <input id="upcomingTSListId" type="hidden">
	    <div class="overlayBtn"><a href="#" class="button"><spring:message code="common.confirm"/></a></div>
	    <div class="ui_overlay_close overlayBox_close"><spring:message code="common.close"/></div>
	</div>
	<!--===E select trade show overlay box -->  
	<!--===S Storefront popup box -->
	<dl class="storefrontPopup serviceListPopup kwRelateLink" id="storefrontPop">
    	<dt class="serviceListTit">
            <img src="<%=sessionBean.imageSrc("BLANK.GIF")%>" alt="" class="storeFrontIco_b" /> <spring:message code="common.online.store"/>
        </dt>
        <dd class="serviceListTxt">
        <spring:message code="listing.hiddenlist.storefronts"/>   
        <ul id="storefrontList" class="dotList mt5"></ul> 
        </dd>
        <p class="storefront_more"><a class="UIdata_href" target="_blank" onclick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp OS Mouseover Link', 'WT.cg_s', 'Click here to learn more about this supplier','WT.source', '<%=WT_source_value1%>', 'WT.si_n','', 'WT.si_p', '');" href="#"><spring:message code="listing.hiddenlist.click.learn"/></a></p>
	</dl>
	<!--===S Storefront popup box -->
    <dl id="hfPop" class="hfPopup serviceListPopup kwRelateLink" style="top: 700px; left: 755.1px; display: none;">
        <dt class="serviceListTit">
            <img width="158" height="34" alt="" class="hfLogo" src="<%=sessionBean.imageSrc("HFLOGO3.JPG")%>"> 
        </dt>
        <dd class="serviceListTxt">
        <spring:message code="listing.hf.desc2"/>  
        <p class="serviceList_more mt15"><a href="http://www.corporate.globalsources.com/CR/COMM.HTM " class="UIdata_href" target="_blank" onClick="dcsMultiTrack('DCS.dcsuri', '/Mouseover.htm', 'WT.ti', 'Mouseover Links', 'WT.cg_n', 'Supp Hinrich Foundation Mouseover Link', 'WT.cg_s', 'Learn More','WT.source', '<%=WT_source_value1%>', 'WT.si_n','', 'WT.si_p', '')"><spring:message code="common.learn.more"/></a></p> 
        </dd>    
    </dl> 
    <%// S MR 31811 Char list %>
	<ul class="charList_popup" id="UItrigger_char_popup"></ul>
	<%// E MR 31811 Char list %>
    <!--===S unverify information problem overlay box -->
	<div id="infoIssue_overlay" class="infoIssue_overlay none">
    	<div id="infoIssue">
            <p><spring:message code="listing.hiddenlist.tip1"/></p>
            <p class="infoIssue_action"><a href="javascript:void(0);" id="infoIssue_yes"><spring:message code="listing.yes"/></a> | <a href="javascript:void(0);" class="ui_overlay_close"><spring:message code="listing.no"/></a></p>
        </div>
        <div id="infoIssue_confirm" class="none">
        	<p><spring:message code="listing.thanku"/></p>
            <p class="mt5"><spring:message code="listing.hiddenlist.tip2"/></p>
            <p class="infoIssue_action"><a href="javascript:void(0);" class="ui_overlay_close"><spring:message code="common.close"/></a></p>
        </div>
	</div>
	
	<%} %>	
	
	
	
	
	<!--===E unverify information problem overlay box --><%
	
    String source = "L4 DD Pg";
	if("top/Results".equals(request.getParameter("page"))){
		source="TP Pg";
	}else if("top/TCSResults".equals(request.getParameter("page"))){
		source="TCS Pg";
	}else if("wholesale/Results".equals(request.getParameter("page"))){
		source="Wholesale Pg";
	}else if("search/ProductSearchResults".equals(request.getParameter("page"))){
		source="KW Search Pg";
	}else if("ProductDetail".equals(request.getParameter("page"))){
		source="GSOL ADV PPs";
	}else if("supplier/ProductDetail".equals(request.getParameter("page"))){
		source="GSOL UNV PPs";
	}
	
	if ("top/Results".equals(request.getParameter("page")) || 
	    "top/TCSResults".equals(request.getParameter("page")) || 
	    "wholesale/Results".equals(request.getParameter("page"))||
	    "ProductDetail".equals(request.getParameter("page"))|| //newly add  
	    "supplier/ProductDetail".equals(request.getParameter("page"))|| 
	    "search/ProductSearchResults".equals(request.getParameter("page"))||
	    "SupplierIndustries".equals(request.getParameter("page")) ){
			
        point = (request.getAttribute("catPointGSTJ")!=null)?(Point)request.getAttribute("catPointGSTJ"):null; // 1st category in search result
	    if (point==null) {
	        if (request.getAttribute("catIdGSTJ")!=null) {//the category of the 1st PP
			    GuiHelper guiHelper = GuiHelper.getInstance();
		        point = guiHelper.getPointByProdId(catalog.getName().getValue(), Long.parseLong((String)request.getAttribute("catIdGSTJ")), request);
		    }
  	    }
    }

	if (point!=null){	
		enigma.web.util.EBookUtil eu = enigma.web.util.EBookUtil.getInstance();
		String prodId = String.valueOf(point.getProdId());		
		enigma.web.util.EBook eb = eu.getEBook(Long.parseLong(prodId), request, point);
	if(eb != null){
		String defaultHostName = "http://" + enigma.web.action.SuperReMap.getHostName("Global Sources", sessionBean.getContext());
		if ("top/TCSResults".equals(request.getParameter("page"))){
			defaultHostName = "http://" + enigma.web.action.SuperReMap.getHostName("China Suppliers");
		}
		String eTitle = eb.getTitle();
		String downLoadUrl = eb.getDownloadUrl();
		String fromebook = request.getParameter("fromebook") != null ? (String)request.getParameter("fromebook") : "";
		User user = sessionBean.getUser() != null? (User)sessionBean.getUser() : null;
		String ebookuser = request.getParameter("ebookuser") != null ? (String)request.getParameter("ebookuser") : "";
		boolean showFlag = true;
		boolean showEguideFlag = true;
		boolean showEmagFlag = true;
		if (user != null && ("RegUser".equals(ebookuser) || "LiteUser".equals(ebookuser)) && "true".equals(fromebook)){
			showFlag = false ;
			showEguideFlag = false;
			showEmagFlag = false;
		}else if ( "NewUser".equals(ebookuser) && "true".equals(fromebook)){
			showFlag = false;		
			showEguideFlag = false;
			showEmagFlag = false;
		}
	%>
    <%
    
    if(user != null || (user == null && sessionBean.getContext().cookieExists("ebook_close_cookie"))){
		showFlag = false;
		showEguideFlag = false;
		showEmagFlag = false;
	}
    	 
   if(sessionBean.getContext().cookieExists("gsol_lite")){
	   showEmagFlag = false;
   }
    
   if(sessionBean.getContext().cookieExists(WebContext.VISITED_US_CREATE_ON)){
    	Cookie cookie = sessionBean.getContext().getCookie(WebContext.VISITED_US_CREATE_ON);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	Date dateCreated = sdf.parse(cookie.getValue());
        if(!sdf.format(new Date()).equals(sdf.format(dateCreated))){   	
    		showEguideFlag = false;
    	}  
    } 
    
    if(showFlag){ %>
		<script type="text/javascript">
			var date = new Date();
			date.setTime(date.getTime()+7*24*3600*1000);
			document.cookie = "shown_ebook_<%=eb.geteBookCode() %>=1;expires="+date.toGMTString()+";domain=globalsources.com;path=/";
		</script>
	<%}
	 if("EBOOK".equals(eb.getEbookType())&&	
		!"ProductDetail".equals(request.getParameter("page"))&&
		!"supplier/ProductDetail".equals(request.getParameter("page"))&&
		!"search/ProductSearchResults".equals(request.getParameter("page"))){ 
	
    String appUrl = (String)request.getAttribute("javax.servlet.forward.request_uri");

    if(appUrl == null || appUrl.indexOf(".htm") < 0){
        	appUrl = "/gsol/GeneralManager?"+ URLEncoder.encode(request.getQueryString(),"UTF-8");
    }
    %>
    <!--=S Buyer's Guide overlay box  -->
       <div id="getEbookPopup" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" class="ebookPopup" <%if(!showFlag){%>noAutoShow="true"<%}%>> 
    	<form onsubmit="return false;" name="eBookPopuForm" method="post" >

    	<input type="hidden" id="ebook_appurl"  name="appurl" value="<%=defaultHostName+appUrl %>" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>"/> 
        <h3 class="tit"><%=eb.getHeaderCopy().replace("�", "–") %></h3>
        <span class="close ui_overlay_close" onclick="javascript:setCookie('ebook_close_cookie','ebookClose',3);"><spring:message code="ebook.popup.close"/></span>                
        
        <div class="con" style="background:url(<%=eb.getImagePopUpURL()%>) no-repeat 560px 0;">
            <ul class="items">
                <li><spring:message code="ebook.center.tip1"/></li>
                <li><spring:message code="ebook.popup.tip1"/></li>
                <li><spring:message code="ebook.center.tip2"/></li>
                <li><spring:message code="ebook.popup.tip2"/></li>
            </ul>
            <div class="sbox">
            <%if (user == null){ %>
                <input id="ebookPopup" name="email" class="ebookPopup_txt mr10 ui_input_tip inputTip" tipCls="inputTip" tip="<spring:message code="ebook.center.email"/>" type="text" value="" />
             <%} %>
			  <a  href="#" trackValue="Auto" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" class="ebookPopup_btn" <%if(user == null){ %>
              onclick="javascript:downLoadEBook('<%=defaultHostName + sessionBean.createHref("action=DownloadEBook&eBookCode=" + eb.geteBookCode()) + "&point_id=" + point.getId() + "&source=GSOL_BuyersGuide_GAM" %>' 
              + $('#getEbookPopup .ebookPopup_btn').attr('trackValue'),document.eBookPopuForm,'ebook_popup','ebook_close_cookie','ebookClose',3);" <%}else{%> id="DownloadBG"  targetID="getEbookCfm2Popup" onclick="javascript:sendEBookEmail('<%=user.getEmail() %>','<%=eb.geteBookCode() %>');"<%} %>><%=eb.getButtonCopy() %></a>
            </div>
             <div class="ebookPopup_tip mt5">
	    	<label>
	    		<input class="verticalMid" type="checkbox" value="" id="sendEmailUpdate"> Send me e-mail updates on <%=eb.getTitle() %>
	    	</label>
	        </div>
            <%Object args[] = {eTitle}; %>
            <div class="ebookPopup_tip"><p>By clicking '<%=eb.getButtonCopy() %>', you acknowledge and agree to Global Sources <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/SITE/TERMSOFUSE.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.terms"/></a> <spring:message code="ebook.center.and"/> <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/HELP/PRIVACY.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.privacy"/></a>.</p></div>
    
        </form>
    </div>
  <!--=E Buyer's Guide overlay box -->
      <%
        
    }else if("EGUIDE".equals(eb.getEbookType())&& 
    		!"top/Results".equals(request.getParameter("page"))&&
    		!"wholesale/Results".equals(request.getParameter("page"))&&
    		!"top/TCSResults".equals(request.getParameter("page"))&&
    		!"SupplierIndustries".equals(request.getParameter("page"))){
    	String appUrl2 = (String)request.getAttribute("javax.servlet.forward.request_uri");
   	    if(appUrl2 == null || appUrl2.indexOf(".htm") < 0){
   	   	appUrl2 = "/gsol/GeneralManager?"+URLEncoder.encode(request.getQueryString(),"UTF-8"); 
   	   }

   	 %>

<script type="text/javascript">	 
window.onload = function(){ 
	document.getElementById("closeEguide").onclick = function(){
		setCookie('ebook_close_cookie','ebookClose',3);
		document.getElementById('getEguidePopup').style.display='none';
	}
};
</script>
<!-- style="position: fixed; top: 170px; left: 537px; z-index: 9999999;"  -->
 <div id="getEguidePopup" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>"  class="ebookPopup_SFC <%if(!showEguideFlag){%>none<%}%>"   <%if(!showEguideFlag){%>noAutoShow="true"<%}%> >
 <form onsubmit="return false;" name="eGuidePopuForm" method="post" >
 <input type="hidden" id="eguide_appurl"  name="appurl" value="<%=appUrl2 %>" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" /> 

    <h3 class="tit3"><%=eb.getHeaderCopy().replace("�", "–") %></h3>
    <span id="closeEguide" class="close ui_overlay_close" >close</span>
    <div class="con">
        <div>
        	<img style="margin:-20px 0 0 -50px;" src="<%=eb.getImagePopUpURL()%>" alt="">
        </div>
        <div class="sbox">  
	        <%if (user == null){ %>
                <input class="ebookPopup_txt mr10 ui_input_tip inputTip" tipcls="inputTip" tip="Enter Email Address" type="text" value="Enter Email Address" id="eguidePopup" name="eguideRmail">
             <%} %>
	        
	        <a  href="#" trackValue="Auto" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" class="ebookPopup_btn" <%if(user == null){ %>
              onclick="javascript:downLoadEGuide('<%=defaultHostName + sessionBean.createHref("action=DownloadEBook&eBookCode=" + eb.geteBookCode()) + "&point_id=" + point.getId() + "&source=GSOL_BuyersGuide_GAM" %>' 
              ,document.eGuidePopuForm,'eguidePopup','ebook_close_cookie','ebookClose',3);" <%}else{%> id="DownloadBG"  targetID="getEbookCfm2Popup" 
              onclick="javascript:sendEBookEmail('<%=user.getEmail() %>','<%=eb.geteBookCode() %>');"<%} %>><%=eb.getButtonCopy() %></a>
	    </div>
	    <div class="ebookPopup_tip mt5">
	    	<label>
	    		<input class="verticalMid" type="checkbox" value="" id="sendEmailUpdate"> Send me e-mail updates on <%=point.getName().getValue() %>
	    	</label>
	    </div>
	     <%Object args[] = {eTitle}; %>
        <div class="ebookPopup_tip mt20"><p>By clicking '<%=eb.getButtonCopy() %>', you acknowledge and agree to Global Sources <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/SITE/TERMSOFUSE.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.terms"/></a> <spring:message code="ebook.center.and"/> <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/HELP/PRIVACY.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.privacy"/></a>.</p></div>
    </div>
  </form>  
</div>
   	 
      <%  	    
    }
    else if("EMAG".equals(eb.getEbookType())&& 
    		!"top/Results".equals(request.getParameter("page"))&&
    		!"wholesale/Results".equals(request.getParameter("page"))&&
    		!"top/TCSResults".equals(request.getParameter("page"))&&
    		!"SupplierIndustries".equals(request.getParameter("page"))){
    	
    	String appUrl2 = (String)request.getAttribute("javax.servlet.forward.request_uri");
   	    if(appUrl2 == null || appUrl2.indexOf(".htm") < 0){
   	   	appUrl2 = "/gsol/GeneralManager?"+URLEncoder.encode(request.getQueryString(),"UTF-8"); 
   	   }
			  %>
		<script type="text/javascript">	 
		window.onload = function(){ 
			document.getElementById("closeEmag").onclick = function(){
				setCookie('ebook_close_cookie','ebookClose',3);
				document.getElementById('getEmagPopup').style.display='none';
			}
			/* document.getElementById("sendEmagBtn").onclick = function(){
				document.getElementById('getEmagPopup').style.display='none';
			} */
		};
		</script>
        <!--=S eMag overlay Guide overlay : UIMR#8796 -->
	 	<div id="getEmagPopup" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" class="ebookPopup_SFC <%if(!showEmagFlag){%>none<%}%>" <%if(!showEmagFlag){%>noAutoShow="true"<%}%> style="position: fixed; top: 131px; left: 537px; z-index: 9999999;">
		   <form onsubmit="return false;" name="eMagPopuForm" method="post" >
		    <input type="hidden" id="eguide_appurl"  name="appurl" value="<%=appUrl2 %>" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" /> 
		    <h3 class="tit4"><%=eb.getHeaderCopy().replace("�", "–") %></h3>
		    <span id="closeEmag" class="close ui_overlay_close">close</span>
		    <div class="con">
		        <div>
		        <img style="margin:-23px 0 0 -20px;" src="<%=eb.getImagePopUpURL()%>" alt="" />
		          <%-- <img style="margin:-23px 0 0 -20px;" src="<%=sessionBean.imageSrc("EMAG_sourcing_boxContent.jpg")%>" alt="" /> --%>
		        </div>
		        <div class="sbox">
		        <%if (user == null){ %>
                <input class="ebookPopup_txt mr10 ui_input_tip inputTip" tipcls="inputTip" tip="Enter Email Address" type="text" value="Enter Email Address" id="eguidePopup" name="eguideRmail">
                <%} %>
	         
	           <a  href="#" trackValue="Auto" ebookid="<%=eb.geteBookCode() %>" source="<%=source %>" class="ebookPopup_btn" id="sendEmagBtn" <%if(user == null){ %>
              onclick="javascript:downLoadEGuide('<%=defaultHostName + sessionBean.createHref("action=DownloadEBook&eBookCode=" + eb.geteBookCode()) + "&point_id=" + point.getId() + "&source=GSOL_BuyersGuide_GAM" %>' 
              ,document.eMagPopuForm,'eguidePopup','ebook_close_cookie','ebookClose',3);" <%}else{%> id="DownloadBG"  targetID="getEbookCfm2Popup" 
              onclick="javascript:sendEBookEmail('<%=user.getEmail() %>','<%=eb.geteBookCode() %>');"<%} %>><%=eb.getButtonCopy() %></a>
		        </div>
		        <div class="ebookPopup_tip mt5">
		          <label>
		            <input class="verticalMid" type="checkbox" value="" id="sendEmailUpdate"/> Send me e-mail updates on <%=point.getName().getValue() %>
		          </label>
		        </div>
		        <div class="ebookPopup_tip mt20"><p>By clicking '<%=eb.getButtonCopy() %>', you acknowledge and agree to Global Sources <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/SITE/TERMSOFUSE.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.terms"/></a> <spring:message code="ebook.center.and"/> <a href="<%=enigma.web.util.URLUtil.setStaticURLLanguage("http://"+enigma.web.action.SuperReMap.getHostName("Global Sources",sessionBean.getContext())+"/HELP/PRIVACY.HTM", sessionBean.getContext().getLanguage())%>" target="externalWin"><spring:message code="ebook.center.privacy"/></a>.</p></div>
		    </div>
		  </form>
		</div> 
       <!--=E eMag overlay Guide overlay : UIMR#8796 -->
    	<%
    	
    }
	 

   }
   }
	
	
	
	
	%>  
<%// RSS Box %>
<div id="rss_xpromoTipBox"></div>