/**
 * 
 */

var Detail = {
	init : function() {
		toastr.options['positionClass']="toast-top-center";
		$(".enable").bootstrapSwitch({
		        onText:"启动",  
		        offText:"停止",
		        onSwitchChange:function(event){
		        	var tr = $(this).closest("tr")
		        	var url="/safe_monitor/Monitor/update.action";
		        	var itemId=tr.data("itemid");
		        	var data={
		        			"item.id":itemId,
		        			"item.enabled":this.checked
		        	};
		        	var isSuccess=false;
		        	$.ajax({
		        		url:url,
		        		async: false,
		        		data:data,
		        		success:function(){
		        			isSuccess=true;
		        			toastr["success"]("更改成功");
		        		},
		        		error:function(){
		        			toastr["error"]("更改失败");
		        		}
		        	})
		        	if(!isSuccess){
		        		return false;
		        	}
		        }
		    }
		);
	}
};

$(function(){
	Detail.init();
})