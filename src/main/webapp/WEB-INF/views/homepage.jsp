<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/14/2024
  Time: 1:07 PM
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
<!-- Modal -->
<div class="container">
    <nav class="navbar navbar-dark">
        <div class="container-fluid">
            <h1 class="text-center">Danh sách bài đăng</h1>
            <%-- Button --%>
            <a href="<%=request.getContextPath()%>/initCreate" class="btn btn-primary">
                Add New Post
            </a>
        </div>
    </nav>

    <%-- Search Form --%>
    <form action="/findByTitleOrContent">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="search" value="${search}" placeholder="Search for ..."
                   aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-success" type="submit" id="button-addon2">Button</button>
        </div>
    </form>

    <%-- Content --%>
    <c:forEach items="${list}" var="post">
        <div class="card w-100 my-3">
            <img src="${post.imgUrl}" class="card-img-top rounded mx-auto d-block" alt="...">
            <div class="card-body">
                <p class="text-break fw-lighter fst-italic text-end"><small>
                    <fmt:formatDate value="${post.time}" pattern="dd/MM/yyyy - HH:mm"/>
                </small></p>
                <h5 class="card-title">${post.title}</h5>
                <p class="card-text">${post.content}</p>
                <span class="border-start border-4 border-primary ps-1 text-secondary">${post.author}</span>

                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <a href="/initUpdate?id=${post.id}" class="btn btn-secondary">Update</a>
                    <a href="/delete?id=${post.id}" class="btn btn-danger" type="button">Delete</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
