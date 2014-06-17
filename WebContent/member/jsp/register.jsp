<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <s:head theme="simple"/>
    <sx:head extraLocales="UTF-8" />  
    <title>Register Health Club</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset='utf-8'>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/datepicker.css" />" />

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/register.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap-datepicker.js" /> type="text/javascript"></script>

  </head>
  <body>
    <header class="all_header">  
             
              <div class="reg_to_login"> 
                 <a href="<s:url value="/member/index.jsp"/>" title="I have one Health Club account" class="btn btn-primary btn-lg">Login</a>
              </div>
              
    
              <img src=<s:url value="/member/images/logo.png"/> id="reg_logo" >             
    </header>  


    <div id="reg_create">
       <h3 id="reg_title">Create a new personal Health Club account</h3>
    </div>
    
    <div id="reg_nav">
        &nbsp;&nbsp;
        <img id="reg_nav_personal"  src=<s:url value="/member/images/personal.png"/> height="100" width="70" title="register a personal account"/>
        <br><br>  
        <img id="reg_nav_family"    src=<s:url value="/member/images/family.png" /> height="60" title="register a family account" >         
    </div>

    <div class="container" id="reg_container" >
      <div id="reg_personal">   
      <s:form theme="simple"  role="form" enctype="multipart/form-data" id="register_info" name="register_info" method="post" action="/register" >
        <s:hidden id="reg_type" name="reg_type" value="Personal"/>
        
        <table class="table table-hover ">
          <tr  >
            <td> <label for="reg_username">Username</label></td>
            <td class="td_mid"><s:textfield id="reg_username" name="reg_username"  cssClass="form-control" placeholder="Username" />
                              <p class="warning" id="warn_username" >The username has been used!</p>
                              <p class="warning" id="warn_username2" >Please input the username!</p> </td>
          </tr>

          <tr>
            <td><label for="reg_email">Email</label></td>
            <td><s:textfield   id="reg_email" name="reg_email"  cssClass="form-control" placeholder="Email" />
                  <p class="warning" id="warn_email">Email format is wrong!</p>
                  <p class="warning" id="warn_email2">Please input the email!</p></td>
          </tr>

          <tr>
            <td><label for="reg_password">Password</label></td>
            <td><s:password showPassword="true" id="reg_password" name="reg_password" cssClass="form-control" placeholder="Password" /> 
                <p class="warning" id="warn_firstpassword2">Please input the password!</p></td>
          </tr>
          <tr>
            <td><label for="reg_password_again">Password</label></td>
            <td><s:password showPassword="true" id="reg_password_again" name="reg_password_again"  cssClass="form-control" placeholder="Password Again"/> 
                 <p class="warning" id="warn_password">Two passwords aren't consistent!</p>
                 <p class="warning" id="warn_password2">Please input the password again!</p></td>
          </tr>
          
          <tr>
            <td><label for="reg_address">Address</label></td>
            <td><s:textfield type="text" id="reg_address" name="reg_address" label="Address" cssClass="form-control" placeholder="Address" />
                <p class="warning" id="warn_address2">Please input the address!</p></td>
          </tr>

          <tr>
            <td><label for="reg_picture">Picture</label></td>
            <td>             
                <s:file id="reg_picture" name="reg_picture" />
                <p class="warning" id="warn_picture">Format must be png,gif,jpg,jpeg,or bmp!</p>
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

          <tr  >
            
            <td><label for="reg_birthday">Birthday</label></td>
           
            <td>
               <!-- <sx:datetimepicker name="reg_birthday"  id="reg_birthday" displayFormat="yyyy-MM-dd"/>  -->
                <s:textfield name="reg_birthday"  id="reg_birthday" cssClass="datepicker form-control" data-date-format="yyyy/mm/dd"/> 
                <p class="warning" id="warn_birthday2">Please input your birthday!</p>
            </td>
            
            <!--  
            <td>
               <s:textfield type="text" id="reg_year" name="reg_year" cssClass="reg_birthday" placeholder="Year"  />
               <s:select id="reg_month" name="reg_month" cssClass="reg_birthday"
                         list="{'Month','1','2','3','4','5','6','7','8','9','10','11','12'}"
                />
               <s:textfield type="text" id="reg_day" name="reg_day"  cssClass="reg_birthday"  placeholder="Day" />
            </td>  
            -->
            
          </tr>


        </table>

         <s:submit  name="reg_submit_personal" id="reg_submit_personal" cssClass="btn btn-info btn-lg center-block" value="Submit"/>

      </s:form>
      </div><!-- personal--------------------------------------------------------------------------------- -->
      
      

      <div id="reg_family">
       <s:form theme="simple"  role="form" enctype="multipart/form-data" id="register_info_family" method="post" action="/register2" >
         <s:hidden id="reg_type2" name="reg_type2" value="Family"/>
        <table class="table table-hover ">
          <tr  >
            <td> <label for="reg_username2">Username</label></td>
            <td>
            	<s:textfield id="reg_username2" name="reg_username2"  cssClass="form-control" placeholder="Username" />
            	<p class="warning" id="warn_fusername" >The username has been used!</p>
                <p class="warning" id="warn_fusername2" >Please input the username!</p>
            </td>
          </tr>

          <tr>
            <td><label for="reg_email2">Email</label></td>
            <td>
            	<s:textfield   id="reg_email2" name="reg_email2"  cssClass="form-control" placeholder="Email" />
            	<p class="warning" id="warn_femail">Email format is wrong!</p>
                <p class="warning" id="warn_femail2">Please input the email!</p>
            </td>
          </tr>

          <tr>
            <td><label for="reg_password2">Password</label></td>
            <td>
                <s:password showPassword="true" id="reg_password2" name="reg_password2" cssClass="form-control" placeholder="Password" />
           		<p class="warning" id="warn_ffirstpassword2">Please input the password!</p> 
           	</td>
          </tr>
          <tr>
            <td><label for="reg_password_again2">Password</label></td>
            <td>
            	<s:password showPassword="true" id="reg_password_again2" name="reg_password_again2"  cssClass="form-control" placeholder="Password Again"/>
            	<p class="warning" id="warn_fpassword">Two passwords aren't consistent!</p>
                <p class="warning" id="warn_fpassword2">Please input the password again!</p>
            </td>
          </tr>
          
          <tr>
            <td><label for="reg_address2">Address</label></td>
            <td>
            	<s:textfield type="text" id="reg_address2" name="reg_address2" label="Address" cssClass="form-control" placeholder="Address" />
            	<p class="warning" id="warn_faddress2">Please input the address!</p>
            </td>
          </tr>

          <tr>
            <td><label for="reg_picture2">Picture</label></td>
            <td>             
                <s:file id="reg_picture2" name="reg_picture2" />
                <p class="warning" id="warn_fpicture">Format must be png,gif,jpg,jpeg,or bmp!</p>
            </td>
          </tr>
          <tr>
              <td><label >Members</label></td>
              <td></td>
          </tr>
        </table> 
          <div id="members">
  
              <table class="table table-striped table_border_alone">
                  <tr >
                      <td> <label for="mem_name">Name</label></td>
                      <td class="td_mem_name"><s:textfield  name="mem_name"  cssClass="form-control mem_name" placeholder="Name" /></td>
                  </tr>
                  <tr>
                      <td><label for="mem_gender">Gender</label></td>
                      <td>
                          <s:select name="mem_gender" labelposition="top" cssClass="form-control mem_gender" 
                                    list="{'Woman','Man','Other'}" />
                      </td>
                  </tr>
                  <tr >
                      <td><label for="mem_birthday">Birthday</label></td>
                      <td class="td_mem_birthday">
                         <s:textfield name="mem_birthday"   data-date-format="yyyy/mm/dd"  cssClass="datepicker form-control mem_birthday"/> 
                      </td>  
                  </tr>    
                  <tr>
                      <td><label for="mem_identity">Family <br>identity</label></td>
                      <td>
                         <s:select name="mem_identity" cssClass="form-control mem_identity"
                         list="{'Head','Mate','Child','Mother','Father','Brother','Sisiter','Uncle','Other'}" />
                      </td>
                  </tr>   
                  <tr>
                        <td></td>
                        <td><a class="btn btn-danger keep_right mem_remove" >Remove this member</a></td>                       
                  </tr>                
                  
              </table><!-- member -->
              

              
          </div><!-- members -->

                        
                        <a class="btn btn-default center-block" id="mem_add">
                        <img src=<s:url value="/member/images/addmem.png"/> height="25" width="35"title="Add a family member">
                        </a>

        
         <br>
         <s:submit  cssClass="btn btn-info btn-lg center-block" value="Submit"/>

      </s:form>
      
      </div><!-- family -->

    </div><!-- container -->
    
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
</html>