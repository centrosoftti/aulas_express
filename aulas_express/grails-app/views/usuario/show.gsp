
<%@ page import="org.example.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-usuario" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuario">
			
				<g:if test="${usuarioInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="usuario.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${usuarioInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="usuario.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${usuarioInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="usuario.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${usuarioInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.first_name}">
				<li class="fieldcontain">
					<span id="first_name-label" class="property-label"><g:message code="usuario.first_name.label" default="Firstname" /></span>
					
						<span class="property-value" aria-labelledby="first_name-label"><g:fieldValue bean="${usuarioInstance}" field="first_name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.last_name}">
				<li class="fieldcontain">
					<span id="last_name-label" class="property-label"><g:message code="usuario.last_name.label" default="Lastname" /></span>
					
						<span class="property-value" aria-labelledby="last_name-label"><g:fieldValue bean="${usuarioInstance}" field="last_name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.telefone_celular}">
				<li class="fieldcontain">
					<span id="telefone_celular-label" class="property-label"><g:message code="usuario.telefone_celular.label" default="Telefonecelular" /></span>
					
						<span class="property-value" aria-labelledby="telefone_celular-label"><g:fieldValue bean="${usuarioInstance}" field="telefone_celular"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.telefone_fixo}">
				<li class="fieldcontain">
					<span id="telefone_fixo-label" class="property-label"><g:message code="usuario.telefone_fixo.label" default="Telefonefixo" /></span>
					
						<span class="property-value" aria-labelledby="telefone_fixo-label"><g:fieldValue bean="${usuarioInstance}" field="telefone_fixo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.escola_onde_estuda}">
				<li class="fieldcontain">
					<span id="escola_onde_estuda-label" class="property-label"><g:message code="usuario.escola_onde_estuda.label" default="Escolaondeestuda" /></span>
					
						<span class="property-value" aria-labelledby="escola_onde_estuda-label"><g:fieldValue bean="${usuarioInstance}" field="escola_onde_estuda"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.serie_cursando}">
				<li class="fieldcontain">
					<span id="serie_cursando-label" class="property-label"><g:message code="usuario.serie_cursando.label" default="Seriecursando" /></span>
					
						<span class="property-value" aria-labelledby="serie_cursando-label"><g:fieldValue bean="${usuarioInstance}" field="serie_cursando"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.rg_numero}">
				<li class="fieldcontain">
					<span id="rg_numero-label" class="property-label"><g:message code="usuario.rg_numero.label" default="Rgnumero" /></span>
					
						<span class="property-value" aria-labelledby="rg_numero-label"><g:fieldValue bean="${usuarioInstance}" field="rg_numero"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.cpf}">
				<li class="fieldcontain">
					<span id="cpf-label" class="property-label"><g:message code="usuario.cpf.label" default="Cpf" /></span>
					
						<span class="property-value" aria-labelledby="cpf-label"><g:fieldValue bean="${usuarioInstance}" field="cpf"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.data_nascimento}">
				<li class="fieldcontain">
					<span id="data_nascimento-label" class="property-label"><g:message code="usuario.data_nascimento.label" default="Datanascimento" /></span>
					
						<span class="property-value" aria-labelledby="data_nascimento-label"><g:formatDate date="${usuarioInstance?.data_nascimento}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.rg_data_expedicao}">
				<li class="fieldcontain">
					<span id="rg_data_expedicao-label" class="property-label"><g:message code="usuario.rg_data_expedicao.label" default="Rgdataexpedicao" /></span>
					
						<span class="property-value" aria-labelledby="rg_data_expedicao-label"><g:formatDate date="${usuarioInstance?.rg_data_expedicao}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.graduado}">
				<li class="fieldcontain">
					<span id="graduado-label" class="property-label"><g:message code="usuario.graduado.label" default="Graduado" /></span>
					
						<span class="property-value" aria-labelledby="graduado-label"><g:fieldValue bean="${usuarioInstance}" field="graduado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.sexo}">
				<li class="fieldcontain">
					<span id="sexo-label" class="property-label"><g:message code="usuario.sexo.label" default="Sexo" /></span>
					
						<span class="property-value" aria-labelledby="sexo-label"><g:fieldValue bean="${usuarioInstance}" field="sexo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="usuario.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${usuarioInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="usuario.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${usuarioInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.clienteAulas}">
				<li class="fieldcontain">
					<span id="clienteAulas-label" class="property-label"><g:message code="usuario.clienteAulas.label" default="Cliente Aulas" /></span>
					
						<g:each in="${usuarioInstance.clienteAulas}" var="c">
						<span class="property-value" aria-labelledby="clienteAulas-label"><g:link controller="aula" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.disciplinas}">
				<li class="fieldcontain">
					<span id="disciplinas-label" class="property-label"><g:message code="usuario.disciplinas.label" default="Disciplinas" /></span>
					
						<g:each in="${usuarioInstance.disciplinas}" var="d">
						<span class="property-value" aria-labelledby="disciplinas-label"><g:link controller="disciplina" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="usuario.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${usuarioInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="usuario.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${usuarioInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.professorAulas}">
				<li class="fieldcontain">
					<span id="professorAulas-label" class="property-label"><g:message code="usuario.professorAulas.label" default="Professor Aulas" /></span>
					
						<g:each in="${usuarioInstance.professorAulas}" var="p">
						<span class="property-value" aria-labelledby="professorAulas-label"><g:link controller="aula" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:usuarioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${usuarioInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
