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
        def jsonResponse = ['response':['status':0,'data':disponibilidadeInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	
	@Transactional
    def create() {
		def disponibilidade = new Disponibilidade(params)
		
		if(params.idProfessor)
			disponibilidade.professor = Usuario.get(params.idProfessor)
			
		respond save(disponibilidade)
//        respond new Disponibilidade(params)
    }
	
	@Transactional
	def createDisponibilidade(long idProfessor) {
		def disponibilidade = new Disponibilidade(params)
		
		if(idProfessor)
			disponibilidade.professor = Usuario.get(idProfessor)
		
		disponibilidade.ativo = 0
		disponibilidade.latitude = -15.874205
		disponibilidade.longitude = -48.088954
		
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
	
	@Transactional
    def edit(Disponibilidade disponibilidadeInstance) {
		println "Entrei no editar Disponibilidade..."
		println "Params: ${params}"
		println "DisponibilidadeInstance: ${disponibilidadeInstance}"
		
		disponibilidadeInstance.properties = params
		
        respond update(disponibilidadeInstance)
    }

    @Transactional
    def update(Disponibilidade disponibilidadeInstance) {
		println "Entrei update do Disponibilidade..."
		
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
		
		println "Salvou disponibilidadeInstance editada: ${disponibilidadeInstance}"
		
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
