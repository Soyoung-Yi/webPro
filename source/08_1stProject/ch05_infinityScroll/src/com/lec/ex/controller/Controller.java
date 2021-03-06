package com.lec.ex.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.AppendService;
import com.lec.ex.service.ListService;
import com.lec.ex.service.ModifyService;
import com.lec.ex.service.ModifyViewService;
import com.lec.ex.service.Service;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri     = request.getRequestURI();
		String conPath = request.getContextPath();
		String com     = uri.substring(conPath.length()); //들어온 요청
		String viewPage = null;
		Service service = null;
		if(com.equals("/list_ver1.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "onlyScroll_ver1/list.jsp";
		}else if(com.equals("/append_ver1.do")) {
			service = new AppendService();
			service.execute(request, response);
			viewPage = "onlyScroll_ver1/append.jsp";
		}else if(com.equals("/list_ver2.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "scrollAndModify_ver2/list.jsp";
		}else if(com.equals("/append_ver2.do")) {
			service = new AppendService();
			service.execute(request, response);
			viewPage = "scrollAndModify_ver2/append.jsp";
		}else if(com.equals("/modifyView.do")) {
			service = new ModifyViewService();
			service.execute(request, response);
			viewPage = "scrollAndModify_ver2/modify.jsp";
		}else if(com.equals("/modify.do")) {
			service = new ModifyService();
			service.execute(request, response);
			viewPage = "scrollAndModify_ver2/dummy.jsp";
		}else if(com.equals("/arraylistToArray.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "arraylistToArray.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}