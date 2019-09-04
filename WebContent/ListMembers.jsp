<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.UserManagement_implimentation"%>
<%@page import="service.UserManagementInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>BidWars</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="adminCss/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="adminCss/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="adminCss/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="adminCss/images/favicon.png" />


</head>
<body>


  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo" href="index.html"><img src="adminCss/kl.jpeg" alt="logo"/></a>
        <a class="navbar-brand brand-logo-mini" href="index.html"><img src="images/logo-mini.svg" alt="logo"/></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-stretch">
        <div class="search-field d-none d-md-block">
          <form class="d-flex align-items-center h-100" action="#">
            <div class="input-group">
              <div class="input-group-prepend bg-transparent">
                  <i class="input-group-text border-0 mdi mdi-magnify"></i>                
              </div>
              <input type="text" class="form-control bg-transparent border-0" placeholder="Search projects">
            </div>
          </form>
        </div>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
              <div class="nav-profile-img">
                <img src="adminCss/images/faces/a.jpg" alt="image">
                <span class="availability-status online"></span>             
              </div>
              <div class="nav-profile-text">
                <p class="mb-1 text-black">Thilini Dureksha</p>
              </div>
            </a>
            <div class="dropdown-menu navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item" href="#">
                <i class="mdi mdi-cached mr-2 text-success"></i>
                Activity Log
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">
                <i class="mdi mdi-logout mr-2 text-primary"></i>
                Signout
              </a>
            </div>
          </li>
          <li class="nav-item d-none d-lg-block full-screen-link">
            <a class="nav-link">
              <i class="mdi mdi-fullscreen" id="fullscreen-button"></i>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="messageDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
              <i class="mdi mdi-email-outline"></i>
              <span class="count-symbol bg-warning"></span>
            </a>
            
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="mdi mdi-bell-outline"></i>
              <span class="count-symbol bg-danger"></span>
            </a>
           
          </li>
          <li class="nav-item nav-logout d-none d-lg-block">
            <a class="nav-link" href="#">
              <i class="mdi mdi-power"></i>
            </a>
          </li>
          <li class="nav-item nav-settings d-none d-lg-block">
            <a class="nav-link" href="#">
              <i class="mdi mdi-format-line-spacing"></i>
            </a>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item nav-profile">
            <a href="#" class="nav-link">
              <div class="nav-profile-image">
                <img src="adminCss/images/faces/a.jpg" alt="profile">
                <span class="login-status online"></span> <!--change to offline or busy as needed-->              
              </div>
              <div class="nav-profile-text d-flex flex-column">
                <span class="font-weight-bold mb-2">Thilini Dureksha</span>
                <span class="text-secondary text-small">Project Manager</span>
              </div>
              <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.html">
              <a class="nav-link" href="MainInterface.jsp">
              <span class="menu-title">Dashboard</span>
              <i class="mdi mdi-home menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="insertWindow.jsp">
              <span class="menu-title">Insert Member</span>
              <i class="mdi mdi-contacts menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListMembers.jsp">
              <span class="menu-title">Edit Members</span>
              <i class="mdi mdi-format-list-bulleted menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListMembers.jsp">
              <span class="menu-title">Remove Members</span>
              <i class="mdi mdi-chart-bar menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListMembers.jsp">
              <span class="menu-title">Member List</span>
              <i class="mdi mdi-table-large menu-icon"></i>
            </a>
          </li>
         
         
         
        </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          
          <div class="page-header">
             <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>                 
              </span>
              User List
            </h3>
            <nav aria-label="breadcrumb">
             
                <li class="breadcrumb-item active" aria-current="page">
                 
                  <i class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
                </li>
            </nav>
          </div>
        

              <div class="card">
                <div class="card-body">
             
 
 
 
 
 
   <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Hemas Hospital Staff Members</h4>
                  <table width="100%"  class="table table-bordered">

                    <thead>
                      <tr>
                        <th>User ID</th>
                        <th> User Name</th>
                        <th>email</th>
                        <th>Mobile No</th>
                        <th>Address</th>
                       <th>Member type</th>
                        <th> Gender</th>
                      </tr>
                    </thead>
<%

	UserManagementInterface userManagementInterface=new UserManagement_implimentation();
	ArrayList<User>userList=userManagementInterface.getUsers();


	for(User User : userList){



%>

                    <tbody>
                      <tr class="table-info">
                        <td>
                         <%=User.getSl_no() %>
                        </td>
                        <td>
                           <%=User.getUser_name() %>
                        </td>
                        <td>
                         <%=User.getEmail() %>
                        </td>
                        <td>
                         <%=User.getMobile() %>
                        </td>
                        <td>
                          <%=User.getAddress() %> 
                        </td>
                        <td>
                          <%=User.getMemberType() %> 
                        </td>
                        <td>
                          <%=User.getGender() %> 
                        </td>
                        
                        
                        <td>
                          
               <form method="POST" action="GetUserServlet">
				<input type="hidden" name="sl_no" value="<%=User.getSl_no()%>"/>
				 <input type="submit" value= "Select User" class="select-button" /> 
				 
				 
				 </form>
     				</td>
                      </tr>
                      
                  <%	
			   }
            %>       
                    </tbody>
                  </table>
                </div>
              </div>
            </div>


              </div>                                  
                        
          
          
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2019 <a href="https://www.bootstrapdash.com/" target="_blank">Brid Wars</a>. All rights reserved.</span>
           
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="adminCss/vendors/js/vendor.bundle.base.js"></script>
  <script src="adminCss/vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="adminCss/js/off-canvas.js"></script>
  <script src="adminCss/js/misc.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="adminCss/js/dashboard.js"></script>
  <!-- End custom js for this page-->




</body>

</html>
