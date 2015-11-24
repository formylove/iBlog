function redLabel(){
	if($("div[name='iterm']").size()>1){
		$("div[name='iterm']").last().remove();
	}
	if($("div[name='iterm']").size() == 1){
		$("#reduce").hide();
	}
}
function addLabel(me){
		var she = $('#iterm').first().clone();
		she.children().first().val("");
		me.before(she);
		if($("div[name='iterm']").size() == 2){
			$("#reduce").show();
		}
		she.children().first().focus();
}
function clearTimeBox(){
	var she = $('#iterm').clone();
	she.children().first().val("");
	$('div[name=iterm]').remove();
	$('#operate').before(she);
	$("#result").hide();
}
function getDepartureTime(){
	var sum = 0;
	$("input[name=effort]").each(function (i){
		sum += Number($(this).val()) ;
		});
	var departureTime = advanse('2015-10-23 ' + $("#meet").val(),sum);
	$("#result").show().find("#resultValue").html("<font color='red' size='4px'>" + departureTime.substr(2,departureTime.length - 5) + "</font>");
}
function advanse(dateTime,advance){ 
    var t=new Date(dateTime); 
    t.setMinutes(t.getMinutes()-advance); 
    return t.toLocaleTimeString(); 
  } 
$(
	function(){  
		document.onkeydown = function()  
		{  
			var oEvent = window.event;  
			if (oEvent.keyCode == 65 && oEvent.ctrlKey) {  
				addLabel($('#operate'));
			}  
			if (oEvent.keyCode == 81 && oEvent.ctrlKey) {  
				redLabel();
			}  
			if (oEvent.keyCode == 13) {  
				getDepartureTime();
			}  
		}  
	}  
);
