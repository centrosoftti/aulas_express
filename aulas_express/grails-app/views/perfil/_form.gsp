<%@ page import="org.example.Perfil" %>



<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="perfil.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" required="" value="${perfilInstance?.authority}"/>

</div>

