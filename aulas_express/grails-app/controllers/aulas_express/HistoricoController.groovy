package aulas_express



import static org.springframework.http.HttpStatus.*
import enums.AcoesHistoricoEnum;
import grails.converters.JSON
import grails.transaction.Transactional
import org.example.Usuario

import java.sql.Timestamp

@Transactional(readOnly = true)
class HistoricoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Historico.list(params), model:[historicoInstanceCount: Historico.count()]
    }
    def show(Historico historicoInstance) {
        respond historicoInstance
    }
	
	@Transactional
    def create() {
		
		def historico = new Historico(params)
		
		if(params.idUsuario)
			historico.usuario = Usuario.get(params.idUsuario)
			
		historico.data_hora = new Timestamp(data.getTime())
		historico.acao = AcoesHistoricoEnum.ALS.ordinal()
		historico.idAula = params.idAula
		
        respond save(historico)
    }
	
	@Transactional
	def createHistoricoComParametros(long idUsuario, long idAula) {
		
		def historico = new Historico()
		
		if(idUsuario)
			historico.usuario = Usuario.get(idUsuario)
			
		historico.data_hora = new Timestamp((new Date()).getTime())
		historico.acao = AcoesHistoricoEnum.ALS.ordinal()
		historico.idAula = idAula
		
		respond save(historico)
	}

    @Transactional
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
    def edit(Historico historicoInstance) {
        respond historicoInstance
    }

    @Transactional
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
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'historico.label', default: 'Historico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def historicosporusuario() {
		println "Entrei nos historicos por cliente..."
		println request.method
		println "Params: ${params}"
		
		def historicos = null
		if(params.idUsuario)
		{
			println "Entrei nas params historicos..."
			def h = Historico.createCriteria()
			historicos = h{
				if (params.idUsuario)
					eq("usuario.id", params.idUsuario.toLong())
			}
		}
		println "HistoricoPorUsuario: ${historicos}"
		
		def retorno = []
		historicos.each {his ->
			retorno.add(
				[
					"usuario":his.usuario,
					"acao":his.acao,
					"data_hora":his.data_hora,
					"idAula": his.idAula
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
}
