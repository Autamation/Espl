<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

   <!DOCTYPE HTML>
<!--[if lt IE 8]><html class="no-js oldIE" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en-US"><![endif]-->
<!--[if IE 9]><html class="no-js ie9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en-US" class="no-js not-ie"><!--<![endif]-->
<head>
  <style type="text/css">
.modal-backdrop .in {
	opacity: 0.1;
}

#sentence {
	margin-left: 20%;
	margin-top: -22px;
	padding-bottom: 34px;
}
</style>  
    
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${empty weburls}">
						
							<span id="urlError">HTTP error fetching
								URL,Status=404.Please enter the valid url.</span>
							<br>

						</c:if>
		<c:if test="${not empty weburls}">
	
	<div id="sentence">
		<b> We have sent you an email with attached report containing the
			Web accessibility issues . Kindly Please refer it.</b>
	</div>
               <div align="center">
		     <img src="${pageContext.request.contextPath}/static/Images/myPieChart.png" alt="piChartImage" id="pieImage" title="" />
				</c:if>
	</div><br><br>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>