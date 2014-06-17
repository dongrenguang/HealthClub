/*
            <li><a  class="header_li" id="nav_age">Age</a></li>       
            <li><a  class=" header_li" id="nav_gender">Gender</a></li>
            <li><a  class=" header_li" id="nav_address">Address</a></li>
            <li><a  class=" header_li" id="nav_state">State</a></li>
            
            <li><a  class=" header_li" id="nav_coach">Coach</a></li>
            <li><a  class=" header_li" id="nav_site">Site</a></li>
            <li><a  class=" header_li" id="nav_persionnumber_day">Daily active users</a></li>
            <li><a  class=" header_li" id="nav_persionnumber_month">Monthly active users</a></li>

*/

$(function(){	
	$.ajaxSetup({ 
	    async : false 
	}); 
	
	$(".warning").hide();
	
	$("#loginForm").bind('submit',function(event){
		var uname=$("#username").attr("value");
		var pw=$("#password").attr("value");
		var flag=false;
		
		$.get('CheckPasswordMemberAction',{username: uname, password: pw},function(response){
			
			if(response=="N"){
				$(".warning").show();
				$('#username').attr('value',null);
				$('#password').attr('value',null);
				$('#username').focus();
				
			}else{
				flag = true;
			}
			
		});	
		
		return flag;

	});

	
	
	




});