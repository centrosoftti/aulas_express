
<%@ page import="aulas_express.Experiencia" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experiencia.label', default: 'Experiencia')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-experiencia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-experiencia" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="experiencia.professor.label" default="Professor" /></th>
					
						<g:sortableColumn property="formacao" title="${message(code: 'experiencia.formacao.label', default: 'Formacao')}" />
					
						<g:sortableColumn property="empregador_atual" title="${message(code: 'experiencia.empregador_atual.label', default: 'Empregadoratual')}" />
					
						<g:sortableColumn property="ocupacao" title="${message(code: 'experiencia.ocupacao.label', default: 'Ocupacao')}" />
					
						<g:sortableColumn property="postal_code" title="${message(code: 'experiencia.postal_code.label', default: 'Postalcode')}" />
					
						<g:sortableColumn property="endereco" title="${message(code: 'experiencia.endereco.label', default: 'Endereco')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${experienciaInstanceList}" status="i" var="experienciaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${experienciaInstance.id}">${fieldValue(bean: experienciaInstance, field: "professor")}</g:link></td>
					
						<td>${fieldValue(bean: experienciaInstance, field: "formacao")}</td>
					
						<td>${fieldValue(bean: experienciaInstance, field: "empregador_atual")}</td>
					
						<td>${fieldValue(bean: experienciaInstance, field: "ocupacao")}</td>
					
						<td>${fieldValue(bean: experienciaInstance, field: "postal_code")}</td>
					
						<td>${fieldValue(bean: experienciaInstance, field: "endereco")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${experienciaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
