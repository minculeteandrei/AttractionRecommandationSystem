<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="bootstrap.css">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

        <title>E-Library</title>
    </head>
    <body>
        <%@include file="navbar.jsp"%>

        <form method="POST" action="${pageContext.request.contextPath}/addBook" id="form" class="form text-center" enctype="multipart/form-data">
            <div class="form-group">
              <label for="title">Title:</label>
              <input type="text" class="form-control" id="title" name="title" required/>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea form="form" type="text" class="form-control" id="description" name="description" required></textarea>
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <input type="text" class="form-control" id="author" name="author" required/>
            </div>
            <div class="form-group">
                <label for="pages">Pages:</label>
                <input type="number" class="form-control" id="pages" name="pages" min="1"/>
            </div>
            <div class="form-group">
                <label for="genre">Genre</label>
                <select class="col-md-6 form-select" name="genre" id="genre">
                    <option value="action">Action</option>
                    <option value="comedy">Comedy</option>
                    <option value="drama">Drama</option>
                    <option value="fantasy">Fantasy</option>
                    <option value="horror">Horror</option>
                    <option value="non-fiction">Non-fiction</option>
                    <option value="romance">Romance</option>
                    <option value="science-fiction">Science-Fiction</option>
                    <option value="self-improvement">Self Improvement</option>
                </select>
            </div>
            <div class="form-group">
                <label for="file">Book file:</label>
                <input type="file" name="file" id="file" accept=".pdf"/>
            </div>
            <input type="submit" class="btn btn-dark" value="Publish"/>
        </form>
    </body>
</html>