package aulas_express

import org.example.Usuario

class Disponibilidade {

	Usuario professor
	Integer ativo
	double latitude
	double longitude
	
    static constraints = {
		
		professor(nullable:false)
		ativo(nullable:false)
		latitude(nullable:false)
		longitude(nullable:false)
    }
}
