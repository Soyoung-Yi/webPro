<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); 
		String pageNum = request.getParameter("pageNum");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%-- <%=dto %> --%>
<%
	dto.setIp(request.getRemoteAddr());
	BoardDao dao = BoardDao.getInstance();
	int result;
	if(dto.getNum()==0){ 
		result = dao.insertBoard(dto);// 원글쓰기
	}else{
		result = dao.reply(dto); // 답변글 쓰기
	}
	if(result == BoardDao.SUCCESS){
%>
		<script>
			alert('글쓰기 완료');
			location.href = 'list.jsp?pageNum=<%=pageNum%>';
		</script>
<%}else{%>
		<script>
			alert('글쓰기 실패');
			history.back();
		</script>
<%}%>
</body>
</html>

















