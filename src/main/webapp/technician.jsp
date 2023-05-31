<%-- 
    Document   : employee
    Created on : May 29, 2023, 3:27:28 PM
    Author     : iamdveloper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <<<<<<< jsb-forms-ready -->

<!--<div class="border border-3 m-3 p-2">
    <h3 class="p-2">Technician List</h3>
    <a href="/nstock/newTechnician"><button class="btn btn-outline-success float-end mb-3">Add Technician</button></a>
    <div>
        <table class="table tabble-striped table-hover">
            <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>GENDER</th>
            <th>PHONE</th>
            <th>EMAIL</th>
            <th>ADDRESS</th>
            <th>DATE OF BIRTH</th>
            <th>PHOTO</th>
            <th>ROLE ID</th>
            <th>LAB ID</th>
            <tr>
            <tr>
                <td>Kwame</td>
                <td>Dzokoto</td>
                <td>Male</td>
                <td>0239429323</td>
                <td>kaceno@live.com</td>
                <td>M street 23</td>
                <td>6/6/1995</td>
                <td>akdaoeiwoie</td>
                <td>23</td>
                <td>23</td>
            </tr>
            <tr>
                <td>Kwame</td>
                <td>Dzokoto</td>
                <td>Male</td>
                <td>0239429323</td>
                <td>kaceno@live.com</td>
                <td>M street 23</td>
                <td>6/6/1995</td>
                <td>akdaoeiwoie</td>
                <td>23</td>
                <td>23</td>
            </tr>
            
        </table>
    </div>
</div>-->
<!-- ======= -->
<div class="view-genre p-4">
    <!--    <h1>List of all Technicians
    
            <hr />
    
        </h1>-->

    <div class="mb-4 justify-content-end mb-5">
        <a href="/nstock/newTechnician"><button class="btn btn-outline-success float-end mb-3">Add Technician</button></a>
    </div>


    <div class="d-flex flex-wrap">    

        <c:if test="${empty technicians}">
            <h3>Not data found at the moment</h3>

        </c:if>


        <c:if test="${not empty technicians}">


            <c:forEach var="techie" items="${technicians}">

                <div class="me-4">

                    <div class="card shadow" style="width: 18rem;">
                        <img src="https://unsplash.com/photos/iEEBWgY_6lA/download?ixid=M3wxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjg1NDUwODY4fA&force=true&w=640" class="card-img-top" alt="...">
                        <div class="card-body">
                            <div class="d-flex">
                                <h6 class="card-text me-2">${techie.getFirstName()}</h6>
                                <h6 class="card-text">${techie.getLastName()}</h6>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>


        </c:if>

        <c:if test="${not empty errorMessage}">
            <h1>${errorMessage}</h1>
        </c:if>
    </div>

</div>
<!-- >>>>>>> main -->
