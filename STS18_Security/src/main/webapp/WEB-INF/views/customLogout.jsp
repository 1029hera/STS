<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h1> Logout Page</h1>
<form action="${pageContext.request.contextPath}/customLogout" method='post'>
<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>
<button>로그아웃 했는데 또 로그아웃 하면?</button>
</form>
</body>
</html>


