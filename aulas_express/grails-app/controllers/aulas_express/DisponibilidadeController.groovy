package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DisponibilidadeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Disponibilidade.list(params), model:[disponibilidadeInstanceCount: Disponibilidade.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Disponibilidade disponibilidadeInstance) {
        respond disponibilidadeInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
        respond new Disponibilidade(params)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Disponibilidade disponibilidadeInstance) {
        if (disponibilidadeInstance == null) {
            notFound()
            return
        }

        if (disponibilidadeInstance.hasErrors()) {
            respond disponibilidadeInstance.errors, view:'create'
            return
        }

        disponibilidadeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'disponibilidade.label', default: 'Disponibilidade'), disponibilidadeInstance.id])
                redirect disponibilidadeInstance
            }
            '*' { respond disponibilidadeInstance, [status: CREATED] }
        }
    }
	@Secured(['ROLE_USER'])
    def edit(Disponibilidade disponibilidadeInstance) {
        respond disponibilidadeInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Disponibilidade disponibilidadeInstance) {
        if (disponibilidadeInstance == null) {
            notFound()
            return
        }

        if (disponibilidadeInstance.hasErrors()) {
            respond disponibilidadeInstance.errors, view:'edit'
            return
        }

        disponibilidadeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Disponibilidade.label', default: 'Disponibilidade'), disponibilidadeInstance.id])
                redirect disponibilidadeInstance
            }
            '*'{ respond disponibilidadeInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Disponibilidade disponibilidadeInstance) {

        if (disponibilidadeInstance == null) {
            notFound()
            return
        }

        disponibilidadeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Disponibilidade.label', default: 'Disponibilidade'), disponibilidadeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'disponibilidade.label', default: 'Disponibilidade'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
