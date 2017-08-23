/**
 * 
 */
var AjaxUtil = function(url, arrParams, method, aSync) {
	var AjaxUtil = function(url, arrParams, nethod, aSync) {
		this.fAction = url;
		this.fMethod = method ? method : "get";
		var params = "?action=LOGIN&id=" + encodeURIComponent(userid);
		this.fASync = aSync ? aSync : true;
		xmlHttpObj.onreadystatechange = function() {
			if (xmlHttpObj.readyState == 4 && xmlHttpObj.status == 200) {
				var result = decodeURIComponent(xmlHttpObj.responseText);
				if (result == "success") {
					location.href = "../user/welcome.jsp"
				} else {
					alert(result);
				}
			}
		}
	}
	xmlHttpObj.open(method, url + params, sync);
	if (method == "post") {
		xmlHttpObj.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
	}
	xmlHttpObj.send(params);
}