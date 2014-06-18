<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  	<s:head theme="simple" />
    <title>Homepage</title>
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
        <s:iterator value="activityList" id="activity" status="st">
           <table>
              <br>
              <hr>
            <tr>
                <td>
                   <div class="homepage_act">
                     <img src=<s:property value="#activity.picture" />  width="280px" class="homepage_pic" />
                     <div class="homepage_act_info">
                       <div class="homepage_info2">
                      
                         <table class="table">
                       	   <tr>
                         		<td><b>Theme</b></td>
                         		<td><s:property value="#activity.theme" /></td>
                           </tr>
                           <tr>
                         	    <td><b>Schedule</b></td>
                         		<td>
                         			<s:property value="#activity.session1" /><br>
                         			<s:property value="#activity.session2" /><br>
                         			<s:property value="#activity.session3" /><br>
                         			<s:property value="#activity.session4" /><br>
                         		</td>
                           </tr>
                         </table>
                        
                       </div>     
                       <s:url action="activity" var="activityLink">
                            <s:param name="aid">
                                <s:property value="#activity.id" />
                            </s:param>
                        </s:url>
                                    
                        <s:a  theme="simple" href="%{activityLink}" cssClass="btn btn-default homepage_moreinfo">More >></s:a>
                       
                       
                     </div>                     
                  </div>               
                </td>
            </tr>
        </table>
        </s:iterator>

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<ul class="pagination">
					<s:iterator value="#session.pageList" id="pageNumber" status="st">
						<s:url action="page" var="pageLink">
							<s:param name="gotoPage">
								<s:property value="#pageNumber" />
							</s:param>
						</s:url>

						<s:if test="session.currentPage == #pageNumber">
							<li class="active"><s:a href="%{pageLink}">
									<s:property value="#pageNumber" />
								</s:a></li>
						</s:if>
						<s:else>
							<li><s:a href="%{pageLink}">
									<s:property value="#pageNumber" />
								</s:a></li>
						</s:else>

					</s:iterator>

				</ul>
			</div>
			<div class="col-md-4"></div>
		</div>

	</div>
  </body>
  <%@ include file="footer.jsp"  %>
  
  <script>
		$(function(){
			$("#header_nav .active").removeClass("active");
			$("#home").addClass("active");
			
			});
  </script>
</html>