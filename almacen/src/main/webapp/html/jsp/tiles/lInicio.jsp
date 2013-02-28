<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="/html/jsp/comun/import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es" >
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="html/css/momo.css" />
<link rel="stylesheet" type="text/css" href="html/css/main.css" />
<link rel="stylesheet" type="text/css" href="html/css/displaytag.css" />
<title>Almacen - Mono Template</title>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<tiles:insert attribute="header"/>
		</div>
		<div id="menu">	
			<tiles:insert attribute="menu"/>
		</div>
		<div id="top"> </div>		
		<div id="contentwrap"> 
		<div id="content">
			<tiles:insert attribute="mensajes"/>
   			<tiles:insert attribute="body"/>
		</div>
		<div id="sidebar">
			<tiles:insert attribute="sidebar"/>
		</div>
		<div style="clear: both;"> </div>
	</div>
	<div id="bottom"> </div>
	<div id="footer">
		<tiles:insert attribute="bottom"/>
	</div>
</div>

</body>
</html>