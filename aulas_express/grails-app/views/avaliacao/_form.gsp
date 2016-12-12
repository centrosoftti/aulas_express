<%@ page import="aulas_express.Avaliacao" %>



<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="avaliacao.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${org.example.Usuario.list()}" optionKey="id" required="" value="${avaliacaoInstance?.usuario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'tipoAvaliacao', 'error')} required">
	<label for="tipoAvaliacao">
		<g:message code="avaliacao.tipoAvaliacao.label" default="Tipo Avaliacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tipoAvaliacao" type="number" value="${avaliacaoInstance.tipoAvaliacao}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'nota', 'error')} required">
	<label for="nota">
		<g:message code="avaliacao.nota.label" default="Nota" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nota" type="number" value="${avaliacaoInstance.nota}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: avaliacaoInstance, field: 'observacao', 'error')} ">
	<label for="observacao">
		<g:message code="avaliacao.observacao.label" default="Observacao" />
		
	</label>
	<g:textField name="observacao" value="${avaliacaoInstance?.observacao}"/>

</div>

