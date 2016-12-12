package aulas_express



import static org.springframework.http.HttpStatus.*
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
        respond new Aula(params)
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
