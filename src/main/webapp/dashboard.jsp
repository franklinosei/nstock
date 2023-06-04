<%-- 
    Document   : dashboard
    Created on : May 27, 2023, 3:59:04 PM
    Author     : iamdveloper
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2 class="mt-3 p-3">Dashboard</h2>
<div class="row p-4 m-3 align-items-center">
    <div class="col-sm-4">
        <div class="card shadow">
            <div class="card-body ">
                <h5 class="card-title align-middle ">TOTAL LABS</h5>
                <hr>

                <p class="card-text align-middle">${labs.size()}</p>
                <a href="/nstock/labs" class="btn btn-outline-success">See Labs</a>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="card shadow">
            <div class="card-body">
                <h5 class="card-title">TOTAL TECHNICIANS</h5>
                <hr>
                <p class="card-text">${technicians.size()}</p>
                <a href="/nstock/technician" class="btn btn-outline-success">See Technicians</a>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="card shadow">
            <div class="card-body">
                <h5 class="card-title">TOTAL ITEMS</h5>
                <hr>
                <p class="card-text align-items-center">${items.size()}</p>
                <a href="/nstock/items" class="btn btn-outline-success">See Items</a>
            </div>
        </div>
    </div>

</div>


