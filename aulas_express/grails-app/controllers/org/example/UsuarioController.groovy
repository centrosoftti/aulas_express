package org.example



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

import java.sql.Timestamp

import aulas_express.Disciplina
import aulas_express.Disponibilidade;
import aulas_express.DisponibilidadeController;

@Transactional(readOnly = true)
class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def jsonResponse = ['response':['status':0,'data':Usuario.list(params), model:[usuarioInstanceCount: Usuario.count()]]]
		render jsonResponse as JSON
		respond jsonResponse
    }
    def show(Usuario usuarioInstance) {
//        respond usuarioInstance
		def jsonResponse = ['response':['status':0,'data':usuarioInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }
	
	@Transactional
    def create() {
		
		def usuario = new Usuario(params);
		
		def perfil = Perfil.get(3);
		if(params.perfilUsuario)
			perfil = Perfil.get(params.perfilUsuario)
		
		println "Perfil: ${perfil}"
        respond save(usuario, perfil)
    }

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
    def save(Usuario usuarioInstance, Perfil perfilInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }
		
		if (perfilInstance == null) {
			notFound()
			return
		}

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

        usuarioInstance.save flush:true
		
		println "PerfilInstance: ${perfilInstance}"
		println "UsuarioInstance: ${usuarioInstance}"

		UsuarioPerfil.create(usuarioInstance, perfilInstance, true);
		
		if(perfilInstance.authority == 'ROLE_PROF')
		{	
			DisponibilidadeController disponibilidadeController = new DisponibilidadeController()
			disponibilidadeController.createDisponibilidade(usuarioInstance.id)
		}
		
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
	
	@Transactional
    def edit(Usuario usuarioInstance) {
		println "Entrei editar professor com disciplina..."
		println "Params: ${params}"
		println "UsuarioInstance: ${usuarioInstance}"
		
		
		usuarioInstance.properties = params
		
		if(params.dataNascimentoLong){
			usuarioInstance.data_nascimento = new Timestamp(params.dataNascimentoLong.toLong())
			println "Data Convertida: $usuarioInstance.data_nascimento}"
		}
		
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
    def update(Usuario usuarioInstance) {
		println "Entrei update do Usuario..."
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
		
		println "Salvou UsuarioInstance editado: ${usuarioInstance}"
		
		def jsonResponse = ['response':['status':0,'data':usuarioInstance]]
		render jsonResponse as JSON
		respond jsonResponse
    }

    @Transactional
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

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def mylogin(){
		println "Entrei no login usuario na mao..."
		println "Params: ${params}"
		
		def usuarios = null
		if(params.username && params.password)
		{
			println "Entrei nas params usuarios..."
			def u = Usuario.createCriteria()
			usuarios = u{
				println "Entrei nas criterias usuarios..."
				if (params.username)
					eq("username", params.username)
				if (params.password)
					eq("password", params.password)
			}
		}
		println "Usuarios: ${usuarios}"
		
		def retorno = []
		usuarios.each {usuario ->
			retorno.add(
				[
					"id":usuario.id,
					"username":usuario.username,
					"nome_usuario":usuario.first_name + ' ' + usuario.last_name,
					"perfil": usuario.getAuthorities()
				]
			)
		}
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
	
	@Transactional
	def disponibilidadeporidprofessor()
	{
		println "Entrei nas disponibilidades por id professor..."
		println request.method
		println "Params: ${params}"
		
		def disponibilidades = null
		def usuarioLogado = null
		if(params.idUsuario)
		{
			println "Entrei nas params disponibilidades por id professor..."
			
			usuarioLogado = Usuario.get(params.idUsuario)
			
		}
		def retorno = []
		if(usuarioLogado)
		{
			if(!usuarioLogado.disponibilidade)
			{
				Disponibilidade novaDisponibilidade = new Disponibilidade()
				novaDisponibilidade.ativo = 0
				novaDisponibilidade.save flush:true
				
				usuarioLogado.disponibilidade = novaDisponibilidade
				usuarioLogado.save flush:true
			}
			
			retorno.add(
				[
					"id": usuarioLogado.disponibilidade.id,
					"ativo":usuarioLogado.disponibilidade.ativo,
					"latitude":usuarioLogado.disponibilidade.latitude,
					"longitude":usuarioLogado.disponibilidade.longitude,
					"cidade":usuarioLogado.disponibilidade.cidade
				]
			)
		}
		
		println "Disponibilidade por ID Professor: ${disponibilidades}"
		
		println "Retorno: ${retorno}"
		def jsonResponse = ['response':['status':0,'data':retorno]]
		render jsonResponse as JSON
		respond jsonResponse
	}
}
