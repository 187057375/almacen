<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
	<html:form action="/crearDisco2P.do?method=save">
		<div class="fieldset">
			<label for="nombre" ><bean:message key="disco.nombre"/><c:out value=":"/></label>
			<html:text property="nombre" name="crearDiscoForm" styleId="nombre" altKey="disco.nombre"/><br/>
			<label for="productor" ><bean:message key="disco.productor"/><c:out value=":"/></label>
			<html:text property="productor" name="crearDiscoForm" styleId="productor" altKey="disco.productor"/><br/>
			<label for="sello" ><bean:message key="disco.sello"/><c:out value=":"/></label>
			<html:text property="sello" name="crearDiscoForm" styleId="sello" altKey="disco.sello"/><br/>
			<label for="anyo" ><bean:message key="disco.anyo"/><c:out value=":"/></label>
			<html:text property="anyo" name="crearDiscoForm" styleId="anyo" altKey="disco.anyo"/><br/>
			<label for="grupo" ><bean:message key="general.grupo"/><c:out value=":"/></label>
			<html:select property="idgrupo" name="crearDiscoForm" styleId="grupo">
				<html:optionsCollection property="grupos" name="crearDiscoForm"/>
			</html:select><br/>
		</div>
		<br/>
		<button type="submit" class="positive">
			<img src='html/img/apply2.png' alt='guardar'/>
			<bean:message key="general.guardar"/>
		</button>
	</html:form>
</div>
	
