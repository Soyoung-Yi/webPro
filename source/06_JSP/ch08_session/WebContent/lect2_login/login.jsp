<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if(session.getAttribute("name")!=null){
		response.sendRedirect("welcome.jsp");
	}
	String msg = request.getParameter("msg");
%> 
<%if(msg!=null){ %>
		<script>
			alert('<%=msg%>');
		</script>
<%} %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required" autofocus="autofocus"
									value="<%
										String id = (String)session.getAttribute("id");
										if(id!=null){
											out.print(id);
										}
									%>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
		</table>
	</form>
</body>
</html>











