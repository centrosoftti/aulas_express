package aulas_express

import org.example.Usuario
class Historico {

	Usuario usuario
	
	Integer acao
	Integer status

	Date data_hora
	
    static constraints = {
		
		usuario(nullable:false)
		acao(nullable:false)
		status(nullable:false)
		
		data_hora(nullable:false)
    }
}
