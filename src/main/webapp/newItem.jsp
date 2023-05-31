<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div>
    <div class="border border-3 m-3" >
        <h3 class="p-3">Add Item</h3>

        <form class="form-group m-3" method="post" action="/nstock/newItem">
            <div class="mb-3 ">
                <div class="input-group">
                    <input type="text" required="true" class="form-control p-2 me-2" placeholder="Item Name" name="name" aria-describedby="basic-addon1">

                </div> 
            </div>


            <div  class="input-group " >
                <select class="form-control me-2" required="true" name="faulty">
                    <option value="">Is the item faulty?</option>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>

                <input  type="text" class="form-control" required="true" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
            </div><br>

            <div >
                <div class="input-group">
                    <input type="text" required="true" class="form-control me-2" placeholder="Serial Number" name="serialNumber" aria-describedby="basic-addon1">
                    <select class="form-control" required="true" name="itemType">
                        <option value="">Click to Select Item Type</option>
                        <!--                        <option>Laptop</option>
                                                <option>Desktop</option>
                                                <option>Monitor</option>-->

                        <c:if test="${not empty typesList}">
                            <c:forEach var="type" items="${typesList}">
                                <option value=${type.getTypeID()}>${type.getTypeName()}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>

            </div>

           
             <c:if test="${not empty labList}">
                  <br>
            <select class="form-control" required="true" name="itemType">
                <option value="">Assigned Lab</option>
                    <c:forEach var="lab" items="${labList}">
                        <option value=${lab.getLabID()}>${lab.getLabName()}</option>
                    </c:forEach>
              
            </select>  
             </c:if>
            
            <br>
            
            <textarea rows="5" type="text" required="true" class="form-control p-2" placeholder="Description" name="description" aria-describedby="basic-addon1"></textarea>


            <div class="">
                <input class="btn btn-outline-success p-2 mt-4" type="submit" value="Save">
            </div><br>

        </form>
    </div>
</div>


