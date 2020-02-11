<%-- <%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
 <style>
   .btn-primary{width:15%;border-radius:5px;}
 </style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<form method="POST" action="processprouser">
			<table class="table table-striped">
				<thead>
					
				</thead>
				<tbody>
					<c:choose>

						<c:when test="${empty weburls}">
						<script>
						
						
								toggleRunButton();
							</script>
							<span id="urlError">HTTP error fetching
								URL,Status=404.Please enter the valid url.</span>
							<br>

						</c:when>
						<c:otherwise>
							
							<tr>
								<th>List of URL's</th>
							</tr>
							<tr>

								<c:set var="count" value="0" scope="page" />

								<td><c:forEach items="${weburls}" var="item">
										<%--  <span id="checkboxSelection"><input type="checkbox" name="checkbox" /></span>
							   <span id="listOfUrl">${item}</span><br><br>
							   --%>
										<span id="checkboxSelection"> <input type="checkbox"
											name="${count + 1}" value="${item}" /></span>
										<span id="listOfUrl">${item}</span>
										<br>
										<br>

									</c:forEach></td>
							</tr>
						</c:otherwise>
					</c:choose>
					<!-- 					</tr>
 -->				</tbody>

			</table>
			<br>
			<div class="form-group">
				<label id="runValidationMessage" style="color: red;"></label> <input
					type="text" id="checkboxValue" name="checkboxValue"
					style="display: none;" />

			</div>
			<div id="count" style="color: green;"></div>

			<input class="validation_button btn-primary" type="submit"
				id="runSubmit" size="100" value="Run !"  />
		</form>
	</div>
	


	<script type="text/javascript">
$(document).ready(function(e) {

$('#runSubmit').click(function() {
	validate_form(this);
    var sel = $('input[type=checkbox]:checked').map(function(_, el) {
        return $(el).val();
    }).get();
    
 //  alert(sel);
	$("#checkboxValue").val(sel);

var s = document.getElementById('checkboxValue').value;
 //  alert(s);

$.ajax({
	
	url : 'processprouser',
	type : 'POST',
	success : function(result) {
 
		if (result === "success") {
			//alert("inside success");
		window.location.href="index.html";
		}
		else {
			$("#runValidationMessage").css('color','red');
			$("#runValidationMessage").html("Unable to login. Please check inputs or contact support.");
		}
		window.setTimeout($("#runSubmit").attr("disabled",false), 5000);
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


	//var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
	//alert(checkboxes);
	/* for (i = 0; i < checkboxes.length; i++) {
		  checkboxes[i].onclick = function() { //call function on click and send current element as param
			  validate_form(this);
		  }
		} */
	
	function validate_form(elem){
	var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
	alert(checkboxes);
	var limit = 0;
		  if (elem.checked) { //if checked, increment counter
		    limit++;
		  alert(limit);
		  } else {
		    limit--; //else, decrement counter
			  alert(limit);

		  }
for (i = 0; i < checkboxes.length; i++) { 
    if (limit == 26) {
    	alert("inside i ");
      if (!checkboxes[i].checked) {
        checkboxes[i].disabled = true; 
      }
    } else { 

        if (!checkboxes[i].checked) {
          checkboxes[i].disabled = false; 
        }

      }
$('#count').append("<b>"+"No of urls selected "+checkboxes.length+"</b>");
valid = true;

if($('input[type=checkbox]:checked').length == 0)
{
    alert ( "ERROR! Please select at least one checkbox" );
    valid = false;
}

return valid;
}
	}
</script>
<script>
/* function toggleRunButton(){
	alert("inside toggle");
    document.getElementById('runSubmit').style.display = none;
   // document.getElementById('urlError').style.display = 'none';

} */

		</script>
		<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>