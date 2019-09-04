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


@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetUserServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		String sl_no = request.getParameter("sl_no");	
		
		UserManagementInterface userManagementInterface  = new UserManagement_implimentation();
		User User=userManagementInterface.getUserByID(sl_no);

		request.setAttribute("User", User);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditUser.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
