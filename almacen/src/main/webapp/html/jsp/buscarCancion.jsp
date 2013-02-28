<%@ include file="/html/jsp/comun/import.jsp" %>
	<div class="separator"><!-- --></div>
	
<div id="formulario">	
	<html:form action="/buscarCancion2P.do?method=buscar">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="general.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" altKey="libro.nombre" styleId="nombre" /><br/>
			<label for="duracion"  ><bean:message key="cancion.duracion"/><c:out value=":"/></label>
			<html:text property="duracion" altKey="cancion.duracion"  styleId="duracion"/><br/>
			<label for="disco" ><bean:message key="general.disco"/><c:out value=":"/></label>
			<html:select property="iddisco" name="buscarCancionForm" styleId="disco">
				<html:optionsCollection property="discos" name="buscarCancionForm"/>
			</html:select><br/>
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
		<c:if test="${not empty buscarCancionForm.canciones}">
		<display-el:table name="requestScope.buscarCancionForm.canciones" id="cancion" requestURI="/buscarCancion.do" pagesize="10" cellpadding="5" cellspacing="0">
			<display-el:column property="nombre" title="nombre" sortable="true" style="text-align: left;" />
			<display-el:column property="duracion" title="duracion" sortable="true" style="text-align: left;" />
			<display-el:column property="disco.nombre" title="disco" sortable="true" style="text-align: left;" />
			<display-el:column href="verCancion.do" paramId="idcancion" paramProperty="idcancion" ><bean:message key="general.ver"/> </display-el:column>
		</display-el:table>
		</c:if>
		<c:if test="${empty buscarCancionForm.canciones}">
			<bean:message key="general.realizar.busqueda"/> 
		</c:if>
	</center>
</div>
<br/><br/>
<div id="buttons" class="buttons">
	<html:link page="/crearCancion2P.do?method=nuevo" styleClass="regular"><bean:message key="cancion.new"/></html:link>
</div>