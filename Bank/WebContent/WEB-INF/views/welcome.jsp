<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.bank.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>

<body>
	<table>
		<tr>
			<td>Welcome ${firstname}</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td>Account No:${user.account.accountNo}</td>
					</tr>
					<tr>
						<td>Balanace:${user.account.balance}</td>
					</tr>
					<tr>
					    <% User user=(User)request.getAttribute("user"); %>
						<td><a href="deposit?userId=<%=user.getId() %>">Deposit</a></td>
						<td><a href="transfer?userId=<%=user.getId() %>">Transfer</a></td>
						<td><a href="history?userId=<%=user.getId()%>">History</a></td>
					</tr>
				</table>
			<td>
		</tr>
		<tr>
		</tr>
	</table>
</body>

</html>