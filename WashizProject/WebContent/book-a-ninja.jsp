<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  
<title>Washiz-Dry Cleaning &amp; Laundry delivered to your door!</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="images/icons/favicon.ico">
<link rel="apple-touch-icon" href="images/icons/favicon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/icons/favicon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/icons/favicon-114x114.png">
<!--Loading bootstrap css-->
<link type="text/css" rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
<link type="text/css" rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
<link type="text/css" rel="stylesheet"
	href="styles/jquery-ui-1.10.4.custom.min.css">
<link type="text/css" rel="stylesheet"
	href="styles/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="styles/animate.css">
<link type="text/css" rel="stylesheet" href="styles/all.css">
<link type="text/css" rel="stylesheet" href="styles/main.css">
<link type="text/css" rel="stylesheet"
	href="styles/style-responsive.css">
<link type="text/css" rel="stylesheet"
	href="styles/zabuto_calendar.min.css">
<link type="text/css" rel="stylesheet" href="styles/pace.css">
<link type="text/css" rel="stylesheet"
	href="styles/jquery.news-ticker.css">
</head>
<body>

	<%
		if (session.getAttribute("user") != null) {
	%>


	<div>
		<!--BEGIN THEME SETTING-->

		<!--END THEME SETTING-->
		<!--BEGIN BACK TO TOP-->
		<a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
		<!--END BACK TO TOP-->
		<!--BEGIN TOPBAR-->
		<div id="header-topbar-option-demo" class="page-header-topbar">
			<nav id="topbar" role="navigation" style="margin-bottom: 0;"
				data-step="3" class="navbar navbar-default navbar-static-top">
				<div class="navbar-header">
					<button type="button" data-toggle="collapse"
						data-target=".sidebar-collapse" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a id="logo" href="index.html" class="navbar-brand"><span
						class="fa fa-rocket"></span><span class="logo-text">Washiz</span><span
						style="display: none" class="logo-text-icon">µ</span></a>
				</div>
				<div class="topbar-main">
					<a id="menu-toggle" href="#" class="hidden-xs"><i
						class="fa fa-bars"></i></a>

					<div class="news-update-box hidden-xs">
						<span class="text-uppercase mrm pull-left text-white">News:</span>
						<ul id="news-update" class="ticker list-unstyled">
							<li>Washiz</li>
							<li>Dry Cleaning &amp; Laundry delivered to your door!</li>
						</ul>
					</div>
					<ul class="nav navbar navbar-top-links navbar-right mbn">

						<li class="dropdown topbar-user"><a data-hover="dropdown"
							href="#" class="dropdown-toggle"> <img
								src="images/avatar/48.jpg" alt=""
								class="img-responsive img-circle" /> <span class="hidden-xs"><%=session.getAttribute("fname")%>&nbsp;<%=session.getAttribute("lname")%>
							</span>&nbsp;<span class="caret"></span></a>
							<ul class="dropdown-menu dropdown-user pull-right">
								<li><a href="Washiz.do?submit=viewprofile"><i
										class="fa fa-user"></i>My Profile</a></li>
								<li><a href="Washiz.do?submit=viewaddresses"><i
										class="fa fa-calendar"></i>Adresses</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i>Redeem
										Coupons</a></li>
								<li><a href="logout.jsp"><i class="fa fa-key"></i>Log
										Out</a></li>
							</ul></li>

					</ul>
				</div>
			</nav>

		</div>
		<!--END TOPBAR-->
		<div id="wrapper">
			<!--BEGIN SIDEBAR MENU-->
			<nav id="sidebar" role="navigation" data-step="2"
				data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
				data-position="right" class="navbar-default navbar-static-side">
				<div class="sidebar-collapse menu-scroll">
					<ul id="side-menu" class="nav">

						<div class="clearfix"></div>
						<li><a href="dashboard.jsp"><i
								class="fa fa-tachometer fa-fw">
									<div class="icon-bg bg-orange"></div>
							</i><span class="menu-title">Dashboard</span></a></li>

						<li class="active"><a href="Washiz.do?submit=getaddressname"><i
								class="fa fa-desktop fa-fw">
									<div class="icon-bg bg-pink"></div>
							</i><span class="menu-title">Book A Ninja</span></a></li>
						<li><a href="Washiz.do?submit=viewaddresses"><i
								class="fa fa-send-o fa-fw">
									<div class="icon-bg bg-green"></div>
							</i><span class="menu-title">Address</span></a></li>
						<li><a href="Washiz.do?submit=viewcardinfo"><i
								class="fa fa-edit fa-fw">
									<div class="icon-bg bg-violet"></div>
							</i><span class="menu-title">Credit Card</span></a></li>
						<li><a href="tarifs.jsp"><i class="fa fa-th-list fa-fw">
									<div class="icon-bg bg-blue"></div>
							</i><span class="menu-title">Tarifs</span></a></li>
						<li><a href="Washiz.do?submit=orderhistory"><i
								class="fa fa-database fa-fw">
									<div class="icon-bg bg-red"></div>
							</i><span class="menu-title">Historical orders</span></a></li>
						<li><a href="Washiz.do?submit=viewprofile"><i
								class="fa fa-file-o fa-fw">
									<div class="icon-bg bg-yellow"></div>
							</i><span class="menu-title">Profile</span></a></li>
						<li><a href="logout.jsp"><i class="fa fa-gift fa-fw">
									<div class="icon-bg bg-grey"></div>
							</i><span class="menu-title">Log Off</span></a>
					</ul>

				</div>
			</nav>
			<!--END SIDEBAR MENU-->

			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">
							Welcome
							<%=session.getAttribute("fname")%>&nbsp;<%=session.getAttribute("lname")%></div>
					</div>
					<ol class="breadcrumb page-breadcrumb pull-right">
						<li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.jsp">Home</a>&nbsp;&nbsp;<i
							class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
						<li class="hidden"><a href="#">Dashboard</a>&nbsp;&nbsp;<i
							class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
						<li class="active">Book A Ninja</li>
					</ol>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
                    <div id="tab-general">
                        <div class="row mbl">
                            <div class="col-lg-12">
                                
                                            <div class="col-md-12">
                                                <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                                </div>
                                            </div>
                                
                            </div>

                            <div class="col-lg-12">
                            <div class="row">
                    <div class="col-lg-6">
</div></div></div></div></div>
				<div class="thumbnail">
					<img src="img/1.png" style="width: 794px; height: 108px;"
						alt="abcd" data-src="">
				</div>

				<div style="width: 50%; height: 400px; float: left">

					<div class="panel panel-orange"
						style="width: 430px; margin-left: 60px; margin-top: 20px">
						<div class="panel-heading">Pick Up</div>
						<div class="panel-body pan">

							<form action="book-a-ninja2.jsp" method="post">

								<div class="form-body pal">

									<div class="form-group">
										<select class="form-control" name="pickupaddress" required="required">
											<option >Select your Address</option>
											<c:forEach var="data" items="${addressnamedata}">
												<option value="${data.name}">${data.name}</option>
											</c:forEach>
										</select>
									</div>

								</div>
								<div class="form-body pal">

									<div class="form-group">
										<input type="text" id="to" name=pickupdate placeholder="Select Pick-up Date(Click Here)"
										 class="form-control" required="required" />
									</div>

								</div>

								<div class="form-body pal">

									<div class="form-group">
										<select class="form-control" name="pickuptime" required="required">
											<option>Pick Up Time</option>
											<option value="12:00-1:00 PM">12:00-1:00 PM</option>
											<option value="1:00-2:00 PM">1:00-2:00 PM</option>
											<option value="2:00-3:00 PM">2:00-3:00 PM</option>
											<option value="3:00-4:00 PM">3:00-4:00 PM</option>
										</select>
									</div>

								</div>
						</div>
					</div>



				</div>





				<div style="width: 50%; height: 400px; float: left">
					<div class="panel panel-orange"
						style="width: 430px; margin-left: 60px; margin-top: 20px">
						<div class="panel-heading">Delivery Up</div>
						<div class="panel-body pan">
							<div class="form-body pal">

								<div class="form-group">
									<select class="form-control" name="deliveryaddress" required="required">
										<option>Select your Address</option>
										<c:forEach var="data" items="${addressnamedata}">
											<option value="${data.name}">${data.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>
							<div class="form-body pal">

								<div class="form-group">
									<input type="text" name="deliverydate" placeholder="Select Delivery Date(Click Here)"
									id="from" class="form-control" required="required"/>
								</div>

							</div>

							<div class="form-body pal">

								<div class="form-group">
									<select class="form-control" name="deliverytime" required="required">
										<option>Delivery Time</option>
										<option value="12:00-1:00 PM">12:00-1:00 PM</option>
										<option value="1:00-2:00 PM">1:00-2:00 PM</option>
										<option value="2:00-3:00 PM">2:00-3:00 PM</option>
										<option value="3:00-4:00 PM">3:00-4:00 PM</option>
									</select>
								</div>

							</div>

						</div>
					</div>




				</div>



				<center>
					<div class="form-actions text-right pal">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</center>
				</form>
				<%
					} else {
						response.sendRedirect("signin.jsp");
					}
				%>
				<br> <br> <br>


				<!--END CONTENT-->
				<!--BEGIN FOOTER-->
				<!--          <div id="footer">
                    <div class="copyright">
                        <a href="">2014 Â© WashIz</a></div>
                </div>
        -->
				<!--END FOOTER-->
			</div>
			<!--END PAGE WRAPPER-->
		</div>
	</div>
	<script src="script/jquery-1.10.2.min.js"></script>
	<script src="script/jquery-migrate-1.2.1.min.js"></script>
	<script src="script/jquery-ui.js"></script>
	<script src="script/bootstrap.min.js"></script>
	<script src="script/bootstrap-hover-dropdown.js"></script>
	<script src="script/html5shiv.js"></script>
	<script src="script/respond.min.js"></script>
	<script src="script/jquery.metisMenu.js"></script>
	<script src="script/jquery.slimscroll.js"></script>
	<script src="script/jquery.cookie.js"></script>
	<script src="script/icheck.min.js"></script>
	<script src="script/custom.min.js"></script>
	<script src="script/jquery.news-ticker.js"></script>
	<script src="script/jquery.menu.js"></script>
	<script src="script/pace.min.js"></script>
	<script src="script/holder.js"></script>
	<script src="script/responsive-tabs.js"></script>
	<script src="script/jquery.flot.js"></script>
	<script src="script/jquery.flot.categories.js"></script>
	<script src="script/jquery.flot.pie.js"></script>
	<script src="script/jquery.flot.tooltip.js"></script>
	<script src="script/jquery.flot.resize.js"></script>
	<script src="script/jquery.flot.fillbetween.js"></script>
	<script src="script/jquery.flot.stack.js"></script>
	<script src="script/jquery.flot.spline.js"></script>
	<script src="script/zabuto_calendar.min.js"></script>
	<script src="script/index.js"></script>
	<!--LOADING SCRIPTS FOR CHARTS-->
	<!--CORE JAVASCRIPT-->
	<script src="script/main.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function(){
      $("#to").datepicker({ dateFormat: 'yy-mm-dd' });
      $("#from").datepicker({ dateFormat: 'yy-mm-dd' }).bind("change",function(){
          var minValue = $(this).val();
          minValue = $.datepicker.parseDate("yy-mm-dd", minValue);
          minValue.setDate(minValue.getDate()+1);
          $("#to").datepicker( "option", "minDate", minValue );
      })
  });
  </script>
</body>
</html>
