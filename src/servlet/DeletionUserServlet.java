package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserManagementInterface;
import service.UserManagement_implimentation;


@WebServlet("/DeletionUserServlet")
public class DeletionUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1871871796669342804L;
       
    
    public DeletionUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");

		String sl_no = request.getParameter("sl_no");			
		
		UserManagementInterface userManagementInterface  = new UserManagement_implimentation();
		userManagementInterface.removeUsers(sl_no);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListMembers.jsp");
		dispatcher.forward(request, response);
		
	}

}
