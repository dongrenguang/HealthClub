$(function(){
	$('#del_pw').bind('change',function(event){
		var oldpw=$.trim($("#del_pw").attr("value"));

		$.get('judgeOldPassword',{old_password: oldpw},function(response){
			if(response=="N"){
				alert("The password you inputed is wrong!");
				$('#del_pw').attr('value',null);
        	    $("#del_pw").focus();
			}
		});	


	});

	$('#del_delete').bind('click',function(event){
		var pw=$.trim($("#del_pw").attr("value"));
		if(pw==null || pw==""){
			alert("You must input your password first!");
			return false;
		}else{
			return true;
		}

	});


});