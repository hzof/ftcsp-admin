var prefix = "/ex/orderInfo";
var IS_SETTLED={'0':'未结算','1':'已结算'};
var AUDIT_STATUS={'0':'未提交','1':'待受理','2':'待专家受理','3':'拒绝受理','4':'已撤销','5':'撤回修改','6':'已受理'};

$(function() {
	load();
});

/**
 * 代理下单页面提交订单的函数
 * @returns
 */
function submitOrder() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if(rows.length==0||rows.length>1){
		layer.msg("未选择行或者选择超过一行");
		return;
	}
	var id=rows[0].exOrderHeaderId;//获取选中的id
	var perLayer=layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/submitOrder/' + id // iframe的url
	});
    layer.full(perLayer);
}
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
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
								offset:params.offset,
								auditStatus:"0"
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
						columns : [
								{
									checkbox : true
								},{
									field : 'ftClientId', 
									title : '委托方' 
								},{
									field : 'exportContractNo', 
									title : '外销合同号' 
								},{
									field : 'exportInvoiceNo', 
									title : '出口发票号' 
								},{
									field : 'deliveryDate', 
									title : '交货日期' 
								},{
									field : 'gmtCreate', 
									title : '创建时间' 
								},{
									field : 'consignee', 
									title : '收货人' 
								},{
									field : 'contact', 
									title : '联系人' 
								},{
									field : 'officePhone', 
									title : '办公室电话' 
								},{
									field : 'phone', 
									title : '手机' 
								},{
									field : 'remark', 
									title : '备注' 
								},{
									field : 'isSettled', 
									title : '是否已结算',
									formatter : function(value, row, index) {
										return IS_SETTLED[value];
									}
								},{
									field : 'auditStatus', 
									title : '审核状态',
									formatter : function(value, row, index) {
										return AUDIT_STATUS[value];
									}
								},{
									visible : false,
									field : 'exOrderHeaderId', 
									title : 'ID' 
								},{
									visible : false,
									field : 'isDeleted', 
									title : '是否已删除'
								},{
									visible : false,
									field : 'gmtModified', 
									title : '修改时间' 
								},{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.exOrderHeaderId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.exOrderHeaderId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.exOrderHeaderId
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	var perLayer=layer.open({
		type : 2,
		title : '添加-货物出运明细',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/ex/orderInfo/add' // iframe的url
	});
    layer.full(perLayer);
}
//==========给待受理的订单添加商品信息==============
function addCommodity() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	alert(rows[0].exOrderHeaderId);
	if (rows.length == 0||rows.length>1) {
		layer.msg("未选择数据或者超过一行");
		return;
	}
	var perLayer=layer.open({
		type : 2,
		title : '添加-订单商品',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/commodity/' +rows[0].exOrderHeaderId // iframe的url /ex/orderInfo/commodity/exOrderHeaderId
	});
    layer.full(perLayer);
}
function edit(id) {
    var perLayer=layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
    layer.full(perLayer);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/ex/orderHeader/remove",
			type : "post",
			data : {
				'exOrderHeaderId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['exOrderHeaderId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}