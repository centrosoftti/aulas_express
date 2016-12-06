import aulas_express.Disciplina

class BootStrap {

	def springSecurityService
	def adminUser
	
    def init = { servletContext ->
		
		println "Bootstrap de dados do BD";
		//Dados gerais previos carregados para todos os ambientes
//		carregarDadosIniciaisParaTodosOsAmbientes();
		 
		
		environments {
			production {
//				carregaDadosDeProducao();
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
		//Se for necessario dados especificos para producao, carregar aqui.
		
	//		carregaDadosDeDesenvolvimento();
//		criarUsuarios();
//		carregaDadosDeCredito();
//		carregaDadosProfissionais();
		
	}
	
	private void carregarDadosFinaisParaTodosOsAmbientes(){
		//Se for necessario criar dados apos a carga especifica de ambientes
	}
	
	private void carregaDadosDeDesenvolvimento(){
//		criarUsuarios();
		
		println "Carregando Disciplinas..."
		
		def disciplina1 = new Disciplina(
			nome:"Matemática").save();
		
		def disciplina2 = new Disciplina(
			nome:"Português").save();
		
		def disciplina3 = new Disciplina(
			nome:"Geografia").save();
		
		def disciplina4 = new Disciplina(
			nome:"História").save();
		
		def disciplina5 = new Disciplina(
			nome:"Física").save();
		
		def disciplina6 = new Disciplina(
			nome:"Química").save();
		
		def disciplina7 = new Disciplina(
			nome:"Inglês").save();
		
		assert Disciplina.count() == 7

	}
}