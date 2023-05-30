<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Item</title>
</head>
<body>
    <h1>New Item</h1>
    <form method="post" action="newItem">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required><br>

        <label for="description">Description:</label>
        <textarea name="description" id="description" rows="3" required></textarea><br>

        <label for="photo">Photo:</label>
        <input type="text" name="photo" id="photo"><br>

        <label for="serialNumber">Serial Number:</label>
        <input type="text" name="serialNumber" id="serialNumber" required><br>

        <label for="labID">Lab ID:</label>
        <select name="labID" id="labID" required>
            <c:forEach items="${labList}" var="lab">
                <option value="${lab.labID}">${lab.labName}</option>
            </c:forEach>
        </select><br>

        <label for="managerID">Manager ID:</label>
        <select name="managerID" id="managerID" required>
            <c:forEach items="${managerList}" var="manager">
                <option value="${manager.managerID}">${manager.managerName}</option>
            </c:forEach>
        </select><br>

        <label for="specID">Spec ID:</label>
        <select name="specID" id="specID" required>
            <c:forEach items="${specList}" var="spec">
                <option value="${spec.specID}">${spec.specName}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="Add Item">
    </form>
</body>
</html>
