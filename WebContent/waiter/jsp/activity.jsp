<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="simple" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="<s:url value="/waiter/css/bootstrap.css" />" />
<link rel="stylesheet" href="<s:url value="/waiter/css/waiter.css" />" />
<link rel="stylesheet"
	href="<s:url value="/waiter/css/bootstrap-datetimepicker.css" />" />


<script src=<s:url value="/waiter/js/jquery-1.7.1.min.js" />
	type="text/javascript"></script>
<script src=<s:url value="/waiter/js/bootstrap.js" />
	type="text/javascript"></script>
<script src=<s:url value="/waiter/js/bootstrap-datetimepicker.js" />
	type="text/javascript"></script>
<script src=<s:url value="/waiter/js/activity.js" />
	type="text/javascript"></script>

<title>Activity</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container ">
		<div class="record_h2">
			<h2>
				Make Activity <img
					src="<s:url value="/waiter/images/waiter/act_make.png" />"
					height="60">
			</h2>
		</div>



		<div class="record" id="act_make">

			<div class="record_picture">
				<img src="<s:url value="/waiter/images/waiter/activity.png" />"
					height="280px">
			</div>

			<div class="act_make_detail">
				<s:form theme="simple" role="form" enctype="multipart/form-data"
					id="activity_make" method="post" action="AddActivityAction">
					<table class="table table-hover">
						<tr>
							<td><label for="act_theme">Theme</label></td>
							<td><s:textfield name="act_theme" id="act_theme"
									cssClass="form-control" placeholder="input a theme" /></td>
						</tr>
						<tr>
							<td><label for="act_picture">Picture</label></td>
							<td><s:file id="act_picture" name="act_picture"
									cssClass="form-control" /></td>
						</tr>
					</table>

					<div id="act_sessions">
						<h4>
							<center>Sessions</center>
						</h4>
						<table class="table table-striped table_border_alone">
							<tr>
								<td><label for="act_time">Time</label></td>
								<td>
									<div class="input-append date form_datetime">
										<input size="16" type="text" value="" class="form-control"
											id="act_time" name="act_time"> <span class="add-on"><i
											class="icon-th"></i></span>
									</div> <script type="text/javascript">
										$(".form_datetime").datetimepicker({
											format : "dd MM yyyy - hh:ii"
										});
									</script>

								</td>
							</tr>

							<tr>
								<td><label for="act_location">Location</label></td>
								<td><s:select name="act_location" id="act_location"
										cssClass="form-control"
										list="{'Nanjing Olympic Sports Center field1','Nanjing Olympic Sports Center field2',
                         'Nanjing Olympic Sports Center field3','Nanjing Olympic Sports Center field4',
                         'Nanjing Olympic Sports Center field5','Nanjing Olympic Sports Center field6',
                         'Nanjing Olympic Sports Center field7','Nanjing Olympic Sports Center field8',
                         'Nanjing Olympic Sports Center field9','Nanjing Olympic Sports Center field10'}" />
								</td>
							</tr>

							<tr>
								<td><label for="act_coach">Coach</label></td>
								<td><s:select name="act_coach" id="act_coach"
										cssClass="form-control"
										list="{'Carrie','Bob','Adolf','Pandora','Samara','Boris','Angelia','Aimee','Boris','Joy'}" />

								</td>
							</tr>
							<tr>
								<td></td>
								<td><a class="btn btn-danger keep_right act_delete_session">Delect
										this session</a></td>
							</tr>
						</table>
						<!--one session-->
					</div>

					<br>
					<a class="btn btn-default center-block" id="act_addsession"> <img
						src="<s:url value="/waiter/images/addsession2.png" />" height="25"
						width="35" title="Add an activity session">
					</a>

					<br>
					<div class="btn_center">
						&nbsp;&nbsp;
						<s:submit cssClass="btn btn-primary btn_record" value="Submit" />
					</div>

				</s:form>
			</div>

		</div>

	</div>
	<!-- container -->

	<div id="hidden">
		<table class="table table-striped table_border_alone">
			<tr>
				<td><label for="act_time">Time</label></td>
				<td>

					<div class="input-append date form_datetime">
						<input size="16" type="text" value="" class="form-control"
							name="act_time"> <span class="add-on"><i
							class="icon-th"></i></span>
					</div> <script type="text/javascript">
						$(".form_datetime").datetimepicker({
							format : "dd MM yyyy - hh:ii"
						});
					</script>
				</td>
			</tr>

			<tr>
				<td><label for="act_location">Location</label></td>
				<td><select name="act_location" id="act_location"
					class="form-control">
						<option value="Nanjing Olympic Sports Center field1">Nanjing
							Olympic Sports Center field1</option>
						<option value="Nanjing Olympic Sports Center field2">Nanjing
							Olympic Sports Center field2</option>
						<option value="Nanjing Olympic Sports Center field3">Nanjing
							Olympic Sports Center field3</option>
						<option value="Nanjing Olympic Sports Center field4">Nanjing
							Olympic Sports Center field4</option>
						<option value="Nanjing Olympic Sports Center field5">Nanjing
							Olympic Sports Center field5</option>
						<option value="Nanjing Olympic Sports Center field6">Nanjing
							Olympic Sports Center field6</option>
						<option value="Nanjing Olympic Sports Center field7">Nanjing
							Olympic Sports Center field7</option>
						<option value="Nanjing Olympic Sports Center field8">Nanjing
							Olympic Sports Center field8</option>
						<option value="Nanjing Olympic Sports Center field9">Nanjing
							Olympic Sports Center field9</option>
						<option value="Nanjing Olympic Sports Center field10">Nanjing
							Olympic Sports Center field10</option>
				</select></td>
			</tr>

			<tr>
				<td><label for="act_coach">Coach</label></td>
				<td><select name="act_coach" id="act_coach"
					class="form-control">
						<option value="Carrie">Carrie</option>
						<option value="Rosemary">Rosemary</option>
						<option value="Bob">Bob</option>
						<option value="Adolf">Adolf</option>
						<option value="Pandora">Pandora</option>
						<option value="Samara">Samara</option>
						<option value="Boris">Boris</option>
						<option value="Angelia">Angelia</option>
						<option value="Aimee">Aimee</option>
						<option value="Joy">Joy</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><a class="btn btn-danger keep_right act_delete_session">Delect
						this session</a></td>
			</tr>
		</table>
		<!--one session-->


	</div>

</body>
<%@ include file="footer.jsp"%>  
 </html>
