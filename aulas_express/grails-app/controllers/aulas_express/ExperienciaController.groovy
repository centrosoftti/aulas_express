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
		def jsonResponse = ['response':['status':0,'data':experienciaInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	
	@Transactional
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
	
	@Transactional
    def edit(Experiencia experienciaInstance) {
		println "Entrei editar Experiencia..."
		println "Params: ${params}"
		println "ExperienciaInstance: ${experienciaInstance}"
		
		experienciaInstance.properties = params
		
        respond update(experienciaInstance)
    }

    @Transactional
    def update(Experiencia experienciaInstance) {
		println "Entrei no update da Experiencia..."
		
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
		
		println "Salvou experienciaInstance editada: ${experienciaInstance}"
		
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
	
	def experienciaporprofessor()
	{
		println "Entrei nas experiencias por id professor..."
		println request.method
		println "Params: ${params}"
		
		def experiencias = null
		if(params.idUsuario)
		{
			println "Entrei nas params experiencias por id professor..."
			def e = Experiencia.createCriteria()
			experiencias = e{
				if (params.idUsuario)
					eq("professor.id", params.idUsuario.toLong())
			}
		}
		println "Experiencia por ID Professor: ${experiencias}"
		
		def retorno = []
		experiencias.each {exp ->
			retorno.add(
				[
					"id": exp.id,
					"professor":exp.professor,
					"formacao":exp.formacao,
					"empregador_atual":exp.empregador_atual,
					"ocupacao":exp.ocupacao,
					"postal_code": exp.postal_code,
					"endereco": exp.endereco,
					"cidade": exp.cidade,
					"estado": exp.estado,
					"telefone": exp.telefone,
					"apresentacao": exp.apresentacao
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
}
