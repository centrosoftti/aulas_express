package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AdministracaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Administracao.list(params), model:[administracaoInstanceCount: Administracao.count()]
    }
    def show(Administracao administracaoInstance) {
        respond administracaoInstance
    }
    def create() {
        respond save(new Administracao(params))
    }

    @Transactional
    def save(Administracao administracaoInstance) {
        if (administracaoInstance == null) {
            notFound()
            return
        }

        if (administracaoInstance.hasErrors()) {
            respond administracaoInstance.errors, view:'create'
            return
        }

        administracaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'administracao.label', default: 'Administracao'), administracaoInstance.id])
                redirect administracaoInstance
            }
            '*' { respond administracaoInstance, [status: CREATED] }
        }
		
		def jsonResponse = ['response':['status':0,'data':administracaoInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

	@Transactional
    def edit(Administracao administracaoInstance) {
		println "Entrei editar Administracao..."
		println "Params: ${params}"
		println "AdministracaoInstance: ${administracaoInstance}"
		
		administracaoInstance.properties = params
		
        respond administracaoInstance
    }

    @Transactional
    def update(Administracao administracaoInstance) {
		println "Entrei no update da Administracao..."
		
        if (administracaoInstance == null) {
            notFound()
            return
        }

        if (administracaoInstance.hasErrors()) {
            respond administracaoInstance.errors, view:'edit'
            return
        }

        administracaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Administracao.label', default: 'Administracao'), administracaoInstance.id])
                redirect administracaoInstance
            }
            '*'{ respond administracaoInstance, [status: OK] }
        }
		
		println "Salvou administracaoInstance editada: ${administracaoInstance}"
		
		def jsonResponse = ['response':['status':0,'data':administracaoInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
    def delete(Administracao administracaoInstance) {

        if (administracaoInstance == null) {
            notFound()
            return
        }

        administracaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Administracao.label', default: 'Administracao'), administracaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'administracao.label', default: 'Administracao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def calcularValorAula(){
		println "Entrei no calcular valor aula..."
		println "Params: ${params}"
		
		def valorTotal = null
		def administracao = Administracao.get(1)
		println "Administracao carregada: ${administracao}"
		
		if(administracao != null)
		{
			def valorAula = 0
			
			println "calcularValorAula graduado: ${params.graduado}"
			println "calcularValorAula graduado.toInteger: ${params.graduado.toInteger()}"
			
			if(params.graduado.toInteger() == 1)
			{
				valorAula = administracao.valorAulaNaoGraduado
			}
			else if(params.graduado.toInteger() == 0)
			{
				valorAula = administracao.valorAulaGraduado
			}
			
			println "calcularValorAula valorAula: ${valorAula}"
			println "calcularValorAula quantidadeAlunos: ${params.quantidadeAlunos.toInteger()}"
			println "calcularValorAula quantidadeHoras: ${params.quantidadeHoras.toInteger()}"
			
			valorTotal = valorAula * params.quantidadeAlunos.toInteger() * params.quantidadeHoras.toInteger()
		}
		
		def jsonResponse = ['response':['status':0,'data':valorTotal]]
		render jsonResponse as JSON
		respond jsonResponse

	}
}
