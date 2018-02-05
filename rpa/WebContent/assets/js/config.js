$(function() {
	$("#placeholder").height($(document).height() - 85);
	$(window).resize(function() {
		$("#placeholder").height($(document).height() - 85);
	});

	$('.addfunc').click(function() {
		$("#functionModal .type").val(1);
		$("#functionModal .name").val("");
		$("#functionModal .description").val("");
	});

	$('.addlob').click(function() {
		$("#lobModal .id").val("");
		$("#lobModal .type").val(1);
		$("#lobModal .name").val("");
		$("#lobModal .description").val("");
		$("#lobModal .function").val("");
	});

	$('.addprocess').click(function() {
		$("#processModal .id").val("");
		$("#processModal .type").val(1);
		$("#processModal .name").val("");
		$("#processModal .description").val("");
		$("#processModal .lob").val("");		
	});

	$("#FunctionSearch").click(function() {
		$.getJSON("function?Name=" + $("#SearchFunctionName").val(), {
			Name : $("#SearchFunctionName").val()
		}, function(result) {
			$("#func_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/func_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#func_tbody");
				});
			});
		});
	});

	$("#SearchLob").click(function() {
		$.getJSON("lobs?Name=" + $("#LobSearch").val(), {
			Name : $("#LobSearch").val()
		}, function(result) {
			$("#lob_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/lob_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#lob_tbody");
				});
			});
		});
		return false;
	});

	$("#SearchStep").click(function() {
		$.getJSON("steps?Name=" + $("#menu3 #Name").val(), {
			Name : $("#menu3 #Name").val()
		}, function(result) {
			$("#step_tbody").empty();
			$.each(result, function(index, item) {
				$.get("templates/step_item.html", function(tmp_data) {
					$.tmpl(tmp_data, item).appendTo("#step_tbody");
				});
			});
		});
		return false;
	});

	$.getJSON("function", {}, function(result) {
		$("#func_tbody").empty();

		$("#menu3 .function").empty();
		$("#menu3 .function").append(
				"<option value=''>Select Function</option>");
		$("#stepModal .function").empty();
		$("#stepModal .function").append(
				"<option value=''>Select Function</option>");

		$.each(result, function(index, item) {
			$("#lobModal .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$("#processModal .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$("#subProcessModal .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$("#activityModal .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$("#menu3 .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$("#stepModal .function").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$.get("templates/func_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#func_tbody");
			});
		});
	});

	$.getJSON("lobs", {}, function(result) {
		$("#lob_tbody").empty();
		$.each(result, function(index, item) {
			$.get("templates/lob_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#lob_tbody");
			});
		});
	});

	$.getJSON("manageprocess", {}, function(result) {
		$("#process_tbody").empty();
		$("#processModal #ParentId").empty();
		$("#processModal #ParentId").append(
				"<option value=''>Select Parent Process</option>");
		$.each(result, function(index, item) {
			$("#processModal #ParentId").append(
					"<option value=" + item.id +">" + item.name
							+ "</option>");
			$.get("templates/process_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#process_tbody");
			});
		});
	});

	$.getJSON("activity", {}, function(result) {
		$("#activity_tbody").empty();
		$.each(result, function(index, item) {
			$.get("templates/activity_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#activity_tbody");
			});
		});
	});

	$.getJSON("steps", {}, function(result) {
		$("#step_tbody").empty();
		$.each(result, function(index, item) {
			$.get("templates/step_item.html", function(tmp_data) {
				$.tmpl(tmp_data, item).appendTo("#step_tbody");
			});
		});
	});

	$("#SearchProcess").click(
			function() {
				$.getJSON("manageprocess?ProcessName="
						+ $("#menu1 #ProcessName").val(), {
					ProcessName : $("#menu1 #ProcessName").val()
				}, function(result) {
					$("#process_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/process_item.html", function(
								tmp_data) {
							$.tmpl(tmp_data, item).appendTo(
									"#process_tbody");
						});
					});
				});
			});

	$("#SearchActivity").click(
			function() {
				$.getJSON("activity?ActivityName="
						+ $("#menu2 #ActivityName").val(), {
					ActivityName : $("#menu2 #ActivityName").val()
				}, function(result) {
					$("#activity_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/activity_item.html", function(
								tmp_data) {
							$.tmpl(tmp_data, item).appendTo(
									"#activity_tbody");
						});
					});
				});
			});

	$("#processModal #FunctionId").change(
			function() {
				var fid = $(this).val();
				$.getJSON("lobs", {}, function(result) {
					$("#processModal #LobId").empty();
					$("#processModal #LobId").append(
							"<option value='0'>Select Lob</option>");
					$.each(result, function(index, item) {
						if (item.functionId == fid) {
							$("#processModal #LobId").append(
									"<option value=" + item.id +">"
											+ item.name + "</option>");
						}
					});
				});
			});

	$("#activityModal #FunctionId").change(
			function() {
				var fid = $(this).val();
				$.getJSON("lobs", {}, function(result) {
					$("#activityModal #LobId").empty();
					$("#activityModal #LobId").append(
							"<option value='0'>Select Lob</option>");
					$.each(result, function(index, item) {
						if (item.functionId == fid) {
							$("#activityModal #LobId").append(
									"<option value=" + item.id +">"
											+ item.name + "</option>");
						}
					});
				});
			});
	$("#activityModal #LobId")
			.change(
					function() {
						var lid = $(this).val();
						$
								.getJSON(
										"manageprocess",
										{},
										function(result) {
											$(
													"#activityModal #ProcessId")
													.empty();
											$(
													"#activityModal #ProcessId")
													.append(
															"<option value=''>Select Process</option>");
											$
													.each(
															result,
															function(
																	index,
																	item) {
																if (item.lobId == lid) {
																	$(
																			"#activityModal #ProcessId")
																			.append(
																					"<option value=" + item.id +">"
																							+ item.name
																							+ "</option>");
																}
															});
										});
					});

	$("#stepModal .function").change(
			function() {
				var fid = $(this).val();
				$.getJSON("lobs", {}, function(result) {
					$("#stepModal .lob").empty();
					$("#stepModal .lob").append(
							"<option value=''>Select Lob</option>");
					$.each(result, function(index, item) {
						if (item.functionId == fid) {
							$("#stepModal .lob").append(
									"<option value=" + item.id +">"
											+ item.name + "</option>");
						}
					});
				});
			});
	$("#stepModal .lob")
			.change(
					function() {
						var lid = $(this).val();
						$
								.getJSON(
										"manageprocess",
										{},
										function(result) {
											$("#stepModal .process")
													.empty();
											$("#stepModal .process")
													.append(
															"<option value=''>Select Process</option>");
											$
													.each(
															result,
															function(
																	index,
																	item) {
																if (item.lobId == lid) {
																	$(
																			"#stepModal .process")
																			.append(
																					"<option value=" + item.id +">"
																							+ item.name
																							+ "</option>");
																}
															});
										});
					});

	$("#stepModal #ProcessId")
			.change(
					function() {
						var pid = $(this).val();
						$
								.getJSON(
										"activity",
										{},
										function(result) {
											$("#stepModal #ActivityId")
													.empty();
											$("#stepModal #ActivityId")
													.append(
															"<option value=''>Select Activity</option>");
											$
													.each(
															result,
															function(
																	index,
																	item) {
																if (item.processId == pid) {
																	$(
																			"#stepModal #ActivityId")
																			.append(
																					"<option value=" + item.id +">"
																							+ item.name
																							+ "</option>");
																}
															});
										});
					});

	$("#SaveFunction").click(
			function() {
				var jsonForm = $("#functionForm").serializeObject();
				console.log(jsonForm);
				$.ajax({
					data : jsonForm,
					method : "POST",
					url : "function",
					success : function(result) {
						$("#func_tbody").empty();
						$.each(result, function(index, item) {
							$.get("templates/func_item.html", function(
									tmp_data) {
								$.tmpl(tmp_data, item).appendTo(
										"#func_tbody");
							});
						});
						$("#functionModal").modal("hide");
					}
				});
			});

	$("#SaveLob").click(
			function() {
				var jsonForm = $("#lobForm").serializeObject();
				$.ajax({
					data : jsonForm,
					method : "POST",
					url : "lobs",
					success : function(result) {
						$("#lob_tbody").empty();
						$.each(result, function(index, item) {
							$.get("templates/lob_item.html", function(
									tmp_data) {
								$.tmpl(tmp_data, item).appendTo(
										"#lob_tbody");
							});
						});
						$("#lobModal").modal("hide");
					}
				});
			});

	$("#SaveProcess").click(
			function() {
				var jsonForm = $("#processForm").serializeObject();
				var tmpData = "";
				$.get("templates/process_item.html",
						function(tmp_data) {
							tmpData = tmp_data;
						});

				if ($("#processForm")[0].checkValidity()) {
					$.ajax({
						data : jsonForm,
						method : "POST",
						url : "manageprocess",
						success : function(result) {
							$("#process_tbody").empty();
							$.each(result, function(index, item) {
								$.tmpl(tmpData, item).appendTo(
										"#process_tbody");
							});
							$("#processModal").modal("hide");
						}
					});
					return false;
				}
			});

	$("#SaveActivity")
			.click(
					function() {
						var jsonForm = $("#activityForm")
								.serializeObject();
						$
								.ajax({
									data : jsonForm,
									method : "POST",
									url : "activity",
									success : function(result) {
										$("#activity_tbody").empty();
										$
												.each(
														result,
														function(index,
																item) {
															$
																	.get(
																			"templates/activity_item.html",
																			function(
																					tmp_data) {
																				$
																						.tmpl(
																								tmp_data,
																								item)
																						.appendTo(
																								"#activity_tbody");
																			});
														});
										$("#activityModal").modal(
												"hide");
									}
								});
					});

	$("#SaveStep").click(function() {
		var jsonForm = $("#stepForm").serializeObject();
		if ($("#stepForm")[0].checkValidity()) {
			$.ajax({
				data : jsonForm,
				method : "POST",
				url : "steps",
				success : function(result) {							
					$("#step_tbody").empty();
					$.each(result,function(index,item) {
						$.get("templates/step_item.html",function(tmp_data) {
							$.tmpl(tmp_data,item).appendTo("#step_tbody");
						});
					});
					$("#stepModal").modal("hide");
				}
			});
			return false;
		}
	});

	$("#func_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "function?type=3&id=" + key,
				success : function(result) {
					$("#func_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/func_item.html", function(tmp_data) {
							$.tmpl(tmp_data, item).appendTo("#func_tbody");
						});
					});
					$("#functionModal").modal("hide");
				}
			});
		}
	});

	$("#func_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");
		var desc = $(this).data("desc");
		$("#functionModal").modal("show");
		$("#functionModal .type").val(2);
		$("#functionModal .id").val(id);
		$("#functionModal .name").val(name);
		$("#functionModal .description").val(desc);
	});

	$("#lob_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");
		var desc = $(this).data("desc");
		var funcid = $(this).data("funcid");
		$("#lobModal").modal("show");
		$("#lobModal .type").val(2);
		$("#lobModal .id").val(id);
		$("#lobModal .name").val(name);
		$("#lobModal .description").val(desc);
		if (funcid > 0) {
			$("#lobModal .function").val(funcid);
		} else {
			$("#lobModal .function").val("");
		}
	});

	$("#lob_tbody").on('click', '.delete', function() {
						if (confirm("Are you sure, want to delete?")) {
							var key = $(this).data("id");
							var jsonForm = {
								type : 3,
								id : key
							};
							$.ajax({
								date : jsonForm,
								method : "POST",
								url : "lobs?type=3&id=" + key,
								success : function(result) {
									$("#lob_tbody").empty();
									$.each(result, function(index, item) {
										$.get("templates/lob_item.html", function(tmp_data) {
											$.tmpl(tmp_data, item).appendTo("#lob_tbody");
										});
									});
									$("#lobModal").modal("hide");
								}
							});
						}
					});

	$("#process_tbody").on('click','.edit',function() {
		var id = $(this).data("id");
		var name = $(this).data("name");
		var desc = $(this).data("desc");
		var fid = $(this).data("funcid");
		var lobid = $(this).data("lobid");
		var pid = $(this).data("pid");

		$("#processModal").modal("show");
		$("#processModal .type").val(2);
		$("#processModal .id").val(id);
		$("#processModal .name").val(name);
		$("#processModal .description").val(desc);
		$("#processModal .function").val(fid);
		$.getJSON("lobs", {}, function(result) {
			$("#processModal .lob").empty();
			$("#processModal .lob").append("<option value=''>Select Lob</option>");
			$.each(result, function(index, item) {
				$("#processModal .lob").append("<option value='" + item.id +"'>" + item.name + "</option>");
			});
			$("#processModal .lob").val(lobid);
		})				
	});

	$("#process_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "manageprocess?type=3&id="+ key,
				success : function(result) {
					$("#process_tbody").empty();
					$.each(result,function(index,item) {
						$.get("templates/process_item.html",function(tmp_data) {
							$.tmpl(tmp_data,item).appendTo("#process_tbody");
						});
					});
				}
			});
		}
	});

	$("#activity_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");
		var desc = $(this).data("desc");
		var fid = $(this).data("funcid");
		var lobid = $(this).data("lobid");
		var procid = $(this).data("procid");

		$("#activityModal").modal("show");
		$("#activityModal .type").val(2);
		$("#activityModal .id").val(id);
		$("#activityModal .name").val(name);
		$("#activityModal .description").val(desc);
		$("#activityModal .function").val(fid);
		$("#activityModal").modal("show");

		$.getJSON("lobs", {}, function(result) {
			$("#activityModal .lob").empty();
			$("#activityModal .lob").append("<option value=''>Select Lob</option>");
			$.each(result, function(index, item) {
				if (item.functionId == fid) {
					$("#activityModal .lob").append("<option value='" + item.id +"'>" + item.name + "</option>");
				}
			});
			$("#activityModal .lob").val(lobid);
		});

		$.getJSON("manageprocess", {}, function(result) {
			$("#activityModal .process").empty();
			$("#activityModal .process").append(
					"<option value=''>Select Lob</option>");
			$.each(result, function(index, item) {
				if (item.lobId == lobid) {
					$("#activityModal .process").append("<option value='" + item.id +"'>"+ item.name + "</option>");
				}
			});
			$("#activityModal .process").val(procid);
		});		
	});

	$("#activity_tbody").on('click', '.delete', function() {
		if (confirm("Are you sure, want to delete?")) {
			var key = $(this).data("id");
			var jsonForm = {
				type : 3,
				id : key
			};
			$.ajax({
				date : jsonForm,
				method : "POST",
				url : "activity?type=3&id="+ key,
				success : function(result) {
					$("#activity_tbody").empty();
					$.each(result, function(index, item) {
						$.get("templates/activity_item.html", function(tmp_data) {
							$.tmpl(tmp_data,item).appendTo("#activity_tbody");
						});
					});
				}
			});
		}
	});

	$("#step_tbody").on('click', '.edit', function() {
		var id = $(this).data("id");
		var name = $(this).data("name");
		var desc = $(this).data("desc");
		var funcid = $(this).data("funcid");
		var lobid = $(this).data("lobid");
		var procid = $(this).data("procid");
		var acid = $(this).data("acid");
		var req = $(this).data("req");

		$("#stepModal .type").val(2);
		$("#stepModal .id").val(id);
		$("#stepModal .name").val(name);
		$("#stepModal .description").val(desc);				
		$("#stepModal #Required").val(req);
		
		if (funcid > 0) {
			$("#stepModal .function").val(funcid);
			$.getJSON("lobs",{}, function(result) {
				$("#stepModal .lob").empty();
				$("#stepModal .lob").append("<option value=''>Select Lob</option>");
				$.each(result,function(index, item) {
					if (item.functionId == funcid) {
						$("#stepModal .lob").append("<option value=" + item.id +">" + item.name + "</option>");
					}
				});
				$("#stepModal .lob").val(lobid);
			});

			$.getJSON("manageprocess",{},function(result) {
				$("#stepModal .process").empty();
				$("#stepModal .process").append("<option value=''>Select Process</option>");
				$.each(result,function(index,item) {
					if (item.lobId == lobid) {
						$("#stepModal .process").append("<option value=" + item.id +">" + item.name + "</option>");
					}
				});
				$("#stepModal .process").val(procid);
			});

			$.getJSON("activity",{},function(result) {
				$("#stepModal .activity").empty();
				$("#stepModal .activity").append("<option value=''>Select Activity</option>");										
				$.each(result,function(index,item) {
					if (item.processId == procid) {
						$("#stepModal .activity").append("<option value=" + item.id +">"+ item.name+ "</option>");
					}
				});
				$("#stepModal .activity").val(acid);
			});
		} else {
			$("#stepModal .function").val("");
		}
		$("#stepModal").modal("show");
	});

	$("#step_tbody")
			.on(
					'click',
					'.delete',
					function() {
						if (confirm("Are you sure, want to delete?")) {
							var key = $(this).data("id");
							var jsonForm = {
								type : 3,
								id : key
							};
							$
									.ajax({
										date : jsonForm,
										method : "POST",
										url : "steps?type=3&id=" + key,
										success : function(result) {
											$("#step_tbody").empty();
											$
													.each(
															result,
															function(
																	index,
																	item) {
																$
																		.get(
																				"templates/step_item.html",
																				function(
																						tmp_data) {
																					$
																							.tmpl(
																									tmp_data,
																									item)
																							.appendTo(
																									"#step_tbody");
																				});
															});
										}
									});
						}
					});
});