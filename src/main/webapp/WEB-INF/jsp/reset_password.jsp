
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    
    <title>E-Quality labs</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath}/static/js/alert.js"></script>
     <link href="${pageContext.request.contextPath}/static/css/alert.css" rel = "stylesheet">
    <style type="text/css">
       
.buttons_divider {
    margin-top: 10%;
    margin-bottom: 10%;
    border-bottom: solid #ccc 1px;
}

.sign_up_title {
    text-align: center;
    margin-bottom: 5%;
}

.sign_in_but {
    border-radius: 45%;
    margin-left: 5px
}

.sign_up_form {
    margin-bottom: 30%;
}

.sign_up_form input {
    border-radius: 0px;
}


p {
    text-align: center;
}

#msg {
    margin-top: 1cm;
}

body {
   padding-bottom: 30px;
    background: url('Images/bg.jpg') no-repeat;
    background-attachment: fixed;
    background-image: cover;
    background-size: 100% 100%;

}
.resetPwd{
    margin-top: 10%;
}

.loader-div {
	margin: -210px 0 0 46%;
	border-radius: 2px; /* margin: 290px 0 0 50%;absolute relative */
	display: none;
	opacity: 1.0;
	position: absolute;
}
    */ </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

 

<%-- <div id="Home" class="tabcontent general-form">
    		<div class="tab-container">
     		 <h2><c:out value="${error}"></c:out></h2>
  		  </div>
		</div> --%>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 resetPwd">
    		<form role="form" class="sign_up_form" method="post" action="#">
    			<h2 class="sign_up_title">Reset password</h2>
    			
    			
    			
    			<p>Enter your email address we will sent you the password reset link.</p>
    			<div class="form-group">
    				<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email address" tabindex="4">
    			</div>
    			
    			  <%-- <input type="hidden" id="msg" name="msg" value="${error}"> --%>  
    			 <%-- <c:redirect url="<%= session.getAttribute("error") %>" /> --%>
    			 
    			<%-- <c:out  value='${error}'/>  --%>
    			 
    			 <%-- <c:redirect url="${url}" /> --%>
    			 
    			<%--  // access the session scoped varaibles inside JSP page in two different ways
	<c:out value='${sessionScope["numList"]}' /><br/>
	<c:out value='${sessionScope.error}'/>
	<c:out id="msg" name="msg" value="${requestScope.error}"/>
	 --%>
    			
    			<div class="form-group">
							<label id="resetValidationMessage" style="color: red;" />
						</div>
    			<!-- <div class="row">
    				<div class="col-xs-12 col-md-12"><a href="#" class="btn btn-success btn-block btn-lg" id ="resetSubmit">Reset</a></div>
    			</div> -->
    			
    			
    			<div class="row" >
					<div class="col-xs-12 col-md-12">
                        <input type="submit" id="resetSubmit" name="resetSubmit" class ="btn btn-success btn-block btn-lg" 
                        value="Reset">
					</div>
					</div>
					
				 	<div id="msg" class="msg" style="color: red;display:none;" >
						<c:out value="${error}"></c:out>
					</div>


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
    <p>Successfully send RestPassword to your mail id</p>
   <input type="button" class="btn btn-default" value="Click Here to Proceed" onclick="redirectMyProfile();">
  </div>
 </div> 
   <div class="loader-div">
		<img src="${pageContext.request.contextPath}/static/Images/35.gif" width="45" height="45">
	</div> 
	
<script >
$(document).ready(function(e) {
	
	
	
	/* LOGIN FUNCTION */
	$("#resetSubmit").click(function(e) {
		$("#resetSubmit").attr("disabled", true);
		$(".loader-div").show();
		$("#emailValidationMessage").css('color', 'blue');
		$("#emailValidationMessage").html("Processing request...");
		
		if($("#email").val().trim().length == 0) {
			$("#emailValidationMessage").html("Please enter Email.");
			$("#email").focus();
			e.preventDefault();
			return;
		}
		
		if(!validateEmail($("#email").val())) {
			$("#emailValidationMessage").html("Please enter a valid Email");
			$("#email").focus();
			e.preventDefault();
			return;
		}
	

		var regUserData = {
			
			'email' : $("#email").val(),
		}
		
		$.ajax({
	
			url : 'forgotPassword',
			type : 'POST',
			data : buildQuery(regUserData),
			success : function(result) {
				if (result === "success") {
					//alert("Successfully send RestPassword to your mail id");
					$(".loader-div").hide();
					onClickAlertBox();
					
				}
				else {
					$("#resetSubmit").attr("disabled", false);

					$(".loader-div").hide();
					$("#msg").show();
					
					/* $("#msg").val();
					 var m=document.getElementById("msg").value;
					alert(m);  */
					//alert("User dosn't sent reset password bcz user not exsting user ! Please Register now");
					//$("#emailValidationMessage").css('color','red');
					//$("#emailValidationMessage").html("User dosn't sent reset password bcz user not exsting user ! Please Register now");
				//	window.location.href="reset_password.html";
					
					window.location.href="#";

				}
				window.setTimeout($("#resetSubmit").attr("disabled",false), 5000);
			}
		});
		
	});
	
	
});

function validateEmail(email) {
	return /^[a-z0-9]+([-._][a-z0-9]+)*@([a-z0-9]+(-[a-z0-9]+)*\.)+[a-z]{2,4}$/.test(email)
    && /^(?=.{1,64}@.{4,64}$)(?=.{6,100}$).*/.test(email);
}

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

function redirectMyProfile(){
	window.location.href="login.html";
}
</script> 

</body>
</html>
