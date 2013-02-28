<%@ include file="/html/jsp/comun/import.jsp" %>
<c:if test="${not verCancionForm.habilitado}">
	<c:set var="deshabilitado" value="deshabilitado" />
</c:if>
<c:if test="${verCancionForm.cancion ne null}">	
	<html:form action="/modificarCancion.do">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="general.nombre"/><c:out value=":"/></label>
			<html:text property="cancion.nombre" name="verCancionForm" readonly="${not verCancionForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
			<label for="duracion" ><bean:message key="cancion.duracion"/><c:out value=":"/></label>
			<html:text property="cancion.duracion" name="verCancionForm" readonly="${not verCancionForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
			<label for="disco" ><bean:message key="general.disco"/><c:out value=":"/></label>
			<html:select property="cancion.disco.iddisco" name="verCancionForm" disabled="${not verCancionForm.habilitado}" styleId="disco" styleClass="${deshabilitado}">
				<html:optionsCollection property="discos" name="verCancionForm"/>
			</html:select>
		</div>
		<c:if test="${verCancionForm.confirmar}">
			<br/>
			<div class="warning">
				<bean:message key="general.pregunta.eliminar" />
			</div>
		</c:if>
		<br/>
		<div id="buttons" class="buttons">
				<a href="buscarCancion.do" class="regular"><bean:message key="general.volver"/></a>
				<c:if test="${verCancionForm.habilitado}">
					<button type="submit" name="method" value="<bean:message key='general.guardar'/>" class="positive">
						<img src='html/img/apply2.png' alt='guardar'/>
						<bean:message key="general.guardar"/>
					</button>
				</c:if>
				<c:if test="${not verCancionForm.habilitado}">
					<button type="submit" name="method" value="<bean:message key='general.editar'/>" class="positive">
						<img src='html/img/apply2.png' alt='editar'/>
						<bean:message key="general.editar"/>
					</button>
				</c:if>
				<c:if test="${not verCancionForm.confirmar}">
					<button type="submit" name="method" value="<bean:message key='general.eliminar'/>" class="negative">
						<img src='html/img/cross.png' alt='eliminar'/>
						<bean:message key="general.eliminar"/>
					</button>
				</c:if>
				<c:if test="${verCancionForm.confirmar}">
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
		<html:hidden property="idcancion" name="verCancionForm"/>
	</html:form>
</c:if>

