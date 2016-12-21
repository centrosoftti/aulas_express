// Place your Spring DSL code here
beans = {
	localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
		defaultLocale = new Locale("pt", "BR")
		java.util.Locale.setDefault(defaultLocale)
	}
	
//	tokenStorageService(void){
//		doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
//	}
}
