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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Web服务安全检测系统</title>

<!-- Bootstrap Core CSS -->
<link href="./static/Home/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="./static/Home/css/landing-page.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="./static/Home/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://cdn.bootcss.com/fullPage.js/2.9.3/jquery.fullpage.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">弹出导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav" href="#">Web服务安全检测系统</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#index">首页</a></li>
					<li><a href="#introduce">介绍</a></li>
					<li><a href="#contact">联系我们</a></li>
				</ul>
				<div class="navbar-form navbar-left">
					<button id="login" class="btn btn-primary">进入控制台</button>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><s:if test="#session.user==null">
							<a id="regist" href="#">注册</a>
						</s:if> <s:else>
							<a id="exit" href="/safe_monitor/User/logout.action">退出</a>
						</s:else></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<div id="fullpage">
		<!-- Header -->
		<div class="intro-header section">
			<div class="container">

				<div class="row">
					<div class="col-lg-12">
						<div class="intro-message">
							<h1>Web服务安全检测系统</h1>
							<h3>一个具备HTTP，PING，DNS检测项的监控系统</h3>
							<hr class="intro-divider">
							<ul class="list-inline intro-social-buttons">
								<li><a href="" class="btn btn-default btn-lg"> <i
										class="fa fa-desktop fa-fw"></i> <span class="network-name">HTTP</span>
								</a></li>
								<li><a
									href="https://github.com/IronSummitMedia/startbootstrap"
									class="btn btn-default btn-lg"> <i class="fa fa-star fa-fw"></i>
										<span class="network-name">PING</span>
								</a></li>
								<li><a href="#" class="btn btn-default btn-lg"> <i
										class="fa fa-cloud fa-fw"></i> <span class="network-name">DNS</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container -->

		</div>
		<!-- /.intro-header -->

		<!-- Page Content -->
		<div class="section">
			<div class="content-section-a slide">

				<div class="container">
					<div class="row">
						<div class="col-lg-5 col-sm-6">
							<hr class="section-heading-spacer">
							<div class="clearfix"></div>
							<h2 class="section-heading">HTTP检测</h2>
							<p class="lead">检测网站特定网页的可访问性</p>
						</div>
						<div class="col-lg-5 col-lg-offset-2 col-sm-6">
							<img class="img-responsive" src="./static/Home/img/ipad.png"
								alt="">
						</div>
					</div>

				</div>
				<!-- /.container -->

			</div>
			<!-- /.content-section-a -->

			<div class="content-section-b slide">

				<div class="container">

					<div class="row">
						<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
							<hr class="section-heading-spacer">
							<div class="clearfix"></div>
							<h2 class="section-heading">PING检测</h2>
							<p class="lead">检测网站的可访问行</p>
						</div>
						<div class="col-lg-5 col-sm-pull-6  col-sm-6">
							<img class="img-responsive" src="./static/Home/img/dog.png"
								alt="">
						</div>
					</div>

				</div>
				<!-- /.container -->

			</div>
			<!-- /.content-section-b -->

			<div class="content-section-a slide">

				<div class="container">

					<div class="row">
						<div class="col-lg-5 col-sm-6">
							<hr class="section-heading-spacer">
							<div class="clearfix"></div>
							<h2 class="section-heading">DNS检测</h2>
							<p class="lead">检测指定域名的是否可以解析成所期待的IP地址</p>
						</div>
						<div class="col-lg-5 col-lg-offset-2 col-sm-6">
							<img class="img-responsive" src="./static/Home/img/phones.png"
								alt="">
						</div>
					</div>

				</div>
				<!-- /.container -->
			</div>
		</div>
		<!-- /.content-section-a -->

		<footer class="section">
			<div class="banner">
				<div class="container">

					<div class="row">
						<div class="col-lg-3 col-lg-offset-1">
							<h2>服务器监控：</h2>
						</div>
						<div class="col-lg-8">
							<ul class="list-inline banner-social-buttons">
								<li><a href="https://twitter.com/SBootstrap"
									class="btn btn-default btn-lg"><i
										class="fa fa-desktop fa-fw"></i> <span class="network-name">服务器系统信息</span></a>
								</li>
								<li><a
									href="https://github.com/IronSummitMedia/startbootstrap"
									class="btn btn-default btn-lg"><i class="fa fa-star fa-fw"></i>
										<span class="network-name">服务器CPU负载信息</span></a></li>
								<li><a href="#" class="btn btn-default btn-lg"><i
										class="fa fa-cloud fa-fw"></i> <span class="network-name">服务器存储信息</span></a>
								</li>
							</ul>
						</div>
					</div>

				</div>
				<!-- /.container -->

			</div>
			<!-- /.banner -->

			<!-- Footer -->
			<div style="width:100%;position:absolute;bottom:10px">
				<ul class="list-inline" style="text-align:center;">
					<li><a href="#">首页</a></li>
					<li class="footer-menu-divider">&sdot;</li>
					<li><a href="#introduce">介绍</a></li>
					<li class="footer-menu-divider">&sdot;</li>
					<li><a href="#contact">联系我们</a></li>
				</ul>
				<p class="copyright text-muted small" style="text-align:center;">Copyright
					&copy; Your Company 2017. All Rights Reserved</p>
			</div>
		</footer>
	</div>
	<div id="loginModal" class="modal fade" tabindex="-1" role="dialog">
		<form action="./User/login.action" method="post">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header bg-success">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">登录</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="username">用户名</label> <input type="text"
								class="form-control" id="username" placeholder="用户名"
								name="u.username">
						</div>
						<div class="form-group">
							<label for="password">密码</label> <input type="password"
								class="form-control" id="password" placeholder="密码"
								name="u.password">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">登录</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<!-- /.modal-dialog -->
			</div>
		</form>
	</div>
	<!-- /.modal -->
	<div id="registModal" class="modal fade" tabindex="-1" role="dialog">
		<form action="./User/regist.action" method="post">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">注册</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="control-label" for="username">用户名</label> <input
								type="text" class="form-control" id="username" placeholder="用户名"
								name="u.username" aria-describedby="userTip"> <span
								id="userTip" class="help-block"></span>
						</div>
						<div class="form-group">
							<label class="control-label" for="password">密码</label> <input
								type="password" class="form-control" id="password"
								placeholder="密码" name="u.password"><span id="userTip"
								class="help-block"></span>
						</div>
						<div class="control-label" class="form-group">
							<label for="confirm">确认密码</label> <input type="password"
								class="form-control" id="confirm" placeholder="密码"
								name="confirm"><span id="userTip" class="help-block"></span>
						</div>
						<div class="control-label" class="form-group">
							<label class="control-label" for="email">邮箱</label> <input
								type="email" class="form-control" id="email" placeholder="邮箱"
								name="u.email"><span id="userTip" class="help-block"></span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">注册</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<!-- /.modal-dialog -->
			</div>
		</form>
	</div>
	<!-- /.modal -->
	<!-- jQuery -->
	<script src="./static/Home/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="./static/Home/js/bootstrap.min.js"></script>

	<script
		src="http://cdn.bootcss.com/fullPage.js/2.9.3/vendors/scrolloverflow.min.js"></script>
	<script
		src="http://cdn.bootcss.com/fullPage.js/2.9.3/vendors/jquery.easings.min.js"></script>
	<script
		src="http://cdn.bootcss.com/fullPage.js/2.9.3/jquery.fullpage.min.js"></script>
	<script
		src="http://cdn.bootcss.com/fullPage.js/2.9.3/jquery.fullpage.extensions.min.js"></script>
	<script
		src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="./static/Home/js/index.js"></script>
</body>

</html>