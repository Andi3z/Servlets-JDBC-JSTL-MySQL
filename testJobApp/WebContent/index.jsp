<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone book</title>
</head>
<body>
<h2>Phone records</h2>
<p><a href='<c:url value="/create_record" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>Phone number</th><th>Note</th></tr>
<c:forEach var="record" items="${records}">
 <tr><td>${record.name}</td>
    <td>${record.number}</td>
    <td>${record.note}</td>
    <td>
    <a href='<c:url value="/edit?id=${record.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${record.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>

</body>
</html>