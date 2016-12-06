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
		"/"(view:"/index")
		"500"(view:'/error')
		
	}
}
