<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="resp">dfdf</div>
	<input type="button" onclick="req();" value="请1求" />
	<input type="button" value="call" onclick="call();" />
	<input type="button" value="deferred" onclick="deferred();" />
	<script src="<c:url value="/js/jquery-2.1.4.js"/>"
		type="text/javascript"></script>
	<script>
		function req() {
			$.ajax({
				url : "test/convert",
				data : "wang-yunfei",//注意此处的格式
				type : "POST",
				contentType : "application/x-wisely",
				success : function(data) {
					$("#resp").html(data);
				}
			});
		}
		function call() {
			$.get('call', function(data) {
				console.log(data);
			});
		}

		function deferred() {
			$.get('defer', function(data) {
				console.log(data);
				//deferred();//每次请求完成,再发一次请求,避免客户端定时刷新来获取数据
			});
		}
	</script>
</body>
</html>