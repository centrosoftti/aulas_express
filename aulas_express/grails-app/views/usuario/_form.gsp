<%@ page import="org.example.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="usuario.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${usuarioInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${usuarioInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="usuario.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${usuarioInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'first_name', 'error')} required">
	<label for="first_name">
		<g:message code="usuario.first_name.label" default="Firstname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="first_name" required="" value="${usuarioInstance?.first_name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'last_name', 'error')} required">
	<label for="last_name">
		<g:message code="usuario.last_name.label" default="Lastname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="last_name" required="" value="${usuarioInstance?.last_name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'telefone_celular', 'error')} ">
	<label for="telefone_celular">
		<g:message code="usuario.telefone_celular.label" default="Telefonecelular" />
		
	</label>
	<g:textField name="telefone_celular" value="${usuarioInstance?.telefone_celular}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'telefone_fixo', 'error')} ">
	<label for="telefone_fixo">
		<g:message code="usuario.telefone_fixo.label" default="Telefonefixo" />
		
	</label>
	<g:textField name="telefone_fixo" value="${usuarioInstance?.telefone_fixo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'escola_onde_estuda', 'error')} ">
	<label for="escola_onde_estuda">
		<g:message code="usuario.escola_onde_estuda.label" default="Escolaondeestuda" />
		
	</label>
	<g:textField name="escola_onde_estuda" value="${usuarioInstance?.escola_onde_estuda}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'serie_cursando', 'error')} ">
	<label for="serie_cursando">
		<g:message code="usuario.serie_cursando.label" default="Seriecursando" />
		
	</label>
	<g:textField name="serie_cursando" value="${usuarioInstance?.serie_cursando}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'rg_numero', 'error')} ">
	<label for="rg_numero">
		<g:message code="usuario.rg_numero.label" default="Rgnumero" />
		
	</label>
	<g:textField name="rg_numero" value="${usuarioInstance?.rg_numero}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'cpf', 'error')} ">
	<label for="cpf">
		<g:message code="usuario.cpf.label" default="Cpf" />
		
	</label>
	<g:textField name="cpf" value="${usuarioInstance?.cpf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'data_nascimento', 'error')} ">
	<label for="data_nascimento">
		<g:message code="usuario.data_nascimento.label" default="Datanascimento" />
		
	</label>
	<g:datePicker name="data_nascimento" precision="day"  value="${usuarioInstance?.data_nascimento}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'rg_data_expedicao', 'error')} ">
	<label for="rg_data_expedicao">
		<g:message code="usuario.rg_data_expedicao.label" default="Rgdataexpedicao" />
		
	</label>
	<g:datePicker name="rg_data_expedicao" precision="day"  value="${usuarioInstance?.rg_data_expedicao}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'graduado', 'error')} ">
	<label for="graduado">
		<g:message code="usuario.graduado.label" default="Graduado" />
		
	</label>
	<g:field name="graduado" type="number" value="${usuarioInstance.graduado}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'sexo', 'error')} ">
	<label for="sexo">
		<g:message code="usuario.sexo.label" default="Sexo" />
		
	</label>
	<g:field name="sexo" type="number" value="${usuarioInstance.sexo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="usuario.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${usuarioInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="usuario.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${usuarioInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'clienteAulas', 'error')} ">
	<label for="clienteAulas">
		<g:message code="usuario.clienteAulas.label" default="Cliente Aulas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${usuarioInstance?.clienteAulas?}" var="c">
    <li><g:link controller="aula" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="aula" action="create" params="['usuario.id': usuarioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'aula.label', default: 'Aula')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'disciplinas', 'error')} ">
	<label for="disciplinas">
		<g:message code="usuario.disciplinas.label" default="Disciplinas" />
		
	</label>
	<g:select name="disciplinas" from="${aulas_express.Disciplina.list()}" multiple="multiple" optionKey="id" size="5" value="${usuarioInstance?.disciplinas*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="usuario.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${usuarioInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="usuario.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${usuarioInstance?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'professorAulas', 'error')} ">
	<label for="professorAulas">
		<g:message code="usuario.professorAulas.label" default="Professor Aulas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${usuarioInstance?.professorAulas?}" var="p">
    <li><g:link controller="aula" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="aula" action="create" params="['usuario.id': usuarioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'aula.label', default: 'Aula')])}</g:link>
</li>
</ul>


</div>

