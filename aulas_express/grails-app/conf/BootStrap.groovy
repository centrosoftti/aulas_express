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

//	def springSecurityService
	def adminUser
	
	def professorUser
	def professorUser2
	
	def usuarioUser
	def usuarioUser2
	def usuarioAndre
	
	def disciplina1
	def disciplina2
	def disciplina3
	
	def disponibilidade1
	def disponibilidade2
	
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
		carregaDisponibilidade();
		criarUsuarios();
		carregaAdministracao();
		carregaAulas();
//		carregaAvaliacao();
		carregaExperiencia();
		carregaHistorico();
	}
	
	private void carregaDisciplinas(){
		//Se for necessario dados especificos para producao, carregar aqui.
		println "Carregando Disciplinas..."
		
		
		 disciplina1 = new Disciplina(
			nome:"Matemática").save(flush: true);
		
		 disciplina2 = new Disciplina(
			nome:"Português").save(flush: true);
		
		 disciplina3 = new Disciplina(
			nome:"Geografia").save(flush: true);
		
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
			
	}
	
	private void criarUsuarios()
	{
		println "Carregando usuarios..."
				
		def adminPerfil = new Perfil(authority: 'ROLE_ADMIN',descricao:"Administrador").save();
		def professorPerfil = new Perfil(authority: 'ROLE_PROF',descricao:"Professor").save();
		def usuarioComumPerfil = new Perfil(authority: 'ROLE_USER',descricao:"Aluno").save();
		
		
//		String password = springSecurityService.encodePassword('1234')
			
		adminUser = new Usuario(username: 'admin', enabled: true, email: 'admin@test.com', first_name: 'Andre', 
			last_name: 'Passos', password: '1234', telefone_celular: '(61) 4545-2323',
			telefone_fixo: '(61) 7878-9090', rg_numero: '5.567.756',cpf:'908.234.456-45', graduado: 0, sexo: 0);
		adminUser.save(flush: true);
		
		UsuarioPerfil.create(adminUser, adminPerfil, true);
		
		professorUser = new Usuario(username: 'jean',
			enabled: true,
			email: 'jean@aulasexpress.com.br',
			first_name: 'Jean',
			last_name: 'Travassos',
			password: '1234', telefone_celular: '(61) 2345-7589',
			telefone_fixo: '(61) 0796-1342', rg_numero: '5.534.784',cpf:'385.940.735-79', graduado: 0, sexo: 0, disponibilidade:disponibilidade1)
		.addToDisciplinas(disciplina1)
		.addToDisciplinas(disciplina2)
		.save(flush: true);
//		professorUser.save(flush: true)
		UsuarioPerfil.create(professorUser, professorPerfil, true);
		
		professorUser2 = new Usuario(username: 'felipe',
			enabled: true,
			email: 'felipe@aulasexpress.com.br',
			first_name: 'Felipe',
			last_name: 'Tavares',
			password: '1234', telefone_celular: '(61) 7867-3456',
			telefone_fixo: '(61) 1345-8565', rg_numero: '9.645.123',cpf:'457.365.134-05', graduado: 1, sexo: 0)
		.addToDisciplinas(disciplina1)
		.addToDisciplinas(disciplina3)
		.save(flush: true);
//		professorUser.save(flush: true)
		UsuarioPerfil.create(professorUser2, professorPerfil, true);
		

		usuarioUser = new Usuario(username: 'aluno', enabled: true, email: 'thiago@teste.com', 
			first_name: 'Thiago', last_name: 'Albuquerque', password: '1234', telefone_celular: '(61) 8888-8888',
			telefone_fixo: '(61) 4444-4444', escola_onde_estuda: 'Ideal', serie_cursando: '2 Ensino Médio',
			rg_numero: '2.222.222',cpf:'444.333.222-11', graduado: 1, sexo: 0);
		usuarioUser.save(flush: true);
		
		UsuarioPerfil.create(usuarioUser, usuarioComumPerfil, true);
		
		usuarioUser2 = new Usuario(username: 'aluno2', enabled: true, email: 'leandro@teste.com', 
			first_name: 'Leandro', last_name: 'Coutinho', password: '1234', telefone_celular: '(61) 7777-7777',
			telefone_fixo: '(61) 5555-5555', escola_onde_estuda: 'Marista', serie_cursando: '3 Ensino Médio',
			rg_numero: '3.333.333',cpf:'999.888.777-66', graduado: 1, sexo: 0);
		usuarioUser2.save(flush: true);
		
		UsuarioPerfil.create(usuarioUser2, usuarioComumPerfil, true);
		
		usuarioAndre = new Usuario(username: 'andre', enabled: true, email: 'andre@aulasexpress.com.br',
			first_name: 'André', last_name: 'Sousa', password: '1234', telefone_celular: '(61) 9999-9999',
			telefone_fixo: '(61) 3333-3333', escola_onde_estuda: 'Projeção', serie_cursando: '1 Ensino Médio',
			rg_numero: '1.111.111',cpf:'111.222.333-44', graduado: 1, sexo: 0);
		usuarioAndre.save(flush: true);
		
		UsuarioPerfil.create(usuarioAndre, usuarioComumPerfil, true);
		
		assert Usuario.count() == 6
		assert Perfil.count() == 3
		assert UsuarioPerfil.count() == 6

	}
	
	private void carregaAdministracao(){
		println "Carregando Administracoes..."
		
		def administracao1 = new Administracao(
			raioProfessor:10000,//10 mil metros
			valorAulaGraduado:65.00,
			valorAulaNaoGraduado:40.00).save();
		
		assert Administracao.count() == 1
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
			disciplina:disciplina1,
			latitude:-15.874205,
			longitude:-48.088954,
			endereco:"",
			observacao:"").save();
		
		def aula2 = new Aula(
			cliente:usuarioUser,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:2,
			valorAula:50.00,
			disciplina:disciplina1,
			latitude:-15.86917761,
			longitude:-48.09179306,
			endereco:"",
			observacao:"").save();
		
		def aula3 = new Aula(
			cliente:usuarioUser2,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:2,
			valorAula:50.00,
			disciplina:disciplina2,
			latitude:-15.83612012,
			longitude:-48.08057606,
			endereco:"",
			observacao:"").save();
		
		def aula4 = new Aula(
			cliente:usuarioAndre,
			professor:professorUser,
			data_hora:new Timestamp((new Date()).getTime()),
			status:1,
			quantidade_alunos:1,
			quantidade_horas:2,
			valorAula:50.00,
			disciplina:disciplina3,
			latitude:-15.83612012,
			longitude:-48.08057606,
			endereco:"",
			observacao:"").save();
		
		assert Aula.count() == 4
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
	
	
	
	private void carregaDisponibilidade(){
		println "Carregando Disponibilidades..."
		
		disponibilidade1 = new Disponibilidade(
			ativo:1,
			latitude:-15.86917761,
			longitude:-48.09179306).save();
		
		disponibilidade2 = new Disponibilidade(
			ativo:0,
			latitude:-15.86917761,
			longitude:-48.09179306).save();
		
		assert Disponibilidade.count() == 2
	}
	
	private void carregaExperiencia(){
		println "Carregando Experiencias..."
		
		def experiencia1 = new Experiencia(
			professor:professorUser,
			formacao:"Sistema de Informação",
			empregador_atual:"CentroSoft APPS",
			ocupacao:"Professor",
			postal_code:"72.000-000",
			endereco:"Samambaia",
			cidade:"Samambaia Norte",
			estado:"DF",
			telefone:"(61) 9090-0909",
			apresentacao: "Apresentação do Professor!").save();
		
		def experiencia2 = new Experiencia(
			professor:professorUser2,
			formacao:"Engenharia Automotiva",
			empregador_atual:"Aula Express LTDA",
			ocupacao:"Professor",
			postal_code:"72.000-000",
			endereco:"Aguas Claras",
			cidade:"Aguas Claras",
			estado:"DF",
			telefone:"(61) 9090-0909",
			apresentacao: "Aulas introdutórias, expositivas e aulas de dicas. Possibilidade de se elaborar aulas para demandas específicas.").save();
		
		assert Experiencia.count() == 2
	}
	
	private void carregaHistorico(){
		println "Carregando Historicos..."
		
		def historico1 = new Historico(
			usuario:usuarioUser,
			acao:0,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		def historico2 = new Historico(
			usuario:usuarioUser,
			acao:1,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		def historico3 = new Historico(
			usuario:usuarioAndre,
			acao:2,
			data_hora:new Timestamp((new Date()).getTime())).save();
		
		assert Historico.count() == 3
	}
	
	private void carregarDadosFinaisParaTodosOsAmbientes(){
		//Se for necessario criar dados apos a carga especifica de ambientes
	}
	
	private void carregaDadosDeDesenvolvimento(){
		carregaDisciplinas();
		carregaDisponibilidade();
		criarUsuarios();
		carregaAdministracao();
		carregaAulas();
//		carregaAvaliacao();
		carregaExperiencia();
		carregaHistorico();
	}
}