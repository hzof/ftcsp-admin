//=======该文件存放exOrder公共的js函数=======

//===Jump to the submission of the order page ==
//======跳转到提交订单页面的公共函数==============
function submissionConfirmation(par) {
	layer.open({
		type : 2,
		title : '提交订单信息确认',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : "/ex/exOrder/submissionConfirmation/"+par // iframe的url
	});
}
//=========提交订单页面上传至服务器保存数据的公共函数==========
function submissionConfirmation(par){
	layer.confirm('您确定数据无误，提交至服务器提交吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			cache : true,
			type : "POST",
			url : "/ex/exOrder/update",
			data : {exOrderId:par.id,auditStatus:1},// 你的formid
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
	})
}