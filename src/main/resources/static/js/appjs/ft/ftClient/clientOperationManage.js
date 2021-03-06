$(function() {
	load();
});
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : "/ft/ftClient/list", // 服务器数据的加载地址
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
						columns : [{checkbox : true},
							    {
                                    visible : false,
									field : 'ftClientId', 
									title : '主键' 
								},{
									visible : false,
									field : 'registerType',
									title : '公司类型'
								},{
									field : 'companyName', 
									title : '公司名称' 
								},{
                                    visible : false,
									field : 'province', 
									title : '省' 
								},{
                                    visible : false,
									field : 'city', 
									title : '市' 
								},{
                                    visible : false,
									field : 'detailedAddress', 
									title : '详细地址' 
								},{
									field : 'Name', 
									title : '姓名' ,
								},{
									field : 'sex', 
									title : '性别'
									formatter : function(value, row, index) {
										return {"0":"男","1":"女"}[value];
									}
								},{
									field : 'telephone', 
									title : '联系电话' 
								},{
									field : 'phone', 
									title : '手机' 
								},{
									field : 'auditRemark', 
									title : '审核备注' 
								},{
                                    visible : false,
									field : 'marketerId', 
									title : '营销人员ID' 
								},{
									field : 'auditStatus', 
									title : '审核状态'
								},{
									field : 'clientNo', 
									title : '客户代码' 
								},{
									field : 'serviceContractNo', 
									title : '服务合同号' 
								},{
                                    visible : false,
									field : 'servicerId', 
									title : '客服人员ID' 
								},{
                                    visible : false,
									field : 'operatorId', 
									title : '操作人员ID' 
								},{
									field : 'clientType', 
									title : '客户类型',
									formatter : function(value, row, index) {
										return {"0":"有效客户","1":"暂停出货客户","2":"未出货客户"}[value];
									}
								},{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.ftClientId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.ftClientId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.ftClientId
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