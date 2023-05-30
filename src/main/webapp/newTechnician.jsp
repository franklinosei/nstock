<%-- 
    Document   : employee
    Created on : May 29, 2023, 3:27:28 PM
    Author     : iamdveloper
--%>


<div class="border border-3 m-3 p-2">
    <h3 class="p-2">Add Technician</h3>
    <div>
        <form>
            <div class="input-group">
                <input type="text" required="true" name="firstName" class="form-control m-1" placeholder="First Name">
                <input type="text" required="true" name="lastName" class="form-control m-1" placeholder="Last Name">
            </div>
            <div class="input-group">
                <select class="form-control m-1"  name="gender">
                    <option>Select Gender</option>
                    <option>Male</option>
                    <option>Female</option>
                </select>
                <input type="number" required="true" name="phone" class="form-control m-1" placeholder="Phone">
            </div>
            <div class="input-group">
                <input type="email" required="true" name="email" class="form-control m-1" placeholder="Email">
                <input type="text" required="true" name="address" class="form-control m-1" placeholder="Address">
            </div>
            <label class="p-1">Date Of Birth</label><br>
            <div class="input-group">
                <input type="date" required="true" name="dob" class="form-control m-1"  placeholder="Date of birth ">
                <input type="text" required="true" name="photo" class="form-control m-1" placeholder=" Photo URL">
            </div>
            <div class="input-group">
                <input type="text" required="true" name="roleID" class="form-control m-1" placeholder="Role ID">
                <input type="text" required="true" name="labID" class="form-control m-1" placeholder="Lab ID">
            </div>
            <div class="p-2">
                <input  type="submit" value="Save" class="btn btn-outline-success" >
            </div>
        </form>
    </div>
</div>