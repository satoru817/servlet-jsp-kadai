package forms;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone_number = request.getParameter("phone_number");
		
		name = Objects.toString(name,"");
		email=Objects.toString(email,"");
		address = Objects.toString(address,"");
		phone_number = Objects.toString(phone_number,"");
		
		request.setAttribute("name",name);
		request.setAttribute("email",email);
		request.setAttribute("address",address);
		request.setAttribute("phone_number",phone_number);
		
		ArrayList<String> errorList = new ArrayList<String>();
		
		if("".equals(name.trim())) {
			errorList.add("Please type your name in the field");
		}
		
		if("".equals(email.trim())) {
			errorList.add("Please type your email address in the field");
		}else if(!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
			errorList.add("The email address you typed in is invalid");
			
		}
		
		if("".equals(address.trim())) {
			errorList.add("Please type your address in the field");
		}
		
		if("".equals(phone_number.trim())) {
			errorList.add("Please type your phone number in the field");
		}else if (!phone_number.trim().matches("^[0-9]{1,4}-[0-9]{1,4}-[0-9]{3,4}$")) {
			errorList.add("Please enter a valid phone number");
		}
		
		if(!errorList.isEmpty()) {
			request.setAttribute("errorList",errorList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/src/pages/confirmPage.jsp");
		dispatcher.forward(request,response);
	}

}
