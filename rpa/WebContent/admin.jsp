<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
<%@include file="includes.html"%>
<%@include file="in.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid" id="placeholder">
		<div class="row">
			<div class="col-lg-12 col-md-12">&nbsp;</div>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#tabGroups">Groups</a></li>
			<li><a data-toggle="tab" href="#tabRoles">Roles</a></li>
			<li><a data-toggle="tab" href="#tabUsers">Users</a></li>
			<li><a data-toggle="tab" href="#tabPages">Pages</a></li>
		</ul>
		<div class="tab-content" id="tabholder">
			<div class="row">
				<div class="col-lg-12 col-md-12">&nbsp;</div>
			</div>
			<div id="tabGroups" class="tab-pane fade in active">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name" id="GroupName"
									name="GroupName" title="Search By Name"
									class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm"
									id="SearchGroup">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" title="Add New Group" data-toggle="modal"
									data-target="#groupModal"
									class="btn btn-primary btn-block btn-sm addgroup"><i
									class="fa fa-plus" aria-hidden="true"></i> Add New Group</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="group_tbody">
					</tbody>
				</table>
			</div>
			<div id="tabRoles" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name"
									title="Search By Name" class="form-control input-sm"
									id="RoleName" name="RoleName" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm" id="SearchRole">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" title="Add New Role" data-toggle="modal"
									data-target="#roleModal"
									class="btn btn-primary btn-block addrole"><i
									class="fa fa-plus" aria-hidden="true"></i> Add New Role</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th style="width: 50px">#</th>
							<th>Name</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="role_tbody">
					</tbody>
				</table>
			</div>
			<div id="tabUsers" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search Text" title="Search Text"
									class="form-control input-sm" id="Name" name="Name" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm" id="SearchUser">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" title="Add New User" data-toggle="modal"
									data-target="#userModal"
									class="btn btn-primary btn-block adduser"><i
									class="fa fa-plus" aria-hidden="true"></i> Add New User</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th style="width: 75px">#</th>
							<th>Username</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="user_tbody">
					</tbody>
				</table>
			</div>
			<div id="tabPages" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name" id="PageName"
									name="PageName" title="Search By Name"
									class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm" id="SearchPage">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" title="Add New Group" data-toggle="modal"
									data-target="#pageModal"
									class="btn btn-primary btn-block btn-sm addpage"><i
									class="fa fa-plus" aria-hidden="true"></i> Add New Page</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Url</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="page_tbody">
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@include file="footer.html"%>
	<div id="groupModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<form id="groupForm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Group</h4>
					</div>
					<div class="modal-body">
						<input id="type" name="type" type="hidden" value="1" /> <input
							id="id" name="id" type="hidden" />
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Group Name</label> <input type="text" id="GName"
										name="GName" placeholder="Group Name" title="Group Name"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Group Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveGroup"
							class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="roleModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<form id="roleForm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Role</h4>
					</div>
					<div class="modal-body">
						<input id="type" name="type" type="hidden" value="1" /> <input
							id="id" name="id" type="hidden" />
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Role Name</label> <input type="text" id="RName"
										name="RName" placeholder="Role Name" title="Role Name"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Role Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveRole" class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="userModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog">
			<form id="userForm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">User</h4>
					</div>
					<div class="modal-body">
						<input id="type" name="type" type="hidden" value="1" /> <input
							id="id" name="id" type="hidden" />
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>First Name</label> <input type="text" id="FirstName"
										name="FirstName" placeholder="First Name" title="First Name"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('First Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Last Name</label> <input type="text" id="LastName"
										name="LastName" placeholder="Last Name" title="Last Name"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Last Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Email</label> <input type="text" id="Email" name="Email"
										placeholder="Email" title="Email"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Email can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Mobile</label> <input type="text" id="Mobile"
										name="Mobile" placeholder="Mobile" title="Mobile"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Mobile can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Username</label> <input type="text" id="Username"
										name="Username" placeholder="Username" title="Username"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Username can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>

							<div class="col-lg-6 col-md-6" id="pwd">
								<div class="form-group">
									<label>Password</label> <input type="password" id="Password"
										name="Password" placeholder="Password" title="Password"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Password can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Role</label> <select type="text" id="RoleId"
										name="RoleId" title="Role"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('User Role can\'t left empty!');"
										oninput="this.setCustomValidity('')" required></select>
								</div>
							</div>

							<div class="col-lg-6 col-md-6" id="pwd">
								<div class="form-group">
									<label>Function</label> 
									<select id="FunctionId"	name="FunctionId" title="Select Function" class="form-control input-sm"></select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6" id="pwd">
								<div class="form-group">
									<label>Lob</label> 
									<select id="LobId"	name="LobId" title="Select Lob" class="form-control input-sm"></select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6" id="pwd">
								<div class="form-group">
									<label>Process</label> 
									<select id="ProcessId"	name="ProcessId" title="Select Process" class="form-control input-sm"></select>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveUser" class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="pageModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<form id="pageForm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Page</h4>
					</div>
					<div class="modal-body">
						<input id="type" name="type" type="hidden" value="1" /> <input
							id="id" name="id" type="hidden" />
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Page Name</label> <input type="text" id="PName"
										name="PName" placeholder="Page Name" title="Page Name"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Page Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
					<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Url</label> <input type="text" id="Url"
										name="Url" placeholder="Page Url" title="Page Url"
										class="form-control input-sm"
										oninvalid="this.setCustomValidity('Page Url can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="SavePage"
							class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/admin.js"></script>
</body>
</html>