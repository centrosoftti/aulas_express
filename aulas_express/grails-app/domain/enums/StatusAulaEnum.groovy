package enums

public enum StatusAulaEnum {
	
	ASL("Solicitada"),
	ALR("Rejeitada"),
	ALA("Aceita"),
	ALC("Cancelada"),
	AGP("Aguardando Pagamento"),
	ALP("Pendente"),
	ALF("Confirmada"),
	ALZ("Realizada"),
	BPF("Buscando Professor");
	
	final String value;
	
	StatusAulaEnum(String value){
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
