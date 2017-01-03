package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional
import org.example.Usuario

@Transactional(readOnly = true)
class DisponibilidadeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Disponibilidade.list(params), model:[disponibilidadeInstanceCount: Disponibilidade.count()]
    }
    def show(Disponibilidade disponibilidadeInstance) {
        respond disponibilidadeInstance
    }
    def create() {
		def disponibilidade = new Disponibilidade(params)
		
		if(params.idProfessor)
			disponibilidade.professor = Usuario.get(params.idProfessor)
			
		respond save(disponibilidade)
//        respond new Disponibilidade(params)
    }

    @Transactional
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
		
		def jsonResponse = ['response':['status':0,'data':disponibilidadeInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
    def edit(Disponibilidade disponibilidadeInstance) {
        respond disponibilidadeInstance
    }

    @Transactional
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
		
		def jsonResponse = ['response':['status':0,'data':disponibilidadeInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
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
