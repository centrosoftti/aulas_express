package aulas_express

class Disponibilidade {

	Integer ativo // 0 - Inativo / 1 - Ativo 
	double latitude
	double longitude
	String cidade
	
    static constraints = {
		
		ativo(nullable:false)
		latitude(nullable:true)
		longitude(nullable:true)
		cidade(nullable:true)
    }
}
