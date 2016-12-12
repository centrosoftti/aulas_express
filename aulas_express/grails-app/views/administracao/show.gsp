
<%@ page import="aulas_express.Administracao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'administracao.label', default: 'Administracao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-administracao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-administracao" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list administracao">
			
				<g:if test="${administracaoInstance?.raioProfessor}">
				<li class="fieldcontain">
					<span id="raioProfessor-label" class="property-label"><g:message code="administracao.raioProfessor.label" default="Raio Professor" /></span>
					
						<span class="property-value" aria-labelledby="raioProfessor-label"><g:fieldValue bean="${administracaoInstance}" field="raioProfessor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${administracaoInstance?.valorAulaGraduado}">
				<li class="fieldcontain">
					<span id="valorAulaGraduado-label" class="property-label"><g:message code="administracao.valorAulaGraduado.label" default="Valor Aula Graduado" /></span>
					
						<span class="property-value" aria-labelledby="valorAulaGraduado-label"><g:fieldValue bean="${administracaoInstance}" field="valorAulaGraduado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${administracaoInstance?.valorAulaNaoGraduado}">
				<li class="fieldcontain">
					<span id="valorAulaNaoGraduado-label" class="property-label"><g:message code="administracao.valorAulaNaoGraduado.label" default="Valor Aula Nao Graduado" /></span>
					
						<span class="property-value" aria-labelledby="valorAulaNaoGraduado-label"><g:fieldValue bean="${administracaoInstance}" field="valorAulaNaoGraduado"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:administracaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${administracaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
