package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)

class AulaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Aula.list(params), model:[aulaInstanceCount: Aula.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Aula aulaInstance) {
        respond aulaInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
		def aula = new Aula(params)
		
		if(params.idCliente)
			aula.cliente = Usuario.get(params.idCliente)
		
        respond aula
    }
	@Secured(['ROLE_USER'])
	def aulasporcliente() {
		println "Entrei nas aulas por cliente..."
		println request.method
		println "Params: ${params}"
		
		def aulas = null
		if(params.idCliente)
		{
			println "Entrei nas params aulas..."
			def a = Aula.createCriteria()
			aulas = a{
				println "Entrei nas criterias aulas..."
				if (params.idCliente)
					eq("cliente.id", params.idCliente.toLong())
			}
		}
		println "AulasPorCliente: ${aulas}"
		
		def retorno = []
		aulas.each {apc ->
			retorno.add(
				[
					"id":apc.id,
					"nome_cliente":apc.cliente.first_name + ' ' + apc.cliente.last_name,
					"nome_professor":apc.professor.first_name + ' ' + apc.professor.last_name,
					"data_hora":apc.data_hora,
					"status":apc.status,
					"quantidade_alunos":apc.quantidade_alunos,
					"quantidade_horas":apc.quantidade_horas,
					"valorAula":apc.valorAula,
					"observacao":apc.observacao
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
	
	@Secured(['ROLE_USER'])
	def aulasporprofessor() {
		println "Entrei nas aulas..."
		println request.method
		println "Params: ${params}"
		
		def aulas = null
		if(params.idProfessor)
		{
			println "Entrei nas params aulas..."
			def a = Aula.createCriteria()
			aulas = a{
				println "Entrei nas criterias aulas..."
				if (params.idProfessor)
					eq("professor.id", params.idProfessor.toLong())
			}
		}
		println "AulasPorProfessor: ${aulas}"
		def retorno = []
		aulas.each {app ->
			retorno.add(
				[
					"id":app.id,
					"nome_cliente":app.cliente.first_name + ' ' + app.cliente.last_name,
					"nome_professor":app.professor.first_name + ' ' + app.professor.last_name,
					"data_hora":app.data_hora,
					"status":app.status,
					"quantidade_alunos":app.quantidade_alunos,
					"quantidade_horas":app.quantidade_horas,
					"valorAula":app.valorAula,
					"observacao":app.observacao
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Aula aulaInstance) {
        if (aulaInstance == null) {
            notFound()
            return
        }

        if (aulaInstance.hasErrors()) {
            respond aulaInstance.errors, view:'create'
            return
        }

        aulaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aula.label', default: 'Aula'), aulaInstance.id])
                redirect aulaInstance
            }
            '*' { respond aulaInstance, [status: CREATED] }
        }
    }
	@Secured(['ROLE_USER'])
    def edit(Aula aulaInstance) {
        respond aulaInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Aula aulaInstance) {
        if (aulaInstance == null) {
            notFound()
            return
        }

        if (aulaInstance.hasErrors()) {
            respond aulaInstance.errors, view:'edit'
            return
        }

        aulaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Aula.label', default: 'Aula'), aulaInstance.id])
                redirect aulaInstance
            }
            '*'{ respond aulaInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Aula aulaInstance) {

        if (aulaInstance == null) {
            notFound()
            return
        }

        aulaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Aula.label', default: 'Aula'), aulaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aula.label', default: 'Aula'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
