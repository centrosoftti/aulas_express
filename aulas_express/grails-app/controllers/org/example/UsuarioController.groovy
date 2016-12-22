package org.example



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import aulas_express.Disciplina

@Transactional(readOnly = true)
class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def jsonResponse = ['response':['status':0,'data':Usuario.list(params), model:[usuarioInstanceCount: Usuario.count()]]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	@Secured(['ROLE_USER'])
    def show(Usuario usuarioInstance) {
//        respond usuarioInstance
		def jsonResponse = ['response':['status':0,'data':usuarioInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	@Secured(['ROLE_USER'])
    def create() {
        respond new Usuario(params)
    }

	@Secured(['ROLE_USER'])
	def professorespordisciplina() {
		println "Entrei nos professores por disciplina..."
		println "Params: ${params}"
		
		def professores = null
		if(params.idDisciplina)
		{
			def p = Usuario.createCriteria()
			professores = p.list {
				disciplinas {
					eq("id", params.idDisciplina.toLong())
				}
			}
		}
		println "ProfessoresPorDisciplina: ${professores}"
		def retorno = []
		professores.each {prf ->
			retorno.add(
				[
					"id":prf.id,
					"nome":prf.first_name + ' ' + prf.last_name
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
	
    @Transactional
	@Secured(['ROLE_USER'])
    def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

        usuarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
		
		def jsonResponse = ['response':['status':0,'data':usuarioInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	@Secured(['ROLE_USER'])
    def edit(Usuario usuarioInstance) {
		println "Entrei editar professor com disciplina..."
		println "Params: ${params}"
		println "UsuarioInstance: ${usuarioInstance}"
		if (params.disciplinas)
		{
			params.disciplinas.each {idDisciplina ->
				
				def disciplina = Disciplina.get(idDisciplina)
				usuarioInstance.addToDisciplinas(disciplina)
				
//				if(!disciplina.equals(Perfil.get(3)))
//				{
//					UsuarioPerfil up = UsuarioPerfil.create(obj, perfil, true)
//					perfisSet.add(perfil)
//				}
			}
		}
		
        respond update(usuarioInstance)
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'edit'
            return
        }

        usuarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*'{ respond usuarioInstance, [status: OK] }
        }
		
		def jsonResponse = ['response':['status':0,'data':usuarioInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
	@Secured(['ROLE_USER'])
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

	@Secured(['ROLE_USER'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
