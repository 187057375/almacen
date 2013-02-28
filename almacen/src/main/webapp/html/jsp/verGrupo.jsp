<%@ include file="/html/jsp/comun/import.jsp" %>
<c:if test="${not verGrupoForm.habilitado}">
	<c:set var="deshabilitado" value="deshabilitado" />
</c:if>
<c:if test="${verGrupoForm.grupo ne null}">	
	<html:form action="/modificarGrupo.do">
	<div class="fieldset">
		<label for="nombre" ><bean:message key="grupo.nombre"/><c:out value=":"/></label>
		<html:text property="grupo.nombre" name="verGrupoForm" readonly="${not verGrupoForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
	</div>
	<br/>
	<div class="listado">
		<center>
			<c:if test="${not empty verGrupoForm.grupo.discos}">
			<display-el:table name="verGrupoForm.grupo.discos" id="disco" requestURI="/verGrupo.do" cellpadding="5" cellspacing="0">
				<display-el:column property="nombre" title="nombre" sortable="true" style="text-align: left;" />
				<display-el:column property="productor" title="productor" sortable="true" style="text-align: left;" />
				<display-el:column property="sello" title="sello" sortable="true" style="text-align: left;" />
				<display-el:column property="anyo" title="anyo" sortable="true" style="text-align: left;" />
				<display-el:column href="verDisco.do" paramId="iddisco" paramProperty="iddisco" ><bean:message key="general.ver"/> </display-el:column>
			</display-el:table>
			</c:if>
			<c:if test="${empty verGrupoForm.grupo.discos}">
				<bean:message key="disco.nohay"/> 
			</c:if>
		</center>
	</div>
	<br/>
	<div id="buttons" class="buttons">
			<a href="buscarLibro.do" class="regular"><bean:message key="general.volver"/></a>
			<c:if test="${verGrupoForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.guardar'/>" class="positive">
					<img src='html/img/apply2.png' alt='guardar'/>
					<bean:message key="general.guardar"/>
				</button>
			</c:if>
			<c:if test="${not verGrupoForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.editar'/>" class="positive">
					<img src='html/img/apply2.png' alt='editar'/>
					<bean:message key="general.editar"/>
				</button>
			</c:if>
			<c:if test="${not verGrupoForm.confirmar}">
				<button type="submit" name="method" value="<bean:message key='general.eliminar'/>" class="negative">
					<img src='html/img/cross.png' alt='eliminar'/>
					<bean:message key="general.eliminar"/>
				</button>
			</c:if>
			<c:if test="${verGrupoForm.confirmar}">
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
	<html:hidden property="idgrupo" name="verGrupoForm"/>
	</html:form>
</c:if>

