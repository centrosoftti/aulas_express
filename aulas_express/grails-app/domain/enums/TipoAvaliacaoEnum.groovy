package enums

public enum TipoAvaliacaoEnum {
	
	TPA("Tipo Aluno"),
	TPP("Tipo Professor");
	
	final String value;
	
	TipoAvaliacaoEnum(String value){
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
