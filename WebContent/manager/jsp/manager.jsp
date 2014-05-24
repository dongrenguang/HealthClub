<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <s:head theme="simple"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="<s:url value="/manager/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/manager/css/manager.css" />" />

    <script src=<s:url value="/manager/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/manager/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/manager/js/manager.js" /> type="text/javascript"></script>
    
<title>Manager</title>
</head>
<body>
    <%@ include file="header.jsp"  %>
    
    <div class="container" id="manager_container">
        <div id="age">
            <table class="table table-hover">
                <caption>Age distribution of Members</caption>
                <tr>
                   <th>Age</th>
                   <th>Number</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="ageList" id="ageList" status="st">
                <tr>
                   <td><s:property value="#ageList.name" /></td>
                   <td><s:property value="#ageList.number" /></td>
                   <td><s:property value="#ageList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
            <br>
            <br>
            <table class="table table-hover">
               <caption>Age-group distribution of Members</caption>
                <tr>
                   <th>Age group</th>
                   <th>Number</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="ageGroupList" id="ageGroupList" status="st">
                <tr>
                   <td><s:property value="#ageGroupList.name" /></td>
                   <td><s:property value="#ageGroupList.number" /></td>
                   <td><s:property value="#ageGroupList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="gender">
            <table class="table table-hover">
            <caption>Gender distribution of Members</caption>
                <tr>
                   <th>Gender</th>
                   <th>Number</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="genderList" id="genderList" status="st">
                <tr>
                   <td><s:property value="#genderList.name" /></td>
                   <td><s:property value="#genderList.number" /></td>
                   <td><s:property value="#genderList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="address">
            <table class="table table-hover">
            <caption>Address distribution of Members</caption>
                <tr>
                  <th>Address</th>
                   <th>Number</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="addressList" id="addressList" status="st">
                <tr>
                   <td><s:property value="#addressList.name" /></td>
                   <td><s:property value="#addressList.number" /></td>
                   <td><s:property value="#addressList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="state">
            <table class="table table-hover">
            <caption>State distribution of Members</caption>
                <tr>
                   <th>State</th>
                   <th>Number</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="stateList" id="stateList" status="st">
                <tr>
                   <td><s:property value="#stateList.name" /></td>
                   <td><s:property value="#stateList.number" /></td>
                   <td><s:property value="#stateList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="coach">
            <table class="table table-hover">
                <caption>The distribution of coaches use</caption>
                <tr>
                   <th>Coach</th>
                   <th>Use</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="coachList" id="coachList" status="st">
                <tr>
                   <td><s:property value="#coachList.name" /></td>
                   <td><s:property value="#coachList.number" /></td>
                   <td><s:property value="#coachList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="site">
            <table class="table table-hover">
                <caption>The distribution of site use</caption>
                <tr>
                   <th>Site</th>
                   <th>Use</th>
                   <th>Proportion</th>
                </tr>
                <s:iterator value="siteList" id="siteList" status="st">
                <tr>
                   <td><s:property value="#siteList.name" /></td>
                   <td><s:property value="#siteList.number" /></td>
                   <td><s:property value="#siteList.proportion" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="persionnumber_month">
            <table class="table table-hover">
                <caption>Monthly active number</caption>
                <tr>
                   <th>Month</th>
                   <th>Number</th>
                </tr>
                <s:iterator value="persionnumber_monthList" id="persionnumber_monthList" status="st">
                <tr>
                   <td><s:property value="#persionnumber_monthList.name" /></td>
                   <td><s:property value="#persionnumber_monthList.number" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        <div id="persionnumber_day">
            <table class="table table-hover">
                <caption>Daily active number</caption>
                <tr>
                  <th>Date</th>
                   <th>Number</th>
                </tr>
                <s:iterator value="persionnumber_dayList" id="persionnumber_dayList" status="st">
                <tr>
                   <td><s:property value="#persionnumber_dayList.name" /></td>
                   <td><s:property value="#persionnumber_dayList.number" /></td>
                </tr>
                </s:iterator>
            </table>
        </div>
        
        
    
    
    </div>
    
    

</body>
</html>