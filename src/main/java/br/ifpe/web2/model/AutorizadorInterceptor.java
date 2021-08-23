package br.ifpe.web2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutorizadorInterceptor implements HandlerInterceptor {
	
	private static final String[] RECURSOS_LIVRES = {"/","/login","/logout","/acesso-negado"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception {
		
		for (String recurso: RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				return true;
			}
		}
		
		if (request.getSession().getAttribute("usuarioLogado") == null) {
		request.getRequestDispatcher("/acesso-negado")
		.forward(request, response); // redirecionar para outra página
			return false;
		} else {
			return true;
		}
	}
}
