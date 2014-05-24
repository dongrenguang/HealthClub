<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>Payment</title>
    <s:head theme="simple"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<s:url value="/member/css/bootstrap.css" />" />
    <link rel="stylesheet" href="<s:url value="/member/css/member.css" />" />

    <script src=<s:url value="/member/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/selectivizr.js" /> type="text/javascript"></script>
    <script src=<s:url value="/member/js/payment.js" /> type="text/javascript"></script>


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

      <div id="pay_qualification">
        <div class="member_picture">
      
            <img src=<s:property value="picture" /> width="200px" />  
        </div>

        <div class="info">
          <table class="table table-hover table_profile">
            <tr>
              <td><label>Username</label></td>
              <td><s:property value="username" /></td>
            </tr>

            <tr>
              <td><label>Card</label></td>
              <td><s:property value="uid" /></td>
            </tr>

            <tr>
              <td><label>Type</label></td>
              <td><s:property value="type" /></td>
            </tr>
          </table>
         
          <s:if test="state==0">
            <div>
              <p class="warning">            
              <img src="<s:url value="/member/images/member/unactivated.png" />" height="25">
                You haven't activated your account.<br>
              </p>
             
               <s:a  theme="simple" href="activate.action" id="activate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click here to activate your account.</s:a> 
            </div>
          </s:if>
          
          <s:hidden id="state"  name="state" />   
          
          <s:else>
              <div>
                  <img src="<s:url value="/member/images/member/activated.png" />" height="25">
                  Your account is activated.
              </div>         
          </s:else>
          
        </div>

      </div>
      <br>
      <hr align="CENTER" size="2" width="100%" color="gray" >  <!--横线-->

      <div id="pay_monthly">
        <h2 ><center>The statement of your account.</center></h2>
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
                         <s:url action="pay" var="payLink">
                            <s:param name="pid">
                                <s:property value="#pays.id" />
                            </s:param>
                         </s:url>
                         <s:a  theme="simple"  href="%{payLink}" cssClass=" paynow">pay</s:a>
                        
                      </s:if>
                      <s:else>
                        <img src="<s:url value="/member/images/member/activated.png" />"  title="You has payed for this month!" height="25">
                      </s:else>
                    </td>
                    <td><s:property value="#pays.paytime" /></td>
                   
                  </tr>
           </s:iterator>  
          


        </table>

      </div>

    </div>

  </body>
</html>