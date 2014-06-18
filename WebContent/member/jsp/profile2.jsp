<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>Profile</title>
    <s:head theme="simple"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->

    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap-theme.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />
    

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/selectivizr.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/profile.js" /> type="text/javascript"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <%@ include file="header.jsp"  %>
    <div class="container">
      <div id="pro_up">
        <div class="member_picture">
            <img src=<s:property value="picture" /> width="200px" />    
        </div>

        <div class="info">


            <table class="table table_profile">
                <tr>
                    <td><label>Username</label></td>
                    <td><s:property value="username" /></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><s:property value="email" /></td>
                </tr>

                <tr>
                    <td><label>Address</label></td>
                    <td><s:property value="address" /></td>
                </tr> 

                <tr>
                  <table class="table table-striped table_border_alone"  id="profile2_mem">
                      <caption><label>Family Members</label></caption>
                      <tr>
                          <th>Name</th>
                          <th>Gender</th>
                          <th>Birthday</th>
                          <th>Identity</th>
                      </tr>
                      <s:iterator value="members" id="memberList" status="st">
                          <tr>
                              <td><s:property value="#memberList.name" /></td>
                              <td><s:property value="#memberList.gender" /></td>
                              <td><s:property value="#memberList.birthday" /></td>
                              <td><s:property value="#memberList.identity" /></td>
                          
                          </tr>
                      
                      </s:iterator>
                  
                  </table>
                
                </tr>
            </table>
        </div>
        <div id="pro_edit_delete">
                <a href="beforeModify2.action"  title="Edit my base information.">[ Edit ]</a>&nbsp;&nbsp;&nbsp;
                <a href="toDelete.action"  title="Delete my account." id="deleteAccount">[ Delete ]</a>
        </div>
      </div>
      
      <hr />
      <div class="pro_hasordered">
      <h2>Has Ordered Activities</h2>
        <table class="table table-striped table-hover">
           <tr>
                    <th>Theme</th>
                    <th>Time</th>
                    <th>Location</th>
                    <th>Coach</th>
                    <th>Operate</th>
           </tr>
        
          <s:iterator value="orderedAct" id="ordered" status="st">
                  <tr>
                    <td><s:property value="#ordered.theme" /></td>
                    <td><s:property value="#ordered.time" /></td>
                    <td><s:property value="#ordered.location" /></td>
                    <td><s:property value="#ordered.coach" /></td>
                    <td>
                        <s:url action="cancelOrdered" var="cancelOrderLink">
                            <s:param name="sid">
                                <s:property value="#ordered.id" />
                            </s:param>
                        </s:url>
                        <s:a  theme="simple" href="%{cancelOrderLink}" cssClass="btn btn-primary">Cancel</s:a>
                    </td>                    
                  </tr>
           </s:iterator>  
         </table>
      
          
        
      
      </div>
      
      <hr />
      <div class="pro_hasjoined">
       <h2>Has Joined  Activities</h2>
        <table class="table table-striped table-hover">
           <tr>
                    <th>Theme</th>
                    <th>Time</th>
                    <th>Location</th>
                    <th>Coach</th>
           </tr>
        
          <s:iterator value="hasJoinedAct" id="hasjoin" status="st">
                  <tr>
                    <td><s:property value="#hasjoin.theme" /></td>
                    <td><s:property value="#hasjoin.time" /></td>
                    <td><s:property value="#hasjoin.location" /></td>
                    <td><s:property value="#hasjoin.coach" /></td>
                  </tr>
           </s:iterator>  
         </table>
      
      </div>
    </div>

  </body>
  <%@ include file="footer.jsp"  %>
</html>