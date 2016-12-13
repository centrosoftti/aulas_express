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
		"/aulas"(resources:'aula')
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
