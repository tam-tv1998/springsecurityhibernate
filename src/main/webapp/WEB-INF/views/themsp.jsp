<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them San Pham</title>
</head>
<body>
	
	<h3>Them San Pham</h3>
	<form id="form-acb" action="themss" method="POST">
		Ten San Pham: <input type="text" name="tenSP">
		<br><br>
		Gia San Pham: <input type="text" name = "gia">
		<br><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Them San Pham">
		
	</form>
</body>
</html>