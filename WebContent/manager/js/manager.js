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
	$("#age").hide();
	$("#gender").hide();
	$("#address").hide();
	$("#state").hide();
	$("#coach").hide();
	$("#site").hide();
	//$("#persionnumber_day").hide();
	$("#persionnumber_month").hide();


	$("#nav_age").bind('click',function(){
		$("#age").show();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_gender").bind('click',function(){
		$("#age").hide();
	    $("#gender").show();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_address").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").show();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_state").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").show();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_coach").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").show();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_site").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").show();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").hide();
	});

	$("#nav_persionnumber_day").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").show();
	    $("#persionnumber_month").hide();
	});

	$("#nav_persionnumber_month").bind('click',function(){
		$("#age").hide();
	    $("#gender").hide();
	    $("#address").hide();
	    $("#state").hide();
	    $("#coach").hide();
	    $("#site").hide();
	    $("#persionnumber_day").hide();
	    $("#persionnumber_month").show();
	});
	

	
	
	




});