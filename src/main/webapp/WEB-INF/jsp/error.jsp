<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<%@ page isErrorPage="true"%>

	<h3>Sorry an exception occured!</h3>

	Exception is:
	<%= exception %>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>