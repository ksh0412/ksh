package com.test.servlet.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		doProcess(response, id);
		doProcess(response, pwd);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		String id = (String)hm.get("id");
		String pwd = (String)hm.get("pwd");
		HashMap hm2 = new HashMap();
		hm2.put("id", id);
		hm2.put("pwd", pwd);
		String result = g.toJson(hm2);
		System.out.println(hm);
		doProcess(response, result);
	}
}
