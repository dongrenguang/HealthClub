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

<title>Manager</title>
</head>
<body>
    <%@ include file="header.jsp"  %>
    
    <div class="container" id="manager_container">




        <div id="age" style="width:1000px;margin-left:100px;margin-top:70px;">
            <div id="ageChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
     
        <div id="gender" style="width:1000px;margin-left:100px;margin-top:70px;">
            <div id="genderChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
        
        <div id="address">
            <div id="addressChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
        
        <div id="state">
			<div id="stateChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
        
        <div id="coach">
			<div id="coachChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
        
        <div id="site">
			<div id="siteChart" style="margin-top:40px; margin-bottom:90px;"></div>
        </div>
 
        
        <div id="persionnumber_day">
			<div id="dayChart" style="margin-top:40px; margin-bottom:90px;"></div>
        
            <table class="table table-hover">
                <caption class="h3" style="margin-bottom:20px;">Daily active number</caption>
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


    <script src=<s:url value="/manager/js/jquery-1.7.1.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/manager/js/bootstrap.js" /> type="text/javascript"></script>
    <script src=<s:url value="/manager/js/manager.js" /> type="text/javascript"></script>
   	<script src="<s:url value="/manager/js/Chart.js-master/Chart.js" />"></script>
   	<script src="<s:url value="/manager/js/highcharts/highcharts.js" />"></script>
   	<script src="<s:url value="/manager/js/highcharts/highcharts-3d.js" />"></script>
   	<script src="<s:url value="/manager/js/highcharts/modules/exporting.js" />"></script>
   	    
    
    <script> 
    
    	$(function(){
    		
    		//age
    		
    		$('#ageChart').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'The Age-group Distribution of Members'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: [
								<s:iterator value="ageGroupList" id="ageGroupList"  status="st">
									'<s:property value="name"/>' ,
								</s:iterator>                    
                                 ],
                    title: null,
                },
                yAxis: {
                    min: 0,
                    title: null,
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' people'
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor || '#FFFFFF'),
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: 'age group',
                    data: [
							<s:iterator value="ageGroupList" id="ageGroupList"  status="st">
								<s:property value="number"/>,
							</s:iterator>  
                           ]
                }, 
                ]
            });    		
    		
    		
    		//gender

			Highcharts.getOptions().plotOptions.pie.colors = ['#00C5CD','#FF6A6A','#FF7F24','3CB371'];

    		$('#genderChart').highcharts({
    	        chart: {
    	            type: 'pie',
    	            options3d: {
    					enabled: true,
    	                alpha: 45,
    	                beta: 0
    	            }
    	        },
    	        title: {
    	            text: 'Gender distribution of Members'
    	        },
    	        tooltip: {
    	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    	        },
    	        plotOptions: {
    	            pie: {
    	                allowPointSelect: true,
    	                cursor: 'pointer',
    	                depth: 35,
    	                dataLabels: {
    	                    enabled: true,
    	                    format: '{point.name}'
    	                }
    	            }
    	        },
    	        series: [{
    	            type: 'pie',
    	            name: 'share',
    	            data: [
						<s:iterator value="genderList" id="genderList"  status="st">
							[ '<s:property value="name"/>' , <s:property value="proportion"/>],
						</s:iterator>     	                   
    	            ]
    	        }]
    	    });
    		
    		$('#addressChart').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'The Address Distribution of Members'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: [
								<s:iterator value="addressList" id="addressList"  status="st">
									'<s:property value="name"/>' ,
								</s:iterator>                    
                                 ],
                    title: null,
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '',
                        align: 'high'
                    },
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' people'
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor || '#FFFFFF'),
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: 'address',
                    data: [
							<s:iterator value="addressList" id="addressList"  status="st">
								<s:property value="number"/>,
							</s:iterator>  
                           ]
                }, 
                ]
            });    		
    		
    		
    		$('#stateChart').highcharts({
    	        chart: {
    	            type: 'pie',
    	            options3d: {
    					enabled: true,
    	                alpha: 45,
    	                beta: 0
    	            }
    	        },
    	        title: {
    	            text: 'State distribution of Members'
    	        },
    	        tooltip: {
    	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    	        },
    	        plotOptions: {
    	            pie: {
    	                allowPointSelect: true,
    	                cursor: 'pointer',
    	                depth: 35,
    	                dataLabels: {
    	                    enabled: true,
    	                    format: '{point.name}'
    	                }
    	            }
    	        },
    	        series: [{
    	            type: 'pie',
    	            name: 'share',
    	            data: [
						<s:iterator value="stateList" id="stateList"  status="st">
							[ '<s:property value="name"/>' , <s:property value="proportion"/>],
						</s:iterator>     	                   
    	            ]
    	        }]
    	    });
    		

    		$('#coachChart').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'The distribution of coaches use'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: [
								<s:iterator value="coachList" id="coachList"  status="st">
									'<s:property value="name"/>' ,
								</s:iterator>                    
                                 ],
                    title: null,
                },
                yAxis: {
                    min: 0,
                    title: null,
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' uses'
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor || '#FFFFFF'),
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: 'coach use',
                    data: [
							<s:iterator value="coachList" id="coachList"  status="st">
								<s:property value="number"/>,
							</s:iterator>  
                           ]
                }, 
                ]
            });
    		

    		$('#siteChart').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'The Distribution of Site Use'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: [
								<s:iterator value="siteList" id="siteList"  status="st">
									'<s:property value="name"/>' ,
								</s:iterator>                    
                                 ],
                    title: null,
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '',
                        align: 'high'
                    },
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' uses'
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor || '#FFFFFF'),
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: 'address',
                    data: [
							<s:iterator value="siteList" id="siteList"  status="st">
								<s:property value="number"/>,
							</s:iterator>  
                           ]
                }, 
                ]
            });    		
    		    		
    		
    		//line
    		
    		$('#dayChart').highcharts({
                title: {
                    text: 'Daily Active Users',
                    x: -20 //center
                },
                subtitle: null,
                xAxis: {
                    categories: [
								<s:iterator value="persionnumber_dayList" id="persionnumber_dayList"  status="st">
									'<s:property value="name"/>',
								</s:iterator>  
                                 ]
                },
                yAxis: {
                    title: null,
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ' users'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: 'Daily active users',
                    data: [
							<s:iterator value="persionnumber_dayList" id="persionnumber_dayList"  status="st">
								<s:property value="number"/>,
							</s:iterator>              
                           ]
                }]
            });
    		
    		
    	});
    
    </script>




</html>