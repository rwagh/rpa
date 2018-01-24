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
import rpa.models.Step;

/**
 * Servlet implementation class steps
 */
@WebServlet("/steps")
public class steps extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public steps() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("Name");		
		ArrayList<Step> lob_list = helper.getStepList(name);						
		String json = new Gson().toJson(lob_list);
		
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
			Step model = new Step();
			if (type == 1) {				
				model.setName(request.getParameter("Name"));
				model.setDescription(request.getParameter("Description"));
				model.setActivityId(Integer.valueOf(request.getParameter("ActivityId")));
				model.setRequired(Integer.valueOf(request.getParameter("Required")));
				helper.add(model);
			} else if (type == 2) {				
				model.setId(Integer.valueOf(request.getParameter("id")));
				model.setName(request.getParameter("Name"));
				model.setDescription(request.getParameter("Description"));
				model.setActivityId(Integer.valueOf(request.getParameter("ActivityId")));
				model.setRequired(Integer.valueOf(request.getParameter("Required")));
				helper.update(model);
			} else if (type == 3) {
				helper.delete(Integer.valueOf(request.getParameter("id")), "Steps");
			}
		}		
		doGet(request, response);
	}
}
