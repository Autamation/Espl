<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>E-Quality Labs</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath}/static/js/alert.js"></script>
     <link href="${pageContext.request.contextPath}/static/css/alert.css" rel = "stylesheet">
    <style type="text/css">
        /* Credit to bootsnipp.com for the css for the color graph */
.colorgraph {
  height: -3px;
  border-top: -10px;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
fieldset > h2{
	margin-top: 63px;
}
.navbar-fixed-top{
	top:-44px;
}
.navbar-brand  {
	margin-top: -10px;
	margin-left: -10px;
}
/* body{
 background: url('${pageContext.request.contextPath}/static/Images/bg.jpg') no-repeat;
    background-attachment: fixed;
    background-image: cover;
    background-size: 100% 100%;
} */

.log-wrapper .navbar-default{border:0;}
.log-wrapper .navbar{background:#000; margin-bottom:0;}
.log-wrapper .log-holder{position:relative; clear:both; padding:55px 0;}
.log-wrapper .log-gray{position:absolute; width:100%; height:100%; left:0; top:0; background:#000; opacity:0.4;}
.log-wrapper .navbar-default .navbar-nav>li>a{color:#eee;}
.log-wrapper h2{color:#00d0ff; margin-top:50px; margin-bottom:0;}
.log-wrapper h2 small{color:#fff; font-size:50%;}
.log-wrapper .colorgraph{height:5px;}
.log-wrapper .form-group label, .agree{color:#ddd;}
.agree a{color:#eee;}
.agree a:hover{color:#fff;}
.log-wrapper .form-group.gender{color:#fff; font-size: 16px; margin-top:13px;}
.log-wrapper .form-group.gender input[type="radio"]{margin-left:30px;}
.log-wrapper .form-control{border-color:#333;}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
   
</head>
<body>
<div class="log-wrapper">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <hr class="colorgraph colorgraph-header">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/static/Images/equalitylabblue.png" alt="Go to Equality Home!" width="200" height="42" border="0"></a>

            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="main-navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/index.html"><i class="glyphicon glyphicon-arrow-left"></i> Back to Home</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>	
   </div> 
<div class="container">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form  action="makePayment" method="post" >
			<fieldset>
						<h2>Payment Details</h2>
						<hr class="colorgraph">
						<div>
					 		<input type="hidden" id="clientaccount_email" name="clientaccount_email" value="${userDetails.email}">
					</div>
						<div class="form-group">
							<input type="text" name="totalAmount" id="totalAmount"
								class="form-control input-lg"  placeholder="totalAmount">
								
						</div>
						<div class="form-group">
							<input type="text" name="paymentType" id="paymentType"
								class="form-control input-lg" placeholder="paymentType">
						</div>
						<div class="form-group">
							<label id="paymentValidationMessage" style="color: red;"></label>
						</div>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="submit" id="paymentSubmit" name="paymentSubmit"
									class="btn btn-primary btn-block btn-lg" value="Proceed to Pay">
							</div>

						</div>
					</fieldset>
		</form>
	</div>
</div>

</div>

<!-- The Modal -->
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content close-button-div">
  	    <span class="close">&times;</span>
   </div>
 <div class="modal-content content-div" style="font-size:1.0rem;background-color:#ffffff;">
    <p>Payment successfully completed,now you can tests the url</p>
   <input type="button" class="btn btn-default" value="Click Here to Proceed" onclick="redirectToTest();">
  </div>
 </div> 

<script>
$(document).ready(function(e) {
	

	$("#paymentSubmit").click(function(e) {

		var paymentDetails = {
			'totalAmount' : $("#totalAmount").val(),
			'paymentType' : $("#paymentType").val(),
			'clientaccount_email':$("#clientaccount_email").val()
		}
		
		
		$.ajax({
	
			url : 'makePayment',
			type : 'POST',
			data : buildQuery(paymentDetails),
			success : function(result) {
         
				if (result === "success") {
					onClickAlertBox();
					window.location.href="prousertest.html";
				}
				else {
					$("#paymentValidationMessage").css('color','red');
					$("#paymentValidationMessage").html("payment is not done. Please check with your bank.");
				}
				window.setTimeout($("#paymentSubmit").attr("disabled",false), 5000);
			}
		});
		
	});
	
	
});



function buildQuery(obj) {
	var Result = '';
	if (typeof (obj) == 'object') {
		jQuery.each(obj, function(key, value) {
			Result += (Result) ? '&' : '';
			if (typeof (value) == 'object' && value.length) {
				for (var i = 0; i < value.length; i++) {
					Result += [ key + '[]', encodeURIComponent(value[i]) ].join('=');
				}
			} else {
				Result += [ key, encodeURIComponent(value) ].join('=');
			}
		});
	}
	return Result;
}

function redirectToTest(){
	window.location.href="prousertest.html";
}

</script>
</body>
</html>
