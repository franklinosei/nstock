<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Edit Item</title>
        </head>
        <body>
            <h3>Edit Item</h3>
            <form action="editItem" method="post">
                <input type="hidden" name="itemId" value="${item.itemId}">
                <label for="itemName">Item Name:</label>
                <input type="text" name="itemName" value="${item.name}"><br>
                <label for="itemDescription">Item Description:</label>
                <textarea name="itemDescription">${item.description}</textarea><br>
                <div  class="input-group " >
                <select class="form-control me-2" required="true" name="faulty">
                    <option value="">Is the item faulty?</option>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>

                <input  type="text" class="form-control" required="true" name="photo" id="city" placeholder="Photo" aria-describedby="basic-addon1">
            </div><br>

            

           
             <c:if test="${not empty labList}">
                  <br>
            <select class="form-control" required="true" name="itemType">
                <option value="">Assigned Lab</option>
                    <c:forEach var="lab" items="${labList}">
                        <option value=${lab.getLabID()}>${lab.getLabName()}</option>
                    </c:forEach>
              
            </select>  
             </c:if>
                <input type="submit" value="Update">
            </form>
        </body>
    </html>
</div>

                
                