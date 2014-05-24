<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<s:url value="/waiter/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/waiter.css" />" />
    <link rel="stylesheet" href="<s:url value="/waiter/css/datepicker.css" />" />

    <script src=<s:url value="/waiter/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/bootstrap-datepicker.js" /> type="text/javascript"></script>
    <script src=<s:url value="/waiter/js/record.js" /> type="text/javascript"></script>
<title>Record</title>
</head>
<body>
    <%@ include file="header.jsp"  %>

    <div class="container">
        <div class="record_h2">
            <h2>Activity Record <img src="<s:url value="/waiter/images/waiter/record_make.png"/>" height="40"></h2></h2>
        </div>
        
        <div class="record_picture" >
            <img src="<s:url value="/waiter/images/waiter/record.png"/>" height="200px">

        </div>
        <div class="record" id="record_make">

        <s:form theme="simple" role="form" id="record_add" method="post" action="">
            <table class="table">
                <tr>
                    <td><label for="record_card">Card</label></td>
                    <td><s:textfield type="text" id="record_card" name="record_card" cssClass="form-control" placeholder="Please input the Card Number first" /></td>
                </tr>
                <tr>
                    <td><label for="record_theme">Activity</label></td>
                    <td>
                        <!--<s:select   id="record_theme" name="record_theme" cssClass="form-control" list="{}"/> -->
                        <select id="record_theme" name="record_theme" class="form-control">
                            <option value="">------------------------has ordered activities------------------------</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="record_time">Time</label></td>
                    <td>
                        <s:textfield name="record_time"  id="record_time" cssClass="datepicker form-control" data-date-format="yyyy/mm/dd"/> 
                    </td>
                </tr>


            </table>
            <br>
            <div class="btn_center">
                <s:submit  cssClass="btn btn-primary btn_record"  value="Save"/>
            </div>

        </s:form>
        </div>

        

    </div>

</body>
</html>