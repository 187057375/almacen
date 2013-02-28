<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
	<html:form action="/crearCancion2P.do?method=save">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="general.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" name="crearCancionForm"  styleId="nombre"/><br/>
			<label for="duracion" ><bean:message key="cancion.duracion"/><c:out value=":"/></label>
			<html:text property="duracion" name="crearCancionForm"  styleId="duracion"/><br/>
			<label for="disco" ><bean:message key="general.disco"/><c:out value=":"/></label>
			<html:select property="iddisco" name="crearCancionForm" styleId="disco">
				<html:optionsCollection property="discos" name="crearCancionForm"/>
			</html:select><br/>
		</div>
		<br/>
		<button type="submit" class="positive">
			<img src='html/img/apply2.png' alt='guardar'/>
			<bean:message key="general.guardar"/>
		</button>
	</html:form>
</div>
	
