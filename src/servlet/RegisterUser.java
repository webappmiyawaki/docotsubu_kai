package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.generator.GenerateString;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //doGet
  protected void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {

    String forwardPath = null;
    String action = request.getParameter("action");

    forwardPath = "/WEB-INF/jsp/register/registerForm.jsp";
    HttpSession session = request.getSession();

    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
    dispatcher.forward(request, response);
  }

  //doPost
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String pass = request.getParameter("pass");

	GenerateString gs = new GenerateString();
	if(name.equals("")) {
		name="student_"+gs.getRandomString(4);
	}
	if(pass.equals("")) {
		pass="1234";
	}

    HttpSession session = request.getSession();
    session.setAttribute("registerUser", new User(name,pass));

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register/registerConfirm.jsp");
    dispatcher.forward(request, response);
  }
}