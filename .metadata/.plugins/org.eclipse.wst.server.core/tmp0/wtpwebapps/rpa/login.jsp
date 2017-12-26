<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@include file="includes.html"%>
</head>
<body>
	<header> 
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<div>
						<img style="height: 100%; width: 40%; margin-top: 5px;"
							src="assets/images/logo.png">
					</div>
				</div>
			</div>
		</nav> 
	</header>
	<div class="container-fluid" id="placeholder">
	<div class="vertical-alignment-helper">
		<div class="vertical-align-center" style="text-align:center;">
			<div class="lcontainer" style="margin:auto; width:280px;">
				<form id="loginForm">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="form-group text-left">
								<label>Username</label>
								<input type="text" id="Username" name="Username" class="form-control input-sm" oninvalid="this.setCustomValidity('Username can\'t left empty!');"
										oninput="this.setCustomValidity('')" required/>
							</div>
						</div>
					</div> 
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="form-group text-left">
								<label>Password</label>
								<input type="password" id="LoginPassword" name="LoginPassword" class="form-control input-sm" oninvalid="this.setCustomValidity('Password can\'t left empty!');"
										oninput="this.setCustomValidity('')" required />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="form-group text-left">
								<button id="btnLogin" type="submit" class="btn btn-primary btn-sm">Login</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
		<div>
		</div>
	</div>
	<%@include file="footer.html"%>
	<script type="text/javascript">
		$("#placeholder").height($(document).height() - 85);
		$(window).resize(function() {
			$("#placeholder").height($(document).height() - 85);
		});
		$("#btnLogin").click(function(){
			var json = $("#loginForm").serializeObject();
			var flag = $("#loginForm")[0].checkValidity();
			if(flag){
				$.ajax({
					data : json,
					method : "POST",
					url : "authenticate",
					success : function(result) {						
						if(result.id > 0){
							window.location.href ="index.jsp";	
						}
					}
				});
				return false;
			}
		});
		
	</script>
</body>
</html>