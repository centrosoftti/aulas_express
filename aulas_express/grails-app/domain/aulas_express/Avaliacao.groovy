package aulas_express

import org.example.Usuario
class Avaliacao {

	Usuario usuario
	
	Integer tipoAvaliacao
	Integer nota
	
	String observacao
	
    static constraints = {
		
		usuario(nullable:false)
		tipoAvaliacao(nullable:false)
		nota(nullable:false)
		
		observacao(nullable:true)
    }
}
