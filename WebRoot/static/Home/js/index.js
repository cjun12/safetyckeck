$(function() {
	if($("#regist").length>0){
        $.cookie('token',null,{expires: -1,path: '/'}); 
	};
	
	$('#login').on('click', function() {
		if (!$.cookie('token')) {
			$("#loginModal").modal();
		} else {
			location.href = "/safe_monitor/UserCenter/index.action"
		}
	});
	$('#regist').on('click', function() {
		$("#registModal").modal();
	})
	$('#fullpage').fullpage({
		controlArrowColor : "rgba(48,48,48,0.5)",
		anchors : [ "index", "introduce", "contact" ],
		paddingTop : 50
	});
});