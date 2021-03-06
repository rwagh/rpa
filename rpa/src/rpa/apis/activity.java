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
import rpa.models.Activity;

/**
 * Servlet implementation class activity
 */
@WebServlet("/activity")
public class activity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json ="";
		String name = request.getParameter("ActivityName");	
		if(name!=null && name !="") {
			ArrayList<Activity> list = helper.getActivityList(name);
			json = new Gson().toJson(list);
		}else {
			ArrayList<Activity> list = helper.getActivityList(name);
			json = new Gson().toJson(list);
		}
	
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("type") != null) {
			int type = Integer.valueOf(request.getParameter("type"));
			Activity model = new Activity();
			if (type == 1) {
				model.setName(request.getParameter("Name"));
				model.setDescription(request.getParameter("Description"));				
				model.setProcessId(Integer.valueOf(request.getParameter("ProcessId")));
				
				helper.add(model);
			} else if (type == 2) {
				model.setId(Integer.valueOf(request.getParameter("id")));
				model.setName(request.getParameter("Name"));
				model.setDescription(request.getParameter("Description"));
				model.setProcessId(Integer.valueOf(request.getParameter("ProcessId")));
				helper.update(model);
			} else if (type == 3) {
				helper.delete(Integer.valueOf(request.getParameter("id")), "Activities");
			}
		}
		doGet(request, response);
	}

}
