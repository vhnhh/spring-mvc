<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/16/2024
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>md4-pring-mvc-post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="<%=request.getContextPath()%>/create" method="post">
    <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add a new post</h5>
    </div>
    <div class="modal-body">
        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Title</span>
            <input type="text" class="form-control" placeholder="" aria-label="title"
                   aria-describedby="title" name="title" required>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Content</span>
            <textarea class="form-control" aria-label="With textarea" name="content"
                      required></textarea>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="author">Author</span>
            <input type="text" class="form-control" placeholder="" aria-label="author"
                   aria-describedby="author" name="author" required>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="imgUrl">Image Url</span>
            <input type="text" class="form-control" placeholder="" aria-label="imgUrl"
                   aria-describedby="imgUrl" name="imgUrl" required>
        </div>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Create</button>
    </div>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
