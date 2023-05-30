<%-- 
    Document   : newTechnician
    Created on : May 29, 2023, 3:29:43 PM
    Author     : iamdveloper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="center-div mt-5 mb-5">
    <div class="container shadow p-4 rounded w-70">
        <h1>Add Technician</h1>
        <hr>
        <form action="/nstock/newTechnician" method="post">

            <!--Personal Info-->
            <div class="mt-4 ms-4 me-4">
                <h4>Personal Info</h4>
                <div class="form-group mt-2">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                </div>
                <div class="form-group mt-2">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                </div>
                <div class="form-group mt-2">
                    <label for="gender">Gender:</label>
                    <select class="form-control" id="gender" name="gender" required>
                        <option value="">Select Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div class="form-group mt-2">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>

                <div class="form-group mt-2">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>
                <div class="form-group mt-2">
                    <label for="dob">Date of Birth:</label>
                    <input type="date" class="form-control" id="dob" name="dob" required>
                </div>
            </div>


            <!--Account Info-->
            <div class="mt-5 ms-4 me-4">
                <h4>Account Info</h4>
                <div class="form-group mt-2">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="form-group mt-2">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group mt-2">
                    <label for="photo">Photo:</label>
                    <input type="text" class="form-control" id="photo" name="photo" required>
                </div>
                
                
                 <div class="form-group mt-2">
                    <label for="labID">Assigned Lab:</label>
                    <!--<input type="number" class="form-control" id="labID" name="labID" required>-->
                    <select class="form-control" id="labID" name="labID" required>
                        <option value="">Select Lab</option>
                        <c:forEach var="lab" items="${labs}">
                            <option value=${lab.getLabID()}>${lab.getLabName()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                
                <div class="form-group mt-2">
                    <label for="roleID">Role:</label>
                    <!--                <input type="number" class="form-control" id="roleID" name="roleID" required>-->
                    <select class="form-control" id="roleID" name="roleID" required>
                        <option value="">Select Role</option>
                        <option value=1>Manager</option>
                        <option value=2>Technician</option>
                    </select>

                </div>


               
            </div>
            <button type="submit" class="btn btn-primary mt-4 ms-4">Add Technician</button>
        </form>
    </div>
</div>