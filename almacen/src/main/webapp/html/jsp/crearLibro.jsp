<%@ include file="/html/jsp/comun/import.jsp" %>
<div id="formulario">	
<html:form action="/crearLibro.do">
	<div class="fieldset">
		<label for="nombre" ><bean:message key="libro.nombre"/><c:out value=":"/></label>
		<html:text property="libro.nombre" name="crearLibroForm"  styleId="nombre"/><br/>
		
		<label for="nombreOriginal" ><bean:message key="libro.nombreOriginal"/><c:out value=":"/></label>
		<html:text property="libro.nombreOriginal" name="crearLibroForm"  styleId="nombreOriginal"/><br/>
		
		<label for="autor" ><bean:message key="libro.autor"/><c:out value=":"/></label>
		<html:text property="libro.autor" name="crearLibroForm"  styleId="autor"/><br/>
		
		<label for="saga" ><bean:message key="libro.saga"/><c:out value=":"/></label>
		<html:text property="libro.saga" name="crearLibroForm"  styleId="saga"/><br/>
		
		<label for="paginas" ><bean:message key="libro.paginas"/><c:out value=":"/></label>
		<html:text property="libro.paginas" name="crearLibroForm"  styleId="paginas"/><br/>
		
		<label for="ilustracion" ><bean:message key="libro.ilustracion"/><c:out value=":"/></label>
		<html:text property="libro.ilustracion" name="crearLibroForm"  styleId="ilustracion"/><br/>
		
		<label for="disenyo" ><bean:message key="libro.disenyo"/><c:out value=":"/></label>
		<html:text property="libro.disenyo" name="crearLibroForm"  styleId="disenyo"/><br/>
		
		<label for="traduccion" ><bean:message key="libro.traduccion"/><c:out value=":"/></label>
		<html:text property="libro.traduccion" name="crearLibroForm"  styleId="traduccion"/><br/>
		
		<label for="editorial" ><bean:message key="libro.editorial"/><c:out value=":"/></label>
		<html:text property="libro.editorial" name="crearLibroForm"  styleId="editorial"/><br/>
		
		<label for="edicion" ><bean:message key="libro.edicion"/><c:out value=":"/></label>
		<html:text property="libro.edicion" name="crearLibroForm"  styleId="edicion"/><br/>
		
		<label for="argumento" ><bean:message key="libro.argumento"/><c:out value=":"/></label>
		<html:textarea  property="libro.argumento" name="crearLibroForm"  styleId="argumento"/><br/>
	</div>
	<br/>
	<button type="submit" class="positive">
		<img src='html/img/apply2.png' alt='guardar'/>
		<bean:message key="general.guardar"/>
	</button>
</html:form>
</div>
