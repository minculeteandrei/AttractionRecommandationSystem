<div class="row navbar" style="background-color:#000000">
  <div class="col-md-2 text-center">
    <c:choose>
      <c:when test="${cookie['UserType'].value == 'admin'}">
        <a class="btn btn-outline-light" href="adminMenu.jsp">Home</a>
      </c:when>
      <c:otherwise>
        <a class="btn btn-outline-light" href="userMenu.jsp">Home</a>
      </c:otherwise>
    </c:choose>
  </div>
  <div class="col">
    <form class="row form-inline justify-content-center" method="GET" action="search.jsp">
      <input class="col-md-5 form-control" type="text" name="keyword" placeholder="Name, genre, author..."/>
      <input type="submit" class="col-md-2 btn btn-outline-light" value="Search"/>
    </form>
  </div>
  <div class="col-md-2 text-center">
    <a class="btn btn-outline-light" href="index.jsp">Log Out</a>
  </div>
</div>