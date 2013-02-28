<%@ include file="/html/jsp/comun/import.jsp" %>

<div class="separator"><!-- --></div>
	
<div id="formulario">	
	<html:form action="/anyadirParticipante.do?method=save">
		<div class="leftForm18">
			<p><bean:message key="general.instrumento"/>:<c:out value=":"/></p>
			<p><bean:message key="general.componente"/><c:out value=":"/></p>
		</div>
		<div class="rightForm18">
			<p><html:text property="instrumento" altKey="general.instrumento" name="anyadirParticipanteForm"/></p>
			<p>
			<html:select property="idcomponente" name="anyadirParticipanteForm" altKey="general.componente">
				<html:optionsCollection property="componentes" name="anyadirParticipanteForm"/>
			</html:select>
			</p>
		</div>
		<html:submit><bean:message key="general.guardar"/></html:submit>
		<html:hidden property="iddisco" name="anyadirParticipanteForm"/>
	</html:form>
</div>
	
