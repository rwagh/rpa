package rpa.apis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import rpa.data.DataHelper;
import rpa.models.ResponseContext;
import rpa.models.UserAccount;

/**
 * Servlet implementation class authenticate
 */
@WebServlet("/authenticate")
public class authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper("jdbc:mysql://localhost:3306/rpauidb?user=root&password=root");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserAccount account = null;
		ResponseContext context = new ResponseContext();
		String json = "";
		if(request.getSession().getAttribute("userinfo") != null) {
			json = String.valueOf(request.getSession().getAttribute("userinfo"));		
			account = new Gson().fromJson(json, UserAccount.class);  
	        
	        context.setId(1);
	        context.setType("Success");
	        context.setAccount(account);
		}else {
			context.setId(0);
	        context.setType("Failed");
		}
		
		json = new Gson().toJson(context);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("Username");
		String password = request.getParameter("LoginPassword");
		UserAccount account = helper.validate(username, password);
		ResponseContext context = new ResponseContext();
		String json = "";
		if(account != null) {
			json = new Gson().toJson(account);
			HttpSession session=request.getSession();  
	        session.setAttribute("userinfo",json);
	        
	        context.setId(1);
	        context.setType("Success");
	        context.setAccount(account);
		}else {
			context.setId(0);
	        context.setType("Failed");
		}
		
		json = new Gson().toJson(context);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();		
	}

}
