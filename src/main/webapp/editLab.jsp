<%-- 
    Document   : editLab
    Created on : May 29, 2023, 2:54:14 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Lab</title>
    </head>
    <body>
        <h1>Edit Lab</h1>
        
        <%-- Retrieve the lab ID from the query parameter --%>
        <%-- You can access it using request.getParameter("labID") --%>
        <%-- Perform necessary operations to fetch the lab details based on the lab ID --%>
        <%-- and display the lab information in the form below --%>
        
<!--        <form action="labs" method="POST">
            <%-- Include hidden input field to pass the lab ID for update --%>
            <input type="hidden" name="editAction" value="editLab">
            
            <label for="labID">Lab ID:</label>
            <input type="text" name="labID" value="<%= request.getParameter("labID") %>">
            
            <label for="labName">Lab Name:</label>
            <input type="text" name="labName" value="<%= labName %>">
            
            <label for="city">City:</label>
            <input type="text" name="city" value="<%= city %>">
            
            <label for="region">Region:</label>
            <input type="text" name="region" value="<%= region %>">
            
            <label for="photo">Photo:</label>
            <input type="text" name="photo" value="<%= photo %>">
            
            <input type="submit" value="Update">
        </form>-->
            
<!--            NEW LAB WITH BOOTSTRAP-->
<div class="border border-4 m-3 p-3">
            <h3 class="p-4">Edit Lab</h3>
            <form action="labs" method="POST">
                <%-- Include hidden input field to pass the lab ID for update --%>
                <input type="hidden" name="editAction" value="editLab">
                <div class="input-group"> 
                    <label for="labID">Lab ID:</label>
                    <input class="form-control" type="text" name="labID" value="<%= request.getParameter("labID") %>" >&nbsp;&nbsp;
                    <label for="labName">Lab Name:</label>
                    <input class="form-control" type="text" name="labName" value="<%= labName %>">

                </div><br>
                <div class="input-group">
                    <label for="city">City:</label>
                    <input class="form-control" type="text" name="city" value="<%= city %>">&nbsp;&nbsp;

                    <label for="region">Region:</label>
                    <input class="form-control" type="text" name="region" value="<%= region %>">
                </div><br>


                <div class="input-group">
                    <label for="photo">Photo:</label>
                    <input class="form-control" type="text" name="photo" value="<%= photo %>">
                </div>
                <input class="btn btn-outline-primary mt-4" type="submit" value="Update">
            </form>

        </div>
    </body>
</html>
