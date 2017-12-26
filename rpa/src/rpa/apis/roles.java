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
import rpa.models.Role;

/**
 * Servlet implementation class roles
 */
@WebServlet("/roles")
public class roles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper("jdbc:mysql://localhost:3306/rpauidb?user=root&password=root");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roles() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("RoleName");		
		ArrayList<Role> list = helper.getRoleList(name);						
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
			Role model = new Role();
			if (type == 1) {				
				model.setName(request.getParameter("RName"));				
				helper.add(model);
			} else if (type == 2) {				
				model.setId(Integer.valueOf(request.getParameter("id")));
				model.setName(request.getParameter("RName"));				
				helper.update(model);
			} else if (type == 3) {
				helper.delete(Integer.valueOf(request.getParameter("id")), "Roles");
			}
		}	
		doGet(request, response);
	}
}
