package rpa.apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import rpa.data.DataHelper;
import rpa.models.Permissions;
import rpa.models.User;
import rpa.models.UserAccount;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class users extends HttpServlet
{
        private static final long serialVersionUID = 1L;
        DataHelper helper = new DataHelper();

        /**
         * @see HttpServlet#HttpServlet()
         */
        public users()
        {
                super();
                // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
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
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                // TODO Auto-generated method stub
                Permissions permissions = new Permissions();
                if (request.getParameter("type") != null)
                {

                        int type = Integer.valueOf(request.getParameter("type"));
                        User model = new User();
                        if (type == 1)
                        {
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
                                if (fid != null && fid != "")
                                {
                                        model.setFunctionId(Integer.valueOf(fid));
                                        model.setLobId(Integer.valueOf(lid));
                                        model.setProcessId(Integer.valueOf(pid));
                                }

                                if (helper.add(model))
                                {
                                        String[] pageList = request.getParameterValues("pagelist[]");
                                        UserAccount account = null;
                                        String json = "";
                                        if (request.getSession().getAttribute("userinfo") != null)
                                        {
                                                json = String.valueOf(request.getSession().getAttribute("userinfo"));
                                                account = new Gson().fromJson(json, UserAccount.class);
                                                int[] pageID = new int[pageList.length];
                                                if (pageList != null && pageList.length > 0)
                                                {
                                                        int userId = helper.getUserId(model.getUsername());
                                                        permissions.setCreatedBy(account.getId());
                                                        permissions.setDateCreated(new Date());
                                                        permissions.setUserId(userId);
                                                        for (int i = 0; i < pageList.length; i++)
                                                        {
                                                                pageID[i] = Integer.parseInt(pageList[i]);
                                                                System.out.println("Add Page Ids" + pageList[i]);
                                                        }
                                                        permissions.setPageIds(pageID);
                                                        helper.add(permissions);

                                                }
                                        }
                                }
                                else
                                {
                                        System.out.println("Failed to create user:");
                                }

                        }
                        else if (type == 2)
                        {
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

                                String[] pageList = request.getParameterValues("pagelist[]");
                                UserAccount account = null;
                                String json = "";
                              
                                if (request.getSession().getAttribute("userinfo") != null)
                                {
                                        json = String.valueOf(request.getSession().getAttribute("userinfo"));
                                        account = new Gson().fromJson(json, UserAccount.class);
                                        
                                        Date currentTime = new Date();
                                        if (pageList != null)
                                        {
                                                int[] pageID = new int[pageList.length];
                                               
                                                permissions.setUserId(model.getId());
                                                permissions.setDateUpdated(currentTime);
                                                permissions.setUpdatedBy(account.getId());
                                                permissions.setCreatedBy(account.getId());
                                                permissions.setDateCreated(currentTime);
                                                for (int i = 0; i < pageList.length; i++)
                                                {
                                                        pageID[i] = Integer.parseInt(pageList[i]);
                                                        System.out.println("Update Page Ids" + pageList[i]);
                                                }

                                                permissions.setPageIds(pageID);

                                                helper.performAccessiblePageUpdate(permissions);
                                        }
                                        else
                                        {
                                                permissions.setUserId(model.getId());
                                                permissions.setDateUpdated(currentTime);
                                                permissions.setUpdatedBy(account.getId());
                                               
                                                helper.delete(permissions);
                                             
                                        }
                                }

                                if (fid != null && fid != "")
                                {
                                        model.setFunctionId(Integer.valueOf(fid));
                                }

                                if (lid != null && lid != "")
                                {
                                        model.setLobId(Integer.valueOf(lid));
                                }

                                if (pid != null && pid != "")
                                {
                                        model.setProcessId(Integer.valueOf(pid));
                                }
                                helper.update(model);
                        }
                        else if (type == 3)
                        {
                                UserAccount account = null;
                                String json = "";
                                helper.delete(Integer.valueOf(request.getParameter("id")), "Users");
                                if (request.getSession().getAttribute("userinfo") != null)
                                {
                                        json = String.valueOf(request.getSession().getAttribute("userinfo"));
                                        account = new Gson().fromJson(json, UserAccount.class);
                                        Date currentTime = new Date();
                                        permissions.setUserId(Integer.valueOf(request.getParameter("id")));
                                        permissions.setDateUpdated(currentTime);
                                        permissions.setUpdatedBy(account.getId());

                                        helper.delete(permissions);

                                }

                        }
                }
                doGet(request, response);
        }
}
