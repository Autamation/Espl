<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
<script type="text/javascript">
	function validateUrl(url) {

		var request = new XMLHttpRequest();
		request.open('GET', url, true);
		request.onreadystatechange = function() {
			if ((request.readyState === 4) && request.status === 404) {
				alert("Oh no, URL does not exist!");
				return true;
			}
			/*   else
			
			  alert("inside true block--url is valid");
			  return false; */

		};
		request.send();

	}

	$(document).ready(function(e) {

		$("#validate_uri").click(function(e) {

			var url = document.getElementById('checkuri').value;
			alert("insite naven");
			if (validateUrl(url)) {
				alert("url not valid");
				$("#url_msg").html("Please enter a valid website URL.");
				$("#checkuri").focus();
				e.preventDefault();
				return;
			}

		});

	});

	function submitLoading() {
		$(".loader-div").show();
	}
</script>
<style>
label {
	margin-left: -26px;
}

#checkuri {
	width: 80%;
	margin-left: 10%;
}

.bottomMargin50 {
	margin-top: 50px;
}

.loader-div {
	/* margin: -50px 0 0 38%;
	border-radius: 2px;  */
	/* margin: 290px 0 0 50%; */
	/* display: none;
	opacity: 1.0;
	position: absolute;  */
	display: none;
	width: 100%;
	height: 100%;
	background-color: black;
	opacity: 25%;
	z-index: 9999;
	position: fixed;
	top: 0;
	left: 0;
}

.no-js #loader {
	display: none;
}

.js #loader {
	display: block;
	position: absolute;
	left: 100px;
	top: 0;
}

.checkuri {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background:
		url(http://smallenvelop.com/wp-content/uploads/2014/08/Preloader_11.gif)
		center no-repeat #fff;
}
</style>
</head>

<body>
	<div class="loader-div">
		<img src="/EQualityLabs/static/Images/35.gif" width="75" height="75"
			style="position: absolute; display: block; top: 50%; left: 50%;">
	</div>

	<!-- begin Main -->
	<jsp:include page="header.jsp"></jsp:include>
	<main role="main" aria-label="main section" id="main-content">

		<div>
			<image
				src="${pageContext.request.contextPath}/static/Images/web-accessibility.png"
				class="headImage" alt="header hands typing on keyboard" />
		</div>

		<!-- The example code below will create a two column grid with a medium breakpoint -->
		<section id="page-title">
			<div class="container " role="header and benefits">
				<div class="row">
					<div class="col-md-12">

						<ol class="breadcrumb" role="breadcrumb">
							<li><a href="index.html" title="Home">Home</a></li>

							<li class="active">Testing URL</li>
						</ol>

						<h1 class="">Test your Website</h1>
					</div>
				</div>
			</div>
		</section>

		<form onsubmit="submitLoading()" action="processReqestForFreeuser"
			method="post">
			<section id="boxes" role="features" class="">
				<div id="" class="" style="display: block">
					<div class="row">
						<label class="col-sm-2 col-form-label" for="checkuri"
							style="text-align: -webkit-right;">URL:</label>
						<div class="col-sm-10"
							style="width: 100%; border-radius: 3px; height: 40px;">
							<input type="text" class="form-control" name="domainUrl" style=""
								id="checkuri" title="please enter https format only"
								placeholder="Please Enter the URL" pattern="https?://.+"
								required /><br> <input type="submit"
								class="btn btn-primary btn-lg btn-margin-top"
								style="width: 10%; margin-left: 10%;" name="domainUrl"
								value="Run" id="checkuri" style="width: 10%;"> <span
								id="lblError" style="color: red;"></span>
						</div>
					</div>
				</div>

			</section>

		</form>

		<div class="container bottomMargin50" role="header and benefits">
			<section role="why choose us" class="bottomMargin50">
				<div class="container">
					<header class="text-center">
						<h2>
							We Can <strong>Help Your Business</strong>
						</h2>
						<p class="lead">
							Some of the things we can do to make your business look <strong>great</strong>
						</p>
					</header>
					<div class="row feature-list">
						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-group"></i></span><span
									class="sr-only">group of people Icon</span> Focus Groups
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>

						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-code"></i></span><span
									class="sr-only">code Icon</span> Code Writing
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>

						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-desktop"></i></span><span
									class="sr-only">desktop Icon</span> Responsive Websites
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>


						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-cogs"></i></span><span
									class="sr-only">cogs Icon</span> Admin Panels
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>

						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-info"></i></span><span
									class="sr-only">information Icon</span> Answer Questions
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>

						<div class="col-md-4 col-sm-6 col-xs-12">
							<h3>
								<span aria-hidden="true"><i class="fa fa-user"></i></span><span
									class="sr-only">user Icon</span> Great Support
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit. Lorem ipsum dolor sit amet, consectetur adipiscing metus
								elit.</p>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- build:js scripts/main.js -->
	<!--<script data-main="scripts/main" src="vendor/requirejs/require.js"></script>-->
	<!-- endbuild -->
	<script>
		
	</script>
	<script type="text/javascript"
		src="http://shakedwebdesign.com/plugins/accessibility-menu/accessibilitymenu.js"
		data-language="eng" data-oemsource="accessible+" data-sign="classic"></script>
</body>
</html>