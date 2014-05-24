$(function(){

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
				alert("Your username '"+username+"' has been used!");
				$('#reg_username').attr('value',old_username);
				$('#reg_username').focus();

			}
		});		
	});

	$('#reg_email').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    if(!(reg.test($("#reg_email").attr("value"))))
		{
		    alert("Email format is wrong!");
		    $('#reg_email').focus();
		}	
	});

	$('#upload').bind('change',function(event){
		var fileext=document.register_info.upload.value.substring(document.register_info.upload.value.lastIndexOf("."),document.register_info.upload.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#upload').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
        }
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
	    
	    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    var fileext=document.register_info.upload.value.substring(document.register_info.upload.value.lastIndexOf("."),document.register_info.upload.value.length);
        fileext=fileext.toLowerCase();
        
	    if(!( (username!=null) && (email!=null) &&  (address!=null)  
	    		&& (username!="") && (email!="") && (address!="") ))
	    {
	    	alert('You have not write some important information!');
	    	return false;
	    }else if(!(reg.test(email))){
	    	 alert("Email format is wrong!");
	    	 return false;
	    }else if( (fileext!="")&&(fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#upload').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
            return false;
        }else{
        	return true;
        }  
        
	});

    $('a.mem_remove').live('click',function(event){
		$(this).parent().parent().parent().detach(); //É¾³ý³ÉÔ±
	});

	$('#mem_add').bind('click',function(){
		//$("div#hidden table.mem_copy_table").clone().after($("tr#members table"));
		$("div#hidden").children().clone().appendTo('#members');
		//$("div#hidden").children().clone().insertAfter(("tr#members table:last-child"));
		
		//alert('add');
		
	});

});