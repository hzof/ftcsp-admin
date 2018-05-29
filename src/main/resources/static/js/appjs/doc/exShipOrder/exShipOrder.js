
var prefix = "/doc/exShipOrder"
$(function() {
	load();
});

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
						columns : [
								{
									checkbox : true
								},
								{
									field : 'invoiceNo', 
									title : '发票号' 
								},
								{
									field : 'gmtCreate',//此处待修改
									title : '委托方' //委托方是个公司名称
								},
								{
									field : 'departurePort', 
									title : '起运港' 
								},
								{
									field : 'destinationPort', 
									title : '目的港' 
								},
								{
									field : '', //此处待修改
									title : '状态' ,
									formatter : function(value, row, index) {
										var STATE={'0':'未发布','1':'已发布'}
									    return STATE[value];
									}
								},
								{
									field : 'gmtCreate',//此处待修改
									title : '制单人' 
								},
								{
									field : '',//此处待修改
									title : '制单时间' 
								},
								
																/*{
									field : 'exShipOrderId', 
									title : '主键' 
								},
																{
									field : 'shipper', 
									title : '发货人' 
								},
																{
									field : 'consignee', 
									title : '收货人' 
								},
																{
									field : 'notifyParty', 
									title : '通知人' 
								},
																{
									field : 'contractNo', 
									title : '合同号' 
								},
																{
									field : 'isTransship', 
									title : '可否转船：0-否，1-是' 
								},
																{
									field : 'isPartialship', 
									title : '可否分批：0-否，1-是' 
								},
																{
									field : 'shipDate', 
									title : '装船期限' 
								},
																{
									field : 'shipCompanyName', 
									title : '船公司名称' 
								},
																
																{
									field : 'transitPort', 
									title : '转运港' 
								},
																
																{
									field : 'expiryDate', 
									title : '有效期限' 
								},
																{
									field : 'encasementType', 
									title : '装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？' 
								},
																{
									field : 'twentyGpNum', 
									title : '20GP数量'
								},
																{
									field : 'fortyGpNum', 
									title : '40GP数量'
								},
																{
									field : 'fortyHqNum', 
									title : '40HQ数量'
								},
																{
									field : 'freightPayment', 
									title : '运费支付方式：0-预付，1-到付' 
								},
																{
									field : 'contact', 
									title : '联系人' 
								},
																{
									field : 'telephone', 
									title : '电话' 
								},
																{
									field : 'fax', 
									title : '传真' 
								},
																{
									field : 'nosOriginalBsl', 
									title : '正本提单份数' 
								},
																{
									field : 'nosOriginalBslCopy', 
									title : '副本提单份数' 
								},
																{
									field : 'customsDeclaredValue', 
									title : '报关金额' 
								},
																{
									field : 'currency', 
									title : '币别' 
								},
																{
									field : 'announcement', 
									title : '注意事项' 
								},
																
																{
									field : 'gmtModified', 
									title : '修改时间' 
								},*/
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.exShipOrderId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.exShipOrderId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.exShipOrderId
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
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'exShipOrderId' : id
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

function resetPwd(id) {
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
			ids[i] = row['exShipOrderId'];
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