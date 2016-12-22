package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DisciplinaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        
		def jsonResponse = ['response':['status':0,'data':Disciplina.list(params), model:[disciplinaInstanceCount: Disciplina.count()]]]
		render jsonResponse as JSON
		respond jsonResponse
    }

	@Secured(['ROLE_USER'])
    def show(Disciplina disciplinaInstance) {
		def jsonResponse = ['response':['status':0,'data':disciplinaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
//        respond disciplinaInstance
    }

	@Secured(['ROLE_USER'])
    def create() {
        respond save(new Disciplina(params))
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Disciplina disciplinaInstance) {
		println "Entrei no save disciplina..."
        if (disciplinaInstance == null) {
            notFound()
            return
        }

        if (disciplinaInstance.hasErrors()) {
            respond disciplinaInstance.errors, view:'create'
            return
        }

        disciplinaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'disciplina.label', default: 'Disciplina'), disciplinaInstance.id])
                redirect disciplinaInstance
            }
            '*' { respond disciplinaInstance, [status: CREATED] }
        }
		
		def jsonResponse = ['response':['status':0,'data':disciplinaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

	@Secured(['ROLE_USER'])
    def edit(Disciplina disciplinaInstance) {
        respond disciplinaInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Disciplina disciplinaInstance) {
        if (disciplinaInstance == null) {
            notFound()
            return
        }

        if (disciplinaInstance.hasErrors()) {
            respond disciplinaInstance.errors, view:'edit'
            return
        }

        disciplinaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Disciplina.label', default: 'Disciplina'), disciplinaInstance.id])
                redirect disciplinaInstance
            }
            '*'{ respond disciplinaInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Disciplina disciplinaInstance) {

        if (disciplinaInstance == null) {
            notFound()
            return
        }

        disciplinaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Disciplina.label', default: 'Disciplina'), disciplinaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'disciplina.label', default: 'Disciplina'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
