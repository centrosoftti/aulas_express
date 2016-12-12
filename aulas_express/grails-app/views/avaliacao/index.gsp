
<%@ page import="aulas_express.Avaliacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'avaliacao.label', default: 'Avaliacao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-avaliacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-avaliacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="avaliacao.usuario.label" default="Usuario" /></th>
					
						<g:sortableColumn property="tipoAvaliacao" title="${message(code: 'avaliacao.tipoAvaliacao.label', default: 'Tipo Avaliacao')}" />
					
						<g:sortableColumn property="nota" title="${message(code: 'avaliacao.nota.label', default: 'Nota')}" />
					
						<g:sortableColumn property="observacao" title="${message(code: 'avaliacao.observacao.label', default: 'Observacao')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${avaliacaoInstanceList}" status="i" var="avaliacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${avaliacaoInstance.id}">${fieldValue(bean: avaliacaoInstance, field: "usuario")}</g:link></td>
					
						<td>${fieldValue(bean: avaliacaoInstance, field: "tipoAvaliacao")}</td>
					
						<td>${fieldValue(bean: avaliacaoInstance, field: "nota")}</td>
					
						<td>${fieldValue(bean: avaliacaoInstance, field: "observacao")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${avaliacaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
