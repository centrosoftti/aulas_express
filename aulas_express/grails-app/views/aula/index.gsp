
<%@ page import="aulas_express.Aula" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aula.label', default: 'Aula')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-aula" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-aula" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="aula.cliente.label" default="Cliente" /></th>
					
						<th><g:message code="aula.professor.label" default="Professor" /></th>
					
						<g:sortableColumn property="status" title="${message(code: 'aula.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="quantidade_alunos" title="${message(code: 'aula.quantidade_alunos.label', default: 'Quantidadealunos')}" />
					
						<g:sortableColumn property="quantidade_horas" title="${message(code: 'aula.quantidade_horas.label', default: 'Quantidadehoras')}" />
					
						<g:sortableColumn property="valorAula" title="${message(code: 'aula.valorAula.label', default: 'Valor Aula')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${aulaInstanceList}" status="i" var="aulaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${aulaInstance.id}">${fieldValue(bean: aulaInstance, field: "cliente")}</g:link></td>
					
						<td>${fieldValue(bean: aulaInstance, field: "professor")}</td>
					
						<td>${fieldValue(bean: aulaInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: aulaInstance, field: "quantidade_alunos")}</td>
					
						<td>${fieldValue(bean: aulaInstance, field: "quantidade_horas")}</td>
					
						<td>${fieldValue(bean: aulaInstance, field: "valorAula")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${aulaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
