<%-- 
    Document   : newLab
    Created on : May 29, 2023, 11:21:06 AM
    Author     : User
--%>


<div class="border border-3 m-3" >
    <h3 class="p-3">Add Lab</h3>

    <form class="form-group m-3" method="post" action="labs">
        <div class="mb-3 ">
            <div class="input-group">
                <input type="text" required="true" class="form-control p-2" placeholder="Lab Name" name="labName" aria-describedby="basic-addon1">&nbsp;&nbsp;
                <input type="text" required="true" class="form-control p-2" placeholder="City" name="city" aria-describedby="basic-addon1">

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
            <input  type="text" class="form-control mb-3 p-2" required="true" name="region" id="region" placeholder="Region" aria-describedby="basic-addon1"> &nbsp; &nbsp;

            <input  type="text" class="form-control mb-3 p-2" required="true" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
        </div><br>
        <div >
            <input class="btn btn-outline-success mp-2" type="submit" value="Save">
        </div><br>
    </form>
</div>
</div

<!--items-->
<!--<div class="border border-3 m-3" >
    <h3 class="p-3">Add Item</h3>

    <form class="form-group m-3" method="post" action="labs">
        <div class="mb-3 ">
            <div class="input-group">
                <input type="text" required="true" class="form-control p-2" placeholder="Item Name" name="name" aria-describedby="basic-addon1">&nbsp;&nbsp;
                <input type="text" required="true" class="form-control p-2" placeholder="Description" name="description" aria-describedby="basic-addon1">

            </div> 
        </div>
        <div  class="input-group" >

            <select class="form-control" required="true" name="faulty">
                <option>Faulty?</option>
                <option>Yes</option>
                <option>No</option>

            </select>&nbsp;&nbsp;
            <input  type="text" class="form-control p-2" required="true" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
        </div><br>
        <div >
            <div class="input-group">
                <input type="text" required="true" class="form-control p-2" placeholder="Serial Number" name="serialNumber" aria-describedby="basic-addon1">&nbsp;&nbsp;
                <select class="form-control" required="true" name="itemType">
                    <option>Click to Select Item Type</option>
                    <option>Laptop</option>
                    <option>Desktop</option>
                    <option>Monitor</option>
                </select>
            </div>

        </div>
        <div>
            <input class="btn btn-outline-success p-2 mt-4" type="submit" value="Save">
        </div><br>
    </form>
</div>-->
</div

