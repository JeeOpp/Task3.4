<%@ page import="entity.BinaryTree" %><%--
  Created by IntelliJ IDEA.
  User: DNAPC
  Date: 21.11.2017
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Tree</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<br><br>
    <div class="container" align="center">
        <ul class="list-group">
            <li class="list-group-item list-group-item-dark"><h1><%= request.getParameter("method")%> </h1></li>
            <li class="list-group-item"><h3>inOrder: <%=request.getAttribute("inOrder")%></h3></li>
            <li class="list-group-item"><h3>preOrder: <%=request.getAttribute("preOrder")%></h3></li>
            <li class="list-group-item"><h3>postOrder: <%=request.getAttribute("postOrder")%></h3></li>
        </ul>
    </div>
</body>
</html>
