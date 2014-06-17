
$(function(){

	$('.datepicker').live('click',function(event){
		$(this).datepicker();
	});
	
	$('#reg_password').bind('change',function(event){
		$("#warn_firstpassword2").hide();
	});
	
	$('#reg_password_again').bind('change',function(event){
		var pw1=$("#reg_password").attr("value");
	    var pw2=$("#reg_password_again").attr("value");
	    $("#warn_password2").hide();
	    if(pw1!=pw2){
		  $("#warn_password").show();
		  $('#reg_password_again').attr('value',null);
		  $('#reg_password_again').focus();
	    }else{
	    	$("#warn_password").hide();
	    }
	});
	
	$('#reg_email').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		$("#warn_email2").hide();
	    if(!(reg.test($("#reg_email").attr("value"))))
		{
		    $('#reg_email').focus();
		    $("#warn_email").show();
		}else{
			$("#warn_email").hide();
		}	
	});
	
	$('#reg_username').bind('change',function(event){
		$("#warn_username2").hide();
		var username=$("#reg_username").attr("value");
		$.get('sameUsername',{reg_username: username},function(response){
			if(response=="Y"){
				$("#warn_username").show();
				$('#reg_username').attr('value',null);
				$('#reg_username').focus();
			}else{
				$("#warn_username").hide();
			}
		});		
	});
	
	$('#reg_picture').bind('change',function(event){
		var fileext=document.register_info.reg_picture.value.substring(document.register_info.reg_picture.value.lastIndexOf("."),document.register_info.reg_picture.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture').attr('value',null);
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
	
	$('#register_info').bind('submit',function(event){
		var username=$("#reg_username").attr("value");
		var email=$("#reg_email").attr("value");
		var pw1=$("#reg_password").attr("value");
	    var pw2=$("#reg_password_again").attr("value");
	    var address=$("#reg_address").attr("value");
	    var gender=$("#reg_gender").attr("value");
	    var birthday=$("#reg_birthday").attr("value");
	    
	    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    var fileext=document.register_info.reg_picture.value.substring(document.register_info.reg_picture.value.lastIndexOf("."),document.register_info.reg_picture.value.length);
        fileext=fileext.toLowerCase();
        
//	    if(!(  (username!="") && (email!="") && (pw1!="") && (pw2!="") && (address!="") && (gender!="") && (birthday!="") ))
//	    {
//	    	alert('You have not write some important information!');
//	    	return false;
//	    }
	    if(username==""){
	    	$("#warn_username").hide();
	    	$("#warn_username2").show();
	    	return false;
	    }else if(email==""){
	    	$("#warn_email").hide();
	    	$("#warn_email2").show();
	    	return false;
	    }else if(pw1==""){
	    	$("#warn_firstpassword2").show();
	    	return false;
	    }else if(pw2==""){
	    	$("#warn_password").hide();
	    	$("#warn_password2").show();
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
	    else if(pw1!=pw2){
	    	alert("Your two passwords is not consistent!");
	    	return false;
	    }else if(!(reg.test(email))){
	    	 alert("Email format is wrong!");
	    	 return false;
	    }else if( (fileext!="")&&(fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
            return false;
        }
        */
	    else{
        	return true;
        }  
	});
	
	
	$('#reg_nav_personal').bind('click',function(event){
		$('#reg_family').hide();
		$('#reg_personal').show();
		$('#reg_title').text('Create a new personal Health Club account');
		$('#reg_nav_family').attr({
			height:"60"
		});
		$('#reg_nav_personal').attr({
			height:"100",width:"70"
		});
	});
	
	$('#reg_nav_family').bind('click',function(event){
		$('#reg_personal').hide();
		$('#reg_family').show();
		$('#reg_title').text('Create a new family Health Club account');
		$('#reg_nav_personal').attr({
			height:"50",width:"40"
		});
		$('#reg_nav_family').attr({
			height:"100"
		});
	});
	
	///////////////////////////////////////////////////////////////////family
	
	$('#mem_add').bind('click',function(){
		//$("div#hidden table.mem_copy_table").clone().after($("tr#members table"));
		$("div#hidden").children().clone().appendTo('#members');
		//$("div#hidden").children().clone().insertAfter(("tr#members table:last-child"));
		
		//alert('add');
		
	});
	
	$('a.mem_remove').live('click',function(event){
		$(this).parent().parent().parent().detach(); //É¾³ý³ÉÔ±
	});
	
	$('#reg_password2').bind('change',function(event){
		$("#warn_ffirstpassword2").hide();
	});
	
	$('#reg_password_again2').bind('change',function(event){
		var pw1=$("#reg_password2").attr("value");
	    var pw2=$("#reg_password_again2").attr("value");
	    $("#warn_fpassword2").hide();
	    if(pw1!=pw2){
	    	$("#warn_fpassword").show();
		  $('#reg_password_again2').attr('value',null);
		  $('#reg_password_again2').focus();
	    }else{
	    	$("#warn_fpassword").hide();
	    }
	});
	
	$('#reg_email2').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		$("#warn_femail2").hide();
	    if(!(reg.test($("#reg_email2").attr("value"))))
		{
	    	$("#warn_femail").show();
		    $('#reg_email2').focus();
		}else{
			$("#warn_femail").hide();
		}
	});
	
	$('#reg_username2').bind('change',function(event){
		var username=$("#reg_username2").attr("value");
		$("#warn_fusername2").hide();
		$.get('sameUsername2',{reg_username2:username },function(response){
			if(response=="Y"){
				$("#warn_fusername").show();
				$('#reg_username2').attr('value',null);
				$('#reg_username2').focus();
			}else{
				$("#warn_fusername").hide();
			}
		});		
	});
	
	$('#reg_picture2').bind('change',function(event){
		var fileext=document.register_info_family.reg_picture2.value.substring(document.register_info_family.reg_picture2.value.lastIndexOf("."),document.register_info_family.reg_picture2.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture2').attr('value',null);
        	$("#warn_fpicture").show();
        }else{
        	$("#warn_fpicture").hide();
        }
	});
	
	$("#reg_address2").bind('change',function(event){
		$("#warn_faddress2").hide();
	});
	
	$('#register_info_family').bind('submit',function(event){
		var username=$("#reg_username2").attr("value");
		var email=$("#reg_email2").attr("value");
		var pw1=$("#reg_password2").attr("value");
	    var pw2=$("#reg_password_again2").attr("value");
	    var address=$("#reg_address2").attr("value");
	    //var gender=$("#reg_gender").attr("value");
	   // var birthday=dojo.widget.byId("reg_birthday").inputNode.value;
	    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		var fileext=document.register_info_family.reg_picture2.value.substring(document.register_info_family.reg_picture2.value.lastIndexOf("."),document.register_info_family.reg_picture2.value.length);
        fileext=fileext.toLowerCase();
        
//	    if(!((username!="") && (email!="") && (pw1!="") && (pw2!="") && (address!="")  ))
//	    {
//	    	alert('You have not write some important information!');
//	    	return false;
//	    }
        if(username==""){
	    	$("#warn_fusername").hide();
	    	$("#warn_fusername2").show();
	    	return false;
	    }else if(email==""){
	    	$("#warn_femail").hide();
	    	$("#warn_femail2").show();
	    	return false;
	    }else if(pw1==""){
	    	$("#warn_ffirstpassword2").show();
	    	return false;
	    }else if(pw2==""){
	    	$("#warn_fpassword").hide();
	    	$("#warn_fpassword2").show();
	    	return false;
	    }else if(address==""){
	    	$("#warn_faddress2").show();
	    	return false;
	    }else if(!(reg.test(email))){
	    	$("#warn_femail2").hide();
	    	$("#warn_femail").show();
	    	 return false;
	    }
	    /*
	    else if(pw1!=pw2){
	    	alert("Your two passwords is not consistent!");
	    	return false;
	    }else if(!(reg.test(email))){
	    	 alert("Email format is wrong!");
	    	 return false;
	    }else if( (fileext!="")&&(fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
            return false;
        }
        */
	    return true;
	});
	
	$('#reg_family').hide();
	
	/***** warning ***********************************************/
	$(".warning").hide();

});
