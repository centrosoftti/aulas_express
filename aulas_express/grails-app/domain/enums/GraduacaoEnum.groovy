package enums

public enum GraduacaoEnum {
	
	GRD("Graduado"),
	NGR("Não Graduado");
	
	final String value;
	
	GraduacaoEnum(String value){
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
