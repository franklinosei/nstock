
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>List of Labs</h1>
<table>
    <tr>
        <th>Lab Name</th>
        <th>City</th>
        <th>Region</th>
        <th>Photo</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="lab" items="${labs}">
        <tr>
            <td>${lab.labName}</td>
            <td>${lab.city}</td>
            <td>${lab.region}</td>
            <td><img src="${lab.photo}" alt="Lab Photo" width="100" height="100"></td>
            <td><a href="editLab.jsp?labID=${lab.labID}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

