package br.ifpe.web2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutorizadorInterceptor implements HandlerInterceptor {
	
	private static final String[] RECURSOS_LIVRES = {"/","/logout","/acesso-negado","/efetuarLogin","/paginaInicial"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception {
		
		for (String recurso: RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				System.out.println(recurso +"- TERMINA COM RECURSO.");
				return true;
			}
		}
		
		if (request.getSession().getAttribute("usuarioLogado") == null) {
			System.out.println("USUARIOLOGADO == NULL");
				request.getRequestDispatcher("redirect:/paginaInicial").forward(request, response); // redirecionar para outra p�gina			
			return false;
		} else {
			System.out.println("USUARIOLOGADO DIF NULL");
			return true;
		}
	}
	
}
