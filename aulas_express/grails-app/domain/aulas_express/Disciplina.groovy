package aulas_express

class Disciplina {

    String nome
	
    static constraints = {
		nome(nullable:false,blank:false,unique:true)
    }
}
