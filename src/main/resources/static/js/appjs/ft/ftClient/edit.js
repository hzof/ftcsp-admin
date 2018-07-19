//==========搜索框异步搜索开始行===========
function overFn(obj){
	$(obj).css("background","#DBEAF9");
}
function outFn(obj){
	$(obj).css("background","#fff");
}
function clickFn(obj){
	$("#servicerName").val($(obj).html());
	$("#showDiv").css("display","none");
	$("#servicerId").val(obj.id);
}
function searchWord(par){
	var content = "";
	$.post(
			"/sys/user/queryUserIdByUsername",
			{companyName:par.value},
			function(data){
				if(data.length>0){
					for(var i=0;i<data.length;i++){
						content+="<div id="+data[i].userId+" style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i].name+"</div>";
					}
					$("#showDiv").html(content);
					$("#showDiv").css("display","block");
				}	
			},
			"json"
	);	
}
//========下面为自动生成的代码================
$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ft/ftClient/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}