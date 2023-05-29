<%-- 
    Document   : newLab
    Created on : May 29, 2023, 11:21:06 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new Lab</title>
</head>
<body>
    <h1>Add Lab</h1>
    <form method="post" action="LabServlet">
        <label for="labName">Lab Name:</label>
        <input type="text" id="labName" name="labName" required><br><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br><br>
        
        <label for="region">Region:</label>
        <input type="text" id="region" name="region" required><br><br>
        
        <label for="photo">Photo URL:</label>
        <input type="text" id="photo" name="photo" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>

