<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.bank.model.User" %>
<%@page import="com.bank.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<%User user=(User)request.getAttribute("user"); %>
						            <form:form id="depositForm" modelAttribute="transaction" action="deposit" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="amount">Amount: </form:label>
                        </td>
                        <td>
                            <form:input path="amount" name="amount" id="amount" />
                        </td>
                        <td><form:hidden path="userId" value="<%=user.getId()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="deposit" name="deposit">Deposit</form:button>
                        </td>
                    </tr>

                    <tr></tr>
                    
                </table>
            </form:form>
					</tr>
				</table>
			<td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="home.jsp">Home</a></td>
		</tr>
	</table>
</body>

</html>