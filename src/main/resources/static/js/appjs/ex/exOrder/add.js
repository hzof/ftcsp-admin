/**
 * 货代是否显示绑定的方法
 */
function displayFreightForwarder(obj){
	if(obj.value==0)
		//设置为不显示
		$("#displayFreightForwarder").css("display","none");
	else
		//设置为显示
		$("#displayFreightForwarder").css("display","block");
}
/**
 * 结汇单证是否显示按钮绑定的方法
 */
function displayIsSettleExg(obj){
	if(obj.value==0){
		obj.value=1;
		//设置结汇单证为显示
		$("#displayIsSettleExg").css("display","block");
	}else{
		obj.value=0;
		//设置结汇单证为不显示
		$("#displayIsSettleExg").css("display","none");
	}
}
//==========搜索框异步搜索开始行===========
/**
 * 候选项绑定的鼠标离焦事件
 * @param obj 触发该方法的元素
 */
function overFn(obj){
	//设置候选项为不加亮显示
	$(obj).css("background","#DBEAF9");
}
/**
 * 候选项绑定的鼠标聚焦事件
 * @param obj 触发该方法的元素
 */
function outFn(obj){
	//设置候选项为加亮显示
	$(obj).css("background","#fff");
}
/**
 * 候选项绑定的单击事件
 * @param obj
 */
function clickFn(obj){
	//控制搜索输入框的内容改变为点击选项的内容
	$("#ftClientId").val(searchData[obj].companyName);
	//点击之后将搜索列表隐藏
	$("#showDiv").css("display","none");
	//修改表单隐藏域的值
	$("#ftClientId1").val(searchData[obj].ftClientId);
	//设置手机
	$("#phone").val(searchData[obj].mobilePhone);
	//设置联系人
	$("#contact_1").val(searchData[obj].name);
	//设置办公室电话
	$("#officePhone").val(searchData[obj].companyPhone);
	$.post(
		"/ft/ftClient/queryExitInvoiceNo",
		{ftClientId:searchData[obj].ftClientId},
		function(data){
			$("#exportInvoiceNo").val(data.exitInvoiceNo);
		},
		"json"
	);
}
/**
 * 搜索框绑定的键盘抬起事件
 * @param par 输入框元素
 */
function searchWord(par){
	//改变域中的值后首先将候选项下拉框设置为隐藏
	$("#showDiv").css("display","none");
	var content = "";
	//将隐藏域中的值置为空
	$("#ftClientId1").val(content);
	//如果传入的是空字符串，则结束方法
	if(par.value==""){
		return ;
	}
	$.post(
		"/ft/ftClientCompany/queryIdByNamelist",
		{companyName:par.value},
		function(data){
			if(data.length>0){
				searchData=data;//将数据赋值给成员变量
				for(var i=0;i<data.length;i++){
					//id为下标，val为companyName
					content+="<div id="+i+" style='padding:5px;cursor:pointer' onclick='clickFn(this.id)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i].companyName+"</div>";
				}
				//将生成的候选项写入到隐藏的候选项下拉框中
				$("#showDiv").html(content);
				//设置候选项下拉框为显示
				$("#showDiv").css("display","block");
			}
		},
		"json"
	);
}
//=====下方为自动生成的代码====
$(function () {
	laydate({
		elem : '#birth'
	});
});
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