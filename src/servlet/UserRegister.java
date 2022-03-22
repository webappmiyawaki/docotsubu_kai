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
import model.UserRegisterLogic;

/**
 * ユーザー登録に関するリクエストを受け付けるサーブレットクラス。
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("done")){
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			session.removeAttribute("registerUser");
			UserRegisterLogic url = new UserRegisterLogic();
			Boolean result = url.execute(registerUser);
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterResult.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		if(pass.equals(pass2)){
			User user = new User(id, name, pass);
			HttpSession session = request.getSession();
			session.setAttribute("registerUser", user);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterConfirm.jsp");
			rd.forward(request, response);
		}else {
			String errorMsg = "入力されたパスワードが一致しません";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			rd.forward(request, response);
		}
	}

}