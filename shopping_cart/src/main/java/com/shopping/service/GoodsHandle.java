package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.model.Goods;

public class GoodsHandle {
	private List list;

	public void addGoods(HttpServletRequest request) {
		String id = request.getParameter("id");
		String goodsName = request.getParameter("goodsname");
		double price = Double.parseDouble(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		Goods goods = new Goods();
		goods.setId(id);
		goods.setGoodsName(goodsName);
		goods.setPrice(price);
		goods.setCount(count);
		list = (List)request.getSession().getAttribute("list");
		if(list == null){
			list = new ArrayList();
		}
		list.add(goods);
		request.getSession().setAttribute("list", list);
	}

	public void deleteGoods(HttpServletRequest request,String id){
		list = (List)request.getSession().getAttribute("list");
		if(list == null){
			throw new RuntimeException("购物车列表丢失，请重新选择购物，由此带来的不便请谅解！");
		}
		for(Object obj:list){
			Goods goods = (Goods) obj;
			if(id.equals(goods.getId())){
				list.remove(obj);
			}
		}
	}
}
