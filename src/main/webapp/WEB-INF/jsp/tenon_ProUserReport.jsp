<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFSheet"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFRow "%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFCell"%>
<%@ page import="java.text.SimpleDateFormat "%>;

<!DOCTYPE html>
<html lang="en">
<!DOCTYPE HTML>
<!--[if lt IE 8]><html class="no-js oldIE" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en-US"><![endif]-->
<!--[if IE 9]><html class="no-js ie9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-US" class="no-js not-ie">
<!--<![endif]-->

<head>

<style>
  .btn-success{margin-left:38%;color:#fff;}
.btn-success > a{color:#fff;}

#sentence {
	margin-left: 20%;
	margin-top: -22px;
	padding-bottom: 34px;
}
</style>    

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="sentence">
		<b> We have sent you an email with attached report containing the
			Web accessibility issues . Kindly Please refer it.</b>
	</div>
	 <div align="center">
		     <img src="${pageContext.request.contextPath}/static/Images/BarChartReport.png" alt="barImage" id="barImage" title="" />
	
	</div>
	<br><br>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>