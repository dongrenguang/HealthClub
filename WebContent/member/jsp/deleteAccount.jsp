<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="simple"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset='utf-8'>
<title>Delete Account</title>
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/deleteAccount.js" /> type="text/javascript"></script>
    

</head>
<body>
    <div class="container">
       <div class="deleteAccount">
           <table class="table">
              <tr>
                  <td><label>Password</label></td>
                  <td><input type="password" id="del_pw" class="form-control"/></td>
              </tr>
           </table>
           
           <a href="<s:url value="deleteAccount.action" />" class="btn btn-danger center-block" id="del_delete">Delete My Count</a>
           <br>
           <a href="<s:url value="profile.action" />" class="btn btn-primary center-block" id="del_cancel">Cancel</a>
           
       </div>
    </div>

</body>
<%@ include file="footer.jsp"  %>
</html>