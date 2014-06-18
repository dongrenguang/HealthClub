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
    <script src=<s:url value="/member/js/modify2.js" /> type="text/javascript"></script>
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
    <s:form theme="simple"  role="form" enctype="multipart/form-data" id="register_info" method="post" action="/modify2" >
        <s:hidden id="old_username" name="old_username"/>
        <s:hidden id="reg_password" name="reg_password"/>
        <s:hidden id="waiter" name="waiter" value="waiter" />
        <table class="table table-hover ">
          <tr  >
            <td> <label for="reg_username">Username</label></td>
            <td><s:textfield id="reg_username" name="reg_username"  cssClass="form-control" placeholder="Username" /></td>
          </tr>

          <tr>
            <td><label for="reg_email">Email</label></td>
            <td><s:textfield   type="email" id="reg_email" name="reg_email"  cssClass="form-control" placeholder="Email" /></td>
          </tr>

          <tr>
            <td><label for="reg_address">Address</label></td>
            <td><s:textfield type="text" id="reg_address" name="reg_address" label="Address" cssClass="form-control" placeholder="Address" /></td>
          </tr>

          <tr>
            <td><label for="upload">Picture</label></td>
            <td>             
                <s:file id="upload" name="upload" />
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
            <td><s:password showPassword="true" id="new_password" name="new_password" cssClass="form-control" placeholder="New Password" /> </td>
          </tr>
          
          <tr class="modify_pw">
            <td><label for="new_password_again">New Password</label></td>
            <td><s:password showPassword="true" id="new_password_again" name="new_password_again"  cssClass="form-control" placeholder="New Password Again"/> </td>
          </tr>

        </table>
        
        
        
        <div id="members">
                 <h4>Family Members</h4>
             
                  <s:iterator value="members" id="memberList" status="st">
                      <table class="table table-striped table_border_alone">
                          <tr>
                              <td> <label for="mem_name">Name</label></td>
                              <td class="td_mem_name">
                                  
                                  <s:textfield  name="mem_name"  cssClass="form-control mem_name" 
                                        placeholder="Name" value="%{#memberList.name}"/>
                              </td>
                          </tr>
                          
                          <tr>
                              <td> <label for="mem_gender">Gender</label></td>
                              <td >
                                   <s:select name="mem_gender" labelposition="top" cssClass="form-control mem_gender" 
                                    list="{'Woman','Man','Other'}" value="%{#memberList.gender}"/>
                              </td>
                          </tr>
                          
                          <tr >
                             <td><label for="mem_birthday">Birthday</label></td>
                             <td class="td_mem_birthday">
                                    <s:textfield name="mem_birthday"   data-date-format="yyyy/mm/dd"  
                                         cssClass="datepicker form-control mem_birthday"
                                         value="%{#memberList.birthday}"/> 
                             </td>  
                          </tr>   
                           
                   <tr>
                      <td><label for="mem_identity">Family <br>identity</label></td>
                      <td>
                         <s:select name="mem_identity" cssClass="form-control mem_identity"
                         list="{'Head','Mate','Child','Mother','Father','Brother','Sisiter','Uncle','Other'}" 
                         value="%{#memberList.identity}"/>
                      </td>
                  </tr>   
                  <tr>
                        <td></td>
                        <td><a class="btn btn-danger keep_right mem_remove" >Remove this member</a></td>                       
                  </tr>        

                      </table>
                  </s:iterator>
                
          </div><!-- members -->
          
           <a class="btn btn-default center-block" id="mem_add">
                        <img src=<s:url value="/member/images/addmem.png"/> height="25" width="35"title="Add a family member">
           </a>
           <br>
        

         <s:submit  cssClass="btn btn-info btn-lg center-block" value="Save"/>

      </s:form>

    </div>
    
        <div id="hidden">
              <table class="table table-striped table_border_alone mem_copy_table" >
                  <tr >
                      <td> <label for="mem_name">Name</label></td>
                      <td class="td_mem_name"><input type="text"  name="mem_name"  class="form-control mem_name" placeholder="Name" /></td>
                  </tr>
                  <tr>
                      <td><label for="mem_gender">Gender</label></td>
                      <td>
                          <select  name="mem_gender"  class="form-control mem_gender" >
                              <option value ="Woman" selected>Woman</option>
                              <option value ="Man" >Man</option>
                              <option value="Other">Other</option>
                          </select>
                      </td>
                  </tr>
                  <tr >
                      <td><label for="mem_birthday">Birthday</label></td>
                      <td class="td_mem_birthday">
                              <input type="text" name="mem_birthday" class="datepicker form-control mem_birthday" data-date-format="yyyy/mm/dd"/>
                      </td>  
                  </tr>    
                  <tr>
                      <td><label for="mem_identity">Family <br>identity</label></td>
                      <td>
                         <select  name="mem_identity" class="form-control mem_identity">
                              <option value ="Head" selected>Head</option>
                              <option value ="Mate">Mate</option>
                              <option value="Child">Child</option>
                              <option value ="Mother">Mother</option>
                              <option value ="Father" >Father</option>
                              <option value="Brother">Brother</option>
                              <option value ="Sister">Sister</option>
                              <option value ="Uncle" >Uncle</option>
                              <option value="Other">Woman</option>
                              
                             
                         </select>
                      </td>
                  </tr>   
                  <tr>
                        <td></td>
                        <td><a class="btn btn-danger keep_right mem_remove">Remove this member</a></td>                       
                  </tr>                
                  
              </table><!-- member -->
    
    </div><!-- hidden -->

  </body>
<%@ include file="footer.jsp"%>  