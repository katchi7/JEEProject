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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="/inc/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_inscription.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/core.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/icon-font.min.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/fullcalendar.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_home.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_module.css">
  <link rel="icon" href="/inc/icons/logo.ico">
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css"
    integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css"
    integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous" />
  

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap"
    rel="stylesheet">

  <link rel="icon" href="logo.ico">
</head>
</head>

<body>
  <c:import url="/WEB-INF/header.jsp"></c:import>

  <div class="row min-vh-100" style="width: 100%;">
    <div class="col-2 menu-gauche" style="min-height: 100%;">
      <center>
        <svg xmlns="http://www.w3.org/2000/svg" width="60%" height="141.747" viewBox="0 0 153 141.747"
          style="margin-bottom: 10px;margin-top: 5%;">
          <path id="user-circle-solid"
            d="M76.5,8C34.24,8,0,39.722,0,78.874s34.24,70.874,76.5,70.874S153,118.026,153,78.874,118.76,8,76.5,8Zm0,27.435c14.992,0,27.145,11.26,27.145,25.149S91.492,85.732,76.5,85.732,49.355,74.473,49.355,60.584,61.508,35.435,76.5,35.435Zm0,98.309a61.1,61.1,0,0,1-45.191-19.49,34.812,34.812,0,0,1,30.384-17.09,8.1,8.1,0,0,1,2.19.314,41.346,41.346,0,0,0,25.233,0,8.1,8.1,0,0,1,2.19-.314,34.812,34.812,0,0,1,30.384,17.09A61.1,61.1,0,0,1,76.5,133.744Z"
            transform="translate(0 -8)" fill="rgba(0,0,0,0.52)" />
        </svg>
        <p>
        <h2>${sessionScope.user.fname } ${sessionScope.user.lname }</h2>
        </p>
      </center>

      <nav class="navbar menu-gauche-centre">
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="/ensiasdocs/home"> <i class="fab fa-leanpub"></i> Module </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre on">
          <a class="nav-link" href=""> <i class="fas fa-calendar-alt"></i> Calendrier </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="/ensiasdocs/profile"> <i class="fas fa-user"></i> Profile </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="#"> <i class="fas fa-file-alt"></i> To Do </a>
        </div>
      </nav>
    </div>
    <div class="col-10 corps_globale">
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

        <div class="pd-20 card-box mb-30" >
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
                <form id="add-event">
                  <div class="modal-body">
                    <h4 class="text-blue h4 mb-10">Add Event Detail</h4>
                    <div class="form-group">
                      <label>Event name</label>
                      <input type="text" class="form-control" name="ename">
                    </div>
                    <div class="form-group">
                      <label>Event Date</label>
                      <input type='text' class="datetimepicker form-control" name="edate">
                    </div>
                    <div class="form-group">
                      <label>Event Description</label>
                      <textarea class="form-control" name="edesc"></textarea>
                    </div>
                    <div class="form-group">
                      <label>Event Color</label>
                      <select class="form-control" name="ecolor">
                        <option value="fc-bg-default">fc-bg-default</option>
                        <option value="fc-bg-blue">fc-bg-blue</option>
                        <option value="fc-bg-lightgreen">fc-bg-lightgreen</option>
                        <option value="fc-bg-pinkred">fc-bg-pinkred</option>
                        <option value="fc-bg-deepskyblue">fc-bg-deepskyblue</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label>Event Icon</label>
                      <select class="form-control" name="eicon">
                        <option value="circle">circle</option>
                        <option value="cog">cog</option>
                        <option value="group">group</option>
                        <option value="suitcase">suitcase</option>
                        <option value="calendar">calendar</option>
                      </select>
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