package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserManagementInterface;
import service.UserManagement_implimentation;


@WebServlet("/InsertionUserServlet")
public class InsertionUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertionUserServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		User User =new User();
		
		User.setSl_no(request.getParameter("sl_no"));
		
		User.setUser_name(request.getParameter("user_name"));
		
		User.setEmail(request.getParameter("email"));
		
		User.setMobile(request.getParameter("mobile"));
		
		User.setAddress(request.getParameter("address"));
		
		User.setMemberType(request.getParameter("memberType"));
		
		User.setGender(request.getParameter("gender"));

		
		UserManagementInterface userManagementInterface  = new UserManagement_implimentation();
		userManagementInterface.addUser(User);

		request.setAttribute("User", User);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListMembers.jsp");
		dispatcher.forward(request, response);

		
	}

}
