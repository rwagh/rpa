<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<%@include file="includes.html"%>
<script type="text/javascript" src="assets/highcharts/highcharts.js"></script>
<script type="text/javascript" src="assets/highcharts/modules/exporting.js"></script>
<%@include file="in.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid" id="placeholder">
		<div class="row">
			<div class="col-lg-12 col-md-12">&nbsp;</div>
		</div>
		<div style="min-height: 680px;">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<div class="recent-job-item">
							<div id="ChartArea" style="width: 100%; height: 400px;"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<div class="recent-job-item">
							<div id="ChartArea1" style="width: 100%; height: 400px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.html"%>
	<script type="text/javascript">
		$(function() {
			$("#placeholder").height($(document).height() - 78);
			$(window).resize(function() {
				$("#placeholder").height($(document).height() - 78);
			});
			
			Highcharts.chart('ChartArea', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Accounts'
                },
                //subtitle: {
                //    text: 'Source: WorldClimate.com'
                //},
                xAxis: {
                    categories: [
                        'JAN',
                        'FEB',
                        'MAR',
                        'APR',
                        'MAY',
                        'JUN',
                        'JUL',
                        'AUG',
                        'SEP',
                        'OCT',
                        'NOV',
                        'DEC'
                    ],
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: ' '
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: [{
                    name: 'Employers',
                    data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]

                }, {
                    name: 'Jobseekers',
                    data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

                }]
            });
		});
	</script>
</body>
</html>