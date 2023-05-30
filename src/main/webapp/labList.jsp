
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Labs</title>

        </head>
        <h3 class="heading">LABS</h3>
        <a href="http://localhost:8080/nstock/newLab"> <button class="btn btn-outline-success float-end m-2">Add lab</button></a>
                <table class="table table-striped table-dark">
                    <tr>
                        <th>LAB NAME</th>
                        <th>CITY</th>
                        <th>REGION</th>
                        <th>PHOTO</th>
                        <th>ACTIONS</th>
                    </tr>
        <c:forEach var="lab" items="${labs}">
            <tr>
                <td>${lab.labName}</td>
                <td>${lab.city}</td>
                <td>${lab.region}</td>
                <td><img class="rounded-circle" src="${lab.photo}" alt="Lab Photo" width="100" height="100"></td>
                <td><a href="editLab.jsp?labID=${lab.labID}"><button class="btn btn-primary">Edit</button></a> &nbsp; <button class="btn btn-danger">X</button></td>
            </tr>
        </c:forEach>
    </table>


        
<!--        <div class="border border-75x75 border-3 " >
            <form class="form-group m-3" method="post" action="labs">
                <div class="mb-3 ">
                    <div class="input-group">
                        <input type="text" class="form-control p-2" placeholder="Lab Name" name="labName" aria-describedby="basic-addon1">&nbsp;&nbsp;
                        <input type="text" class="form-control p-2" placeholder="City" name="city" aria-describedby="basic-addon1">

                    </div> 
                </div>
                <div class="input-group">
                    <select class="form-select" name="region">
                        <option selected>Region</option>
                        <option value="accra">Accra</option>
                        <option value="upperwest">Upper West</option>
                        <option value="uppereast">Upper East</option>
                        <option value="northern">Northern</option>
                        <option value="oti">Oti</option>
                        <option value="volta">Volta</option>
                    </select>&nbsp;&nbsp;             
                    <input  type="text" class="form-control mb-3 p-2" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
                </div><br>
                <div >
                <input class="btn btn-success mp-2" type="submit" value="Save">
                </div><br>
            </form>
        </div>
</div-->

</html>

