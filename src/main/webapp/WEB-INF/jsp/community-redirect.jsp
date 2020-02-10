<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Quality Labs</title>
<style>
 .community-body{
   background-color: #f2f2f2;
 }
</style>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
   <div class="community-body">
    <iframe src="http://localhost:8080/jforum/" width="100%" height="600" frameBorder="0">
  		<p>Your browser does not support iframes.</p>
   </iframe> 
   </div>
   
   <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>