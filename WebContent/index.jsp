<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Search</title>
</head>
<body>

	<form action="getQuery.do" method="GET">
		<input type="text" name="keyword" size="50" placeholder="keyword" /> 
		<input type="submit" value="Get Search Word" />
	</form>
	<hr />

	<p>Your Input: ${result}</p>

	<table>
		<tbody>
			<c:forEach var="query" items="${queries}">
				<tr>
					<c:forEach var="item" items="${query}">
						<td>${item}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>