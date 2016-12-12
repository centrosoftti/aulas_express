package org.example

import java.util.Date
import aulas_express.Aula
import aulas_express.Disciplina
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	String email
	String first_name
	String last_name
	
	static hasMany = [clienteAulas: Aula, professorAulas: Aula, disciplinas:Disciplina]
	static mappedBy = [clienteAulas: "cliente",
					   professorAulas: "professor"]
	
	String telefone_celular
	String telefone_fixo
	String escola_onde_estuda
	String serie_cursando
	
	String rg_numero
	String cpf
	
	Date data_nascimento
	Date rg_data_expedicao
	
	Integer graduado //0 = não, 1 = sim
	Integer sexo

	Usuario(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Perfil> getAuthorities() {
		UsuarioPerfil.findAllByUsuario(this)*.perfil
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']
	
	static constraints = {
		
		//campos de usuários
		username blank: false, unique: true
		password blank: false
		
		//campos obrigatórios
		email(nullable:false,blank:false)
		first_name(nullable:false,blank:false)
		last_name(nullable:false,blank:false)
		
		//campos não obrigatórios
		telefone_celular(nullable:true)
		telefone_fixo(nullable:true)
		escola_onde_estuda(nullable:true)
		serie_cursando(nullable:true)
		
		rg_numero(nullable:true,unique:true)
		cpf(nullable:true,unique:true)
		
		data_nascimento(nullable:true)
		rg_data_expedicao(nullable:true)
		
		graduado(nullable:true)
		sexo(nullable:true)
	}

	static mapping = {
		password column: '`password`'
	}
}
