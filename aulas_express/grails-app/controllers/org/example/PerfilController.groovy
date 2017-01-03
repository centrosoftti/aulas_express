package org.example



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PerfilController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Perfil.list(params), model:[perfilInstanceCount: Perfil.count()]
    }

    def show(Perfil perfilInstance) {
        respond perfilInstance
    }

    def create() {
        respond new Perfil(params)
    }

    @Transactional
    def save(Perfil perfilInstance) {
        if (perfilInstance == null) {
            notFound()
            return
        }

        if (perfilInstance.hasErrors()) {
            respond perfilInstance.errors, view:'create'
            return
        }

        perfilInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'perfil.label', default: 'Perfil'), perfilInstance.id])
                redirect perfilInstance
            }
            '*' { respond perfilInstance, [status: CREATED] }
        }
    }

    def edit(Perfil perfilInstance) {
        respond perfilInstance
    }

    @Transactional
    def update(Perfil perfilInstance) {
        if (perfilInstance == null) {
            notFound()
            return
        }

        if (perfilInstance.hasErrors()) {
            respond perfilInstance.errors, view:'edit'
            return
        }

        perfilInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Perfil.label', default: 'Perfil'), perfilInstance.id])
                redirect perfilInstance
            }
            '*'{ respond perfilInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Perfil perfilInstance) {

        if (perfilInstance == null) {
            notFound()
            return
        }

        perfilInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Perfil.label', default: 'Perfil'), perfilInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
