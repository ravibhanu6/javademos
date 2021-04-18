<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Books" method="post">
		<table style="width: 80%">
			<tr>
				<td>Id</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>

			<c:forEach items="${rList}" var="route">
				<tr>
					<td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td><input type="hidden" name="duration">${route.duration}</td>
					<td><input type="hidden" name="userid" value=${userid} ></td>
					<td><input type="hidden" name="action" value="Book" /></td>
					<td><input value="Book" type="submit" /></td>
				</tr>

			</c:forEach>

		</table>
	</form>


</body>
</html>