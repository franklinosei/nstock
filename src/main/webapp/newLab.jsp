<%-- 
    Document   : newLab
    Created on : May 29, 2023, 11:21:06 AM
    Author     : User
--%>


<h1>Add Lab</h1>

<div class="border border-75x75 border-3 " >
            <form class="form-group m-3" method="post" action="labs">
                <div class="mb-3 ">
                    <div class="input-group">
                        <input type="text" class="form-control p-2" placeholder="Lab Name" name="labName" aria-describedby="basic-addon1">&nbsp;&nbsp;
                        <input type="text" class="form-control p-2" placeholder="City" name="city" aria-describedby="basic-addon1">

                    </div> 
                </div>
                <div  class="input-group">
<!--                    <select class="form-select" name="region">
                        <option selected>Region</option>
                        <option value="accra">Accra</option>
                        <option value="upperwest">Upper West</option>
                        <option value="uppereast">Upper East</option>
                        <option value="northern">Northern</option>
                        <option value="oti">Oti</option>
                        <option value="volta">Volta</option>
                    </select>&nbsp;&nbsp;             -->
<input  type="text" class="form-control mb-3 p-2" name="region" id="region" placeholder="Region" aria-describedby="basic-addon1"> &nbsp; &nbsp;

                    <input  type="text" class="form-control mb-3 p-2" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
                </div><br>
                <div >
                <input class="btn btn-success mp-2" type="submit" value="Save">
                </div><br>
            </form>
        </div>
</div

