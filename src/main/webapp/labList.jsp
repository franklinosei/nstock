
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Labs</title>

        </head>
        <div class="border border-3 m-2 p-3 bg-light">
            <h3 class="heading">LABS</h3>
            <a href="http://localhost:8080/nstock/newLab"> <button class="btn btn-outline-success float-end m-2 ">Add lab</button></a>
        <table class="table table-striped table-hover">
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
            <td><img class="rounded-circle" src="${lab.photo}" alt="Lab Photo" width="40" height="40"></td>
            <td>
                <a href="editLab?id=${lab.labID}"><button class="btn btn-primary">Edit</button></a>
                <button class="btn btn-danger" onclick="deleteLab(${lab.labID})">X</button>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    function deleteLab(labID) {
        if (confirm("Are you sure you want to delete this lab?")) {
            // Send an AJAX request to delete the lab
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "labs");
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onload = function() {
                if (xhr.status === 200) {
                    alert(xhr.responseText);
                    // Refresh the page to update the lab list
                    location.reload();
                } else {
                    alert("Failed to delete lab. Please try again.");
                }
            };
            xhr.send("deleteAction=deleteLab&labID=" + labID);
        }
    }
</script>



<!--ADD LAB-->

<!--                    <div class="border border-75x75 border-3 " >
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
        </div>

        <!--EDIT LAB-->
<!--        <div class="border border-4 m-3 p-3">
            <h3 class="p-4">Edit Lab</h3>
            <form action="labs" method="POST">
                <%-- Include hidden input field to pass the lab ID for update --%>
                <input type="hidden" name="editAction" value="editLab">
                <div class="input-group"> 
                    <label for="labID">Lab ID:</label>
                    <input class="form-control" type="text" name="labID" value="">&nbsp;&nbsp;
                    <label for="labName">Lab Name:</label>
                    <input class="form-control" type="text" name="labName" value="">

                </div><br>
                <div class="input-group">
                    <label for="city">City:</label>
                    <input class="form-control" type="text" name="city" value="">&nbsp;&nbsp;

                    <label for="region">Region:</label>
                    <input class="form-control" type="text" name="region" value="">
                </div><br>


                <div class="input-group">
                    <label for="photo">Photo:</label>
                    <input class="form-control" type="text" name="photo" value="">
                </div>
                <input class="btn btn-outline-primary mt-4" type="submit" value="Update">
            </form>

        </div>-->
    </html>


    