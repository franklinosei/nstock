<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <div class="shadow p-4 mt-5">
        <h3>Edit Item</h3>
        <form action="/nstock/editItem" method="POST">
            <input type="hidden" name="itemId" value=${item.getItemID()}>
             <input type="hidden" name="labID" value=${item.getLabID()}>
            <label for="itemName">Item Name:</label>
            <input type="text" name="itemName" value=${item.getName()}><br>
            <label for="itemDescription">Item Description:</label>
            <textarea name="itemDescription">${item.getDescription()}</textarea><br>
            <div class="input-group">
                <select class="form-control me-2" required="true" name="faulty">
                    <option value="">Is the item faulty?</option>
                    <option value="true" <c:if test="${item.isFaulty()}">selected</c:if>>Yes</option>
                    <option value="false" <c:if test="${!item.isFaulty()}">selected</c:if>>No</option>
                </select>
                <input type="text" class="form-control" name="photo" id="photo" placeholder="Photo" aria-describedby="basic-addon1" value=${item.getPhoto()}>
            </div><br>
            <input type="submit" value="Update">
        </form>
    </div>
</div>
