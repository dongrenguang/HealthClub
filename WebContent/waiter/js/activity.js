$(function(){
	$('#act_addsession').bind('click',function(){
		$("div#hidden").children().clone().appendTo('#act_sessions');
	});

	$('.act_delete_session').live('click',function(event){
		$(this).parent().parent().parent().detach();

	});

});