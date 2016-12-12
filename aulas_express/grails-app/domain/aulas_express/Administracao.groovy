package aulas_express

class Administracao {

	Integer raioProfessor
	double valorAulaGraduado
	double valorAulaNaoGraduado
    
	static constraints = {
		raioProfessor(nullable:false)
		valorAulaGraduado(nullable:false)
		valorAulaNaoGraduado(nullable:false)
    }
}
