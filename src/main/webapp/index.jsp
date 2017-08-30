<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" errorPage="other.jsp" autoFlush="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" uri="/WEB-INF/tagLib/tagLib.tld" %>

<html>
<head>
    <script src="js/script.js"></script>
</head>
<body onload="onReadyPage()">

    <my:Hello color="red">rtewrewrew</my:Hello>

    <c:set var="x" value="10" scope="page"/>

    <p>var x = ${pageScope.x}</p>

    <p>queryString = ${pageContext.request.queryString}</p>
    <p>header cookie = ${cookie}</p>



    <h2>Hello World!</h2>
    <a href="/test">TestController</a>
    <form action="/test" method="post">
        <input type="text" name="value" value="qqqq">
        <input type="submit" value="OK">
    </form>

    <c:import url="other.jsp" var="data"/>
    <c:out value="${data}"/>

    <p>Session = ${pageContext.session.id}</p>
    <h2>${message}</h2>
    <h2><c:out value="${pageContext.request.session.creationTime}"></c:out></h2>
    <p id="demo">JSON</p>

    <form method="post" action="/another" enctype="multipart/form-data">
        <input type="file" name="fileName"/>
        <input type="submit" value="UpLoad"/>
    </form>


</body>
</html>
