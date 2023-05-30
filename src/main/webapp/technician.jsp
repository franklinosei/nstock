<%-- 
    Document   : employee
    Created on : May 29, 2023, 3:27:28 PM
    Author     : iamdveloper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="view-genre p-4">
    <!--    <h1>List of all Technicians
    
            <hr />
    
        </h1>-->

    <div class="mb-4 justify-content-end">
        <a href="/nstock/newTechnician">
            <button type="button" class="btn btn-success">Add Technician</button>
        </a>
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
