package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HistoricoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Historico.list(params), model:[historicoInstanceCount: Historico.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Historico historicoInstance) {
        respond historicoInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
        respond new Historico(params)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Historico historicoInstance) {
        if (historicoInstance == null) {
            notFound()
            return
        }

        if (historicoInstance.hasErrors()) {
            respond historicoInstance.errors, view:'create'
            return
        }

        historicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'historico.label', default: 'Historico'), historicoInstance.id])
                redirect historicoInstance
            }
            '*' { respond historicoInstance, [status: CREATED] }
        }
    }
	@Secured(['ROLE_USER'])
    def edit(Historico historicoInstance) {
        respond historicoInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Historico historicoInstance) {
        if (historicoInstance == null) {
            notFound()
            return
        }

        if (historicoInstance.hasErrors()) {
            respond historicoInstance.errors, view:'edit'
            return
        }

        historicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Historico.label', default: 'Historico'), historicoInstance.id])
                redirect historicoInstance
            }
            '*'{ respond historicoInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Historico historicoInstance) {

        if (historicoInstance == null) {
            notFound()
            return
        }

        historicoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Historico.label', default: 'Historico'), historicoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'historico.label', default: 'Historico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
