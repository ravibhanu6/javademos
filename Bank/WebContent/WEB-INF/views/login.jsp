<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
            <style type="text/css">
            	.error{
            		color: red;
            		position: fixed;
            		text-align: left;
            		margin-left: 20px;
            	}
            </style>
            <script type="text/javascript">
            	function validate() {
					var username=document.getElementById("username");
					var password=document.getElementById("password");
					if(username.value.trim()==""){
						document.getElementById("user").style.visibility="visible";
						return false;
					}
					else if(password.value.trim()==""){
						document.getElementById("pass").style.visibility="visible";
						return false;
					}
					esle{
						return true;
					}
				}
            </script>
        </head>

        <body>

            <form:form id="loginForm" modelAttribute="login" action="login" method="post" onsubmit="return validate()">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                            <form:errors path="username" cssClass="error"/>
                            <label id="user" style="color: red;visibility: hidden;">Required</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                            <form:errors path="password" cssClass="error"/>
                             <label id="pass" style="color: red;visibility: hidden;">Required</label>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                           <%--  <form:button id="login" name="login">Login</form:button> --%>
                            <input type="submit" value="Login" name="login" id="login"/>
                        </td>
                    </tr>

                    <tr></tr>
                    
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>

        </body>

        </html>