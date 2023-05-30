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
=======
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>new item</title>
    </head>
    <body>
         <div class="border border-3 m-3" >
    <h3 class="p-3">Add Item</h3>

    <form class="form-group m-3" method="post" action="labs">
        <div class="mb-3 ">
            <div class="input-group">
                <input type="text" required="true" class="form-control p-2" placeholder="Item Name" name="name" aria-describedby="basic-addon1">&nbsp;&nbsp;
                <input type="text" required="true" class="form-control p-2" placeholder="Description" name="description" aria-describedby="basic-addon1">

            </div> 
        </div>
        <div  class="input-group" >

            <select class="form-control" required="true" name="faulty">
                <option>Faulty?</option>
                <option>Yes</option>
                <option>No</option>

            </select>&nbsp;&nbsp;
            <input  type="text" class="form-control p-2" required="true" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
        </div><br>
        <div >
            <div class="input-group">
                <input type="text" required="true" class="form-control p-2" placeholder="Serial Number" name="serialNumber" aria-describedby="basic-addon1">&nbsp;&nbsp;
                <select class="form-control" required="true" name="itemType">
                    <option>Click to Select Item Type</option>
                    <option>Laptop</option>
                    <option>Desktop</option>
                    <option>Monitor</option>
                </select>
            </div>

        </div>
        <div>
            <input class="btn btn-outline-success p-2 mt-4" type="submit" value="Save">
        </div><br>
    </form>
</div>
    </body>

</html>
