//==========搜索框异步搜索开始行===========
function overFn(obj){
	$(obj).css("background","#DBEAF9");
}
function outFn(obj){
	$(obj).css("background","#fff");
}
function clickFn(obj){
	$("#ftClientId").val($(obj).html());
	$("#showDiv").css("display","none");
	$("#ftClientId1").val(obj.id);
}
function searchWord(par){
	if(par.value==""){
		return ;
	}
	var content = "";
	$.post(
			"/ft/ftClientCompany/queryIdByNamelist",
			{companyName:par.value},
			function(data){
				if(data.length>0){
					for(var i=0;i<data.length;i++){
						content+="<div id="+data[i].ftClientId+" style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i].companyName+"</div>";
					}
					$("#showDiv").html(content);
					$("#showDiv").css("display","block");
				}	
			},
			"json"
	);	
}
//=====下方为自动生成的代码====
$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ex/exOrder/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function() {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				//上传图片
				uploadFile(data.exOrderId,data.ftClientId)
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
function uploadFile(refKey,ftClientId) {
	var files = $("#file")[0].files;
	for(var i=0;i<files.length;i++){
		var formData = new FormData();
		formData.append("refKey",refKey);
		formData.append("ftClientId",ftClientId);
		formData.append("file",files[i]);
		$.ajax({
			url : "/ex/exOrder/uploadFile",
			type : "POST",
			cache : false,
			data : formData,// 你的formid
			async : false,
			timeout :5000,
			processData: false,
			contentType: false,
			xhrFields: {
				withCredentials: true
			},
	
			error : function() {
				parent.layer.alert("Connection error");
			},
			success : function(data) {
				if (data.code == 0) {
					parent.layer.msg("操作成功");
					
				} else {
					parent.layer.alert(data.msg)
				}
				
			}
		});
		parent.reLoad();
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		parent.layer.close(index);
	}
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
				required : icon + "请输入姓名"
			}
		}
	})
}