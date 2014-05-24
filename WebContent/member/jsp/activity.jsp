<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>Activity</title>
    <s:head theme="simple"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" >
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/selectivizr.js" /> type="text/javascript"></script>


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
        <img src=<s:property value="picture" /> width="300px" class="act_pic" />
        <div class="act_info">
            Theme: <s:property value="theme" /><br><br>
            Sessions:<br>
            
            
            <table class="table table-striped table-hover">
                <tr>
                    <th>Time</th>
                    <th>Location</th>
                    <th>Coach</th>
                    <th>Select</th>
                </tr>
                <s:iterator value="sessionList" id="asession" status="st">
                  <tr>
                    <td><s:property value="#asession.time" /></td>
                    <td><s:property value="#asession.location" /></td>
                    <td><s:property value="#asession.coach" /></td>
                    <td>
                        <s:url action="order" var="orderLink">
                            <s:param name="sid">
                                <s:property value="#asession.id" />
                            </s:param>
                            <s:param name="aid">
                                <s:property value="aid" />
                            </s:param>
                            <s:param name="theme">
                                <s:property value="theme" />
                            </s:param>
                            <s:param name="picture">
                                <s:property value="picture" />
                            </s:param>

                        </s:url>
                                    
                        <s:a  theme="simple" href="%{orderLink}" cssClass="btn btn-primary" class="act_order">Order</s:a>
                    </td>
                  </tr>
                </s:iterator>  
                


            </table>

        </div>

    </div>
</body>
</html>