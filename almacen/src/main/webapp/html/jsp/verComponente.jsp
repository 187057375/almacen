<%@ include file="/html/jsp/comun/import.jsp" %>
<c:if test="${not verComponenteForm.habilitado}">
	<c:set var="deshabilitado" value="deshabilitado" />
</c:if>
<c:if test="${verComponenteForm.componente ne null}">	
	<html:form action="/modificarComponente.do">
	<div class="fieldset">
		<label for="nombre" ><bean:message key="general.nombre"/><c:out value=":"/></label>
		<html:text property="componente.nombre" name="verComponenteForm" readonly="${not verComponenteForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
	</div>
	<br/>
	<div class="listado">
			<center>
				<c:if test="${not empty verComponenteForm.componente.participantes}">
				<display-el:table name="verComponenteForm.componente.participantes" id="participante" requestURI="/verComponente.do" cellpadding="5" cellspacing="0">
					<display-el:column property="instrumento" title="Instrumento" sortable="true" style="text-align: left;" />
					<display-el:column property="disco.grupo.nombre" title="Grupo" sortable="true" style="text-align: left;" />
					<display-el:column property="disco.nombre" title="Disco" sortable="true" style="text-align: left;" />
					<display-el:column href="verDisco.do" paramId="iddisco" paramProperty="disco.iddisco" ><bean:message key="general.ver"/> </display-el:column>
				</display-el:table>
				</c:if>
				<c:if test="${empty verComponenteForm.componente.participantes}">
					<bean:message key="participante.nohay"/> 
				</c:if>
			</center>
		</div>
	<c:if test="${verComponenteForm.confirmar}">
		<br/>
		<div class="warning">
			<bean:message key="general.pregunta.eliminar" />
		</div>
	</c:if>
	<br/>
	<div id="buttons" class="buttons">
			<a href="buscarLibro.do" class="regular"><bean:message key="general.volver"/></a>
			<c:if test="${verComponenteForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.guardar'/>" class="positive">
					<img src='html/img/apply2.png' alt='guardar'/>
					<bean:message key="general.guardar"/>
				</button>
			</c:if>
			<c:if test="${not verComponenteForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.editar'/>" class="positive">
					<img src='html/img/apply2.png' alt='editar'/>
					<bean:message key="general.editar"/>
				</button>
			</c:if>
			<c:if test="${not verComponenteForm.confirmar}">
				<button type="submit" name="method" value="<bean:message key='general.eliminar'/>" class="negative">
					<img src='html/img/cross.png' alt='eliminar'/>
					<bean:message key="general.eliminar"/>
				</button>
			</c:if>
			<c:if test="${verComponenteForm.confirmar}">
				<button type="submit" name="method" value="<bean:message key='general.aceptar'/>" class="positive">
					<img src='html/img/apply2.png' alt='aceptar'/>
					<bean:message key="general.aceptar"/>
				</button>
				<button type="submit" name="method" value="<bean:message key='general.cancelar'/>" class="negative">
					<img src='html/img/cross.png' alt='cancelar'/>
					<bean:message key="general.cancelar"/>
				</button>
			</c:if>
	</div>
	<html:hidden property="idcomponente" name="verComponenteForm"/>
	</html:form>
</c:if>

