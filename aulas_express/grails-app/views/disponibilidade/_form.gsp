<%@ page import="aulas_express.Disponibilidade" %>




<div class="fieldcontain ${hasErrors(bean: disponibilidadeInstance, field: 'ativo', 'error')} required">
	<label for="ativo">
		<g:message code="disponibilidade.ativo.label" default="Ativo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ativo" type="number" value="${disponibilidadeInstance.ativo}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: disponibilidadeInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="disponibilidade.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitude" value="${fieldValue(bean: disponibilidadeInstance, field: 'latitude')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: disponibilidadeInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="disponibilidade.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitude" value="${fieldValue(bean: disponibilidadeInstance, field: 'longitude')}" required=""/>

</div>

