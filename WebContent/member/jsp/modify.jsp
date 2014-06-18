<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>Modify</title>
    <s:head theme="simple"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/datepicker.css" />" />

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/selectivizr.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/modify.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap-datepicker.js" /> type="text/javascript"></script>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <%@ include file="header.jsp"  %>

    <div id="reg_create">
        <h2 >Modify  my  base  information</h2>
    </div>

    <div class="container" id="reg_container">
    <s:form theme="simple"  role="form" enctype="multipart/form-data" id="register_info" method="post" action="/modify" >
        <s:hidden id="old_username" name="old_username"/>
        <table class="table table-striped ">
          <tr  >
            <td> <label for="reg_username">Username</label></td>
            <td>
            	<s:textfield id="reg_username" name="reg_username"  cssClass="form-control" placeholder="Username" />
            	<p class="warning" id="warn_username" >The username has been used!</p>
                <p class="warning" id="warn_username2" >Please input the username!</p>
            </td>
          </tr>

          <tr>
            <td><label for="reg_email">Email</label></td>
            <td>
            	<s:textfield id="reg_email" name="reg_email"  cssClass="form-control" placeholder="Email" />
            	<p class="warning" id="warn_email">Email format is wrong!</p>
            	<p class="warning" id="warn_email2">Please input the email!</p>
            </td>
          </tr>
          
          <tr>
            <td><label for="reg_gender">Gender</label></td>
            <td>
                          <s:select id="reg_gender" name="reg_gender" labelposition="top" cssClass="form-control" 
                                    list="{'Woman','Man','Other'}"
                           />
            </td>
          </tr>

          <tr>
            <td><label for="reg_birthday">Birthday</label></td>
            <td>
                <s:textfield name="reg_birthday"  id="reg_birthday" cssClass="datepicker form-control" data-date-format="yyyy/mm/dd"/> 
            	<p class="warning" id="warn_birthday2">Please input your birthday!</p>
            </td>
          </tr>

          <tr>
            <td><label for="reg_address">Address</label></td>
            <td>
            	<s:textfield type="text" id="reg_address" name="reg_address" label="Address" cssClass="form-control" placeholder="Address" />
                <p class="warning" id="warn_address2">Please input the address!</p>
            </td>
          </tr>

          <tr>
            <td><label for="upload">Picture</label></td>
            <td>             
                <s:file id="upload" name="upload" />
                <p class="warning" id="warn_picture">Format must be png,gif,jpg,jpeg,or bmp!</p>
            </td>
          </tr>
          
          <tr>
          <td><a class="btn " id="modifypw" title="Click here to modify your password">modify password</a></td>
          <td><a class="btn " id="cancelmodifypw" title="Cancel the password change">cancel</a></td>
          
          </tr>
          <tr class="modify_pw">
            <td><label for="old_password">Old Password</label></td>
            <td><s:password showPassword="true" id="old_password" name="old_password" cssClass="form-control" placeholder="Old Password" /> </td>
          </tr>

          <tr class="modify_pw">
            <td><label for="new_password">New Password</label></td>
            <td><s:password showPassword="true" id="new_password" name="reg_password" cssClass="form-control" placeholder="New Password" /> </td>
          </tr>
          
          <tr class="modify_pw">
            <td><label for="new_password_again">New Password</label></td>
            <td><s:password showPassword="true" id="new_password_again" name="reg_password_again"  cssClass="form-control" placeholder="New Password Again"/> </td>
          </tr>
          

        </table>
        <div class="edit_save_cancel">
        	<s:submit  cssClass="btn btn-info btn-lg btn_edit" value="Save"/>
       		<a href="profile.action" class="btn btn-info btn-lg btn_edit">Cancel</a>
        </div>
         

      </s:form>

    </div>

  </body>
</html>