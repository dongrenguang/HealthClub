$(function(){
	$('.paynow').live('click',function(event){

		var state=$('#state').attr("value");
		if(state==0){
			alert('Your account has not been activated.Please activate first!');
			return false;
		}else{
			var account=prompt("Please input your bank account:");
		    account=$.trim(account);
		    if(account!=null && account!=""){
			    return true;
		    }else{
			    return false;
		    }
		}
	});

	$('#activate').live('click',function(event){
		var account=prompt("Please input your bank account:");
		account=$.trim(account);
		if(account!=null && account!=""){
			return true;
		}else{
			return false;
		}

	});

});