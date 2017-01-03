package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional
import org.example.Usuario

@Transactional(readOnly = true)
class ExperienciaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Experiencia.list(params), model:[experienciaInstanceCount: Experiencia.count()]
    }
    def show(Experiencia experienciaInstance) {
        respond experienciaInstance
    }
    def create() {
		
		def experiencia = new Experiencia(params)
		
		if(params.idProfessor)
			experiencia.professor = Usuario.get(params.idProfessor)
			
		respond save(experiencia)
//        respond new Experiencia(params)
    }

    @Transactional
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
		
		def jsonResponse = ['response':['status':0,'data':experienciaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
    def edit(Experiencia experienciaInstance) {
        respond experienciaInstance
    }

    @Transactional
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
		
		def jsonResponse = ['response':['status':0,'data':experienciaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
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
