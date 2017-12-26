package rpa.apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import rpa.data.DataHelper;
import rpa.models.User;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper("jdbc:mysql://localhost:3306/rpauidb?user=root&password=root");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public users() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("Name");		
		ArrayList<User> list = helper.getUserList(name);						
		String json = new Gson().toJson(list);
		
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
		if (request.getParameter("type") != null) {
			int type = Integer.valueOf(request.getParameter("type"));
			User model = new User();
			if (type == 1) {				
				model.setUsername(request.getParameter("Username"));
				model.setFirstName(request.getParameter("FirstName"));
				model.setLastName(request.getParameter("LastName"));
				model.setEmail(request.getParameter("Email"));
				model.setMobile(request.getParameter("Mobile"));
				model.setPassword(request.getParameter("Password"));
				model.setRoleId(Integer.valueOf(request.getParameter("RoleId")));
				String fid = request.getParameter("FunctionId");
				String lid = request.getParameter("LobId");
				String pid = request.getParameter("ProcessId");
				if(fid!=null && fid !="") {
					model.setFunctionId(Integer.valueOf(fid));
					model.setLobId(Integer.valueOf(lid));
					model.setProcessId(Integer.valueOf(pid));
				}
				helper.add(model);
			} else if (type == 2) {				
				model.setId(Integer.valueOf(request.getParameter("id")));
				model.setUsername(request.getParameter("Username"));
				model.setFirstName(request.getParameter("FirstName"));
				model.setLastName(request.getParameter("LastName"));
				model.setEmail(request.getParameter("Email"));
				model.setMobile(request.getParameter("Mobile"));
				model.setRoleId(Integer.valueOf(request.getParameter("RoleId")));
				String fid = request.getParameter("FunctionId");
				String lid = request.getParameter("LobId");
				String pid = request.getParameter("ProcessId");
				
				if(fid != null && fid !="") {
					model.setFunctionId(Integer.valueOf(fid));					
				}
				
				if(lid != null && lid != "") {
					model.setLobId(Integer.valueOf(lid));					
				}
				
				if(pid != null && pid != "") {
					model.setProcessId(Integer.valueOf(pid));
				}
				helper.update(model);
			} else if (type == 3) {
				helper.delete(Integer.valueOf(request.getParameter("id")), "Users");
			}
		}	
		doGet(request, response);
	}
}
