<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ensias.beans.Module" %>
<%@ page import="com.ensias.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>ENSIAS-DOC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/inc/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css"
    integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css"
    integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous" />
  <link rel="stylesheet" type="text/css" href="/inc/styles/core.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/icon-font.min.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/fullcalendar.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style.css">
  <link rel="stylesheet" href="/inc/styles/style_inscription.css">
  <link rel="stylesheet" href="/inc/styles/style_home.css">
  <link rel="stylesheet" href="/inc/styles/style_barre.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js"></script>

  <link rel="icon" href="/inc/icons/logo.ico">
</head>


<body>

  <div id="wrapper">
    <div class="overlay"></div>

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse fixed-top" id="sidebar-wrapper" role="navigation" style="margin-top: 75px;">

      <ul class="nav sidebar-nav" style="list-style-type: none;">
        <div class="sidebar-header">
          <div class="sidebar-brand">
            <a href="#">${sessionScope.user.fname } ${sessionScope.user.lname }</a>
          </div>
        </div>
        <li><a href="/ensiasdocs/home"><i class="fas fa-book" style="margin-right:10px;"></i>Module</a></li>
        <li><a href="/ensiasdocs/profile"><i class="fas fa-user-graduate" style="margin-right:10px;"></i></i>Profile</a></li>
        <li><a href="/ensiasdocs/calendrier"><i class="fas fa-calendar-alt" style="margin-right:10px;"></i>Calendrier</a></li>
        <li><a href="/ensiasdocs/todo"><i class="fas fa-list-alt" style="margin-right:10px;"></i>To Do</a></li>
        <li><a href="/ensiasdocs/admin" ><i class="fas fa-user-cog" style="margin-right:10px;"></i>Administrateur</a></li>
        </li>
      </ul>
      <a class="navbar-brand" href=""><img src="/inc/images/logo.png" alt="ENSIAS-DOC" width="200"
          style="position: absolute;bottom: 100px;"></a>
    </nav>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <c:import url="/WEB-INF/header.jsp"></c:import>
      <c:forEach items="${requestScope.events}" var="event">
        <div class="user_events" hidden>
          <span class="event_name">${event.event_name}</span>
          <span class="event_description">${event.event_description}</span>
          <span class="event_start">${event.event_start}</span>
          <span class="event_end">${event.event_end}</span>
          <span class="event_class">${event.event_class}</span>
          <span class="event_icon">${event.event_icon}</span>
        </div>
      </c:forEach>

      <div class="container align-self-center">
        <div class="min-vh-100">
          <div class="page-header">
            <div class="row">
              <div class="col-md-12 col-sm-12">
                <div class="title">
                  <center>
                    <h4 style="font-weight: bold;font-size: 50px;"><i class="fas fa-calendar-alt"
                        style="margin-right: 15px;"></i>Calendrier</h4>
                  </center>
                </div>
              </div>
            </div>
          </div>

          <div class="pd-ltr-20 xs-pd-20-10">
            <div class="pd-20 card-box mb-30">
              <div class="calendar-wrap">
                <div id='calendar'></div>
              </div>
              <!-- calendar modal -->
              <div id="modal-view-event" class="modal modal-top fade calendar-modal">
                <div class="modal-dialog modal-dialog-centered">
                  <div class="modal-content">
                    <div class="modal-body">
                      <h4 class="h4"><span class="event-icon weight-400 mr-3"></span><span class="event-title"></span>
                      </h4>
                      <div class="event-body"></div>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>

              <div id="modal-view-event-add" class="modal modal-top fade calendar-modal">
                <div class="modal-dialog modal-dialog-centered">
                  <div class="modal-content">
                    <form method="POST" action="/ensiasdocs/nouvelle-tache" id="add-event">
                      <div class="modal-body">
                        <h4 class="text-blue h4 mb-10">Add Todo Detail</h4>
                        <div class="form-group">
                          <label>Todo title</label>
                          <input type="text" class="form-control" name="todo_name">
                        </div>
                        <div class="form-group">
                          <label>Todo Date</label>
                          <input type='text' class="datetimepicker form-control" name="todo_date">
                        </div>
                        <div class="form-group">
                          <label>Todo Description</label>
                          <textarea class="form-control" name="todo_desc"></textarea>
                        </div>

                        <div class="form-check ml-1">
                          <input class="form-check-input" type="checkbox" value="done" id="flexCheckDefault"
                            name="todo_is_done">
                          <label class="form-check-label" for="flexCheckDefault">
                            Done
                          </label>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <c:import url="/WEB-INF/footer.jsp"></c:import>
    </div>
    <!-- /#page-content-wrapper -->
  </div>

  <script src="/inc/js/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="/inc/js/main.js"></script>
  <script src="/inc/js/barre.js"></script>

  <script src="/inc/js/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="/inc/js/main.js"></script>
  <script src="/inc/js/core.js"></script>
  <script src="/inc/js/script.min.js"></script>
  <script src="/inc/js/process.js"></script>
  <script src="/inc/js/layout-settings.js"></script>
  <script src="/inc/js/fullcalendar.min.js"></script>
  <script src="/inc/js/calendar-setting.js"></script>
</body>

</html>