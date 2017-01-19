class UrlMappings {

	static mappings = {
       	"/$controller/rest/$id?"{
			action = [GET:"show", PUT:"update", DELETE:"delete", POST:"save"]
		}
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/administracoes"(resources:'administracao')
		"/administracoes"(controller:"administracao", action:"calcularValorAula")
		
		"/usuarios"(resources:'cliente') {
			"/aulas"(resources:"aula")
		}
		
		"/aulas"(resources:"aula")
		"/aulas"(controller:"aula", action:"aulasporcliente")
		"/aulas"(controller:"aula", action:"aulasporprofessor")
		
		"/usuarios"(controller:"usuario", action:"professorespordisciplina")
		
		"/usuarios"(resources:'usuario') {
			"/disciplinas"(resources:"disciplina")
		  }
		
		"/usuarios"(controller:"usuario", action:"mylogin")
		"/usuarios"(controller:"usuario", action:"disponibilidadeporidprofessor")
		
		"/usuarios"(resources:"usuario")
		"/avaliacoes"(resources:'avaliacao')
		"/disciplinas"(resources:'disciplina')
		"/disponibilidades"(resources:'disponibilidade')
		
		"/experiencias"(resources:'experiencia')
		"/experiencias"(controller:"experiencia", action:"experienciaporprofessor")
		
		"/historicos"(resources:'historico')
		"/historicos"(controller:"historico", action:"historicosporusuario")
		
		"/"(view:"/index")
		"500"(view:'/error')
		
		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
	}
}
