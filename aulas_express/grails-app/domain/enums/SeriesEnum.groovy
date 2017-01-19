package enums

public enum SeriesEnum {
	
	TDS("Todos"),
	FDP("Fundamental I"),
	FDS("Fundamental II"),
	EMP("1º ano do Ensino Médio"),
	EMS("2º ano do Ensino Médio"),
	EMT("3º ano do Ensino Médio");
	
	final String value;
	
	SeriesEnum(String value){
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
