$.ajax({
	url:"/err/getAjaxerror",
	type:"POST",
	async:false,
	success:function(data){
		if(data.status == 200 && data.msg == "ok"){
			alert("success");
		}else{
			alert("∑¢…˙“Ï≥££∫"+data.msg);
		}
	},
	error:function(respomse.ajaxOptions,thrownError){
		alert("error");
	}
});