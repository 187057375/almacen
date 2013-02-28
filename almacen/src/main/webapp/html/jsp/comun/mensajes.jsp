<%@ include file="/html/jsp/comun/import.jsp" %>
<logic:messagesPresent>
	<div class="error">
		<ul>
		<html:messages message="false" id="errMsg">
			<li><bean:write name="errMsg" /></li>
		</html:messages>
		</ul>
	</div>
</logic:messagesPresent>

<logic:messagesPresent message="true" property="mensaje">
	<div class="success">
		<html:messages message="true" id="mensaje">
			<bean:write name="mensaje" />
		</html:messages>
	</div>
</logic:messagesPresent>