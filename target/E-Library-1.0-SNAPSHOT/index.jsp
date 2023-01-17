<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script>
        function submitData() {
            const name = $("#id_username").val();
            const pass = $("#id_password").val();
            if(name === "" || pass === "") {
                alert("All fields must be completed");
                return false;
            } else
                return true;
        }
    </script>

    <title>E-Library</title>
</head>
<body>
<h2><i>Log In</i></h2>
<form method="POST" action="${pageContext.request.contextPath}/login" class="form text-center" onsubmit="return submitData()">
    <div class="form-group">
        <label for="id_username">Username:</label>
        <input type="text" class="form-control" name="username" id="id_username">
    </div>
    <div class="form-group">
        <label for="id_password">Password:</label>
        <input type="password" class="form-control" name="password" id="id_password">
    </div>
    <input type="submit" class="btn btn-dark" value="Log In"/>
    <a class="btn btn-outline-dark" href="signup.jsp">Sign Up</a>
</form>
</body>
</html>