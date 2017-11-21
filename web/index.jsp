<%--
  Created by IntelliJ IDEA.
  User: DNAPC
  Date: 18.11.2017
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  </head>
  <body>
  <br>
    <div class="container">
      <form action="Controller" method="post">
        <input type="hidden" name="method" value="arrayList"/>
        <div class="input-group mx-sm-3">
          <div class="input-group-addon">Values</div>
          <input type="text" class="form-control col-2" id="inputField1" name="values" value="6 3 8 2 5 1 4 9 7">
          <button type="submit" class="btn btn-primary">ArrayList</button>
        </div>
      </form>
      <form action="Controller" method="post">
        <input type="hidden" name="method" value="linkedList"/>
        <div class="input-group mx-sm-3">
          <div class="input-group-addon">Values</div>
          <input type="text" class="form-control col-2" id="inputField2" name="values" value="6 3 8 2 5 1 4 9 7">
          <button type="submit" class="btn btn-primary">LinkedList</button>
        </div>
      </form>
    </div>
  </body>
</html>
