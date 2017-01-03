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

    def edit(Administracao administracaoInstance) {
        respond administracaoInstance
    }

    @Transactional
    def update(Administracao administracaoInstance) {
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
}
