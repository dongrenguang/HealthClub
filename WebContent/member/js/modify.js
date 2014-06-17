$(function(){
	$(".warning").hide();

	$('.datepicker').live('click',function(event){
		$(this).datepicker();
	});

	$('.modify_pw').hide();

	$('#modifypw').bind('click',function(event){
        $('.modify_pw').show();
	});

	$('#cancelmodifypw').bind('click',function(event){
		$('#old_password').attr('value',null);
		$('#new_password').attr('value',null);
		$('#new_password_again').attr('value',null);
		$('.modify_pw').hide();
	});

	$('#reg_username').bind('change',function(event){
		var username=$("#reg_username").attr("value");
		var old_username=$("#old_username").attr("value");
		if(username==old_username){
			return true;
		}
		if(username==null || username==""){
			$('#reg_username').attr('value',old_username);
			return true;
		}
		$.get('sameUsername',{reg_username: username},function(response){
			if(response=="Y"){
				$("#warn_username").show();
				$('#reg_username').attr('value',old_username);
				$('#reg_username').focus();
			}else{
				$("#warn_username").hide();
			}
		});		
	});

	$('#reg_email').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		$("#warn_email2").hide();
	    if(!(reg.test($("#reg_email").attr("value"))))
		{
	    	$("#warn_email").show();
		    $('#reg_email').focus();
		}else{
			$("#warn_email").hide();
		}	
	});

	$('#upload').bind('change',function(event){
		var fileext=document.register_info.upload.value.substring(document.register_info.upload.value.lastIndexOf("."),document.register_info.upload.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#upload').attr('value',null);
        	$("#warn_picture").show();
        }else{
        	$("#warn_picture").hide();
        }
	});
	
	$("#reg_address").bind('change',function(event){
		$("#warn_address2").hide();
	});
	
	$("#reg_birthday").bind('change',function(event){
		$("#warn_birthday2").hide();
	});

	$('#old_password').bind('change',function(){
		    var oldpw=$("#old_password").attr("value");
			$.get('judgeOldPassword',{old_password: oldpw},function(response){
			if(response=="N"){
				alert("The old password you inputed is wrong!");
				$('#old_password').attr('value',null);
        	    $("#old_password").focus();
			}
		});	
         
	});

    $('#new_password').bind('change',function(event){
    	var oldpw=$("#old_password").attr("value");
        if(oldpw==null || oldpw==""){
        	alert("Please input your old password first!");
        	$('#new_password').attr('value',null);
        	$("#old_password").focus();
        }

    });

	$('#new_password_again').bind('change',function(event){
        var oldpw=$("#old_password").attr("value");
        if(oldpw==null || oldpw==""){
        	alert("Please input your old password first!");
        	$('#new_password_again').attr('value',null);
        	$("#old_password").focus();
        }
		var pw1=$("#new_password").attr("value");
	    var pw2=$("#new_password_again").attr("value");
	    if(pw1!=pw2){
		  alert("Your two new passwords is not consistent!");
		  $('#new_password_again').attr('value',null);
		  $('#new_password_again').focus();
	    }
	});

		$('#register_info').bind('submit',function(event){
		  var username=$("#reg_username").attr("value");
		  var email=$("#reg_email").attr("value");
		  var oldpw=$("#old_password").attr("value");
		  var pw1=$("#new_password").attr("value");
	      var pw2=$("#new_password_again").attr("value");
	      var address=$("#reg_address").attr("value");
	      var gender=$("#reg_gender").attr("value");
	      var birthday=$("#reg_birthday").attr("value");
	    
	    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    var fileext=document.register_info.upload.value.substring(document.register_info.upload.value.lastIndexOf("."),document.register_info.upload.value.length);
        fileext=fileext.toLowerCase();
        /*
	    if(!((username!="") && (email!="") && (address!="") && (gender!="") && (birthday!="") ))
	    {
	    	alert('You have not write some important information!');
	    	return false;
	    }
	    */
        if(username==""){
	    	$("#warn_username").hide();
	    	$("#warn_username2").show();
	    	return false;
	    }else if(email==""){
	    	$("#warn_email").hide();
	    	$("#warn_email2").show();
	    	return false;
	    }else if(address==""){
	    	$("#warn_address2").show();
	    	return false;
	    }else if(birthday==""){
	    	$("#warn_birthday2").show();
	    	return false;
	    }else if(!(reg.test(email))){
	    	$("#warn_email2").hide();
	    	$("#warn_email").show();
	    	 return false;
	    }
	    
	    /*
	    else if(!(reg.test(email))){
	    	 alert("Email format is wrong!");
	    	 return false;
	    }else if( (fileext!="")&&(fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#upload').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
            return false;
        }
	    */
	    else{
        	return true;
        }  
        
	});

});