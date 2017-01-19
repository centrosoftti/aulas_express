
<%@ page import="aulas_express.Disponibilidade" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'disponibilidade.label', default: 'Disponibilidade')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-disponibilidade" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-disponibilidade" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
					
						<g:sortableColumn property="ativo" title="${message(code: 'disponibilidade.ativo.label', default: 'Ativo')}" />
					
						<g:sortableColumn property="latitude" title="${message(code: 'disponibilidade.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'disponibilidade.longitude.label', default: 'Longitude')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${disponibilidadeInstanceList}" status="i" var="disponibilidadeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: disponibilidadeInstance, field: "ativo")}</td>
					
						<td>${fieldValue(bean: disponibilidadeInstance, field: "latitude")}</td>
					
						<td>${fieldValue(bean: disponibilidadeInstance, field: "longitude")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${disponibilidadeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
