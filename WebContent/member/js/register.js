
$(function(){

	$('.datepicker').live('click',function(event){
		$(this).datepicker();
	});
	
	$('#reg_password_again').bind('change',function(event){
		var pw1=$("#reg_password").attr("value");
	    var pw2=$("#reg_password_again").attr("value");
	    if(pw1!=pw2){
		  alert("Your two passwords is not consistent!");
		  $('#reg_password_again').attr('value',null);
		  $('#reg_password_again').focus();
	    }
	});
	
	$('#reg_email').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    if(!(reg.test($("#reg_email").attr("value"))))
		{
		    alert("Email format is wrong!");
		    $('#reg_email').focus();
		}	
	});
	
	$('#reg_username').bind('change',function(event){
		
		var username=$("#reg_username").attr("value");
		$.get('sameUsername',{reg_username: $("#reg_username").attr("value")},function(response){
			if(response=="Y"){
				alert("Your username '"+username+"' has been used!");
				$('#reg_username').attr('value',null);
				$('#reg_username').focus();
			}
		});		
	});
	
	$('#reg_picture').bind('change',function(event){
		var fileext=document.register_info.reg_picture.value.substring(document.register_info.reg_picture.value.lastIndexOf("."),document.register_info.reg_picture.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
        }
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
        
	    if(!( (username!=null) && (email!=null) && (pw1!=null) && (pw2!=null) && (address!=null) && (gender!=null) && (birthday!=null)  
	    		&& (username!="") && (email!="") && (pw1!="") && (pw2!="") && (address!="") && (gender!="") && (birthday!="") ))
	    {
	    	alert('You have not write some important information!');
	    	return false;
	    }else if(pw1!=pw2){
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
        }else{
        	return true;
            /*
    		$.get('sameUsername',{reg_username: $("#reg_username").attr("value")},function(response2){
    			if(response2=="Y"){
    				alert('Your username has been used!');
    				return false;
    			}else{
    				return true;
    			}
    		});	
        	*/
        }  
	});
	
	
	$('#reg_nav_personal').bind('click',function(event){
		$('#reg_family').hide();
		$('#reg_personal').show();
		$('#reg_title').text('Create one new personal Health Club account');
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
		$('#reg_title').text('Create one new family Health Club account');
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
	
	
	$('#reg_password_again2').bind('change',function(event){
		var pw1=$("#reg_password2").attr("value");
	    var pw2=$("#reg_password_again2").attr("value");
	    if(pw1!=pw2){
		  alert("Your two passwords is not consistent!");
		  $('#reg_password_again2').attr('value',null);
		  $('#reg_password_again2').focus();
	    }
	});
	
	$('#reg_email2').bind('change',function(event){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	    if(!(reg.test($("#reg_email2").attr("value"))))
		{
		    alert("Email format is wrong!");
		    $('#reg_email2').focus();
		}	
	});
	
	$('#reg_username2').bind('change',function(event){
		var username=$("#reg_username2").attr("value");
		$.get('sameUsername2',{reg_username2:username },function(response){
			if(response=="Y"){
				alert("Your username '"+username+"' has been used!");
				$('#reg_username2').attr('value',null);
				$('#reg_username2').focus();
			}
		});		
	});
	
	$('#reg_picture2').bind('change',function(event){
		var fileext=document.register_info_family.reg_picture2.value.substring(document.register_info_family.reg_picture2.value.lastIndexOf("."),document.register_info_family.reg_picture2.value.length);
        fileext=fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
        {
        	$('#reg_picture2').attr('value',null);
            alert("Image format error!Please upload your image in format png,gif,jpg,jpeg,or bmp!");
        }
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
        
	    if(!( (username!=null) && (email!=null) && (pw1!=null) && (pw2!=null) && (address!=null)   
	    		&& (username!="") && (email!="") && (pw1!="") && (pw2!="") && (address!="")  ))
	    {
	    	alert('You have not write some important information!');
	    	return false;
	    }else if(pw1!=pw2){
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
	    /* else{
        	//return true;
        	$.get('sameUsername2',{reg_username2:username},function(response2){
    			alert(response2);
    			if(response2=="Y"){
    				alert('Your username has been used!');
    				return false;
    			}else{
    				return true;
    			}
    		});	
        }  */
	    
	    
	    /*
	    alert('mem--');
	    $('td.td_mem_name').each(function(i,element){
	    	alert(i);
	    	
	    	var name=($($(this).children()).get(0)).attr("value");
	    	alert(name);
	    	if(name==null || name==""){
	    		alter("Please family members' information");
	    		return false;
	    	}
	    });
	    
	    $('td.td_mem_birthday').each(function(){
	    	var birthday=($($(this).children()).get(0)).attr("value");
	    	if(birthday==null || birthday==""){
	    		alter("Please family members' information");
	    		return false;
	    	}
	    });
	    */
	    return true;
	    
	});
	
	
	
	
	


	
	
	$('#reg_family').hide();
});