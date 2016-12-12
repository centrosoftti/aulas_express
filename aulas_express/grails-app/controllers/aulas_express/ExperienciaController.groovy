package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ExperienciaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Experiencia.list(params), model:[experienciaInstanceCount: Experiencia.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Experiencia experienciaInstance) {
        respond experienciaInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
        respond new Experiencia(params)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Experiencia experienciaInstance) {
        if (experienciaInstance == null) {
            notFound()
            return
        }

        if (experienciaInstance.hasErrors()) {
            respond experienciaInstance.errors, view:'create'
            return
        }

        experienciaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'experiencia.label', default: 'Experiencia'), experienciaInstance.id])
                redirect experienciaInstance
            }
            '*' { respond experienciaInstance, [status: CREATED] }
        }
    }
	@Secured(['ROLE_USER'])
    def edit(Experiencia experienciaInstance) {
        respond experienciaInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Experiencia experienciaInstance) {
        if (experienciaInstance == null) {
            notFound()
            return
        }

        if (experienciaInstance.hasErrors()) {
            respond experienciaInstance.errors, view:'edit'
            return
        }

        experienciaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Experiencia.label', default: 'Experiencia'), experienciaInstance.id])
                redirect experienciaInstance
            }
            '*'{ respond experienciaInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Experiencia experienciaInstance) {

        if (experienciaInstance == null) {
            notFound()
            return
        }

        experienciaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Experiencia.label', default: 'Experiencia'), experienciaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'experiencia.label', default: 'Experiencia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
