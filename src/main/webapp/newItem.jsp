<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <div class="border border-3 m-3" >
        <h3 class="p-3">Add Item</h3>

        <form class="form-group m-3" method="post" action="/nstock/newItem">
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
    </div>
</div>


