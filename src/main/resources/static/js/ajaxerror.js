$.ajax({
	url:"/err/getAjaxerror",
	type:"POST",
	async:false,
	success:function(data){
		if(data.status == 200 && data.msg == "ok"){
			alert("success");
		}else{
			alert("�����쳣��"+data.msg);
		}
	},
	error:function(respomse.ajaxOptions,thrownError){
		alert("error");
	}
});