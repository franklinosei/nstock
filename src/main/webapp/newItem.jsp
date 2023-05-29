<%-- 
    Document   : newItem
    Created on : May 29, 2023, 3:54:00 PM
    Author     : confi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>new item</title>
    </head>
    <body>
         <h1>Add item</h1>
    <form method="post" action="item">
        <label for="labName">item Name:</label>
        <input type="text" id="labName" name="name" required><br><br>

        <label for="city">descr</label>
        <input type="text" id="city" name="description" required><br><br>

        <label for="region">faulty</label>
        <input type="text" id="region" name="faulty" required><br><br>

        <label for="photo">type ID</label>
        <input type="text" id="typeid" name="typeID"><br><br>
        
         <label for="photo">photo</label>
        <input type="text" id="photo" name="photo"><br><br>
        
         <label for="photo">serial number</label>
        <input type="text" id="serial" name="serialNumber"><br><br>
        
         <label for="photo">lab ID</label>
        <input type="text" id="labid" name="labID"><br><br>
        
<!--         <label for="photo">manager ID</label>
        <input type="text" id="photo" name="managerID"><br><br>
        -->
         <label for="photo">spec ID</label>
        <input type="text" id="spec" name="specID"><br><br>

        <input type="submit" value="Submit">
    </form>
    </body>
</html>
