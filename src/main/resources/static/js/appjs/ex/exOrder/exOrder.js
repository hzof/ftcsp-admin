
var prefix = "/ex/exOrder"
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
								offset:params.offset,
								auditStatus:0
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
									field : 'companyName', 
									title : '委托方公司名称' 
								},{
									visible : false,
									field : 'ftClientId', 
									title : '委托方' 
								},{
									field : 'exportContractNo', 
									title : '外销合同号' 
								},{
									field : 'exportInvoiceNo', 
									title : '出口发票号' 
								},{
									field : 'shipmentDeadline', 
									title : '装运期限' 
								},{
									field : 'gmtCreate', 
									title : '创建时间' 
								},{
									field : 'auditStatus', 
									title : '审核状态',
									formatter : function(value, row, index) {
										var AUDIT_STATUS={'0':'未提交','1':'待受理','2':'待专家受理','3':'拒绝受理','4':'已撤销','5':'撤回修改','6':'已受理'};
										return AUDIT_STATUS[value];
									}
								},{
									field : 'servicerName', 
									title : '客服人员名字' 
								},
																/*{
									field : 'exOrderId', 
									title : '主键' 
								},{
									field : 'deliveryDate', 
									title : '交货日期' 
								},
																{
									field : 'orderContact', 
									title : '联系人' 
								},
																{
									field : 'officePhone', 
									title : '办公室电话' 
								},
																{
									field : 'orderPhone', 
									title : '手机' 
								},
																{
									field : 'consignee', 
									title : '收货人' 
								},
																{
									field : 'orderRemark', 
									title : '订单备注' 
								},
																{
									field : 'isSettled', 
									title : '是否已结算：0-未结算状态，1-已结算状态' 
								},
																
																{
									field : 'processTime', 
									title : '受理时间' 
								},
																{
									field : 'tradeCountry', 
									title : '贸易国别' 
								},
																{
									field : 'tradeWay', 
									title : '贸易方式' 
								},
																{
									field : 'priceTerms', 
									title : '价格条款' 
								},
																{
									field : 'freight', 
									title : '运费' 
								},
																{
									field : 'destinationCountry', 
									title : '运抵国' 
								},
																{
									field : 'currency', 
									title : '币别' 
								},
																
																{
									field : 'transportMode', 
									title : '运输方式' 
								},
																{
									field : 'departurePort', 
									title : '起运港' 
								},
																{
									field : 'transitPort', 
									title : '转运港' 
								},
																{
									field : 'destinationPort', 
									title : '目的港' 
								},
																{
									field : 'territorySourcePlace', 
									title : '境内货源地' 
								},
																{
									field : 'manufactureFactory', 
									title : '生产厂家' 
								},
																{
									field : 'factoryContact', 
									title : '厂家联系人' 
								},
																{
									field : 'factoryPhone', 
									title : '厂家联系电话' 
								},
																{
									field : 'settlementWay', 
									title : '结汇方式' 
								},
																{
									field : 'creditNo', 
									title : '信用证号码' 
								},
																{
									field : 'isSettleExg', 
									title : '是否有结汇单证：0-否，1-是' 
								},
																{
									field : 'billLadingNum', 
									title : '提单' 
								},
																{
									field : 'invoiceNum', 
									title : '发票' 
								},
																{
									field : 'packingListNum', 
									title : '装箱单' 
								},
																{
									field : 'draftNum', 
									title : '汇票' 
								},
																{
									field : 'qualityCertificateNum', 
									title : '品质证' 
								},
																{
									field : 'weightListNum', 
									title : '重量单' 
								},
																{
									field : 'certificateOriginNum', 
									title : '产地证' 
								},
																{
									field : 'certificateQuarantineNum', 
									title : '检疫证' 
								},
																{
									field : 'insurancePolicyNum', 
									title : '保险单' 
								},
																{
									field : 'others', 
									title : '其它' 
								},
																{
									field : 'credentials', 
									title : '已确认证件（多选“，”分隔）：00-商检，01-订舱，02-报关，03-提单确认，04-结汇单证，05-产地证' 
								},
																{
									field : 'operationType', 
									title : '操作类型：0-非全套操作，1-全套操作，2-客户制单' 
								},
																{
									field : 'serviceRemark', 
									title : '客服服务记录/备注' 
								},
																{
									field : 'linkName', 
									title : '环节名称' 
								},
																{
									field : 'linkStatus', 
									title : '环节状态' 
								},
																{
									field : 'finishDate', 
									title : '完成时间' 
								},
																{
									field : 'isShipOrder', 
									title : '已制作托单：0-否，1-是' 
								},
																{
									field : 'isCustomsInspection', 
									title : '已制作报检：0-否，1-是' 
								},
																{
									field : 'isCustomsDeclaration', 
									title : '已制作报关：0-否，1-是' 
								},
																{
									field : 'isOriginCertificate', 
									title : '已制作产地证：0-否，1-是' 
								},
																{
									field : 'isNegotiation', 
									title : '已制作议付单证：0-否，1-是' 
								},
																{
									field : 'isCollection', 
									title : '已制作托收：0-否，1-是' 
								},
																{
									field : 'isOrderLink', 
									title : '已制作订单环节：0-否，1-是' 
								},
																{
									field : 'specifyShipCompany', 
									title : '指定船公司' 
								},
																{
									field : 'appointForwarderType', 
									title : '指定货代类型:0-平台指定，1-自己指定' 
								},
																{
									field : 'forwarderCompanyName', 
									title : '货代公司' 
								},
																{
									field : 'forwarderContact', 
									title : '货代联系人' 
								},
																{
									field : 'forwarderPhone', 
									title : '货代手机' 
								},
																{
									field : 'forwarderFax', 
									title : '货代传真' 
								},{
									field : 'forwarderAddress', 
									title : '货代公司地址' 
								},{
									field : 'customsBrokerName', 
									title : '报关行名称' 
								},{
									field : 'customsBrokerCode', 
									title : '报关行代码' 
								},{
									field : 'entryNoticeFileId', 
									title : '进仓通知书文件ID' 
								},{
									field : 'encasementType', 
									title : '装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？' 
								},{
									field : 'insuranceFinanceService', 
									title : '保险或融资服务(多选“,”分隔):00-信用保险,01-退税融资,02-LC融资,03-其他融资' 
								},{
									field : 'pkgs', 
									title : '总包装数' 
								},{
									field : 'totalVolume', 
									title : '总体积' 
								},{
									field : 'totalRoughWeight', 
									title : '总毛重' 
								},{
									field : 'totalNetWeight', 
									title : '总净重' 
								},{
									field : 'totalAmount', 
									title : '总金额' 
								},{
									field : 'foreignExgCost', 
									title : '换汇成本' 
								},{
									field : 'createBy', 
									title : '创建人ID' 
								},{
									field : 'servicerId', 
									title : '客服人员id' 
								},{
									field : 'isDeleted', 
									title : '是否已删除：0-否，1-是' 
								},*/
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑订单" onclick="edit(\''
												+ row.exOrderId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除订单"  mce_href="#" onclick="remove(\''
												+ row.exOrderId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="添加商品"  mce_href="#" onclick="addCommodity(\''
												+ row.exOrderId
												+ '\')"><i class="fa fa-plus"></i></a> ';
										var g = '<a class="btn btn-success btn-sm" href="#" title="提交订单"  mce_href="#" onclick="resetPwd(\''
											+ row.exOrderId
											+ '\')"><i class="fa fa-key"></i></a> ';
										var h = '<a class="btn btn-success btn-sm" href="#" title="复制订单"  mce_href="#" onclick="resetPwd(\''
											+ row.exOrderId
											+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d + f + g + h ;
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
				'exOrderId' : id
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
	alert(id);
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
			ids[i] = row['exOrderId'];
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
//出口订单添加商品按钮绑定的单击事件
function addCommodity(id){
	layer.open({
		type : 2,
		title : '为出口订单添加商品',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/addCommodity/' + id // iframe的url
	});
}