<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.kimile.el.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- 模拟域中的数据 -->
  <%
   		//存储字符串
   		request.setAttribute("girlfriend", "lebaby");
   		User user=new User();
   		user.setId(1);
   		user.setName("cwy");
   		user.setPassword("123");
   		session.setAttribute("user",user);
   		//存出一个集合
   		List<User> list=new ArrayList<User>();
   		User user1=new User();
   		user1.setId(1);
   		user1.setName("chm");
   		user1.setPassword("123");
   		list.add(user1);
   		User user2=new User();
   		user2.setId(2);
   		user2.setName("clovec");
   		user2.setPassword("123");
   		list.add(user2);
   		application.setAttribute("list",list);
   %>
   <%=request.getAttribute("girlfriend") %>
   <%User sessionUser=(User)session.getAttribute("user"); 
     out.write(sessionUser.getName());
   %>
   
    ${requestScope.girlfriend}
  	${sessionScope.user.name}
 	${applicationScope.list[1].name} 
 
  	
   
  </body>
</html>
