<%@ include file="/html/jsp/comun/import.jsp" %>
<c:if test="${not verDiscoForm.habilitado}">
	<c:set var="deshabilitado" value="deshabilitado" />
</c:if>
<c:if test="${verDiscoForm.disco ne null}">	
	<html:form action="/modificarDisco.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="disco.nombre"/><c:out value=":"/></label>
			<html:text property="disco.nombre" name="verDiscoForm" readonly="${not verDiscoForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
			<label for="productor" ><bean:message key="disco.productor"/><c:out value=":"/></label>
			<html:text property="disco.productor" name="verDiscoForm" readonly="${not verDiscoForm.habilitado}" styleId="productor" styleClass="${deshabilitado}"/><br/>
			<label for="sello" ><bean:message key="disco.sello"/><c:out value=":"/></label>
			<html:text property="disco.sello" name="verDiscoForm" readonly="${not verDiscoForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
			<label for="anyo" ><bean:message key="disco.anyo"/><c:out value=":"/></label>
			<html:text property="disco.anyo" name="verDiscoForm" readonly="${not verDiscoForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
			<label for="grupo" ><bean:message key="general.grupo"/><c:out value=":"/></label>
			<html:select property="disco.grupo.idgrupo" name="verDiscoForm" disabled="${not verDiscoForm.habilitado}" styleId="grupo" styleClass="${deshabilitado}">
					<html:optionsCollection property="grupos" name="verDiscoForm"/>
				</html:select><br/>
		</div>
		<br/>
		<div class="listado">
			<center>
				<c:if test="${not empty verDiscoForm.disco.participantes}">
				<display-el:table name="verDiscoForm.disco.participantes" id="participante" requestURI="/verDisco.do" cellpadding="5" cellspacing="0">
					<display-el:column property="componente.nombre" title="Componente" sortable="true" style="text-align: left;" />
					<display-el:column property="instrumento" title="Instrumento" sortable="true" style="text-align: left;" />
					<display-el:column href="verComponente.do" paramId="idcomponente" paramProperty="componente.idcomponente" ><bean:message key="general.ver"/> </display-el:column>
				</display-el:table>
				</c:if>
				<c:if test="${empty verDiscoForm.disco.participantes}">
					<bean:message key="participante.nohay"/> 
				</c:if>
			</center>
		</div>
		<br/>
	<div id="buttons" class="buttons">
			<a href="buscarLibro.do" class="regular"><bean:message key="general.volver"/></a>
			<c:if test="${verDiscoForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.guardar'/>" class="positive">
					<img src='html/img/apply2.png' alt='guardar'/>
					<bean:message key="general.guardar"/>
				</button>
			</c:if>
			<c:if test="${not verDiscoForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.editar'/>" class="positive">
					<img src='html/img/apply2.png' alt='editar'/>
					<bean:message key="general.editar"/>
				</button>
			</c:if>
			<c:if test="${not verDiscoForm.confirmar}">
				<button type="submit" name="method" value="<bean:message key='general.eliminar'/>" class="negative">
					<img src='html/img/cross.png' alt='eliminar'/>
					<bean:message key="general.eliminar"/>
				</button>
			</c:if>
			<c:if test="${verDiscoForm.confirmar}">
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
		<html:hidden property="iddisco" name="verDiscoForm"/>
	</html:form>
	<html:form action="anyadirParticipante.do">
		<div id="buttons" class="buttons">
			<button type="submit" class="regular">
				<bean:message key="participante.anyadir"/>
			</button>
		</div>
		<html:hidden property="iddisco" name="anyadirParticipanteForm" value="${verDiscoForm.iddisco}"/>
		<html:hidden property="method" value="nuevo"/>
	</html:form>
</c:if>

