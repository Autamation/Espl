<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<html>
<h1>EQuality Labs</h1>

<script type="text/javascript">

	$(document).ready(function() {

			
			var key = "9927c26eece3c7b18e7194800a100932";
			var url ="https://www.bankofscotland.co.uk/";
			$.ajax({
				type : 'POST',
				url : "https://tenon.io/api/",
				data : {
					'key' : email,
					'url':url
				},
				success : function(result) {
				alert(result);

					} 
			});
		});

	</script>

<body>
<form>
</form>
</body>
</html>