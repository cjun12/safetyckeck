(function() {
	toastr['success']("欢迎回来！")
	var token = $.cookie("token");
	var url = "/safe_monitor/Monitor/listAllItem.action";
	var data = {
		token : token
	};
	var items = null;
	$.get(url, data, function(jsonstr) {
		items = JSON.parse(jsonstr);
	});
	var createChart = function() {
		var overview = document.getElementById('overview');
		var overviewChart = echarts.init(overview);
		var option = {
			xAxis : {
				data : [ "HTTP监控", "PING监控", "DNS监控", "SNMP监控" ],
				triggerEvent : true
			},
			legend : {
				data : [ '正常', '异常' ]
			},
			yAxis : [ {
				type : 'value'
			} ],
			tooltip : {
				trigger : 'axis'
			},
			series : [ {
				name : '正常',
				type : 'bar',
				data : [ 1, 4, 2, 1 ],
				itemStyle : {
					normal : {
						color : 'rgb(160, 211, 110)'
					}
				}
			}, {
				name : '异常',
				type : 'bar',
				data : [ 1, 4, 2, 1 ],
				itemStyle : {
					normal : {
						color : 'rgb(251, 110, 82)'
					}
				}
			} ]
		}
		overviewChart.setOption(option)

		overviewChart.on('click', function(param) {
			if (param.componentType == 'xAxis') {
				console.log(param.value);
			}
		});
	}
	$("#date-popover").popover({
		html : true,
		trigger : "manual"
	});
	$("#date-popover").hide();
	$("#date-popover").click(function(e) {
		$(this).hide();
	});

	$("#my-calendar").zabuto_calendar({
		action : function() {

		},
		action_nav : function() {

		},
		legend : [ {
			type : 'text',
			label : "告警",
			badge : "00"
		}, {
			type : "block",
			label : "正常"
		} ]
	});
})();