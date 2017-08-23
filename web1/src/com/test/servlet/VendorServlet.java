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
import com.test.dto.Vendor;

import implement.VendorServiceImpl;

public class VendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorServiceImpl vs = new VendorServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";

		doProcess(response, resultStr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		Gson g = new Gson();
		Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
		System.out.println(vendor);
		String command = vendor.getCommand();
		if(command.equals("list")){
			List<Vendor> vendorList = vs.selectVendorList(vendor);
			int number = vs.writeNumber();
			HashMap resultMap = new HashMap();
			resultMap.put("vendorList", vendorList);
			resultMap.put("number", number);
			String jsonStr = g.toJson(resultMap);
			System.out.println(jsonStr);
			doProcess(response, jsonStr);
		}else if(command.equals("view")){
			Vendor resultVendor = vs.selectVendor(vendor);
			HashMap resultMap = new HashMap();
			resultMap.put("resultVendor", resultVendor);
			resultMap.put("url", "/vendor/vendor_view.jsp");
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("delete")){
			int result = vs.deleteVendor(vendor);
			HashMap resultMap = new HashMap();
			resultMap.put("result", result);
			resultMap.put("msg", "삭제완료");
			resultMap.put("url", "/vendor/vendor_list.jsp");
			if(result!=1){
				resultMap.put("msg", "삭제실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("update")){
			int result = vs.updateVendor(vendor);
			HashMap resultMap = new HashMap();
			resultMap.put("result", result);
			resultMap.put("msg", "수정완료");
			resultMap.put("url", "/vendor/vendor_view.jsp");
			if(result!=1){
				resultMap.put("msg", "수정실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}else if(command.equals("insert")){
			int result = vs.insertVendor(vendor);
			HashMap resultMap = new HashMap();
			resultMap.put("result", result);
			resultMap.put("msg", "등록완료");
			resultMap.put("url", "/vendor/vendor_list.jsp");
			if(result!=1){
				resultMap.put("msg", "등록실패");
				resultMap.put("url", "");
			}
			String jsonStr = g.toJson(resultMap);
			doProcess(response, jsonStr);
		}//else if(command.equals("vendorlist")){
//			List<Vendor> vendorList = vs.selectVendorList();
//			Page page = goods.getPage();
//			HashMap resultMap = new HashMap();
//			resultMap.put("page", page);
//			resultMap.put("vendorList", vendorList);
//			String jsonStr = g.toJson(resultMap);
//			doProcess(response, jsonStr);
//		}
////		Type listType = new TypeToken<ArrayList<Goods>>(){}.getType();
////		
////		List<Goods> goodsList = g.fromJson(request.getReader(), listType);
////		for(Goods gs : goodsList){
////			System.out.println(gs);
////		}
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