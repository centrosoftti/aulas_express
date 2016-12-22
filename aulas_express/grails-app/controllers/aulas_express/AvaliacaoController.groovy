package aulas_express



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.example.Usuario

@Transactional(readOnly = true)
class AvaliacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Avaliacao.list(params), model:[avaliacaoInstanceCount: Avaliacao.count()]
    }
	@Secured(['ROLE_USER'])
    def show(Avaliacao avaliacaoInstance) {
        respond avaliacaoInstance
    }
	@Secured(['ROLE_USER'])
    def create() {
		def avaliacao = new Avaliacao(params)
		
		if(params.idUsuario)
			avaliacao.usuario = Usuario.get(params.idUsuario)
			
        respond save(avaliacao)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def save(Avaliacao avaliacaoInstance) {
        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        if (avaliacaoInstance.hasErrors()) {
            respond avaliacaoInstance.errors, view:'create'
            return
        }

        avaliacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect avaliacaoInstance
            }
            '*' { respond avaliacaoInstance, [status: CREATED] }
        }
		def jsonResponse = ['response':['status':0,'data':avaliacaoInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

	@Secured(['ROLE_USER'])
    def edit(Avaliacao avaliacaoInstance) {
        respond avaliacaoInstance
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Avaliacao avaliacaoInstance) {
        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        if (avaliacaoInstance.hasErrors()) {
            respond avaliacaoInstance.errors, view:'edit'
            return
        }

        avaliacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect avaliacaoInstance
            }
            '*'{ respond avaliacaoInstance, [status: OK] }
        }
		
		def jsonResponse = ['response':['status':0,'data':avaliacaoInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Avaliacao avaliacaoInstance) {

        if (avaliacaoInstance == null) {
            notFound()
            return
        }

        avaliacaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Avaliacao.label', default: 'Avaliacao'), avaliacaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'avaliacao.label', default: 'Avaliacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
