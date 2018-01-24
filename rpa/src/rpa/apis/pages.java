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
import rpa.models.Page;

/**
 * Servlet implementation class pages
 */
@WebServlet("/pages")
public class pages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataHelper helper = new DataHelper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pages() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("PageName");		
		ArrayList<Page> list = helper.getPageList(name);						
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
			Page model = new Page();
			if (type == 1) {				
				model.setName(request.getParameter("PName"));				
				model.setUrl(request.getParameter("Url"));
				helper.add(model);
			} else if (type == 2) {				
				model.setId(Integer.valueOf(request.getParameter("id")));
				model.setName(request.getParameter("PName"));
				model.setUrl(request.getParameter("Url"));
				helper.update(model);
			} else if (type == 3) {
				helper.delete(Integer.valueOf(request.getParameter("id")), "Pages");
			}
		}	
		doGet(request, response);
	}
}
