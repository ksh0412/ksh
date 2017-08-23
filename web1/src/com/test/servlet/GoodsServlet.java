package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.GoodsService;

public class GoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";

		doProcess(response, resultStr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		Gson g = new Gson();
		Goods goods = g.fromJson(request.getReader(), Goods.class);
		System.out.println(goods);
		String command = goods.getCommand();
		if(command.equals("list")){
			int totalCnt = gs.getTotalCount(goods);
			Page page = goods.getPage();
			page.setTotalCnt(totalCnt);
			List<Goods> list = gs.selectGoodsList(goods);
			List<Vendor> vendorList = gs.selectVendorList();
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("list", list);
			resultMap.put("search", goods);
			resultMap.put("vendorList", vendorList);
			String jsonStr = g.toJson(resultMap);
			System.out.println(jsonStr);
			doProcess(response, jsonStr);
		}else if(command.equals("view")){
			Goods resultGoods = gs.selectGoods(goods);
			Page page = goods.getPage();
			HashMap resultMap = new HashMap();
			resultMap.put("resultGoods", resultGoods);
			resultMap.put("page", page);
			resultMap.put("url", "/goods/goods_view.jsp");
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("delete")){
			int result = gs.deleteGoods(goods);
			Page page = goods.getPage();
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("msg", "삭제완료");
			resultMap.put("url", "/goods/goods_list.jsp");
			if(result!=1){
				resultMap.put("msg", "삭제실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("update")){
			int result = gs.updateGoods(goods);
			Page page = goods.getPage();
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("result", result);
			resultMap.put("msg", "수정완료");
			resultMap.put("url", "/goods/goods_view.jsp");
			if(result!=1){
				resultMap.put("msg", "삭제실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("insert")){
			int result = gs.insertGoods(goods);
			Page page = goods.getPage();
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("result", result);
			resultMap.put("msg", "등록완료");
			resultMap.put("url", "/goods/goods_list.jsp");
			if(result!=1){
				resultMap.put("msg", "등록실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("vendorlist")){
			List<Vendor> vendorList = gs.selectVendorList();
			Page page = goods.getPage();
			HashMap resultMap = new HashMap();
			resultMap.put("page", page);
			resultMap.put("vendorList", vendorList);
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}
//		Type listType = new TypeToken<ArrayList<Goods>>(){}.getType();
//		
//		List<Goods> goodsList = g.fromJson(request.getReader(), listType);
//		for(Goods gs : goodsList){
//			System.out.println(gs);
//		}
//		
//		String jsonStr = g.toJson(goodsList);
//		doProcess(response, jsonStr);
//		HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
//		Set<String> keys = hm.keySet();
//		for(String key : keys){
//			System.out.println(key + "=" + hm.get(key));
//		}
//		Goods gs = g.fromJson(request.getReader(), Goods.class);
//		System.out.println(gs.toString());
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}