package enums

public enum AcoesHistoricoEnum {

	PGO("Pagamento Efetuado"),
	ALR("Aula Rejeitada"),
	ALA("Aula Aceita"),
	ALS("Aula Solicitada"),
	ALC("Aula Cancelada");
	
	final String value;
	
	AcoesHistoricoEnum(String value){
		this.value = value;
	}
	String toString(){
		value
	}
	String getKey(){
		name()
	}
	String getIndex(){
		ordinal()
	}

}