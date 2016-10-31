<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 10/29/16
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Movie List</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<style>body {background-color: lightskyblue;}

tr:hover {
    background-color: #555;
    color: white;
}
body {background-color: white  ;}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 45%;
}

td, th {
    border: 2px solid #566573 ;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd ;
}



</style>
<body>
<center><h2>Now Playing Movies</h2></center>
<table border="3" class="table">
    <tr><th>Title</th><th>Release Date</th><th>Description</th><th>Poster Cover</th></tr>
    <c:forEach items="${movies}" var="aMovie">
    <tr>
        <td><c:out value="${aMovie.title}"/></td>
        <td><c:out value="${aMovie.release_date}"/></td>
        <td><c:out value="${aMovie.overview}"/></td>
        <td><img src="https://image.tmdb.org/t/p/w300_and_h450_bestv2<c:out value="${aMovie.poster_path}"/>"></td>


        </c:forEach>
</table>
</body>
</html>

