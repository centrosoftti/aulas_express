package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AdministracaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Administracao.list(params), model:[administracaoInstanceCount: Administracao.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Administracao administracaoInstance) {
        respond administracaoInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
        respond new Administracao(params)
    }

    @Transactional
	@Secured(['ROLE_USER'])
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
    }

	@Secured(['ROLE_USER'])
    def edit(Administracao administracaoInstance) {
        respond administracaoInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
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
    }

    @Transactional
	@Secured(['ROLE_USER'])
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
	@Secured(['ROLE_USER'])
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
