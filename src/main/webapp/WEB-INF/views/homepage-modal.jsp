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
            <div class="d-flex">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Add New Post
                </button>

            </div>
        </div>
    </nav>

    <%-- Search Form --%>
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search for ..."
               aria-label="Recipient's username" aria-describedby="button-addon2">
        <button class="btn btn-outline-success" type="button" id="button-addon2">Button</button>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="<%=request.getContextPath()%>/create" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add a new post</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
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
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

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
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal1">
                        Update
                    </button>
                    <button class="btn btn-danger" type="button">Delete</button>
                </div>
            </div>
        </div>
        <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="<%=request.getContextPath()%>/update" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel1">Add a new post</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="input-group mb-3">
                                    <span class="input-group-text">Title</span>
                                    <input type="text" class="form-control" placeholder="" aria-label="title"
                                           aria-describedby="title" name="title" required>
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text">Content</span>
                                    <textarea class="form-control" aria-label="With textarea" name="content"
                                              required></textarea>
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text">Author</span>
                                    <input type="text" class="form-control" placeholder="" aria-label="author"
                                           aria-describedby="author" name="author" required>
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text">Image Url</span>
                                    <input type="text" class="form-control" placeholder="" aria-label="imgUrl"
                                           aria-describedby="imgUrl" name="imgUrl" required>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </div>
                    </form>
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
