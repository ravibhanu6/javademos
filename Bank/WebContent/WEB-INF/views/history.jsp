<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>

<body style="text-align: left;">
Welcome <h4>${firstname}</h4> ${message }
	<table style="text-align: center;align-items: center;border: 2px solid black;">
	
		<tr style="background-color: orange;border: 2px solid black;">
			<th style="border: 2px solid black;">Transaction Id</th>
			<th style="border: 2px solid black;">Amount</th>
			<th style="border: 2px solid black;">Transaction Type</th>
			<th style="border: 2px solid black;">Description</th>
			<th style="border: 2px solid black;">Account No</th>
			<th style="border: 2px solid black;">Transaction Date</th>
		</tr>
		<c:forEach items="${transactions}" var="item">
		<tr style="border: 2px solid black;">
      		<td style="border: 2px solid black;"><c:out value="${item.id}" /></td>
      		<td style="border: 2px solid black;"><c:out value="${item.amount}" /></td>
      		<td style="border: 2px solid black;"><c:out value="${item.transactionType}" /></td>
      		<td style="border: 2px solid black;"><c:out value="${item.description}" /></td>
      		<td style="border: 2px solid black;"><c:out value="${item.accountNumber}" /></td>
      		<td style="border: 2px solid black;"><c:out value="${item.date}" /></td>
    	</tr>
		</c:forEach>
	</table>
</body>

</html>