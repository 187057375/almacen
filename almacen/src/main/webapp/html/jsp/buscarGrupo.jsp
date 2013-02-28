<%@ include file="/html/jsp/comun/import.jsp" %>

<div id="formulario">	
	<html:form action="/buscarGrupo.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="grupo.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" altKey="grupo.nombre" styleId="nombre" /><br/>
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
		<c:if test="${not empty buscarGrupoForm.grupos}">
		<display-el:table name="requestScope.buscarGrupoForm.grupos" id="grupo" requestURI="/buscarGrupo.do" cellpadding="5" cellspacing="0">
			<display-el:column property="nombre" title="nombre" sortable="true" style="text-align: left;" />
			<display-el:column href="verGrupo.do" paramId="idgrupo" paramProperty="idgrupo" ><bean:message key="general.ver"/> </display-el:column>
		</display-el:table>
		</c:if>
		<c:if test="${empty buscarGrupoForm.grupos}">
			<bean:message key="general.realizar.busqueda"/> 
		</c:if>
	</center>
</div>
<br/>
<div id="buttons" class="buttons">
	<html:link page="/inicioCrearGrupo.do" styleClass="regular"><bean:message key="grupo.new"/></html:link>
</div>