
<%@ page import="aulas_express.Experiencia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experiencia.label', default: 'Experiencia')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-experiencia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-experiencia" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list experiencia">
			
				<g:if test="${experienciaInstance?.professor}">
				<li class="fieldcontain">
					<span id="professor-label" class="property-label"><g:message code="experiencia.professor.label" default="Professor" /></span>
					
						<span class="property-value" aria-labelledby="professor-label"><g:link controller="usuario" action="show" id="${experienciaInstance?.professor?.id}">${experienciaInstance?.professor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.formacao}">
				<li class="fieldcontain">
					<span id="formacao-label" class="property-label"><g:message code="experiencia.formacao.label" default="Formacao" /></span>
					
						<span class="property-value" aria-labelledby="formacao-label"><g:fieldValue bean="${experienciaInstance}" field="formacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.empregador_atual}">
				<li class="fieldcontain">
					<span id="empregador_atual-label" class="property-label"><g:message code="experiencia.empregador_atual.label" default="Empregadoratual" /></span>
					
						<span class="property-value" aria-labelledby="empregador_atual-label"><g:fieldValue bean="${experienciaInstance}" field="empregador_atual"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.ocupacao}">
				<li class="fieldcontain">
					<span id="ocupacao-label" class="property-label"><g:message code="experiencia.ocupacao.label" default="Ocupacao" /></span>
					
						<span class="property-value" aria-labelledby="ocupacao-label"><g:fieldValue bean="${experienciaInstance}" field="ocupacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.postal_code}">
				<li class="fieldcontain">
					<span id="postal_code-label" class="property-label"><g:message code="experiencia.postal_code.label" default="Postalcode" /></span>
					
						<span class="property-value" aria-labelledby="postal_code-label"><g:fieldValue bean="${experienciaInstance}" field="postal_code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.endereco}">
				<li class="fieldcontain">
					<span id="endereco-label" class="property-label"><g:message code="experiencia.endereco.label" default="Endereco" /></span>
					
						<span class="property-value" aria-labelledby="endereco-label"><g:fieldValue bean="${experienciaInstance}" field="endereco"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.cidade}">
				<li class="fieldcontain">
					<span id="cidade-label" class="property-label"><g:message code="experiencia.cidade.label" default="Cidade" /></span>
					
						<span class="property-value" aria-labelledby="cidade-label"><g:fieldValue bean="${experienciaInstance}" field="cidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="experiencia.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${experienciaInstance}" field="estado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.telefone}">
				<li class="fieldcontain">
					<span id="telefone-label" class="property-label"><g:message code="experiencia.telefone.label" default="Telefone" /></span>
					
						<span class="property-value" aria-labelledby="telefone-label"><g:fieldValue bean="${experienciaInstance}" field="telefone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="experiencia.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${experienciaInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experienciaInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="experiencia.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${experienciaInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:experienciaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${experienciaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
