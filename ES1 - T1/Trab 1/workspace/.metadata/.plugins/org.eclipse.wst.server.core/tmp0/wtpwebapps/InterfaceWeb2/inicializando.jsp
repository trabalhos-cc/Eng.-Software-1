<%@page import="connectAll.connectWeb"%>
<js >
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boticário</title>
</head>
<body>
	<h1 align="center"> ~~ BOTICÁRIO ~~ </h1>
	
	<form action="inicializando.jsp">
				Produto: <input type="text" id="nome" name="nome"> <input
			type="submit" value="Buscar" />
	</form>
	<%
		String nome = request.getParameter("nome");
		if (nome != null)
		connectWeb.getProdutoDigitado(nome);
	%> 
	
	<!--  <form acton = "inicializando.jsp" method="post">
	
		Nome produto:<input type="text" id="nome" name="nome" >
		<br/>
		Valor de venda:<input type="text" id="valor" name="valor">
		<br/>
		<input type = "submit" value="testar"/>
	</form>
	 -->	
	
</body>
</html>

