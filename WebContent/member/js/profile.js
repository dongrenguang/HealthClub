$(function(){
	$('#deleteAccount').bind('click',function(e){
		
		var r=confirm("Are you sure to delete your account?");
		if (r==true)
		  {
			/*
			var oldpw=prompt("Please input your password:");
			alert(oldpw);

			$.get('judgeOldPassword',{old_password: oldpw},function(response){
				if(response=="N"){
					alert("The password you inputed is wrong!");
					
	        	    return false;
				}
				else{
					alert("password is true!");
					
				}
			});	
		      return false;*/
			return true;
		  }
		else
		  {
		      return false;
		  }
		/*e.preventDefault();
					var thisHref	= $(this).attr('href');					
					if(confirm('Are you sure to delete your account?')) {
						//window.location = thisHref;
						//window.location = thisHref;
						location.href="";
					}

*/
	});

});