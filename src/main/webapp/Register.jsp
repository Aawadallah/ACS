<%--
  Created by IntelliJ IDEA.
  User: aawadallah
  Date: 11/29/18
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<form name="form" action="<%=request.getContextPath()%>
/RegistrationServlet" method="post">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Regisration Form</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Full Name</td>
                <td><input type="text" name="name"  required value="" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" required value="" /></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username"  required value="" /></td>
            </tr>
            <tr>
                <td>Password  <label for="pass">(8 characters minimum):</label></td>

                <td><input type="password" name="pwd"  id = "pass"   minlength="8" required value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Already registered!! <a href="../index.jsp">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>