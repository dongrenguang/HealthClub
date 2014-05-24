$(function(){
	$('.datepicker').bind('click',function(event){
		$(this).datepicker();
	});

	$('#record_card').change(function(event){
		var card=$.trim($("#record_card").attr("value"));
		if(card==""){
			alert("Please input the Card Number first");
			$("#record_card").attr("value",null);
			$('#record_card').focus();
			return false;
		}

		$.get('CardValidAction',{card: card},function(response){
			if(response=="N"){
				alert("The Card Number is invalid!");
				$("#record_card").attr("value",null);
			    $('#record_card').focus();
			    return false;
			}
		});	

		$('#record_theme').html("");//清空

		$('#record_theme').load(
			'GetSessionsByCardAction',{card: card}

		);



	});//#record_card

	$('#record_theme').bind('click',function(event){
		var card=$.trim($("#record_card").attr("value"));
		if(card==""){
			alert("Please input the Card Number first");
			$("#record_card").attr("value",null);
			$('#record_card').focus();
			return false;
		}
	});

	

});