<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div>

    <!-- NEW LAB WITH BOOTSTRAP -->
    <div class="shadow-lg mt-4 m-3 p-3">
        <h3 class="p-4">Edit Lab</h3>
        <form action="/nstock/editItem" method="POST">
            <%-- Include hidden input field to pass the lab ID for update --%>
            <input type="hidden" name="labID" value=${lab.getLabID()}>
            <div class="input-group">
                <!--<label for="labID">Lab ID:</label>-->
                <!--<input class="form-control" type="text" name="labID" value="<%= request.getParameter("id") %>">&nbsp;&nbsp;-->
                <label for="labName" class="me-2">Lab Name:</label>
                <input class="form-control me-2" type="text" name="labName" value="${lab.getLabName()}">
            </div><br>
            <div class="input-group">
                <label for="city" class="me-2">City:</label>
                <input class="form-control me-2" type="text" name="city" value="${lab.getCity()}">
                <label for="region" class="me-2">Region:</label>
                <input class="form-control" type="text" name="region" value="${lab.getRegion()}">
            </div><br>
            <div class="input-group">
                <label for="photo" class="me-2">Photo:</label>
                <input class="form-control" type="text" name="photo" value="${lab.getPhoto()}">
            </div>
            <input class="btn btn-outline-primary mt-4" type="submit" value="Update">
        </form>
    </div>
</div>

