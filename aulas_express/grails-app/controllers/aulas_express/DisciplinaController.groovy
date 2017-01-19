package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DisciplinaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 30, 100)
        
		def jsonResponse = ['response':['status':0,'data':Disciplina.list(params), model:[disciplinaInstanceCount: Disciplina.count()]]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    def show(Disciplina disciplinaInstance) {
		def jsonResponse = ['response':['status':0,'data':disciplinaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
//        respond disciplinaInstance
    }

	@Transactional
    def create() {
        respond save(new Disciplina(params))
    }

    @Transactional
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

    def edit(Disciplina disciplinaInstance) {
        respond disciplinaInstance
    }

    @Transactional
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
