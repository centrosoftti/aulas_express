<%@ page import="aulas_express.Administracao" %>



<div class="fieldcontain ${hasErrors(bean: administracaoInstance, field: 'raioProfessor', 'error')} required">
	<label for="raioProfessor">
		<g:message code="administracao.raioProfessor.label" default="Raio Professor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="raioProfessor" type="number" value="${administracaoInstance.raioProfessor}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: administracaoInstance, field: 'valorAulaGraduado', 'error')} required">
	<label for="valorAulaGraduado">
		<g:message code="administracao.valorAulaGraduado.label" default="Valor Aula Graduado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valorAulaGraduado" value="${fieldValue(bean: administracaoInstance, field: 'valorAulaGraduado')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: administracaoInstance, field: 'valorAulaNaoGraduado', 'error')} required">
	<label for="valorAulaNaoGraduado">
		<g:message code="administracao.valorAulaNaoGraduado.label" default="Valor Aula Nao Graduado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valorAulaNaoGraduado" value="${fieldValue(bean: administracaoInstance, field: 'valorAulaNaoGraduado')}" required=""/>

</div>

