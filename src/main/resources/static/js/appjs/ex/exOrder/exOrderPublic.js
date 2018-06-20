//=======该文件存放exOrder公共的js函数=======

//===Jump to the submission of the order page ==
//======跳转到提交订单页面的公共函数==============
function submissionConfirmation(par) {
	var perLayer=layer.open({
		type : 2,
		title : '提交订单信息确认',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : "/ex/exOrder/submissionConfirmation/"+par // iframe的url
	});
	layer.full(perLayer);
}
//=========提交订单页面上传至服务器保存数据的公共函数==========
function submissionConfirmationSave(par){
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
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
//======出口订单模块查看订单详情的公共函数========
function details(par){
	var perLayer=layer.open({
		type : 2,
		title : '查看订单详情',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/ex/exOrder/details/'+par// iframe的url
	});
    layer.full(perLayer);
}
//=====公共系列之加载订单的商品信息=====

$(function() {
	load2();
});

function load2() {
	$('#exampleTable25')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : "/ex/exOrderCommodity/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [{
									field : 'exOrderId', 
									title : '出口订单主键' 
								},{
									field : 'manufacturer', 
									title : '生产厂家' 
								},{
									field : 'manufacturerCode', 
									title : '生产厂家编号' 
								},
																{
									field : 'factoryArticleNo', 
									title : '公司货号' 
								},
																{
									field : 'customsCode', 
									title : '海关编码' 
								},
																{
									field : 'taxRefundRate', 
									title : '退税率%' 
								},
																{
									field : 'shipMarkInfo', 
									title : '唛头信息' 
								},
																{
									field : 'chineseName', 
									title : '中文品名' 
								},
																{
									field : 'englishName', 
									title : '英文品名' 
								},
																{
									field : 'declareElement', 
									title : '申报要素' 
								},
																{
									field : 'pkgs', 
									title : '包装数量' 
								},
																{
									field : 'pkgsUnit', 
									title : '包装数量单位' 
								},
																{
									field : 'totalQuantity', 
									title : '总数量' 
								},
																{
									field : 'totalQuantityUnit', 
									title : '总数量单位' 
								},
																{
									field : 'packSizeLength', 
									title : '包装尺寸-长mm' 
								},
																{
									field : 'packSizeWidth', 
									title : '包装尺寸-宽mm' 
								},
																{
									field : 'packSizeHeight', 
									title : '包装尺寸-高mm' 
								},
																{
									field : 'totalVolume', 
									title : '总体积m*m*m' 
								},
																{
									field : 'unitRoughWeight', 
									title : '单位毛重kg' 
								},
																{
									field : 'totalRoughWeight', 
									title : '总毛重kg' 
								},
																{
									field : 'unitNetWeight', 
									title : '单位净重kg' 
								},
																{
									field : 'totalNetWeight', 
									title : '总净重kg' 
								},
																{
									field : 'purchaseUnitPrice', 
									title : '采购单价' 
								},
																{
									field : 'purchaseTotalPrice', 
									title : '采购总价' 
								},
																{
									field : 'exportUnitPrice', 
									title : '出口单价' 
								},
																{
									field : 'exportTotalPrice', 
									title : '出口总价' 
								},
																{
									field : 'gmtCreate', 
									title : '创建时间' 
								},
																{
									field : 'gmtModified', 
									title : '修改时间' 
								}]
					});
}
function reLoad2() {
	$('#exampleTable25').bootstrapTable('refresh');
}