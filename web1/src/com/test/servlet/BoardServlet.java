package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.BoardService;

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");

		String name1 = req.getParameter("name");
		String pwd1 = req.getParameter("pass");
		String a = req.getParameter("a");
		System.out.println(name1 + pwd1 + a);

		String command = req.getParameter("command");

		BoardService bs = new BoardService();
		if (command.equals("INSERT")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			HashMap hm = new HashMap();
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);

			if (bs.insertBoard(hm)) {
				doProcess(resq, "저장 잘 됬꾸만!!!!");
			} else {
				doProcess(resq, "값 똑바로 입력 안하냐잉~");
			}
		} else if (command.equals("DELETE")) {
			String writer = req.getParameter("writer");
			System.out.println("삭제할 번호 : " + writer);
			if (bs.deleteUser(writer)) {
				doProcess(resq, writer + "삭제");
			} else {
				doProcess(resq, "안돼");
			}
		} else if (command.equals("UPDATE")) {
			String writer = req.getParameter("writer");
			System.out.println("업데이트할 번호 : " + writer);

			String name = req.getParameter("title");
			String class_num = req.getParameter("content");
			String age = req.getParameter("writer");

			if (bs.updateUser(writer)) {
				doProcess(resq, "업뎃");
			} else {
				doProcess(resq, "없뎃");
			}
		} else if (command.equals("SELECT")) {
			String num = req.getParameter("num");
			if (bs.selectUser(num)) {
				doProcess(resq, "셀렉트");
			} else {
				doProcess(resq, "캔셀렉");
			}
		}
	}

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}