<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	if (!!window.EventSource) {
		var source = new EventSource('push'); //为http://localhost:8080/testSpringMVC/push
		s = "";
		source.addEventListener('message', function(e) {
			s += e.data + "<br/>";
			$("#msg_from_server").html(s);
		});

		source.addEventListener('open', function(e) {
			console.log("连接打开.");
		}, false);

		source.addEventListener('error', function(e) {
			if (e.readyState == EventSource.CLOSED) {
				console.log("连接关闭");
			} else {
				console.log(e.readyState);
			}
		}, false);
	} else {
		console.log("没有sse");
	}
</script>
</head>
<body>
<div id="msg_from_server"></div>
</body>
</html>