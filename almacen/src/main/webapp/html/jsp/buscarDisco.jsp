<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
	<html:form action="/buscarDisco.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="disco.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" altKey="disco.nombre" styleId="nombre" /><br/>
			<label for="productor"  ><bean:message key="disco.productor"/><c:out value=":"/></label>
			<html:text property="productor" altKey="disco.productor" styleId="productor"/><br/>
			<label for="sello" ><bean:message key="disco.sello"/><c:out value=":"/></label>
			<html:text property="sello" altKey="disco.sello" styleId="sello"/><br/>
			<label for="anyo"  ><bean:message key="disco.anyo"/><c:out value=":"/></label>
			<html:text property="anyo" altKey="disco.anyo" styleId="anyo"/><br/>
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
		<c:if test="${not empty buscarDiscoForm.discos}">
		<display-el:table name="requestScope.buscarDiscoForm.discos" id="disco" requestURI="/buscarDisco.do" pagesize="10" cellpadding="5" cellspacing="0">
			<display-el:column property="nombre" title="nombre" sortable="true" style="text-align: left;" />
			<display-el:column property="productor" title="productor" sortable="true" style="text-align: left;" />
			<display-el:column property="sello" title="sello" sortable="true" style="text-align: left;" />
			<display-el:column property="anyo" title="anyo" sortable="true" style="text-align: left;" />
			<display-el:column href="verDisco.do" paramId="iddisco" paramProperty="iddisco" ><bean:message key="general.ver"/> </display-el:column>
		</display-el:table>
		</c:if>
		<c:if test="${empty buscarDiscoForm.discos}">
			<bean:message key="general.realizar.busqueda"/> 
		</c:if>
	</center>
</div>
<br/>
<div id="buttons" class="buttons">
	<html:link page="/crearDisco2P.do?method=nuevo" styleClass="regular"><bean:message key="disco.new"/></html:link>
</div>