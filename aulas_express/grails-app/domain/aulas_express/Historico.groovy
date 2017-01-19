package aulas_express

import org.example.Usuario
class Historico {

	Usuario usuario
	
	Integer acao

	Date data_hora
	
	String idAula
	
    static constraints = {
		
		usuario(nullable:false)
		acao(nullable:false)
		
		data_hora(nullable:false)
		
		idAula(nullable:true)
    }
}
