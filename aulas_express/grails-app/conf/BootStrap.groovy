import aulas_express.Administracao
import aulas_express.Aula
import aulas_express.Avaliacao
import aulas_express.Disciplina
import aulas_express.Disponibilidade
import aulas_express.Experiencia
import aulas_express.Historico
import java.sql.Timestamp
import org.example.Perfil
import org.example.Usuario
import org.example.UsuarioPerfil

class BootStrap {

	def springSecurityService
	def adminUser
	
	def professorUser
	def professorUser2
	
	def usuarioUser
	def usuarioUser2
	
	def disciplina1
	def disciplina2
	def disciplina3
	
    def init = { servletContext ->
		
		println "Bootstrap de dados do BD";
		//Dados gerais previos carregados para todos os ambientes
//		carregarDadosIniciaisParaTodosOsAmbientes();
		 
		
		environments {
			production {
				carregaDadosDeProducao();
			}
			development {
				carregaDadosDeDesenvolvimento();
			}

		}
		
		//Dados gerais carregados para todos os ambientes apos a carga especifica de cada ambiente
//		carregarDadosFinaisParaTodosOsAmbientes();
    }
	
	
    def destroy = {
    }
	
	private void carregarDadosIniciaisParaTodosOsAmbientes(){
	
	}
	
	private void carregaDadosDeProducao(){
		carregaDisciplinas();
		criarUsuarios();
		carregaAdministracao();
		carregaAulas();
		carregaAvaliacao();
		carregaDisponibilidade();
		carregaExperiencia();
		carregaHistorico();
	}
	
//	private void criarUsuarios()
//	{
//		println "Carregando usuarios..."
//				
//		def adminPerfil = new Perfil(authority: 'ROLE_ADMIN',descricao:"Administrador").save(flush: true)
//		def professorPerfil = new Perfil(authority: 'ROLE_PROF',descricao:"Professor").save(flush: true)
//		def usuarioComumPerfil = new Perfil(authority: 'ROLE_USER',descricao:"Aluno").save(flush: true)
//		
//		
//		String password = springSecurityService.encodePassword('1234')
//			
//		adminUser = new Usuario(username: 'admin', enabled: true, email: 'admin@test.com', first_name: 'Andre', last_name: 'Passos', password: '1234')
//		adminUser.save(flush: true)
//		
//		UsuarioPerfil.create(adminUser, adminPerfil, true)
//		
//		disciplina1 = new Disciplina(
//			nome:"Matemática").save();
//		
//		disciplina2 = new Disciplina(
//			nome:"Português").save();
//		
//		disciplina3 = new Disciplina(
//			nome:"Geografia").save();
//		
//		professorUser = new Usuario(username: 'professor', 
//			enabled: true, 
//			email: 'professor@test.com', 
//			first_name: 'Jean', 
//			last_name: 'Travassos', 
//			password: '1234')
//		.addToDisciplinas(disciplina1)
//        .addToDisciplinas(disciplina2)
//        .save(flush: true)
////		professorUser.save(flush: true)
//		
//		professorUser2 = new Usuario(username: 'professor2',
//			enabled: true,
//			email: 'professor2@test.com',
//			first_name: 'Tia Leo',
//			last_name: 'Travassos',
//			password: '1234')
//		.addToDisciplinas(disciplina3)
//		.save(flush: true)
////		professorUser.save(flush: true)
//		
//		UsuarioPerfil.create(professorUser, professorPerfil, true)
//		UsuarioPerfil.create(professorUser2, professorPerfil, true)
//		
//
//		usuarioUser = new Usuario(username: 'aluno', enabled: true, email: 'thiago@test.com', first_name: 'Thiago', last_name: 'Albuquerque', password: '1234')
//		usuarioUser.save(flush: true)
//		
//		UsuarioPerfil.create(usuarioUser, usuarioComumPerfil, true)
//		
//		usuarioUser2 = new Usuario(username: 'aluno2', enabled: true, email: 'thiago@test.com', first_name: 'Leandro', last_name: 'Coutinho', password: '1234')
//		usuarioUser2.save(flush: true)
//		
//		UsuarioPerfil.create(usuarioUser2, usuarioComumPerfil, true)
//		
//		assert Usuario.count() == 5
//		assert Perfil.count() == 3
//		assert UsuarioPerfil.count() == 5
//
//	}
	
	private void criarUsuarios()
	{
		println "Carregando usuarios..."
				
		def adminPerfil = new Perfil(authority: 'ROLE_ADMIN',descricao:"Administrador").save()
		def professorPerfil = new Perfil(authority: 'ROLE_PROF',descricao:"Professor").save()
		def usuarioComumPerfil = new Perfil(authority: 'ROLE_USER',descricao:"Aluno").save()
		
		
		String password = springSecurityService.encodePassword('1234')
			
		adminUser = new Usuario(username: 'admin', enabled: true, email: 'admin@test.com', first_name: 'Andre', last_name: 'Passos', password: '1234')
		adminUser.save()
		
		UsuarioPerfil.create(adminUser, adminPerfil, true)
		
		disciplina1 = new Disciplina(
			nome:"Matemática").save();
		
		disciplina2 = new Disciplina(
			nome:"Português").save();
		
		disciplina3 = new Disciplina(
			nome:"Geografia").save();
		
		professorUser = new Usuario(username: 'professor',
			enabled: true,
			email: 'professor@test.com',
			first_name: 'Jean',
			last_name: 'Travassos',
			password: '1234')
		.addToDisciplinas(disciplina1)
		.addToDisciplinas(disciplina2)
		.save(flush: true)
//		professorUser.save(flush: true)
		
		professorUser2 = new Usuario(username: 'professor2',
			enabled: true,
			email: 'professor2@test.com',
			first_name: 'Tia Leo',
			last_name: 'Travassos',
			password: '1234')
		.addToDisciplinas(disciplina3)
		.save()
//		professorUser.save(flush: true)
		
		UsuarioPerfil.create(professorUser, professorPerfil, true)
		UsuarioPerfil.create(professorUser2, professorPerfil, true)
		

		usuarioUser = new Usuario(username: 'aluno', enabled: true, email: 'thiago@test.com', first_name: 'Thiago', last_name: 'Albuquerque', password: '1234')
		usuarioUser.save()
		
		UsuarioPerfil.create(usuarioUser, usuarioComumPerfil, true)
		
		usuarioUser2 = new Usuario(username: 'aluno2', enabled: true, email: 'thiago@test.com', first_name: 'Leandro', last_name: 'Coutinho', password: '1234')
		usuarioUser2.save()
		
		UsuarioPerfil.create(usuarioUser2, usuarioComumPerfil, true)
		
		assert Usuario.count() == 5
		assert Perfil.count() == 3
		assert UsuarioPerfil.count() == 5

	}
	
	private void carregaAdministracao(){
		println "Carregando Administracoes..."
		
		def administracao1 = new Administracao(
			raioProfessor:1000,
			valorAulaGraduado:70.00,
			valorAulaNaoGraduado:50.00).save();
		
		def administracao2 = new Administracao(
			raioProfessor:500,
			valorAulaGraduado:70.00,
			valorAulaNaoGraduado:50.00).save();
		
		assert Administracao.count() == 2
	}
	
	private void carregaAulas(){
		println "Carregando Aulas..."
		
		def aula1 = new Aula(
			cliente:usuarioUser,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:1,
			valorAula:70.00,
			observacao:"").save();
		
		def aula2 = new Aula(
			cliente:usuarioUser,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:2,
			valorAula:50.00,
			observacao:"").save();
		
		def aula3 = new Aula(
			cliente:usuarioUser2,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:2,
			valorAula:50.00,
			observacao:"").save();
		
		assert Aula.count() == 3
	}
	
	private void carregaAvaliacao(){
		println "Carregando Avaliacoes..."
		
		def avaliacao1 = new Avaliacao(
			usuario:usuarioUser,
			tipoAvaliacao:0,
			nota:5,
			observacao:"").save();
		
		def avaliacao2 = new Avaliacao(
			usuario:professorUser,
			tipoAvaliacao:1,
			nota:5,
			observacao:"").save();
		
		assert Avaliacao.count() == 2
	}
	
	private void carregaDisciplinas(){
		//Se for necessario dados especificos para producao, carregar aqui.
		println "Carregando Disciplinas..."
		
		
		
		def disciplina4 = new Disciplina(
			nome:"História").save();
		
		def disciplina5 = new Disciplina(
			nome:"Física").save();
		
		def disciplina6 = new Disciplina(
			nome:"Química").save();
		
		def disciplina7 = new Disciplina(
			nome:"Inglês").save();
		
		def disciplina8 = new Disciplina(
			nome:"Espanhol").save();
		
		def disciplina9 = new Disciplina(
			nome:"Filosofia").save();
		
		def disciplina10 = new Disciplina(
			nome:"Literatura").save();
		
		def disciplina11 = new Disciplina(
			nome:"Artes Plásticas").save();
		
		def disciplina12 = new Disciplina(
			nome:"Artes Visuais").save();
		
		def disciplina13 = new Disciplina(
			nome:"Artes Cênicas").save();
		
		def disciplina14 = new Disciplina(
			nome:"Redação").save();
		
		def disciplina15 = new Disciplina(
			nome:"Educação Física").save();
		
		def disciplina16 = new Disciplina(
			nome:"Biologia").save();
		
		assert Disciplina.count() == 16
		
	//		carregaDadosDeDesenvolvimento();
//		criarUsuarios();
//		carregaDadosDeCredito();
//		carregaDadosProfissionais();
		
	}
	
	private void carregaDisponibilidade(){
		println "Carregando Disponibilidades..."
		
		def disponibilidade1 = new Disponibilidade(
			professor:professorUser,
			ativo:1,
			latitude:-15.86917761,
			longitude:-48.09179306).save();
		
		assert Disponibilidade.count() == 1
	}
	
	private void carregaExperiencia(){
		println "Carregando Experiencias..."
		
		def experiencia1 = new Experiencia(
			professor:professorUser,
			formacao:"",
			empregador_atual:"",
			ocupacao:"",
			postal_code:"",
			endereco:"",
			cidade:"",
			estado:"",
			telefone:"").save();
		
		assert Experiencia.count() == 1
	}
	
	private void carregaHistorico(){
		println "Carregando Historicos..."
		
		def historico1 = new Historico(
			usuario:usuarioUser,
			acao:0,
			status:0,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		def historico2 = new Historico(
			usuario:usuarioUser,
			acao:1,
			status:1,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		def historico3 = new Historico(
			usuario:usuarioUser,
			acao:2,
			status:2,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		assert Historico.count() == 3
	}
	
	private void carregarDadosFinaisParaTodosOsAmbientes(){
		//Se for necessario criar dados apos a carga especifica de ambientes
	}
	
	private void carregaDadosDeDesenvolvimento(){
		criarUsuarios();
		carregaAdministracao();
		carregaAulas();
		carregaAvaliacao();
		carregaDisciplinas();
		carregaDisponibilidade();
		carregaExperiencia();
		carregaHistorico();
	}
}