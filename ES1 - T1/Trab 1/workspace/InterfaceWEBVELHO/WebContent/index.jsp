<%@page import="connectionBD.ConnectionAll"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Botic�rio</title>
</head>
<body>
	<h1 align="center"> BOTIC�RIO</h1>
	<form action="index.jsp">
		Produto:<input type="text" id="nome" name="nome"> <input
			type="submit" value="Buscar" />
	</form>

	<%
		String nome = request.getParameter("nome");
		if (nome != null)
			out.print(ConnectionAll.getProdutoDigitado(nome));
	%>


</body>
</html>

<!--  CAIXA COM CAMPO PARA DIGITAR! 
%= ConnectionAll.getProdutoDigitado("FUN FUN FUN") %>
form action="iniciando.jsp">
	<input type = "text" id = "nome" name = "nome">
	<input type = "submit" value="Enviar"/>
	</form>
	% session.setAttribute("titulo1", "titulo2"); %>	
-->

<!--  INCLUDE - 
	inclue p�ginas uma dentro da outra.  
	
	incluindo pagina testando.jsp em index.jsp 
	em testando jsp: 
		<html>
			<h3> Essa p�gina est� sendo incluida</h3>
		</html>
	em index.jsp:
		%@ include file = "testando.jsp" %>
-->


<!-- P�GINA DE ERRO 
	em index.jsp:
	%@ page errorPage = "iniciando.jsp" %>  [<-exemplo]
	%= 100/0%> [<- isso no Java d� um erro]
	
	em iniciando.jsp:
	%@ page isErrorPage = "true" %>
	% execption %>
 -->

<!-- "%= application.getInitParameter("titulo") %>
<br>
%= application.getInitParameter("titulo1") %>  -->

<!--%=
"Nome recebido:" + request.getParameter("nome")
%>  -->