<%-- 
    Document   : newLab
    Created on : May 29, 2023, 11:21:06 AM
    Author     : User
--%>


    <h1>Add Lab</h1>
    <form method="post" action="labs">
        <label for="labName">Lab Name:</label>
        <input type="text" id="labName" name="labName" required><br><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br><br>
        
        <label for="region">Region:</label>
        <input type="text" id="region" name="region" required><br><br>
        
        <label for="photo">Photo URL:</label>
        <input type="text" id="photo" name="photo"><br><br>
        
        <input type="submit" value="Submit">
    </form>


