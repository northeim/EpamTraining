<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

    <p>Message: ${pageContext.exception}</p>
    <p>toString: ${pageContext.exception.message}</p>
    <p>Name: ${pageContext.errorData.statusCode}</p>

    <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
        <p>${trace}</p>
    </c:forEach>


    <a href="${header["Referer"]}">Back</a>

</body>
</html>
