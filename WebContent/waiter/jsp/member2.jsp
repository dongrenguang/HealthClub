<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="simple"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<s:url value="/waiter/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/member.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/datepicker.css" />" />

    <script src=<s:url value="/waiter/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap-datepicker.js" /> type="text/javascript"></script>
<title>Insert title here</title>
</head>
  <body>
    <%@ include file="header.jsp"  %>
    <div class="container">
      <div id="pro_up row">
        <div class="member_picture">
            <img src="<s:property value="picture" />" width="200px" />    
        </div>
        <div class="info">
            <table class="table table_profile" id="profile2_mem">
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
           <s:url action="order" var="orderLink">
              <s:param name="id">
                  <s:property value="id" />
              </s:param>
           </s:url>
           <a href="W_BeforeModify2.action"  title="Edit my base information.">[ Edit ]</a>&nbsp;&nbsp;&nbsp;
         </div>  
        
      </div>
      
      <hr />
      <br>
      
      <div class="pro_hasordere">
          <ul class="nav nav-tabs pro_hasordere">
            <li class="active"><a href="#ordered" data-toggle="tab"><h4>Ordered Activity</h4></a></li>
            <li><a href="#joined" data-toggle="tab"><h4>Joined Activity</h4></a></li>
            <li><a href="#payment" data-toggle="tab"><h4>Payment Record</h4></a></li>
          </ul>

          <div id="myTabContent" class="tab-content">
            
            <div class="tab-pane active" id="ordered">
              <div class="pro_hasordered">
              <br>
			        <table class="table table-striped table-hover">
			           <tr>
	                    <th>Theme</th>
	                    <th>Time</th>
	                    <th>Location</th>
	                    <th>Coach</th>
	                    <th>Record</th>
			                    
			           </tr>
			        
			          <s:iterator value="orderedAct" id="ordered" status="st">
		                  <tr>
		                    <td><s:property value="#ordered.theme" /></td>
		                    <td><s:property value="#ordered.time" /></td>
		                    <td><s:property value="#ordered.location" /></td>
		                    <td><s:property value="#ordered.coach" /></td>
		                    <td>
		                        <s:url action="JoinAction" var="joinLink">
		                            <s:param name="sid">
		                                <s:property value="#ordered.id" />
		                            </s:param>
		                            <s:param name="uid">
		                                <s:property value="uid" />
		                            </s:param>
		                        </s:url>
		                        <s:a  theme="simple" href="%{joinLink}" cssClass="btn-success">Join</s:a>
		                    </td>                   
		                  </tr>
			           </s:iterator>  
			         </table>
			    </div>    
            </div>

            <div class="tab-pane" id="joined">
             <div class="pro_hasjoined">
             <br>
		        <table class="table table-striped table-hover">
		           <tr>
                    <th>Theme</th>
                    <th>Time</th>
                    <th>Location</th>
                    <th>Coach</th>
                    <th>Modify</th>
		           </tr>
		          <s:iterator value="hasJoinedAct" id="hasjoin" status="st">
	                  <tr>
	                    <td><s:property value="#hasjoin.theme" /></td>
	                    <td><s:property value="#hasjoin.time" /></td>
	                    <td><s:property value="#hasjoin.location" /></td>
	                    <td><s:property value="#hasjoin.coach" /></td>
	                    <td>
	                       <s:url action="DeleteActAction" var="deleteLink">
	                            <s:param name="sid">
	                                <s:property value="#hasjoin.id" />
	                            </s:param>
	                            <s:param name="uid">
	                                <s:property value="uid" />
	                            </s:param>
	                        </s:url>
	                        <s:a  theme="simple" href="%{deleteLink}" cssClass="btn btn-danger">delete</s:a>
	                    </td>
	                  </tr>
		           </s:iterator>  
		         </table>
		      </div>           
            </div>
            
            <div class="tab-pane" id="payment">  
           	 <div id="pay_monthly">
		        <table class="table table-hover table_pay_monthly">
		          <tr>
		            <th>Month</th>
		            <th>Statement</th>
		            <th>Pay time</th>
		          </tr>
		          <s:iterator value="paymentList" id="pays" status="st">
	                  <tr>
	                    <td><s:property value="#pays.month" /></td>
	                    <td>
	                      <s:if test="#pays.type==1">
	                        <img src="<s:url value="/member/images/member/unactivated.png" />"  title="has not payed for this month" height="25">
	                      </s:if>
	                      <s:else>
	                        <img src="<s:url value="/member/images/member/activated.png" />"  title=" has payed for this month" height="25">
	                      </s:else>
	                    </td>
	                    <td><s:property value="#pays.paytime" /></td>
	                  </tr>
		           </s:iterator>  
		         </table>
		      </div>
      	    </div>
    	  </div>
  	  </div>
  	  
  	
      <hr />
      <br>
      
      <br>
      </div>
  </body>
<script>
		$(function(){
			$("#header_nav .active").removeClass("active");
			$("#member").addClass("active");
			
			});
  </script>
  
 <%@ include file="footer.jsp"%>  
  </html>
  
  