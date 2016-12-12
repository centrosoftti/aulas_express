package aulas_express

import java.util.Date
import org.example.Usuario

class Aula {
	
	Usuario cliente
	Usuario professor
	
	Date data_hora
	
	Integer status
	Integer quantidade_alunos
	Integer quantidade_horas
	
	double valorAula
	
	String observacao
	
	static constraints = {
		
		//campos obrigatórios
		cliente(nullable:false)
		professor(nullable:true)
		
		status(nullable:false)
		quantidade_alunos(nullable:false)
		quantidade_horas(nullable:false)
		
		valorAula(nullable:false)
		
		//campos não obrigatórios
		observacao(nullable:true)

	}
}