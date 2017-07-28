//package com.test.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.test.service.BoardService;
//
//public class BoardServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8");
//
//		String name1 = req.getParameter("name");
//		String pwd1 = req.getParameter("pass");
//		String a = req.getParameter("a");
//		System.out.println(name1 + pwd1 + a);
//
//		String command = req.getParameter("command");
//
//		BoardService bs = new BoardService();
//		if (command.equals("INSERT")) {
//			String title = req.getParameter("title");
//			String content = req.getParameter("content");
//			String writer = req.getParameter("writer");
//
//			HashMap hm = new HashMap();
//			hm.put("title", title);
//			hm.put("content", content);
//			hm.put("writer", writer);
//
//			if (bs.insertBoard(hm)) {
//				doProcess(resq, "저장 잘 됬꾸만!!!!");
//			} else {
//				doProcess(resq, "값 똑바로 입력 안하냐잉~");
//			}
//		} else if (command.equals("DELETE")) {
//			String writer = req.getParameter("writer");
//			System.out.println("삭제할 번호 : " + writer);
//			if (bs.deleteUser(writer)) {
//				doProcess(resq, writer + "삭제");
//			} else {
//				doProcess(resq, "안돼");
//			}
//		} else if (command.equals("UPDATE")) {
//			String writer = req.getParameter("writer");
//			System.out.println("업데이트할 번호 : " + writer);
//
//			String name = req.getParameter("title");
//			String class_num = req.getParameter("content");
//			String age = req.getParameter("writer");
//
//			if (bs.updateUser(writer)) {
//				doProcess(resq, "업뎃");
//			} else {
//				doProcess(resq, "없뎃");
//			}
//		} else if (command.equals("SELECT")) {
//			HashMap hm = new HashMap();
//			String num = req.getParameter("num");
//			if (num != null && !num.equals("")) {
//				hm.put("num", num);
//			}
//
//			List<HashMap> boardList = bs.selectUser(hm);
//			String result = "<form action ='/test_web/sign.user>";
//			result += "번호 : <input type='text' name='name' id='name'/> <input type='submit' value='검색'/>";
//			result += "<input type='hidden' name='command' value='SELECT'/>";
//			result += "</form>";
//			result += "<table border='1'>";
//			result += "<tr>";
//			result += "<td>번호</td>";
//			result += "<td>타이틀</td>";
//			result += "<td>내용</td>";
//			result += "<td>작성자</td>";
//			result += "<td>날짜</td>";
//			result += "<td>삭제버튼</td>";
//			result += "</tr>";
//			for (Map m : boardList) {
//				result += "<tr align='center'>";
//				result += "<td>" + m.get("num") + "</td>";
//				result += "<td>" + m.get("title") + "</td>";
//				result += "<td>" + m.get("content") + "</td>";
//				result += "<td>" + m.get("writer") + "</td>";
//				result += "<td>" + m.get("reg_date") + "</td>";
//				result += "<td><input type='button' value='삭제' onclick='deleteUser(" + m.get("num") + ")'/></td>";
//				result += "</tr>";
//			}
//			result += "</table>";
//			doProcess(resq, result);
//		}
//	}
//
//	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {
//
//	}
//
//	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
//		resq.setContentType("text/html; charset = UTF-8");
//		PrintWriter out = resq.getWriter();
//		out.print(writeStr);
//	}
//}