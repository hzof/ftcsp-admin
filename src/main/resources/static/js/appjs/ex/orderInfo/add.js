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
//===========上一段结束,我是搜索功能结束的分割线=========
/**
 * ready：在文档加载后的激活函数
 * @returns
 */
$().ready(function() {
	validateRule();//调用表单校验,注销此行无法执行提交
});

$.validator.setDefaults({
	submitHandler : function() {//保存处理函数
		save();
	}
});
function save() {
	var formdata=$('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ex/orderInfo/proxyExOrderSave",
		data : formdata,// 你的formid
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
			ftClientId : {
				required : true
			}
		},
		messages : {
			ftClientId : {
				required : icon + "请输入姓名"
			}
		}
	})
}

var prefix = "/ex/orderCommodity";


function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
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
