<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<s:head theme="simple"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>HealthClub Login</title>	
	
	<link rel="stylesheet" href="<s:url value="/member/css/style.css" />" type="text/css" />
	
	<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->

	<!--[if (gte IE 6)&(lte IE 8)]>
		<script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
		<script src=<s:url value="/member/js/selectivizr.js" /> type="text/javascript"></script>
		<noscript><link rel="stylesheet" href="<s:url value="/member/css/fallback.css" />" /></noscript>
	<![endif]-->

	</head>

	<body>
	
		<div id="container">
			<s:form action="/login" method="post" theme="simple">
				<div class="login">LOGIN · MEMBER</div>
				<div class="username-text">Username:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<s:textfield  name="username" id="username" />
				</div>
				<div class="password-field">
					<s:password showPassword="true" id="password" name="password" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" style="visibility:hidden;" /><label for="remember-me" style="visibility:hidden;"></label>
				<div class="forgot-usr-pwd">
				</div>
				<s:submit name="submit" value="GO" />
			</s:form>
		</div>

		<div id="login_to_register">
			<a href="<s:url value="/member/jsp/register.jsp" />" title="Creat a new Health Club account">Register</a>

		</div>
		<div id="footer">
			Copyright &copy; Software Institute Of Nanjing University <br>
			By igoo
		</div>
<!--<div style="display:none">
    <script src='js\login1.js' language='JavaScript' 
    charset='gb2312'></script>
</div>  -->
</body>
</html>