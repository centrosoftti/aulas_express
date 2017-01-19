
<%@ page import="aulas_express.Historico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'historico.label', default: 'Historico')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-historico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-historico" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="historico.usuario.label" default="Usuario" /></th>
					
						<g:sortableColumn property="acao" title="${message(code: 'historico.acao.label', default: 'Acao')}" />
					
						<g:sortableColumn property="data_hora" title="${message(code: 'historico.data_hora.label', default: 'Datahora')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${historicoInstanceList}" status="i" var="historicoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${historicoInstance.id}">${fieldValue(bean: historicoInstance, field: "usuario")}</g:link></td>
					
						<td>${fieldValue(bean: historicoInstance, field: "acao")}</td>
					
						<td><g:formatDate date="${historicoInstance.data_hora}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${historicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
