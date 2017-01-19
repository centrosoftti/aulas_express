<%@ page import="aulas_express.Experiencia" %>



<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'professor', 'error')} required">
	<label for="professor">
		<g:message code="experiencia.professor.label" default="Professor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="professor" name="professor.id" from="${org.example.Usuario.list()}" optionKey="id" required="" value="${experienciaInstance?.professor?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'formacao', 'error')} ">
	<label for="formacao">
		<g:message code="experiencia.formacao.label" default="Formacao" />
		
	</label>
	<g:textField name="formacao" value="${experienciaInstance?.formacao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'empregador_atual', 'error')} ">
	<label for="empregador_atual">
		<g:message code="experiencia.empregador_atual.label" default="Empregadoratual" />
		
	</label>
	<g:textField name="empregador_atual" value="${experienciaInstance?.empregador_atual}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'ocupacao', 'error')} ">
	<label for="ocupacao">
		<g:message code="experiencia.ocupacao.label" default="Ocupacao" />
		
	</label>
	<g:textField name="ocupacao" value="${experienciaInstance?.ocupacao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'endereco', 'error')} ">
	<label for="endereco">
		<g:message code="experiencia.endereco.label" default="Endereco" />
		
	</label>
	<g:textField name="endereco" value="${experienciaInstance?.endereco}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'cidade', 'error')} ">
	<label for="cidade">
		<g:message code="experiencia.cidade.label" default="Cidade" />
		
	</label>
	<g:textField name="cidade" value="${experienciaInstance?.cidade}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'estado', 'error')} ">
	<label for="estado">
		<g:message code="experiencia.estado.label" default="Estado" />
		
	</label>
	<g:textField name="estado" value="${experienciaInstance?.estado}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experienciaInstance, field: 'telefone', 'error')} ">
	<label for="telefone">
		<g:message code="experiencia.telefone.label" default="Telefone" />
		
	</label>
	<g:textField name="telefone" value="${experienciaInstance?.telefone}"/>

</div>


