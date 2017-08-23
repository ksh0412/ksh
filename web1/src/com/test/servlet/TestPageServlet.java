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
import com.test.dto.TestPage;
import com.test.service.TestPageService;

public class TestPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TestPageService ts = new TestPageService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";

		doProcess(response, resultStr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson g = new Gson();
		HashMap resultMap = new HashMap();
		TestPage tp = g.fromJson(request.getReader(), TestPage.class);
		if(tp.getCommand().equals("list")){
			int counting = ts.countRow();
			tp.setTotalCnt(counting);
			List<TestPage> resultTsList = ts.selectTestPageList(tp);
			resultMap.put("testList", resultTsList);
			resultMap.put("page", tp);
			System.out.println(resultTsList);
			String jsonStr = g.toJson(resultMap);
			System.out.println(jsonStr);
			doProcess(response, jsonStr);
		}
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}