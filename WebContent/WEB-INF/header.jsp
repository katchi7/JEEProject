<header>
        <nav class="navbar">
          <div class="container">
            <a class="navbar-brand" href="/"><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="200"></a>
              <%if(session.getAttribute("user")==null){%>
            <div>
              <a class="btn btn-outline-primary mr-2" href="login"><span><i class="fas fa-user"></i></span>&nbsp;&nbsp;Log In</a>
              <a class="btn btn-primary" href="register"><span><i class="fas fa-user-plus"></i></span>&nbsp;&nbsp;Sign Up</a></div>
          </div>
            <!--Si l'utilisateur est conecté-->
            <%}else{%>
            <div>
                <span><i class="fas fa-user-circle"></i> </span><strong>${sessionScope.user.fname} ${sessionScope.user.lname}</strong>
                <a class="btn btn-danger" href="logout"><span><i class="fas fa-sign-out-alt"></i></span>&nbsp;&nbsp;Logout</a></div>
            </div>
            <%}%>
        </nav>
</header>