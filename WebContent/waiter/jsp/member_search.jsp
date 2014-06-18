<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<%@page import="java.util.ArrayList"%>
<%@page import="healthclub.member.model.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="simple"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<s:url value="/waiter/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/waiter.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/datepicker.css" />" />

    <script src=<s:url value="/waiter/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap-datepicker.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/member_search.js" /> type="text/javascript"></script>
    
<title>Insert title here</title>
</head>
<body>
    <%@ include file="header.jsp"  %>

    <div class="container ">
        <div class="record_h2">
            <h2>Member Center <img   src=<s:url value="/waiter/images/waiter/mem_h2.png" /> height="40"></h2>
        </div>
        
        <div class="input-group mem_search ">
             <s:form theme="simple"  role="form"  id="form_mem_search" name="form_mem_search" method="post" action="/SearchAction" >
                <s:textfield   id="uid" name="uid"  cssClass="textfield_mem_uid" placeholder="Please enter the card number to query" />
                <s:submit cssClass="btn btn-primary" id="btn_mem_search" name="btn_mem_search" value="Search"/>
                <h4 class="text-danger">
        		<% Object errorMessage = request.getAttribute("error");
      		 	if(errorMessage!=null){out.println(errorMessage.toString());}%>
    			</h4> 
            </s:form>
        </div >
        
         <div class="row">
        	<p></p>
        </div>
        
        <div class="panel-group mem_search" id="accordion">
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
		          <center>Check Member List</center>
		        </a>
		      </h4>
		    </div>
		    <div id="collapseOne" class="panel-collapse collapse">
		      <div class="panel-body">
		      	<table class="table table-striped table-hover">
			       <thead>
			         <tr>
			           <th>User Name</th>
			           <th>User Id</th>
			         </tr>
			       </thead>
			       <tbody>
			       	 <%ArrayList<Users> userList = (ArrayList<Users>)session.getAttribute("userList");
			       	 for(int i =0; i < userList.size(); i++){ %>
			         <tr>
			           <td><%=userList.get(i).getUsername()%></td>
			           <td><a href="http://localhost:8080/HealthClub/SearchAction?uid=<%=userList.get(i).getId()%>"><%=userList.get(i).getId()%></a></td>
			         </tr>
			         <%} %>
			       </tbody>
		     	</table>
		      </div>
		    </div>
		  </div>
	    </div>
        
        

    </div>

</body>
<script>
		$(function(){
			$(".active").removeClass("active");
			$("#member").addClass("active");
			
			});
  </script>
 <%@ include file="footer.jsp"%> 
 </html> 