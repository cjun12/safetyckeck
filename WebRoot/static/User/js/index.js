var UserIndex = {
	loadEcharts : function(token) {
		var url = "/safe_monitor/Monitor/listAllItem.action";
		var data = {
			token : token
		};
		$.get(url, data, function(result) {
			var normal = [ result['http'][0], result['ping'][0],
					result['dns'][0], 0 ]
			var exception = [ result['http'][1], result['ping'][1],
					result['dns'][1], 0 ]
			var data = {
				normal : normal,
				exception : exception
			}
			createChart(data)
		});

		var createChart = function(result) {
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
					type : 'value',
					minInterval : 1,
					min:0
				} ],
				tooltip : {
					trigger : 'axis'
				},
				series : [ {
					name : '正常',
					type : 'bar',
					data : result['normal'],
					itemStyle : {
						normal : {
							color : 'rgb(160, 211, 110)'
						}
					}
				}, {
					name : '异常',
					type : 'bar',
					data : result['exception'],
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
	},
	loadCalendar : function() {
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
	},
	loadMessage : function(token) {

	}
};
(function (){
	toastr['success']("欢迎回来！")
	var token = $.cookie("token");
	UserIndex.loadEcharts(token);
	UserIndex.loadCalendar();
})()


