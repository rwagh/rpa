package rpa.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rpa.models.*;

public final class DataHelper {
	private String connectionString;
	private Connection conn;

	public DataHelper(String connectionString) {
		this.connectionString = connectionString;
	}

	public ArrayList<Lob> getLobList(String name) {
		ArrayList<Lob> lobs = new ArrayList<Lob>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT A.Id, A.Name, A.Description, A.FunctionId, B.Name as FunctionName FROM lobs A LEFT JOIN functions B ON A.FunctionId = B.Id ORDER BY A.Id ASC";
			if(name != null) {
				sql="SELECT A.Id, A.Name, A.Description, A.FunctionId, B.Name as FunctionName FROM lobs A LEFT JOIN functions B ON A.FunctionId = B.Id WHERE LOWER(CONCAT(A.Name, B.Name)) LIKE '%" + name.toLowerCase() + "%' ORDER BY A.Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Lob lob = new Lob();
				lob.setId(rs.getInt("Id"));
				lob.setName(rs.getString("Name"));
				lob.setDescription(rs.getString("Description"));
				lob.setFunctionId(rs.getInt("FunctionId"));
				lob.setFunctionName(rs.getString("FunctionName"));
				lobs.add(lob);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return lobs;
	}
	
	public Boolean add(Lob model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Lobs(Name, Description, FunctionId) VALUES('" + model.getName() + "','"
					+ model.getDescription() + "'," + model.getFunctionId() + ")");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	
	public Boolean update(Lob model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Lobs SET Name='" + model.getName() + "', Description='" + model.getDescription() +"', FunctionId=" + model.getFunctionId() + " WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}


	public ArrayList<Function> getFunctionList(String name) {
		ArrayList<Function> list = new ArrayList<Function>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT Id, Name, Description FROM Functions ORDER BY Id ASC";
			if(name != null) {
				sql="SELECT Id, Name, Description FROM Functions WHERE LOWER(Name) LIKE '%" + name.toLowerCase() + "%' ORDER BY Id ASC";
			}
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Function model = new Function();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				model.setDescription(rs.getString("Description"));
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}

	public Boolean add(Function model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Functions(Name, Description) VALUES('" + model.getName() + "','"
					+ model.getDescription() + "')");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Function model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Functions SET Name='" + model.getName() + "', Description='" + model.getDescription() +"' WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public Boolean delete(int key, String table) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			String sql = "DELETE FROM " + table +" WHERE Id= ?";
	        PreparedStatement query = conn.prepareStatement(sql);
	        query.setInt(1, key);
	        flag = query.execute();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<ProcessEntity> getProcessList(String name) {
		ArrayList<ProcessEntity> list = new ArrayList<ProcessEntity>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT A.Id, A.Name, A.Description, A.LobId, B.Name as LobName, B.FunctionId, C.Name as FunctionName, A.ParentId, (SELECT Name FROM processes WHERE Id = A.ParentId) ParentName FROM processes as A LEFT JOIN lobs B ON A.LobId = B.Id LEFT JOIN functions C on B.FunctionId = C.Id ORDER BY A.Id ASC";
			if(name != null) {
				sql="SELECT A.Id, A.Name, A.Description, A.LobId, B.Name as LobName, B.FunctionId, C.Name as FunctionName, A.ParentId, (SELECT Name FROM processes WHERE Id = A.ParentId) ParentName FROM processes as A LEFT JOIN lobs B ON A.LobId = B.Id LEFT JOIN functions C on B.FunctionId = C.Id WHERE LOWER(CONCAT(A.Name, B.Name)) LIKE '%" + name.toLowerCase() + "%' ORDER BY A.Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				ProcessEntity model = new ProcessEntity();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				model.setDescription(rs.getString("Description"));
				model.setParentId(rs.getInt("ParentId"));
				model.setParentName(rs.getString("ParentName"));
				model.setLobId(rs.getInt("LobId"));
				model.setLobName(rs.getString("LobName"));
				model.setFunctionId(rs.getInt("FunctionId"));
				model.setFunctionName(rs.getString("FunctionName"));
				
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(ProcessEntity model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			if(model.getParentId()>0) {
				flag = query.execute("INSERT INTO Processes(Name, Description, LobId, ParentId) VALUES('" + model.getName() + "','"			
					+ model.getDescription() + "'," + model.getLobId() + "," + model.getParentId() + ")");
			}else {
				flag = query.execute("INSERT INTO Processes(Name, Description, LobId, ParentId) VALUES('" + model.getName() + "','"			
						+ model.getDescription() + "'," + model.getLobId() + ",null)");
			}

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(ProcessEntity model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Processes SET Name='" + model.getName() + "', Description='" + model.getDescription() +"', LobId=" + model.getLobId() +", ParentId="+ model.getParentId() + " WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<Activity> getActivityList(String name) {
		ArrayList<Activity> list = new ArrayList<Activity>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT A.Id, A.Name, A.Description, A.ProcessId, B.Name as ProcessName, B.LobId, C.Name as LobName, D.Id as FunctionId, D.Name as FunctionName FROM activities A LEFT JOIN processes B ON B.Id = A.ProcessId LEFT JOIN lobs C ON B.LobId = C.Id LEFT JOIN functions D on C.FunctionId = D.Id ORDER BY A.Id ASC";
			if(name != null) {
				sql="SELECT A.Id, A.Name, A.Description, A.ProcessId, B.Name as ProcessName, B.LobId, C.Name as LobName, D.Id as FunctionId, D.Name as FunctionName FROM activities A LEFT JOIN processes B ON B.Id = A.ProcessId LEFT JOIN lobs C ON B.LobId = C.Id LEFT JOIN functions D on C.FunctionId = D.Id WHERE LOWER(CONCAT(A.Name, B.Name)) LIKE '%" + name.toLowerCase() + "%' ORDER BY A.Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Activity model = new Activity();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				model.setDescription(rs.getString("Description"));
				model.setProcessId(rs.getInt("ProcessId"));
				model.setProcessName(rs.getString("ProcessName"));
				model.setLobName(rs.getString("LobName"));
				model.setLobId(rs.getInt("LobId"));
				model.setLobName(rs.getString("LobName"));
				model.setFunctionId(rs.getInt("FunctionId"));
				model.setFunctionName(rs.getString("FunctionName"));
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(Activity model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Activities(Name, Description, ProcessId) VALUES('" + model.getName() + "','"
					+ model.getDescription() + "'," + model.getProcessId() + ")");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Activity model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Activities SET Name='" + model.getName() + "', Description='" + model.getDescription() +"', ProcessId=" + model.getProcessId() + " WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<Step> getStepList(String name) {
		ArrayList<Step> list = new ArrayList<Step>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT A.Id, A.Name, A.Description, A.ActivityId, B.Name as ActivityName, B.ProcessId, C.Name as ProcessName, C.LobId, D.Name as LobName, E.Id as FunctionId, E.Name as FunctionName, A.Required FROM steps A LEFT JOIN activities B ON B.Id = A.ActivityId LEFT JOIN processes C ON C.Id = B.ProcessId LEFT JOIN lobs D ON C.LobId = D.Id LEFT JOIN functions E on D.FunctionId = E.Id ORDER BY A.Id ASC";
			if(name != null) {
				sql="SELECT A.Id, A.Name, A.Description, A.ActivityId, B.Name as ActivityName, B.ProcessId, C.Name as ProcessName, C.LobId, D.Name as LobName, E.Id as FunctionId, E.Name as FunctionName, A.Required FROM steps A LEFT JOIN activities B ON B.Id = A.ActivityId LEFT JOIN processes C ON C.Id = B.ProcessId LEFT JOIN lobs D ON C.LobId = D.Id LEFT JOIN functions E on D.FunctionId = E.Id WHERE LOWER(CONCAT(A.Name,B.Name,C.Name,D.Name,E.Name)) LIKE '%" + name.toLowerCase() + "%' ORDER BY A.Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Step model = new Step();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				model.setDescription(rs.getString("Description"));
				model.setActivityId(rs.getInt("ActivityId"));
				model.setActivityName(rs.getString("ActivityName"));
				model.setProcessId(rs.getInt("ProcessId"));
				model.setProcessName(rs.getString("ProcessName"));				
				model.setLobId(rs.getInt("LobId"));
				model.setLobName(rs.getString("LobName"));
				model.setFunctionId(rs.getInt("FunctionId"));
				model.setFunctionName(rs.getString("FunctionName"));
				model.setRequired(rs.getInt("Required"));
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(Step model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Steps(Name, Description, ActivityId, Required) VALUES('" + model.getName() + "','"
					+ model.getDescription() + "'," + model.getActivityId() + "," + model.getRequired() + ")");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Step model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Steps SET Name='" + model.getName() + "', Description='" + model.getDescription() +"', ActivityId=" + model.getActivityId() + ", Required=" + model.getRequired() + " WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<Group> getGroupList(String name) {
		ArrayList<Group> list = new ArrayList<Group>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT Id, Name FROM groups ORDER BY Id ASC";
			if(name != null) {
				sql="SELECT Id, Name FROM groups WHERE LOWER(Name) LIKE '%" + name.toLowerCase() + "%' ORDER BY Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Group model = new Group();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));				
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(Group model) {
		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Groups(Name) VALUES('" + model.getName() + "')");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Group model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Groups SET Name='" + model.getName() + "' WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<Role> getRoleList(String name) {
		ArrayList<Role> list = new ArrayList<Role>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT Id, Name FROM roles ORDER BY Id ASC";
			if(name != null) {
				sql="SELECT Id, Name FROM roles WHERE LOWER(Name) LIKE '%" + name.toLowerCase() + "%' ORDER BY Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Role model = new Role();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));				
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(Role model) {
		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Roles(Name) VALUES('" + model.getName() + "')");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Role model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Roles SET Name='" + model.getName() + "' WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<User> getUserList(String name) {
		ArrayList<User> list = new ArrayList<User>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT Id, Username, FirstName, LastName, Email, Mobile FROM users ORDER BY Id ASC";
			if(name != null) {
				sql="SELECT Id, Username, FirstName, LastName, Email, Mobile FROM users WHERE LOWER(CONCAT(Username, FirstName, LastName, Email, Mobile)) LIKE '%" + name.toLowerCase() + "%' ORDER BY Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				User model = new User();
				model.setId(rs.getInt("Id"));
				model.setUsername(rs.getString("Username"));				
				model.setFirstName(rs.getString("FirstName"));
				model.setLastName(rs.getString("LastName"));
				model.setEmail(rs.getString("Email"));
				model.setMobile(rs.getString("Mobile"));
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(User model) {
		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO Users(Username, FirstName, LastName, Email, Mobile, Password, RoleId, FunctionId, LobId, ProcessId) VALUES('" + model.getUsername() + "','" + model.getFirstName() + "','" + model.getLastName() + "','" + model.getEmail() + "','" + model.getMobile() + "','" + model.getPassword() + "'," + 
			model.getRoleId() + "," + String.valueOf((model.getFunctionId() > 0) ? model.getFunctionId() : "null") + "," + String.valueOf((model.getLobId() > 0) ? model.getLobId() : "null") + "," + String.valueOf((model.getProcessId() > 0) ? model.getProcessId() : "null") + ")");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(User model) {
		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE Users SET Username='" + model.getUsername() + "', FirstName='" + model.getFirstName() + "', LastName='" + model.getLastName() + "',Email='" + model.getEmail() + "',Mobile='" + model.getMobile() + 
					"',RoleId=" + model.getRoleId()	
					+ ", FunctionId=" + String.valueOf((model.getFunctionId() > 0) ? model.getFunctionId() : "null")
					+ ", LobId=" + String.valueOf((model.getLobId() > 0) ? model.getLobId() : "null")
					+ ", ProcessId=" + String.valueOf((model.getProcessId() > 0) ? model.getProcessId() : "null")
					+" WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public ArrayList<Page> getPageList(String name) {
		ArrayList<Page> list = new ArrayList<Page>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT Id, Name, Url FROM pages ORDER BY Id ASC";
			if(name != null) {
				sql="SELECT Id, Name, Url FROM pages WHERE LOWER(Name) LIKE '%" + name.toLowerCase() + "%' ORDER BY Id ASC";
			}
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			while (rs.next()) {
				Page model = new Page();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				model.setUrl(rs.getString("Url"));	
				list.add(model);
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}
	
	public Boolean add(Page model) {
		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("INSERT INTO pages(Name, Url) VALUES('" + model.getName() + "','" + model.getUrl() + "')");

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}

	public Boolean update(Page model) {

		Boolean flag = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Statement query = conn.createStatement();
			flag = query.execute("UPDATE pages SET Name='" + model.getName() + "', Url='" + model.getUrl() + "' WHERE Id=" + model.getId());

			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ex: " + ex.toString());
		}
		return flag;
	}
	
	public UserAccount validate(String username, String password) {

		UserAccount account = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(this.connectionString);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			String sql="SELECT A.Id, A.Username, A.FirstName, A.LastName, A.Email, A.Mobile, B.Name Role, A.FunctionId, C.Name FunctionName, A.LobId, D.Name LobName, A.ProcessId, E.Name ProcessName FROM users A LEFT JOIN Roles B ON A.RoleId = B.Id LEFT JOIN Functions C ON A.FunctionId = C.Id LEFT JOIN Lobs D ON A.LobId = D.Id LEFT JOIN Processes E ON A.ProcessId = E.Id WHERE A.Username='" +  username + "' AND A.Password='" + password + "'";			
			
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(sql);

			if (rs.next()) {
				account = new UserAccount();
				account.setId(rs.getInt("Id"));
				account.setUsername(rs.getString("Username"));
				account.setFirstName(rs.getString("FirstName"));
				account.setLastName(rs.getString("LastName"));
				account.setEmail(rs.getString("Email"));
				account.setMobile(rs.getString("Mobile"));
				account.setRole(rs.getString("Role"));
				account.setFunctionId(rs.getInt("FunctionId"));
				account.setFunctionName(rs.getString("FunctionName"));
				account.setLobId(rs.getInt("LobId"));
				account.setLobName(rs.getString("LobName"));
				account.setProcessId(rs.getInt("ProcessId"));
				account.setProcessName(rs.getString("ProcessName"));
			}
			rs.close();
			query.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return account;
	}
}
