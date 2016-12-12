
<%@ page import="aulas_express.Aula" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aula.label', default: 'Aula')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-aula" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-aula" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list aula">
			
				<g:if test="${aulaInstance?.cliente}">
				<li class="fieldcontain">
					<span id="cliente-label" class="property-label"><g:message code="aula.cliente.label" default="Cliente" /></span>
					
						<span class="property-value" aria-labelledby="cliente-label"><g:link controller="usuario" action="show" id="${aulaInstance?.cliente?.id}">${aulaInstance?.cliente?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.professor}">
				<li class="fieldcontain">
					<span id="professor-label" class="property-label"><g:message code="aula.professor.label" default="Professor" /></span>
					
						<span class="property-value" aria-labelledby="professor-label"><g:link controller="usuario" action="show" id="${aulaInstance?.professor?.id}">${aulaInstance?.professor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="aula.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${aulaInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.quantidade_alunos}">
				<li class="fieldcontain">
					<span id="quantidade_alunos-label" class="property-label"><g:message code="aula.quantidade_alunos.label" default="Quantidadealunos" /></span>
					
						<span class="property-value" aria-labelledby="quantidade_alunos-label"><g:fieldValue bean="${aulaInstance}" field="quantidade_alunos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.quantidade_horas}">
				<li class="fieldcontain">
					<span id="quantidade_horas-label" class="property-label"><g:message code="aula.quantidade_horas.label" default="Quantidadehoras" /></span>
					
						<span class="property-value" aria-labelledby="quantidade_horas-label"><g:fieldValue bean="${aulaInstance}" field="quantidade_horas"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.valorAula}">
				<li class="fieldcontain">
					<span id="valorAula-label" class="property-label"><g:message code="aula.valorAula.label" default="Valor Aula" /></span>
					
						<span class="property-value" aria-labelledby="valorAula-label"><g:fieldValue bean="${aulaInstance}" field="valorAula"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.observacao}">
				<li class="fieldcontain">
					<span id="observacao-label" class="property-label"><g:message code="aula.observacao.label" default="Observacao" /></span>
					
						<span class="property-value" aria-labelledby="observacao-label"><g:fieldValue bean="${aulaInstance}" field="observacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aulaInstance?.data_hora}">
				<li class="fieldcontain">
					<span id="data_hora-label" class="property-label"><g:message code="aula.data_hora.label" default="Datahora" /></span>
					
						<span class="property-value" aria-labelledby="data_hora-label"><g:formatDate date="${aulaInstance?.data_hora}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:aulaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${aulaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
