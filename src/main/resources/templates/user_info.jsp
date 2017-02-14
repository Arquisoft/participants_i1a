<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
    <title>User info</title>
  </head>
  <body>
    <jsp:useBean id="user" class="main/hello/User" scope="session" />
    <table>
      <tr>
        <td>Id:</td><td id="id"><jsp:getProperty property="id" name="user"/></td>
      </tr>
      <tr>
        <td>Name:</td><td id="name"><jsp:getProperty property="firstName" name="user"/></td>
      </tr>
      <tr>
        <td>Email:</td><td id="surname"><jsp:getProperty property="Email" name="user"/></td>
      </tr>
      <tr>
        <td>Date of birth:</td><td id="birth"><jsp:getProperty property="dateOfBirth" name="user"/></td>
      </tr>
      <tr>
        <td>Address:</td><td id="address"><jsp:getProperty property="Address" name="user"/></td>
      </tr>
      <tr>
        <td>Nationality:</td><td id="nationality"><jsp:getProperty property="Nationality" name="user"/></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td>
          <input name="pass" type="password" placeholder="Password" >
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input name="repass" type="password" placeholder="Re-password" >
        </td>
        <td>
          <input type="submit" method="post" value="Change">
        </td>
      </tr>
    </table>
    <a href="login">Cerrar sesión</a>
  </body>
</html>
