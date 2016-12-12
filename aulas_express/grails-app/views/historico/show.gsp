
<%@ page import="aulas_express.Historico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'historico.label', default: 'Historico')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-historico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-historico" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list historico">
			
				<g:if test="${historicoInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="historico.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${historicoInstance?.usuario?.id}">${historicoInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${historicoInstance?.acao}">
				<li class="fieldcontain">
					<span id="acao-label" class="property-label"><g:message code="historico.acao.label" default="Acao" /></span>
					
						<span class="property-value" aria-labelledby="acao-label"><g:fieldValue bean="${historicoInstance}" field="acao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historicoInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="historico.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${historicoInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historicoInstance?.data_hora}">
				<li class="fieldcontain">
					<span id="data_hora-label" class="property-label"><g:message code="historico.data_hora.label" default="Datahora" /></span>
					
						<span class="property-value" aria-labelledby="data_hora-label"><g:formatDate date="${historicoInstance?.data_hora}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:historicoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${historicoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
