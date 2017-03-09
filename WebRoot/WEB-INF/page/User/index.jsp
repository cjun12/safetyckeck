<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>控制台</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="http://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link
	href="http://cdn.bootcss.com/responsive-nav.js/1.12/responsive-nav.min.css"
	rel="stylesheet">
<link
	href="http://cdn.bootcss.com/zabuto_calendar/1.2.1/zabuto_calendar.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./static/User/css/style.css">
<!--[if lt IE 9]>	
		<script src="http://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<section id="container">
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="导航条"></div>
			</div>
			<a href="index.html" class="logo"><b>控制台</b></a>
			<div class="nav notify-row">
				<ul class="nav top-menu">
					<li class="dropdown"><a data-toggle="dropdown"
						href="index.html#" class="dropdown-toggle"> <i
							class="fa fa-envelope-o"></i> <span class="badge bg-theme">4</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<li class="notify-arrow notify-arrow-green"></li>
							<li>
								<p class="green">你有5条新消息</p>
							</li>
							<li><a href="index.html#"> <span class="subject">
										<span class="from">监控项</span> <span class="time">时间</span> <span
										class="message">具体消息</span>
								</span>
							</a></li>
							<li><a href="index.html#">See all messages</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><s:a cssClass="logout" action="logout" namespace="/User">退出</s:a></li>
				</ul>
			</div>
		</header>
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">
						<a href="profile.html"><img
							src="./static/User/img/default.jpg" class="img-circle" width="60"></a>
					</p>
					<h5 class="centered">
						<s:property value="#session.user.username" />
					</h5>

					<li class="mt"><a class="active" href="index.html"> <i
							class="fa fa-dashboard"></i> <span>概览</span>
					</a></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>监控</span>
					</a>
						<ul class="sub">
							<li><a href="calendar.html">Calendar</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="todo_list.html">Todo List</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>告警</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>历史</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>设置</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>用户中心</span>
					</a></li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-9">
						<div class="row mt">
							<div class="col-lg-6">
								<div class="panel panel-primary">
									<div class="panel-heading">监控项概述</div>
									<div class="panel-body">
										<div id="overview" style="width:100%;height:250px;"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										当前告警事件<a href="">【当前共有 N 个告警事件】</a>
									</div>
									<div class="panel-body">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>监控对象</th>
													<th>类型</th>
													<th>异常信息</th>
													<th>发生时间</th>
													<th>持续时间</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="row mt">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										网站监控<a href="">【当前共添加了 N 个网站监控】</a>
									</div>
									<div class="panel-body">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>监控对象</th>
													<th>类型</th>
													<th>响应时间</th>
													<th>访问成功率</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="row mt">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										服务器监控 <a href="">【当前共添加了 0 台服务器】</a>
									</div>
									<div class="panel-body">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>服务器</th>
													<th>系统</th>
													<th>采集状态</th>
													<th>系统进程</th>
													<th>内存使用</th>
													<th>根分区使用</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
												<tr>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
													<td>test</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 ds">
						<h3>通知</h3>
						<div class="desc">
							<div class="thumb">
								<span class="badge bg-theme"> <i class="fa fa-clock-o"></i>
								</span>
							</div>
							<div class="details">
								<p>
									<muted>2 Minutes Ago</muted>
									<br /> <a href="#">James Brown</a> subscribed to your
									newsletter.<br />
								</p>
							</div>
						</div>
						<h3>成员</h3>
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="" width="35px" height="35px">
							</div>
							<div class="details">
								<p>
									<a href="#">Marcel Newman</a><br />
									<muted>Available</muted>
								</p>
							</div>
						</div>
						<div id="calendar" class="mb">
							<div class="panel green-panel no-margin">
								<div class="panel-body">
									<div id="date-popover" class="popover top"
										style="cursor: pointer; display: block; margin-left: 33%; margin-top: -50px; width: 175px;">
										<div class="arrow"></div>
										<h3 class="popover-title" style="display: none;"></h3>
										<div id="date-popover-content" class="popover-content"></div>
									</div>
									<div id="my-calendar" style="color:#333"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
		<footer class="site-footer">
			<div class="text-center">
				2017 <a href="" target="_blank">web服务安全监控系统</a> <a
					href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
	</section>
	<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/moment.js/2.17.1/moment.js"></script>
	<script
		src="http://cdn.bootcss.com/zabuto_calendar/1.2.1/zabuto_calendar.min.js"></script>
	<script src="http://cdn.bootcss.com/toastr.js/latest/js/toastr.min.js"></script>
	<script src="http://cdn.bootcss.com/echarts/3.4.0/echarts.min.js"></script>
	<script
		src="http://cdn.bootcss.com/jquery-scrollTo/2.1.2/jquery.scrollTo.min.js"></script>
	<script
		src="http://cdn.bootcss.com/jquery.nicescroll/3.6.8/jquery.nicescroll.min.js"></script>
	<script
		src="http://cdn.bootcss.com/responsive-nav.js/1.12/responsive-nav.min.js"></script>
	<script src="./static/User/js/jquery.cookie.js"></script>
	<script src="./static/User/js/jquery.hoverIntent.minified.js"></script>
	<script src="./static/User/js/jquery.dcjqaccordion.2.7.min.js"></script>
	<script src="./static/User/js/common-scripts.js"></script>
	<script type="text/javascript" src="./static/User/js/index.js"></script>
</body>
</html>