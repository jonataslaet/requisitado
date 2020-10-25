package br.com.jonataslaet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	@Autowired
	private RequisitadoApiProperty requisitadoApiProperty;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (requisitadoApiProperty.getOriginPermitida().equalsIgnoreCase(req.getHeader("Origin"))) {
			res.setHeader("Access-Control-Allow-Origin", requisitadoApiProperty.getOriginPermitida());
			res.setHeader("Access-Control-Allow-Headers", "Content-Type");
		}
		chain.doFilter(request, response);
	}

}
