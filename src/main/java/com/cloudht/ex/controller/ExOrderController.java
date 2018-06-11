package com.cloudht.ex.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudht.ex.domain.OrderHeaderDO;

@Controller
public class ExOrderController {
	/**
	 * 代理下单的出口订单保存
	 */
	@RequestMapping(value="/ex/orderInfo/proxyExOrderSave",method = RequestMethod.POST)
	@RequiresPermissions("ex:orderInfo:add")
	public void proxyExOrderSave(OrderHeaderDO orderHeaderDO) {
		System.out.println(orderHeaderDO.getExportContractNo());
	}
}
