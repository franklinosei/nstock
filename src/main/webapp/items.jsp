<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Items</title>
            
        </head>
        <div class="shadow-lg p-4 mt-4 m-4">
            <h3 class="heading p-2" >ITEMS</h3>
            <a href="http://localhost:8080/nstock/newItem"> <button class="btn btn-outline-success float-end m-2">Add item</button></a>
            <table class="table table-striped table-light table-hover box-shadow-2">
                <tr>
                    <th>ITEM NAME</th>
                    <th>DESCRIPTION</th>
                    <th>FAULTY</th>

                    <!--                <th>TYPE ID</th>-->
                    <th>PHOTO</th>
                    <th>SERIAL NUMBER</th>
                    <!--                <th>LAB ID</th>
                                    <th>MANAGER ID</th>
                    
                                    <th>SPEC ID</th>-->
                    <th>ACTIONS</th>
                </tr>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.faulty}</td>


<!--                    <td>${item.typeID}</td>-->
                        <td><img class="rounded-circle" src="${item.photo}" alt="Item Photo" width="100" height="100"></td>
                        <td>${item.serialNumber}</td>
    <!--                    <td>${item.labID}</td>
                        <td>${item.managerID}</td>
                        <td>${item.specID}</td>-->

                        <td><a href="editItem?id=${item.itemID}"><button class="btn btn-primary">Edit</button></a> &nbsp; <button class="btn btn-danger">X</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </html>
</div>
