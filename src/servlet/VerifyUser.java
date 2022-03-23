package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.register.RegisterUserLogic;
import model.register.RegistorUserList;

@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(name,pass);

	    ServletContext application = this.getServletContext();
	    RegistorUserList registorUserList = (RegistorUserList) application.getAttribute("rul");

	    List<User> userList = new ArrayList<>();

	    //初回はスルー
	    if(registorUserList==null) {
	    	registorUserList = new RegistorUserList();
	    }else {
	    	userList = registorUserList.getRul();
	    }

	    RegisterUserLogic registerUserLogic = new RegisterUserLogic();
		boolean isRegister = registerUserLogic.execute(userList,user);

		if(isRegister) {
			userList.add(user);
			registorUserList.setRul(userList);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register/registerForm.jsp");
			dispatcher.forward(request, response);
		}
		application.setAttribute("rul",registorUserList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
