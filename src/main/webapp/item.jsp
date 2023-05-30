<%-- 
    Document   : item
    Created on : May 29, 2023, 2:36:17 PM
    Author     : confi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> items</title>
    </head>
    <body>
    <h1>Items</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <!-- Add more columns as needed -->
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <!-- Display other item properties -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>







