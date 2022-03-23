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
import javax.servlet.http.HttpSession;

import model.User;
import model.registor.RegisterUserLogic;
import model.registor.RegistorUserList;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(name,pass);

		if(name.isBlank()||pass.isBlank()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}


	    ServletContext application = this.getServletContext();
	    RegistorUserList registorUserList = (RegistorUserList) application.getAttribute("rul");

	    List<User> userList = new ArrayList<>();
	    if(registorUserList==null) {
	    	registorUserList = new RegistorUserList();
	    }else {
	    	userList = registorUserList.getRegistorUserList();
	    }

	    RegisterUserLogic registerUserLogic = new RegisterUserLogic();
		boolean isRegister = registerUserLogic.execute(userList,user);

		HttpSession session = request.getSession();
		if(isRegister) {
			session.setAttribute("loginUser", null);
		}else {
			session.setAttribute("loginUser", user);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}
