<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<c:if test="${not empty param.error}">
		<font color="red"> An error was produced. <br /> Cause :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	</c:if>
	<form method="POST" action="<c:url value="/j_spring_security_check" />">
		<table>
			<tr>
				<td align="right">Username</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td align="right">Password</td>
				<td><input type="password" name="j_password" /></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

