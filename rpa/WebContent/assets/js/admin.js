$(function() {
	$("#placeholder").height($(document).height() - 78);
	$(window).resize(function() {
		$("#placeholder").height($(document).height() - 78);
	});

	$('.addgroup').click(function() {
		$("#groupModal #id").val("");
		$("#groupModal #type").val(1);
		$("#groupModal #Name").val("");				
	});
	
	$('.addrole').click(function() {
		$("#roleModal #id").val("");
		$("#roleModal #type").val(1);
		$("#roleModal #Name").val("");				
	});
	
	$('.adduser').click(function() {
		$("#userModal #id").val("");
		$("#userModal #type").val(1);
		$("#userModal #Username").val("");				
		$("#userModal #FirstName").val("");
		$("#userModal #LastName").val("");
		$("#userModal #Email").val("");
		$("#userModal #Mobile").val("");
		$("#userModal #pwd").show();
		$("#userModal #Password").val("");
	});
	
	$('.addpage').click(function() {
		$("#pageModal #id").val("");
		$("#pageModal #type").val(1);
		$("#pageModal #Name").val("");				
		$("#pageModal #Url").val("");
	});
	
	$.getJSON("lobs", {}, function(result) {		
		$("#userModal #LobId").empty();
		$("#userModal #LobId").append("<option value=''>Select</option>")
		$.each(result, function(index, item) {
			$("#userModal #LobId").append("<option value='" + item.id +"'>" + item.name +"</option>");			
		});
	});
	
	$.getJSON("roles", {}, function(result) {
		$("#role_tbody").empty();
		$("#userModal #RoleId").empty();
		$("#userModal #RoleId").append("<option value=''>Select</option>")
		$.each(result, function(index, item) {
			$("#userModal #RoleId").append("<option value='" + item.id +"'>" + item.name +"</option>");
			$.get("templates/role_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#role_tbody");
			});
		});
	});

	$("#SearchRole").click(function() {
		$.getJSON("roles?RoleName=" + $("#tabRoles #RoleName").val(), {
			RoleName : $("#tabRoles #RoleName").val()
		}, function(result) {
			$("#role_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/role_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#role_tbody");
				});
			});
		});
		return false;
	});
	
	$("#role_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");				
		
		$("#roleModal .type").val(2);
		$("#roleModal .id").val(id);
		$("#roleModal .name").val(name);				
		
		$("#roleModal").modal("show");
	});

	$("#role_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "roles?type=3&id="+ key,
				success : function(result) {										
					$("#role_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/role_item.html", function(tmp_data) {
							$.tmpl(tmp_data, item).appendTo("#role_tbody");
						});
					});							
				}
			});
		}
	});
				
	$("#SaveRole").click(function() {
		var jsonForm = $("#roleForm").serializeObject();		
		var tmpData="";
		$.get("templates/role_item.html", function(tmp_data) {
			tmpData = tmp_data;					
		});			
		if($("#roleForm")[0].checkValidity()){										
			$.ajax({
				data : jsonForm,
				method : "POST",
				url : "roles",
				success : function(result) {							
					$("#role_tbody").empty();
					$.each(result, function(index, item) {
						$.tmpl(tmpData, item).appendTo("#role_tbody");				
					});
					$("#roleModal").modal("hide");
				}
			});	
			return false;
		}
	});
	
	$.getJSON("users", {}, function(result) {
		$("#user_tbody").empty();
		$.each(result, function(index, item) {
			$.get("templates/user_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#user_tbody");
			});
		});
	});
	
	$("#SearchUser").click(function() {
		$.getJSON("users?Name=" + $("#tabUsers #Name").val(), {
			Name : $("#tabUsers #Name").val()
		}, function(result) {
			$("#user_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/user_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#user_tbody");
				});
			});
		});
		return false;
	});
	
	$("#user_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var username = $(this).data("username");				
		var fname = $(this).data("firstname");
		var lname = $(this).data("lastname");
		var email = $(this).data("email");
		var mobile = $(this).data("mobile");
		var pageids=$(this).data("pageids");
		var rid = $(this).data("rid");
		var lid = $(this).data("lid");
		
		$("#userModal .password").val("");
		$("#userModal .password").attr("disabled","true");
		$("#userModal .type").val(2);
		$("#userModal .id").val(id);
		$("#userModal #Username").val(username);
		$("#userModal #FirstName").val(fname);
		$("#userModal #LastName").val(lname);			
		$("#userModal #Email").val(email);
		$("#userModal #Mobile").val(mobile);
		$("#userModal #RoleId").val(rid);
		$("#userModal #LobId").val(lid);

		$.getJSON("pages", {}, function(result) {
			$("#userModal #PageId").empty();
			$.each(result, function(index, item) {
				if(jQuery.inArray(item.id,pageids)!== -1)
				{
					$("#userModal #PageId").append("<li value='" + item.id + "'><input type='checkbox' checked>&nbsp<span>" + item.name + "</span></li>");
				}	
				else
				{	
					$("#userModal #PageId").append("<li value='" + item.id + "'><input type='checkbox'>&nbsp<span>" + item.name + "</span></li>");
				}
			});
		});
		$("#userModal").modal("show");
	});

	$("#user_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "users?type=3&id="+ key,
				success : function(result) {										
					$("#user_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/user_item.html", function(tmp_data) {
							$.tmpl(tmp_data, item).appendTo("#user_tbody");
						});
					});							
				}
			});
		}
	});
				
	$("#SaveUser").click(function() {				
		var tmpData="";
		$.get("templates/user_item.html", function(tmp_data) {
			tmpData = tmp_data;					
		});		
		
		var json = $("#userForm").serializeObject();
		var flag = $("#userForm")[0].checkValidity();		
		var  pageList=[];
		$("#userModal #PageId li").each(function( index ) 
		{
			var $cb = $(this).find(":checkbox");		
			if ($cb.prop("checked")) {				
				pageList.push($(this).val());
			}
		});		
		var data = { pagelist: pageList};		
		$.extend(json, data);
		
		if(flag){						
			$.ajax({
				data : json,
				method : "POST",
				url : "users",
				success : function(result) {							
					$("#user_tbody").empty();
					$.each(result, function(index, item) {
						$.tmpl(tmpData, item).appendTo("#user_tbody");				
					});
					$("#userModal").modal("hide");
				}
			});	
			return false;
		}
	});
	
	$.getJSON("pages", {}, function(result) {

		$("#page_tbody").empty();
		$("#userModal #PageId").empty();
		$.each(result, function(index, item) {
		
			$("#userModal #PageId").append("<li value='" + item.id + "'><input type='checkbox'>&nbsp<span>" + item.name + "</span></li>");
			$.get("templates/page_item.html", function(tmp_data) {
				
				$.tmpl(tmp_data, item).appendTo("#page_tbody");
			});
		});
	});
	
	$("#SearchPage").click(function() {
		$.getJSON("pages?PageName=" + $("#tabPages #PageName").val(), {
			PageName : $("#tabPages #PageName").val()
		}, function(result) {
			$("#page_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/page_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#page_tbody");
				});
			});
		});
		return false;
	});
	
	$("#page_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");				
		var url = $(this).data("nurl");
		
		$("#pageModal .type").val(2);
		$("#pageModal .id").val(id);
		$("#pageModal .name").val(name);				
		$("#pageModal #Url").val(url);
		$("#pageModal").modal("show");
	});

	$("#page_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "pages?type=3&id="+ key,
				success : function(result) {										
					$("#page_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/page_item.html", function(tmp_data) {
							$.tmpl(tmp_data, item).appendTo("#page_tbody");
						});
					});							
				}
			});
		}
	});
				
	$("#SavePage").click(function() {
		var json = $("#pageForm").serializeObject();
		var flag = $("#pageForm")[0].checkValidity();
		var tmplData = "";
		$.get("templates/page_item.html", function(tmp_data) {
			tmplData = tmp_data;					
		});
		if(flag){		
			$.ajax({
				data : json,
				method : "POST",
				url : "pages",
				success : function(result) {							
					$("#page_tbody").empty();							
					$.each(result, function(index, item) {
						$.tmpl(tmplData, item).appendTo("#page_tbody");								
					});
					$("#pageModal").modal("hide");
				}
			});
			return false;
		}
	});		
});
