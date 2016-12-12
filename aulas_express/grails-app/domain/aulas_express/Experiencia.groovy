package aulas_express

import org.example.Usuario

class Experiencia {

	Usuario professor
	
	String formacao
	String empregador_atual
	String ocupacao
	String postal_code
	String endereco
	String cidade
	String estado
	String telefone
	
    static constraints = {
		professor(nullable:false)
		
		formacao(nullable:true)
		empregador_atual(nullable:true)
		ocupacao(nullable:true)
		postal_code(nullable:true)
		endereco(nullable:true)
		cidade(nullable:true)
		estado(nullable:true)
		telefone(nullable:true)
    }
}
