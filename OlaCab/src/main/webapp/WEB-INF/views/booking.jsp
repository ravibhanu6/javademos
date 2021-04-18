<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<P>Your Ride has been booked successfully</P>

	<table style="width: 80%;border: 2px">
		<tr>
			<td>Id</td>
			<td>UserId</td>
			<td>RouteId</td>
			<td>Date</td>
		</tr>

		<tr>
			<td>${ride.rideId}</td>
			<td>${ride.userId}</td>
			<td>${ride.routeId}</td>
			<td>${ride.dateTime}</td>
		</tr>


	</table>
</body>
</html>
