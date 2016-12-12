<%@ page import="aulas_express.Aula" %>



<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'cliente', 'error')} required">
	<label for="cliente">
		<g:message code="aula.cliente.label" default="Cliente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cliente" name="cliente.id" from="${org.example.Usuario.list()}" optionKey="id" required="" value="${aulaInstance?.cliente?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'professor', 'error')} ">
	<label for="professor">
		<g:message code="aula.professor.label" default="Professor" />
		
	</label>
	<g:select id="professor" name="professor.id" from="${org.example.Usuario.list()}" optionKey="id" value="${aulaInstance?.professor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="aula.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="status" type="number" value="${aulaInstance.status}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'quantidade_alunos', 'error')} required">
	<label for="quantidade_alunos">
		<g:message code="aula.quantidade_alunos.label" default="Quantidadealunos" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade_alunos" type="number" value="${aulaInstance.quantidade_alunos}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'quantidade_horas', 'error')} required">
	<label for="quantidade_horas">
		<g:message code="aula.quantidade_horas.label" default="Quantidadehoras" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade_horas" type="number" value="${aulaInstance.quantidade_horas}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'valorAula', 'error')} required">
	<label for="valorAula">
		<g:message code="aula.valorAula.label" default="Valor Aula" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valorAula" value="${fieldValue(bean: aulaInstance, field: 'valorAula')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'observacao', 'error')} ">
	<label for="observacao">
		<g:message code="aula.observacao.label" default="Observacao" />
		
	</label>
	<g:textField name="observacao" value="${aulaInstance?.observacao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: aulaInstance, field: 'data_hora', 'error')} required">
	<label for="data_hora">
		<g:message code="aula.data_hora.label" default="Datahora" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data_hora" precision="day"  value="${aulaInstance?.data_hora}"  />

</div>

