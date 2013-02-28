<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
	<html:form action="/buscarLibro.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="libro.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" altKey="libro.nombre" styleId="nombre" /><br/>
			<label for="saga"  ><bean:message key="libro.saga"/><c:out value=":"/></label>
			<html:text property="saga" altKey="libro.saga"  styleId="saga"/><br/>
			<label for="autor" ><bean:message key="libro.autor"/><c:out value=":"/></label>
			<html:text property="autor" altKey="libro.autor" styleId="autor"/><br/>
			<label for="paginas"  ><bean:message key="libro.paginas"/><c:out value=":"/></label>
			<html:text property="paginas" altKey="libro.paginas"  styleId="paginas"/><br/>
			<div id="buttons" class="buttons">
				<button type="submit" class="regular">
					<bean:message key="form.submit"/>
				</button>
			</div>
		</div>
	</html:form>
</div>
<br/><br/>
<div class="listado">
	<center>
		<c:if test="${not empty buscarLibroForm.libros}">
		<html:form action="buscarLibro.do">
		<display-el:table name="requestScope.buscarLibroForm.libros" id="libro" requestURI="/buscarLibro.do" pagesize="10" cellpadding="5" cellspacing="0" >
			<display-el:column headerScope="col" property="nombre" title="Nombre" sortable="true" style="text-align: left;" />
			<display-el:column headerScope="col" property="saga" title="Saga" sortable="true" style="text-align: left;" />
			<display-el:column headerScope="col" property="autor" title="Autor" sortable="true" style="text-align: left;" />
			<display-el:column headerScope="col" property="paginas" title="Paginas" sortable="true" style="text-align: left;" />
			<display-el:column headerScope="col" href="verLibro.do" paramId="idlibro" paramProperty="idlibro" escapeXml="true"><bean:message key="general.ver"/> </display-el:column>
			<display:setProperty name="css.tr.even" value="" />
		</display-el:table>
		</html:form>
		</c:if>
		<c:if test="${empty buscarLibroForm.libros}">
			<bean:message key="general.realizar.busqueda"/> 
		</c:if>
	</center>
</div>
<br/>
<div id="buttons" class="buttons">
	<html:link page="/inicioCrearLibro.do" styleClass="regular"><bean:message key="libro.new"/></html:link>
</div>
