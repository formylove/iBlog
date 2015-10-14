				
function $_(id) {
					return document.getElementById(id);
				}
$(function(){
	       		var parser = new UAParser();
	       		r = parser.getResult();
	       		// console.log(r.ua);
	       		// $_('ua_info').innerHTML =s '您的UserAgent：<span class="green">' + r.ua + '</span>';
	       		$_('browser_name').innerHTML = r.browser.name + ' ' + r.browser.major;
	       		$_('browser_version').innerHTML = r.browser.version;
	       		$_('browser_engine').innerHTML = r.engine.name + ' ' + r.engine.version;
	       		$_('system').innerHTML = r.os.name + ' ' + r.os.version;
	       		$_('cpu').innerHTML = r.cpu.architecture;
	       		$_('device').innerHTML = r.device.model + ' ' + r.device.type + ' ' + r.device.vendor;
	       		$_('screen_size').innerHTML = screen.width + 'px X ' + screen.height + 'px';
	       		var d = new Date();
            	var tzOffset = (d.getTimezoneOffset() / 60) + ' Hours';
            	$_('tz_offset').innerHTML = tzOffset;
	       		// console.log(parser.getResult());
				$.post('/include/ip/Ip.inc.php', {'ip': $('#ip_text').text()}, function (data) {
       				var ip = '你的位置应该是是在火星...'
       				if (data.code == 0) {
       					ip = data.data.country + ' ' + data.data.area + ' ' + data.data.region + ' ' + data.data.city + ' ' + data.data.isp;
       				}
       				$('#area_text').text(ip);
       			}, 'json');
});