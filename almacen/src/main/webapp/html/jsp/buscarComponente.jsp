<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
	<html:form action="/buscarComponente.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="general.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" altKey="general.nombre" styleId="nombre" /><br/>
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
		<c:if test="${not empty buscarComponenteForm.componentes}">
		<display-el:table name="requestScope.buscarComponenteForm.componentes" id="componente" requestURI="/buscarComponente.do" pagesize="10" cellpadding="5" cellspacing="0">
			<display-el:column property="nombre" title="nombre" sortable="true" style="text-align: left;" />
			<display-el:column href="verComponente.do" paramId="idcomponente" paramProperty="idcomponente" ><bean:message key="general.ver"/> </display-el:column>
		</display-el:table>
		</c:if>
		<c:if test="${empty buscarComponenteForm.componentes}">
			<bean:message key="general.realizar.busqueda"/> 
		</c:if>
	</center>
</div>
<br/><br/>
<div id="buttons" class="buttons">
	<html:link page="/inicioCrearComponente.do" styleClass="regular"><bean:message key="componente.new"/></html:link>
</div>
