<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuration</title>
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
			<li class="active"><a data-toggle="tab" href="#tabFunctions">Functions</a></li>
			<li><a data-toggle="tab" href="#home">Line Of Businesses</a></li>
			<li><a data-toggle="tab" href="#menu1">Processes</a></li>
			<li><a data-toggle="tab" href="#menu2">Sub Processes</a></li>
			<li><a data-toggle="tab" href="#menu3">Activities</a></li>
			<li><a data-toggle="tab" href="#menu4">Steps</a></li>
		</ul>
		<div class="tab-content" id="tabholder">
			<div class="row">
				<div class="col-lg-12 col-md-12">&nbsp;</div>
			</div>
			<div id="tabFunctions" class="tab-pane fade in active">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name"
									title="Search By Name" id="FunctionName"
									class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button type="button" class="btn btn-primary btn-block btn-sm"
									id="FunctionSearch">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" class="btn btn-primary btn-block addfunc"
									title="Add New Function" data-toggle="modal"
									data-target="#functionModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New Function</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody id="func_tbody">
					</tbody>
				</table>
			</div>

			<div id="home" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name" id="LobSearch"
									title="Search By Name" class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm" id="SearchLob">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" class="btn btn-primary btn-block addlob"
									title="Add New Line Of Business" data-toggle="modal"
									data-target="#lobModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Function</th>
							<th>Name</th>
							<th>Description</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="lob_tbody">
					</tbody>
				</table>
			</div>
			<div id="menu1" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name"
									title="Search By Name" class="form-control input-sm"
									id="ProcessName" name="ProcessName" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm"
									id="SearchProcess">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" class="btn btn-primary btn-block addprocess"
									title="Add New Process" data-toggle="modal"
									data-target="#processModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Lob</th>
							<th>Process</th>
							<th>Description</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="process_tbody">
					</tbody>
				</table>
			</div>
			<div id="menu2" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name"
									title="Search By Name" class="form-control input-sm"
									id="SubProcessName" name="SubProcessName" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm"
									id="SearchSubProcess">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" class="btn btn-primary btn-block addprocess"
									title="Add New Sub Process" data-toggle="modal"
									data-target="#subProcessModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Lob</th>
							<th>Process</th>
							<th>Sub Process</th>
							<th>Description</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="process_tbody">
					</tbody>
				</table>
			</div>
			<div id="menu3" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name"
									id="ActivityName" name="ActivityName" title="Search By Name"
									class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm"
									id="SearchActivity">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button" class="btn btn-primary btn-block addactivity"
									title="Add New Activity" data-toggle="modal"
									data-target="#activityModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Process</th>
							<th>Activity</th>
							<th>Description</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="activity_tbody">
					</tbody>
				</table>
			</div>
			<div id="menu4" class="tab-pane fade">
				<div class="list-group-item">
					<div class="form-group">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<input type="text" placeholder="Search By Name" id="Name"
									title="Search By Name" class="form-control input-sm" />
							</div>
							<div class="col-lg-1 col-md-1">
								<button class="btn btn-primary btn-block btn-sm" id="SearchStep">Search</button>
							</div>
							<div class="col-lg-2 col-md-2 col-lg-offset-5 col-md-offset-5">
								<a role="button"
									class="btn btn-primary btn-block btn-sm addstep"
									title="Add New Step" data-toggle="modal"
									data-target="#stepModal"><i class="fa fa-plus"
									aria-hidden="true"></i> Add New</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<th>Activity</th>
							<th>Step</th>
							<th>Description</th>
							<th>Required</th>
							<th style="width: 150px">Actions</th>
						</tr>
					</thead>
					<tbody id="step_tbody">
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@include file="footer.html"%>
	<div id="functionModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Function</h4>
				</div>
				<div class="modal-body">
					<form id="functionForm">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Function Name</label> 
									<input type="text" name="Name"
										placeholder="Function Name" title="Function Name"
										class="form-control input-sm name" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="SaveFunction"
						class="btn btn-default btn-sm">Save</button>
					<button type="button" class="btn btn-danger btn-sm"
						data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
	<div id="lobModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Line of Business</h4>
				</div>
				<div class="modal-body">
					<form id="lobForm">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Lob Name</label> 
									<input type="text" name="Name" placeholder="Lob Name" title="Lob Name"
										class="form-control input-sm name" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Function</label> 
									<select title="Select Function" name="FunctionId"
										class="form-control input-sm function">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="SaveLob" class="btn btn-default btn-sm"
						data-dismiss="modal">Save</button>
					<button type="button" class="btn btn-danger btn-sm"
						data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
	<div id="processModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<form id="processForm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Process</h4>
					</div>
					<div class="modal-body">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Process Name</label> 
									<input type="text" name="Name" placeholder="Process Name" title="Process Name"
										class="form-control input-sm name"
										oninvalid="this.setCustomValidity('Process Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Function</label> <select title="Select Function" name="FunctionId"
										class="form-control input-sm function"
										oninvalid="this.setCustomValidity('Please select function!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Line Of Business</label> <select name="LobId"
										title="Select Line Of Business" class="form-control input-sm lob"
										oninvalid="this.setCustomValidity('Please select lob!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select Lob</option>
									</select>
								</div>
							</div>
						</div>						
					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveSubProcess"
							class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="subProcessModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<form id="subProcessForm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Process</h4>
					</div>
					<div class="modal-body">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Process Name</label> 
									<input type="text" 
										name="Name" placeholder="Process Name" title="Process Name"
										class="form-control input-sm name"
										oninvalid="this.setCustomValidity('Process Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Function</label> 
									<select title="Select Function" name="FunctionId"
										class="form-control input-sm function"
										oninvalid="this.setCustomValidity('Please select function!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Line Of Business</label> <select name="LobId"
										title="Select Line Of Business" class="form-control input-sm lob"
										oninvalid="this.setCustomValidity('Please select lob!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select Lob</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Parent Process</label> 
									<select name="ParentId" title="Select Parent Process"
										class="form-control input-sm process">
										<option value="0">Select Parent Process</option>
									</select>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveProcess"
							class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="activityModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<form id="activityForm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Activity</h4>
					</div>
					<div class="modal-body">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Name</label> <input type="text" name="Name"
										placeholder="Activity Name" title="Activity Name"
										class="form-control input-sm activity" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Function</label> 
									<select title="Select Function" name="FunctionId"
										class="form-control input-sm function">
										<option value="0">Select</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Line Of Business</label> <select name="LobId"
										title="Select Line Of Business" class="form-control input-sm lob">
										<option value="0">Select Lob</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Process</label> 
									<select name="ProcessId" title="Select Process" 
										class="form-control input-sm process">
										<option value="0">Select Process</option>
									</select>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" id="SaveActivity"
							class="btn btn-default btn-sm" data-dismiss="modal">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="stepModal" class="modal fade" role="dialog"
		data-backdrop="static">
		<div class="modal-dialog modal-md">
			<!-- Modal content-->
			<form id="stepForm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Step</h4>
					</div>
					<div class="modal-body">
						<input name="type" type="hidden" class="type" value="1"> 
						<input name="id" type="hidden" class="id">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Name</label> 
									<input type="text" name="Name"
										placeholder="Step Name" title="Step Name"
										class="form-control input-sm name"
										oninvalid="this.setCustomValidity('Step Name can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Description</label>
									<textarea type="text" name="Description"
										placeholder="Description" title="Description"
										class="form-control input-sm description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Function</label> 
									<select title="Select Function" name="FunctionId"
										class="form-control input-sm function"
										oninvalid="this.setCustomValidity('Please select function!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select</option>
									</select>
								</div>
							</div>

							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Line Of Business</label> 
									<select name="LobId"
										title="Select Line Of Business" class="form-control input-sm lob"
										oninvalid="this.setCustomValidity('Please select lob!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select Lob</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Process</label> <select name="ProcessId"
										title="Select Process" class="form-control input-sm process"
										oninvalid="this.setCustomValidity('Please select process!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select Process</option>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6">
								<div class="form-group">
									<label>Activity</label> 
									<select name="ActivityId" title="Select Process"
										class="form-control input-sm activity"
										oninvalid="this.setCustomValidity('Please select activity!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select Activity</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label>Required</label> <select id="Required" name="Required"
										title="Select Process" class="form-control input-sm"
										oninvalid="this.setCustomValidity('Please select required!');"
										oninput="this.setCustomValidity('')" required>
										<option value="">Select</option>
										<option value="0">Yes</option>
										<option value="1">No</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" id="SaveStep" class="btn btn-default btn-sm">Save</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/config.js"></script>
</body>
</html>