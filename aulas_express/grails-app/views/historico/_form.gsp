<%@ page import="aulas_express.Historico" %>



<div class="fieldcontain ${hasErrors(bean: historicoInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="historico.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${org.example.Usuario.list()}" optionKey="id" required="" value="${historicoInstance?.usuario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: historicoInstance, field: 'acao', 'error')} required">
	<label for="acao">
		<g:message code="historico.acao.label" default="Acao" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="acao" type="number" value="${historicoInstance.acao}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: historicoInstance, field: 'data_hora', 'error')} required">
	<label for="data_hora">
		<g:message code="historico.data_hora.label" default="Datahora" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data_hora" precision="day"  value="${historicoInstance?.data_hora}"  />

</div>

