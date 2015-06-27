<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript">	
	var json = {
		"id" : 456,
		"name" : "FJDFJ"
	};

	$.ajax({
		url : "api/getjson",
		data : JSON.stringify(json),
		type : "POST",
		contentType : "application/json",
		success : function(data) {
			console.log(data);
		}
	});
	$.ajax({
		url : "api/getxml",
		data : JSON.stringify(json),
		type : "POST",
		contentType : "application/json",
		success : function(data) {
			console.log(data);
		}
	});	
</script>
</head>
<body>

</body>
</html>