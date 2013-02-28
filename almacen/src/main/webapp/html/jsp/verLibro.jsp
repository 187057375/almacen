<%@ include file="/html/jsp/comun/import.jsp" %>
<c:if test="${not verLibroForm.habilitado}">
	<c:set var="deshabilitado" value="deshabilitado" />
</c:if>
<c:if test="${verLibroForm.libro ne null}">
	<html:form action="/modificarLibro.do">	
	<div class="fieldset">
		<label for="nombre" ><bean:message key="libro.nombre"/><c:out value=":"/></label>
		<html:text property="libro.nombre" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="nombre" styleClass="${deshabilitado}"/><br/>
		
		<label for="nombreOriginal" ><bean:message key="libro.nombreOriginal"/><c:out value=":"/></label>
		<html:text property="libro.nombreOriginal" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="nombreOriginal" styleClass="${deshabilitado}"/><br/>
		
		<label for="autor" ><bean:message key="libro.autor"/><c:out value=":"/></label>
		<html:text property="libro.autor" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="autor" styleClass="${deshabilitado}"/><br/>
		
		<label for="saga" ><bean:message key="libro.saga"/><c:out value=":"/></label>
		<html:text property="libro.saga" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="saga" styleClass="${deshabilitado}"/><br/>
		
		<label for="paginas" ><bean:message key="libro.paginas"/><c:out value=":"/></label>
		<html:text property="libro.paginas" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="paginas" styleClass="${deshabilitado}"/><br/>
		
		<label for="ilustracion" ><bean:message key="libro.ilustracion"/><c:out value=":"/></label>
		<html:text property="libro.ilustracion" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="ilustracion" styleClass="${deshabilitado}"/><br/>
		
		<label for="disenyo" ><bean:message key="libro.disenyo"/><c:out value=":"/></label>
		<html:text property="libro.disenyo" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="disenyo" styleClass="${deshabilitado}"/><br/>
		
		<label for="traduccion" ><bean:message key="libro.traduccion"/><c:out value=":"/></label>
		<html:text property="libro.traduccion" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="traduccion" styleClass="${deshabilitado}"/><br/>
		
		<label for="editorial" ><bean:message key="libro.editorial"/><c:out value=":"/></label>
		<html:text property="libro.editorial" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="editorial" styleClass="${deshabilitado}"/><br/>
		
		<label for="edicion" ><bean:message key="libro.edicion"/><c:out value=":"/></label>
		<html:text property="libro.edicion" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="edicion" styleClass="${deshabilitado}"/><br/>
		
		<label for="argumento" ><bean:message key="libro.argumento"/><c:out value=":"/></label>
		<html:textarea  property="libro.argumento" name="verLibroForm" readonly="${not verLibroForm.habilitado}" styleId="argumento" styleClass="${deshabilitado}"/><br/>
	</div>
	<c:if test="${verLibroForm.confirmar}">
		<br/>
		<div class="warning">
			<bean:message key="general.pregunta.eliminar" />
		</div>
	</c:if>
	<br/>
	<div id="buttons" class="buttons">
			<a href="buscarLibro.do" class="regular"><bean:message key="general.volver"/></a>
			<c:if test="${verLibroForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.guardar'/>" class="positive">
					<img src='html/img/apply2.png' alt='guardar'/>
					<bean:message key="general.guardar"/>
				</button>
			</c:if>
			<c:if test="${not verLibroForm.habilitado}">
				<button type="submit" name="method" value="<bean:message key='general.editar'/>" class="positive">
					<img src='html/img/apply2.png' alt='editar'/>
					<bean:message key="general.editar"/>
				</button>
			</c:if>
			<c:if test="${not verLibroForm.confirmar}">
				<button type="submit" name="method" value="<bean:message key='general.eliminar'/>" class="negative">
					<img src='html/img/cross.png' alt='eliminar'/>
					<bean:message key="general.eliminar"/>
				</button>
			</c:if>
			<c:if test="${verLibroForm.confirmar}">
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
	<html:hidden property="idlibro" name="verLibroForm"/>
	<html:hidden property="habilitado" name="verLibroForm"/>
	<html:hidden property="confirmar" name="verLibroForm"/>
	</html:form>
</c:if>
