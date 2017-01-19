package aulas_express

import enums.AcoesHistoricoEnum;
import enums.GraduacaoEnum;
import enums.SeriesEnum;
import enums.SexoEnum;
import enums.StatusAulaEnum;
import enums.TipoAvaliacaoEnum;
import grails.converters.JSON


class ConstantesController {
	
	def acoesHistoricoEnum = {
		def enumJson = []
		AcoesHistoricoEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}
	
	def graduacaoEnum = {
		def enumJson = []
		GraduacaoEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}
	
	def seriesEnum = {
		def enumJson = []
		SeriesEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}
	
	def sexoEnum = {
		def enumJson = []
		SexoEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}
	
	def statusAulaEnum = {
		def enumJson = []
		StatusAulaEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}
	
	def tipoAvaliacaoEnum = {
		def enumJson = []
		TipoAvaliacaoEnum.values().each {enumVal ->
			enumJson.add(["index":enumVal.index, "key":enumVal.key, "desc":enumVal.toString()])
		}
		render enumJson as JSON
	}

}
