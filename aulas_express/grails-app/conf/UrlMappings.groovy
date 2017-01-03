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
		"/usuarios"(resources:'cliente') {
			"/aulas"(resources:"aula")
		}
		
		"/aulas"(controller:"aula", action:"aulasporcliente")
		"/aulas"(controller:"aula", action:"aulasporprofessor")
		
		"/usuarios"(controller:"usuario", action:"professorespordisciplina")
		
		"/usuarios"(resources:'usuario') {
			"/disciplinas"(resources:"disciplina")
		  }
		
		"/usuarios"(controller:"usuario", action:"mylogin")
		
		"/usuarios"(resources:"usuario")
		"/avaliacoes"(resources:'avaliacao')
		"/disciplinas"(resources:'disciplina')
		"/disponibilidades"(resources:'disponibilidade')
		"/experiencias"(resources:'experiencia')
		"/historicos"(resources:'historico')
		
		"/"(view:"/index")
		"500"(view:'/error')
		
		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
	}
}
